package example.com.thesportsdb.view.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import example.com.thesportsdb.BaseFragment;
import example.com.thesportsdb.R;
import example.com.thesportsdb.adapters.LeaguesAdapter;
import example.com.thesportsdb.adapters.OnItemClickedListener;
import example.com.thesportsdb.util.AnalyticsConstants;
import example.com.thesportsdb.util.AnalyticsUtils;
import example.com.thesportsdb.util.Constants;
import example.com.thesportsdb.util.VerticalSpacingItemDecorator;
import example.com.thesportsdb.util.ViewModelFactory;
import example.com.thesportsdb.viewmodels.LeagueSportFragmentViewModel;

public class LeaguesSportFragment extends BaseFragment implements OnItemClickedListener {

    private LeagueSportFragmentViewModel viewModel;
    private SearchView searchView;
    private RecyclerView recyclerView;
    private LeaguesAdapter adapter;
    private String query = "";

    private static final String TAG = "LeaguesFragment";

    public static LeaguesSportFragment newInstance(String query) {

        Bundle args = new Bundle();
        args.putString(Constants.QUERY, query);

        LeaguesSportFragment fragment = new LeaguesSportFragment();
        fragment.setArguments( args );
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_league_sport, container, false);

        initViews(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );
        viewModel = new ViewModelProvider(this, new ViewModelFactory(getActivity().getApplication())).get( LeagueSportFragmentViewModel.class);
        parentActivity.setTitle(context.getString(R.string.leagues));

        if (getArguments() != null){
            query = getArguments().getString(Constants.QUERY);
        }

        initRecyclerView();
        initSearchView();
        subscribeObservers();

        fetchLeagues(query);
    }

    private void subscribeObservers(){

        viewModel.getLeagues().observe(this, leagues -> {
            if (leagues != null){
                Log.d(TAG, "subscribeObservers: " + leagues.status);

                if (leagues.data != null){

                    switch (leagues.status){

                        case LOADING:
                            parentActivity.showProgressBar(true);
                            break;
                        case SUCCESS:
                            parentActivity.showProgressBar(false);
                            adapter.setLeagues(leagues.data);
                            break;
                        case ERROR:
                            parentActivity.showProgressBar(false);
                            adapter.setLeagues(leagues.data);
                            break;

                    }

                }
            }
        });

    }

    private RequestManager initGlide(){
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.white_background)
                .error(R.drawable.white_background);

        return Glide.with(this).setDefaultRequestOptions(options);
    }

    private void initRecyclerView(){
        adapter = new LeaguesAdapter( this, initGlide());
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(30);
        recyclerView.addItemDecoration(itemDecorator);
        recyclerView.setLayoutManager( new LinearLayoutManager(context) );
        recyclerView.setAdapter(adapter);
    }

    private void initViews(View view){
        searchView = view.findViewById( R.id.leagues_search_view);
        recyclerView = view.findViewById(R.id.leagues_list);
    }

    private void initSearchView(){
        searchView.setOnQueryTextListener( new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchLeagues(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        } );

        searchView.setOnCloseListener( () -> {

            fetchLeagues(query);
            return false;
        } );
    }

    private void fetchLeagues(String query){

        viewModel.fetchLeaguesApi(query);

    }

    private void searchLeagues(String query){
        viewModel.searchLeagues(query);
    }

    @Override
    public void onItemClicked(int position) {
        if (adapter.getSelectedLeague(position) != null){
            String leagueId = adapter.getSelectedLeague(position).getIdLeague();
            //Analytics Tagging
            AnalyticsUtils.analyticsTrackAction(AnalyticsUtils.userData(), AnalyticsConstants.ELEMENT_LIST_ITEM,
                    leagueId, AnalyticsConstants.PAGE_LEAGUE_DETAILS,
                    AnalyticsConstants.PAGE_LEAGUES_BY_SPORT, AnalyticsConstants.ACTION_TAP);
            parentActivity.replaceFragment(LeagueDetailsFragment.newInstance(leagueId));
        }
    }
}

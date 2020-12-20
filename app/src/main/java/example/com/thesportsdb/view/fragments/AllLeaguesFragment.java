package example.com.thesportsdb.view.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import example.com.thesportsdb.BaseFragment;
import example.com.thesportsdb.R;
import example.com.thesportsdb.adapters.OnItemClickedListener;
import example.com.thesportsdb.adapters.SimpleLeaguesAdapter;
import example.com.thesportsdb.util.AnalyticsConstants;
import example.com.thesportsdb.util.AnalyticsUtils;
import example.com.thesportsdb.util.VerticalSpacingItemDecorator;
import example.com.thesportsdb.util.ViewModelFactory;
import example.com.thesportsdb.viewmodels.AllLeaguesFragmentViewModel;

public class AllLeaguesFragment extends BaseFragment implements OnItemClickedListener {

    private AllLeaguesFragmentViewModel viewModel;
    private SearchView searchView;
    private RecyclerView recyclerView;
    private SimpleLeaguesAdapter adapter;

    private static final String TAG = "AllLeaguesFragment";

    public static AllLeaguesFragment newInstance() {

        Bundle args = new Bundle();

        AllLeaguesFragment fragment = new AllLeaguesFragment();
        fragment.setArguments( args );
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate( R.layout.fragment_all_leagues, container, false);
        initViews(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );
        parentActivity.setTitle(context.getString(R.string.leagues));
        viewModel = new ViewModelProvider(this, new ViewModelFactory(getActivity().getApplication())).get(AllLeaguesFragmentViewModel.class);
        initRecyclerView();
        initSearchView();
        subscribeObservers();
        fetchAllLeagues();

    }

    private void initViews(View view){

        searchView = view.findViewById(R.id.leagues_search_view);
        recyclerView = view.findViewById(R.id.leagues_list);
    }

    private void initRecyclerView(){
        adapter = new SimpleLeaguesAdapter(this);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(10);
        recyclerView.addItemDecoration(itemDecorator);
        recyclerView.setLayoutManager( new LinearLayoutManager(context) );
        recyclerView.setAdapter(adapter);
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
            fetchAllLeagues();
            return false;
        } );
    }

    private void fetchAllLeagues(){
        viewModel.fetchLeaguesApi();
    }

    private void searchLeagues(String query){
        viewModel.searchLeagues(query);
    }

    private void subscribeObservers(){
        viewModel.getAllLeagues().observe(this, leagues ->{
            if (leagues != null){

                Log.d( TAG, "subscribeObservers: " + leagues.status );

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

    @Override
    public void onItemClicked(int position) {
        if (adapter.getSelectedLeague(position) != null){
            String leagueId = adapter.getSelectedLeague(position).getIdLeague();

            //Analytics Tagging
            AnalyticsUtils.analyticsTrackAction(AnalyticsUtils.userData(), AnalyticsConstants.ELEMENT_LIST_ITEM,
                    leagueId, AnalyticsConstants.PAGE_LEAGUE_DETAILS,
                    AnalyticsConstants.PAGE_ALL_LEAGUES, AnalyticsConstants.ACTION_TAP);

            parentActivity.replaceFragment(LeagueDetailsFragment.newInstance(leagueId));
        }
    }
}

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
import androidx.recyclerview.widget.SimpleItemAnimator;
import example.com.thesportsdb.BaseFragment;
import example.com.thesportsdb.R;
import example.com.thesportsdb.adapters.OnItemClickedListener;
import example.com.thesportsdb.adapters.SportsAdapter;
import example.com.thesportsdb.util.AnalyticsConstants;
import example.com.thesportsdb.util.AnalyticsUtils;
import example.com.thesportsdb.util.VerticalSpacingItemDecorator;
import example.com.thesportsdb.util.ViewModelFactory;
import example.com.thesportsdb.viewmodels.AllSportFragmentViewModel;

public class AllSportsFragment extends BaseFragment implements OnItemClickedListener {

    private AllSportFragmentViewModel viewModel;
    private SearchView sportSearchView;
    private RecyclerView sportsRecyclerView;
    private SportsAdapter adapter;

    private static final String TAG = "AllSportsFragment";

    public static AllSportsFragment newInstance() {

        Bundle args = new Bundle();

        AllSportsFragment fragment = new AllSportsFragment();
        fragment.setArguments( args );
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate( R.layout.fragment_all_sports, container, false);
        initViews(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );
        parentActivity.setTitle(context.getString(R.string.sports));
        viewModel = new ViewModelProvider(this, new ViewModelFactory(getActivity().getApplication())).get(AllSportFragmentViewModel.class);
        initRecyclerView();
        initSearchView();
        subscribeObservers();
        fetchALLSports();



    }

    private void subscribeObservers(){

        viewModel.getAllSports().observe( this, sports -> {
            if (sports != null){
                Log.d( TAG, "onChanged: " + sports.status);

                if (sports.data != null){

                    switch (sports.status){

                        case LOADING:
                            parentActivity.showProgressBar(true);
                            break;
                        case SUCCESS:
                            parentActivity.showProgressBar(false);
                            adapter.setSports(sports.data);
                            break;
                        case ERROR:
                            parentActivity.showProgressBar(false);
                            adapter.setSports(sports.data);
                            break;

                    }

                }
            }
        } );

    }

    private void initViews(View view){
        sportSearchView = view.findViewById(R.id.sports_search_view);
        sportsRecyclerView = view.findViewById(R.id.sports_list);
    }

    private RequestManager initGlide(){
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.white_background)
                .error(R.drawable.white_background);

        return Glide.with(this).setDefaultRequestOptions(options);
    }

    private void initRecyclerView(){
        adapter = new SportsAdapter( this, initGlide());
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(30);
        sportsRecyclerView.addItemDecoration(itemDecorator);
        sportsRecyclerView.setLayoutManager( new LinearLayoutManager(context) );
        sportsRecyclerView.setAdapter(adapter);
    }

    private void initSearchView(){
        sportSearchView.setOnQueryTextListener( new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchSports(query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        } );

        sportSearchView.setOnCloseListener( () -> {
            fetchALLSports();
            return false;
        } );
    }

    private void fetchALLSports(){
        viewModel.fetchAllSportApi();
    }

    private void searchSports(String query){
        viewModel.searchSports(query);
    }

    @Override
    public void onItemClicked(int position) {
        if (adapter.getSelectedSport(position) != null){

            //Analytics Tagging
            AnalyticsUtils.analyticsTrackAction(AnalyticsUtils.userData(), AnalyticsConstants.ELEMENT_LIST_ITEM,
                    adapter.getSelectedSport(position).getStrSport(), AnalyticsConstants.PAGE_SPORTS,
                    AnalyticsConstants.PAGE_LEAGUES_BY_SPORT, AnalyticsConstants.ACTION_TAP);

            String sportName = adapter.getSelectedSport(position).getStrSport();
            parentActivity.replaceFragment( LeaguesSportFragment.newInstance(sportName));
        }

    }
}

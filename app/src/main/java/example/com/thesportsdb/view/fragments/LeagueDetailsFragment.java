package example.com.thesportsdb.view.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import example.com.thesportsdb.BaseFragment;
import example.com.thesportsdb.R;
import example.com.thesportsdb.adapters.OnItemClickedListener;
import example.com.thesportsdb.adapters.TeamsAdapter;
import example.com.thesportsdb.model.League;
import example.com.thesportsdb.util.AnalyticsConstants;
import example.com.thesportsdb.util.AnalyticsUtils;
import example.com.thesportsdb.util.Constants;
import example.com.thesportsdb.util.VerticalSpacingItemDecorator;
import example.com.thesportsdb.util.ViewModelFactory;
import example.com.thesportsdb.viewmodels.LeagueDetailsFragmentViewModel;

public class LeagueDetailsFragment extends BaseFragment implements OnItemClickedListener {

    private LeagueDetailsFragmentViewModel viewModel;
    private TextView tv_sport_type, tv_league_name, tv_country;
    private ImageView iv_league_badge, iv_internet, iv_facebook, iv_twitter, iv_youtube;
    private RecyclerView rv_teams_list;
    private TeamsAdapter adapter;
    private String leagueId;

    private static final String TAG = "LeagueDetailsFragment";

    public static LeagueDetailsFragment newInstance(String leagueId) {

        Bundle args = new Bundle();
        args.putString(Constants.LEAGUE_ID, leagueId);

        LeagueDetailsFragment fragment = new LeagueDetailsFragment();
        fragment.setArguments( args );
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_league_details, container, false);
        initViews(view);
        if (getArguments() != null)
            leagueId = getArguments().getString(Constants.LEAGUE_ID);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );
        parentActivity.setTitle(context.getString(R.string.league_details));

        viewModel = new ViewModelProvider(this, new ViewModelFactory(getActivity().getApplication())).get(LeagueDetailsFragmentViewModel.class);
        initRecyclerView();
        subscribeObservers();
        searchLeagueById(leagueId);
        fetchTeamsByLeagueId(leagueId);
    }

    private void subscribeObservers(){

        if (leagueId != null){
            viewModel.getLeague().observe(this, league -> {
                if (league != null){
                    Log.d( TAG, "subscribeObservers: " + league.status);

                    if (league.data != null){
                        switch (league.status){

                            case LOADING:
                                parentActivity.showProgressBar(true);
                                break;
                            case SUCCESS:
                                parentActivity.showProgressBar(false);
                                setLeagueProperties(league.data);
                                break;
                            case ERROR:
                                parentActivity.showProgressBar(false);
                                setLeagueProperties(league.data);
                                break;

                        }
                    }
                }
            } );

            viewModel.getTeams().observe(this, teams -> {
                if (teams != null){
                    if (teams.data != null){

                        switch (teams.status){

                            case LOADING:
                                parentActivity.showProgressBar(true);
                                break;
                            case SUCCESS:
                                parentActivity.showProgressBar(false);
                                adapter.setTeams(teams.data);
                                break;
                            case ERROR:
                                parentActivity.showProgressBar(false);
                                adapter.setTeams(teams.data);
                                break;

                        }
                    }
                }
            });
        }
    }

    private void setLeagueProperties(League league){

        if (league != null){
            RequestOptions options = new RequestOptions()
                    .placeholder(R.drawable.white_background)
                    .error(R.drawable.white_background);

            Glide.with(this)
                    .setDefaultRequestOptions(options)
                    .load(league.getStrBadge())
                    .into(iv_league_badge);

            tv_sport_type.setText(league.getStrSport());
            tv_league_name.setText(league.getStrLeague());
            tv_country.setText(league.getStrCountry());

            String urlHeader = "http://";

            if (league.getStrWebsite() != null && !league.getStrWebsite().isEmpty()){
                iv_internet.setVisibility(View.VISIBLE);
                iv_internet.setOnClickListener( view -> {

                    String url = league.getStrWebsite();
                    if (!url.contains(urlHeader))
                        url = urlHeader + url;

                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    context.startActivity(intent);
                } );
            }else {
                iv_internet.setVisibility(View.GONE);
            }

            if (league.getStrFacebook() != null && !league.getStrFacebook().isEmpty()){
                iv_facebook.setVisibility(View.VISIBLE);
                iv_facebook.setOnClickListener( view -> {

                    String url = league.getStrFacebook();
                    if (!url.contains(urlHeader))
                        url = urlHeader + url;
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    context.startActivity(intent);
                } );
            }else {
                iv_facebook.setVisibility(View.GONE);
            }

            if (league.getStrTwitter() != null && !league.getStrTwitter().isEmpty()){
                iv_twitter.setVisibility(View.VISIBLE);
                iv_twitter.setOnClickListener( view -> {

                    String url = league.getStrTwitter();
                    if (!url.contains(urlHeader))
                        url = urlHeader + url;
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                    context.startActivity(intent);
                } );
            }else {
                iv_twitter.setVisibility(View.GONE);
            }

            if (league.getStrYoutube() != null && !league.getStrYoutube().isEmpty()){
                iv_youtube.setVisibility(View.VISIBLE);
                iv_youtube.setOnClickListener( view -> {

                    String url = league.getStrYoutube();
                    if (!url.contains(urlHeader))
                        url = urlHeader + url;
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    context.startActivity(intent);
                } );
            }else {
                iv_youtube.setVisibility(View.GONE);
            }
        }
    }

    private void fetchTeamsByLeagueId(String query){
        viewModel.fetchTeamsByLeagueId(query);
    }

    private void searchLeagueById(String query){
        viewModel.searchLeagueById(query);
    }

    private RequestManager initGlide(){
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.white_background)
                .error(R.drawable.white_background);

        return Glide.with(this).setDefaultRequestOptions(options);
    }

    private void initViews(View view){
        tv_sport_type = view.findViewById(R.id.tv_sport_type);
        tv_league_name = view.findViewById(R.id.tv_league_name);
        tv_country = view.findViewById(R.id.tv_country);
        iv_league_badge = view.findViewById(R.id.iv_league_badge);
        iv_internet = view.findViewById(R.id.iv_internet);
        iv_facebook = view.findViewById(R.id.iv_facebook);
        iv_twitter = view.findViewById(R.id.iv_twitter);
        iv_youtube = view.findViewById(R.id.iv_youtube);
        rv_teams_list = view.findViewById(R.id.rv_teams_list);
    }

    private void initRecyclerView(){
        adapter = new TeamsAdapter(this, initGlide());
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(20);
        rv_teams_list.addItemDecoration(itemDecorator);
        rv_teams_list.setLayoutManager( new LinearLayoutManager(context) );
        rv_teams_list.setAdapter(adapter);
    }

    @Override
    public void onItemClicked(int position) {
        if (adapter.getSelectedTeam(position) != null){
            String teamId = adapter.getSelectedTeam(position).getIdTeam();

            //Analytics Tagging
            AnalyticsUtils.analyticsTrackAction(AnalyticsUtils.userData(), AnalyticsConstants.ELEMENT_LIST_ITEM,
                    teamId, AnalyticsConstants.PAGE_TEAM_DETAILS,
                    AnalyticsConstants.PAGE_LEAGUE_DETAILS, AnalyticsConstants.ACTION_TAP);

            parentActivity.replaceFragment(TeamDetailsFragment.newInstance(teamId));
        }
    }
}

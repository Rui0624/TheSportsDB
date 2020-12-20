package example.com.thesportsdb.view.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import example.com.thesportsdb.BaseFragment;
import example.com.thesportsdb.R;
import example.com.thesportsdb.model.Team;
import example.com.thesportsdb.util.Constants;
import example.com.thesportsdb.util.ViewModelFactory;
import example.com.thesportsdb.viewmodels.TeamDetailsFragmentViewModel;

public class TeamDetailsFragment extends BaseFragment {

    private TextView tv_sport_type, tv_team_name, tv_country, tv_description;
    private ImageView iv_team_badge, iv_internet, iv_facebook, iv_twitter, iv_youtube;
    private TeamDetailsFragmentViewModel viewModel;
    private String teamId;

    private static final String TAG = "TeamDetailsFragment";

    public static TeamDetailsFragment newInstance(String query) {

        Bundle args = new Bundle();
        args.putString( Constants.TEAM_ID, query );

        TeamDetailsFragment fragment = new TeamDetailsFragment();
        fragment.setArguments( args );
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_team_details, container, false);
        initViews(view);

        if (getArguments() != null){
            teamId = getArguments().getString(Constants.TEAM_ID);
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );
        parentActivity.setTitle(context.getString(R.string.team_details));

        viewModel = new ViewModelProvider(this, new ViewModelFactory(getActivity().getApplication())).get(TeamDetailsFragmentViewModel.class);

        subscribeObservers();
        searchTeamByID(teamId);

    }

    private void subscribeObservers(){
        if (teamId != null){
            viewModel.getTeam().observe(this, team ->{
                if (team != null){

                    if (team.data != null){

                        switch (team.status){

                            case LOADING:
                                parentActivity.showProgressBar(true);
                                break;
                            case SUCCESS:
                                parentActivity.showProgressBar(false);
                                setTeamProperties(team.data);
                                break;
                            case ERROR:
                                parentActivity.showProgressBar(false);
                                setTeamProperties(team.data);
                                break;

                        }
                    }

                }
            });
        }
    }

    private void setTeamProperties(Team team){

        if (team != null){
            RequestOptions options = new RequestOptions()
                    .placeholder(R.drawable.white_background)
                    .error(R.drawable.white_background);

            Glide.with(this)
                    .setDefaultRequestOptions(options)
                    .load(team.getStrTeamBadge())
                    .into(iv_team_badge);

            tv_sport_type.setText(team.getStrSport());
            tv_country.setText(team.getStrCountry());
            tv_team_name.setText(team.getStrTeam());
            tv_description.setText(team.getStrDescriptionEN());

            String urlHeader = "http://";

            if (team.getStrWebsite() != null && !team.getStrWebsite().isEmpty()){
                iv_internet.setVisibility(View.VISIBLE);
                iv_internet.setOnClickListener( view -> {

                    String url = team.getStrWebsite();
                    if (!url.contains(urlHeader))
                        url = urlHeader + url;

                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    context.startActivity(intent);
                } );
            }else {
                iv_internet.setVisibility(View.GONE);
            }

            if (team.getStrFacebook() != null && !team.getStrFacebook().isEmpty()){
                iv_facebook.setVisibility(View.VISIBLE);
                iv_facebook.setOnClickListener( view -> {

                    String url = team.getStrFacebook();
                    if (!url.contains(urlHeader))
                        url = urlHeader + url;
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    context.startActivity(intent);
                } );
            }else {
                iv_facebook.setVisibility(View.GONE);
            }

            if (team.getStrTwitter() != null && !team.getStrTwitter().isEmpty()){
                iv_twitter.setVisibility(View.VISIBLE);
                iv_twitter.setOnClickListener( view -> {

                    String url = team.getStrTwitter();
                    if (!url.contains(urlHeader))
                        url = urlHeader + url;
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                    context.startActivity(intent);
                } );
            }else {
                iv_twitter.setVisibility(View.GONE);
            }

            if (team.getStrYoutube() != null && !team.getStrYoutube().isEmpty()){
                iv_youtube.setVisibility(View.VISIBLE);
                iv_youtube.setOnClickListener( view -> {

                    String url = team.getStrYoutube();
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

    private void searchTeamByID(String query){
        viewModel.fetchTeamById(query);
    }

    private void initViews(View view){
        tv_sport_type = view.findViewById(R.id.tv_sport_type);
        tv_team_name = view.findViewById(R.id.tv_team_name);
        tv_country = view.findViewById(R.id.tv_country);
        tv_description = view.findViewById(R.id.tv_description);

        iv_team_badge = view.findViewById(R.id.iv_team_badge);
        iv_internet = view.findViewById(R.id.iv_internet);
        iv_facebook = view.findViewById(R.id.iv_facebook);
        iv_twitter = view.findViewById(R.id.iv_twitter);
        iv_youtube = view.findViewById(R.id.iv_youtube);
    }
}

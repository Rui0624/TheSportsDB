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
import example.com.thesportsdb.model.Player;
import example.com.thesportsdb.util.Constants;
import example.com.thesportsdb.util.ViewModelFactory;
import example.com.thesportsdb.viewmodels.PlayerDetailsFragmentViewModel;

public class PlayerDetailsFragment extends BaseFragment {

    private ImageView iv_player_thumb, iv_internet, iv_facebook, iv_twitter, iv_youtube;
    private TextView tv_sport_type, tv_player_name, tv_team_name, tv_dob, tv_description;
    private String playerId;
    private PlayerDetailsFragmentViewModel viewModel;

    private static final String TAG = "PlayerDetailsFragment";

    public static PlayerDetailsFragment newInstance(String query) {

        Bundle args = new Bundle();
        args.putString( Constants.PLAYER_ID, query );

        PlayerDetailsFragment fragment = new PlayerDetailsFragment();
        fragment.setArguments( args );
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_player_details, container, false);
        initView(view);


        if (getArguments() != null){
            playerId = getArguments().getString(Constants.PLAYER_ID);
        }

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );
        parentActivity.setTitle(context.getString(R.string.player_details));

        viewModel = new ViewModelProvider(this, new ViewModelFactory(getActivity().getApplication())).get(PlayerDetailsFragmentViewModel.class);
        subscribeObservers();
        searchPlayerById(playerId);

    }

    private void subscribeObservers(){

        if (playerId != null){

            viewModel.getPlayer().observe(this, player -> {
                if (player != null){

                    if (player.data != null){

                        switch (player.status){

                            case LOADING:
                                parentActivity.showProgressBar(true);
                                break;
                            case SUCCESS:
                                parentActivity.showProgressBar(false);
                                setPlayerProperties(player.data);
                                break;
                            case ERROR:
                                parentActivity.showProgressBar(false);
                                setPlayerProperties(player.data);
                                break;

                        }

                    }

                }
            });
        }

    }

    private void setPlayerProperties(Player player){

        if (player != null){
            RequestOptions options = new RequestOptions()
                    .placeholder( R.drawable.white_background)
                    .error(R.drawable.white_background);

            Glide.with(this)
                    .setDefaultRequestOptions(options)
                    .load( player.getStrThumb() )
                    .into( iv_player_thumb );

            tv_player_name.setText( player.getStrPlayer() );
            tv_sport_type.setText( player.getStrSport() );
            tv_team_name.setText( player.getStrTeam() );
            tv_dob.setText( player.getDateBorn() );
            tv_description.setText( player.getStrDescriptionEN() );

            String urlHeader = "http://";

            if (player.getStrWebsite() != null && !player.getStrWebsite().isEmpty()){
                iv_internet.setVisibility(View.VISIBLE);
                iv_internet.setOnClickListener( view -> {

                    String url = player.getStrWebsite();
                    if (!url.contains(urlHeader))
                        url = urlHeader + url;

                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    context.startActivity(intent);
                } );
            }else {
                iv_internet.setVisibility(View.GONE);
            }

            if (player.getStrFacebook() != null && !player.getStrFacebook().isEmpty()){
                iv_facebook.setVisibility(View.VISIBLE);
                iv_facebook.setOnClickListener( view -> {

                    String url = player.getStrFacebook();
                    if (!url.contains(urlHeader))
                        url = urlHeader + url;
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    context.startActivity(intent);
                } );
            }else {
                iv_facebook.setVisibility(View.GONE);
            }

            if (player.getStrTwitter() != null && !player.getStrTwitter().isEmpty()){
                iv_twitter.setVisibility(View.VISIBLE);
                iv_twitter.setOnClickListener( view -> {

                    String url = player.getStrTwitter();
                    if (!url.contains(urlHeader))
                        url = urlHeader + url;
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                    context.startActivity(intent);
                } );
            }else {
                iv_twitter.setVisibility(View.GONE);
            }

            if (player.getStrYoutube() != null && !player.getStrYoutube().isEmpty()){
                iv_youtube.setVisibility(View.VISIBLE);
                iv_youtube.setOnClickListener( view -> {

                    String url = player.getStrYoutube();
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

    private void initView(View view){
        tv_sport_type = view.findViewById(R.id.tv_sport_type);
        tv_player_name = view.findViewById(R.id.tv_player_name);
        tv_team_name = view.findViewById(R.id.tv_team_name);
        tv_dob = view.findViewById(R.id.tv_dob);
        tv_description = view.findViewById(R.id.tv_description);

        iv_player_thumb = view.findViewById(R.id.iv_player_thumb );
        iv_internet = view.findViewById(R.id.iv_internet);
        iv_facebook = view.findViewById(R.id.iv_facebook);
        iv_twitter = view.findViewById(R.id.iv_twitter);
        iv_youtube = view.findViewById(R.id.iv_youtube);

    }

    private void searchPlayerById(String playerId){
        viewModel.fetchPlayerById(playerId);
    }
}

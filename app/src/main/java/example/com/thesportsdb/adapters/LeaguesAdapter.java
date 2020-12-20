package example.com.thesportsdb.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import example.com.thesportsdb.R;
import example.com.thesportsdb.model.League;

public class LeaguesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<League> leagues;
    private OnItemClickedListener onItemClickedListener;
    private RequestManager requestManager;

    public LeaguesAdapter(OnItemClickedListener onItemClickedListener, RequestManager requestManager) {
        this.onItemClickedListener = onItemClickedListener;
        this.requestManager = requestManager;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_league_item, parent, false);
        return new LeagueViewHolder(view, onItemClickedListener, requestManager);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((LeagueViewHolder) holder).onBind(leagues.get(position));
    }

    @Override
    public int getItemCount() {

        if (leagues != null)
            return leagues.size();

        return 0;
    }

    public void setLeagues(List<League> leagues){
        this.leagues = leagues;
        notifyDataSetChanged();
    }

    public League getSelectedLeague(int position){
        if (leagues != null){
            if (leagues.size() > 0)
                return leagues.get(position);
        }

        return null;
    }

    private static class LeagueViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView leagueImage;
        TextView leagueText, sportName, leagueGender, leagueCountry;
        OnItemClickedListener onItemClickedListener;
        RequestManager requestManager;

        LeagueViewHolder(@NonNull View itemView, OnItemClickedListener onItemClickedListener, RequestManager requestManager){
            super(itemView);
            this.onItemClickedListener = onItemClickedListener;
            this.requestManager = requestManager;

            leagueImage = itemView.findViewById(R.id.league_image);
            sportName = itemView.findViewById(R.id.sport_name);
            leagueGender = itemView.findViewById(R.id.league_gender);
            leagueCountry = itemView.findViewById(R.id.league_country);
            leagueText = itemView.findViewById(R.id.league_text);

            itemView.setOnClickListener(this);

        }

        private void onBind(League league){
            requestManager.load(league.getStrBadge()).into(leagueImage);
            leagueText.setText(league.getStrLeague());
            sportName.setText(league.getStrSport());
            leagueGender.setText(league.getStrGender());
            leagueCountry.setText(league.getStrCountry());
        }


        @Override
        public void onClick(View view) {
            onItemClickedListener.onItemClicked(getAdapterPosition());
        }
    }
}

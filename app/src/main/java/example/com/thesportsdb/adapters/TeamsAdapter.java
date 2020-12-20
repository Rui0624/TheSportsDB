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
import example.com.thesportsdb.model.Team;

public class TeamsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Team> teams;
    private OnItemClickedListener onItemClickedListener;
    private RequestManager requestManager;

    public TeamsAdapter(OnItemClickedListener onItemClickedListener, RequestManager requestManager){
        this.onItemClickedListener = onItemClickedListener;
        this.requestManager = requestManager;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.layout_team_item, parent, false);
        return new TeamViewHolder(view, onItemClickedListener, requestManager);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((TeamViewHolder) holder).onBind(teams.get(position));
    }

    @Override
    public int getItemCount() {

        if (teams != null)
            return teams.size();
        return 0;
    }

    public void setTeams(List<Team> teams){
        this.teams = teams;
        notifyDataSetChanged();
    }

    public Team getSelectedTeam(int position){
        if (teams != null){
            if (teams.size() > 0)
                return teams.get(position);
        }

        return null;
    }

    private static class TeamViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView iv_team_badge;
        TextView tv_team_name, tv_stadium_location, tv_league_name;
        OnItemClickedListener onItemClickedListener;
        RequestManager requestManager;

        public TeamViewHolder(@NonNull View itemView, OnItemClickedListener onItemClickedListener, RequestManager requestManager) {
            super( itemView );
            this.onItemClickedListener = onItemClickedListener;
            this.requestManager = requestManager;

            iv_team_badge = itemView.findViewById(R.id.iv_team_badge);
            tv_team_name = itemView.findViewById(R.id.tv_team_name);
            tv_stadium_location = itemView.findViewById(R.id.tv_stadium_location );
            tv_league_name = itemView.findViewById(R.id.tv_league_name);

            itemView.setOnClickListener(this);
        }

        private void onBind(Team team){
            requestManager.load(team.getStrTeamBadge()).into(iv_team_badge);
            tv_team_name.setText(team.getStrTeam());
            tv_stadium_location.setText(team.getStrStadiumLocation());
            tv_league_name.setText(team.getStrLeague());

        }

        @Override
        public void onClick(View view) {
            onItemClickedListener.onItemClicked(getAdapterPosition());
        }
    }
}

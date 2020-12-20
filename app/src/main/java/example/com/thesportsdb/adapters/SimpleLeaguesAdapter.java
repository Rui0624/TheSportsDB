package example.com.thesportsdb.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import example.com.thesportsdb.R;
import example.com.thesportsdb.model.League;

public class SimpleLeaguesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<League> leagues;
    private OnItemClickedListener onItemClickedListener;

    public SimpleLeaguesAdapter(OnItemClickedListener onItemClickedListener){
        this.onItemClickedListener = onItemClickedListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.layout_simple_league_item, parent,false);

        return new SimpleLeagueViewHolder(view, onItemClickedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((SimpleLeagueViewHolder) holder).onBind(leagues.get(position));
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

    private static class SimpleLeagueViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView leagueText;
        OnItemClickedListener onItemClickedListener;

        public SimpleLeagueViewHolder(@NonNull View itemView, OnItemClickedListener onItemClickedListener) {
            super(itemView);
            this.onItemClickedListener = onItemClickedListener;

            leagueText = itemView.findViewById(R.id.league_text);

            itemView.setOnClickListener(this);
        }

        private void onBind(League league){
            leagueText.setText(league.getStrLeague());
        }

        @Override
        public void onClick(View view) {
            onItemClickedListener.onItemClicked(getAdapterPosition());
        }
    }
}

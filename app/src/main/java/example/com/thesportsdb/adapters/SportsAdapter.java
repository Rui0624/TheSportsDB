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
import example.com.thesportsdb.model.Sport;

public class SportsAdapter extends RecyclerView.Adapter <RecyclerView.ViewHolder>{

    private List<Sport> sports;
    private OnItemClickedListener onItemClickedListener;
    private RequestManager requestManager;

    public SportsAdapter(OnItemClickedListener onItemClickedListener, RequestManager requestManager){
        this.onItemClickedListener = onItemClickedListener;
        this.requestManager = requestManager;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_sport_item, parent, false);

        return new SportViewHolder(view, onItemClickedListener, requestManager);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((SportViewHolder) holder).onBind(sports.get(position));
    }

    @Override
    public int getItemCount() {

        if (sports != null)
            return sports.size();

        return 0;
    }

    public Sport getSelectedSport(int position){
        if (sports != null){
            if (sports.size() > 0)
                return sports.get(position);
        }

        return null;
    }

    public void setSports(List<Sport> sports) {
        this.sports = sports;
        notifyDataSetChanged();
    }

    private static class SportViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView sportImage;
        TextView sportText, sportFormat;
        OnItemClickedListener onItemClickedListener;
        RequestManager requestManager;

        SportViewHolder(@NonNull View itemView, OnItemClickedListener onItemClickedListener, RequestManager requestManager) {
            super( itemView );

            this.onItemClickedListener = onItemClickedListener;
            this.requestManager = requestManager;

            sportImage = itemView.findViewById(R.id.sport_image);
            sportText = itemView.findViewById(R.id.sport_text);
            sportFormat = itemView.findViewById(R.id.sport_format);

            itemView.setOnClickListener(this);
        }

        private void onBind(Sport sport){
            requestManager.load( sport.getStrSportThumb() ).into(sportImage);
            sportText.setText( sport.getStrSport() );
            sportFormat.setText( sport.getStrFormat() );
        }

        @Override
        public void onClick(View view) {
            onItemClickedListener.onItemClicked(getAdapterPosition());
        }
    }
}

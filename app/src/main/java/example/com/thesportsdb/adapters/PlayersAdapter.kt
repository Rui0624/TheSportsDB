package example.com.thesportsdb.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import example.com.thesportsdb.R
import example.com.thesportsdb.model.Player

class PlayersAdapter(private val onItemClickedListener: OnItemClickedListener
                     , private val requestManager: RequestManager)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var players : List<Player>? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.layout_player_item, parent, false)
        return PlayerViewHolder(view, onItemClickedListener,requestManager)
    }

    override fun getItemCount(): Int {

        if (players != null)
            return players!!.size
        return 0

    }

    public fun setPlayers(players :List<Player>){
        this.players = players
        notifyDataSetChanged()
    }

    public fun getSelectedItem(position: Int): Player? {
        if (players != null){
            if (players!!.isNotEmpty()){
                return players!![position]
            }
        }

        return null
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PlayerViewHolder).onBind(this.players!![position])
    }

    private class PlayerViewHolder(itemView: View
                                   , private val onItemClickedListener: OnItemClickedListener
                                   , private val requestManager: RequestManager)
        : RecyclerView.ViewHolder(itemView), View.OnClickListener{

        private val iv_player_image :ImageView = itemView.findViewById(R.id.iv_player_image)
        private val tv_player_name : TextView = itemView.findViewById(R.id.tv_player_name)
        private val tv_dob : TextView = itemView.findViewById(R.id.tv_dob)
        private val tv_gender : TextView = itemView.findViewById(R.id.tv_gender)
        private val tv_team_name : TextView = itemView.findViewById(R.id.tv_team_name)

        init {
            itemView.setOnClickListener(this)
        }

        public fun onBind(player: Player){
            requestManager.load(player.strThumb).into(iv_player_image)
            tv_player_name.text = player.strPlayer
            tv_dob.text = player.dateBorn
            tv_gender.text = player.strGender
            tv_team_name.text = player.strTeam

        }

        override fun onClick(view: View?) {
            onItemClickedListener.onItemClicked(adapterPosition)
        }

    }

}
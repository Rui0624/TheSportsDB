package example.com.thesportsdb.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import example.com.thesportsdb.BaseFragment
import example.com.thesportsdb.R
import example.com.thesportsdb.adapters.OnItemClickedListener
import example.com.thesportsdb.adapters.PlayersAdapter
import example.com.thesportsdb.model.Player
import example.com.thesportsdb.util.*
import example.com.thesportsdb.viewmodels.SearchPlayerFragmentViewModel

class SearchPlayerFragment : BaseFragment() , OnItemClickedListener{

    private lateinit var sv_search_player: SearchView
    private lateinit var rv_players_list : RecyclerView
    private lateinit var viewModel: SearchPlayerFragmentViewModel
    private lateinit var adapter: PlayersAdapter

    companion object{
        @JvmStatic
        fun newInstance(): SearchPlayerFragment {
            return SearchPlayerFragment();
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.fragment_search_player, container, false)
        init(view)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        parentActivity.title = context.getString(R.string.search_players)

        viewModel = ViewModelProvider(this, ViewModelFactory(activity?.application)).get(SearchPlayerFragmentViewModel ::class.java)
        initRecyclerView()
        initSearchView()
        subscribeObservers()

    }

    private fun subscribeObservers(){
        viewModel.get().observe(this, object : Observer<Resource<List<Player>>> {
            override fun onChanged(players: Resource<List<Player>>?) {
                if (players != null){

                        when(players.status){

                            Resource.Status.LOADING -> parentActivity.showProgressBar(true);

                            Resource.Status.SUCCESS -> {
                                parentActivity.showProgressBar(false);
                                adapter.setPlayers(players.data!!)
                            }

                            Resource.Status.ERROR ->{
                                parentActivity.showProgressBar(false);
                                adapter.setPlayers(players.data!!)
                            }

                        }

                }
            }

        })
    }

    private fun initGlide() : RequestManager{
        val options: RequestOptions = RequestOptions()
                .placeholder(R.drawable.white_background)
                .error(R.drawable.white_background)

        return Glide.with(this).setDefaultRequestOptions(options)
    }

    private fun init(view: View){
        sv_search_player = view.findViewById(R.id.sv_search_player)
        rv_players_list = view.findViewById(R.id.rv_players_list)
    }

    private fun initRecyclerView(){
        adapter = PlayersAdapter(this,initGlide())
        val itemDecorator = VerticalSpacingItemDecorator(30)
        rv_players_list.addItemDecoration(itemDecorator)
        rv_players_list.layoutManager = LinearLayoutManager(context)
        rv_players_list.adapter = adapter
    }

    private fun initSearchView() {
        sv_search_player.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) fetchPlayersByName(query)

                return false
            }
        });

        sv_search_player.setOnCloseListener(object : SearchView.OnCloseListener{
            override fun onClose(): Boolean {
                adapter.setPlayers(ArrayList<Player>())
                return false
            }
        })
    }


    private fun fetchPlayersByName(query: String){
        viewModel.fetchPlayersByName(query)
    }

    override fun onItemClicked(position: Int) {
        if(adapter.getSelectedItem(position) != null){

            val idPlayer : String = adapter.getSelectedItem(position)!!.idPlayer

            AnalyticsUtils.analyticsTrackAction(AnalyticsUtils.userData(), AnalyticsConstants.ELEMENT_LIST_ITEM,
                    idPlayer,AnalyticsConstants.PAGE_PLAYER_DETAILS,
                    AnalyticsConstants.PAGE_SEARCH_PLAYERS, AnalyticsConstants.ACTION_TAP)

            parentActivity.replaceFragment(PlayerDetailsFragment.newInstance(idPlayer));
        }
    }

}
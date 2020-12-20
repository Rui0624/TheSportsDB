package example.com.thesportsdb.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import example.com.thesportsdb.model.Player
import example.com.thesportsdb.repositories.SportDBRepository
import example.com.thesportsdb.util.Resource

class SearchPlayerFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val mSportDBRepository : SportDBRepository = SportDBRepository.getInstance(application)

    private val players : MediatorLiveData<Resource<List<Player>>> = MediatorLiveData<Resource<List<Player>>>()

    public fun get() :MediatorLiveData<Resource<List<Player>>>{
        return players
    }

    fun fetchPlayersByName(query : String){
        val repositorySource : LiveData<Resource<List<Player>>> = mSportDBRepository.searchPlayersByName(query)
        players.addSource(repositorySource) {
            players.value = it
        }
    }

}
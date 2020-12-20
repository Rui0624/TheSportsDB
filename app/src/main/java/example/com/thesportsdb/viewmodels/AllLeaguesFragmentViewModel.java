package example.com.thesportsdb.viewmodels;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import example.com.thesportsdb.model.League;
import example.com.thesportsdb.repositories.SportDBRepository;
import example.com.thesportsdb.util.Resource;

public class AllLeaguesFragmentViewModel extends AndroidViewModel {

    private SportDBRepository mSportDBRepository;
    private MediatorLiveData<Resource<List<League>>> allLeagues = new MediatorLiveData<>();

    public AllLeaguesFragmentViewModel(@NonNull Application application) {
        super( application );
        mSportDBRepository = SportDBRepository.getInstance(application);
    }

    public MediatorLiveData<Resource<List<League>>> getAllLeagues() {
        return allLeagues;
    }

    public void fetchLeaguesApi(){
        //fetch all leagues
        final LiveData<Resource<List<League>>> repositorySource = mSportDBRepository.fetchAllLeagueApi();
        allLeagues.addSource(repositorySource, listResource -> allLeagues.setValue(listResource));

    }

    public void searchLeagues(String query){

        final LiveData<Resource<List<League>>> repositorySource = mSportDBRepository.searchLeague(query);
        allLeagues.addSource(repositorySource, listResource -> allLeagues.setValue(listResource));
    }
}

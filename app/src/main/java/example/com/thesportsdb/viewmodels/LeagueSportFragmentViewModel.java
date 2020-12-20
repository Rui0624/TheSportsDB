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

public class LeagueSportFragmentViewModel extends AndroidViewModel {

    private SportDBRepository mSportDBRepository;
    private MediatorLiveData<Resource<List<League>>> leagues = new MediatorLiveData<>();

    public LeagueSportFragmentViewModel(@NonNull Application application) {
        super( application );
        mSportDBRepository = SportDBRepository.getInstance(application);
    }

    public MediatorLiveData<Resource<List<League>>> getLeagues() {
        return leagues;
    }

    public void fetchLeaguesApi(String query){
        //fetch leagues by country

        final LiveData<Resource<List<League>>> repositorySource = mSportDBRepository.fetchLeagueBySportApi(query);

        leagues.addSource(repositorySource, listResource -> leagues.setValue(listResource));

    }

    public void searchLeagues(String query){
        final LiveData<Resource<List<League>>> repositorySource = mSportDBRepository.searchLeague(query);
        leagues.addSource(repositorySource, listResource -> leagues.setValue(listResource));
    }
}

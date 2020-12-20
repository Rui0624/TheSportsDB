package example.com.thesportsdb.viewmodels;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import example.com.thesportsdb.model.League;
import example.com.thesportsdb.model.Team;
import example.com.thesportsdb.repositories.SportDBRepository;
import example.com.thesportsdb.util.Resource;

public class LeagueDetailsFragmentViewModel extends AndroidViewModel {

    private SportDBRepository mSportDBRepository;
    private MediatorLiveData<Resource<List<Team>>> teams = new MediatorLiveData<>();
    private MediatorLiveData<Resource<League>> league = new MediatorLiveData<>();

    public LeagueDetailsFragmentViewModel(@NonNull Application application) {
        super( application );
        mSportDBRepository = SportDBRepository.getInstance(application);
    }

    public MediatorLiveData<Resource<List<Team>>> getTeams() {
        return teams;
    }

    public MediatorLiveData<Resource<example.com.thesportsdb.model.League>> getLeague() {
        return league;
    }

    public void fetchTeamsByLeagueId(String query){
        final LiveData<Resource<List<Team>>> repositorySource = mSportDBRepository.searchTeamsByLeagueId(query);
        teams.addSource(repositorySource, listResource -> teams.setValue(listResource));
    }

    public void searchLeagueById(String query){
        final LiveData<Resource<League>> repositorySource = mSportDBRepository.searchLeagueById(query);
        league.addSource(repositorySource, leagueResource -> league.setValue(leagueResource));
    }
}

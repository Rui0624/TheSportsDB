package example.com.thesportsdb.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import example.com.thesportsdb.model.Team;
import example.com.thesportsdb.repositories.SportDBRepository;
import example.com.thesportsdb.util.Resource;

public class TeamDetailsFragmentViewModel extends AndroidViewModel {

    private SportDBRepository mSportDBRepository;
    private MediatorLiveData<Resource<Team>> team = new MediatorLiveData<>();

    public TeamDetailsFragmentViewModel(@NonNull Application application) {
        super( application );
        mSportDBRepository = SportDBRepository.getInstance(application);
    }

    public MediatorLiveData<Resource<Team>> getTeam() {
        return team;
    }

    public void fetchTeamById(String query){
        final LiveData<Resource<Team>> repositorySource = mSportDBRepository.searchTeamById(query);
        team.addSource(repositorySource, teamResource -> team.setValue(teamResource));
    }
}

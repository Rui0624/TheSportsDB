package example.com.thesportsdb.viewmodels;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import example.com.thesportsdb.model.Player;
import example.com.thesportsdb.repositories.SportDBRepository;
import example.com.thesportsdb.util.Resource;

public class PlayerDetailsFragmentViewModel extends AndroidViewModel {

    private SportDBRepository mSportDBRepository;
    private MediatorLiveData<Resource<Player>> player = new MediatorLiveData<>();


    public PlayerDetailsFragmentViewModel(@NonNull Application application) {
        super( application );
        mSportDBRepository = SportDBRepository.getInstance(application);
    }

    public MediatorLiveData<Resource<Player>> getPlayer() {
        return player;
    }

    public void fetchPlayerById(String query){
        final LiveData<Resource<Player>> repositorySource = mSportDBRepository.searchPlayerById(query);
        player.addSource(repositorySource, playerSource -> player.setValue( playerSource ));
    }
}

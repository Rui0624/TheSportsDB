package example.com.thesportsdb.viewmodels;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import example.com.thesportsdb.model.League;
import example.com.thesportsdb.model.Player;
import example.com.thesportsdb.repositories.SportDBRepository;
import example.com.thesportsdb.util.Resource;

public class MainViewModel extends AndroidViewModel {

    private SportDBRepository mSportDBRepository;


    public MainViewModel(Application application){
        super(application);
        mSportDBRepository = SportDBRepository.getInstance(application);
    }

}

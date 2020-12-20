package example.com.thesportsdb.viewmodels;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import example.com.thesportsdb.model.Sport;
import example.com.thesportsdb.repositories.SportDBRepository;
import example.com.thesportsdb.util.Resource;

public class AllSportFragmentViewModel extends AndroidViewModel {

    private SportDBRepository mSportDBRepository;
    private MediatorLiveData<Resource<List<Sport>>> allSports = new MediatorLiveData<>();

    public AllSportFragmentViewModel(@NonNull Application application) {
        super( application );
        mSportDBRepository = SportDBRepository.getInstance(application);
    }


    public MediatorLiveData<Resource<List<Sport>>> getAllSports() {
        return allSports;
    }

    public void fetchAllSportApi(){
        final LiveData<Resource<List<Sport>>> repositorySource = mSportDBRepository.fetchAllSportsApi();

        allSports.addSource( repositorySource, listResource -> allSports.setValue(listResource) );
    }

    public void searchSports(String query){
        final LiveData<Resource<List<Sport>>> repositorySource = mSportDBRepository.searchSports(query);

        allSports.addSource( repositorySource, listResource -> allSports.setValue(listResource) );
    }
}

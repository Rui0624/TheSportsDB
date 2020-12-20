package example.com.thesportsdb.util;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import example.com.thesportsdb.view.fragments.SearchPlayerFragment;
import example.com.thesportsdb.viewmodels.AllLeaguesFragmentViewModel;
import example.com.thesportsdb.viewmodels.AllSportFragmentViewModel;
import example.com.thesportsdb.viewmodels.LeagueDetailsFragmentViewModel;
import example.com.thesportsdb.viewmodels.LeagueSportFragmentViewModel;
import example.com.thesportsdb.viewmodels.MainViewModel;
import example.com.thesportsdb.viewmodels.PlayerDetailsFragmentViewModel;
import example.com.thesportsdb.viewmodels.SearchPlayerFragmentViewModel;
import example.com.thesportsdb.viewmodels.TeamDetailsFragmentViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private Application application;

    public ViewModelFactory(Application application){
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass == MainViewModel.class)
            return (T) new MainViewModel(application);
        else if (modelClass == AllSportFragmentViewModel.class)
            return (T) new AllSportFragmentViewModel(application);
        else if (modelClass == LeagueSportFragmentViewModel.class)
            return (T) new LeagueSportFragmentViewModel(application);
        else if (modelClass == AllLeaguesFragmentViewModel.class)
            return (T) new AllLeaguesFragmentViewModel(application);
        else if (modelClass == LeagueDetailsFragmentViewModel.class)
            return (T) new LeagueDetailsFragmentViewModel(application);
        else if (modelClass == TeamDetailsFragmentViewModel.class){
            return (T) new TeamDetailsFragmentViewModel(application);
        }else if (modelClass == SearchPlayerFragmentViewModel.class){
            return (T) new SearchPlayerFragmentViewModel(application);
        }else if (modelClass == PlayerDetailsFragmentViewModel.class){
            return (T) new PlayerDetailsFragmentViewModel(application);
        }

        return super.create(modelClass);
    }
}

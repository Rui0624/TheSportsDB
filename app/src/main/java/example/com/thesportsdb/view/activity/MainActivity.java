package example.com.thesportsdb.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import example.com.thesportsdb.BaseActivity;
import example.com.thesportsdb.R;
import example.com.thesportsdb.util.ViewModelFactory;
import example.com.thesportsdb.view.fragments.AllLeaguesFragment;
import example.com.thesportsdb.view.fragments.AllSportsFragment;
import example.com.thesportsdb.view.fragments.SearchPlayerFragment;
import example.com.thesportsdb.viewmodels.MainViewModel;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private static final String TAG = "MainActivity";
    private MainViewModel viewModel;
    private BottomNavigationView bottomNavigationView;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        viewModel = new ViewModelProvider(this, new ViewModelFactory(this.getApplication())).get( MainViewModel.class);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        replaceFragment( AllSportsFragment.newInstance());
    }

    public void replaceFragment(Fragment fragment){
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        currentFragment = fragment;
        transaction.addToBackStack(null);
        transaction.commit();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.navigation_sport:
                replaceFragment( AllSportsFragment.newInstance() );
                return true;
            case R.id.navigation_league:
                replaceFragment( AllLeaguesFragment.newInstance() );
                return true;
            case R.id.navigation_search:
                replaceFragment(SearchPlayerFragment.newInstance());
                return true;

        }

        return false;
    }

    @Override
    public void onBackPressed() {

        if (currentFragment instanceof AllSportsFragment
                || currentFragment instanceof AllLeaguesFragment
                || currentFragment instanceof SearchPlayerFragment){
            finish();
        }else {
            super.onBackPressed();
        }

    }
}

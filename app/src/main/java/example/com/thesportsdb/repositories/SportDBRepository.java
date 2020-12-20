package example.com.thesportsdb.repositories;

import android.content.Context;
import android.util.Log;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import example.com.thesportsdb.AppExecutors;
import example.com.thesportsdb.db.SportDBDao;
import example.com.thesportsdb.db.SportDataBase;
import example.com.thesportsdb.model.League;
import example.com.thesportsdb.model.Player;
import example.com.thesportsdb.model.Sport;
import example.com.thesportsdb.model.Team;
import example.com.thesportsdb.requests.ServiceGenerator;
import example.com.thesportsdb.requests.responses.ApiResponse;
import example.com.thesportsdb.requests.responses.AllSportsResponse;
import example.com.thesportsdb.requests.responses.LeaguesResponse;
import example.com.thesportsdb.requests.responses.PlayersResponse;
import example.com.thesportsdb.requests.responses.TeamsResponse;
import example.com.thesportsdb.util.NetworkBoundResource;
import example.com.thesportsdb.util.Resource;
import example.com.thesportsdb.util.Testing;

public class SportDBRepository {

    private static SportDBRepository instance;
    private SportDBDao mSportDBDao;

    private static final String TAG = "SportRepository";

    public static SportDBRepository getInstance(Context context){

        if (instance == null){
            instance = new SportDBRepository(context);
        }

        return instance;

    }

    private SportDBRepository(Context context){
        mSportDBDao = SportDataBase.getInstance(context).getSportDBDao();

    }

    public LiveData<Resource<List<Sport>>> fetchAllSportsApi(){

        return new NetworkBoundResource<List<Sport>, AllSportsResponse>(AppExecutors.getInstance()){

            @Override
            protected void saveCallResult(@NonNull AllSportsResponse item) {
                if (item.getSports() != null){

                    Testing.printSports(item.getSports(), "saveCallResult");
                    for(Sport sport : item.getSports()){

                        if (sport != null)
                            mSportDBDao.insertSport(sport);

                    }
                }
            }

            @Override
            protected boolean shouldFetch(@Nullable List<Sport> data) {
                return true;
            }

            @NonNull
            @Override
            protected LiveData<List<Sport>> loadFromDb() {
                return mSportDBDao.getAllSport();
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<AllSportsResponse>> createCall() {
                return ServiceGenerator.getSportDBApi().allSports();
            }
        }.getAsLiveData();
    }

    public LiveData<Resource<List<Sport>>> searchSports(String query){
        return new NetworkBoundResource<List<Sport>, AllSportsResponse>(AppExecutors.getInstance()){

            @Override
            protected void saveCallResult(@NonNull AllSportsResponse item) {

            }

            @Override
            protected boolean shouldFetch(@Nullable List<Sport> data) {
                return false;
            }

            @NonNull
            @Override
            protected LiveData<List<Sport>> loadFromDb() {
                return mSportDBDao.searchSports(query);
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<AllSportsResponse>> createCall() {
                return null;
            }
        }.getAsLiveData();
    }

    public LiveData<Resource<List<League>>> fetchAllLeagueApi(){
        return new NetworkBoundResource<List<League>, LeaguesResponse>(AppExecutors.getInstance()){

            @Override
            protected void saveCallResult(@NonNull LeaguesResponse item) {
                if (item.getLeagues() != null){
                    Testing.printLeague(item.getLeagues(), "saveCallResult");
                    League[] leagues = new League[item.getLeagues().size()];

                    int index = 0;
                    for (long rowId: mSportDBDao.insertLeagues(item.getLeagues().toArray(leagues)))

                        if (rowId == -1){
                            Log.d( TAG, "saveCallResult: CONFLICT...This League is already in the cache" );
                            League currentLeague = leagues[index];

                            mSportDBDao.updateLeague(currentLeague.getIdLeague(), currentLeague.getStrSport(), currentLeague.getStrLeague());
                        }
                    index++;
                }
            }

            @Override
            protected boolean shouldFetch(@Nullable List<League> data) {
                return true;
            }

            @NonNull
            @Override
            protected LiveData<List<League>> loadFromDb() {
                return mSportDBDao.getAllLeagues();
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<LeaguesResponse>> createCall() {
                return ServiceGenerator.getSportDBApi().allLeagues();
            }
        }.getAsLiveData();
    }

    public LiveData<Resource<List<League>>> fetchLeagueBySportApi(String query){
        return new NetworkBoundResource<List<League>, LeaguesResponse>(AppExecutors.getInstance()){

            @Override
            protected void saveCallResult(@NonNull LeaguesResponse item) {
                if (item.getLeagues() != null){
                    Testing.printLeague(item.getLeagues(), "saveCallResult");
                    League[] leagues = new League[item.getLeagues().size()];

                    int index = 0;
                    for (long rowId: mSportDBDao.insertLeagues(item.getLeagues().toArray(leagues)))

                        if (rowId == -1){
                            Log.d( TAG, "saveCallResult: CONFLICT...This League is already in the cache" );
                            League currentLeague = leagues[index];

                            mSportDBDao.updateLeague(currentLeague.getIdLeague(), currentLeague.getStrSport(), currentLeague.getStrLeague(),
                                    currentLeague.getStrLeagueAlternate(), currentLeague.getStrGender(), currentLeague.getStrCountry(),
                                    currentLeague.getStrWebsite(), currentLeague.getStrFacebook(), currentLeague.getStrTwitter(),
                                    currentLeague.getStrYoutube(), currentLeague.getStrDescriptionEN(), currentLeague.getStrBadge());
                        }
                    index++;
                }
            }

            @Override
            protected boolean shouldFetch(@Nullable List<League> data) {
                return true;
            }

            @NonNull
            @Override
            protected LiveData<List<League>> loadFromDb() {
                return mSportDBDao.searchLeagueBySport(query);
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<LeaguesResponse>> createCall() {
                return ServiceGenerator.getSportDBApi().searchLeaguesBySport(query);
            }
        }.getAsLiveData();
    }

    public LiveData<Resource<List<League>>> searchLeague(String query){
        return new NetworkBoundResource<List<League>, LeaguesResponse>(AppExecutors.getInstance()){

            @Override
            protected void saveCallResult(@NonNull LeaguesResponse item) {

            }

            @Override
            protected boolean shouldFetch(@Nullable List<League> data) {
                return false;
            }

            @NonNull
            @Override
            protected LiveData<List<League>> loadFromDb() {
                return mSportDBDao.searchLeague(query);
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<LeaguesResponse>> createCall() {
                return null;
            }
        }.getAsLiveData();
    }

    public LiveData<Resource<League>> searchLeagueById(String query){
        return new NetworkBoundResource<League, LeaguesResponse>(AppExecutors.getInstance()){

            @Override
            protected void saveCallResult(@NonNull LeaguesResponse item) {

            }

            @Override
            protected boolean shouldFetch(@Nullable League data) {
                return false;
            }

            @NonNull
            @Override
            protected LiveData<League> loadFromDb() {
                return mSportDBDao.getLeagueById(query);
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<LeaguesResponse>> createCall() {
                return null;
            }
        }.getAsLiveData();
    }

    public LiveData<Resource<List<League>>> searchLeaguesBySport(String query){
        return new NetworkBoundResource<List<League>, LeaguesResponse>(AppExecutors.getInstance()){

            @Override
            protected void saveCallResult(@NonNull LeaguesResponse item) {

            }

            @Override
            protected boolean shouldFetch(@Nullable List<League> data) {
                return false;
            }

            @NonNull
            @Override
            protected LiveData<List<League>> loadFromDb() {
                return mSportDBDao.searchLeagueBySport(query);
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<LeaguesResponse>> createCall() {
                return null;
            }
        }.getAsLiveData();
    }

    public LiveData<Resource<List<Team>>> searchTeamsByLeagueId(String query){
        return new NetworkBoundResource<List<Team>, TeamsResponse>(AppExecutors.getInstance()){

            @Override
            protected void saveCallResult(@NonNull TeamsResponse item) {
                if (item.getTeams() != null){
                    for (Team team : item.getTeams()){
                        if (team != null)
                            mSportDBDao.insertTeam(team);
                    }
                }
            }

            @Override
            protected boolean shouldFetch(@Nullable List<Team> data) {
                return true;
            }

            @NonNull
            @Override
            protected LiveData<List<Team>> loadFromDb() {
                return mSportDBDao.getTeamsByLeagueId(query);
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<TeamsResponse>> createCall() {
                return ServiceGenerator.getSportDBApi().searchTeamsByLeagueId(query);
            }
        }.getAsLiveData();
    }

    public LiveData<Resource<Team>> searchTeamById(String query){

        return new NetworkBoundResource<Team, TeamsResponse>(AppExecutors.getInstance()){

            @Override
            protected void saveCallResult(@NonNull TeamsResponse item) {

            }

            @Override
            protected boolean shouldFetch(@Nullable Team data) {
                return false;
            }


            @NonNull
            @Override
            protected LiveData<Team> loadFromDb() {
                return mSportDBDao.searchTeamById(query);
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<TeamsResponse>> createCall() {
                return null;
            }
        }.getAsLiveData();

    }

    public LiveData<Resource<List<Player>>> searchPlayersByName(String query){

        return new NetworkBoundResource<List<Player>, PlayersResponse>(AppExecutors.getInstance()){

            @Override
            protected void saveCallResult(@NonNull PlayersResponse item) {
                if (item.getPlayers() != null){
                    for (Player player : item.getPlayers()){
                        if (player != null)
                            mSportDBDao.insertPlayer(player);
                    }
                }
            }

            @Override
            protected boolean shouldFetch(@Nullable List<Player> data) {
                return true;
            }

            @NonNull
            @Override
            protected LiveData<List<Player>> loadFromDb() {
                return mSportDBDao.searchPlayerByName(query);
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<PlayersResponse>> createCall() {
                return ServiceGenerator.getSportDBApi().searchPlayersByName(query);
            }
        }.getAsLiveData();

    }

    public LiveData<Resource<Player>> searchPlayerById(String query){
        return new NetworkBoundResource<Player, PlayersResponse>(AppExecutors.getInstance()){

            @Override
            protected void saveCallResult(@NonNull PlayersResponse item) {
                if (item.getPlayers() != null){
                    for (Player player : item.getPlayers()){
                        if (player != null)
                            mSportDBDao.insertPlayer(player);
                    }
                }
            }

            @Override
            protected boolean shouldFetch(@Nullable Player data) {
                return true;
            }

            @NonNull
            @Override
            protected LiveData<Player> loadFromDb() {
                return mSportDBDao.searchPlayerById(query);
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<PlayersResponse>> createCall() {
                return ServiceGenerator.getSportDBApi().searchPlayerById(query);
            }
        }.getAsLiveData();
    }


}

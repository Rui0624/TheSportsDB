package example.com.thesportsdb.requests;

import java.util.List;

import androidx.lifecycle.LiveData;
import example.com.thesportsdb.requests.responses.ApiResponse;
import example.com.thesportsdb.requests.responses.AllSportsResponse;
import example.com.thesportsdb.requests.responses.LeaguesResponse;
import example.com.thesportsdb.requests.responses.PlayersResponse;
import example.com.thesportsdb.requests.responses.TeamsResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SportDBApi {

    // GET ALL SPORTS
    @GET("api/v1/json/1/all_sports.php")
    LiveData<ApiResponse<AllSportsResponse>> allSports();

    //GET LEAGUES
    @GET("api/v1/json/1/all_leagues.php")
    LiveData<ApiResponse<LeaguesResponse>> allLeagues();

    @GET("api/v1/json/1/search_all_leagues.php")
    LiveData<ApiResponse<LeaguesResponse>> searchLeaguesBySport(
            @Query("s") String sport
    );

    //GET TEAMS BY LEAGUE ID
    @GET("api/v1/json/1/lookup_all_teams.php")
    LiveData<ApiResponse<TeamsResponse>> searchTeamsByLeagueId(
            @Query("id") String idLeague
    );

    //GET PLAYERS BY NAME
    @GET("api/v1/json/1/searchplayers.php")
    LiveData<ApiResponse<PlayersResponse>> searchPlayersByName(
            @Query("p") String playerName
    );

    //GET PLAYER BY ID
    @GET("api/v1/json/1/look_up_player.php")
    LiveData<ApiResponse<PlayersResponse>> searchPlayerById(
            @Query("id") String playerId
    );

}

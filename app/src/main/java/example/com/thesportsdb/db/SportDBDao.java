package example.com.thesportsdb.db;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import example.com.thesportsdb.model.League;
import example.com.thesportsdb.model.Player;
import example.com.thesportsdb.model.Sport;
import example.com.thesportsdb.model.Team;

import static androidx.room.OnConflictStrategy.IGNORE;
import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface SportDBDao {

    /*
     * Sports
     */
    @Insert(onConflict = IGNORE)
    long[] insertSports(Sport... sport);

    @Insert(onConflict = REPLACE)
    void insertSport(Sport sport);

    @Query("UPDATE sports SET sport = :sport, format = :format, sportThumb = :sportThumb, sportThumbGreen = :sportThumbGreen, sportDescription = :sportDescription " +
            "WHERE idSport = :idSport")
    void updateSport(String idSport, String sport, String format, String sportThumb, String sportThumbGreen, String sportDescription);

    @Query("SELECT * FROM sports WHERE idSport = :idSport")
    LiveData<Sport> getSport(String idSport);

    @Query("SELECT * FROM sports")
    LiveData<List<Sport>> getAllSport();

    @Query("SELECT * FROM sports WHERE sport LIKE '%' || :query || '%'")
    LiveData<List<Sport>> searchSports(String query);


    /*
     * Leagues
     */

    @Insert(onConflict = IGNORE)
    long[] insertLeagues(League... league);

    @Insert(onConflict = REPLACE)
    void insertLeague(League league);

    @Query("UPDATE leagues SET sport = :strSport, league = :strLeague, leagueAlternate = :strLeagueAlternate, gender = :strGender, country = :strCountry, website = :strWebsite, facebook = :strFacebook, twitter = :strTwitter, youtube = :strYoutube, description = :strDescriptionEN, badge = :strBadge " +
            "WHERE idLeague = :idLeague")
    void updateLeague(String idLeague, String strSport, String strLeague, String strLeagueAlternate,
                      String strGender, String strCountry, String strWebsite, String strFacebook,
                      String strTwitter, String strYoutube, String strDescriptionEN, String strBadge);

    @Query("UPDATE leagues SET sport = :strSport, league = :strLeague " +
            "WHERE idLeague = :idLeague")
    void updateLeague(String idLeague, String strSport, String strLeague);

    @Query("SELECT * FROM leagues WHERE idLeague = :idLeague")
    LiveData<League> getLeagueById(String idLeague);

    @Query("SELECT * FROM leagues")
    LiveData<List<League>> getAllLeagues();

    @Query("SELECT * FROM leagues WHERE league LIKE '%' || :query || '%' OR country LIKE '%' || :query || '%' OR leagueAlternate LIKE '%' || :query || '%'")
    LiveData<List<League>> searchLeague(String query);

    @Query("SELECT * FROM leagues WHERE sport = :query")
    LiveData<List<League>> searchLeagueBySport(String query);

    /*
     * Teams
     */

    @Insert(onConflict = REPLACE)
    void insertTeam(Team team);

    @Query("UPDATE teams SET team = :strTeam, alternate = :strAlternate, league = :strLeague, idLeague = :idLeague,website = :strWebsite, facebook = :strFacebook, twitter = :strTwitter, instagram = :strInstagram, description = :strDescriptionEN, gender = :strGender, country = :strCountry, youtube = :strYoutube " +
            "WHERE idLeague = :idTeam")
    void updateTeam(String idTeam, String strTeam, String strAlternate, String strLeague, String idLeague,
                    String strWebsite, String strFacebook, String strTwitter,
                    String strInstagram, String strDescriptionEN,
                    String strGender, String strCountry, String strYoutube);

    @Query("SELECT * FROM teams")
    LiveData<List<Team>> getAllTeams();

    @Query("SELECT * FROM teams WHERE idTeam = :idTeam")
    LiveData<Team> searchTeamById(String idTeam);

    @Query("SELECT * FROM teams WHERE idLeague = :idLeague")
    LiveData<List<Team>> getTeamsByLeagueId(String idLeague);

    @Query("SELECT * FROM teams WHERE team LIKE '%' || :query || '%' OR alternate LIKE '%' || :query || '%'")
    LiveData<List<Team>> searchTeamByName(String query);

    /*
     * Players
     */

    @Insert(onConflict = REPLACE)
    void insertPlayer(Player player);

    @Query("UPDATE players SET idTeam = :idTeam, nationality =:strNationality, player = :strPlayer, team = :strTeam, sport = :strSport, dateBorn = :dateBorn," +
            "description = :strDescriptionEN, gender = :strGender, position = :strPosition, faceBook = :strFacebook, website = :strWebsite, twitter = :strTwitter," +
            "instagram = :strInstagram, youtube = :strYoutube, height = :strHeight, weight = :strWeight, thumb = :strThumb " +
            "WHERE idPlayer = :idPlayer")
    void updatePlayer(String idPlayer, String idTeam, String strNationality, String strPlayer,
                      String strTeam, String strSport, String dateBorn, String strDescriptionEN,
                      String strGender, String strPosition, String strFacebook, String strWebsite,
                      String strTwitter, String strInstagram, String strYoutube, String strHeight,
                      String strWeight, String strThumb);

    @Query("SELECT * FROM players")
    LiveData<List<Player>> getAllPlayers();

    @Query("SELECT * FROM players WHERE idTeam = :idTeam")
    LiveData<List<Player>> searchPlayersByTeam(String idTeam);

    @Query("SELECT * FROM players WHERE idPlayer = :idPlayer")
    LiveData<Player> searchPlayerById(String idPlayer);

    @Query("SELECT * FROM players WHERE player LIKE '%' || :playerName || '%'")
    LiveData<List<Player>> searchPlayerByName(String playerName);
}

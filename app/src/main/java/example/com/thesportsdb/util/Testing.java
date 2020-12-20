package example.com.thesportsdb.util;

import android.util.Log;

import java.util.List;

import example.com.thesportsdb.model.League;
import example.com.thesportsdb.model.Sport;
import example.com.thesportsdb.model.Team;

public class Testing {

    public static void printSports(List<Sport> list, String tag){
        for (Sport sport: list){
            Log.d( tag, "printSports: " + sport.getStrSport() );
        }
    }

    public static void printLeague(List<League> list, String tag){
        for (League league: list){
            Log.d( tag, "printSports: " + league.getStrLeague());
        }
    }

    public static void printTeams(List<Team> list, String tag){
        for (Team team : list){
            Log.d( tag, "printTeams: " + team.getIdTeam());
        }
    }

}

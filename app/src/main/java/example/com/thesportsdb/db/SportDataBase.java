package example.com.thesportsdb.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import example.com.thesportsdb.model.League;
import example.com.thesportsdb.model.Player;
import example.com.thesportsdb.model.Sport;
import example.com.thesportsdb.model.Team;

@Database(entities = {Sport.class, League.class, Team.class, Player.class}, version = 1, exportSchema = false)
public abstract class SportDataBase extends RoomDatabase {

    private static final String DATABASE_NAME = "sports_db";

    private static SportDataBase instance;

    public static SportDataBase getInstance(final Context context){

        if (instance == null){

            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    SportDataBase.class,
                    DATABASE_NAME
            ).build();
        }
        return instance;
    }

    public abstract SportDBDao getSportDBDao();

}

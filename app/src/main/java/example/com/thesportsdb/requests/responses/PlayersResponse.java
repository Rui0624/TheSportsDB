package example.com.thesportsdb.requests.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import example.com.thesportsdb.model.Player;

public class PlayersResponse {

    @SerializedName("player")
    List<Player> players;

    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        return "PlayersResponse{" +
                "players=" + players +
                '}';
    }
}

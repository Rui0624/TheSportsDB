package example.com.thesportsdb.requests.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import example.com.thesportsdb.model.League;

public class LeaguesResponse {

    @SerializedName("countrys")
    private List<League> leagues;

    @SerializedName("leagues")
    private List<League> allLeagues;

    public List<League> getLeagues() {
        return leagues;
    }

    @Override
    public String toString() {
        return "LeaguesResponse{" +
                "leagues=" + leagues +
                '}';
    }

    public List<League> getAllLeagues() {
        return allLeagues;
    }
}

package example.com.thesportsdb.requests.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import example.com.thesportsdb.model.Team;

public class TeamsResponse {

    @SerializedName("teams")
    List<Team> teams;

    public List<Team> getTeams() {
        return teams;
    }

    @Override
    public String toString() {
        return "TeamsResponse{" +
                "teams=" + teams +
                '}';
    }
}

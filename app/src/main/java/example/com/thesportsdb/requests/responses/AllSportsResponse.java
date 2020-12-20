package example.com.thesportsdb.requests.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import example.com.thesportsdb.model.Sport;

public class AllSportsResponse {

    @SerializedName("sports")
    private List<Sport> sports;

    public List<Sport> getSports() {
        return sports;
    }

    @Override
    public String toString() {
        return "AllSportsResponse{" +
                "sports=" + sports +
                '}';
    }
}

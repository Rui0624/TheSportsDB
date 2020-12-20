package example.com.thesportsdb.util;

import java.util.HashMap;
import java.util.Map;

public class AnalyticsUtils {

    private static final String TAG = "AnalyticsUtils";

    public static Map<String, Object> userData(){

        Map<String, Object> map = new HashMap<>();

        //implement get user data in the following.....

        return map;
    }

    public static void analyticsTrackAction(Map<String, Object> userData, String elementType, String elementText, String destination, String currentView, String actionType){

        // implement analytics tracking in the following.....

    }
}

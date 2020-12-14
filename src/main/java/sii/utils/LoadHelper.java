package sii.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import sii.model.Sport;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LoadHelper {
    public List<Sport> loadSportList() {
        JSONParser jsonParser = new JSONParser();
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                this.getClass().getResourceAsStream("/objects.json")));

        List<Sport> sports = new ArrayList<>();
        try {
            Object obj = jsonParser.parse(reader);

            JSONArray sportList = (JSONArray) obj;
            System.out.println(sportList);

            for (Object o : sportList) {
                JSONObject jsonObject = (JSONObject) o;
                sports.add(parseSportJson(jsonObject));
            }

            System.out.println("Success parse sport json!");
            return sports;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sports;
    }

    private Sport parseSportJson(JSONObject jsonObject) {
        Sport sport = new Sport();
        sport.setCompetitionYear((long)jsonObject.get("competition_year"));
        sport.setCountry((String)jsonObject.get("country"));
        sport.setMinAge((long)jsonObject.get("min_age"));
        sport.setMinParticipants((long)jsonObject.get("min_participants"));
        sport.setName((String)jsonObject.get("name"));
        sport.setOlympic((boolean)jsonObject.get("olympic"));
        sport.setPopularity((long)jsonObject.get("popularity"));
        return sport;
    }
}

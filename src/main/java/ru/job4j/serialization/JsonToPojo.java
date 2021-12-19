package ru.job4j.serialization;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonToPojo {
    public static void main(String[] args) {
        JSONObject jsonRegion = new JSONObject("{\"region\":\"Central\"}");
        final District msk = new District(new Region("Central"),
                "Moscow Area",
                false,
                8000000,
                new String[]{"Taldom", "Istra", "Ruza"});

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("region", jsonRegion);
        jsonObject.put("name", msk.getName());
        jsonObject.put("republic", msk.isRepublic());
        jsonObject.put("population", msk.getPopulation());
        jsonObject.put("towns", new JSONArray(msk.getTowns()));

        System.out.println(jsonObject.toString());

        System.out.println(new JSONObject(msk).toString());

    }
}

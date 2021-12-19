package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonFormat {
    public static void main(String[] args) {
        final District msk = new District(new Region("Central"),
                "Moscow Area",
                false,
                8000000,
                new String[]{"Taldom", "Istra", "Ruza"});

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(msk));

        final String areaJson =
                "{"
                        + "\"region\":{\"region\":\"Northwest\"},"
                        + "\"name\":\"Leningrad Area\","
                        + "\"republic\":false,"
                        + "\"population\":6000000,"
                        + "\"towns\":[\"Luga\",\"Kirowsk\",\"Roshino\"]"
                        + "}";

        final District districtMod = gson.fromJson(areaJson, District.class);
        System.out.println(districtMod);
    }
}

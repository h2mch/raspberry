package ch.h2m.rp.iboard.bus.control;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.stream.Collectors;

public class Service {


    public List<String> getNextDeparture() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://transport.opendata.ch/v1/stationboard?id=008589841&limit=15")
                .build();

        Response response = client.newCall(request).execute();
        JsonObject body = Json.createReader(new StringReader(response.body().string())).readObject();
        JsonArray stationboard = body.getJsonArray("stationboard");
        List<String> collect = stationboard.stream()
                .filter(jsonValue -> ((JsonObject) jsonValue).getString("to").contains("Luzern"))
                .map(jsonValue -> ((JsonObject) jsonValue).getJsonObject("stop").getString("departure")).collect(Collectors.toList());

        return collect;
    }


}

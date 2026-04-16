package com.srm.hackathon.curahealth.utils;

import com.google.gson.*;
import java.io.FileReader;
import java.io.Reader;

public class JsonReader {

    public static JsonArray getAppointmentData() {
        try {
            Reader reader = new FileReader("src/test/resources/appointmentData.json");
            JsonElement jsonElement = JsonParser.parseReader(reader);
            return jsonElement.getAsJsonArray();
        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON file");
        }
    }
}
package com.srm.hackathon.curahealth.dataproviders;

import org.testng.annotations.DataProvider;
import com.google.gson.JsonArray;
import com.srm.hackathon.curahealth.utils.JsonReader;

public class AppointmentDataProvider {

    @DataProvider(name = "appointmentData")
    public Object[][] getData() {

        JsonArray jsonArray = JsonReader.getAppointmentData();
        Object[][] data = new Object[jsonArray.size()][1];

        for (int i = 0; i < jsonArray.size(); i++) {
            data[i][0] = jsonArray.get(i).getAsJsonObject();
        }

        return data;
    }
}
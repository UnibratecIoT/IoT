package com.example.unibratec.iot.http;

import android.content.Context;

import com.example.unibratec.iot.model.Data;
import com.example.unibratec.iot.model.User;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by mvpires on 01/07/17.
 */

public class DataDeserializer implements JsonDeserializer<Data>{

    Context mContext;

    public DataDeserializer(Context context)
    {
        this.mContext = context;
    }


    @Override
    public Data deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        try {

            JsonObject jsonObject = (JsonObject) json;

            Data data = new Data();
            data.setMyName(jsonObject.get("payload").getAsJsonObject().get("myName").getAsString());
            data.setCpuLoad(jsonObject.get("payload").getAsJsonObject().get("cputemp").getAsFloat());
            data.setCpuTemp(jsonObject.get("payload").getAsJsonObject().get("cpuload").getAsFloat());
            data.setMemoryUsage(jsonObject.get("payload").getAsJsonObject().get("memoryusage").getAsFloat());

            return data;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }

    }
}

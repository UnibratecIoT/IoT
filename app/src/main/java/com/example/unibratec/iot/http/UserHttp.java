package com.example.unibratec.iot.http;

/**
 * Created by mvpires on 01/07/17.
 */

import android.content.Context;

import com.example.unibratec.iot.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by mvpires on 01/07/17.
 */

public class UserHttp {

    public static final String URL_CLOUD = "";

    public User getUserData(Context context) {

        User user = new User();

        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL_CLOUD)
                .build();

        Response response = null;

        try
        {
            response = httpClient.newCall(request).execute();
            String json = response.body().string();
            GsonBuilder gsonBuilder = new GsonBuilder().serializeNulls();
            gsonBuilder.registerTypeAdapter(User.class, new UserDeserializer(context));
            Gson gson = gsonBuilder.create();
            user = gson.fromJson(json, User.class);
            return user;
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }



}




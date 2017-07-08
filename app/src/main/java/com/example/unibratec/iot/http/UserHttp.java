package com.example.unibratec.iot.http;

/**
 * Created by mvpires on 01/07/17.
 */

import android.content.Context;
import android.util.Log;

import com.example.unibratec.iot.model.Data;
import com.example.unibratec.iot.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by mvpires on 01/07/17.
 */

public class UserHttp {

    public static final String URL_CLOUD_BY_ID = "";
    public static final String URL_CLOUD_ALL = "";
    public static final String URL_DATA = "http://iot-pdm.mybluemix.net/bruno";

    public static User getUserData(Context context, String id) {

        User user = new User();

        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL_CLOUD_BY_ID)
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

    public static Data getData(Context context) {

        Data data = new Data();

        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL_DATA)
                .build();

        Response response = null;

        try
        {
            response = httpClient.newCall(request).execute();
            String json = response.body().string();
            Log.d("TESTE", json);
            GsonBuilder gsonBuilder = new GsonBuilder().serializeNulls();
            gsonBuilder.registerTypeAdapter(Data.class, new DataDeserializer(context));
            Gson gson = gsonBuilder.create();
            data = gson.fromJson(json, Data.class);

            Log.d("TESTE", data.getMyName());
            return data;
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public static List<User> getAllUsers(String query)
    {
        List<User> users = new ArrayList<>();

        OkHttpClient okHttpClient = new OkHttpClient();

        String url = String.format(URL_CLOUD_ALL, query);

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = null;

        try
        {
            response = okHttpClient.newCall(request).execute();

            String json = response.body().string();

            JSONObject jsonObject = new JSONObject(json);

            JSONArray jsonArray = jsonObject.getJSONArray("Users");

            String jsonList = jsonArray.toString();

            Gson gson = new Gson();

            User[] usersArray = gson.fromJson(jsonList, User[].class);

            users.addAll(Arrays.asList(usersArray));


        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch (JSONException e) {
            e.printStackTrace();
        }


        return users;
    }



}




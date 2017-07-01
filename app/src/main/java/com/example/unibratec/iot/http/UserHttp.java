package com.example.unibratec.iot.http;

/**
 * Created by mvpires on 01/07/17.
 */

import com.example.unibratec.iot.model.User;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by mvpires on 01/07/17.
 */

public class UserHttp {

    public static final String URL_CLOUD = "";

    public User getUserData() {

        User user = new User();

        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL_CLOUD)
                .build();

        Response response = null;

        try
        {
            response = httpClient.newCall(request).execute();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
        return user;
    }



}




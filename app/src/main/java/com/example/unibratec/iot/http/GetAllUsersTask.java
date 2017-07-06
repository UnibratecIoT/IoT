package com.example.unibratec.iot.http;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.example.unibratec.iot.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mvpires on 06/07/17.
 */

public class GetAllUsersTask extends AsyncTaskLoader<List<User>> {

    List<User> users;
    String query;

    public GetAllUsersTask(Context context, String query)
    {
        super(context);
        this.query = query;
        this.users = new ArrayList<>();

    }

    @Override
    protected void onStartLoading()
    {
        super.onStartLoading();

        if(query != null && (users != null || users.isEmpty()))
        {
            forceLoad();
        }
        else
        {
            deliverResult(users);
        }
    }


    @Override
    public List<User> loadInBackground() {

        users.addAll(UserHttp.getAllUsers(query));
        return users;
    }
}

package com.example.unibratec.iot.http;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.example.unibratec.iot.model.User;

/**
 * Created by mvpires on 01/07/17.
 */

public class GetUserTask extends AsyncTaskLoader<User> {

    User mUser;
    Context mContext;
    String mUserId;

    public GetUserTask(Context context, String userId)
    {
        super(context);
        mContext = context;
        mUserId = userId;

    }

    @Override
    protected void onStartLoading()
    {
        super.onStartLoading();

        if (mUser == null)
        {
            forceLoad();
        }
        else
        {
            deliverResult(mUser);
        }

    }

    @Override
    public User loadInBackground() {

        mUser = UserHttp.getUserData(mContext, mUserId);
        return mUser;
    }
}

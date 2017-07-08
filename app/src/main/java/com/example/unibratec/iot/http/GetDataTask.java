package com.example.unibratec.iot.http;

import android.support.v4.content.AsyncTaskLoader;
import android.content.Context;

import com.example.unibratec.iot.model.Data;
import com.example.unibratec.iot.model.User;

/**
 * Created by mvpires on 01/07/17.
 */

public class GetDataTask extends AsyncTaskLoader<Data> {

    Data mData;
    Context mContext;

    public GetDataTask(Context context)
    {
        super(context);
        mContext = context;

    }

    @Override
    protected void onStartLoading()
    {
        super.onStartLoading();

        if (mData== null)
        {
            forceLoad();
        }
        else
        {
            deliverResult(mData);
        }

    }

    @Override
    public Data loadInBackground() {

        mData = UserHttp.getData(mContext);
        return mData;
    }
}

package com.example.unibratec.iot;

import android.view.View;

import com.example.unibratec.iot.model.Data;

/**
 * Created by mvpires on 07/07/17.
 */

public interface OnDataClickListener {

    void OnDataClick(View view, Data data, int position);
}

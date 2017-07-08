package com.example.unibratec.iot;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.support.v4.content.Loader;
import com.example.unibratec.iot.adapter.UserAdapter;
import com.example.unibratec.iot.http.GetDataTask;
import com.example.unibratec.iot.model.Data;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Data>{

    public static final int LOADER_ID = 0;

    UserAdapter userAdapter;
    List<Data>  dataList;
    LoaderManager loaderManager;
    RecyclerView recyclerView;
    Button updateButton;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        dataList = new ArrayList<>();
        userAdapter = new UserAdapter(this, dataList);

        updateButton = (Button)findViewById(R.id.button);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loaderManager = getSupportLoaderManager();
                loaderManager.initLoader(LOADER_ID, null, MainActivity.this);

            }
        });

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userAdapter);

        loaderManager = getSupportLoaderManager();
        loaderManager.initLoader(LOADER_ID, null, this);

        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series);


    }


    @Override
    public Loader<Data> onCreateLoader(int id, Bundle args) {

        progressBar.setVisibility(View.VISIBLE);
        return new GetDataTask(MainActivity.this);
    }



    @Override
    public void onLoadFinished(Loader<Data> loader, Data data) {


        dataList.clear();

        if(data != null)
        {
            dataList.add(data);
        }

        userAdapter.notifyDataSetChanged();

        progressBar.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onLoaderReset(Loader<Data> loader) {

    }
}

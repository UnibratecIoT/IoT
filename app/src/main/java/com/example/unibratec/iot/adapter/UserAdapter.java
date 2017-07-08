package com.example.unibratec.iot.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.unibratec.iot.OnDataClickListener;
import com.example.unibratec.iot.R;
import com.example.unibratec.iot.model.Data;
import com.example.unibratec.iot.model.User;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by mvpires on 06/07/17.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<Data> dataList;
    private Context context;
    private OnDataClickListener dataClickListener;


    public UserAdapter(Context context, List<Data> dataList)
    {
        this.context = context;
        this.dataList = dataList;
    }

    public void setDataClickListener(OnDataClickListener dataClick)
    {
        this.dataClickListener = dataClick;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.row_user, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Data data = dataList.get(position);

        holder.txtName.setText(data.getMyName());
        holder.txtCpuTemp.setText(String.valueOf(data.getCpuTemp()));
        holder.txtCpuLoad.setText(String.valueOf(data.getCpuLoad()));
        holder.txtMemory.setText(String.valueOf(data.getMemoryUsage()));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView txtName;
        TextView txtCpuLoad;
        TextView txtCpuTemp;
        TextView txtMemory;

        public ViewHolder(View itemView) {
            super(itemView);

            txtName = (TextView)itemView.findViewById(R.id.textUserName);
            txtMemory = (TextView)itemView.findViewById(R.id.textAddress);
            txtCpuLoad = (TextView)itemView.findViewById(R.id.textId);
            txtCpuTemp = (TextView)itemView.findViewById(R.id.textVolume);
        }
    }

}

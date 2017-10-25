package com.gamemobile.sqltest.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.gamemobile.sqltest.Model.Addmore;
import com.gamemobile.sqltest.R;

import java.util.List;

/**
 * Created by hands on 24/10/2017.
 */

public class CustomAdapter extends ArrayAdapter<Addmore>{
    private Context context;
    private int resoure;
    private List<Addmore> listAdd;

    public CustomAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Addmore> objects) {
        super(context, resource, objects);
        this.context= context;
        this.resoure=resource;
        this.listAdd=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.items_list,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.tvId = (TextView)convertView.findViewById(R.id.tv_id);
            viewHolder.tvTen = (TextView)convertView.findViewById(R.id.tv_tenmon);
            viewHolder.tvNguyenlieu = (TextView)convertView.findViewById(R.id.tv_nguyenlieu);
            viewHolder.tvCachlam  = (TextView)convertView.findViewById(R.id.tv_cachlam);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Addmore them = listAdd.get(position);
        viewHolder.tvId.setText(String.valueOf(them.getmID()));
        viewHolder.tvTen.setText(them.getmTen());
        viewHolder.tvNguyenlieu.setText(them.getmNguyenlieu());
        viewHolder.tvCachlam.setText(them.getmCachlam());

        return convertView;
    }
    public class ViewHolder{
        private TextView tvId;
        private TextView tvTen;
        private TextView tvNguyenlieu;
        private TextView tvCachlam;
    }
}

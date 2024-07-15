package com.example.volumecalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> data;
    private ArrayList<Integer>images;
    private LayoutInflater layoutInflater;

    public GridAdapter(Context context, ArrayList<String> data, ArrayList<Integer> images) {
        this.context = context;
        this.data = data;
        this.images = images;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){ // nothing to recycle
            convertView = layoutInflater.inflate(R.layout.grid_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.imageView);
            viewHolder.textView = convertView.findViewById(R.id.textView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.imageView.setImageResource(images.get(position));
        viewHolder.textView.setText(data.get(position));

        return convertView;
    }

    static class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}

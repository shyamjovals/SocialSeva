package com.example.win10.win;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomList extends ArrayAdapter<String> {
    private String[] names;
    private Integer[] imageid;
    private Activity context;

    public CustomList(Activity context, String[] names,  Integer[] imageid) {
        super(context, R.layout.listview_layout, names);
        this.context = context;
        this.names = names;

        this.imageid = imageid;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.listview_layout, null, true);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.txt);

        ImageView image = (ImageView) listViewItem.findViewById(R.id.flag);

        textViewName.setText(names[position]);
        image.setImageResource(imageid[position]);
        return  listViewItem;
    }
}


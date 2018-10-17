package com.onedevz.noct.fragments.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.onedevz.noct.R;

public class gridAdapter extends BaseAdapter {
    Context context;
    String[] names;
    LayoutInflater layoutInflater;

    public gridAdapter(Context context,String[] names) {
        this.context = context;
        this.names = names;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return names[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View gridView = convertView;
        if (convertView == null) {
            layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView = layoutInflater.inflate(R.layout.gridcalendar, parent, false);
        }

        TextView textView = (TextView)gridView.findViewById(R.id.gridtext);
        textView.setText(names[position]);
        return gridView;
    }
}

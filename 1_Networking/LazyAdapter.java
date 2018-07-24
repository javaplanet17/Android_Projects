package com.umamy.alan.umamy.lazyload;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.umamy.alan.umamy.R;

import java.util.ArrayList;

/**
 * Created by alan on 4/16/17.
 */

public class LazyAdapter extends BaseAdapter{
    private Activity activity;
    private ArrayList<String> data;
    private static LayoutInflater inflater=null;
    public ImageLoader imageLoader;

    public LazyAdapter(Activity a, ArrayList<String> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader=new ImageLoader(activity.getApplicationContext());
    }

    public int getCount() {
        Log.d("stuff1","fhjksdkjfb dks fsdkah gkadhjs gjhdsv gkhasd glkadhsg kuds gadshgkasd ljsg kajsg jkldas dasg kljdasgjkdsaka ghdk ghdskj ");
        Log.d("stuff", String.valueOf(data.size()));
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.picturelist, null);

        TextView text=(TextView)vi.findViewById(R.id.text);;
        ImageView image=(ImageView)vi.findViewById(R.id.image);
        text.setText("item "+position);
        imageLoader.DisplayImage(data.get(position), image);
        return vi;
    }
}

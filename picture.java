package com.umamy.alan.umamy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.umamy.alan.umamy.lazyload.LazyAdapter;
import com.umamy.alan.umamy.mappackage.map;
import com.umamy.alan.umamy.webconnect.BackgroundWorker;

import java.util.ArrayList;

/**
 * Created by alan on 4/15/17.
 */

public class picture extends AppCompatActivity {
    Button button;
    ImageView imgview;
    String imgurl = "";
    public ArrayList<String> ar = new ArrayList<>();

    ListView list;
    LazyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.picture);
        //button = (Button)(findViewById(R.id.button1));
        //imgview = (ImageView)(findViewById(R.id.imgview));

        list=(ListView)findViewById(R.id.list);
        String username = "user";
        String password = "pass";
        String type = "login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,username,password);
        ar.add("https://static.pexels.com/photos/110854/pexels-photo-110854.jpeg");
        Log.d("the ar", String.valueOf(ar));
        adapter=new LazyAdapter(this,ar);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new ItemList());
        Button b=(Button)findViewById(R.id.button1);
        b.setOnClickListener(listener);

        /*button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                DownloadTask downloadTask = new DownloadTask();
                downloadTask.execute(imgurl);
            }
        });*/
    }

    class ItemList implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent,View view, int position, long id){
            ViewGroup vg = (ViewGroup)view;
            TextView tv = (TextView)vg.findViewById(R.id.text);
            Toast.makeText(picture.this, tv.getText().toString(), Toast.LENGTH_LONG).show();
            //
            if(position==1){
                Intent i = new Intent(getApplicationContext(),map.class);
                // sending data to next activity, hello is the key and one is the value
                i.putExtra("hello","one");
                startActivity(i);
            }
        }
    }
    @Override
    public void onDestroy()
    {
        list.setAdapter(null);
        super.onDestroy();
    }

    public OnClickListener listener=new OnClickListener(){
        @Override
        public void onClick(View arg0) {
            adapter.imageLoader.clearCache();
            adapter.notifyDataSetChanged();
        }
    };


    private String[] mStrings={
            "https://static.pexels.com/photos/110854/pexels-photo-110854.jpeg",
            "https://cdn.pixabay.com/photo/2011/12/13/14/28/earth-11009_960_720.jpg",
            "https://www.nasa.gov/sites/default/files/thumbnails/image/stsci-h-p1703a-m2000x2000.png",
            "https://pbs.twimg.com/profile_images/913338263/AndroidPolice_logo_normal.png",
            "https://pbs.twimg.com/profile_images/1417650153/android-hug_normal.png",
            "https://pbs.twimg.com/profile_images/1517737798/aam-twitter-right-final_normal.png",
            "https://pbs.twimg.com/profile_images/3319660679/70e7025a05b674852b9f3cea0998259c_normal.jpeg",
            "https://pbs.twimg.com/profile_images/2100693240/58534_150210305010136_148613708503129_315282_6481640_n_normal.jpg",
            "https://pbs.twimg.com/profile_images/1306095935/androidcoo_normal.png",
            "https://pbs.twimg.com/profile_images/2938108229/399ba333772228bfbb40134018fbe777_normal.jpeg",
            "https://pbs.twimg.com/profile_images/487047133392949248/sVTI9rGI_normal.png",
            "https://pbs.twimg.com/profile_images/3092003750/9b72a46e957a52740c667f4c64fa5d10_normal.jpeg",
            "https://pbs.twimg.com/profile_images/2508170683/m8jf0po4imu8t5eemjdd_normal.png",
            "https://pbs.twimg.com/profile_images/1701796334/TA-New-Logo_normal.jpg",
            "https://pbs.twimg.com/profile_images/913338263/AndroidPolice_logo_normal.png",
            "https://pbs.twimg.com/profile_images/1417650153/android-hug_normal.png",
            "https://pbs.twimg.com/profile_images/1517737798/aam-twitter-right-final_normal.png",
            "https://pbs.twimg.com/profile_images/3319660679/70e7025a05b674852b9f3cea0998259c_normal.jpeg",
            "https://pbs.twimg.com/profile_images/2100693240/58534_150210305010136_148613708503129_315282_6481640_n_normal.jpg",
            "https://pbs.twimg.com/profile_images/1306095935/androidcoo_normal.png",
            "https://pbs.twimg.com/profile_images/2938108229/399ba333772228bfbb40134018fbe777_normal.jpeg",
            "https://pbs.twimg.com/profile_images/487047133392949248/sVTI9rGI_normal.png","https://pbs.twimg.com/profile_images/3092003750/9b72a46e957a52740c667f4c64fa5d10_normal.jpeg",
            "https://pbs.twimg.com/profile_images/2508170683/m8jf0po4imu8t5eemjdd_normal.png",
            "https://pbs.twimg.com/profile_images/1701796334/TA-New-Logo_normal.jpg",
            "https://pbs.twimg.com/profile_images/913338263/AndroidPolice_logo_normal.png",
            "https://pbs.twimg.com/profile_images/1417650153/android-hug_normal.png",
            "https://pbs.twimg.com/profile_images/1517737798/aam-twitter-right-final_normal.png",
            "https://pbs.twimg.com/profile_images/3319660679/70e7025a05b674852b9f3cea0998259c_normal.jpeg",
            "https://pbs.twimg.com/profile_images/2100693240/58534_150210305010136_148613708503129_315282_6481640_n_normal.jpg",
            "https://pbs.twimg.com/profile_images/1306095935/androidcoo_normal.png",
            "https://pbs.twimg.com/profile_images/2938108229/399ba333772228bfbb40134018fbe777_normal.jpeg",
            "https://pbs.twimg.com/profile_images/487047133392949248/sVTI9rGI_normal.png","https://pbs.twimg.com/profile_images/3092003750/9b72a46e957a52740c667f4c64fa5d10_normal.jpeg",
            "https://pbs.twimg.com/profile_images/2508170683/m8jf0po4imu8t5eemjdd_normal.png",
            "https://pbs.twimg.com/profile_images/1701796334/TA-New-Logo_normal.jpg",
            "https://pbs.twimg.com/profile_images/913338263/AndroidPolice_logo_normal.png",
            "https://pbs.twimg.com/profile_images/1417650153/android-hug_normal.png",
            "https://pbs.twimg.com/profile_images/1517737798/aam-twitter-right-final_normal.png",
            "https://pbs.twimg.com/profile_images/3319660679/70e7025a05b674852b9f3cea0998259c_normal.jpeg",
            "https://pbs.twimg.com/profile_images/2100693240/58534_150210305010136_148613708503129_315282_6481640_n_normal.jpg",
            "https://pbs.twimg.com/profile_images/1306095935/androidcoo_normal.png",
            "https://pbs.twimg.com/profile_images/2938108229/399ba333772228bfbb40134018fbe777_normal.jpeg",
            "https://pbs.twimg.com/profile_images/487047133392949248/sVTI9rGI_normal.png","https://pbs.twimg.com/profile_images/3092003750/9b72a46e957a52740c667f4c64fa5d10_normal.jpeg",
            "https://pbs.twimg.com/profile_images/2508170683/m8jf0po4imu8t5eemjdd_normal.png",
            "https://pbs.twimg.com/profile_images/1701796334/TA-New-Logo_normal.jpg",
            "https://pbs.twimg.com/profile_images/913338263/AndroidPolice_logo_normal.png",
            "https://pbs.twimg.com/profile_images/1417650153/android-hug_normal.png",
            "https://pbs.twimg.com/profile_images/1517737798/aam-twitter-right-final_normal.png",
            "https://pbs.twimg.com/profile_images/3319660679/70e7025a05b674852b9f3cea0998259c_normal.jpeg",
            "https://pbs.twimg.com/profile_images/2100693240/58534_150210305010136_148613708503129_315282_6481640_n_normal.jpg",
            "https://pbs.twimg.com/profile_images/1306095935/androidcoo_normal.png",
            "https://pbs.twimg.com/profile_images/2938108229/399ba333772228bfbb40134018fbe777_normal.jpeg",
            "https://pbs.twimg.com/profile_images/487047133392949248/sVTI9rGI_normal.png"
    };

}





/*
class DownloadTask extends AsyncTask<String,Integer,String>{

    ProgressDialog progressDialog;
    @Override
    protected void onPreExecute(){
        super.onPreExecute();
        progressDialog = new ProgressDialog(picture.this);
        progressDialog.setTitle("Download in progress");
        progressDialog.setProgressStyle(progressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(100);
        progressDialog.setProgress(0);
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... params) {
        String path = params[0];
        int file_length = 0;
        try {
            URL url = new URL(path);
            URLConnection urlconnection = url.openConnection();
            urlconnection.connect();
            file_length = urlconnection.getContentLength();
            File newfolder = new File("sdcard/photoalbum");
            if(!newfolder.exists()){
                newfolder.mkdir();
            }
            File inputfile = new File(newfolder,"photo1.jpg");
            InputStream inputstream = new BufferedInputStream(url.openStream(),8192);
            byte[] data = new byte[1024];
            int total = 0;
            int count = 0;
            OutputStream outputstream = new FileOutputStream(newfolder);
            while ((count=inputstream.read(data) )!=1){
                total+= count;
                outputstream.write(data,0,count);
                int progress = total*100/file_length;
                publishProgress(progress);
            }
            inputstream.close();
            outputstream.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "download completed";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        progressDialog.setProgress(0);
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        progressDialog.hide();

        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
        String path = "sdcard/photoalbum/photo1.jpg";

        super.onPostExecute(result);
    }

}*/
package com.onedevz.noct;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.GridView;

import com.onedevz.noct.fragments.adapters.gridAdapter;


public class MainActivity extends AppCompatActivity {


    String[] Names = {"great","good","average","great","good","average","great","good","average","great","good","average","great","good","average","great","good","average"};
    String[] days = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
    GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid = (GridView)findViewById(R.id.firstList);

        gridAdapter adapter = new gridAdapter(this,days);
        grid.setAdapter(adapter);

    }

}

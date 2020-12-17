package com.example.administrator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TabHost;
import android.widget.TextView;




public class RecommendActivity extends AppCompatActivity {
    FrameLayout frameLayout;

    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        frameLayout = findViewById(R.id.framelayout);
        textView = findViewById(R.id.textview);
        /*textView.setText("Home");*/
        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();
        LayoutInflater inflater = LayoutInflater.from(this);
        inflater.inflate(R.layout.activity_hospital,tabHost.getTabContentView());
        inflater.inflate(R.layout.activity_office,tabHost.getTabContentView());
        inflater.inflate(R.layout.activity_yisheng,tabHost.getTabContentView());
        tabHost.addTab(tabHost.newTabSpec("active_hospital").setIndicator("医院简介").setContent(R.id.one));
        tabHost.addTab(tabHost.newTabSpec("active_office").setIndicator("科室简介").setContent(R.id.two));
        tabHost.addTab(tabHost.newTabSpec("active_yisheng").setIndicator("名医简介").setContent(R.id.three));


    }

}


package com.example.administrator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class XuzhiActivity extends AppCompatActivity {
    TextView bottom_bar_myinfo_btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xuzhi);
        bottom_bar_myinfo_btn2 = (TextView) findViewById(R.id.btn_next);
        bottom_bar_myinfo_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(XuzhiActivity.this,NumberActivity.class);
                startActivity(intent);
            }
        });
    }
}

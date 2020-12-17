package com.example.administrator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class PersonActivity extends AppCompatActivity {
    private TextView btn_number,btn_number1,jiaofei;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);


        btn_number=findViewById(R.id.xiugai);
        btn_number1=findViewById(R.id.tuichu);
        jiaofei=findViewById(R.id.jiaofei);


        btn_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PersonActivity.this,XiugaiActivity.class);
                startActivity(intent);
            }
        });
        btn_number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PersonActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        jiaofei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PersonActivity.this,PatientActivity.class);
                startActivity(intent);
            }
        });
    }
}

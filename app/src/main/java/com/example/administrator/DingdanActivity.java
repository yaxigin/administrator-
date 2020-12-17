package com.example.administrator;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DingdanActivity extends AppCompatActivity implements
        View.OnClickListener {
    MyHelper myHelper;

    private TextView mTvShow;

    private Button mBtnQuery;
    Date date = new Date();//获取当前的日期
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    String dat = df.format(date);//获取String类型的时间
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dingdan);
        myHelper = new MyHelper(this);
        init();//初始化控件

    }
    private void init() {

        mTvShow = (TextView) findViewById(R.id.tv_show);

        mBtnQuery = (Button) findViewById(R.id.btn_query);

        mBtnQuery.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {

        SQLiteDatabase db;
        ContentValues values;



        switch (v.getId()) {

            case R.id.btn_query: //查询数据
                db = myHelper.getReadableDatabase();
                Cursor cursor = db.query("information", null, null, null, null,
                        null, null);
                if (cursor.getCount() == 0) {
                    mTvShow.setText("");
                    Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
                } else {
                    cursor.moveToFirst();
                    mTvShow.setText("订单编号 :  " + cursor.getString(1) +
                            "  \n姓名 :  " + cursor.getString(2) +
                            "  \n证件号:  " + cursor.getString(4)+
                            "  \n科室 :  " + cursor.getString(5)+
                            "  \n医生:  " + cursor.getString(6)+
                            "  \n查询时间:  " + dat);
                }
                while (cursor.moveToNext()) {
                    mTvShow.append("\n\n订单编号 :  " + cursor.getString(1) +
                            "  \n姓名 :  " + cursor.getString(2) +
                            "  \n证件号:  " + cursor.getString(4)+
                            "  \n科室 :  " + cursor.getString(5)+
                            "  \n医生:  " + cursor.getString(6)+
                            "  \n查询时间:  " + dat);
                }
                cursor.close();
                db.close();
                break;

        }
    }



    class MyHelper extends SQLiteOpenHelper {
        public MyHelper(Context context) {
            super(context, "guahaotest.db", null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE information(_id INTEGER PRIMARY KEY AUTOINCREMENT, id VARCHAR(20), name VARCHAR(20),  phone VARCHAR(20),phone1 VARCHAR(20),phone2 VARCHAR(20),phone3 VARCHAR(20),phone4 VARCHAR(20))");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }
}

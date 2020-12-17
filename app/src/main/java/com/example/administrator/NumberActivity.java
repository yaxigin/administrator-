package com.example.administrator;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NumberActivity extends AppCompatActivity implements
        View.OnClickListener {
    MyHelper myHelper;
    private EditText mEtName;
    private EditText mEtPhone;
    private EditText mEtPhone1;
    private EditText mEtPhone2;
    private EditText mEtPhone3;
    private EditText mEtPhone4;



    Date date = new Date();//获取当前的日期
    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
    String id = df.format(date);//获取String类型的时间
    private Button mBtnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
        myHelper = new MyHelper(this);
        init();//初始化控件
    }
    private void init() {
        mEtName = (EditText) findViewById(R.id.et_name);
        mEtPhone = (EditText) findViewById(R.id.et_phone);
        mEtPhone1 = (EditText) findViewById(R.id.et_phone1);
        mEtPhone2 = (EditText) findViewById(R.id.et_phone2);
        mEtPhone3 = (EditText) findViewById(R.id.et_phone3);
        mEtPhone4 = (EditText) findViewById(R.id.et_phone4);


        mBtnAdd = (Button) findViewById(R.id.btn_add);

        mBtnAdd.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        String name;
        String phone;
        String phone1;
        String phone2;
        String phone3;
        String phone4;
        SQLiteDatabase db;
        ContentValues values;



        switch (v.getId()) {
            case R.id.btn_add: //添加数据
                name = mEtName.getText().toString();
                phone = mEtPhone.getText().toString();
                phone1 = mEtPhone1.getText().toString();
                phone2 = mEtPhone2.getText().toString();
                phone3 = mEtPhone3.getText().toString();
                phone4 = mEtPhone4.getText().toString();

                db = myHelper.getWritableDatabase();//获取可读写SQLiteDatabse对象
                values = new ContentValues();       // 创建ContentValues对象
                values.put("id",id); // 将数据添加到ContentValues对象
                values.put("name", name);
                values.put("phone", phone);
                values.put("phone1", phone1);
                values.put("phone2", phone2);
                values.put("phone3", phone3);
                values.put("phone4", phone4);


                db.insert("information", null, values);
                Toast.makeText(this, "挂号提交成功，请到订单中查看！", Toast.LENGTH_SHORT).show();
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

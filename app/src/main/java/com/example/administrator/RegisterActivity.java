package com.example.administrator;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText username;
    EditText password;
//    EditText age;
//    EditText sex;
    Button register1;
    private Button register2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findViews();
        register1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name=username.getText().toString().trim();
                String pass=password.getText().toString().trim();
//                String agestr=age.getText().toString().trim();
//                String sexstr=sex.getText().toString().trim();
                register2=(Button) findViewById(R.id.Login);
                Log.i("TAG",name+"_"+pass);

                UserService uService=new UserService(RegisterActivity.this);
                User user=new User();
                user.setUsername(name);
                user.setPassword(pass);
//                user.setAge(Integer.parseInt(agestr));
//                user.setSex(sexstr);
                uService.register(user);
                Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_LONG).show();
            }
        });
        register2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    private void findViews() {
        username=(EditText) findViewById(R.id.usernameRegister);
        password=(EditText) findViewById(R.id.passwordRegister);
//        age=(EditText) findViewById(R.id.ageRegister);
//        sex=(EditText) findViewById(R.id.sexRegister);
        register1=(Button) findViewById(R.id.Register);
        register2=(Button) findViewById(R.id.Login);
    }

}



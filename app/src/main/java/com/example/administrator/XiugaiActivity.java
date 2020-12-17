package com.example.administrator;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class XiugaiActivity extends AppCompatActivity {

    EditText username;
    EditText password;

    Button register;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiugai);
        findViews();
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name=username.getText().toString().trim();
                String pass=password.getText().toString().trim();


                Log.i("TAG",name+"_"+pass);

                UserService uService=new UserService(XiugaiActivity.this);
                User user=new User();
                user.setUsername(name);
                user.setPassword(pass);

                uService.register(user);
                Toast.makeText(XiugaiActivity.this, "修改成功", Toast.LENGTH_LONG).show();
            }
        });
    }
    private void findViews() {
        username=(EditText) findViewById(R.id.usernameRegister);
        password=(EditText) findViewById(R.id.passwordRegister);

        register=(Button) findViewById(R.id.Register);
    }

}



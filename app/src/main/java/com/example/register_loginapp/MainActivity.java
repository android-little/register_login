package com.example.register_loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.register_loginapp.db.Data;

import org.litepal.LitePal;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private  Integer flag=0;
    private Button zhuce;
    private Button denglu;
    private EditText password;
    private EditText user_name;
    private CheckBox rembpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        denglu=(Button)findViewById(R.id.denglu);
        password=(EditText) findViewById(R.id.password);
        user_name=(EditText)findViewById(R.id.user_name);
        rembpassword=(CheckBox)findViewById(R.id.rembpassword);
        zhuce = findViewById(R.id.zhuce);

        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameinput = user_name.getText().toString().trim();
                String pwdinput = password.getText().toString().trim();
                List<Data> datas = LitePal.where("name = ? and mima = ?", nameinput, pwdinput).find(Data.class);
                if (datas.size() > 0) {
                    for (Data data : datas) {
                        Log.d("MainActivity", "ID=" + data.getName());
                        Log.d("MainActivity", "mima=" + data.getMima());
                        if (data.getName().equals(nameidinput) && data.getMima().equals(pwdinput))
                            flag = 1;
                    }
                }
                if (flag == 1) {
                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "登录失败，用户名或密码错误，请重新输入", Toast.LENGTH_SHORT).show();
                }
            }
        });

        class OnClick implements View.OnClickListener {

            @Override
            public void onClick(View view) {
                Intent intent;
                switch (view.getId()) {
                    case R.id.zhuce:
                        intent = new Intent(MainActivity.this, register.class);
                        startActivity(intent);
                        break;
                }
            }
        }
    }
}

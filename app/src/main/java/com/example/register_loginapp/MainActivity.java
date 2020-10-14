package com.example.register_loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
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
       // zhuce=findViewById(R.id.zhuc);
        //zhuce.setOnClickListener(new OnClick());

        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameinput = user_name.getText().toString().trim();
                String pwdinput = password.getText().toString().trim();
                List<Data> datas = LitePal.where("name = ? and mima = ?", nameinput, pwdinput).find(Data.class);
                if (datas.size() > 0) {
                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, "登录失败，用户名或密码错误，请重新输入", Toast.LENGTH_SHORT).show();
                }
            }
        });
<<<<<<< HEAD
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, register.class);

                startActivity(intent);

            }
        });
=======
        ((Button) findViewById(R.id.zhuc))
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this,
                                register.class);
                        startActivity(intent);
                    }
                });

>>>>>>> cs2


    }
}

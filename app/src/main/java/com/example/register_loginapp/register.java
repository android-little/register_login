package com.example.register_loginapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.register_loginapp.db.Data;

import org.litepal.LitePal;

import java.util.List;

public class register extends AppCompatActivity {

    String idinput,f_pwdinput,s_pwdinput;
    private EditText number;//账号
    private EditText f_pass;//第一次密码
    private EditText s_pass;//第二密码
    private Button right_zhuce;//立即注册
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.register);
        number=(EditText)findViewById(R.id.number);
        f_pass=(EditText)findViewById(R.id.f_pass);
        s_pass=(EditText)findViewById(R.id.s_pass);
        right_zhuce=(Button) findViewById(R.id.right_zhuce);
        right_zhuce.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                    idinput=number.getText().toString().trim();
                     f_pwdinput=f_pass.getText().toString().trim();
                    s_pwdinput=s_pass.getText().toString().trim();
                    boolean exist=LitePal.isExist(Data.class,"name = ?",idinput);
                    if(exist){
                        Toast.makeText(register.this,"用户已存在，不能重复注册，请重新输入",Toast.LENGTH_SHORT).show();
                    }else{
                        Data newdata=new Data();
                        newdata.setName(idinput);
                        newdata.setMima(f_pwdinput);
                        if(f_pwdinput.equals(s_pwdinput)) {
                            boolean flag = newdata.save();
                            Log.d("MainActivity", "flag=" + flag);
                            if (flag) {

                                Toast.makeText(register.this, "注册成功", Toast.LENGTH_SHORT).show();
                            } else
                                Toast.makeText(register.this, "注册失败", Toast.LENGTH_SHORT).show();
                        }
                        else Toast.makeText(register.this, "密码不一致", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

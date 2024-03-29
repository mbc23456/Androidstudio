package com.example.myapplication.activity;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.content.SharedPreferences;

import android.os.Bundle;

import android.text.TextUtils;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import android.widget.TextView;

import android.widget.Toast;



import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import com.example.myapplication.utils.MD5Utils;


public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Object StatusUtils;


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_login);







        initView();  // 初始化界面控件

        initData();  // 初始化传入的数据

    }



    private void initData() {

        Intent intent = getIntent();

        String username = intent.getStringExtra("username");

        if (!TextUtils.isEmpty(username)) {

            etUsername.setText(username);

        }

    }



    @SuppressLint("WrongViewCast")
    private void initView() {

        etUsername = findViewById(R.id.tv_username);

        etPassword = findViewById(R.id.tv_username);



        TextView tvRegister = findViewById(R.id.tv_register);

        tvRegister.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);

                startActivityForResult(intent, 1);

            }

        });



        Button btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                login();



            }

        });

    }



    private void login() {

        String username = etUsername.getText().toString();

        String password = etPassword.getText().toString();

        password = MD5Utils.md5(password);

        String spPwd = readPwd(username);



        if (TextUtils.isEmpty(username)) {

            Toast.makeText(LoginActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();

        } else if (TextUtils.isEmpty(password)) {

            Toast.makeText(LoginActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();

        } else if (TextUtils.isEmpty(spPwd)) {

            Toast.makeText(LoginActivity.this, "请先注册", Toast.LENGTH_SHORT).show();

        } else if (!spPwd.equals(password)) {

            Toast.makeText(LoginActivity.this, "输入的密码不正确", Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();

            saveLoginStatus(username, true);



            // 返回到我的界面

            Intent intent = new Intent();

            intent.putExtra("isLogin", true);

            intent.putExtra("loginUser", username);

            setResult(RESULT_OK, intent);

            LoginActivity.this.finish();

        }

    }



    /**

     * 保存登录的状态和用户名

     * @param username

     * @param isLogin

     */

    private void saveLoginStatus(String username, boolean isLogin) {

        getSharedPreferences("userInfo", MODE_PRIVATE)

                .edit()

                .putString("loginUser", username)

                .putBoolean("isLogin", isLogin)

                .apply();

    }



    private String readPwd(String username) {

        SharedPreferences sp = getSharedPreferences("userInfo", MODE_PRIVATE);

        return sp.getString(username, "");

    }



    @Override

    protected void onActivityResult(int requestCode,

                                    int resultCode,

                                    @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {

            String username = data.getStringExtra("username");

            etUsername.setText(username);

//                etUsername.setSelection(username.length());

        }

    }



    //    @Override

//    public void onWindowFocusChanged(boolean hasFocus) {

//        super.onWindowFocusChanged(hasFocus);

//        if (hasFocus && Build.VERSION.SDK_INT >= 19) {

//            View decorView = getWindow().getDecorView();

//            decorView.setSystemUiVisibility(

//                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE

//                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION

//                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

//                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION

//                            | View.SYSTEM_UI_FLAG_FULLSCREEN

//                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

//        }

//    }

}
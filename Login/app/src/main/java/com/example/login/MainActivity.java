package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private EditText setUsername;
    private EditText setPassword;
    private Button setLogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView forgetPwd = findViewById(R.id.forgetPassword);
        forgetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ForgetPassword.class);
                startActivity(intent);
            }
        });

        setUsername = findViewById(R.id.username);
        setPassword = findViewById(R.id.password);
        setLogin = findViewById(R.id.submitBtn);

        setLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = setUsername.getText().toString();
                String password = setPassword.getText().toString();

                if(username.equals("admin") && password.equals("admin")){
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Invalid Credientials", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
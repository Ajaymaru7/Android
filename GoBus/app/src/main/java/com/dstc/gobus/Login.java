package com.dstc.gobus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    Button btn_login, btn_CreateAccount;
    EditText ed_name, ed_Pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login Page");

        btn_login=(Button)findViewById(R.id.btn_login);
        btn_CreateAccount=(Button)findViewById(R.id.btn_CA);
        ed_name=(EditText)findViewById(R.id.ed_name);
        ed_Pass=(EditText)findViewById(R.id.ed_password);


        btn_CreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),CreateAccount.class);
                startActivity(i);
            }
        });
    }
}

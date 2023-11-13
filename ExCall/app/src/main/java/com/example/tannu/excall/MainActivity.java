package com.example.tannu.excall;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn_call;
    EditText ed_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_call = (Button) findViewById(R.id.btn_call);
        ed_number = (EditText) findViewById(R.id.ed_number);

        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+ed_number.getText().toString()));
                startActivity(call);
            }
        });
    }
}

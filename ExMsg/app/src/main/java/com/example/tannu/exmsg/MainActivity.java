package com.example.tannu.exmsg;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_C,btn_M;
    EditText ed_C,ed_M;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_M=(Button)findViewById(R.id.btn_msg);
        btn_C=(Button)findViewById(R.id.btn_call);
        ed_M=(EditText)findViewById(R.id.ed_msg);
        ed_C=(EditText)findViewById(R.id.ed_call);

        btn_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent call = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+ed_C.getText().toString()));
                startActivity(call);
            }
        });
        btn_M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SmsManager sm = SmsManager.getDefault();
                sm.sendTextMessage(ed_C.getText().toString(),null,ed_M.getText().toString(),null,null);
                Toast.makeText(MainActivity.this, "send", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package com.dstc.exvibrate;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_Vibrate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Vibrate=(Button)findViewById(R.id.btn_V);

        btn_Vibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vi = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                vi.vibrate(1000);
            }
        });

    }
}

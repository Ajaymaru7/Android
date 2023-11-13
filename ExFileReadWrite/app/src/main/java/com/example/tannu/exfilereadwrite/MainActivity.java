package com.example.tannu.exfilereadwrite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.StringBufferInputStream;

public class MainActivity extends AppCompatActivity {

    Button btn_save,btn_load;
    TextView tv_read;
    EditText ed_et;


    String data;
    private String file = "mydata.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_save = (Button)findViewById(R.id.btn_s);
        btn_load = (Button)findViewById(R.id.btn_l);
        tv_read = (TextView)findViewById(R.id.tv_r);
        ed_et = (EditText)findViewById(R.id.ed_et);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                data = ed_et.getText().toString();
                try{
                    FileOutputStream fout = openFileOutput(file,MODE_WORLD_READABLE);
                    fout.write(data.getBytes());
                    fout.close();
                    Toast.makeText(getBaseContext(),"File Saved", Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        btn_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileInputStream fin = openFileInput(file);
                    int c;
                    String temp="";
                    while ((c=fin.read()) != -1){
                        temp = temp + Character.toString((char)c);
                    }
                    tv_read.setText(temp);
                    Toast.makeText(getBaseContext(), "File Read", Toast.LENGTH_SHORT).show();
                }catch (Exception e){

                }

            }
        });
    }
}

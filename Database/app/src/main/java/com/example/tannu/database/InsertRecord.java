package com.example.tannu.database;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertRecord extends AppCompatActivity {

    EditText ed_id,ed_sn, ed_cn;
    Button btn_i, btn_b;
    SQLiteDatabase stu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_record);

        ed_id = (EditText)findViewById(R.id.i_ed_id);
        ed_sn = (EditText)findViewById(R.id.i_ed_sn);
        ed_cn = (EditText)findViewById(R.id.i_ed_cn);
        btn_i = (Button)findViewById(R.id.i_btn_I);
        btn_b = (Button)findViewById(R.id.i_btn_B);

        stu = openOrCreateDatabase("Student.db",Context.MODE_PRIVATE,null);

        btn_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if(ed_id.getText().toString().equals("")&& ed_sn.getText().toString().equals("")&&ed_cn.getText().toString().equals(""))
                    {
                        Toast.makeText(getApplicationContext(),"Fill up All Information",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        stu.execSQL("insert into stud(id,name,course)values('"+ed_id.getText().toString()+"','"+ed_sn.getText().toString()+"','"+ed_cn.getText().toString()+"')");
                        Toast.makeText(getApplicationContext(),"Data is Stored", Toast.LENGTH_SHORT).show();

                        ed_id.setText("");
                        ed_sn.setText("");
                        ed_cn.setText("");
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }
}

package com.example.tannu.database;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchRecord extends AppCompatActivity {

    EditText s_id;
    Button s_btn_search, s_btn_back;
    TextView s_tv_sn, s_tv_cn;
    SQLiteDatabase stu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_record);

        s_id =(EditText)findViewById(R.id.s_ed_id);
        s_btn_search=(Button)findViewById(R.id.s_btn_s);
        s_btn_back = (Button)findViewById(R.id.s_btn_b);
        s_tv_sn = (TextView)findViewById(R.id.s_tv_sn);
        s_tv_cn = (TextView)findViewById(R.id.s_tv_cn);

        stu = openOrCreateDatabase("Student.db", Context.MODE_PRIVATE,null);

        s_btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String table="Stud";
                    String[]col={"name,course"};
                    String sel="id=?";
                    String[]arg={s_id.getText().toString()};
                    Cursor c = stu.query(table,col,sel,arg,null,null,null);
                    c.moveToFirst();
                    if(c.getCount()<=0){
                        Toast.makeText(getApplicationContext(),"No Record Found", Toast.LENGTH_SHORT).show();
                    }else{
                        s_tv_sn.setText(c.getString(0));
                        s_tv_cn.setText(c.getString(1));
                        Toast.makeText(getApplicationContext(), "Record Found", Toast.LENGTH_SHORT).show();
                    }
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(),e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        s_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}

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

public class UpdateRecord extends AppCompatActivity {


    EditText id, u_ed_sn, u_ed_cn;
    Button btn_u, btn_s, btn_b;
    SQLiteDatabase stu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_record);

        u_ed_sn = (EditText)findViewById(R.id.u_ed_sn);
        u_ed_cn = (EditText)findViewById(R.id.u_ed_cn);
        id = (EditText)findViewById(R.id.u_ed_I);
        btn_s = (Button)findViewById(R.id.u_btn_s);
        btn_u = (Button)findViewById(R.id.u_btn_u);
        btn_b = (Button)findViewById(R.id.u_btn_b);

        stu = openOrCreateDatabase("Student.db", Context.MODE_PRIVATE,null);

        btn_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String table="stud";
                    String[]col={"name,course"};
                    String sel="id=?";
                    String[]arg={id.getText().toString()};
                    Cursor c = stu.query(table,col,sel,arg,null,null,null);
                    c.moveToFirst();
                    if(c.getCount()<=0){
                        Toast.makeText(getApplicationContext(),"No REcord Found", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        u_ed_sn.setText(c.getString(0));
                        u_ed_cn.setText(c.getString(1));
                        Toast.makeText(getApplicationContext(),"record Found",Toast.LENGTH_SHORT).show();
                    }
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(),e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    stu.execSQL("Update stud set name='"+u_ed_sn.getText().toString()+"',course='"+u_ed_cn.getText().toString()+"' where id='"+id.getText().toString()+"'");
                    Toast.makeText(getApplicationContext(),"Data is Updated",Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();

                        id.setText("");
                        u_ed_sn.setText("");
                        u_ed_cn.setText("");
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

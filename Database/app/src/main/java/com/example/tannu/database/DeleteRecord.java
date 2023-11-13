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

import org.w3c.dom.Text;

public class DeleteRecord extends AppCompatActivity {

    EditText ed_id;
    Button btn_d, btn_s, btn_b;
    TextView d_tv;
    SQLiteDatabase stu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_record);

        ed_id=(EditText)findViewById(R.id.d_ed_id);
        btn_s=(Button)findViewById(R.id.d_btn_s);
        btn_d=(Button)findViewById(R.id.d_btn_d);
        btn_b=(Button)findViewById(R.id.d_btn_b);
        d_tv=(TextView)findViewById(R.id.d_tv_sn);

        stu=openOrCreateDatabase("Student.db", Context.MODE_PRIVATE,null);
        btn_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String table="stud";
                    String[]col={"name,course"};
                    String sel="id=?";
                    String[]arg={ed_id.getText().toString()};
                    Cursor c = stu.query(table,col,sel,arg,null,null,null);
                    c.moveToFirst();
                    if(c.getCount()<=0){
                        Toast.makeText(getApplicationContext(), "No REcord Found", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        d_tv.setText(c.getString(0)+"and"+c.getString(1));
                        Toast.makeText(getApplicationContext(), "Recod Found", Toast.LENGTH_SHORT).show();
                    }
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(),e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    stu.execSQL("Delete from stud where id='"+ed_id.getText().toString()+"'");
                    Toast.makeText(getApplicationContext(), "Data is Deleted", Toast.LENGTH_SHORT).show();
                    d_tv.setText("");
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.toString(), Toast.LENGTH_SHORT).show();
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

package com.example.tannu.database;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_CD, btn_I, btn_U, btn_D, btn_S, btn_V;
    SQLiteDatabase stu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_CD = (Button)findViewById(R.id.btn_CD);
        btn_I = (Button)findViewById(R.id.btn_insert);
        btn_U = (Button)findViewById(R.id.btn_update);
        btn_D = (Button)findViewById(R.id.btn_delete);
        btn_S = (Button)findViewById(R.id.btn_search);
        btn_V = (Button)findViewById(R.id.btn_view);

        btn_CD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stu=openOrCreateDatabase("Student.db", Context.MODE_PRIVATE,null);
                stu.execSQL("drop table IF EXISTS stud");
                stu.execSQL("Create Table stud(id text primarykey, name text, course text)");
                Toast.makeText(getApplicationContext(), "database is Created", Toast.LENGTH_SHORT).show();
            }
        });

        btn_I.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),InsertRecord.class);
                startActivity(i);
            }
        });

        btn_U.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),UpdateRecord.class);
                startActivity(i);
            }
        });

        btn_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),DeleteRecord.class);
                startActivity(i);
            }
        });

        btn_S.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SearchRecord.class);
                startActivity(i);
            }
        });

        btn_V.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ViewRecord.class);
                startActivity(i);
            }
        });
    }
}

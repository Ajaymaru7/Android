package com.example.tannu.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ViewRecord extends AppCompatActivity {

    ListView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_record);

        l=(ListView)findViewById(R.id.listView);

        ArrayList<HashMap<String,String>>userList = GetUser();
        ListAdapter adapter = new SimpleAdapter(ViewRecord.this,userList, R.layout.list_row,new String[]{"id","sname","cname"},new int[]{R.id.tv_1,R.id.tv_2,R.id.tv_3});
        l.setAdapter(adapter);
    }
    public ArrayList<HashMap<String, String>>GetUser(){
        SQLiteDatabase stu =openOrCreateDatabase("Student.db", Context.MODE_PRIVATE,null);
        ArrayList<HashMap<String,String>>userList = new ArrayList<>();
        String table="stud";
        String[]col={"id","name","course"};
        Cursor c=stu.query(table,col,null,null,null,null,null);
        c.moveToFirst();
        do{
            HashMap<String,String>user = new HashMap<>();
            user.put("id",c.getString(0));
            user.put("sname",c.getString(1));
            user.put("cname",c.getString(2));
            userList.add(user);
        }while(c.moveToNext());
        return  userList;
    }
}

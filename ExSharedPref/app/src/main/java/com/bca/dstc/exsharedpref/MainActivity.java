package com.bca.dstc.exsharedpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_save,btn_vdata;
    EditText ed_name, ed_number, ed_email;

    public static final String myPREFERENCES = "MyPrefs";
    public static final String Name = "namekey";
    public static final String Number = "numkey";
    public static final String Email = "emailkey";

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_save=(Button)findViewById(R.id.btn_S);
        btn_vdata=(Button)findViewById(R.id.btn_vd);
        ed_name=(EditText)findViewById(R.id.ed_n);
        ed_number=(EditText)findViewById(R.id.ed_pn);
        ed_email=(EditText)findViewById(R.id.ed_m);


        sp=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n =ed_name.getText().toString();
                String pn =ed_name.getText().toString();
                String e =ed_name.getText().toString();
                SharedPreferences.Editor editor = sp.edit();
                editor.putString(Name, n);
                editor.putString(Number, pn);
                editor.putString(Email, e);
                editor.commit();
                Toast.makeText(MainActivity.this, "dat Stored", Toast.LENGTH_SHORT).show();
            }
        });
        btn_vdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "name", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

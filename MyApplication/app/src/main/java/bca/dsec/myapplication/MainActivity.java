package bca.dsec.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class   MainActivity extends AppCompatActivity {


    Button btnL,btnC;
    EditText ednm,edpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Login Form");

        //Login page
        btnL = (Button)findViewById(R.id.btn1);
        ednm = (EditText)findViewById(R.id.edUserName);
        edpwd = (EditText)findViewById(R.id.edPassword);

        //New Account
        btnC = (Button)findViewById(R.id.btn2);


        btnL.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                String unm = ednm.getText().toString();
                String pwd = edpwd.getText().toString();

                if(unm.equals("") && pwd.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Enter Some Value", Toast.LENGTH_SHORT).show();
                }
                else if(unm.equals("admin") && pwd.equals("bca"))
                {
                    Toast.makeText(MainActivity.this, "OKK", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),Activity2.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Incorrect Password or Username", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Wellcome", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),Create_Aco.class);
                    startActivity(i);
                }
        });
}

}



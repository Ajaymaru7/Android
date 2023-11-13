package bca.dsec.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Create_Aco extends AppCompatActivity {


    EditText edF,edL,edM,edA ;
    RadioGroup rdg;
    CheckBox chR,chD,chT;
    Button btnR;

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__aco);
//        getSupportActionBar().setTitle("Create Account");


            //EditText
            edF = (EditText)findViewById(R.id.edFN);
            edL = (EditText)findViewById(R.id.edLN);
            edM = (EditText)findViewById(R.id.edM);
            edA = (EditText)findViewById(R.id.edA);

            //RadioButton
            rdg = (RadioGroup)findViewById(R.id.rdg);

            //CheckBox
            chR = (CheckBox)findViewById(R.id.chBoxR);
            chT = (CheckBox)findViewById(R.id.chBoxT);
            chD = (CheckBox)findViewById(R.id.chBoxD);

            btnR = (Button)findViewById(R.id.btnR);
            btnR.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String chstr_r="", chstr_t="", chstr_d="";

//                        RadioButton r
                        RadioButton r = (RadioButton)findViewById(rdg.getCheckedRadioButtonId());
                            Toast.makeText(Create_Aco.this,r.getText().toString(), Toast.LENGTH_SHORT).show();

                        if(chR.isChecked())
                            chstr_r = chR.getText().toString();
                        if(chT.isChecked())
                            chstr_t = chT.getText().toString();
                        if(chD.isChecked())
                            chstr_d = chD.getText().toString();

                        Toast.makeText(Create_Aco.this, chstr_r + chstr_t + chstr_d, Toast.LENGTH_SHORT).show();


                        String edf = edF.getText().toString();  
                        String edl = edL.getText().toString();
                        String edm = edM.getText().toString();
                        String eda = edA.getText().toString();

                        Intent i = new Intent(getApplicationContext(),Profile.class);

                        i.putExtra("chR",chstr_r);
                        i.putExtra("chT", chstr_t);
                        i.putExtra("chD", chstr_d);

                        i.putExtra("edF",edf);
                        i.putExtra("edL",edl);
                        i.putExtra("edM",edm);
                        i.putExtra("edA",eda);

                        i.putExtra("Gander",r.getText().toString());

                        startActivity(i);
                    }
                });

        }

     }


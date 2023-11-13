package bca.dsec.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    TextView f,l,m,a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        f = (TextView)findViewById(R.id.txf);
        l = (TextView)findViewById(R.id.txl);
        m = (TextView)findViewById(R.id.edm);
        a = (TextView)findViewById(R.id.eda);

        Intent i = getIntent();

        String a = i.getStringExtra("edF");
        String b = i.getStringExtra("edL");
        String c = i.getStringExtra("edM");
        String d = i.getStringExtra("edA");

        f.setText(a);
        l.setText(b);
        m.setText(c);
        l.setText(d);


    }
}

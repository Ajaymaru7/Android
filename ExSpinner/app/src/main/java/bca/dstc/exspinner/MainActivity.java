package bca.dstc.exspinner;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner s;
    ImageView i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s=(Spinner)findViewById(R.id.spinner);
        i=(ImageView)findViewById(R.id.imageView);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, parent.getCount()+"", Toast.LENGTH_SHORT).show();

                if(position == 0) {
                    view.setBackgroundColor(Color.RED);
                    i.setBackgroundColor(Color.RED);
                }
                else if(position == 1) {
                    view.setBackgroundColor(Color.GREEN);
                    i.setBackgroundColor(Color.GREEN);
                }
                else if(position == 2) {
                    view.setBackgroundColor(Color.BLUE);
                    i.setBackgroundColor(Color.BLUE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}

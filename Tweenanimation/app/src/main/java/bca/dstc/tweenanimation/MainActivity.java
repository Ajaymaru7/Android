package bca.dstc.tweenanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner sp;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp=(Spinner)findViewById(R.id.spinner);
        iv=(ImageView)findViewById(R.id.imageView);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position)
                {
                    case 0:
                        Toast.makeText(MainActivity.this, "rotate", Toast.LENGTH_SHORT).show();
                        Animation r = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ex_rotate);
                        iv.startAnimation(r);
                        break;

                    case 1:
                        Toast.makeText(MainActivity.this, "scale", Toast.LENGTH_SHORT).show();
                        Animation s = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ex_scale);
                        iv.startAnimation(s);
                        break;

                    case 2:
                        Toast.makeText(MainActivity.this, "transalate", Toast.LENGTH_SHORT).show();
                        Animation t = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ex_transalate);
                        iv.startAnimation(t);
                        break;

                    case 3:
                        Toast.makeText(MainActivity.this, "alpha", Toast.LENGTH_SHORT).show();
                        Animation a = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ex_alpha);
                        iv.startAnimation(a);
                        break;

                    case 4:
                        Toast.makeText(MainActivity.this, "mix", Toast.LENGTH_SHORT).show();
                        Animation m = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.mix);
                        iv.startAnimation(m);
                        break;

                    default:
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}

package bca.dstc.framebyframe;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView iv;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        iv = (ImageView)findViewById(R.id.imageView);
        b1 = (Button)findViewById(R.id.btn1);
        b2 = (Button)findViewById(R.id.btn2);

        iv.setImageResource(R.drawable.framenm);
        final AnimationDrawable frameAnimation =(AnimationDrawable) iv.getDrawable();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                frameAnimation.start();

                Toast.makeText(MainActivity.this, "Loading.....", Toast.LENGTH_SHORT).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frameAnimation.stop();
                Toast.makeText(MainActivity.this, "STOP 😔", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

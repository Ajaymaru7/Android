package bca.dstc.progressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar p;
    Button b;
    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p = (ProgressBar)findViewById(R.id.progressBar);
        b = (Button)findViewById(R.id.btn);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPValue(progress);
            }
        });
    }

    private void setPValue(final int progress)
    {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e)
                    { }
                    setPValue(progress+10);
                }
            });
            t.start();
    }

}

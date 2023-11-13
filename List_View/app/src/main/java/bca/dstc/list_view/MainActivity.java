package bca.dstc.list_view;

import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    String[] ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ls.(ListView)findViewById(R.id.textView);
        ls = getResources().getStringArray(R.array.array_technology);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplication(),android.R.layout.simple_list_item_1,android.R.id.textview);
        lv.setAdapter(adapter);


        lv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = adapter.getItem(position)
            }
        });



    }
}

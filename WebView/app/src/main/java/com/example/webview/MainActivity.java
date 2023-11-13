package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText ed1;
    TextView tv;
    WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.button);
        ed1=(EditText)findViewById(R.id.editText);
        tv=(TextView)findViewById(R.id.textView);

        wv1=(WebView)findViewById(R.id.WebView);

        WebViewClient webClient = new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                Log.v("WebView","Page Finish Loaading");
                super.onPageFinished(view, url);
                String title = wv1.getTitle();
                tv.setText(title + "has been Loaded....");
            }


           @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                Log.i("WebView", "Starting....");
                super.onPageStarted(view, url, favicon);
                tv.setText(url + "\nloding...");
            }
        };
        wv1.setWebViewClient(webClient);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = ed1.getText().toString();

                wv1.getSettings().setLoadsImagesAutomatically(true);
                wv1.getSettings().setJavaScriptEnabled(true);
                wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                wv1.loadUrl(url);
            }
        });
    }
    private class MyBrowser extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
        @Override
        public  void onPageStarted(WebView view, String url, Bitmap favicon){
            super.onPageStarted(view, url, favicon);
            String title = view.getTitle();
            System.out.print(title);
        }


        @Override
        public void  onPageFinished(WebView view, String url){
            super.onPageFinished(view, url);
        }
    }
}
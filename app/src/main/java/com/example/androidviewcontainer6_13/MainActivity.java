package com.example.androidviewcontainer6_13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import java.nio.file.Files;

public class MainActivity extends AppCompatActivity {

    EditText edtURL;
    Button btnGo, btnBack;
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        edtURL= (EditText) findViewById(R.id.edtURL);
        btnGo = (Button) findViewById(R.id.btnGo);
        btnBack = (Button) findViewById(R.id.btnBack);
        web = (WebView) findViewById(R.id.webView);

        web.setWebViewClient(new CookWebViewClient());

        WebSettings webSet = web.getSettings();
        webSet.setBuiltInZoomControls(true);

        btnGo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                web.loadUrl(edtURL.getText().toString());
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.goBack();
            }
        });
    }
    class CookWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }
    }
}
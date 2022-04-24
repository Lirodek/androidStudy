package com.example.androidsemiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {
    RadioGroup rbG;
    RadioButton rbMan, rbWonder;
    LinearLayout linearGender, linearWeb;
    Button btnGo, btnBack;
    WebView webView;
    EditText edtUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        rbG.setOnCheckedChangeListener(radioGroupCheck);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.naver.com/");
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(edtUrl.getText().toString());
                webView.loadUrl(edtUrl.getText().toString());
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.goBack();
            }
        });




        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabGender = tabHost.newTabSpec("Gender")
                .setIndicator("성별");
        tabGender.setContent(R.id.tabGender);
        tabHost.addTab(tabGender);

        TabHost.TabSpec tabWebBrowser = tabHost.newTabSpec("WebBrowser")
                .setIndicator("웹 브라우저");
        tabWebBrowser.setContent(R.id.tabWebBrowser);
        tabHost.addTab(tabWebBrowser);

        tabHost.setCurrentTab(0);
    }
    void init(){
        linearGender = (LinearLayout) findViewById(R.id.tabGender);

        rbG = (RadioGroup) findViewById(R.id.rdG);
        rbMan = (RadioButton) findViewById(R.id.rbMan);
        rbMan = (RadioButton) findViewById(R.id.rbMan);
        rbWonder = (RadioButton) findViewById(R.id.rbWonder);

        btnGo = (Button) findViewById(R.id.btnGo);
        btnBack = (Button) findViewById(R.id.btnBack);
        webView = (WebView) findViewById(R.id.webView1);
        edtUrl = (EditText) findViewById(R.id.edtUrl);
    }

    RadioGroup.OnCheckedChangeListener radioGroupCheck = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if(i == R.id.rbMan){
                Toast.makeText(getApplicationContext(), "남자 선택됨", Toast.LENGTH_SHORT).show();
                linearGender.setBackgroundColor(Color.GRAY);
            } else {
                Toast.makeText(getApplicationContext(), "여자 선택됨", Toast.LENGTH_SHORT).show();
                linearGender.setBackgroundColor(Color.LTGRAY);
            }
        }
    };
    class TestWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }

}
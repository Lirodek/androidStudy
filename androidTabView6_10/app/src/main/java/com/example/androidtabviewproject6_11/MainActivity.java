package com.example.androidtabviewproject6_11;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabSpecElina = tabHost.newTabSpec("일레이나").setIndicator("일레이나");
        tabSpecElina.setContent(R.id.elaina);
        tabHost.addTab(tabSpecElina);

        TabHost.TabSpec tabSpicalElaina = tabHost.newTabSpec("우승자 일레이나").setIndicator("우승자 일레이나");
        tabSpicalElaina.setContent(R.id.winner);
        tabHost.addTab(tabSpicalElaina);

        TabHost.TabSpec tabMisaka = tabHost.newTabSpec("미사카 미코토").setIndicator("미사카 미코토");
        tabMisaka.setContent(R.id.misaka);
        tabHost.addTab(tabMisaka);

        TabHost.TabSpec tabSpecialMisaka = tabHost.newTabSpec("우승자 미코토").setIndicator("우승자 미코토");
        tabSpecialMisaka.setContent(R.id.winner2);
        tabHost.addTab(tabSpecialMisaka);

        tabHost.setCurrentTab(0);
    }
}
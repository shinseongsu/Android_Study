package com.example.application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.os.Bundle;
import android.widget.TabHost;

public class Main7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        TabHost host = findViewById(R.id.host);
        host.setup();

        TabHost.TabSpec spec = host.newTabSpec("tab1");
        spec.setIndicator(null, ResourcesCompat.getDrawable(
                getResources(), R.drawable.tab_icon1, null));
        spec.setContent(R.id.tab_content1);
        host.addTab(spec);

        spec = host.newTabSpec("tab2");
        spec.setIndicator(null, ResourcesCompat.getDrawable(
                getResources(), R.drawable.tab_icon2, null));
        spec.setContent(R.id.tab_content2);
        host.addTab(spec);

        spec = host.newTabSpec("tab3");
        spec.setIndicator(null, ResourcesCompat.getDrawable(
                getResources(), R.drawable.tab_icon3, null ));
        spec.setContent(R.id.tab_content3);
        host.addTab(spec);

    }
}

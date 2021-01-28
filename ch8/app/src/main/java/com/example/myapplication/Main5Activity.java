package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;
import android.widget.Spinner;

public class Main5Activity extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Spinner spinner = findViewById(R.id.spinner);

        String[] datas = getResources().getStringArray(R.array.spinner_array);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, datas);
        arrayAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.auto);
        String[] autoDatas = getResources().getStringArray(R.array.auto_array);
        ArrayAdapter<String> autoAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, autoDatas);

        autoCompleteTextView.setAdapter(autoAdapter);

        progressBar = findViewById(R.id.progress);
        ProgressThread thread = new ProgressThread();
        thread.start();

    }

    class ProgressThread extends Thread {
        @Override
        public void run() {
            for(int i = 0 ; i < 10 ; i++) {
                SystemClock.sleep(1000);
                progressBar.incrementProgressBy(10);
                progressBar.incrementSecondaryProgressBy(15);
            }
        }
    }

}

package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        TextView textView = findViewById(R.id.fileResult);

        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
                + "/myApp/myfile.txt");


        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuffer buffer = new StringBuffer();
            String line;

            while((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            textView.setText(buffer.toString());
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

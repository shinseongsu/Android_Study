package com.example.part2_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class Lab3_6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        Button button1 = new Button(this);

        linearLayout.addView(button1);

        Button button2 = new Button(this);
        linearLayout.addView(button2);

        // 새롭게 생성
        setContentView(linearLayout);
    }
}

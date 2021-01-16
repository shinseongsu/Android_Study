package com.example.part2_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linear = new LinearLayout(this);

        Button button = new Button(this);
        button.setText("Button 1");
        linear.addView(button);

        Button button2 = new Button(this);
        button2.setText("Button 2");
        linear.addView(button2);

        setContentView(linear);

    }
}

package com.example.part2_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Lab3_5Activity extends AppCompatActivity implements View.OnClickListener {

    Button trueButton;
    TextView targetTextView;
    Button falseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3_5);

        // view 객체 생성
        trueButton = findViewById(R.id.btn_visible_true);
        targetTextView = findViewById(R.id.text_visible_target);
        falseButton = findViewById(R.id.btn_visible_false);

        // Button 이벤트 등록
        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == trueButton) {
            // trueButton이 눌리면 targetTextView를 visible 상태로 변경
            targetTextView.setVisibility(View.VISIBLE);
        } else if (view == falseButton) {
            // falseButton이 눌리면 targetTextView를 invisible 상태로 변경
            targetTextView.setVisibility(View.INVISIBLE);
        }
    }
}

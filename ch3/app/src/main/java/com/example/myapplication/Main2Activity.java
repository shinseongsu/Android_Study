package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    Button alertBtn;
    Button listBtn;
    Button dateBtn;
    Button timeBtn;
    Button customDialogBtn;

    AlertDialog customDialog;
    AlertDialog listDialog;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // View 객체 획득
        alertBtn = findViewById(R.id.btn_alert);
        listBtn = findViewById(R.id.btn_list);
        dateBtn = findViewById(R.id.btn_date);
        timeBtn = findViewById(R.id.btn_time);
        customDialogBtn = findViewById(R.id.btn_custom);

        // 버튼 이벤트 등록
        alertBtn.setOnClickListener(this);
        listBtn.setOnClickListener(this);
        dateBtn.setOnClickListener(this);
        timeBtn.setOnClickListener(this);
        customDialogBtn.setOnClickListener(this);

    }

    // 매개변수의 문자열을 Toast로 띄우는 개발자 함수
    private void showToast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    DialogInterface.OnClickListener dialogListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(dialog == customDialog && which == DialogInterface.BUTTON_POSITIVE) {
                showToast("custom dialog 확인 Click...");
            } else if (dialog == listDialog) {
                String[] datas = getResources().getStringArray(R.array.dialog_array);
                showToast(datas[which] + " 선택 하셨습니다.");
            } else if (dialog == alertDialog && which == DialogInterface.BUTTON_POSITIVE) {
                showToast("alert dialog ok click...");
            }
        }
    };

    @Override
    public void onClick(View view) {
        if(view == alertBtn) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(android.R.drawable.ic_dialog_alert);
            builder.setTitle("알림");
            builder.setMessage("정말 종료 하시겠습니까?");
            builder.setPositiveButton("OK", dialogListener);
            builder.setNegativeButton("NO", null);

            alertDialog = builder.create();
            alertDialog.show();

        } else if (view == listBtn) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("알람 벨소리");
            builder.setSingleChoiceItems(R.array.dialog_array, 0, dialogListener);
            builder.setPositiveButton("확인", null);
            builder.setNegativeButton("취소", null);
            listDialog = builder.create();
            listDialog.show();
        } else if (view == dateBtn) {
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dateDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            showToast(year + ":" + (monthOfYear+1) + ":" + dayOfMonth);
                        }
                    }, year, month, day);
            dateDialog.show();
        } else if (view == timeBtn) {
            Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            TimePickerDialog timeDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            showToast(hourOfDay + ":" + minute);
                        }
                    }, hour, minute, false);
            timeDialog.show();
        } else if (view == customDialogBtn) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View view1 = inflater.inflate(R.layout.dialog_layout, null);
            builder.setView(view1);
            builder.setPositiveButton("확인", dialogListener);
            builder.setNegativeButton("취소", null);

            customDialog = builder.create();
            customDialog.show();
        }

    }
}

package com.example.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class MyPlusMinusView extends View {

    Context context;
    int value;
    // 화면 출력 이미지
    Bitmap plusBitmap;
    Bitmap minusBtmap;
    // 이미지가 화면에 출력되는 좌표정보
    Rect plusRectDst;
    Rect minusRectDst;

    // value 출력 문자열 색상
    int textColor;

    // Observer를 등록하기 위한 객체
    ArrayList<OnMyChangeListener> listeners;

    public MyPlusMinusView(Context context) {
        super(context);
        this.context = context;
        init(null);
    }

    public MyPlusMinusView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(attrs);
    }

    public MyPlusMinusView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(attrs);
    }

    // 생성자의 공통 코드
    private void init(AttributeSet attrs) {
        plusBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.plus);
        minusBtmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.minus);

        plusRectDst = new Rect(10, 10, 210, 210);
        minusRectDst = new Rect(400, 10, 600, 210);

        if(attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MyView);
            textColor = a.getColor(R.styleable.MyView_customTextColor, Color.RED);
        }
        listeners = new ArrayList<>();
    }

    public void setOnMyChangeListener(OnMyChangeListener listener){
        listeners.add(listener);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode=MeasureSpec.getMode(widthMeasureSpec);
        int widthSize=MeasureSpec.getSize(widthMeasureSpec);
        int heightMode=MeasureSpec.getMode(heightMeasureSpec);
        int heightSize=MeasureSpec.getSize(heightMeasureSpec);

        int width=0;
        int height=0;

        if(widthMode==MeasureSpec.AT_MOST){
            width=700;
        }else if(widthMode==MeasureSpec.EXACTLY){
            width=widthSize;
        }
        if(heightMode==MeasureSpec.AT_MOST){
            height=250;
        }else if(heightMode==MeasureSpec.EXACTLY){
            height=heightSize;
        }
        setMeasuredDimension(width, height);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x=(int)event.getX();
        int y=(int)event.getY();

        if(plusRectDst.contains(x, y) && event.getAction()==MotionEvent.ACTION_DOWN){
            value++;
            invalidate();
            for(OnMyChangeListener listener : listeners){
                listener.onChange(value);
            }
            return  true;
        }else if(minusRectDst.contains(x, y) && event.getAction()==MotionEvent.ACTION_DOWN){
            value--;
            invalidate();
            for(OnMyChangeListener listener : listeners){
                listener.onChange(value);
            }
            return true;
        }
        return false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.alpha(Color.CYAN));

        Rect plusRectSource=new Rect(0, 0, plusBitmap.getWidth(), plusBitmap.getHeight());
        Rect minusRectSource=new Rect(0, 0, minusBtmap.getWidth(), minusBtmap.getHeight());

        Paint paint=new Paint();

        canvas.drawBitmap(plusBitmap, plusRectSource, plusRectDst, null);

        paint.setTextSize(80);
        paint.setColor(textColor);
        canvas.drawText(String.valueOf(value), 260, 150, paint);

        canvas.drawBitmap(minusBtmap, minusRectSource, minusRectDst, null);
    }


}

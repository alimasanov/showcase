package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class Main2Activity extends AppCompatActivity {

    RelativeLayout layout;
    Button button;
    float x1;
    float x2;
    float y1;
    float y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button = findViewById(R.id.button5);
        layout = findViewById(R.id.layout);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

//        float left = button.getLeft();
//        float right = button.getRight();
//        float top = button.getTop();
//        float bottom = button.getBottom();
//        RectF rectF = new RectF(left, top, right, bottom);

        float x = (button.getX() + button.getWidth()) / 2;
        float y = (button.getY() + button.getHeight()) / 2;

        layout.addView(new Draw(this,  x, y));
    }
}

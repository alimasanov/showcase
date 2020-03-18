package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Main2Activity extends AppCompatActivity {

    RelativeLayout layout;
    Button button;

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

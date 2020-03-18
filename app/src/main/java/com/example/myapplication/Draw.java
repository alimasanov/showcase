package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

@SuppressLint("ViewConstructor")
public class Draw extends View {

    Paint paint;
    RectF rectF;
    String type;
    float x;
    float y;
    float radius = 159;

    public Draw(Context context, float x, float y) {
        super(context);
        this.x = x;
        this.y = y;
        this.type = "circle";
        init();
    }

    public void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (type.equals("circle")) {
//            getCoordFromRect(rectF);
            canvas.drawCircle(x, y, radius, paint);
        } else if (type.equals("oval")) {
            canvas.drawOval(rectF, paint);
        }
    }
}

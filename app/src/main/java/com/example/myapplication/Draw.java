package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.view.View;

public class Draw extends View {

    Paint paint;
    RectF rectF;
    String type;
    float x;
    float y;
    float radius = 159;

    public Draw(Context context, RectF rectF, String type) {
        super(context);
        this.rectF = rectF;
        this.type = type;
        init();
    }

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

    private void getCoordFromRect(RectF rectF) {
        x = rectF.top + (rectF.bottom - rectF.top) / 2;
        y = rectF.left + (rectF.right - rectF.left) / 2;
        radius = 150;
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

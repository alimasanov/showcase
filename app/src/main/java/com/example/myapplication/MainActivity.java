package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.elconfidencial.bubbleshowcase.BubbleShowCase;
import com.elconfidencial.bubbleshowcase.BubbleShowCaseBuilder;
import com.elconfidencial.bubbleshowcase.BubbleShowCaseListener;
import com.elconfidencial.bubbleshowcase.BubbleShowCaseSequence;
import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ActionViewTarget;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

import me.toptas.fancyshowcase.FancyShowCaseQueue;
import me.toptas.fancyshowcase.FancyShowCaseView;
import me.toptas.fancyshowcase.FocusShape;
import me.toptas.fancyshowcase.listener.DismissListener;
import me.toptas.fancyshowcase.listener.OnViewInflateListener;

public class MainActivity extends AppCompatActivity {

    Button var1;
    Button var2;
    Button var3;
    Button button;
    Button button2;
    Button button3;
    TextView textView;
    ConstraintLayout cr;
    Draw draw;

    FancyShowCaseQueue queue;

    FancyShowCaseView firstView;
    FancyShowCaseView secView;
    FancyShowCaseView thirdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Main2Activity.class));
            }
        });
        var1 = findViewById(R.id.var1);
        var2 = findViewById(R.id.var2);
        var3 = findViewById(R.id.var3);
        textView = findViewById(R.id.text_view);

        setListeners();

    }


    private void setListeners() {
        var1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstView = new FancyShowCaseView.Builder(MainActivity.this)
                        .focusOn(button)
                        .title("title")
                        .customView(R.layout.custrom_view, new OnViewInflateListener() {
                            @Override
                            public void onViewInflated(View view) {
                                textView = view.findViewById(R.id.text_view);
                            }
                        })
                        .disableFocusAnimation()
                        .build();

                secView = new FancyShowCaseView.Builder(MainActivity.this)
                        .focusOn(button2)
                        .title("title")
                        .disableFocusAnimation()
                        .build();

                thirdView = new FancyShowCaseView.Builder(MainActivity.this)
                        .focusOn(button3)
                        .title("title")
                        .disableFocusAnimation()
                        .build();

                queue = new FancyShowCaseQueue().add(firstView).add(secView).add(thirdView);

                queue.show();
            }
        });

        var2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BubbleShowCaseBuilder first = new BubbleShowCaseBuilder(MainActivity.this)
                        .title("title")
                        .description("description")
                        .targetView(button)
                        .backgroundColor(R.drawable.back)
                        .listener(bubbleShowCaseListener);

                BubbleShowCaseBuilder sec = new BubbleShowCaseBuilder(MainActivity.this)
                        .title("title")
                        .description("description")
                        .targetView(button2)
                        .backgroundColor(R.drawable.back)
                        .arrowPosition(BubbleShowCase.ArrowPosition.RIGHT)
                        .listener(bubbleShowCaseListener);

                BubbleShowCaseBuilder third = new BubbleShowCaseBuilder(MainActivity.this)
                        .title("title")
                        .description("description")
                        .targetView(button3)
                        .backgroundColor(R.drawable.back)
                        .arrowPosition(BubbleShowCase.ArrowPosition.LEFT)
                        .listener(bubbleShowCaseListener);

                new BubbleShowCaseSequence().addShowCase(first).addShowCase(sec).addShowCase(third).show();
            }

            BubbleShowCaseListener bubbleShowCaseListener = new BubbleShowCaseListener() {
                @Override
                public void onTargetClick(BubbleShowCase bubbleShowCase) {
                    bubbleShowCase.dismiss();
                }

                @Override
                public void onCloseActionImageClick(BubbleShowCase bubbleShowCase) {
                    bubbleShowCase.dismiss();
                }

                @Override
                public void onBackgroundDimClick(BubbleShowCase bubbleShowCase) {
                    bubbleShowCase.dismiss();
                }

                @Override
                public void onBubbleClick(BubbleShowCase bubbleShowCase) {
                    bubbleShowCase.dismiss();
                }
            };
        });

        var3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ShowcaseView.Builder(MainActivity.this)
                        .setTarget(new ViewTarget(R.id.button, MainActivity.this))
                        .setContentText("text")
                        .setContentTitle("title")
                        .blockAllTouches()
                        .setStyle(R.style.CustomShowcaseTheme2)
                        .build();



            }
        });
    }

}

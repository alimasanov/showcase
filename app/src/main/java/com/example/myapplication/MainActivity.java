package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.elconfidencial.bubbleshowcase.BubbleShowCase;
import com.elconfidencial.bubbleshowcase.BubbleShowCaseBuilder;
import com.elconfidencial.bubbleshowcase.BubbleShowCaseListener;
import com.elconfidencial.bubbleshowcase.BubbleShowCaseSequence;
import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;
import com.wooplr.spotlight.SpotlightConfig;
import com.wooplr.spotlight.utils.SpotlightSequence;

import me.toptas.fancyshowcase.FancyShowCaseQueue;
import me.toptas.fancyshowcase.FancyShowCaseView;
import me.toptas.fancyshowcase.listener.OnViewInflateListener;

public class MainActivity extends AppCompatActivity {

    Button var1;
    Button var2;
    Button var3;
    Button var4;
    Button button;
    Button button2;
    Button button3;
    TextView textView;
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
        var4 = findViewById(R.id.var4);
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
                        .disableFocusAnimation()
                        .build();

                secView = new FancyShowCaseView.Builder(MainActivity.this)
                        .focusOn(button2)
                        .title("title")
                        .customView(R.layout.custrom_view, new OnViewInflateListener() {
                            @Override
                            public void onViewInflated(View view) {
                                TextView tv = view.findViewById(R.id.text_view);
                                tv.setText("за джона");
                            }
                        })
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
                        .listener(bubbleShowCaseListener);

                BubbleShowCaseBuilder sec = new BubbleShowCaseBuilder(MainActivity.this)
                        .title("title")
                        .description("description")
                        .targetView(button2)
                        .arrowPosition(BubbleShowCase.ArrowPosition.RIGHT)
                        .listener(bubbleShowCaseListener);

                BubbleShowCaseBuilder third = new BubbleShowCaseBuilder(MainActivity.this)
                        .title("title")
                        .description("description")
                        .targetView(button3)
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
                        .setStyle(R.style.CustomShowcaseTheme4)
                        .build();

            }
        });

        var4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SpotlightConfig config = new SpotlightConfig();
                config.setPadding(50);
                config.setLineAndArcColor(Color.BLUE);
                config.setHeadingTvColor(Color.BLUE);
                config.setLineAnimationDuration(200);
                config.setSubHeadingTvSize(18);

                SpotlightSequence.getInstance(MainActivity.this,config)
                        .addSpotlight(button, "Button 1", "this is button 1", "" + Math.random())
                        .addSpotlight(button2, "Button 2", "this is button 2", "" + Math.random())
                        .addSpotlight(textView, "TextView", "this is textView", "" + Math.random())
                .startSequence();
            }
        });
    }

}

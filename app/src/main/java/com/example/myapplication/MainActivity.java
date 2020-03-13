package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import me.toptas.fancyshowcase.FancyShowCaseQueue;
import me.toptas.fancyshowcase.FancyShowCaseView;
import me.toptas.fancyshowcase.FocusShape;
import me.toptas.fancyshowcase.listener.DismissListener;
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
    Switch aSwitch;

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
        var1 = findViewById(R.id.var1);
        var2 = findViewById(R.id.var2);
        var3 = findViewById(R.id.var3);
        var4 = findViewById(R.id.var4);
        textView = findViewById(R.id.text_view);
        aSwitch = findViewById(R.id.switch1);

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
    }
}

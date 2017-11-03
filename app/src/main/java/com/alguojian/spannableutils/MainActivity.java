package com.alguojian.spannableutils;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import android.widget.Toast;

import com.alguojian.mylibrary.SpannableStringUtils;

public class MainActivity extends AppCompatActivity {

    protected TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
        init();
    }

    private void init() {

        SpannableStringUtils spannableStringUtils = new SpannableStringUtils("飞流直下三千尺，疑是银河落九天");

        spannableStringUtils.setColor(Color.GREEN, 2, 6)
                .setBackGround(Color.BLUE, 4, 8)
                .setBold(6, 10)
                .setOnClick(9, 14, Color.YELLOW)
                .setOnClickSpanListener(new SpannableStringUtils.OnClickSpanListener() {
                    @Override
                    public void OnClickSpanListener() {

                        Toast.makeText(MainActivity.this, "点我", Toast.LENGTH_SHORT).show();
                    }
                });

        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setTextSize(20);
        textView.setText(spannableStringUtils);

    }

    private void initView() {
        textView = (TextView) findViewById(R.id.textView);
    }
}

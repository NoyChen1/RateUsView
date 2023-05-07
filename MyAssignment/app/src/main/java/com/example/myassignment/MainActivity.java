package com.example.myassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.library.RateUs;
import com.google.android.material.appbar.MaterialToolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button click_me_BTN = findViewById(R.id.click_me_BTN);

        click_me_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RateUs.Rate(MainActivity.this, Color.parseColor("#E44643"));

            }
        });
    }
}
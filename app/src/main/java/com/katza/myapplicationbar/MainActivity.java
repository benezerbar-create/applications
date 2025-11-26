package com.katza.myapplicationbar;

import android.content.Intent;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Switch sw;
    private Button myButton;
    private ImageView imageView;
    private SeekBar brightnessSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "start", Toast.LENGTH_SHORT).show();

        initViews();

        imageView.setVisibility(sw.isChecked() ? View.VISIBLE : View.INVISIBLE);
    }

    private void initViews() {
        imageView = findViewById(R.id.myImageView);
        myButton = findViewById(R.id.myButton);
        sw = findViewById(R.id.sw);
        brightnessSeekBar = findViewById(R.id.brightnessSeekBar);

        sw.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                imageView.setVisibility(View.VISIBLE);
            } else {
                imageView.setVisibility(View.INVISIBLE);
            }
        });

        myButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        });

        brightnessSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                // 100 = אין שינוי, פחות חשוך, יותר בהיר
                float brightness = progress - 100;

                ColorMatrix matrix = new ColorMatrix(new float[]{
                        1, 0, 0, 0, brightness,
                        0, 1, 0, 0, brightness,
                        0, 0, 1, 0, brightness,
                        0, 0, 0, 1, 0
                });

                imageView.setColorFilter(new ColorMatrixColorFilter(matrix));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }
}

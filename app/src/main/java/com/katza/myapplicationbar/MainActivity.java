package com.katza.myapplicationbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Switch sw;
    private Button myButton;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "start", Toast.LENGTH_SHORT).show();

        initViews();

        // Set initial state of image based on switch
        imageView.setVisibility(sw.isChecked() ? View.VISIBLE : View.INVISIBLE);
    }

    private void initViews() {
        imageView = findViewById(R.id.myImageView);
        myButton = findViewById(R.id.myButton);
        sw = findViewById(R.id.sw);

        sw.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                imageView.setVisibility(View.VISIBLE);
            } else {
                imageView.setVisibility(View.INVISIBLE);
            }
        });

        // --- כפתור לעמוד שני ---
        myButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        });
    }
}

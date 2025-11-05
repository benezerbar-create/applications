package com.katza.myapplicationbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private int totalCalories = 0;
    private TextView totalCaloriesText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        totalCaloriesText = findViewById(R.id.totalCaloriesText);

        // כפתורי המאכלים
        setupFoodButton(R.id.appleButton, 52);
        setupFoodButton(R.id.bananaButton, 89);
        setupFoodButton(R.id.breadButton, 80);
        setupFoodButton(R.id.cottageButton, 100);
        setupFoodButton(R.id.iceCreamButton, 200);
        setupFoodButton(R.id.pizzaButton, 285);
        setupFoodButton(R.id.chocolateButton, 230);
        setupFoodButton(R.id.orangeButton, 62);
        setupFoodButton(R.id.carrotButton, 41);

        // כפתור איפוס
        Button resetButton = findViewById(R.id.resetButton);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalCalories = 0;
                totalCaloriesText.setText("סה״כ קלוריות: 0");
            }
        });
    }

    private void setupFoodButton(int buttonId, int calories) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalCalories += calories;
                totalCaloriesText.setText("סה״כ קלוריות: " + totalCalories);
            }
        });
    }
}

package com.example.quiz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private TextView questionText, resultText;
    private Button option1, option2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionText = findViewById(R.id.questionText);
        resultText = findViewById(R.id.resultText);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);

        // Set click listeners for buttons
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayResult(true);
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayResult(false);
            }
        });
    }

    // Function to display result
    private void displayResult(boolean isCorrect) {
        if (isCorrect) {
            resultText.setText("Correct Answer!");
            resultText.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
        } else {
            resultText.setText("Wrong Answer!");
            resultText.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
        }

    }
}
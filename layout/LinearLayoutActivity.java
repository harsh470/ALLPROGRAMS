package com.example.layouts;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LinearLayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        TextView textView = findViewById(R.id.textView);
        textView.setText("This layout arranges its children in a single vertical or horizontal line.");
    }
}
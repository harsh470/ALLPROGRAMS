package com.example.calender;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Find views by their IDs
        CalendarView calendarView = findViewById(R.id.calendarView);
        TextView selectedDateText = findViewById(R.id.selectedDateText);

        // Set a listener to capture date selection
        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            // Months are 0-based (January is 0, December is 11), so add 1 to display correctly
            String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
            selectedDateText.setText("Selected Date: " + selectedDate);
        });
    }
}
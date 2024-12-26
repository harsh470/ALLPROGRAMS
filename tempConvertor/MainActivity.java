package com.example.temperatureconvertor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private EditText temperatureInput;
    private Spinner unitSpinner;
    private TextView resultText;
    private Button btnToKelvin, btnToCelsius,btnToFahrenheit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize views
        temperatureInput =findViewById(R.id.temperatureInput);
        unitSpinner = findViewById(R.id.unitSpinner);
        resultText = findViewById(R.id.resultText);
        btnToCelsius = findViewById(R.id.btnToCelsius);
        btnToKelvin = findViewById(R.id.btnToKelvin);
        btnToFahrenheit = findViewById(R.id.btnToFahrenheit);

        // Set click listeners for the buttons
        btnToKelvin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertTemperature("Kelvin");
            }
        });

        btnToFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertTemperature("Fahrenheit");
            }
        });

        btnToCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertTemperature("Celsius");
            }
        });
    }

    private  void  convertTemperature(String targetUnit){
        String input = temperatureInput.getText().toString();

        if(input.isEmpty()){
            Toast.makeText(this, "Please enter temperature ", Toast.LENGTH_SHORT).show();
            return;
        }

        double inputTemperature = Double.parseDouble(input);
        String inputUnit = unitSpinner.getSelectedItem().toString();
        double result = 0.0;

        // Conversion logic

        switch (inputUnit){
            case "Celsius":
                if(targetUnit.equals("Kelvin")){
                    result = inputTemperature + 273.15;
                } else if (targetUnit.equals("Fahrenheit")){
                    result = (inputTemperature * 9 / 5) + 32;
                } else {
                    result = inputTemperature;
                }
                break;

            case "Kelvin":
                if (targetUnit.equals("Celsius")){
                    result = inputTemperature - 273.15;
                } else if (targetUnit.equals("Fahrenheit")){
                    result = ((inputTemperature - 273.15) * 9/5) + 32;
                } else {
                    result = inputTemperature;
                }
                break;

            case "Fahrenheit":
                if (targetUnit.equals("Celsius")){
                    result = (inputTemperature - 32) * 5 / 9;
                } else if (targetUnit.equals("Kelvin")){
                    result = ((inputTemperature - 32) * 5 / 9) + 273.15;
                } else  {
                    result = inputTemperature;
                }
                break;

            default:
                Toast.makeText(this, "Invalid Input Unit", Toast.LENGTH_SHORT).show();
                return;

        }

        resultText.setText(String.format("Converted Temperature: %.2f %s", result , targetUnit));

    }

}
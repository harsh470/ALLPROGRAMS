package com.example.database;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editTextName;
    Button buttonInsert, buttonView;
    TextView textViewData;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        buttonInsert = findViewById(R.id.buttonInsert);
        buttonView = findViewById(R.id.buttonView);
        textViewData = findViewById(R.id.textViewData);

        databaseHelper = new DatabaseHelper(this);

        buttonInsert.setOnClickListener(view -> {
            String name = editTextName.getText().toString();
            if (!name.isEmpty()) {
                boolean result = databaseHelper.insertData(name);
                Toast.makeText(this, result ? "Data Inserted" : "Insertion Failed", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please enter a name", Toast.LENGTH_SHORT).show();
            }
        });
        buttonView.setOnClickListener(view -> displayData());
    }

    private void displayData() {
        Cursor cursor = databaseHelper.getData();
        StringBuilder data = new StringBuilder();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                data.append(cursor.getString(1)).append("\n");
            }
        } else {
            data.append("No data available.");
        }
        textViewData.setText(data.toString());
    }


}
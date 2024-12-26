package com.example.calculator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonAdd, buttonSub, buttonMul, buttonDiv, buttonClear;
    EditText editTextN1, editTextN2;
    TextView textView;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize buttons by finding them in the layout using their IDs.
        buttonAdd = findViewById(R.id.btn_add);
        buttonSub = findViewById(R.id.btn_sub);
        buttonMul = findViewById(R.id.btn_mul);
        buttonDiv = findViewById(R.id.btn_div);

        // Initialize input fields and result display.
        editTextN1 = findViewById(R.id.number1);
        editTextN2 = findViewById(R.id.number2);
        textView = findViewById(R.id.answer);

        // Set click listeners for the buttons, connecting them to this activity's onClick method.
        buttonClear = findViewById(R.id.btn_clear);
        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
        buttonClear.setOnClickListener(this);

    }
    /**
     * A helper method to safely retrieve an integer from an EditText field.
     * @param editText The input field.
     * @return The integer value, or 0 if the input is empty.
     */
    public int getIntegerFromText(EditText editText){
        // Check if the input is empty. If yes, show a Toast message.
        if (editText.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Number", Toast.LENGTH_SHORT).show();
            return 0; // Return 0 if no number is entered.
        }else
            // Parse the input as an integer and return it.
            return Integer.parseInt(editText.getText().toString()) ;
    }

    @Override
    public void onClick(View view) {
        // Retrieve the numbers entered by the user.
        num1 =getIntegerFromText(editTextN1);
        num2 =getIntegerFromText(editTextN2);
        // Perform the appropriate operation based on the button clicked.
        if (view.getId() == R.id.btn_add) {
            textView.setText("Answer = " + (num1 + num2));
        } else if (view.getId() == R.id.btn_sub) {
            textView.setText("Answer = " + (num1 - num2));
        } else if (view.getId() == R.id.btn_mul) {
            textView.setText("Answer = " + (num1 * num2));
        } else if (view.getId() == R.id.btn_div) {
            textView.setText("Answer = " + ((float) num1 / (float) num2));
        } else if (view.getId() == R.id.btn_clear) {
            // Clear the inputs and result
            editTextN1.setText("");
            editTextN2.setText("");
            textView.setText("");
        }

    }
}
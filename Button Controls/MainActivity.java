package com.example.buttons;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTextViewSport;
    private CheckBox checkBoxBalls, checkBoxNets, checkBoxRackets;
    private RadioGroup radioGroupGender;
    private RadioButton radioMale, radioFemale;
    private ToggleButton toggleButtonMembership;
    private ImageButton imageButtonProfile;
    private Button buttonSubmit;
    private EditText userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName =findViewById(R.id.username);
        autoCompleteTextViewSport = findViewById(R.id.autoCompleteTextView_sport);
        checkBoxBalls = findViewById(R.id.checkbox_balls);
        checkBoxNets = findViewById(R.id.checkbox_nets);
        checkBoxRackets = findViewById(R.id.checkbox_rackets);
        radioGroupGender = findViewById(R.id.radioGroup_gender);
        toggleButtonMembership = findViewById(R.id.toggleButton_membership);
        imageButtonProfile = findViewById(R.id.imageButton_profile);
        buttonSubmit = findViewById(R.id.button_submit);

        //AutoCompleteTextView
        String[] sports = {"Soccer", "Basketball", "Tennis", "Cricket", "Baseball"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, sports);
        autoCompleteTextViewSport.setAdapter(adapter);
        buttonSubmit.setOnClickListener(view -> submitForm());
    }

    // form submission
    private void submitForm() {
        String selectedSport = autoCompleteTextViewSport.getText().toString();
        String selectedName = userName.getText().toString();
        // Get selected equipment
        StringBuilder equipment = new StringBuilder();
        if (checkBoxBalls.isChecked()) equipment.append("Balls ");
        if (checkBoxNets.isChecked()) equipment.append("Nets ");
        if (checkBoxRackets.isChecked()) equipment.append("Rackets ");

        // Get selected gender
        int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
        String gender = "";
        if (selectedGenderId == R.id.radio_male) gender = "Male";
        else if (selectedGenderId == R.id.radio_female) gender = "Female";

        // Get membership status
        String membershipStatus = toggleButtonMembership.isChecked() ? "Member" : "Not a Member";

        // Display the form data in a Toast (just for demonstration purposes)
        String message = "Username: " +selectedName + "\n" +
                "Sport: " + selectedSport + "\n" +
                "Equipment: " + equipment.toString() + "\n" +
                "Gender: " + gender + "\n" +
                "Membership: " + membershipStatus;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}

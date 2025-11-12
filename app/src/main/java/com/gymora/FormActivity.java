package com.gymora;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    private EditText nameEditText, ageEditText, weightEditText, heightEditText;
    private Spinner genderSpinner, levelSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        nameEditText = findViewById(R.id.editTextText);
        ageEditText = findViewById(R.id.editTextText2);
        weightEditText = findViewById(R.id.editTextText4);
        heightEditText = findViewById(R.id.editTextText5);
        genderSpinner = findViewById(R.id.spinner1);
        levelSpinner = findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                this,
                R.array.my_items1,
                R.layout.custom_spinner_item
        );
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                this,
                R.array.my_items2,
                R.layout.custom_spinner_item
        );
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        levelSpinner.setAdapter(adapter2);

        Button submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(v -> {
            if (validateInputs()) {
                Toast.makeText(FormActivity.this, "Form Submitted!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FormActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean validateInputs() {
        if (TextUtils.isEmpty(nameEditText.getText().toString().trim())) {
            nameEditText.setError("Name is required.");
            return false;
        }

        if (TextUtils.isEmpty(ageEditText.getText().toString().trim())) {
            ageEditText.setError("Age is required.");
            return false;
        }

        if (TextUtils.isEmpty(weightEditText.getText().toString().trim())) {
            weightEditText.setError("Weight is required.");
            return false;
        }

        if (TextUtils.isEmpty(heightEditText.getText().toString().trim())) {
            heightEditText.setError("Height is required.");
            return false;
        }

        if (genderSpinner.getSelectedItemPosition() == 0) {
            ((TextView) genderSpinner.getSelectedView()).setError("Please select a gender.");
            return false;
        }

        if (levelSpinner.getSelectedItemPosition() == 0) {
            ((TextView) levelSpinner.getSelectedView()).setError("Please select a level.");
            return false;
        }

        return true;
    }
}

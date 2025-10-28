package com.gymora;

// Make sure these are imported
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        // --- SPINNER SETUP (The Easy Way) ---

        // 1. Find your Spinners
        Spinner spinner1 = findViewById(R.id.spinner1);
        Spinner spinner2 = findViewById(R.id.spinner2);

        // 2. Create an adapter for the first spinner
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                this,
                R.array.my_items1, // Your data from strings.xml
                R.layout.custom_spinner_item // YOUR NEW CUSTOM LAYOUT
        );
        // Set the layout for the dropdown list itself
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // 3. Create an adapter for the second spinner
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                this,
                R.array.my_items2, // Your data from strings.xml
                R.layout.custom_spinner_item // RE-USE THE SAME CUSTOM LAYOUT
        );
        // Set the layout for the dropdown list itself
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // 4. Apply the adapters to the Spinners
        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);


        // --- YOUR EXISTING BUTTON LOGIC ---
        Button submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(v -> {
            Toast.makeText(FormActivity.this, "Form Submitted!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(FormActivity.this, HomeActivity.class);
            startActivity(intent);
        });
    }
}

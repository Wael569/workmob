package com.gymora;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        // Set the content view to your new form layout
        setContentView(R.layout.activity_form);

        // Apply window insets to the root layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.form_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Optional: Add functionality to the submit button
        Button submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(v -> {
            // You can add logic here to handle the form submission
            Toast.makeText(FormActivity.this, "Form Submitted! Taking you home ..", Toast.LENGTH_SHORT).show();

            });
        Button submit_button = findViewById(R.id.submit_button);
        submit_button.setOnClickListener(v -> {
            Intent intent = new Intent(FormActivity.this, HomeActivity.class);
            startActivity(intent);
        });
    }
}

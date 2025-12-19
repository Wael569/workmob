package com.gymora;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LegsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_legs);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Back Button
        ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish());

        // Programme Buttons
        Button programme1Button = findViewById(R.id.button_programme_c1);
        Button programme2Button = findViewById(R.id.button_programme_c2);
        Button programme3Button = findViewById(R.id.button_programme_c3);
        Button programme4Button = findViewById(R.id.button_programme_c4);

        programme1Button.setOnClickListener(v -> {
            startActivity(new Intent(LegsActivity.this, ProgrammeC1Activity.class));
        });

        programme2Button.setOnClickListener(v -> {
            startActivity(new Intent(LegsActivity.this, ProgrammeC2Activity.class));
        });

        programme3Button.setOnClickListener(v -> {
            startActivity(new Intent(LegsActivity.this, ProgrammeC3Activity.class));
        });

        programme4Button.setOnClickListener(v -> {
            startActivity(new Intent(LegsActivity.this, ProgrammeC4Activity.class));
        });
    }
}
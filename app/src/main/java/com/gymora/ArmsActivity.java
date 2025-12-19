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

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ArmsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_arms);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Back Button
        ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish());

        // Programme Buttons
        Button programme1Button = findViewById(R.id.button_programme);
        Button programme2Button = findViewById(R.id.button_programme5);
        Button programme3Button = findViewById(R.id.button_programme6);
        Button programme4Button = findViewById(R.id.button_programme7);

        programme1Button.setOnClickListener(v -> {
            startActivity(new Intent(ArmsActivity.this, ProgrammeA1Activity.class));
        });

        programme2Button.setOnClickListener(v -> {
            startActivity(new Intent(ArmsActivity.this, ProgrammeA2Activity.class));
        });

        programme3Button.setOnClickListener(v -> {
            startActivity(new Intent(ArmsActivity.this, ProgrammeA3Activity.class));
        });

        programme4Button.setOnClickListener(v -> {
            startActivity(new Intent(ArmsActivity.this, ProgrammeA4Activity.class));
        });

        // Bottom Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_training) {
                startActivity(new Intent(ArmsActivity.this, HomeActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                return true;
            } else if (itemId == R.id.navigation_meals) {
                startActivity(new Intent(ArmsActivity.this, MealsActivity.class));
                return true;
            } else if (itemId == R.id.navigation_menu) {
                startActivity(new Intent(ArmsActivity.this, MenuActivity.class));
                return true;
            }
            return false;
        });
    }
}

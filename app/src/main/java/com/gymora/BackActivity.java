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

public class BackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_back);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Back Button
        ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish());

        // Programme Buttons
        Button programme1Button = findViewById(R.id.button_programme1);
        Button programme2Button = findViewById(R.id.button_programme2);
        Button programme3Button = findViewById(R.id.button_programme3);

        programme1Button.setOnClickListener(v -> {
            Intent intent = new Intent(BackActivity.this, BProgramme1Activity.class);
            startActivity(intent);
        });

        programme2Button.setOnClickListener(v -> {
            Intent intent = new Intent(BackActivity.this, BProgramme2Activity.class);
            startActivity(intent);
        });

        programme3Button.setOnClickListener(v -> {
            Intent intent = new Intent(BackActivity.this, BProgramme3Activity.class);
            startActivity(intent);
        });

        // Bottom Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_training) {
                startActivity(new Intent(BackActivity.this, HomeActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                return true;
            } else if (itemId == R.id.navigation_meals) {
                startActivity(new Intent(BackActivity.this, MealsActivity.class));
                return true;
            } else if (itemId == R.id.navigation_menu) {
                startActivity(new Intent(BackActivity.this, MenuActivity.class));
                return true;
            }
            return false;
        });
    }
}
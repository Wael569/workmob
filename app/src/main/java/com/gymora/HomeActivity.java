package com.gymora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // --- Link Cards to their Specific Activities ---
        // Only setting up listeners for the cards that still exist.
        setupCardClickListener(R.id.card_chest, ChestActivity.class);
        setupCardClickListener(R.id.card_back, BackActivity.class);
        setupCardClickListener(R.id.card_arms, ArmsActivity.class);
        setupCardClickListener(R.id.card_legs, LegsActivity.class);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setSelectedItemId(R.id.navigation_training);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_meals) {
                Intent intent = new Intent(HomeActivity.this, MealsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                return true;
            } else if (itemId == R.id.navigation_menu) {
                Intent intent = new Intent(HomeActivity.this, MenuActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                return true;
            } else if (itemId == R.id.navigation_training) {
                return true;
            }
            return false;
        });
    }

    // Helper for specific Activity classes
    private void setupCardClickListener(int cardId, Class<?> targetActivity) {
        CardView card = findViewById(cardId);
        if (card != null) {
            card.setOnClickListener(v -> {
                Intent intent = new Intent(HomeActivity.this, targetActivity);
                startActivity(intent);
            });
        }
    }
}

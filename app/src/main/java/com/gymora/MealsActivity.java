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

public class MealsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_meals);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.meals_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Link Cards to their specific Activities
        setupCardClickListener(R.id.card_meals1, Meals1Activity.class);
        setupCardClickListener(R.id.card_meals2, Meals2Activity.class);
        setupCardClickListener(R.id.card_meals3, Meals3Activity.class);
        setupCardClickListener(R.id.card_meals4, Meals4Activity.class);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setSelectedItemId(R.id.navigation_meals);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_training) {
                Intent intent = new Intent(MealsActivity.this, HomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                return true;
            } else if (itemId == R.id.navigation_menu) {
                Intent intent = new Intent(MealsActivity.this, MenuActivity.class);
                startActivity(intent);
                return true;
            }
            return false;
        });
    }

    private void setupCardClickListener(int cardId, Class<?> targetActivity) {
        CardView card = findViewById(cardId);
        if (card != null) {
            card.setOnClickListener(v -> {
                Intent intent = new Intent(MealsActivity.this, targetActivity);
                startActivity(intent);
            });
        }
    }
}
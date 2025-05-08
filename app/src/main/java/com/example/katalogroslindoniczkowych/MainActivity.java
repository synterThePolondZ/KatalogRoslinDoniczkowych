package com.example.mojerosliny;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.katalogroslindoniczkowych.R;

public class MainActivity extends AppCompatActivity {

    private int favoriteCount = 0;
    private TextView favoriteCountText;
    private Button addFavoriteBtn;
    private Button removeFavoriteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            favoriteCountText = findViewById(R.id.favoriteCount);
            addFavoriteBtn = findViewById(R.id.addFavorite);
            removeFavoriteBtn = findViewById(R.id.removeFavorite);

            addFavoriteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    favoriteCount++;
                    updateFavoriteText();
                }
            });

            removeFavoriteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (favoriteCount > 0) {
                        favoriteCount--;
                        updateFavoriteText();
                    }
                }
            });
        } catch (Exception e) {
            Log.e("MainActivity", "Błąd inicjalizacji UI: " + e.getMessage());
        }
    }

    private void updateFavoriteText() {
        favoriteCountText.setText("Liczba w ulubionych: " + favoriteCount);
    }
}

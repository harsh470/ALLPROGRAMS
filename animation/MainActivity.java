package com.example.animation;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private TextView animatedText;
    private Button startAnimationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animatedText = findViewById(R.id.animatedText);
        startAnimationButton = findViewById(R.id.startAnimationButton);

        // Set click listener to start the animation
        startAnimationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation();
            }
        });
    }

    private void startAnimation() {
        // Create a TranslateAnimation: (fromX, toX, fromY, toY)
        TranslateAnimation animation = new TranslateAnimation(0, 300, 0, 0);
        animation.setDuration(1000); // Duration in milliseconds
        animation.setFillAfter(true); // Keep the final position after animation
        animatedText.startAnimation(animation);

    }
}
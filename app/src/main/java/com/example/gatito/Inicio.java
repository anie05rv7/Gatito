package com.example.gatito;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Inicio extends AppCompatActivity {

    private static final int COUNTDOWN_SECONDS = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        final TextView countdownText = findViewById(R.id.countdownText);

        new CountDownTimer(COUNTDOWN_SECONDS * 1000, 1000) {
            public void onTick(long millisUntilFinished) {
                int secondsRemaining = (int) (millisUntilFinished / 1000);
                countdownText.setText(String.valueOf(secondsRemaining));
            }

            public void onFinish() {
                // Cuando finalice el contador, inicia la actividad "jugadores"
                Intent intent = new Intent(Inicio.this, jugadores.class);
                startActivity(intent);
                finish(); // Finaliza la actividad actual (Inicio) si no deseas volver a ella
            }
        }.start();
    }
}

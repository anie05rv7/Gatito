package com.example.gatito;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.app.Activity;


public class resultados extends Dialog {
    private String message;
    private MainActivity mainActivity;

    public resultados(Context context, String message, MainActivity mainActivity) {
        super(context);
        this.message = message;
        this.mainActivity = mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        TextView messageText = findViewById(R.id.messageText);
        Button startAgainButton = findViewById(R.id.startAgainButton);
        Button exitGameButton = findViewById(R.id.exitGameButton); // Botón "Salir del juego"

        messageText.setText(message);

        startAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mainActivity != null) {
                    mainActivity.restartMatch();
                }
                dismiss();
            }
        });

        exitGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cierra todas las actividades y finaliza la aplicación
                System.exit(0);
            }
        });


    }
}
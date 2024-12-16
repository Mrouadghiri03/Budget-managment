package com.example.floussyy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TraitementWarning extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traitement_warning);


        // Récupérer le TextView où afficher la valeur
        TextView resultTextView = findViewById(R.id.TextResult);

        // Récupérer la valeur envoyée par l'Intent
        String warningValue = getIntent().getStringExtra("warning_value");

        // Afficher la valeur dans le TextView
        resultTextView.setText("THE POURCENT FOR ALERT IS " + warningValue +"%");
    }
}
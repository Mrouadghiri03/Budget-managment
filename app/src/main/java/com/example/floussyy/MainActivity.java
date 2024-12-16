package com.example.floussyy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialiser les vues
        EditText editTextUsername = findViewById(R.id.input_username);
        EditText editTextPassword = findViewById(R.id.input_password);
        Button btnLogin = findViewById(R.id.button_send);

        // Définir le clic sur le bouton
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupérer les valeurs des champs
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                // Vérifier si les champs sont vides

                    // Créer l'Intent pour lancer NavigationdrawerActivity
                    Intent intent = new Intent(MainActivity.this, NavigationdrawerActivity.class);
                    intent.putExtra("username_value", username);
                    intent.putExtra("password_value", password);
                    startActivity(intent); // Lancer l'activité
                }

        });
    }

    */
   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       EditText editTextUsername = findViewById(R.id.input_username);
       EditText editTextPassword = findViewById(R.id.input_password);
       Button btnLogin = findViewById(R.id.button_send);

       btnLogin.setOnClickListener(v -> {
           String username = editTextUsername.getText().toString();
           String password = editTextPassword.getText().toString();

           // Sauvegarder les données utilisateur dans SharedPreferences
           getSharedPreferences("UserPrefs", MODE_PRIVATE)
                   .edit()
                   .putString("username", username)
                   .putString("password", password)
                   .apply();

           // Démarrer NavigationdrawerActivity
           Intent intent = new Intent(MainActivity.this, NavigationdrawerActivity.class);
           startActivity(intent);
       });
   }


}

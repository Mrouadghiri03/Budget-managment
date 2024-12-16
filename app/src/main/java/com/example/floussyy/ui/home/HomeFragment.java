package com.example.floussyy.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.ViewModelProvider;

import com.example.floussyy.R;
import com.example.floussyy.databinding.FragmentHomeBinding;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        TextView textView = root.findViewById(R.id.text_home);
        TextView textView_time = root.findViewById(R.id.text_time);

        // Récupérer les données passées dans le bundle
        Bundle arguments = getArguments();
        if (arguments != null) {
            String username = arguments.getString("username", "Utilisateur inconnu");
            String password = arguments.getString("password", "Mot de passe non défini");
            textView.setText("Username: " + username + "\nPassword: " + password);
            Date now = new Date();

// Définir un format pour la date et l'heure
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

// Convertir la date en chaîne formatée
            String formattedDate = sdf.format(now);

// Afficher la date formatée dans le TextView
            textView_time.setText(formattedDate);        }
        else {
            Date now = new Date();

// Définir un format pour la date et l'heure
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

// Convertir la date en chaîne formatée
            String formattedDate = sdf.format(now);

// Afficher la date formatée dans le TextView
            textView_time.setText(formattedDate);
            textView.setText("Bienvenue dans Home");
        }

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
package com.example.floussyy.ui.logout;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.floussyy.MainActivity;
import com.example.floussyy.NavigationdrawerActivity;
import com.example.floussyy.R;
import com.example.floussyy.TraitementIncome;
import com.example.floussyy.TraitementLogout;
import com.example.floussyy.ui.home.HomeFragment;

public class LogoutFragment extends Fragment {

    private LogoutViewModel mViewModel;

    public static LogoutFragment newInstance() {
        return new LogoutFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_logout, container, false);
        Button btn_valider=view.findViewById(R.id.button_valider_logout);
        Button btn_annuler=view.findViewById(R.id.button_annuler_logout);

       /* btn_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // Démarrer la nouvelle activité avec l'Intent
                Intent intent = new Intent(getContext(), MainActivity.class);
                Toast.makeText(MainActivity.this,"Logout",Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
        btn_annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Démarrer la nouvelle activité avec l'Intent
                Intent intent = new Intent(getContext(), HomeFragment.class);

                startActivity(intent);
                Toast.makeText(HomeFragment.this,"Logout",Toast.LENGTH_LONG).show();
            }
        });

        */
        btn_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Démarrer la nouvelle activité avec l'Intent
                Intent intent = new Intent(getContext(), MainActivity.class);
                Toast.makeText(getContext(), "Logout succes,Login now", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });

        btn_annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Naviguer vers le fragment Home
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_content_navigation_drawer);
                navController.navigate(R.id.nav_home); // ID du HomeFragment dans navigation.xml

                Toast.makeText(getContext(), "Retour à Home", Toast.LENGTH_LONG).show();
            }
        });


        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(LogoutViewModel.class);
        // TODO: Use the ViewModel
    }

}
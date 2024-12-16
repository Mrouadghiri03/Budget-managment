package com.example.floussyy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Menu;
import android.support.design.widget.Snackbar;
import android.support.design.widget.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.floussyy.databinding.ActivityNavigationDrawerBinding;

public class NavigationdrawerActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityNavigationDrawerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNavigationDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarNavigationDrawer.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_goal,
                R.id.nav_income, R.id.nav_spending, R.id.nav_warning,
                R.id.nav_userdata, R.id.nav_transactions, R.id.nav_logout)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation_drawer);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        // Lire les données de SharedPreferences
        String username = getSharedPreferences("UserPrefs", MODE_PRIVATE).getString("username", "");
        String password = getSharedPreferences("UserPrefs", MODE_PRIVATE).getString("password", "");

        // Ajouter les données à HomeFragment au démarrage
        if (savedInstanceState == null) {
            Bundle bundle = new Bundle();
            bundle.putString("username", username);
            bundle.putString("password", password);
            navController.navigate(R.id.nav_home, bundle);
        }

       /* super.onCreate(savedInstanceState);

        binding = ActivityNavigationDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarNavigationDrawer.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_goal,
                R.id.nav_income, R.id.nav_spending, R.id.nav_warning,
                R.id.nav_userdata, R.id.nav_transactions, R.id.nav_logout)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation_drawer);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        // Récupérer les données transmises par l'intent
        Intent intent = getIntent();
        String username = intent.getStringExtra("username_value");
        String password = intent.getStringExtra("password_value");

        // Ajouter cette logique pour transmettre les données au premier démarrage
        if (savedInstanceState == null) { // Vérifie si l'activité est démarrée pour la première fois
            Bundle bundle = new Bundle();
            bundle.putString("username", username);
            bundle.putString("password", password);

            // Naviguer vers HomeFragment avec les données
            navController.navigate(R.id.nav_home, bundle);
        }
        */
        /*
        super.onCreate(savedInstanceState);

        binding = ActivityNavigationDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarNavigationDrawer.toolbar);
        binding.appBarNavigationDrawer.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,R.id.nav_goal,
                R.id.nav_income,R.id.nav_spending,R.id.nav_warning
        ,R.id.nav_userdata,R.id.nav_transactions,R.id.nav_logout)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation_drawer);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        // Récupérer les données transmises par l'intent
        Intent intent = getIntent();
        String username = intent.getStringExtra("username_value");
        String password = intent.getStringExtra("password_value");
*/
        // Transmettre les données au HomeFragment
      /*  navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.nav_home) { // Vérifier si on navigue vers MarhabaFragment
                Bundle bundle = new Bundle();
                bundle.putString("username", username);
                bundle.putString("password", password);
                navController.navigate(R.id.nav_home, bundle); // Ajouter les données
            }
        });

       */
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.nav_home) {
                // Vous pouvez ajouter un Toast ou une autre action ici si nécessaire.
                Toast.makeText(this, "Bienvenue dans Home", Toast.LENGTH_SHORT).show();
            }
        });


        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                int menuID=destination.getId();
                switch (menuID) {
                    case R.id.nav_gallery:
                        Toast.makeText(NavigationdrawerActivity.this, "Gallery", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_home:
                        Toast.makeText(NavigationdrawerActivity.this, "Home", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_slideshow:
                        Toast.makeText(NavigationdrawerActivity.this, "Slideshow", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_income:
                        Toast.makeText(NavigationdrawerActivity.this,"Income",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_goal:
                        Toast.makeText(NavigationdrawerActivity.this,"Goal",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_spending:
                        Toast.makeText(NavigationdrawerActivity.this,"Spending",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_warning:
                        Toast.makeText(NavigationdrawerActivity.this,"Warning",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_logout:
                        Toast.makeText(NavigationdrawerActivity.this,"Logout",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_userdata:
                        Toast.makeText(NavigationdrawerActivity.this,"User DATA",Toast.LENGTH_LONG).show();
                        break;

                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigationdrawer, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation_drawer);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
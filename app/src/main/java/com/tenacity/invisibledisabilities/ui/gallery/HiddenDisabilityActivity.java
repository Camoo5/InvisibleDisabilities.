package com.tenacity.invisibledisabilities.ui.gallery;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.tenacity.invisibledisabilities.R;
import com.tenacity.invisibledisabilities.databinding.ActivityHiddenDisabilityBinding;



public class HiddenDisabilityActivity extends AppCompatActivity {


    private NavController navController;
    private DrawerLayout drawerLayout;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityHiddenDisabilityBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_hidden_disability);
        this.drawerLayout = binding.drawerLayout;



        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.my_nav_host_fragment);
        NavController navController = navHostFragment.getNavController();
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).setDrawerLayout(drawerLayout).build();

        // Set up ActionBar
        setSupportActionBar(binding.toolbar);

        // Initialize the app bar with the navigation drawer if present.
        // If the drawerLayout is not null here, a Navigation button will be added to
        // the app bar whenever the user is on a top-level destination
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Initialize the NavigationView if it is present,
        // so that clicking an item takes
        // the user to the appropriate destination.
        NavigationView navView = findViewById(R.id.nav_view);
        NavigationUI.setupWithNavController(binding.navView, navController);



    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.my_nav_host_fragment);
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }



        }
    }





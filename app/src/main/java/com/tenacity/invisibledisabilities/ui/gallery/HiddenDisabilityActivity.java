package com.tenacity.invisibledisabilities.ui.gallery;


import static androidx.navigation.ui.NavigationUI.navigateUp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.tenacity.invisibledisabilities.R;
import com.tenacity.invisibledisabilities.databinding.ActivityHiddenDisabilityBinding;



public class HiddenDisabilityActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private AppBarConfiguration appBarConfiguration;
    private NavController navController;




    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityHiddenDisabilityBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_hidden_disability);
this.drawerLayout = binding.drawerLayout;

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.hidden_disability_nav_fragment);
        NavController navController = navHostFragment.getNavController();

       this.appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout(drawerLayout).build();




        // Set u ActionBar
        Toolbar Toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(Toolbar);

        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationUI.setupActionBarWithNavController(this,navController, appBarConfiguration);

        // Set up navigation menu
        NavigationView navView = findViewById(R.id.nav_view);

    }

    @Override
    public boolean onSupportNavigateUp() {
        return navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
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



package com.tenacity.invisibledisabilities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.tenacity.invisibledisabilities.databinding.ActivityHiddenDisabilityBinding;


public class HiddenDisabilityActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private AppBarConfiguration appBarConfiguration;
    private NavController navController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityHiddenDisabilityBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_hidden_disability );
        this.drawerLayout = binding.drawerLayout;
        this.navController = Navigation.findNavController(this, R.id.hidden_disability_nav_host_fragment);
        this.navController = Navigation.findNavController(this, R.id.coping_strategy_fragment);
        this.navController = Navigation.findNavController(this, R.id.criteria_one_fragment);
        this.navController = Navigation.findNavController(this, R.id.criteria_two_fragment);
        this.navController = Navigation.findNavController(this, R.id.extension_to_blue_badge_fragment);
        this.navController = Navigation.findNavController(this, R.id.practitioners_fragment);
        this.navController = Navigation.findNavController(this, R.id.sub_considerations_fragment);
        this.navController = Navigation.findNavController(this, R.id.supporting_evidence_fragment);

        this.appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).setOpenableLayout (drawerLayout).build();

        // Set up ActionBar
        setSupportActionBar(binding.toolbar);
        NavigationUI.setupActionBarWithNavController(this, this.navController, this.appBarConfiguration);
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set up navigation menu
        NavigationUI.setupWithNavController(binding.navigationView, this.navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen( GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    }

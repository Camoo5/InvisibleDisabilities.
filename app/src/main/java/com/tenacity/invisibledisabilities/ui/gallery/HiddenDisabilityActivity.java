package com.tenacity.invisibledisabilities.ui.gallery;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.tenacity.invisibledisabilities.R;
import com.tenacity.invisibledisabilities.databinding.ActivityHiddenDisabilityBinding;



public class HiddenDisabilityActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private NavController mNavController;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityHiddenDisabilityBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_hidden_disability);
        mDrawerLayout = binding.drawerLayout;

        setSupportActionBar(binding.toolbar);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.hidden_disability_nav_fragment);
        NavController navController = navHostFragment.getNavController();



        // Set u ActionBar
        Toolbar Toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(Toolbar);

        NavigationUI.setupActionBarWithNavController(this, mNavController, mDrawerLayout);
        NavigationUI.setupWithNavController(binding.navView, mNavController);

    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(mNavController, mDrawerLayout);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}



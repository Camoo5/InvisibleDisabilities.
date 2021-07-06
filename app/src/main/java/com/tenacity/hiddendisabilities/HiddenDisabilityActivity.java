package com.tenacity.hiddendisabilities;

import android.os.Bundle;
import android.widget.Toolbar;

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

import com.tenacity.hiddendisabilities.databinding.ActivityHiddenDisabilityBinding;

import java.util.Objects;

import static java.util.Objects.*;


public class HiddenDisabilityActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private AppBarConfiguration appBarConfiguration;
    private NavController navController;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );

        ActivityHiddenDisabilityBinding binding = DataBindingUtil.setContentView ( this, R.layout.activity_hidden_disability );
        this.drawerLayout = ( binding.drawerLayout );
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager ().findFragmentById ( R.id.nav_host_fragment );
        NavController navController = navHostFragment.getNavController();
        appBarConfiguration = new AppBarConfiguration.Builder ( navController.getGraph ()).setDrawerLayout ( drawerLayout ).build ();

        // Set up ActionBar
        setSupportActionBar(binding.toolbar);
        NavigationUI.setupActionBarWithNavController ( this, navController, appBarConfiguration );
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Set up navigation menu
        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration);


    }
        @Override
        public boolean onSupportNavigateUp ( ) {
            NavController navController = Navigation.findNavController ( this, R.id.nav_host_fragment );
            return NavigationUI.navigateUp ( navController, appBarConfiguration )
                    || super.onSupportNavigateUp ();
        }

        @Override
        public void onBackPressed ( ) {
            if (drawerLayout.isDrawerOpen ( GravityCompat.START )) {
                drawerLayout.closeDrawer ( GravityCompat.START );
            } else {
                super.onBackPressed ();
            }
        }
    }



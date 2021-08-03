package com.tenacity.invisibledisabilities;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.tenacity.invisibledisabilities.R;


public class HiddenDisabilityActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private AppBarConfiguration appBarConfiguration;
    private NavController navController;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate ( savedInstanceState );
      setContentView ( R.layout.activity_hidden_disability );


        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager ().findFragmentById ( R.id.nav_host_fragment );
        NavController navController = navHostFragment.getNavController();
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
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



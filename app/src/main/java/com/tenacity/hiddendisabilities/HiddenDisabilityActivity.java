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


public class HiddenDisabilityActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private AppBarConfiguration appBarConfiguration;
    private NavController navController;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );

        ActivityHiddenDisabilityBinding binding = DataBindingUtil.setContentView ( this, R.layout.activity_hidden_disability );
        this.drawerLayout = binding.drawerLayout;
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager ().findFragmentById ( R.id.nav_host_fragment );
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder ( navController.getGraph ()).setDrawerLayout ( drawerLayout ).build ();
        NavigationUI.setupActionBarWithNavController ( this, navController, appBarConfiguration );

        Toolbar toolbar = findViewById ( R.id.toolbar );

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



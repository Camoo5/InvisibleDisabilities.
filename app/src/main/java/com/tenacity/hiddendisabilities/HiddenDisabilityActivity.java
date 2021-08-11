package com.tenacity.invisibledisabilities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.tenacity.invisibledisabilities.databinding.ActivityHiddenDisabilityBinding;


public class HiddenDisabilityActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private NavController mNavController;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate ( savedInstanceState );

        ActivityHiddenDisabilityBinding binding = DataBindingUtil.setContentView (this, R.layout.activity_hidden_disability);
        mDrawerLayout = binding.drawerLayout;

        setSupportActionBar(binding.toolbar);
        mNavController = Navigation.findNavController(this, R.id.hidden_disability_fragment);
        NavigationUI.setupActionBarWithNavController(this, mNavController, mDrawerLayout);
        NavigationUI.setupWithNavController(binding.navigationView, mNavController);



    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(mNavController, mDrawerLayout);
    }


        @Override
        public void onBackPressed ( ) {
            if (mDrawerLayout.isDrawerOpen ( GravityCompat.START )) {
                mDrawerLayout.closeDrawer ( GravityCompat.START );
            } else {
                super.onBackPressed ();
            }
        }
    }



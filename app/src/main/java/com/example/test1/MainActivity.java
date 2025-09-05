package com.example.test1;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener,
        NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private BottomNavigationView bottomNavigationView;
    private NavigationView navigationView;

    HomeFragment homeFragment = new HomeFragment();
    PersonFragment personFragment = new PersonFragment();
    SettingFragment settingFragment = new SettingFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.person);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.open_nav, R.string.close_nav
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.flFragment, personFragment)
                    .commit();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {

            case R.id.person:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment, personFragment)
                        .commit();
                return true;

            case R.id.home:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment, homeFragment)
                        .commit();
                navigationView.setCheckedItem(R.id.nav_home);
                return true;

            case R.id.settings:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment, settingFragment)
                        .commit();
                navigationView.setCheckedItem(R.id.nav_settings);
                return true;

            case R.id.nav_home:
                bottomNavigationView.setSelectedItemId(R.id.home);
                break;

            case R.id.nav_settings:
                bottomNavigationView.setSelectedItemId(R.id.settings);
                break;

            case R.id.nav_share:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment, new ShereFragment())
                        .commit();
                break;

            case R.id.nav_about:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFragment, new AboutFragment())
                        .commit();
                break;

            case R.id.nav_logout:
                Toast.makeText(this, "Logout ?", Toast.LENGTH_SHORT).show();
                break;
        }

        drawerLayout.closeDrawers();
        return true;
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
            return;
        }

        int selectedItemId = bottomNavigationView.getSelectedItemId();


        if (selectedItemId != R.id.home) {
            bottomNavigationView.setSelectedItemId(R.id.home);
            return;
        }


        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.flFragment);
        if (currentFragment instanceof HomeFragment) {
            if (((HomeFragment) currentFragment).handleBackPressed()) {
                return;

            }
        }


        super.onBackPressed();
    }
}

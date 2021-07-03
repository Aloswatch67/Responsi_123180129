package com.example.covid.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.covid.R;
import com.example.covid.view.fragment.RujukFragment;
import com.example.covid.view.fragment.KasusFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener
{

    private BottomNavigationView navbar;
    private Fragment fragment = new KasusFragment() ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        navbar = findViewById(R.id.activitymain_bottomnav);
        navbar.setOnNavigationItemSelectedListener(this);

        loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment)
    {
        if(fragment != null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activitymain_fragment, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_botnav_kasus:
                fragment = new KasusFragment();
                break;

            case R.id.menu_botnav_rujuk:
                fragment = new RujukFragment();
        }
        return loadFragment(fragment);
    }
}
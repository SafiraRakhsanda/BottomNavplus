package com.example.bottomnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new FragmentHome());
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnav_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }


    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_layout, fragment)
                    .commit();
            return true;
        }

        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.home :
                fragment = new FragmentHome();
                break;
            case R.id.sholat :
                fragment = new FragmentSholat();
                break;
            case R.id.kiblat :
                fragment = new FragmentKiblat();
                break;
            case R.id.kesehatan :
                fragment = new FragmentHealth();
                break;
            case R.id.author :
                fragment = new FragmentUser();
                break;
        }

        return loadFragment(fragment);
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu, menu);
        super.onCreateOptionsMenu(menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId()== R.id.daftar){
            startActivity(new Intent(this, DaftarIsi.class));
        } else if (item.getItemId() == R.id.rate){
            startActivity(new Intent(this, Rate.class));
        }else if (item.getItemId() == R.id.tentang){
            startActivity(new Intent(this,Tentang.class));
        }else if (item.getItemId() == R.id.search){
            startActivity(new Intent(this, search.class));
        }
        return true;
    }
}

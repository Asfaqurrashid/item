package com.example.item;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomnav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new HomeFragment());
        bottomnav = (BottomNavigationView)findViewById(R.id.navigation);
        bottomnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                Fragment fragment = null;
                if(id == R.id.nav_account)
                {
                    fragment = new AccountFragment();
                    loadFragment(fragment);
                    return true;
                }
                else if(id == R.id.nav_home)
                {
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;
                }
                else if(id == R.id.nav_chart)
                {
                    fragment = new ChartFragment();
                    loadFragment(fragment);
                    return true;
                }
                else if(id==R.id.nav_search)
                {
                    fragment = new SearchFragment();
                    loadFragment(fragment);
                    return true;
                }
                else
                {
                    return false;
                }
            }
        });
    }

    private boolean loadFragment(Fragment fragment)
    {
        if(fragment!=null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            return true;
        }
        return false;
    }


}

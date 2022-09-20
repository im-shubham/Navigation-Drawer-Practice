package com.shubham.fragmentspractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;
import com.sdsmdg.tastytoast.TastyToast;
import com.shubham.fragmentspractice.fragments.SharedWithMeFragment;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.OpenDrawer,R.string.CloseDrawer);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if(id==R.id.myFiles){

                    TastyToast.makeText(MainActivity.this,"My Files Clicked ",TastyToast.LENGTH_LONG,TastyToast.SUCCESS);
                }else if(id == R.id.sharedWithMe){
                    loadFragment(new SharedWithMeFragment());
                    TastyToast.makeText(MainActivity.this,"SharedWithMeFragment Clicked ",TastyToast.LENGTH_LONG,TastyToast.SUCCESS);
                }else if(id == R.id.recent){

                    TastyToast.makeText(MainActivity.this,"Recent Fragment Clicked ",TastyToast.LENGTH_LONG,TastyToast.SUCCESS);

                }else if(id == R.id.trash){

                    TastyToast.makeText(MainActivity.this,"Trash Fragment Clicked ",TastyToast.LENGTH_LONG,TastyToast.SUCCESS);
                }else if(id == R.id.logOut){

                    TastyToast.makeText(MainActivity.this,"Logout Fragment Clicked ",TastyToast.LENGTH_LONG,TastyToast.SUCCESS);
                }
                drawerLayout.closeDrawer(GravityCompat.START);


                return true;
            }
        });

    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    private void loadFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, fragment);
        fragmentTransaction.commit();

    }
}
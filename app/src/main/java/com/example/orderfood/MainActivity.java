package com.example.orderfood;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.orderfood.fragment.MonAnFragment;
import com.example.orderfood.fragment.BanAnFragment;
import com.example.orderfood.fragment.NhanVienFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    DrawerLayout drawer;
    Toolbar toolbar;
    NavigationView navigationView;
    FragmentManager fragmentActivity;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        fragmentActivity = getSupportFragmentManager();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.mo, R.string.dong){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        drawer.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentTransaction tranHienThiBanAn = fragmentActivity.beginTransaction();
        BanAnFragment banAnFragment = new BanAnFragment();
        tranHienThiBanAn.replace(R.id.nav_host_fragment, banAnFragment);
        tranHienThiBanAn.commit();
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        FragmentTransaction tranHienThiBanAn ;
        switch (id){
            case R.id.ban_an:
                tranHienThiBanAn = fragmentActivity.beginTransaction();
                BanAnFragment banAnFragment = new BanAnFragment();
                tranHienThiBanAn.replace(R.id.nav_host_fragment, banAnFragment);
                tranHienThiBanAn.commit();

                drawer.closeDrawers();
                break;
            case R.id.mon_an:
                tranHienThiBanAn = fragmentActivity.beginTransaction();
                MonAnFragment monAnFragment = new MonAnFragment();
                tranHienThiBanAn.replace(R.id.nav_host_fragment, monAnFragment);
                tranHienThiBanAn.commit();

                drawer.closeDrawers();
                break;
            case R.id.nhan_vien:
                tranHienThiBanAn = fragmentActivity.beginTransaction();
                NhanVienFragment nhanVienFragment = new NhanVienFragment();
                tranHienThiBanAn.replace(R.id.nav_host_fragment, nhanVienFragment);
                tranHienThiBanAn.commit();

                drawer.closeDrawers();
                break;
            case R.id.log_out:
                break;
            case R.id.exit:
                finishAffinity();
                System.exit(0);
                break;
        }
        return false;
    }
}
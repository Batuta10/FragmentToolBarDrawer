package br.com.fiap.exercicios.drawerandfragments.RM78792;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FrameLayout frameContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        frameContainer = (FrameLayout) findViewById(R.id.fragment_container);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navigatioview);

        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.strAbre,R.string.strFecha);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.mnDelorean){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DeloreanFragment()).addToBackStack(null).commit();
                }else if (item.getItemId() == R.id.mnImpala){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ImpalaFragment()).addToBackStack(null).commit();
                }else if (item.getItemId() == R.id.mnPontiacGto){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new GtoFragment()).addToBackStack(null).commit();
                }else if (item.getItemId() == R.id.mnShelbymustang){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShelbyFragment()).addToBackStack(null).commit();
                }
                drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }//OnCreate
}//Main Class

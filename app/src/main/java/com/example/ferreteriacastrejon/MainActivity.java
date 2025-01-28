package com.example.ferreteriacastrejon;

import static com.example.ferreteriacastrejon.R.id.nav_add;
import static com.example.ferreteriacastrejon.R.id.nav_delete;
import static com.example.ferreteriacastrejon.R.id.nav_home;
import static com.example.ferreteriacastrejon.R.id.nav_logout;
import static com.example.ferreteriacastrejon.R.id.nav_update;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerlayout=findViewById(R.id.drawer_layout);
        NavigationView navigationview = findViewById(R.id.nav_view);
        navigationview.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerlayout,toolbar,R.string.Open_nav,R.string.Close_nav);
        drawerlayout.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationview.setCheckedItem(nav_home);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == nav_delete){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new DeleteFragment()).commit();
        }else{
            if(item.getItemId() == nav_home){
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
            }else{
                if(item.getItemId() == nav_add){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AddFragment()).commit();
                }else{
                    if(item.getItemId() == nav_update){
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new UpdateFragment()).commit();
                    }else{
                        if(item.getItemId() == nav_logout){
                            Toast.makeText(this, "Sesion Cerrada", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this, Login.class));
                            finish();
                        }
                    }
                }
            }
        }



        drawerlayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
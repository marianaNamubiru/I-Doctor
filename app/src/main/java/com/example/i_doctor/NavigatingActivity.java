package com.example.i_doctor;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.i_doctor.myactivity.HomeActivity;
import com.example.i_doctor.myactivity.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class NavigatingActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {

    private CardView AskDocCardView,MyDoctorsCardView,AboutCardView,ViewDoctorsCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigating);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);

        AskDocCardView=findViewById(R.id.AskDocCardView);
        MyDoctorsCardView=findViewById(R.id.MyDoctorsCardView);
        AboutCardView=findViewById(R.id.AboutCardView);
        ViewDoctorsCardView=findViewById(R.id.ViewDoctorsCardView);

        AskDocCardView.setOnClickListener(this);
        MyDoctorsCardView.setOnClickListener(this);
        AboutCardView.setOnClickListener(this);
        ViewDoctorsCardView.setOnClickListener(this);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigating, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings || id == R.id.action_Logout) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_about) {
            // Handle the camera action
        } else if (id == R.id.nav_signout) {
            // Showing Echo Response Message Coming From Server.
            Toast.makeText(NavigatingActivity.this, "Logged Out Successfully", Toast.LENGTH_LONG).show();
            // Closing the current activity.
            finish();
            Intent intent = new Intent(NavigatingActivity.this, LoginActivity.class);

            startActivity(intent);

        } else if (id == R.id.nav_Chat) {

        } else if (id == R.id.nav_Email) {

        } else if (id == R.id.nav_Notifications) {

        } else if (id == R.id.nav_Privacy_policy) {

        }else if (id == R.id.nav_Help) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {

        Intent intent;

        switch (view.getId()){

            case R.id.AskDocCardView:{
                intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
                break;

            }
            case R.id.MyDoctorsCardView:{
                intent = new Intent(this,HomeActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.AboutCardView:{
                intent = new Intent(this,HomeActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.ViewDoctorsCardView:{
                intent = new Intent(this,HomeActivity.class);
                startActivity(intent);
                break;
            }

        }
    }

}

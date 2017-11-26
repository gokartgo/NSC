package com.gokartgiftmind.nsc.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.gokartgiftmind.nsc.R;
import com.gokartgiftmind.nsc.fragment.MainFragment;
import com.gokartgiftmind.nsc.view.UserTravelListView;
import com.gokartgiftmind.nsc.util.ValueUserTravelListView;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentListener{

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstance();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, MainFragment.newInstance(),"MainFragment")
                    .commit();
        }

        // request permission from user
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            } else {


                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},23
                );
            }
        }

    }

    private void initInstance() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this
                ,drawerLayout
                ,R.string.open_drawer
                ,R.string.close_drawer);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnLogout = (Button)findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(buttonClick);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    final View.OnClickListener buttonClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view == btnLogout){
                Intent intent = new Intent(MainActivity.this,LoginRegisterActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };

    @Override
    public void onUserItemClick(UserTravelListView view) {
        ValueUserTravelListView valueUser = new ValueUserTravelListView();
        valueUser.setLocationText(view.getTvLocationText());
        valueUser.setDestination(view.getTvDestination());
        valueUser.setTimeText(view.getTvTimeText());
        valueUser.setSeatText(view.getTvSeatText());
        valueUser.setNumberSeat(view.getSeat());
        Intent intent = new Intent(MainActivity.this,StatusUserActivity.class);
        intent.putExtra("valueUser",valueUser);
        startActivity(intent);
    }
}

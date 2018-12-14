package com.example.qis_rnd.neoly;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class TabActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private int[] tabIcons = {
            R.drawable.ic_menu_camera,
            R.drawable.ic_menu_gallery,
            R.drawable.ic_menu_manage,
            R.drawable.ic_menu_share
    };
    TabLayout tabLayout;
    private CardView cdr1,cdr2,cdr3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("MEDINFRAS");
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//       cdr1=findViewById(R.id.btn_create_event);
//        cdr1.setOnClickListener(new View.OnClickListener() {
//          @Override
//         public void onClick(View v) {
//                Intent intent=new Intent(getApplicationContext(), GetCardActivity.class);
//                startActivity(intent);
//            }
//        });
//        int image []={R.drawable.medinfras_bg_ori,R.drawable.medinfras_logo};
//        viewflip=findViewById(R.id.viewflip);
//        for (int i=0;i<image.length;i++){
//            Flipper(image[i]);
//
//        }
//        cdr2=findViewById(R.id.btn_create_event0);
//        cdr2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(getIntent().hasExtra("state")){
//                    if (getIntent().getStringExtra("state").equals("success")){
//                        Intent intent = new Intent(getApplicationContext(),MainxActivity.class);
//                        startActivity(intent);
//
//                    }else{
//                        ibd.setEnabled(false);
//                    }
//                }
//            }
//        });
//        cdr3=findViewById(R.id.btn_create_event1);
//        cdr3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent igt =new Intent(getApplicationContext(), CardQueueActivity.class);
//                startActivity(igt);
//            }
//        });
        TabLayout tabLayout =(TabLayout)findViewById(R.id.tabs);

        ViewPager Pager =(ViewPager)findViewById(R.id.viewpager);

        tabpagerAdapter Tabpageradapter = new tabpagerAdapter(getSupportFragmentManager());
        Pager.setAdapter(Tabpageradapter);
        tabLayout.setupWithViewPager(Pager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_map);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_call);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_que);
        //setupTabIcons();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
    }

}

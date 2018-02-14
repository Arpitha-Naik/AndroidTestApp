package com.effiatechnologies.androideducationapp.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.effiatechnologies.androideducationapp.R;
import com.effiatechnologies.androideducationapp.fragment.ComputersFragment;
import com.effiatechnologies.androideducationapp.fragment.EnglishFragment;
import com.effiatechnologies.androideducationapp.fragment.FacultyHomeFragment;
import com.effiatechnologies.androideducationapp.fragment.HindiFragment;
import com.effiatechnologies.androideducationapp.fragment.KannadaFragment;
import com.effiatechnologies.androideducationapp.fragment.MathsFragment;
import com.effiatechnologies.androideducationapp.fragment.ScienceFragment;
import com.effiatechnologies.androideducationapp.fragment.SocialFragment;

public class MainNavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private FloatingActionButton fab;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private FragmentManager mFragmentManager = null;
    private FragmentTransaction mFragmentTransaction = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setTitle("Dashboard");
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.dashboard_fragment_container, new FacultyHomeFragment());
        mFragmentTransaction.addToBackStack(null);
        mFragmentTransaction.commit();
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
        getMenuInflater().inflate(R.menu.main_navigation, menu);
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

        switch (id) {


            case R.id.nav_Dashboard:
                toolbar.setTitle("Dashboard");
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.dashboard_fragment_container, new FacultyHomeFragment());
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();
                break;

            case R.id.nav_Kannada:
                toolbar.setTitle("Kannada");
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.dashboard_fragment_container, new KannadaFragment());
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();
                break;

            case R.id.nav_English:
                toolbar.setTitle("English");
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.dashboard_fragment_container, new EnglishFragment());
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();
                break;

            case R.id.nav_Hindi:
                toolbar.setTitle("Hindi");
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.dashboard_fragment_container, new HindiFragment());
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();
                break;

            case R.id.nav_Social:
                toolbar.setTitle("Social");
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.dashboard_fragment_container, new SocialFragment());
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();
                break;

            case R.id.nav_Science:
                toolbar.setTitle("Science");
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.dashboard_fragment_container, new ScienceFragment());
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();
                break;

            case R.id.nav_Maths:
                toolbar.setTitle("Maths");
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.dashboard_fragment_container, new MathsFragment());
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();
                break;
            case R.id.nav_Computers:
                toolbar.setTitle("Computers");
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.dashboard_fragment_container, new ComputersFragment());
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();
                break;

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

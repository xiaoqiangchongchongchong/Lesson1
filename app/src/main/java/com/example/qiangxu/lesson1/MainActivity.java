package com.example.qiangxu.lesson1;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
//public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private NavigationView menu;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = (DrawerLayout) findViewById(R.id.drawer);

        menu = (NavigationView) findViewById(R.id.expend_menu);

        menu.setNavigationItemSelectedListener(this);

        //menu.setOnClickListener(this);
        //显示Home
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, 0, 0);
        //三条横线的MEnu
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        actionBarDrawerToggle.syncState();

        //由DrawerLayout控制Toggle
        drawer.setDrawerListener(actionBarDrawerToggle);

        pager = (ViewPager) findViewById(R.id.viewpager);

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 2; i++) {
            list.add(String.format("第%02d页", i));
        }

        pager.setAdapter(new MyAdapter(getSupportFragmentManager(), list));

        TabLayout tabLayout =(TabLayout) findViewById(R.id.tablayout);

        tabLayout.setupWithViewPager(pager);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_1:
                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_4:
                //finishAffinity();
                ActivityCompat.finishAffinity(this);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

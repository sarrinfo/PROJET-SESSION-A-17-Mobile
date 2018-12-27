package com.androidquebec.yakalma;

import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import DataAccess.DBAdapter;
import Modele.Recette;

public class MenuActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    PageAdapter pageAdapter;
    TabItem tabHome;
    TabItem tabNewRecette;
    TabItem tabList;
    TabItem tabDayMenu;
    Toolbar toolbar;
    DBAdapter dbAdapter;
    Recette recette;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(toolbar);

        setWidgets();
        setListeners();
    }

    private void setListeners() {
        pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 1){
                    toolbar.setTitle(getResources().getString(R.string.tabDayMenu));
                }
                else if (tab.getPosition() == 2){
                    toolbar.setTitle(getResources().getString(R.string.tabNewRecette));
                }
                else if (tab.getPosition() == 3){
                    toolbar.setTitle(getResources().getString(R.string.tabList));

                }
                else {
                    toolbar.setTitle(getResources().getString(R.string.tabHome));
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }

    private void setWidgets() {
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabHome = (TabItem)findViewById(R.id.tabHome);
        tabNewRecette = (TabItem)findViewById(R.id.tabNewRecette);
        tabList = (TabItem)findViewById(R.id.tabList);
        tabNewRecette = (TabItem)findViewById(R.id.tabNewRecette);
        tabDayMenu = (TabItem)findViewById(R.id.tabDayMenu);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
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
}

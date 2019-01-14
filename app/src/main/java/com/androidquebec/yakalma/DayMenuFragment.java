package com.androidquebec.yakalma;


import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import DataAccess.DBAdapter;
import DataAccess.MonCurseurAdapter;
import Modele.Recette;


/**
 * A simple {@link Fragment} subclass.
 */
public class DayMenuFragment extends Fragment {
    private ListView listingViewIngredient, listingViewPreparation;
    TextView txtTitreMenuRecette, txtMenuDureePreparation, txtMenuDureeTotal;
    View view;
    TabLayout tabMenuRecetteLayout;
    TabItem tabDayMenuIngredient, tabDayMenuPreparation;
    FrameLayout frameIngredient, framePreparation;
    DBAdapter dbAdapter;
    Recette recette;
    int position ;

    public DayMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_day_menu, container, false);
        //setWidgets();
        //setlisteners();
        return view;
    }

    private void setWidgets() {
        txtTitreMenuRecette = (TextView)  view.findViewById(R.id.txtTitreMenuRecette);
        txtMenuDureePreparation = (TextView)  view.findViewById(R.id.txtMenuDureePreparation);
        txtMenuDureeTotal  = (TextView)  view.findViewById(R.id.txtMenuDureeTotal);
        tabMenuRecetteLayout = (TabLayout)  view.findViewById(R.id.tabMenuRecetteLayout);
        tabDayMenuIngredient = (TabItem)  view.findViewById(R.id.tabDayMenuIngredient);
        tabDayMenuPreparation = (TabItem)  view.findViewById(R.id.tabDayMenuPreparation);
        frameIngredient = (FrameLayout)  view.findViewById(R.id.frameIngredient);
        framePreparation = (FrameLayout)  view.findViewById(R.id.framePreparation);
        listingViewIngredient = (ListView) view.findViewById(R.id.listingViewIngredient);
        listingViewPreparation = (ListView) view.findViewById(R.id.listingViewPreparation);

        position = 1;
        dbAdapter = new DBAdapter(getContext());
        //recette = dbAdapter.OneRecette(position);
        //BindDetailsRecette(recette);
    }

    private void setlisteners() {
        //
    }

    public void BindDetailsRecette(Recette recette){
            //
    };


    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        inflater.inflate(R.menu.menu_day_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.action_day_menu){
            Toast.makeText(getActivity(), "Cliked on "+ item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return  true;
    }



}

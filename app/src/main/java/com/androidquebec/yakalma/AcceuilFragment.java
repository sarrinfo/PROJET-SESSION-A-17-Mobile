package com.androidquebec.yakalma;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import DataAccess.DBAdapter;
import DataAccess.MonCurseurAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class AcceuilFragment extends Fragment {
    View view;

    public AcceuilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        view =  inflater.inflate(R.layout.fragment_acceuil, container, false);


        return view;
    }

    private void setWidgets() {

    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        inflater.inflate(R.menu.menu_acceuil, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.action_acceuil){
            Toast.makeText(getActivity(), "Cliked on "+ item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return  true;
    }
}


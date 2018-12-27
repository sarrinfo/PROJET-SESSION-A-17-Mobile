package com.androidquebec.yakalma;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import android.widget.ListView;

import android.widget.TextView;
import android.widget.Toast;


import DataAccess.DBAdapter;
import DataAccess.MonCurseurAdapter;



/**
 * A simple {@link Fragment} subclass.
 */
public class ListesFragment extends Fragment {
    TextView txtTitre, txtDureePreparation, txtDureeTotal;
    View view;
    DBAdapter dbAdapter;
    ListView listView;
    Cursor curseur;


    MonCurseurAdapter monCurseurAdapter;

    public ListesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        view = inflater.inflate(R.layout.fragment_listes, container, false);

        setWidgets();
        setlisteners();
        dbAdapter = new DBAdapter(getContext());
        curseur = dbAdapter.selectionnerRecette();
        MonCurseurAdapter adapter =
                new MonCurseurAdapter(getContext(), curseur, 1);
        listView.setAdapter(adapter);

        return view;

    }

    private void setlisteners() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "Click sur item : "+ position, Toast.LENGTH_LONG).show();
            }
        });
    }


    private void setWidgets() {
        listView = (ListView) view.findViewById(R.id.listingView);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        inflater.inflate(R.menu.menu_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.action_list){
            Toast.makeText(getActivity(), "Cliked on "+ item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return  true;
    }

}

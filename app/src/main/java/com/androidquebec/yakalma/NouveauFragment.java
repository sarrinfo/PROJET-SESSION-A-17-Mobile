package com.androidquebec.yakalma;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import DataAccess.DBAdapter;
import Modele.Recette;


/**
 * A simple {@link Fragment} subclass.
 */
public class NouveauFragment extends Fragment {
    Recette recette;
    EditText edtTitreRecette, edtAddIngredient, edtAddPreparation,
            edtHH, edtMM, edtHHCuisson, edtMMCuisson;
    Button btnPhotos, btnTerminer;
    ImageView imgAddPhotos;
    View view;
    DBAdapter dbAdapter;


    public NouveauFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        view = inflater.inflate(R.layout.fragment_nouveau, container, false);
        // Inflate the layout for this fragment


        setWidgets();


        return view ;
    }


    private void setWidgets() {
        edtTitreRecette = (EditText)  view.findViewById(R.id.edtTitreRecette);
        edtAddIngredient = (EditText)  view.findViewById(R.id.edtAddIngredient);
        edtAddPreparation  = (EditText)  view.findViewById(R.id.edtAddPreparation);
        edtHH = (EditText)  view.findViewById(R.id.edtHH);
        edtMM = (EditText)  view.findViewById(R.id.edtMM);
        edtHHCuisson = (EditText)  view.findViewById(R.id.edtHHCuisson);
        edtMMCuisson = (EditText)  view.findViewById(R.id.edtMMCuisson);

        btnPhotos = (Button) view.findViewById(R.id.btnPhotos);
        btnTerminer = (Button) view.findViewById(R.id.btnPhotos);
        imgAddPhotos = (ImageView) view.findViewById(R.id.imgAddPhotos);

    }

    public void ajouterNewRecette(){
        dbAdapter = new DBAdapter(getContext());
        String titre = edtTitreRecette.getText().toString();
        recette.set_Titre(titre);
        String ingredient = edtAddIngredient.getText().toString();
        recette.get_ListIngredient().add(ingredient);
        String preparation = edtAddPreparation.getText().toString();
        recette.get_ListEtapePreparation().add(preparation);
        int hhprep = Integer.parseInt(edtHH.getText().toString());
        recette.set_TempsPreparation(hhprep * 60);
        int mmprep = Integer.parseInt(edtMM.getText().toString());
        //
        int hhCuisson = Integer.parseInt(edtHHCuisson.getText().toString());
        recette.set_TempsCuisson(hhCuisson * 60);
        int mmCuisson = Integer.parseInt(edtMMCuisson.getText().toString());
        //
        recette.set_Categorie("SANTE");


        dbAdapter.ajouterRecette(recette);
        dbAdapter.fermerBd();
    };

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        inflater.inflate(R.menu.menu_nouveau, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.action_nouveau){
            Toast.makeText(getActivity(), "Nouvelle Recette", Toast.LENGTH_SHORT).show();
            creerRecette();
        }
        return  true;
    }

    private void creerRecette() {
        recette = new Recette();
    }


    private void effacer(){
        edtTitreRecette.getText().clear();
        edtAddIngredient.getText().clear();;
        edtAddPreparation.getText().clear();;
        edtHH.getText().clear();;
        edtMM.getText().clear(); ;
        edtHHCuisson.getText().clear(); ;
        edtMMCuisson.getText().clear();
    }


}

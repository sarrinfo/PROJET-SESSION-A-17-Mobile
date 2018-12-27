package Modele;

import java.util.ArrayList;

public class Recette {
    private String _Titre;
    private int _TempsPreparation;
    private int _TempsCuisson;
    private String _Categorie;
    private String UrlPhotos;

    private ArrayList<String> _ListIngredient;
    private ArrayList<String> _ListEtapePreparation;

    public Recette(){
        this._ListIngredient = new ArrayList<String>();
        this._ListEtapePreparation = new ArrayList<String>();
    }

    public Recette(String _Titre, int _TempsPreparation, int _TempsCuisson, String _Categorie, String urlPhotos) {
        this._Titre = _Titre;
        this._TempsPreparation = _TempsPreparation;
        this._TempsCuisson = _TempsCuisson;
        this._Categorie = _Categorie;
        UrlPhotos = urlPhotos;
        this._ListIngredient = new ArrayList<String>();
        this._ListEtapePreparation = new ArrayList<String>();
    }

    public String get_Titre() {
        return _Titre;
    }

    public int get_TempsPreparation() {
        return _TempsPreparation;
    }

    public int get_TempsCuisson() {
        return _TempsCuisson;
    }

    public String get_Categorie() {
        return _Categorie;
    }

    public String getUrlPhotos() {
        return UrlPhotos;
    }

    public ArrayList<String> get_ListIngredient() {
        return _ListIngredient;
    }

    public ArrayList<String> get_ListEtapePreparation() {
        return _ListEtapePreparation;
    }
    public void set_Titre(String _Titre) {
        this._Titre = _Titre;
    }

    public void set_TempsPreparation(int _TempsPreparation) {
        this._TempsPreparation = _TempsPreparation;
    }

    public void set_TempsCuisson(int _TempsCuisson) {
        this._TempsCuisson = _TempsCuisson;
    }

    public void set_Categorie(String _Categorie) {
        this._Categorie = _Categorie;
    }

    public void setUrlPhotos(String urlPhotos) {
        UrlPhotos = urlPhotos;
    }

    public void set_ListIngredient(ArrayList<String> _ListIngredient) {
        this._ListIngredient = _ListIngredient;
    }

    public void set_ListEtapePreparation(ArrayList<String> _ListEtapePreparation) {
        this._ListEtapePreparation = _ListEtapePreparation;
    }
}

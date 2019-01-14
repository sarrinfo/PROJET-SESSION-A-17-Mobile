package DataAccess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import Modele.Recette;

public class DBAdapter {
    private SQLiteDatabase db;
    private DBHelper dbHelper;
    private Context context;
    private static ArrayList<Recette> listRecette ;

    public static ArrayList<Recette> getListRecette() {
        return listRecette;
    }



    public DBAdapter(Context context) {
        this.context = context;
        this.dbHelper = new DBHelper(context, DBHelper.BD_NOM,null,DBHelper.VERSION);
    }

    public void getMaBd(){
        db = dbHelper.getWritableDatabase();
    }
    public void fermerBd(){
        db.close();
    }

    public void ajouterRecette(Recette recette){
        //Open database
        getMaBd();
        //Obtenir les valeurs des colonnes
        String _Titre = recette.get_Titre();
        int _TempsPreparation = recette.get_TempsPreparation();
        int _TempsCuisson = recette.get_TempsCuisson();
        String _Categorie = recette.get_Categorie();
        String UrlPhotos = recette.getUrlPhotos();

        ContentValues cv = new ContentValues();
        cv.put(DBHelper.COL_NAME_1, _Titre);
        cv.put(DBHelper.COL_NAME_2, _TempsPreparation);
        cv.put(DBHelper.COL_NAME_3, _TempsCuisson);
        cv.put(DBHelper.COL_NAME_4, _Categorie);
        cv.put(DBHelper.COL_NAME_5, UrlPhotos);
        //Excuter l'insertion
        db.insert(DBHelper.TABLE_1, null,cv);
    }
    public Cursor selectionnerRecette(){
        Recette recette ;
        listRecette = new ArrayList<Recette>();
        getMaBd();
        //Indiquer les colonnes du SELECT
        String[] cols ={DBHelper.COL_ID, DBHelper.COL_NAME_1, DBHelper.COL_NAME_2, DBHelper.COL_NAME_3, DBHelper.COL_NAME_4, DBHelper.COL_NAME_5};
        Cursor curseur = db.query(DBHelper.TABLE_1,cols,null,null,
                null,null,null,null);
        //Parcourir le curseur
        curseur.moveToFirst();
        while( !curseur.isAfterLast()){
            int id = curseur.getInt(0);
            String titre = curseur.getString(1);
            int tempsPreparation = curseur.getInt(2);
            int tempsCuisson = curseur.getInt(3);
            String categorie = curseur.getString(4);
            String urlPhotos = curseur.getString(5);

            recette = new Recette(titre,tempsPreparation,tempsCuisson,categorie,urlPhotos);
            listRecette.add(recette);
            curseur.moveToNext();
        }
        return curseur;
    }

    //Requete pour recuperer les details de la recette
    public Recette OneRecette(int position){
        Recette recette ;
        String sql = "SELECT * FROM "+DBHelper.TABLE_1+" WHERE "+DBHelper.COL_ID+ " = "+position;
        getMaBd();
        //Indiquer les colonnes du SELECT
        String[] cols ={DBHelper.COL_ID, DBHelper.COL_NAME_1, DBHelper.COL_NAME_2, DBHelper.COL_NAME_3, DBHelper.COL_NAME_4, DBHelper.COL_NAME_5};
        Cursor curseur = db.rawQuery(sql, null);
        //Parcourir le curseur
        curseur.moveToFirst();
            int id = curseur.getInt(0);
            String titre = curseur.getString(1);
            int tempsPreparation = curseur.getInt(2);
            int tempsCuisson = curseur.getInt(3);
            String categorie = curseur.getString(4);
            String urlPhotos = curseur.getString(5);

            recette = new Recette(titre,tempsPreparation,tempsCuisson,categorie,urlPhotos);
            listRecette.add(recette);

        return recette;
    }
}

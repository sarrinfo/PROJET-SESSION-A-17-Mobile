package DataAccess;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    //Declaration de constantes
    public static final String TABLE_1 = "Recette";
    public static final String COL_ID = "_id";
    public static final String COL_NAME_1 = "Titre";
    public static final String COL_NAME_2 = "TempsPreparation";
    public static final String COL_NAME_3 = "TempsCuisson";
    public static final String COL_NAME_4 = "Categorie";
    public static final String COL_NAME_5 = "UrlPhotos";



    public static final String CREATE_RECETTE_DDL =" create table "+TABLE_1+"("+
            COL_ID +" INTEGER primary key autoincrement unique, " +
            ""+COL_NAME_1+" TEXT, " +
            "" +COL_NAME_2+" NUMBER, " +
            "" +COL_NAME_3+" NUMBER, " +
            "" +COL_NAME_4+" TEXT, " +
            "" +COL_NAME_5+" TEXT)";

    public static final String BD_NOM = "yakalma";
    public static final int VERSION = 1;


    public DBHelper(Context context, String name,
                    SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_RECETTE_DDL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

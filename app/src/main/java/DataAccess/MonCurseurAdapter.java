package DataAccess;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquebec.yakalma.R;

public class MonCurseurAdapter extends CursorAdapter {
    public MonCurseurAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(
                R.layout.item_layout ,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String titreRecette = cursor.getString(cursor.getColumnIndex("Titre"));
        int tempsPreparation = cursor.getInt(cursor.getColumnIndex("TempsPreparation"));
        int tempsCuisson = cursor.getInt(cursor.getColumnIndex("TempsCuisson"));
        String categorie = cursor.getString(cursor.getColumnIndex("Categorie"));
        String urlPhotos = cursor.getString(cursor.getColumnIndex("UrlPhotos"));

        TextView titre = (TextView)view.findViewById(R.id.txtTitre);
        TextView dureePreparation = (TextView)view.findViewById(R.id.txtDureePreparation);
        TextView dureeTotal = (TextView)view.findViewById(R.id.txtDureeTotal);
        ImageView imageItemRecette = (ImageView)view.findViewById(R.id.imageItemRecette);
        ImageView imageNotation = (ImageView)view.findViewById(R.id.imgNotation);

        titre.setText(titreRecette);
        dureePreparation.setText(""+tempsPreparation+" mn");
        dureeTotal.setText(""+tempsCuisson+" mn");
        //imageItemRecette.setImageDrawable(urlPhotos);
        //imageNotation.setText(urlPhotos);

    }
}

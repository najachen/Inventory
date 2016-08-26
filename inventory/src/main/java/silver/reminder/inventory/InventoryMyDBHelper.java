package silver.reminder.inventory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Zumrat on 2016/8/25.
 */
public class InventoryMyDBHelper extends SQLiteOpenHelper{
    public InventoryMyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE main.exp" +
            "_id INTEGER PRIMARY KEY NOT NULL,"+
            "name VARCHAR"+
            "image BUTTON"+
            "room VARCHAR NOT NULL"+
            "place VARCHAR"+
            "direction VARCHAR"+
            "user VARCHAR"+
            "sort VARCHAR"+
            "amount INTEGER"+
            "limit DATATIME NOT NULL"+
            "remark VARCHAR");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

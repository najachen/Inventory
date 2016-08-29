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
    db.execSQL("CREATE TABLE exp" +
            "(_id INTEGER PRIMARY KEY NOT NULL,"+
            "name TEXT,"+
            "image TEXT,"+
            "room TEXT,"+
            "place TEXT,"+
            "direction TEXT,"+
            "user TEXT,"+
            "sort TEXT,"+
            "amount TEXT,"+
            "limit TEXT,"+
            "remark TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

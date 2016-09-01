package silver.reminder.inventory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Zumrat on 2016/8/25.
 */
public class InventoryMyDBHelper extends SQLiteOpenHelper {

    private static InventoryMyDBHelper dbHelper;

    private InventoryMyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static InventoryMyDBHelper getInstance(Context context){
        if(dbHelper == null){
            dbHelper = new InventoryMyDBHelper(context,"inventory.db",null,1);
        }
        return dbHelper;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE \"account\" " +
                "(\"_id\" INTEGER PRIMARY KEY NOT NULL, " +
                "\"nickname\" VARCHAR(20))"
//                "\"createdBy\" VARCHAR(20), " +
//                "\"createdOn\" TEXT  )"
        );
        db.execSQL("CREATE TABLE \"category\" " +
                "(\"_id\" INTEGER PRIMARY KEY NOT NULL, " +
//                "\"createdBy\" VARCHAR(20), " +
//                "\"createdOn\" TEXT , " +
                "\"category\" VARCHAR(50)  )");
        db.execSQL("CREATE TABLE \"inventory\"" +
                " (\"_id\" INTEGER PRIMARY KEY NOT NULL, " +
                "\"item_id\" INTEGER," +
                " \"qty\" INTEGER)");
//                "\"createdOn\"TEXT  )");
        db.execSQL("CREATE TABLE \"item\"" +
                "(_id INTEGER PRIMARY KEY NOT NULL," +
//                        "createdBy TEXT," +
//                        "createdOn TEXT," +
                        "itemName TEXT," +
                        "expiredOn TEXT," +
                        "photo TEXT," +
//                        "modifiedBy TEXT," +
//                        "modifiedOn TEXT," +
                        "remark TEXT," +
                        //"location_id INTEGER NOT NULL," +
                        "location_id INTEGER," +
//                        "category_id INTEGER NOT NULL," +
                "category_id INTEGER," +
                        "direction TEXT," +
                        "user TEXT)");
        db.execSQL("CREATE TABLE \"location\"" +
                "(_id INTEGER PRIMARY KEY NOT NULL," +
//                        "createdBy TEXT," +
//                        "createdOn TEXT," +
                        "location TEXT," +
                        "Parent TEXT)");
        db.execSQL("CREATE TABLE  \"relationship\"" +
                "(_id INTEGER PRIMARY KEY NOT NULL," +
                        "account_id INTEGER NOT NULL," +
                        "category_id INTEGER NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

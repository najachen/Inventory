package silver.reminder.inventory;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class InventoryStockMain extends AppCompatActivity {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        findViews();
        InventoryMyDBHelper helper = new InventoryMyDBHelper(this, "inventory.db", null, 1);
        Cursor c = helper.getReadableDatabase().rawQuery("select * from inventory join item " +
                "on inventory.item_id = item._id  and qty <> -1", new String[]{});
    }

    private void findViews() {
        list = (ListView) findViewById(R.id.list_list);
    }
}

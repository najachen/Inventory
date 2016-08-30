package silver.reminder.inventory;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class InventoryStockActivity extends AppCompatActivity {

    private GridView list;
    private TextView l_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        findViews();
        l_title.setText("庫存");
        selectData();
    }

    private void selectData() {
        InventoryMyDBHelper helper = new InventoryMyDBHelper(this, "inventory.db", null, 1);
        Cursor c = helper.getReadableDatabase().rawQuery("select * from inventory join item " +
                "on inventory.item_id = item._id  and qty <> -1", new String[]{});
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                R.layout.inventory_row_stock,
                c,
                new String[]{"itemName", "qty"},
                new int[]{R.id.t_row_stock_itemName, R.id.t_row_stock_qty},
                0);
    }

    private void findViews() {
        list = (GridView) findViewById(R.id.grid_list);
        l_title = (TextView) findViewById(R.id.l_title);
    }
}

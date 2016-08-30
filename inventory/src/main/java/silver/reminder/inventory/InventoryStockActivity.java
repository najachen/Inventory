package silver.reminder.inventory;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class InventoryStockActivity extends AppCompatActivity {

    private TextView l_title;
    private ListView list_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        findViews();
        l_title.setText("庫存");
        selectData();
    }

    private void selectData() {
        InventoryMyDBHelper helper = new InventoryMyDBHelper(this, "inventory.db", null, 1);
        final Cursor c = helper.getReadableDatabase().rawQuery("select * from inventory join item " +
                "on inventory.item_id = item._id  and qty <> -1", new String[]{});

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                R.layout.inventory_row_stock,
                c,
                new String[]{"itemName", "qty"},
                new int[]{R.id.t_row_stock_itemName, R.id.t_row_stock_qty},
                0){
            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                //super.bindView(view, context, cursor);
                if(view == null){
                    LayoutInflater layoutInflater = LayoutInflater.from(context);
                    view = layoutInflater.inflate(R.layout.inventory_row_stock, null, false);
                }

                TextView t_row_stock_itemName = (TextView) view.findViewById(R.id.t_row_stock_itemName);
                TextView t_row_stock_qty = (TextView) view.findViewById(R.id.t_row_stock_qty);

                TextView fieldName = (TextView) view.findViewById(R.id.fieldName);
                fieldName.setText("數量 : ");

                int itemNameIndex =  cursor.getColumnIndexOrThrow("itemName");
                int qtyIndex =  cursor.getColumnIndexOrThrow("qty");

                while (cursor.moveToNext()){

                    String itemName = cursor.getString(itemNameIndex);
                    t_row_stock_itemName.setText(itemName);

                    int qty = cursor.getInt(qtyIndex);
                    t_row_stock_qty.setText(String.valueOf(qty));
                }
            }
        };
        list_list.setAdapter(adapter);
    }

    private void findViews() {
        list_list = (ListView) findViewById(R.id.list_list);
        l_title = (TextView) findViewById(R.id.l_title);
    }
}

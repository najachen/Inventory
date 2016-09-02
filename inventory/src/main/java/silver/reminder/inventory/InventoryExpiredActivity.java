package silver.reminder.inventory;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class InventoryExpiredActivity extends AppCompatActivity {

    private ListView list_list;
    private TextView l_title;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        findViews();
        setSupportActionBar(toolbar);
        l_title.setText("物品保存期限");
        selectData();



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void findViews() {
        list_list = (ListView) findViewById(R.id.list_list);
        l_title = (TextView) findViewById(R.id.l_title);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void selectData() {
        InventoryMyDBHelper helper = InventoryMyDBHelper.getInstance(this);
        final Cursor c = helper.getReadableDatabase().rawQuery(
                "select * from item WHERE (expiredOn != ' ' " +
                        "and expiredOn != '') ORDER BY expiredOn ASC",
                new String[]{});


        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_expandable_list_item_2,
                c,
                new String[]{"itemName", "expiredOn"},
                new int[]{android.R.id.text1, android.R.id.text2},
                0);
        list_list.setAdapter(adapter);
    }
}

package silver.reminder.inventory;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class InventoryCategoryActivity extends AppCompatActivity {
    public static final int LEI_LOGIN = 1;
    String[] lei = {"消耗品", "加工食品", "飲料", "調料", "發票類", "重要物品", "圖書籍"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview_category);
        GridView gridView = (GridView)findViewById(R.id.grid_list);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,lei);
        gridView.setAdapter(adapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}

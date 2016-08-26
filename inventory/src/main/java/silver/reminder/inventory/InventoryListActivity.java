package silver.reminder.inventory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class InventoryListActivity extends AppCompatActivity {

    public static final int LEI_LOGIN = 1;
    String[] lei = {"消耗品", "加工食品", "飲料", "調料", "發票類", "重要物品", "圖書籍"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView listView = (ListView)findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,lei);
        listView.setAdapter(adapter);
    }
}

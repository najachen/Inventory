package silver.reminder.inventory;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InventoryHomeActivity extends AppCompatActivity {

    
    private TextView treminder;
    private EditText edsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        edsearch = (EditText)findViewById(R.id.ed_home_search);
        treminder = (TextView)findViewById(R.id.t_reminder);
        treminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = InventoryMyDBHelper.getInstance(InventoryHomeActivity.this).getReadableDatabase();
                Cursor c = db.rawQuery("select itemname, qty from inventory join item on inventory.item_id = item._id and inventory.qty = 1", null);



                Toast.makeText(InventoryHomeActivity.this, "textview ",Toast.LENGTH_LONG).show();



            }
        });
    }

    public void mine(View view){
        Intent intent = new Intent(this,InventoryMineActivity.class);
        startActivity(intent);
    }
    public void user(View view){
        Intent intent = new Intent(this,InventoryUserActivity.class);
        startActivity(intent);
    }
    public void location(View view){
        Intent intent = new Intent(this,InventoryLocationActivity.class);
        startActivity(intent);
    }
    public void category(View view){
        Intent intent = new Intent(this,InventoryCategoryActivity.class);
        startActivity(intent);
    }
    public void expiredDate(View view){
        Intent intent = new Intent(this,InventoryMineActivity.class);
        startActivity(intent);
    }
    public void stock(View view){
        Intent intent = new Intent(this,InventoryStockActivity.class);
        startActivity(intent);
    }
    public void createNew(View view){
        Intent intent = new Intent(this,InventoryCreateActivity.class);
        startActivity(intent);
    }


}

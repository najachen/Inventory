package silver.reminder.inventory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class InventoryMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_main);
    }
    public void Storage(View view){
        Intent intent = new Intent(this, InventoryHomeActivity.class);
        startActivity(intent);
    }
}

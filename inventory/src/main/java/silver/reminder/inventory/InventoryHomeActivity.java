package silver.reminder.inventory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class InventoryHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void mine(View view){
        Intent intent = new Intent(this,InventoryColumnsActivity.class);
        startActivity(intent);
    }
    public void user(View view){
        Intent intent = new Intent(this,InventoryLocationActivity.class);
        startActivity(intent);
    }
    public void location(View view){
        Intent intent = new Intent(this,InventoryLocationActivity.class);
        startActivity(intent);
    }
    public void category(View view){
        Intent intent = new Intent(this,InventoryLocationActivity.class);
        startActivity(intent);
    }
    public void expiredDate(View view){
        Intent intent = new Intent(this,InventoryColumnsActivity.class);
        startActivity(intent);
    }
    public void inventory(View view){
        Intent intent = new Intent(this,InventoryColumnsActivity.class);
        startActivity(intent);
    }
    public void createNew(View view){
        Intent intent = new Intent(this,InventoryCreateActivity.class);
        startActivity(intent);
    }
}

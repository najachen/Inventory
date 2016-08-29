package silver.reminder.inventory;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class InventoryCreateActivity extends AppCompatActivity {

    private EditText edItemname;
    private EditText edRoom;
    private EditText edPlace;
    private EditText edDirection;
    private EditText edUser;
    private EditText edCategory;
    private EditText edQty;
    private EditText edExpiredOn;
    private EditText edRemark;

    private InventoryMyDBHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        findViewById();
        helper = new InventoryMyDBHelper(this,"expense.db",null,1);
    }
    private void findViewById(){
        edItemname =(EditText)findViewById(R.id.ed_itemName);
        edRoom =(EditText)findViewById(R.id.ed_room);
        edPlace =(EditText)findViewById(R.id.ed_place);
        edDirection =(EditText)findViewById(R.id.ed_direction);
        edUser=(EditText)findViewById(R.id.ed_user);
        edCategory =(EditText)findViewById(R.id.ed_category);
        edQty =(EditText)findViewById(R.id.ed_qty);
        edExpiredOn =(EditText)findViewById(R.id.ed_expiredOn);
        edRemark =(EditText)findViewById(R.id.ed_remark);
    }
    public void Create(View view){
        String itemName = edItemname.getText().toString();
        String room = edRoom.getText().toString();
        String place = edPlace.getText().toString();
        String direction = edDirection.getText().toString();
        String user = edUser.getText().toString();
        String category = edCategory.getText().toString();
        int qty = Integer.parseInt(edQty.getText().toString());
        String expiredOn = edExpiredOn.getText().toString();
        String remark = edRemark.getText().toString();
        ContentValues values = new ContentValues();
        values.put("itemName",itemName);
        long id = helper.getWritableDatabase().insert("exp",null,values);
        Log.d("ADD", String.valueOf(id));


    }
    public void cancel(View view){

    }
}

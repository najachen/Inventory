package silver.reminder.inventory;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class InventoryCreateActivity extends AppCompatActivity {

    private EditText edName;
    private EditText edRoom;
    private EditText edPlace;
    private EditText edDirection;
    private EditText edUser;
    private EditText edSort;
    private EditText edAmount;
    private EditText edLimit;
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
        edName =(EditText)findViewById(R.id.ed_itemName);
        edRoom =(EditText)findViewById(R.id.ed_room);
        edPlace =(EditText)findViewById(R.id.ed_place);
        edDirection =(EditText)findViewById(R.id.ed_direction);
        edUser=(EditText)findViewById(R.id.ed_user);
        edSort =(EditText)findViewById(R.id.ed_category);
        edAmount =(EditText)findViewById(R.id.ed_qty);
        edLimit =(EditText)findViewById(R.id.ed_expiredOn);
        edRemark =(EditText)findViewById(R.id.ed_remark);
    }
    public void store(View view){
        String name = edName.getText().toString();
        String room = edRoom.getText().toString();
        String place = edPlace.getText().toString();
        String direction = edDirection.getText().toString();
        String user = edUser.getText().toString();
        String sort = edSort.getText().toString();
        int amount = Integer.parseInt(edAmount.getText().toString());
        String limit = edLimit.getText().toString();
        String remark = edRemark.getText().toString();
        ContentValues values = new ContentValues();
        values.put("name",name);
        long id = helper.getWritableDatabase().insert("exp",null,values);
        Log.d("ADD", String.valueOf(id));


    }
    public void cancel(View view){

    }
}

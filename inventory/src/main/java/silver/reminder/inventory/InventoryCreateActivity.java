package silver.reminder.inventory;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class InventoryCreateActivity extends AppCompatActivity {

    private static final int CAMERA = 1;

    private EditText edItemName;
    private EditText edRoom;
    private EditText edPlace;
    private EditText edDirection;
    private EditText edUser;
    private EditText edCategory;
    private EditText edQty;
    private EditText edExpiredOn;
    private EditText edRemark;

    private InventoryMyDBHelper helper;
    private ImageButton bCamera;
    private TextView photo_id;

    private String url;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        findViewById();
        photo_id.setVisibility(View.INVISIBLE);
        helper = new InventoryMyDBHelper(this,"inventory.db",null,1);
    }
    private void findViewById(){
        edItemName =(EditText)findViewById(R.id.ed_itemName);
        edRoom =(EditText)findViewById(R.id.ed_room);
        edPlace =(EditText)findViewById(R.id.ed_place);
        edDirection =(EditText)findViewById(R.id.ed_direction);
        edUser=(EditText)findViewById(R.id.ed_user);
        edCategory =(EditText)findViewById(R.id.ed_category);
        edQty =(EditText)findViewById(R.id.ed_qty);
        edExpiredOn =(EditText)findViewById(R.id.ed_expiredOn);
        edRemark =(EditText)findViewById(R.id.ed_remark);
        bCamera = (ImageButton) findViewById(R.id.b_camera);
        photo_id = (TextView) findViewById(R.id.photo_id);
        imageView = (ImageView) findViewById(R.id.thumbnail);
    }
    public void Create(View view){
        String room = edRoom.getText().toString();
        String place = edPlace.getText().toString();
        String direction = edDirection.getText().toString();
        String itemName = edItemName.getText().toString();
        String user = edUser.getText().toString();
        String category = edCategory.getText().toString();
        String q  = edQty.getText().toString();
        q = q==null?"-1":q;
        int qty = -1;
        try{
            qty = Integer.parseInt(q);
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
        String expiredOn = edExpiredOn.getText().toString();
        String remark = edRemark.getText().toString();

        //把資料放進locatioon資料表
        ContentValues locaionValues1 = new ContentValues();
        locaionValues1.put("location",room);
        locaionValues1.put("parent", "*");
        long rowIdRoom = helper.getWritableDatabase().insert("location", null, locaionValues1);

        ContentValues locationValues2 = new ContentValues();
        locationValues2.put("location",place);
        locationValues2.put("parent", String.valueOf(rowIdRoom));
        long rowIdPlace = helper.getWritableDatabase().insert("location", null, locationValues2);

        ContentValues locationValues3 = new ContentValues();
        locationValues3.put("location", direction);
        locationValues3.put("parent", String.valueOf(rowIdPlace));
        long rowIdDirection = helper.getWritableDatabase().insert("location", null, locationValues3);

        //把資料放進 category資料表
        ContentValues categoryValues = new ContentValues();
        categoryValues.put("category",category );
        long rowIdCategory = helper.getWritableDatabase().insert("category", null, categoryValues);

        //把資料放進 item資料表
        ContentValues itemValues = new ContentValues();
        itemValues.put("itemName",itemName);
        itemValues.put("expiredOn", expiredOn);
        itemValues.put("photo", this.url == null?"":this.url);
        itemValues.put("remark", remark);
        itemValues.put("location_id", rowIdRoom );
        itemValues.put("category_id", rowIdCategory );
        itemValues.put("user", user);
        long rowIdItem = helper.getWritableDatabase().insert("item",null, itemValues);
        //把資料放進 inventory資料表
        ContentValues inventoryValues = new ContentValues();
        inventoryValues.put("item_id",rowIdItem);
        inventoryValues.put("qty",qty);
        long rowIdInventory = helper.getWritableDatabase().insert("inventory",null, inventoryValues);


    }
    public void cancel(View view){
      this.finish();
    }

    public void camera (View view){
        Intent capture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(capture, CAMERA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            switch (requestCode){
                case CAMERA:
                    Bitmap image = (Bitmap) data.getExtras().get("data");
                    imageView.setImageBitmap(image);
                    break;
            }
        }
    }

    //class SaveItemLocation extends AsyncTask<>
}

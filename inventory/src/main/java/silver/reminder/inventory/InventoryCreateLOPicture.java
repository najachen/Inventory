package silver.reminder.inventory;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class InventoryCreateLOPicture extends AppCompatActivity implements AdapterView.OnItemClickListener {
        public static final int FUNC_LOGIN = 1;
        int []icons = {R.drawable.lo_toilet, R.drawable.lo_studyingroom,R.drawable.lo_livingroom,
                R.drawable.lo_kichen,R.drawable.laundryroom1,R.drawable.livingroom,R.drawable.lo_babyroom,
                R.drawable.lo_bathroom,R.drawable.lo_studyingroom
        };

        class IconAdapter extends BaseAdapter {
            @Override
            public int getCount() {
                return icons.length;
            }
            @Override
            public Object getItem(int position) {
                return 0;
            }
            @Override
            public long getItemId(int position) {
                return icons[position];
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View row =convertView;
                if  (row==null){
                    row = getLayoutInflater().inflate(R.layout.inventory_row_user,null);
                    ImageView image = (ImageView) row.findViewById(R.id.item_image);
                    image.setImageResource(icons[position]);
                }
                return row;
            }
        }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_inventory_create_lopicture);
            GridView grid = (GridView)findViewById(R.id.gridl_pic);
            IconAdapter gAdapter = new IconAdapter();
            grid.setAdapter(gAdapter);
            grid.setOnItemClickListener(this);
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            int drawId2 = (int) parent.getItemIdAtPosition(position);
            setResult(RESULT_OK, getIntent().putExtra("pictureId2", drawId2));
            finish();
        }
    }


package silver.reminder.inventory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class InventoryLocationActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
        boolean logon = false;
        public static final int FUNC_LOGIN = 1;
        String[] lo = {"嬰兒房", "浴室", "廚房", "客廳", "書房", "化妝室"};
        int []icons = {R.drawable.lo_babyroom, R.drawable.lo_bathroom,R.drawable.lo_kichen,
                R.drawable.lo_livingroom,R.drawable.lo_studyingroom,R.drawable.lo_toilet
        };
        class IconAdapter extends BaseAdapter {

            @Override
            public int getCount() {
                return lo.length;
            }

            @Override
            public Object getItem(int position) {
                return lo[position];
            }

            @Override
            public long getItemId(int position) {

                return icons[position];
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View row =convertView;
                if  (row==null){
                    row = getLayoutInflater().inflate(R.layout.item_row,null);
                    ImageView image = (ImageView) row.findViewById(R.id.item_image);
                    TextView text = (TextView) row.findViewById(R.id.item_text);
                    image.setImageResource(icons[position]);
                    text.setText(lo[position]);
                }
                return row;
            }
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_inventory_location);
            GridView gridView = (GridView)findViewById(R.id.gridView);
            IconAdapter gAdapter = new IconAdapter();
            gridView.setAdapter(gAdapter);
            gridView.setOnItemClickListener(this);

        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if ((int) id == R.drawable.lo_babyroom ){
                startActivity(new Intent(this, InventoryColumnsActivity.class));
            } else if ((int) id == R.drawable.lo_bathroom) {
                startActivity(new Intent(this, InventoryColumnsActivity.class));
            } else if ((int) id == R.drawable.lo_kichen) {
                startActivity(new Intent(this, InventoryColumnsActivity.class));
            } else if ((int) id == R.drawable.lo_livingroom) {
                startActivity(new Intent(this, InventoryColumnsActivity.class));
            } else if ((int) id == R.drawable.lo_studyingroom) {
                startActivity(new Intent(this, InventoryColumnsActivity.class));
            } else if ((int) id == R.drawable.lo_toilet) {
                startActivity(new Intent(this, InventoryColumnsActivity.class));
                finish();
            }
        }
    }

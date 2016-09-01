package silver.reminder.inventory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class InventoryCreateUSPicture extends AppCompatActivity implements AdapterView.OnItemClickListener {

    boolean logon = false;
    public static final int FUNC_LOGIN = 1;
    int []icons = {R.drawable.func_baby, R.drawable.func_elwoman,R.drawable.func_elman,
            R.drawable.func_ma,R.drawable.func_ba,R.drawable.func_elsister,R.drawable.func_ysister,
            R.drawable.func_brother,R.drawable.func_mine,R.drawable.baby1,R.drawable.baby2,R.drawable.baby4,
            R.drawable.babygirl2,R.drawable.func_brother
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
        setContentView(R.layout.activity_inventory_create_uspicture);
        GridView grid = (GridView)findViewById(R.id.gridu_pic);
        IconAdapter gAdapter = new IconAdapter();
        grid.setAdapter(gAdapter);
        grid.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int drawId = (int) parent.getItemIdAtPosition(position);
        setResult(RESULT_OK, getIntent().putExtra("pictureId", drawId));
        finish();
    }
}

package silver.reminder.inventory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class InventoryUserActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    boolean logon = false;
    public static final int FUNC_LOGIN = 1;
    String[] func = {"寶寶", "阿媽", "阿公", "媽媽", "爸爸", "姐姐", "妹妹", "外甥","我"};
    int []icons = {R.drawable.func_baby, R.drawable.func_elwoman,R.drawable.func_elman,
            R.drawable.func_ma,R.drawable.func_ba,R.drawable.func_elsister,R.drawable.func_ysister,
            R.drawable.func_brother,R.drawable.func_mine

    };
    class IconAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return func.length;
        }

        @Override
        public Object getItem(int position) {
            return func[position];
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
                text.setText(func[position]);
            }
            return row;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
    GridView grid = (GridView)findViewById(R.id.grid);
        IconAdapter gAdapter = new IconAdapter();
        grid.setAdapter(gAdapter);
    grid.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if ((int) id == R.drawable.func_baby) {
            startActivity(new Intent(this, InventoryColumnsActivity.class));
        } else if ((int) id == R.drawable.func_elwoman) {
            startActivity(new Intent(this, InventoryColumnsActivity.class));
        } else if ((int) id == R.drawable.func_elman) {
            startActivity(new Intent(this, InventoryColumnsActivity.class));
        } else if ((int) id == R.drawable.func_ma) {
            startActivity(new Intent(this, InventoryColumnsActivity.class));
        } else if ((int) id == R.drawable.func_ba) {
            startActivity(new Intent(this, InventoryColumnsActivity.class));
        } else if ((int) id == R.drawable.func_elsister) {
            startActivity(new Intent(this, InventoryColumnsActivity.class));
        } else if ((int) id == R.drawable.func_ysister) {
            startActivity(new Intent(this, InventoryColumnsActivity.class));
        } else if ((int) id == R.drawable.func_brother) {
            startActivity(new Intent(this, InventoryColumnsActivity.class));
        } else if ((int) id == R.drawable.func_mine) {
            startActivity(new Intent(this, InventoryColumnsActivity.class));
            finish();

        }
    }
}

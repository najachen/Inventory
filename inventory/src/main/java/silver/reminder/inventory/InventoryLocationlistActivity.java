package silver.reminder.inventory;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Administrator on 2016/8/30.
 */


    public class InventoryLocationlistActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_listview);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
            FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    startActivity(new Intent(InventoryLocationlistActivity.this,InventoryCreateActivity.class));
                }
            });

        }

    }



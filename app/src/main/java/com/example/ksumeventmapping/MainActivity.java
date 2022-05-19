package com.example.ksumeventmapping;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        DataBaseHelper dbHelper = new DataBaseHelper(MainActivity.this);
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewActivity(dbHelper);
            }
        });

        ImageView i_but = (ImageView) findViewById(R.id.fragm);
        i_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CourseModal data = getIntent().getParcelableExtra("eventData");
                if(getIntent().hasExtra("eventData")){

                    final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
                    View bottomSheetView = LayoutInflater.from( getApplicationContext ( ))
                            .inflate(
                                    R.layout.activity_bottomdialog,
                                    (LinearLayout)findViewById(R.id.bottomSheetContainer));
                    bottomSheetDialog.setContentView( bottomSheetView);
                    bottomSheetDialog.show( );

                    TextView name,desc,time,room;
                    name = bottomSheetDialog.findViewById(R.id.textView2);
                    desc = bottomSheetDialog.findViewById(R.id.textView3);
                    time = bottomSheetDialog.findViewById(R.id.textView4);
                    room = bottomSheetDialog.findViewById(R.id.textView5);
                    CharSequence c = "sdds";
                    name.setText(data.getName());
                    desc.setText(data.getDesc());
                    time.setText(data.getTime());
                    room.setText(data.getRoom());
                }else{
                    Toast toast=Toast.makeText(getApplicationContext(),"Select an Event",Toast.LENGTH_SHORT);
                }
            }
        });


    }
    public void openNewActivity(DataBaseHelper db){
        Intent intent = new Intent(this, EventActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
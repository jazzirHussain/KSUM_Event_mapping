package com.example.ksumeventmapping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class EventActivity extends AppCompatActivity {
    SearchView searchView;
    ListView listView;
    List<String> list;
    ArrayAdapter<String > adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        DataBaseHelper db = new DataBaseHelper(EventActivity.this);
        searchView = (SearchView) findViewById(R.id.searchView);
        listView = (ListView) findViewById(R.id.lv1);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        list = new ArrayList<String>();
        ArrayList<CourseModal> allEvents = db.getAllEventData();
        for(int i=0;i<allEvents.size();i++){
            list.add(allEvents.get(i).getName());
        }

//        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        CustomListAdapter adapter = new CustomListAdapter(this, list);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(query.equals("")){
                    adapter.getFilter().filter("");
                }
                if(!checkList(list, query).equals("")){
                    adapter.getFilter().filter(query);
                }else{
                    Toast.makeText(EventActivity.this, "No Match found",Toast.LENGTH_LONG).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                if(query.equals("")){
                    adapter.getFilter().filter("");
                }
                if(!checkList(list, query).equals("")){
                    adapter.getFilter().filter(query);
                }
                return false;
            }
        });
        searchView.setOnCloseListener(new SearchView.OnCloseListener(){

            @Override
            public boolean onClose() {
                adapter.checkList(list,"");
                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(EventActivity.this,MainActivity .class);

                String item = adapter.getItem(position);
                ArrayList<CourseModal> data =  db.getEventData(item);
                intent.putExtra("eventData",data.get(0));

                startActivity(intent);
                finish();
            }
        });

    }
    public String checkList(List<String> list, String query){
        for (int i = 0; i < list.size(); i++){
            if(list.get(i).toLowerCase().contains(query.toLowerCase())){
                return list.get(i);
            }
        }
        return "";
    }
}
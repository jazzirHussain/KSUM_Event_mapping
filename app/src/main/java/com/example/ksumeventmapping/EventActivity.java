package com.example.ksumeventmapping;

import android.os.Bundle;
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

        searchView = (SearchView) findViewById(R.id.searchView);
        listView = (ListView) findViewById(R.id.lv1);

        list = new ArrayList<String>();
        list.add("Apple");
        list.add("Banana");
        list.add("Pineapple");
        list.add("Orange");
        list.add("Lychee");
        list.add("Gavava");
        list.add("Peech");
        list.add("Melon");
        list.add("Watermelon");
        list.add("Papaya");

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

    }
    public String checkList(List<String> list, String query){
        for (int i = 0; i < list.size(); i++){
            if(list.get(i).toLowerCase().equals(query.toLowerCase())){
                return list.get(i);
            }
        }
        return "";
    }
}
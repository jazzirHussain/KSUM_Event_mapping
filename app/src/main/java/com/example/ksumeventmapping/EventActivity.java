package com.example.ksumeventmapping;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EventActivity extends AppCompatActivity {
    SearchView searchView;
    ListView listView;
    List<String> list;
    ArrayAdapter<String > adapter;
    RecyclerView mRecyclerView;
    private EventsAdapter evensAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        String url = "https://iwkerala.org/api/stats/agenda.json";

        RecyclerView rvDate = findViewById(R.id.rvDate);
        HashMap<String, JSONArray> map = new HashMap<>();
        list = new ArrayList<String>();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray allEventsJson = response.getJSONArray("agenda");
                    evensAdapter = new EventsAdapter(allEventsJson, EventActivity.this);
                    LinearLayoutManager manager = new LinearLayoutManager(EventActivity.this);
                    rvDate.setLayoutManager(manager);
                    rvDate.setAdapter(evensAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);



        DataBaseHelper db = new DataBaseHelper(EventActivity.this);
//        searchView = (SearchView) findViewById(R.id.searchView);
//        listView = (ListView) findViewById(R.id.lv1);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
//        for(int i = 0; i<map.size(); i++){
//            LinearLayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
//            mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//            mRecyclerView.setLayoutManager(layoutManager);
//        }
//        CustomListAdapter adapter = new CustomListAdapter(EventActivity.this, list);
//        listView.setAdapter(adapter);

//        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);


//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                if(query.equals("")){
//                    adapter.getFilter().filter("");
//                }
//                if(!checkList(list, query).equals("")){
//                    adapter.getFilter().filter(query);
//                }else{
//                    Toast.makeText(EventActivity.this, "No Match found",Toast.LENGTH_LONG).show();
//                }
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String query) {
//                if(query.equals("")){
//                    adapter.getFilter().filter("");
//                }
//                if(!checkList(list, query).equals("")){
//                    adapter.getFilter().filter(query);
//                }
//                return false;
//            }
//        });
////        searchView.setOnCloseListener(new SearchView.OnCloseListener(){
////
////            @Override
////            public boolean onClose() {
////                adapter.checkList(list,"");
////                return true;
////            }
////        });
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(EventActivity.this,MainActivity .class);
//
//                String item = adapter.getItem(position);
//                ArrayList<CourseModal> data =  db.getEventData(item);
//                intent.putExtra("eventData",data.get(0));
//
//                startActivity(intent);
//                finish();
//            }
//        });

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
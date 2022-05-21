package com.example.ksumeventmapping;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> implements ItemClickListener{

    public JSONArray dates;
    private Context context;
    private LayoutInflater layoutInflater;
    EventAdapter e;

    public EventsAdapter(JSONArray dates, Context context) {
        this.dates = dates;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.hor_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        try {
            e = new EventAdapter(context, dates.getJSONObject(position).getJSONArray("events"));
            String c ="Day "+(position+1);
            holder.recyclerView.setAdapter(e);
            holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            holder.recyclerView.setHasFixedSize(true);
            holder.tvHeading.setText(c);
            e.setClickListener(this);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return dates.length();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;
        TextView tvHeading;

        public ViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.rvDates);
            tvHeading = (TextView) itemView.findViewById(R.id.tvDate);

        }


    }
    @Override
    public void onClick(View view, JSONObject event) {
        Intent intent = new Intent(context,MainActivity.class);
        intent.putExtra("eventData",event.toString());
        context.startActivity(intent);
        ((Activity)context).finish();
    }
}
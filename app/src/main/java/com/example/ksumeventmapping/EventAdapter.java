package com.example.ksumeventmapping;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.CustomViewHolder>{

    private Context context;
    private JSONArray events;
    private LayoutInflater inflater;

    public EventAdapter(Context context, JSONArray events) {
        this.context = context;
        this.events = events;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = inflater.inflate(R.layout.item_list, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        try {
            JSONObject event = events.getJSONObject(position);
            holder.note_title.setText(event.getString("title"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        Picasso.get().load(chapter.imageUrl).into(holder.ivChapter);
    }

    @Override
    public int getItemCount() {
        return events.length();
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivChapter;
        public TextView note_title;

        public CustomViewHolder(View itemView) {
            super(itemView);
            note_title = (TextView) itemView.findViewById(R.id.note_title);
//            ivChapter = (ImageView) itemView.findViewById(R.id.ivChapter);
        }
    }


}

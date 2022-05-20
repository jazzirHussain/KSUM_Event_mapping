package com.example.ksumeventmapping;

import android.view.View;

import org.json.JSONObject;

public interface ItemClickListener {
    void onClick(View view, JSONObject event);
}

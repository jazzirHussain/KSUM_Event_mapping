package com.example.ksumeventmapping;

import java.util.HashMap;

public class Building {

    HashMap<String,Integer> query=new HashMap<String,Integer>();

    public Building(){
        add();
    }

    public void add()
    {
        query.put("Open Area - Digital Hub" , 2);
        query.put("Amphitheatre" , 1);
        query.put("Conference Hall",1);
        query.put("Conference Room",1);
        query.put("Meeting Room",1);
        query.put("Main Stage - Digital Hub",2);
        query.put("Digital Hub & Integrated Startup Complex",1);
        query.put("Fab Zone",1);
        query.put("Expo Zone",2);
        query.put("Food Street",2);
        query.put("Maker Hub",1);
        query.put("Design District",2);

    }
    public int getBuilding(String room_name)
    {

        if(query.containsKey(room_name)){
            return query.get(room_name);
        }
        return 0;

    }
}

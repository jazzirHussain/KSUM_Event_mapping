package com.example.ksumeventmapping;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;
public class DatabaseHelper extends SQLiteOpenHelper
{

    public static final String DB_NAME="STARTUPMISSION.DB"; //.db extension must use
    public static final int DB_VERSION=1;

    public static final String table_name1 = "event";
    public static final String event_id = "event_id";
    public static final String date = "date_time";
    public static final String event_name = "event_name";
    public static final String fee = "fee";
    public static final String desc ="desc";
    public static final String cor = "cor";
    public static final String room_id = "room id";

    private static final String CREATE_TABLE_EVENT = "CREATE TABLE IF NOT EXISTS " + table_name1 + "(" + event_id + " INTEGER AUTOINCREMENT," + event_name +" VARCHAR(40) not null," + date + " TIMESTAMP NOT NULL" +  fee + " VARCHAR(20) NOT NULL," + room_id + " VARCHAR(40) NOT NULL," + desc + " VARCHAR(100)," + cor + " INT NOT NULL, PRIMARY KEY ("+ event_id + "),FOREIGN KEY (" + room_id + ") REFERENCES ROOM(" + room_id + ");";

    public static final String table_name2 = "room";
    public static final String room_no = "room_no";
    public static final String room_name = "room name";
    public static final String building_no = "building_no";

    private static final String CREATE_TABLE_ROOM = "CREATE TABLE IF NOT EXISTS " + table_name2 + "(" + room_id + " INTEGER PRIMARY KEY AUTO INCREMENT," + room_no + "INTEGER NOT NULL UNIQUE," + room_name + " VARCHAR(20)" + building_no + " INT NOT NULL, FOREIGN KEY (" + building_no + ") REFERENCES BUILDING(" + building_no + "));";

    public static final String table_name3 = "building";
    public static final String building_name = "building_name";

    private static final String CREATE_TABLE_BUILDING = "CREATE TABLE IF NOT EXISTS " + table_name3 + "(" + building_no + " INTEGER PRIMARY KEY," + building_name + " VARCHAR(20));";
    public static final String insert1 = "INSERT INTO " + table_name1 +  " VALUES (1,'Cyclothon','2022-05-22 06:00:00', 'free' , 'Main Entrance' , 'This years Kerala Innovation Week will kick off with a 25 km Cyclothon, Starting from KTIZ and passing through Infopark and returning back.This year kerala innovation will kick off ', 111),(2,'2022-05-22 10:00:00','Youth Leadership Summit','Paid','Amphitheatre','no desc',222),(3,'Codeathon','2022-05-23 10:00:00','Free','Wanna bring out that coding geek in you? Wanna dive deep into world of codes and logic?Then let's make an early shot for it with CODE-A-THON, a one day workshop exclusively for Age Group of 10-18 years,jointly hosted by Kerala Innovation Week and KODERFIN.',333),(4,'Makeathon','2022-05-23 03:00:00' , 'Free' , 'Confrence Hall','No desc',444 )";
    public static final String insert2 = "INSERT INTO " + table_name1 +  " VALUES (5, 'Robotics Workshop' ,'2022-05-24 06:00:00' , 'Kerala Innovation Week along with Inker Robotics is here with an exciting 'Workshop on Robotics', a 1- day event to mould your technical skills and unleash your creative spirits. ','Free',''Confrence Hall',)";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}


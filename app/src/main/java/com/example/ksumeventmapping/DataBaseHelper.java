package com.example.ksumeventmapping;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class







DataBaseHelper extends SQLiteOpenHelper
{

    public static final String DB_NAME="STARTUPMISSION.db"; //.db extension must use
    public static final int DB_VERSION=1;

    public static final String table_name1 = "event";
    public static final String event_id = "event_id";
    public static final String date = "date_time";
    public static final String event_name = "event_name";
    public static final String fee = "fee";
    public static final String desc ="descr";
    public static final String cor = "cor";
    public static final String room_id = "room_id";

    public static final String table_name2 = "room";
    public static final String room_name = "room_name";
    public static final String building_no = "building_no";

    public static final String table_name3 = "building";
    public static final String building_name = "building_name";

    private static final String CREATE_TABLE_EVENT = "CREATE TABLE IF NOT EXISTS "
            + table_name1 + "("
            + event_id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + event_name +" VARCHAR(50) not null ,"
            + date + " TIMESTAMP NOT NULL , "
            +  fee + " VARCHAR(20) NOT NULL ,"
            + room_id + " VARCHAR(50) ,"
            + desc + " VARCHAR(500),"
            + cor + " INTEGER NOT NULL,"
            + "FOREIGN KEY("+room_id+") REFERENCES "+table_name2+"(" + room_name + "));";
//      private static final String CREATE_TABLE_EVENT = "CREATE TABLE IF NOT EXISTS " + table_name1 + "(" + event_id + "INTEGER PRIMARY KEY AUTOINCREMENT ," + event_name +" VARCHAR(50) not null ," + date + " TIMESTAMP NOT NULL , " +  fee + " VARCHAR(20) NOT NULL ," + room_id + "VARCHAR(60) NOT NULL FORIEGN KEY(" + room_id + "), REFERENCES room( " + room_id + " " + desc + " VARCHAR(500)," + cor + " INT NOT NULL );";

    private static final String CREATE_TABLE_ROOM = "CREATE TABLE IF NOT EXISTS " + table_name2 + " (" +  room_id + " INTEGER PRIMARY KEY, " +  room_name +" VARCHAR(50) not null, " + building_no + " INTEGER NOT NULL, FOREIGN KEY(" + building_no + ") REFERENCES BUILDING(" + building_no + "));";
    private static final String CREATE_TABLE_BUILDING = "CREATE TABLE IF NOT EXISTS " + table_name3 + "(" + building_no + " INTEGER PRIMARY KEY," + building_name + " VARCHAR(20));";

    private static final String DROP_TABLE_EVENT = "DROP TABLE IF EXISTS " + table_name1 + ";";
    private static final String DROP_TABLE_ROOM = "DROP TABLE IF EXISTS " + table_name2 +  ";";
    private static final String DROP_TABLE_BUILDING = "DROP TABLE IF EXISTS " + table_name3 + ";";


    public static final String insert1_event = "INSERT INTO " + table_name1 +  " VALUES (1,'Cyclothon','2022-05-22 06:00:00', 'free' , 'Main Entrance' , 'This years Kerala Innovation Week will kick off with a 25 km Cyclothon, Starting from KTIZ and passing through Infopark and returning back.This year kerala innovation will kick off ', 111),(2,'Community Leaders Summit', '2022-05-22 10:00:00', 'Paid','Amphitheatre','',222),(3,'Codeathon','2022-05-23 10:00:00','Free','Amphitheatre','Wanna bring out that coding geek in you? Wanna dive deep into world of codes and logic?Then lets make an early shot for it with CODE-A-THON, a one day workshop exclusively for Age Group of 10-18 years,jointly hosted by Kerala Innovation Week and KODERFIN.',333),(4,'Makeathon','2022-05-23 15:00:00' , 'Free' , 'Conference Hall','',444 ); ";
    public static final String insert2_event = "INSERT INTO " + table_name1 +  " VALUES (5, 'Robotics Workshop' ,'2022-05-24 06:00:00' ,'Free','Conference Hall', 'Kerala Innovation Week along with Inker Robotics is here with an exciting Workshop on Robotics, a 1- day event to mould your technical skills and unleash your creative spirits. ', 555),(6,'Designathon : Day-1', '2022-05-24 14:00:00', 'Invite Only' , 'Amphitheatre' , 'Kerala Innovation Week in partnership with Canva-the one-stop for all our design needs brings to you Design-A-Thon, a 24 Hour Theme-based Design Challenge using Canva. For the First Time in India in partnership with Canva,we bring forth to you Design-A-Thon.' ,666), (7,'Buildathon : Day-1' , '2022-05-25 14:00:00' , 'Invite Only' , 'Amphitheatre' , 'Kerala Innovation Week in association with Gtech uLearn is organising an exciting 24-Hour Offline Hackathon: Build-A-Thon, Design.Build.Ship. Build-A-Thon is all about the pure joy of creating. With two verticals, Design & Maker, anyone who is interested in design / hardware / software are welcome to participate. ', 777); " ;
    public static final String insert3_event = "INSERT INTO " + table_name1 +  " VALUES (8 , 'Why Hack - Women : Day-1' , '2022-05-25 09:00:00' , 'Invite Only' , 'Conference Hall' , 'Kerala Innovation Week along with EY brings to you whyHack - a nerve wracking Hackthon exclusively for Women ' , 888), (9 , 'Investor Cafe' , '2022-05-25 10:00:00' , 'Invite Only' , 'Conference Room' , '' , 999) , (10, 'Mentor Clinic - Office Hours' , '2022-05-27 12:00:00' , 'Invite Only' , 'Meeting Room' , '' , 000), (11 , 'Pitch Fest' , '2022-05-26 10:00:00' , 'Invite Only' , 'Conference Room' , 'Kerala Startup Mission presents the best oppurtunity for startups looking to raise funds. Pitch your ideas before an Investor Panela nd stand a chance to be funded at the Kerala innovation week.' , 1111) , (12, 'Buildathon : Day-2' , '2022-05-26 15:00:00' , 'Free' , 'Amphitheatre' , '' , 2222), (13 , 'Why Hack: Day-2' , '2022-05-26 15:00:00' , 'Free' , 'Conference Hall' , 'Kerala Innovation Week along with EY brings to you whyHack - a nerve wracking Hackathon exclusively for Women ' , 3333), (14 , 'SHE Power Summit' , '2022-05-27 14:00:00' , 'Free', 'Amphitheatre' , '' , 4444); ";
    public static final String insert4_event = "INSERT INTO " + table_name1 +  " VALUES (15 , 'Founders Summit' , '2022-05-27 06:00:00' , 'Invite Only' , 'Amphitheatre' , '' , 5555), (16 , 'Standup Comedy' , '2022-05-27 10:00:00' , 'Free' , 'ISC' , '' , 6666), (17, 'Design Challenge' , '2022-05-27 16:00:00' , 'Free' , 'Conference Hall' , 'As a part of Kerala Innovation Week, KSUM brings you an opportunity to portray your creative ideas through the event Design Challenge.Cash prizes worth 100K.' , 7777) , (18 , 'Design & Maker Fest' , '2022-05-28 10:00:00' , 'Free' , 'ISC' , 'Kerala Innovation Week presents an astounding exhibition to showcase your Fab/DIY Projects as part of our Design and Maker Fest. So Why wait?Hold on your creative hands together and walk onto Indias largest Design and Maker Fest on 28th of May.' , 8888) , (19, 'Creators Summit' , '2022-05-28 14:00:00' , 'Paid' , 'Main Stage - Digital Hub' , '' , 9999) , (20 , 'Fashion Show' , '2022-05-28 18:00:00' , 'Free' , 'Main Stage - Digital Hub' , '' , 0000), (21 , 'Flea Bazaar' , '2022-05-28 15:00:00' , 'Paid' , 'Expo Zone' , 'The old is the new here! Witness a one-of-a-kind Flea Bazaar on the culmination day of Kerala Innovation Week. A huge line-up of captivating activities to check out and get absorbed in.' , 11111) , (22 , 'Entertainment Festival' , '2022-05-28 19:00:00' , 'Paid' , 'Main Stage - Digital Hub' , 'no desc' , 22222) , (23 , 'KITE - Student Product Showcase' , '2022-05-28 10:00:00' , 'Invite Only' , 'Maker Hub 2' , 'Kerala Startup Mission brings the best opportunity for the young master minds and innovators to flaunt their products.Be a part of Student Product Showcase Kerala Innovators Technology Expo and let the world know about your products at Kerala Innovation Week.' , 33333) , (24 , 'Product Expo' , '2022-05-28 10:00:00' , 'Invite Only' , 'Maker Hub 1' , 'Showcase your innovative products to a host of tech leaders at the Kerala Innovation Week. The platform will bring people from technology and innovation industry across different sectors. Get valuable market exposure and potential clientele seeking latest tech innovations and product solutions' , 44444) , (25 , 'Live Experiences' , '2022-05-28 10:00:00' , 'Free' ,  'Design District' , '' , 55555) , (26 , 'Design/Maker/3D Installations' , '2022-05-28 10:00:00' , 'Free' , 'Design District' , '' , 66666) , (27 , 'Food Fest' , '2022-05-28 10:00:00' , 'Free' , 'Food Street' , '' , 77777) , (28 , 'Fab/DIY Project Showcase' , '2022-05-28 10:00:00' , 'Invite Only' , 'Fab Zone' , '',88888) , (29 , 'Google I/O Extended' , '2022-05-28 10:00:00' , 'Invite Only' , 'Amphitheatre' , '' , 99999 ) , (30 , 'Rink-Research Product Expo' , '2022-05-28 10:00:00' , 'Invite Only' , 'Maker Hub' , 'Are you a researcher with an entrancing technology or product that could amuse tech geeks?Come and showcase your projects at Kerala Innovation weeks research innovation demo day' , 111111 ) , (31 , 'Python Workshop' , '2022-05-24 10:00:00' , 'Free' , 'Confrence Room' , '' , 444444 )";

    public static final String insert_room = "INSERT INTO " + table_name2 + " VALUES (1,'Conference Hall', 1) , (2 , 'Maker Hub - 1' , 2) , (3 , 'Maker Hub -2' , 1) , (4,'Design District',2) , (5,'ISC',1) , (6,'Main Entrance',1) , (7,'Food Street',2) , (8,'Conference Room',1) , (9,'Amphitheatre',1) , (10,'Main Stage - Digital Hub',2) , (11,'Expo Zone',2) , (12,'Meeting Room',1) , (13 , 'Fab Zone' , 1);  ";

    public static final String insert_building = "INSERT INTO " + table_name3 + " VALUES (1 , 'Integrated Start-up Complex'), (2, 'Digital Hub'); ";

    public DataBaseHelper(@Nullable Context context)
    {

        super(context, DB_NAME, null, DB_VERSION);
        Log.i("Check","entered in database constructor");
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        Log.i("Check","entered in database creator");
        sqLiteDatabase.execSQL(CREATE_TABLE_BUILDING);
        sqLiteDatabase.execSQL(CREATE_TABLE_ROOM);
         sqLiteDatabase.execSQL(CREATE_TABLE_EVENT);

        sqLiteDatabase.execSQL(insert_building);
        sqLiteDatabase.execSQL(insert_room);
        sqLiteDatabase.execSQL(insert1_event);
        sqLiteDatabase.execSQL(insert2_event);
        sqLiteDatabase.execSQL(insert3_event);
        sqLiteDatabase.execSQL(insert4_event);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        Log.i("Check","entered in database upgrade");
        sqLiteDatabase.execSQL(DROP_TABLE_EVENT);
        sqLiteDatabase.execSQL(DROP_TABLE_ROOM);
        sqLiteDatabase.execSQL(DROP_TABLE_BUILDING);
        onCreate(sqLiteDatabase);
    }

    public ArrayList<CourseModal> convertToCourseAll(Cursor cursorCourses){
        ArrayList<CourseModal> courseModalArrayList = new ArrayList<>();
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new CourseModal(cursorCourses.getString(1),
                        cursorCourses.getString(5),
                        cursorCourses.getString(2),
                        cursorCourses.getString(4),
                        cursorCourses.getInt(9)
                ));
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        return courseModalArrayList;
    }
    public ArrayList<CourseModal> convertToCourse(Cursor cursorCourses){
        ArrayList<CourseModal> courseModalArrayList = new ArrayList<>();
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new CourseModal(cursorCourses.getString(1),
                        cursorCourses.getString(5),
                        cursorCourses.getString(2),
                        cursorCourses.getString(4),
                        1
                ));
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        return courseModalArrayList;
    }

    public ArrayList<CourseModal> getEventData(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCourses = db.rawQuery("SELECT * FROM "+table_name1+","+table_name2+","+table_name3+" WHERE "+event_name+" = ? AND "+table_name1+"."+room_id+" = "+table_name2+"."+room_name+" AND "+table_name2+"."+building_no+" = "+table_name3+"."+building_no+";",new String[] {name});
        return convertToCourseAll(cursorCourses);
    }
    public ArrayList<CourseModal> getAllEventData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCourses = db.rawQuery("SELECT * FROM "+table_name1+";",null);
        return convertToCourse(cursorCourses);
    }
}
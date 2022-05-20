package com.example.ksumeventmapping;

import android.os.Parcel;
import android.os.Parcelable;

public class CourseModal implements Parcelable {
    private String name;
    private String desc;
    private String time;
    private String room;
    private int building;
    private int id;


    // variables for our coursename,
    // description, tracks and duration, id.


    protected CourseModal(Parcel in) {
        name = in.readString();
        desc = in.readString();
        time = in.readString();
        room = in.readString();
        building = in.readInt();
        id = in.readInt();
    }

    public static final Creator<CourseModal> CREATOR = new Creator<CourseModal>() {
        @Override
        public CourseModal createFromParcel(Parcel in) {
            return new CourseModal(in);
        }

        @Override
        public CourseModal[] newArray(int size) {
            return new CourseModal[size];
        }
    };

    // creating getter and setter methods
    public String getName() {
        return name;
    }

    public void setCourseName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setCourseDuration(String courseDuration) {
        this.desc = courseDuration;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRoom() {
        return room;
    }

    public int getBuilding() {
        return building;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // constructor
    public CourseModal(String name, String courseDuration, String time, String room, int building) {
        this.name = name;
        this.desc = courseDuration;
        this.time = time;
        this.room = room;
        this.building = building;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(desc);
        dest.writeString(time);
        dest.writeString(room);
        dest.writeInt(building);
        dest.writeInt(id);

    }
}
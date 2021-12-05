package com.example.studentsapp.model;

public class Student {
    private String id = "";
    private String name = "";
    private boolean flag = false;
    private int pictureRid;         //Picture Resource id

    //Constructors
    public Student(){}
    public Student(String id, String name, boolean flag) {
        this.name = name;
        this.id = id;
        this.flag = flag;
    }
    public Student(String id, String name, boolean flag, int pictureRid) {
        this.name = name;
        this.id = id;
        this.flag = flag;
        this.pictureRid = pictureRid;
    }

    //Getters & Setters
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public boolean isFlagged() {
        return flag;
    }
    public int getPictureRid() {
        return pictureRid;
    }
    public void setPictureRid(int pictureRid) {
        this.pictureRid = pictureRid;
    }
}
package com.example.clientapp;

public class order {

    private String name;
    private int red;
    private int green;
    private int orange;
    private int yellow;
    private int location1;
    private int location2;

    order(){

    }
    order(String n, int r, int g, int o, int y, int lo1, int lo2){

        name = n;
        red = r;
        green = g;
        orange = o;
        yellow = y;
        location1 = lo1;
        location2 = lo2;
    }

    public String getName(){return name;}
    int getRed(){return red;}
    int getGreen(){return green;}
    int getOrange(){return orange;}
    int getYellow(){return yellow;}
    public int getLocation1(){return location1;}
    public int getLocation2(){return location2;}

}

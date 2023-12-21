package com.factweavers.tutorials.handson.Day2;

import java.util.ArrayList;

public class Airport {
    String name;
    String location;
    int noOfPlanes;

    Airport(String name,String location,int noOfPlanes){
        this.name=name;
        this.location=location;
        this.noOfPlanes=noOfPlanes;

    }

    @Override
    public String toString() {
        return "Airport{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", noOfPlanes=" + noOfPlanes +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNoOfPlanes() {
        return noOfPlanes;
    }

    public void setNoOfPlanes(int noOfPlanes) {
        this.noOfPlanes = noOfPlanes;
    }

}

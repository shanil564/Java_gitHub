package com.factweavers.tutorials.handson.Day2;

public class PrivateAirport extends Airport{
    String owner;
    PrivateAirport(String name,String location,int noOfPlanes,String owner){
        super(name,location,noOfPlanes);
        this.owner=owner;
    }

    @Override
    public String toString() {
        return "PrivateAirport{" +
                "owner='" + owner + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", noOfPlanes=" + noOfPlanes +
                '}';
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}

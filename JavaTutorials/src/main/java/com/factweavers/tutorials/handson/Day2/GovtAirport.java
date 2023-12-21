package com.factweavers.tutorials.handson.Day2;

public class GovtAirport extends Airport{

    GovtAirport(String name,String location,int noOfPlanes){
        super(name, location,noOfPlanes);

    }

    @Override
    public String toString() {
        return "GovtAirport{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", noOfPlanes=" + noOfPlanes +
                '}';
    }

}

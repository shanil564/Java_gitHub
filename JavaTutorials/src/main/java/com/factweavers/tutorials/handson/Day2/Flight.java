package com.factweavers.tutorials.handson.Day2;

import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Flight {
    private String name;
    private int id;
    private String destination;
    private String origin;
    private Boolean onAir;
    private Date departureTime;
    private Date arrivalTime;
    Flight(String name, int id, String destination, String origin,String departureTime,String arrivalTime) throws ParseException {
        this.name=name;
        this.id=id;
        this.destination = destination;
        this.origin = origin;
        this.onAir=false;
        this.departureTime=new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(departureTime);
        this.arrivalTime= new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(arrivalTime);
    }
    @Override
    public String toString() {
        return "Flight{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", destination='" + destination + '\'' +
                ", origin='" + origin + '\'' +
                ", onAir=" + onAir +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Boolean getOnAir() {
        return onAir;
    }

    public void setOnAir(Boolean onAir) {
        this.onAir = onAir;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) throws ParseException{
        this.departureTime =new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(departureTime);
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) throws ParseException {
        this.arrivalTime =new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(arrivalTime);
    }
}

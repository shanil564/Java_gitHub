package com.factweavers.tutorials.handson.Day1;
import java.lang.*;


public class Animal {
    private String name;
    private String type;
    private Boolean isAlive;
    Animal(String name, String type){
        this.name=name;
        this.type=type;
        this.isAlive=true;
    }
    @Override
    public String toString() {
        return "Animals{" +
                "name='" + this.getName() + '\'' +
                ", type='" + this.getType() + '\'' +
                ", isAlive=" + this.getIsAlive() +
                '}';
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(Boolean isAlive) {
        this.isAlive = isAlive;
    }
}

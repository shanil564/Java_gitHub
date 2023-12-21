package com.factweavers.tutorials.handson.Day1;
import java.lang.*;

public class Bird extends Animal{
    private int wings;
    public Bird(String name, String type, int wings){
        super(name,type);
        this.wings= wings;

    }

    @Override
    public String toString() {
        return "Birds{" +

                ", name='" + this.getName() + '\'' +
                ", type='" + this.getType() + '\'' +
                ", isAlive=" + this.getIsAlive() +", wings=" + wings +
                '}';
    }
}

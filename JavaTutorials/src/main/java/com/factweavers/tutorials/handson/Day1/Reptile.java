package com.factweavers.tutorials.handson.Day1;
import java.lang.*;

public class Reptile extends Animal{
    private int length;
    Reptile(String name, String type, int length) {
        super(name, type);
        this.length =length;

    }


    public String toString() {
        return "Reptile{" +
                "length=" + length +
                ", name='" + this.getName() + '\'' +
                ", type='" + this.getType() + '\'' +
                ", isAlive=" + this.getIsAlive() +
                '}';
    }
}

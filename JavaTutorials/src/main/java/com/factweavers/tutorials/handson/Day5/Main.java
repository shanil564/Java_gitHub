package com.factweavers.tutorials.handson.Day5;
import com.opencsv.CSVWriter;
import java.io.FileWriter;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Main {
    public static Logger logger=Logger.getLogger(Main.class);
    public static void main(String[] args) throws Exception {
        BasicConfigurator.configure();
        CSVWriter asd = new CSVWriter(new FileWriter("new13.csv"));
        CsvFileReader thread=new CsvFileReader(0,3,asd);
        CsvFileReader thread1=new CsvFileReader(3,6,asd);
        thread.start();
        thread1.start();
        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        asd.close();
    }
}

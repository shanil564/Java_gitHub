package org.asd;

import com.google.gson.Gson;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.util.SortedMap;
import java.util.TreeMap;

public class MapToJson {
    public static Logger logger=Logger.getLogger(MapToJson.class);
    public static void main(String[] args) {
        BasicConfigurator.configure();
        SortedMap<String, String> elements = new TreeMap<>();
        elements.put("jasmine", "white");
        elements.put("sunflower", "yellow");
        elements.put("lotus", "pink");
        Gson gson = new Gson();
        String gsonString = gson.toJson(elements);
        logger.info(gsonString);





    }
}
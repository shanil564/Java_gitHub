
package com.factweavers.tutorials.handson.Day4;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.asd.MapToJson;
import org.json.*;
import com.google.gson.JsonObject;
import  com.google.gson.JsonParser;


import java.io.FileReader;
import java.util.Iterator;

public class JsonFileToObject {
    public static Logger logger=Logger.getLogger(JsonFileToObject.class);
    public static void main(String[] args) {
        BasicConfigurator.configure();
        JsonParser parser = new JsonParser();
        try {
            Object obj = parser.parse(new FileReader("/home/dbiz/test.json"));
            logger.info(obj);

            JSONObject jsonObject = (JSONObject) obj;
            String ID=(String) jsonObject.get("ID");
            String name=(String) jsonObject.get("First_Name");
            String lastname=(String) jsonObject.get("Last_Name");
            String dob=(String) jsonObject.get("Date_Of_Birth");
            String place=(String) jsonObject.get("Place_Of_Birth");
            String salary=(String) jsonObject.get("Salary");
            JSONArray companyList = (JSONArray) jsonObject.get("contact");
            logger.info(ID);
            logger.info(name);
            logger.info(lastname);
            logger.info(dob);
            logger.info(place);
            logger.info(salary);
            Iterator<Object> iterator = companyList.iterator();
            while (iterator.hasNext()) {
                logger.info(iterator.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

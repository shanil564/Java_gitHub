package org.json;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.asd.MapToJson;

public class JsonStringToObject {
    public static Logger logger=Logger.getLogger(JsonStringToObject.class);
    public static void main(String[] args) {
        BasicConfigurator.configure();
        String str = "[{\"No\":\"1\",\"Name\":\"Adithya\"},{\"No\":\"2\",\"Name\":\"Jai\"}, {\"No\":\"3\",\"Name\":\"Raja\"}]";
        JSONArray array = new JSONArray(str);
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            logger.info(object.getString("No"));
            logger.info(object.getString("Name"));
        }
    }
}

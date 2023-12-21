package com.factweavers.tutorials.handson.day6;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TextFileReader {
        private Logger logger=Logger.getLogger(this.getClass());
        public List<String> getWordsFromFile(String filePath) {
                try {
                        List<String> list = new ArrayList<>();
                        String temp = "";
                        BufferedReader reader = new BufferedReader(new FileReader(filePath));
                        while ((temp = reader.readLine()) != null) {
                                String[] stringArray = temp.toLowerCase().split("[^\\w-]+");
                                list.addAll(List.of(stringArray));
                        }
                        return list;
                } catch (Exception e) {
                        logger.info(e.getMessage());
                }
                return null;
        }
}





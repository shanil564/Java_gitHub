package com.factweavers.tutorials.handson.day6;
import com.factweavers.tutorials.handson.ConfigurationLoader.ConfigurationLoader;
import com.factweavers.tutorials.handson.Constants.Constants;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.util.*;

public class Main {
    private static final Properties properties = ConfigurationLoader.getInstance().getProperties();
    private static final String textFilePath = properties.getProperty(Constants.TEXT_FILE_PATH);
    private static final String stoppingWordFilePath = properties.getProperty(Constants.STOPPING_FILE_PATH);
    public static Logger logger= Logger.getLogger(Main.class);
    public static void main(String[] args) {
        BasicConfigurator.configure();
        TextFileReader textFileReader=new TextFileReader();
        FileHandler fileHandler =new FileHandler();
        List<String> wordsList=textFileReader.getWordsFromFile(textFilePath);
        List<String> stoppingWords=textFileReader.getWordsFromFile(stoppingWordFilePath);
        Map<String,Integer> wordsCountMap= fileHandler.getWordCount(wordsList);
        logger.info("word counter=============\n"+wordsCountMap);
        logger.info("unique word==============");
        fileHandler.getUniquewords(wordsCountMap);
        logger.info("without Stopping words============");
        fileHandler.removeStoppingWords(wordsList,stoppingWords);
        logger.info("sort based on word ================");
        fileHandler.sortBasedOnWord(wordsCountMap);
        logger.info("sort based on count ====================");
        fileHandler.sortBasedOnCount(wordsCountMap);
    }
}



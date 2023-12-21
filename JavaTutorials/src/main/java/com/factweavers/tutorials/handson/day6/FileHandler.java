package com.factweavers.tutorials.handson.day6;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileHandler {
    Map<String,Integer> map=new HashMap<>();
    private Logger logger=Logger.getLogger(this.getClass());
    public  void getUniquewords(Map<String,Integer> wordsCountMap){
        wordsCountMap.entrySet().stream().filter(m->m.getValue()==1).forEach(m-> logger.info(m.getKey()));
    }
    public Map<String,Integer> getWordCount(List<String> wordsList){
        wordsList.stream().forEach(m->{if(map.containsKey(m)){map.put(m,map.get(m)+1);}
        else{
            map.put(m,1);
        }
        });
        return map;
    }
    public void removeStoppingWords(List<String> wordsList, List<String> stopWordsList){
        wordsList.parallelStream().forEach(n->{if(!stopWordsList.contains(n)){logger.info(n);}});
    }
    public void sortBasedOnCount(Map<String,Integer> wordsCountMap){
        wordsCountMap.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed()).forEach(m-> System.out.println(m.getKey()));
    }
    public void sortBasedOnWord(Map<String,Integer> wordsCountMap){
        //map1.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(m-> logger.info(m.getKey()));
        wordsCountMap.keySet().stream().sorted().forEach(m-> logger.info(m));
    }
}

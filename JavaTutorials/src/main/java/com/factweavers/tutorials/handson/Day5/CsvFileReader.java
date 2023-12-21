package com.factweavers.tutorials.handson.Day5;
import com.factweavers.tutorials.handson.ConfigurationLoader.ConfigurationLoader;
import com.factweavers.tutorials.handson.Constants.Constants;
import com.opencsv.CSVWriter;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CsvFileReader extends Thread {
    private int start;
    private int stop;
    List<String> list = new ArrayList<String>();
    private Logger logger;
    private static final Properties properties = ConfigurationLoader.getInstance().getProperties();
    private static final String siteLink = properties.getProperty(Constants.INPUT_CSV_FILE_PATH);
    BufferedReader br = new BufferedReader(new FileReader(siteLink));
    private CSVWriter csvWriter;
    CsvFileReader(int start, int stop, CSVWriter csvWriter) throws Exception {
        this.start = start;
        this.stop = stop;
        this.csvWriter = csvWriter;
        this.logger=Logger.getLogger(this.getClass());
        String line = "";
        br.readLine();
        while (((line = br.readLine()) != null)) {
            String[] row = line.split(",");
            String b = row[1];
            list.add(b);
        }
    }
    @Override
    public void run() {
        try {
            running();
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
    }
    public void running() throws Exception {
        int m = 1;
        List<String> l1 = list.subList(start, stop);
        for (String url : l1) {
            Document doc = Jsoup.connect(url).get();
            String title = doc.title();
            String description = doc.select("meta[name=description]").get(0).attr("content");
            String[] l = {String.valueOf(m), url, title, description};
            logger.info("string" + new JSONArray(l));
            csvWriter.writeNext(l);
            ++m;
        }
    }
}

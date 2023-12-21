package com.factweavers.tutorials.handson.Day3;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
public class ScraperOperaion {
    public static int retryCount = 0;
    private Logger logger;
    private Document doc;
    private String link;
    ScraperOperaion(String url) throws  Exception {
        this.logger = Logger.getLogger(this.getClass());
        this.link=url;
        this.doc=Jsoup.connect(link).get();
    }
    void siteTitle() {
        try {
            String title = doc.title();
            logger.info(title);
        } catch (Exception e) {
            logger.error(e + "exception ");
        }
    }
    void siteLink() {
        try {
            //Document doc = Jsoup.connect(name).get();
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                logger.info("\nlink : " + link.attr("href"));
                logger.info("text : " + link.text());
            }
        } catch (Exception e) {
            logger.error("error occur");
        }
    }
    void siteContent() {
        try {
            String keywords = doc.select("meta[name=keywords]").first().attr("content");
            logger.info("Meta keyword : " + keywords);
            String description = doc.select("meta[name=description]").get(0).attr("content");
            logger.info("Meta description : " + description);
        } catch (Exception e) {
            logger.error("occur " + e);
            if (retryCount < 3) {
                retryCount++;
                siteContent();
            }
        }
    }
    void fileTitle() {
        try {
            Document doc = Jsoup.parse(new File("/home/dbiz/Desktop/s.html"), "utf-8");
            String title = doc.title();
            String head= String.valueOf(doc.select("h1"));
            logger.info(head);
            logger.info(title);
        } catch (Exception e) {
            logger.error("Exception occur   " + e);
        }
    }
}

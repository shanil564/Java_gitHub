package com.factweavers.tutorials.handson.Day3;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.util.Scanner;

public class Scraper {
    public static Logger logger = Logger.getLogger(Scraper.class);
    public static void main(String[] args) throws Exception{
        BasicConfigurator.configure();
        Scanner scanner=new Scanner(System.in);
        logger.info("PLease Enter The Site Name");
        String siteName=scanner.nextLine();
        String url="http://www."+siteName+".com";
        ScraperOperaion operator=new ScraperOperaion(url);
        operator.fileTitle();
        operator.siteTitle();
        operator.siteContent();
        operator.siteLink();

    }
}

package com.factweavers.tutorials.handson.Day2;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.text.ParseException;

public class AirportController {
    public static Logger logger = Logger.getLogger(AirportController.class);
    public static void main(String[] args) throws ParseException {
        BasicConfigurator.configure();
        logger.info("\n welcome to airport \n");
        Airport karipoor=new GovtAirport("karipoor","kozhikode",23);
        Airport nedumbassery=new PrivateAirport("nedumbassery","kochi",30,"adani");
        Flight indiGo= new Flight("indiGo",535,"karipoor","kochi","1/2/2023 02:21","1/2/2023 04:23");
        Flight jetairways= new Flight("jetairway",525,"kochi","karipoor","1/2/2023 15:21","1/2/2023 15:23");
        Flight airIndia=new Flight("airIndia",245,"kochi","karipoor","1/2/2023 12:32","1/2/2023 17:30");
        AirpotManager shanil=new AirpotManager();
        shanil.addFlight(indiGo);
        shanil.addFlight(airIndia);
        shanil.addFlight(jetairways);
        shanil.scheduleTrip(indiGo,"kochi","karipoor","2/2/2023 23:23","2/2/2023 00:32");
        shanil.getFlightStatusInAirport("karipoor","1/2/2023 13:01");
        shanil.searchByAirport("kochi");
        shanil.flightTripAt("karipoor","kochi","1/2/2023 13:23");
    }
}

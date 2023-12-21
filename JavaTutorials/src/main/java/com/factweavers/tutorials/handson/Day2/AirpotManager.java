package com.factweavers.tutorials.handson.Day2;
import org.apache.log4j.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AirpotManager {
    private ArrayList<Flight> flights;
    private Logger logger;
    AirpotManager(){
        this.flights=new ArrayList<Flight>();
        this.logger=Logger.getLogger(this.getClass());
    }
    void addFlight(Flight name){
        flights.add(name);
    }
    void scheduleTrip(Flight name,String from,String to,String departureTime,String arrivaltime) throws ParseException{
            name.setOrigin(from);
            name.setDestination(to);
            name.setDepartureTime(departureTime);
            name.setArrivalTime(arrivaltime);
        logger.info("\nschedule trip from "+name.getOrigin()+" \n"+name);
    }
    void getFlightStatusInAirport(String airportName, String time) throws ParseException {
        for(Flight flightt:flights){
            if (flightt.getOrigin().equalsIgnoreCase(airportName)){
                Date date1=new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(time);
                if (date1.after(flightt.getDepartureTime())){
                    logger.info("\nflight in "+flightt.getOrigin()+" \n"+flightt);
                }
                else{
                    logger.info("\nflight is on air :\n"+flightt);
                }
            }
        }
    }
    void searchByAirport(String place){
        for(Flight i:flights){
            if (i.getOrigin().equalsIgnoreCase(place)){
                logger.info("\nFlights in "+i.getOrigin()+" \n"+i);
            }
        }
    }
    void flightTripAt(String from,String to,String date) throws ParseException{
        for(Flight flightt:flights){
            if ((flightt.getOrigin().equalsIgnoreCase(from)) && flightt.getDestination().equalsIgnoreCase(to)){
                Date date1=new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(date);
                if (date1.after(flightt.getDepartureTime())){
                    logger.info("\nflight from "+flightt.getOrigin()+" to "+flightt.getDestination()+"\n"+flightt.getOrigin()+" "+flightt);
                }
            }
        }
    }
    void showflights(){
        for(Flight flight:flights){
        }
    }
    @Override
    public String toString() {
        return "AirpotManager{" +
                "flights=" + flights +
                '}';
    }
}

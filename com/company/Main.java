package com.company;

import com.company.enums.Gender;
import com.company.exceptions.CreateException;
import com.company.models.*;
import com.company.services.CabBookingService;

import java.util.List;

public class Main {
    public static void main(String[] args){
        CabBookingService Uber = CabBookingService.getInstance();

        // Rider 

        Location from = new Location(12, 20);
        Location to = new Location(18, 18);

        Rider rider1 =  null;
        try
        {
            rider1 = Uber.registerRider("Maheli Dutta", 1, Gender.FEMALE, from, to);
            System.out.println("Rider_ID : "+rider1.getId()+ " Rider_Name : "+ rider1.getName() + " Successfully Registered.");
            System.out.println("Rider_Current_Location : "+from.getX()+","+from.getY());
            System.out.println();


        }
        catch(CreateException e){
            e.getMessage();
        }



        // List of Cabs 

        // Cab-1 
        
        Location cab1_Location = new Location(3, 3);
        Vehicle cab1_Vehicle = new Vehicle("Audi", 6, cab1_Location);
        Driver cab1_Driver = null;
        try
        {
            cab1_Driver = Uber.registerDriver("Srikant", 23, Gender.MALE, cab1_Vehicle, true);
        }
        catch(CreateException e){
            e.getMessage();
        }
       

        // Cab-2 

        Location cab2_Location = new Location(4, 4);
        Vehicle cab2_Vehicle = new Vehicle("Indica", 2000, cab2_Location);
        Driver cab2_Driver = null;
        try{
            cab2_Driver = Uber.registerDriver("Raju", 23, Gender.MALE, cab2_Vehicle, false);
        }
        catch(CreateException e)
        {
            e.getMessage();
        }

           // Cab-3 

           Location cab3_Location = new Location(17, 17);
           Vehicle cab3_Vehicle = new Vehicle("Indica", 2000, cab3_Location);
           Driver cab3_Driver = null;
           try{
               cab3_Driver = Uber.registerDriver("Albert Mathew", 28, Gender.MALE, cab3_Vehicle, true);
           }
           catch(CreateException e)
           {
               e.getMessage();
           }

           


        // Booking Ride

        try {
            Driver d11 = Uber.bookRide(1, from, to);
            System.out.println("Ride successfully booked in " +d11.getVehicle().getName()+" "+ d11.getVehicle().getModel() + " and your driver is " + d11.getName());
            System.out.println("Cab current location : "+d11.getVehicle().getLocation().getX()+","+d11.getVehicle().getLocation().getY());

        }
        catch (Exception e)
        {
            e.getMessage();
        }

        List<Ride> rideList = rider1.getRideList();
        for(Ride ride : rideList)
        {
            System.out.println( " Rider :" + ride.getRider().getName() + " From " + ride.getFromLocation().getX()+","+ride.getFromLocation().getY() + " To " + ride.getToLocation().getX()+","+ride.getToLocation().getY());
        }
    }
}

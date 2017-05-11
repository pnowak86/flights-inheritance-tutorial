package com.company;

import com.company.specialflights.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //nothing unusual here...look how toString works when inheritance is used
        System.out.println("\n-- Example 1 --\n");
        ExtendedFlight fe = new ExtendedFlight("KRK", "DFW", 99);
        fe.setCallSign("LO3882");
        System.out.println(fe.toString());
        System.out.println(fe.getExtendedRangeDetails());

        //try to assign specialized instance to more general
        System.out.println("\n-- Example 2 --\n");
        Flight someFlight = fe;
        fe.getExtraTankDescription();
        System.out.println(someFlight.getFlightDescription());
        //can we call getExtendedRange this way? NO!
        //but look how getFlightDescription worked..
        //this "automation" works for @override methods only!


        //but with casting... will work the same way!
        System.out.println("\n-- Example 3 --\n");
        ExtendedFlight fe2 = (ExtendedFlight) someFlight;
        System.out.println(fe2.getFlightDescription());
        //but now we have access to methods not accessible when
        //using more generic Flight type.
        System.out.println(fe2.getExtendedRangeDetails());
        //just like in the beginning when we created instance of fe.

        //important take-away: whenever we "look" at the class instance from perspective of
        //a more generic type - we "loose" specialized behaviours BUT gain automation
        //for overriden methods - just like in case of java interfaces!


        //so we have some "generic" flight here... what specialized flight is that?
        System.out.println("\n-- Example 4 --\n");
        System.out.println(someFlight.getClass().getCanonicalName());
        //...rembember interfaces? we did EXACTLY the same on interface type!
        //...to allow for proper casting to narrow type like in Example 3

        //we create just another instance of subtype IrregularFlight

        IrregularFlight irf = new IrregularFlight("DFW", "JFK", 82);
        System.out.println(irf.getFlightDescription());
        irf.setCallSign("DF2891");
        //note which class's method is it... FLIGHT's ! Implemented because of abstract
        //class AbstractFlight!

        //let's add them all to list!
        ArrayList<Flight> flights = new ArrayList<>();
        flights.add(fe);
        //this worked - why? Extended flight IS A flight!
        flights.add(irf);
        //...worked for the same reason

        //now let's create yet another new flight
        Flight someNewFlight = new IrregularFlight("WAW", "KRK", 21);
        flights.add(someNewFlight);
        //worked because someNewFlights INHERITS from Flight. Remember interfaces?
        someNewFlight.setCallSign("WA882");
        //OF COURSE we can set call sign AFTER adding to list. It's a reference, right?


        System.out.println("\n-- Example 5 --\n");
        for (Flight f : flights) {
            System.out.println(String.format("flight: %s , %s", f.getClass().getCanonicalName(), f.toString()));
        }

        //now, lets create class that inherits from Flight and Extended Flight:
        System.out.println("\n-- Example 6 --\n");
        Flight expFlight = new ExperimentalFlight("KRK", "FRA", 22);
        expFlight.setCallSign("CRASH666");
        System.out.println(expFlight.getFlightDescription());
        //it's clear what's going on. And what if we comment out getFlightDescription in ExperimentalFlight
        //class for a moment? Which method will be called?
        //Answer: inherited one!

        //note - if you call base calss methods on inheriting classes - such casting is clearly reduntand:
        //System.out.println(((Flight) expFlight).getFlightDescription());
       // System.out.println(((ExtendedFlight) expFlight).getFlightDescription());

        System.out.println("\n-- Example 7 --\n");

        //let's add the last flight to the list...
        flights.add(expFlight);
        //now, don't copy/past loop where flights are being printed - create a function!
        printAllFlights(flights);


        //now, one of the flights is going to explode!
        for (Flight flight : flights) {
            if (flight instanceof Destroyable) {
                ((Destroyable) flight).explode();
            }
        }

        System.out.println("\n-- Example 8 --\n");
        //just look at print flights loop and call sign method...
        //these methods can be called because of AbstractFlight -> Flight -> SpecificFlight inheritance.

        System.out.println("\n-- Example 9 --\n");
        for (Flight flight : flights) {
            System.out.print(String.format(" is flight %s inheriting from AbstractFlight ?  ", flight.toString()));
            System.out.println(flight instanceof AbstractFlight);
        }

        for (Flight flight : flights) {
            System.out.print(String.format(" is flight %s inheriting from Flight?  ", flight.toString()));
            System.out.println(flight instanceof Flight);
        }

        for (Flight flight : flights) {
            System.out.print(String.format(" is flight %s implementing Destroyable?  ", flight.toString()));
            System.out.println(flight instanceof Destroyable);
        }

        for (Flight flight : flights) {
            System.out.print(String.format(" is flight %s dangerous?  ", flight.toString()));
            System.out.println(flight instanceof Dangerous);
        }

        System.out.println("-- end --\n");


    }

    //note - what we pass as parameter... it's a... interface reference!
    //more - it's a parametrized interface!
    //where is the implementation? We don't care (but it is some ArrayList instance!)
    private static void printAllFlights(List<Flight> flights) {
        for (Flight f : flights) {
            System.out.println(String.format("flight: %s , %s", f.getClass().getCanonicalName(), f.toString()));
            System.out.println(String.format("call sign is: %s", f.getCallSignId()));
        }
    }
}

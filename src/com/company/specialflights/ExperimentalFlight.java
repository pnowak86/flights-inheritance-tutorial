package com.company.specialflights;

/**
 * Created by adrian on 5/11/17.
 */
public class ExperimentalFlight extends ExtendedFlight implements Destroyable {
    public ExperimentalFlight(String origin, String destination, Integer costIndex) {
        super(origin, destination, costIndex);
    }

    @Override
    public String getFlightDescription() {
        return super.getFlightDescription() + " with Monkey as pilot!";
    }

    @Override
    public void explode() {
        System.out.println(" \n warning warning warning \n");
        System.out.println(" \n this is flight: " + getFlightDescription());
        System.out.println("Arrrrgghhhhhh!!! We're going to die!\n");
        System.out.println("...beceause of:" + bomb);
    }
}

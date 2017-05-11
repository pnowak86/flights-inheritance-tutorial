package com.company.specialflights;

import com.company.Flight;

/**
 * Created by adrian on 5/11/17.
 */
public class ExtendedFlight extends Flight {
    public ExtendedFlight(String origin, String destination, Integer costIndex) {
        super(origin, destination, costIndex);
    }

    @Override
    public String toString() {
        return super.toString() + " ExtendedFlight{}";
    }

    @Override
    public String getFlightDescription() {
        return super.getFlightDescription() + "\n ...but it's a very long flight...";
    }

    public String getExtendedRangeDetails(){
        return "[2 aidditional fuel taks, 1 extra crew onboard, lot's of pizza]";
    }
}

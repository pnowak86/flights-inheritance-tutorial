package com.company.specialflights;

import com.company.Flight;

/**
 * Created by adrian on 5/11/17.
 */
public class IrregularFlight extends Flight {
    public IrregularFlight(String origin, String destination, Integer costIndex) {
        super(origin, destination, costIndex);
    }

    @Override
    public String toString() {
        return super.toString() + " IrregularFlight{}";
    }

    @Override
    public String getFlightDescription() {
        return super.getFlightDescription() + "\n ...but actually - it's a non-scheduled flight with president onboard!";
    }
}

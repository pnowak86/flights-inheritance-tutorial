package com.company;

import com.company.specialflights.AbstractFlight;

/**
 * General base "flight" class.
 */
public class Flight extends AbstractFlight {
    private String origin;
    private String destination;
    private Integer costIndex;
    private String callSign = "abc123";

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }


    public Flight(String origin, String destination, Integer costIndex) {
        this.origin = origin;
        this.destination = destination;
        this.costIndex = costIndex;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getCostIndex() {
        return costIndex;
    }

    public void setCostIndex(Integer costIndex) {
        this.costIndex = costIndex;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", costIndex=" + costIndex +
                '}';
    }

    public String getFlightDescription() {
        return "This is just a flight. Some flight. A journey...";
    }

    @Override
    public String getCallSignId() {
        return callSign;
    }
}

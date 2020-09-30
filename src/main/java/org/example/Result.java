package org.example;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Result {

    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private int travelLength;

    public Result(LocalTime departureTime, LocalTime arrivalTime) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        travelLength = (int) departureTime.until(arrivalTime, ChronoUnit.MINUTES);
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public int getTravelLength() {
        return travelLength;
    }

    @Override
    public String toString() {
        return "Result{" +
                "departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", travelLength=" + travelLength +
                '}';
    }
}

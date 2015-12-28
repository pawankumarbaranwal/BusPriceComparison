package com.pawan.buspricecomparison;


public class BusDetails {

    private String busId;
    private String busName;
    private String sourceCity;
    private String destinationCity;
    private String arrivalTime;
    private String reachingTime;
    private String busCompanyName;
    private String paytmDealer;
    private String redBusDealer;
    private String makeMyTripDealer;
    private Float paytmFare;
    private Float redBusFare;
    private Float makeMyTripFare;


    public BusDetails(String busId, String busName, String sourceCity,
                      String destinationCity, String arrivalTime, String reachingTime,
                      String busCompanyName,
                      String paytmDealer, Float paytmFare,
                      String redBusDealer,  Float redBusFare,
                      String makeMyTripDealer, Float makeMyTripFare) {
        this.busId = busId;
        this.busName = busName;
        this.sourceCity = sourceCity;
        this.destinationCity = destinationCity;
        this.arrivalTime = arrivalTime;
        this.reachingTime = reachingTime;
        this.busCompanyName = busCompanyName;
        this.paytmDealer = paytmDealer;
        this.redBusDealer = redBusDealer;
        this.makeMyTripDealer = makeMyTripDealer;
        this.paytmFare = paytmFare;
        this.redBusFare = redBusFare;
        this.makeMyTripFare = makeMyTripFare;
    }

    public String getBusId() {
        return busId;
    }

    public String getBusName() {
        return busName;
    }

    public String getSourceCity() {
        return sourceCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getReachingTime() {
        return reachingTime;
    }

    public String getBusCompanyName() {
        return busCompanyName;
    }

    public String getPaytmDealer() {
        return paytmDealer;
    }

    public String getRedBusDealer() {
        return redBusDealer;
    }

    public String getMakeMyTripDealer() {
        return makeMyTripDealer;
    }

    public Float getPaytmFare() {
        return paytmFare;
    }

    public Float getRedBusFare() {
        return redBusFare;
    }

    public Float getMakeMyTripFare() {
        return makeMyTripFare;
    }
}
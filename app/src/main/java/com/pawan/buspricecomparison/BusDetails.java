package com.pawan.buspricecomparison;


import java.io.Serializable;

public class BusDetails implements Serializable,Comparable {

    private String busId;
    private String busName;
    private String sourceCity;
    private String destinationCity;
    private String arrivalTime;
    private String reachingTime;
    private String busCompanyName;
    private String cleartripDealer;
    private String paytmDealer;
    private String redBusDealer;
    private String makeMyTripDealer;
    private String cleartripFare;
    private String paytmFare;
    private String redBusFare;
    private String makeMyTripFare;


    public BusDetails() {
    }

    public BusDetails(String busId, String busName, String sourceCity,
                      String destinationCity, String arrivalTime, String reachingTime,
                      String busCompanyName,
                      String paytmDealer, String paytmFare,
                      String redBusDealer, String redBusFare,
                      String cleartripDealer, String clearTripFare) {
        this.busId = busId;
        this.busName = busName;
        this.sourceCity = sourceCity;
        this.destinationCity = destinationCity;
        this.arrivalTime = arrivalTime;
        this.reachingTime = reachingTime;
        this.busCompanyName = busCompanyName;
        this.paytmDealer = paytmDealer;
        this.redBusDealer = redBusDealer;
        this.cleartripDealer = cleartripDealer;
        this.paytmFare = paytmFare;
        this.redBusFare = redBusFare;
        this.cleartripFare = clearTripFare;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getSourceCity() {
        return sourceCity;
    }

    public void setSourceCity(String sourceCity) {
        this.sourceCity = sourceCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getReachingTime() {
        return reachingTime;
    }

    public void setReachingTime(String reachingTime) {
        this.reachingTime = reachingTime;
    }

    public String getBusCompanyName() {
        return busCompanyName;
    }

    public void setBusCompanyName(String busCompanyName) {
        this.busCompanyName = busCompanyName;
    }

    public String getPaytmDealer() {
        return paytmDealer;
    }

    public void setPaytmDealer(String paytmDealer) {
        this.paytmDealer = paytmDealer;
    }

    public String getRedBusDealer() {
        return redBusDealer;
    }

    public void setRedBusDealer(String redBusDealer) {
        this.redBusDealer = redBusDealer;
    }

    public String getMakeMyTripDealer() {
        return makeMyTripDealer;
    }

    public void setMakeMyTripDealer(String makeMyTripDealer) {
        this.makeMyTripDealer = makeMyTripDealer;
    }

    public String getPaytmFare() {
        return paytmFare;
    }

    public void setPaytmFare(String paytmFare) {
        this.paytmFare = paytmFare;
    }

    public String getRedBusFare() {
        return redBusFare;
    }

    public void setRedBusFare(String redBusFare) {
        this.redBusFare = redBusFare;
    }

    public String getMakeMyTripFare() {
        return makeMyTripFare;
    }

    public void setMakeMyTripFare(String makeMyTripFare) {
        this.makeMyTripFare = makeMyTripFare;
    }

    public String getCleartripDealer() {
        return cleartripDealer;
    }

    public void setCleartripDealer(String cleartripDealer) {
        this.cleartripDealer = cleartripDealer;
    }

    public String getCleartripFare() {
        return cleartripFare;
    }

    public void setCleartripFare(String cleartripFare) {
        this.cleartripFare = cleartripFare;
    }

    public int hashCode() {
        return arrivalTime.hashCode() * reachingTime.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        //return true;
        BusDetails paytmBuses = (BusDetails) obj;
        if (!this.busCompanyName.equalsIgnoreCase(paytmBuses.getBusCompanyName())) {
            return false;
        }
        if (!this.arrivalTime.equalsIgnoreCase(paytmBuses.getArrivalTime())) {
            return false;
        }
        if (!this.reachingTime.equalsIgnoreCase(paytmBuses.getReachingTime())) {
            return false;
        } else {
            return true;
        }
    }
    @Override
    public int compareTo(Object obj) {

        String companyName=((BusDetails)obj).getBusCompanyName();
        return (this.busCompanyName.toUpperCase()).compareTo(companyName.toUpperCase());
    }
}
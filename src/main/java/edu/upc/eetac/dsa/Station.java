package edu.upc.eetac.dsa;

import java.util.LinkedList;

public class Station {
    String idStation;
    String description;
    int max;
    double lat;
    double lon;
    LinkedList<Bike> bicis;

    public Station() {
        this.bicis = new LinkedList<>();
    }

    public Station(String idStation, String description, int max, double lat, double lon) {
        this.idStation = idStation;
        this.description = description;
        this.max = max;
        this.lat = lat;
        this.lon = lon;
        this.bicis = new LinkedList<>();
    }

    public String getIdStation() {
        return idStation;
    }

    public void setIdStation(String idStation) {
        this.idStation = idStation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public LinkedList<Bike> getBicis() {
        return bicis;
    }

    public void setBicis(LinkedList<Bike> bicis) {
        this.bicis = bicis;
    }

    public void addBicis(Bike b){
        this.getBicis().add(b);
    }

    @Override
    public String toString() {
        return "Station{" +
                "idStation='" + idStation + '\'' +
                ", description='" + description + '\'' +
                ", max=" + max +
                ", lat=" + lat +
                ", lon=" + lon +
                ", bicis=" + bicis +
                '}';
    }
}

package edu.upc.eetac.dsa;

public class Bike {
    String idBike;
    String description;
    double kms;
    String idStation;


    public Bike() {
    }

    public Bike(String idBike, String description, double kms, String idStation) {
        this.idBike = idBike;
        this.description = description;
        this.kms = kms;
        this.idStation = idStation;
    }

    public String getBikeId() {
        return idBike;
    }

    public void setIdBike(String idBike) {
        this.idBike = idBike;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getKms() {
        return kms;
    }

    public void setKms(double kms) {
        this.kms = kms;
    }

    public String getIdBike() {
        return idBike;
    }

    public String getIdStation() {
        return idStation;
    }

    public void setIdStation(String idStation) {
        this.idStation = idStation;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "idBike='" + idBike + '\'' +
                ", description='" + description + '\'' +
                ", kms=" + kms +
                ", idStation='" + idStation + '\'' +
                '}';
    }
}

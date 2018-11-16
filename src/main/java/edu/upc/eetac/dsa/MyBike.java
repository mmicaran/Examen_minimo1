package edu.upc.eetac.dsa;

import java.util.List;

public interface MyBike {

    /**
     * number of stations
     */
    public static final int S = 10;

    /**
     * Add a new User
     *
     * @param idUser identifier of the user
     * @param name name of the user
     * @param surname surname of the user
     */
    public void addUser(String idUser, String name, String surname);


    /**
     * Add a new Station
     *
     * @param idStation identifier of the station
     * @param description description
     * @param max maximum number of bikes of the station
     * @param lat lattitude GPS
     * @param lon longitude GPS
     */
    public void addStation(String idStation, String description, int max, double lat, double lon);


    /**
     * Add a new Bike into a Station
     *
     * @param idBike identifier of the bike
     * @param description description
     * @param kms kilometers
     * @param idStation identifier of the station
     * @throws StationFullException  if the station is full
     * @throws StationNotFoundException if the station doesn't exist
     */
    public void addBike(String idBike, String description, double kms, String idStation) throws StationFullException, StationNotFoundException;


    /**
     * Get the bikes of a station ordered by kilometers
     *
     * @param idStation identifier
     * @return list of bikes
     * @throws StationNotFoundException if the station doesn't exist
     */
    public List<Bike> bikesByStationOrderByKms(String idStation) throws StationNotFoundException;

    /**
     * get the first Bike of the station
     *
     * @param stationId identifier of the station
     * @param userId identifier of the user
     * @return the first bike of the station
     * @throws UserNotFoundException if the user doesn't exist
     * @throws StationNotFoundException if the station doesn't exist
     */
    public Bike getBike(String stationId, String userId) throws UserNotFoundException, StationNotFoundException;

    /**
     * get the bikes used by the user
     *
     * @param userId identifier of the user
     * @return the list of bikes used by the user
     * @throws UserNotFoundException if the user doesn't exist
     */
    public List<Bike> bikesByUser(String userId) throws UserNotFoundException;


    /**
     * get the number of users
     *
     * @return the number of users
     */
    public int numUsers();

    /**
     * get the number of stations
     *
     * @return the number of stations
     */
    public int numStations();

    /**
     * get the number of bikes in a station
     *
     * @param idStation identifier of the station
     * @return the number of bikes of the station
     * @throws StationNotFoundException if the station doesn't exist
     */
    public int numBikes(String idStation) throws StationNotFoundException;

    /**
     * clear all the data structures
     */
    public void clear();
}

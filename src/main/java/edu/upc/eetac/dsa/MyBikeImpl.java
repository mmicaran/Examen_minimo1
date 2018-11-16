package edu.upc.eetac.dsa;

import org.apache.log4j.Logger;

import java.util.*;

public class MyBikeImpl implements MyBike {

    final static Logger log = Logger.getLogger(MyBikeImpl.class.getName());
    //SINGELTON
    private static MyBikeImpl instance;

    protected int nStations;
    protected Station[] stations;
    //HashMap(key: string; value: User)
    protected HashMap<String, User> usuarios;

    private MyBikeImpl(){
        nStations = 0;
        this.stations = new Station[10];
        this.usuarios = new HashMap<>();
    }

    public static MyBike getInstance(){
        if(instance == null){
            instance = new MyBikeImpl();
        }
        return instance;
    }

    public void addStation(String idStation, String description, int max, double lat, double lon){
        if(nStations != S){
            stations[nStations] = new Station(idStation,description,max,lat,lon);
            log.info("Estacion añadida: "+stations[nStations]);
        }
        else{
            log.error("Maximo de estaciones permitidas");
        }
    }

    public void addUser(String idUser, String name, String surname){
        usuarios.put(idUser,new User(idUser,name,surname));
        log.info("Usuario añadido: " + usuarios.get(idUser));
    }

    public void addBike(String idBike, String description, double kms, String idStation) throws StationFullException, StationNotFoundException{

        Bike b = new Bike(idBike,description,kms);
        log.info("Bici creada: "+b);

        int i;
        boolean encontrado = false;

        for(i = 0; i<nStations && !encontrado; i++){
            if(idStation.equals(stations[i].getIdStation())){
                encontrado = true;
                log.info("Estacion encontrada");
            }
        }
        if(!encontrado){
            log.error("Estacion no encontrada");
            throw new StationNotFoundException();
        }else {
            if(stations[i].getBicis().size() < stations[i].getMax() ){
                stations[i].addBicis(b);
                log.info("Bicis de estacion i: " + stations[i].getBicis());
            }
            else {
                log.error("Estacion llena");
                throw new StationFullException();
            }
        }

    }

    public List<Bike> bikesByStationOrderByKms(String idStation) throws StationNotFoundException {
        int i;
        boolean encontrado;
        for(i =0;)
    }




}

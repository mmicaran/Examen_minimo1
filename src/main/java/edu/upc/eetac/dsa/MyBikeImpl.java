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
            log.info(nStations);
            log.info("Estacion añadida: "+stations[nStations]);
            nStations++;
        }
        else{
            log.error("Maximo de estaciones permitidas");
        }
    }

    public void addUser(String idUser, String name, String surname){
        usuarios.put(idUser, new User(idUser,name,surname));
        log.info(usuarios.size());
        log.info("Usuario añadido: " + usuarios.get(idUser));
    }

    public void addBike(String idBike, String description, double kms, String idStation) throws StationFullException, StationNotFoundException{

        Bike b = new Bike(idBike,description,kms,idStation);
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
            if(stations[i-1].getBicis().size() < stations[i-1].getMax() ){
                stations[i-1].addBicis(b);
                log.info("Bicis de estacion "+ stations[i-1].getIdStation()+": " + stations[i-1].getBicis());
            }
            else {
                log.error("Estacion llena");
                throw new StationFullException();
            }
        }

    }

    public List<Bike> bikesByStationOrderByKms(String idStation) throws StationNotFoundException {
        int i;
        boolean encontrado = false;
        for(i =0; i<nStations && !encontrado; i++){
            if(idStation.equals(stations[i].getIdStation())){
                encontrado = true;
                log.info("Estacion encontrada");
            }
        }
        i--;
        if(encontrado){
            LinkedList<Bike> bs = stations[i].getBicis();
            log.info("Lista de bicis desordenada: "+ bs);
            Collections.sort(bs, new Comparator<Bike>() {
                @Override
                public int compare(Bike b1, Bike b2) {
                    //Ascendente
                    double d = b1.getKms() - b2.getKms();
                    if(d < 0.0)
                        return -1;
                    else if(d> 0.0)
                        return 1;
                    else
                        return 0;
                }
            });
            log.info(("Lisa de bicis rdenada"+bs));
            return bs;
        }
        else {
            log.error("Estacion no encontrada");
            throw new StationNotFoundException();
        }
    }

    public Bike getBike(String stationId, String userId) throws UserNotFoundException, StationNotFoundException{
        int i;
        boolean encontrado = false;
        for(i =0; i<nStations && !encontrado; i++){
            if(stationId.equals(stations[i].getIdStation())){
                encontrado = true;
                log.info("Estacion encontrada");
            }
        }
        i--;
        if(encontrado){
            Bike bike = stations[i].getBicis().removeFirst();
            log.info("bicis en la estacion: "+stations[i].getBicis());

            User u = usuarios.get(userId);
            if(u != null){
                log.info("Primera bici de la estacion: "+bike);
                u.addBicis(bike);
                return bike;
            }else{
                log.error("Usuario no encontrado");
                throw new UserNotFoundException();
            }

        }
        else {
            log.error("Estacion no encontrada");
            throw new StationNotFoundException();
        }

    }

    public List<Bike> bikesByUser(String userId) throws UserNotFoundException{
        User u = usuarios.get(userId);
        if(u != null){
            LinkedList<Bike> bikes = u.getBicis();
            log.info("Lista de bicis de "+userId+": "+bikes);
            return bikes;
        }else{
            log.error("Usuario no encontrado");
            throw  new UserNotFoundException();
        }
    }

    public int numUsers(){
        return usuarios.size();
    }

    public int numStations(){
        return nStations;
    }

    public int numBikes(String idStation) throws StationNotFoundException {
        int i;
        boolean encontrado = false;
        for (i = 0; i < nStations; i++) {
            if (idStation.equals(stations[i].getIdStation())) {
                log.info("Estacion encontrada");
                log.info("numero de bicis: " + stations[i].getBicis().size());
                return (stations[i].getBicis().size());
            }
        }
        throw new StationNotFoundException();
    }

    public void clear(){
        nStations = 0;
        this.stations = new Station[10];
        this.usuarios = new HashMap<>();
    }






}

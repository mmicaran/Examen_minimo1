package edu.upc.eetac.dsa;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MyBikeImpl implements MyBike {

    final static Logger log = Logger.getLogger(MyBikeImpl.class.getName());
    //SINGELTON
    private static MyBikeImpl instance;

    protected int nStations;
    protected Station[] stations;
    //!!!!!!
    protected LinkedList<Bike> pedidos;
    //HashMap(key: string; value: User)
    protected HashMap<String, User> usuarios;
    protected LinkedList<Bike> bicicletas;

    private MyBikeImpl(){
        nStations = 0;
        this.stations = new Station[10];
        //!!!!!!
        this.pedidos = new LinkedList<Pedido>();
        this.usuarios = new HashMap<>();
        this.bicicletas = new LinkedList<>();
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
        log.info("Usuario añadido: "+usuarios.get(idUser));
    }


}

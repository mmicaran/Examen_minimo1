package edu.upc.eetac.dsa.services;
import edu.upc.eetac.dsa.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Api(value = "/MyBike", description = "Endpoint to Track Service")
@Path("/MyBike")
public class MyBikeService {

    private MyBike mb;

    public MyBikeService() throws StationFullException, StationNotFoundException {
        this.mb = MyBikeImpl.getInstance();
        this.mb = MyBikeImpl.getInstance();
        this.mb.addUser("user1", "Juan", "Lopex");


        this.mb.addStation("Station1","description:: station1", 10, 3, 3);
        this.mb.addStation("Station2","description:: station2", 10, 3, 3);

        this.mb.addBike("bike101", "descripton", 25.45, "Station1");
        this.mb.addBike("bike102", "descripton", 70.3, "Station1");
        this.mb.addBike("bike103", "descripton", 10.2, "Station1");

        this.mb.addBike("bike201", "descripton", 1325.45, "Station2");
        this.mb.addBike("bike202", "descripton", 74430.3, "Station2");
        this.mb.addBike("bike203", "descripton", 1320.2, "Station2");
    }

    //bikesByStationOrderByKms
    @GET
    @ApiOperation(value = "bikesByStationOrderByKms", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Bike.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "Track not found")

    })
    @Path("/{idStation}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response bikesByStationOrderByKms(@PathParam("idStation") String idStation)  {

        try {
            List<Bike> tracks = this.mb.bikesByStationOrderByKms(idStation);
            GenericEntity<List<Bike>> entity = new GenericEntity<List<Bike>>(tracks) {};
            return Response.status(201).entity(entity).build()  ;
        } catch (StationNotFoundException e) {
            return Response.status(404).build();
        }


    }

    //getBikes
    @GET
    @ApiOperation(value = "Get Bike", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Bike.class),
            @ApiResponse(code = 404, message = "Track not found")

    })
    @Path("/{idStation}{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBike (@PathParam("idStation") String idStation, @PathParam("userId") String userId)  {
        try {
            Bike bike = this.mb.getBike(idStation,userId);
            GenericEntity<Bike> entity = new GenericEntity<Bike>(bike) {};
            return Response.status(201).entity(entity).build()  ;
        }catch (UserNotFoundException e) {
            return Response.status(404).build();
        } catch (StationNotFoundException e) {
            return Response.status(404).build();
        }


    }
    //addUser
    @POST
    @ApiOperation(value = "ADD USER", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful")
    })
    @Path("/AddUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(User u) {
        String idUser = u.getIdUser();
        String name = u.getName();
        String surname = u.getSurname();
        this.mb.addUser(idUser, name, surname);
        return Response.status(201).build();
    }

    //addStation
    @POST
    @ApiOperation(value = "ADD STATION", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful")
    })
    @Path("/AddStation")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStation(Station s) {
        String idStation = s.getIdStation();
        String description = s.getDescription();
        int max = s.getMax();
        double lat = s.getLat();
        double lon = s.getLon();
        this.mb.addStation(idStation,description,max,lat,lon);
        return Response.status(201).build();
    }

    //addBike
    @POST
    @ApiOperation(value = "ADD BIKE", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful")
    })
    @Path("/AddBike")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBike (Bike b) throws StationFullException, StationNotFoundException {
        String idBike = b.getBikeId();
        String description = b.getDescription();
        double kms = b.getKms();
        String idStation = b.getIdStation();
        this.mb.addBike(idBike,description,kms,idStation);
        return Response.status(201).build();
    }

}
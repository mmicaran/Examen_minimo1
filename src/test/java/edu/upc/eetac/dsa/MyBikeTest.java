git apackage edu.upc.eetac.dsa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MyBikeTest {
    private MyBike mb;

    @Before
    public void setUp() throws Exception {
        this.mb = MyBikeImpl.getInstance();
        this.mb.addUser("user1", "Juan", "Lopex");


        this.mb.addStation("Station1","description:: station1", 10, 3, 3);
        this.mb.addStation("Station2","description:: station2", 10, 3, 3);


        Assert.assertEquals(2, this.mb.numStations());
        Assert.assertEquals(0, this.mb.numBikes("Station1"));

        this.mb.addBike("bike101", "descripton", 25.45, "Station1");
        this.mb.addBike("bike102", "descripton", 70.3, "Station1");
        this.mb.addBike("bike103", "descripton", 10.2, "Station1");
        Assert.assertEquals(3, this.mb.numBikes("Station1"));

        this.mb.addBike("bike201", "descripton", 1325.45, "Station2");
        this.mb.addBike("bike202", "descripton", 74430.3, "Station2");
        this.mb.addBike("bike203", "descripton", 1320.2, "Station2");
        Assert.assertEquals(3, this.mb.numBikes("Station2"));
    }

    @After
    public void tearDown(){
        this.mb.clear();
    }

    @Test
    public void testAddUser() {
        this.mb.addUser("3334445ZX", "Juan", "Lopex");
        Assert.assertEquals(2, this.mb.numUsers());
    }


    @Test
    public void testAddStations() {
        this.mb.addStation("Station3","description", 10, 3, 3);
        Assert.assertEquals(3, this.mb.numStations());
    }

    @Test
    public void testAddBike() throws Exception {

        this.mb.addBike("bike500", "descripton", 43.3, "Station1");
        this.mb.addBike("bike600", "descripton", 45.3, "Station1");

        Assert.assertEquals(5, this.mb.numBikes("Station1"));


    }

    @Test(expected = StationFullException.class)
    public void testAddBikesAndStationFull() throws Exception {
        this.mb.addStation("Station3","description", 2, 3, 3);
        Assert.assertEquals(3, this.mb.numStations());
        Assert.assertEquals(0, this.mb.numBikes("Station3"));

        this.mb.addBike("bike1", "descripton", 25.3,"Station3");
        this.mb.addBike("bike2", "descripton", 70.2, "Station3");
        this.mb.addBike("bike3", "descripton", 10.4, "Station3");

    }


    @Test(expected = StationNotFoundException.class)
    public void testAddBikesAndStationNotFound() throws Exception {
        this.mb.addBike("bike1", "descripton", 55.4,"StationXXXXX");
    }



    @Test
    public void testBikesByStation() throws Exception {

        List<Bike> bikes = this.mb.bikesByStationOrderByKms("Station1");

        Assert.assertEquals("bike103", bikes.get(0).getBikeId());
        Assert.assertEquals(10, bikes.get(0).getKms(),1);

        Assert.assertEquals("bike101", bikes.get(1).getBikeId());
        Assert.assertEquals(25, bikes.get(1).getKms(),1);

        Assert.assertEquals("bike102", bikes.get(2).getBikeId());
        Assert.assertEquals(70, bikes.get(2).getKms(),1);
    }

    @Test
    public void testGetBikes() throws Exception {

        Bike b1 = this.mb.getBike("Station1", "user1");
        Assert.assertEquals("bike101", b1.getBikeId());
        Assert.assertEquals(2, this.mb.numBikes("Station1"));

        Bike b2 = this.mb.getBike("Station2", "user1");
        Assert.assertEquals("bike201", b2.getBikeId());
        Assert.assertEquals(2, this.mb.numBikes("Station1"));

        List<Bike> bikes = this.mb.bikesByUser("user1");

        Assert.assertEquals("bike101", bikes.get(0).getBikeId());
        Assert.assertEquals("bike201", bikes.get(1).getBikeId());

    }


}

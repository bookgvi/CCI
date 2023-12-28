package graph.task;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheapestFlightsWithinKStopsTest {

    @Test
    public void findCheapestPrice() {
        int n = 4, src = 0, dst = 3, k = 1;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        CheapestFlightsWithinKStops c = new CheapestFlightsWithinKStops();
        int res = c.findCheapestPrice(n, flights, src, dst, k);
        assertEquals(700, res);
    }

    @Test
    public void findCheapestPrice2() {
        int n = 3, src = 0, dst = 2, k = 0;
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        CheapestFlightsWithinKStops c = new CheapestFlightsWithinKStops();
        int res = c.findCheapestPrice(n, flights, src, dst, k);
        assertEquals(500, res);
    }

    @Test
    public void findCheapestPrice3() {
        int n = 3, src = 0, dst = 2, k = 1;
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        CheapestFlightsWithinKStops c = new CheapestFlightsWithinKStops();
        int res = c.findCheapestPrice(n, flights, src, dst, k);
        assertEquals(200, res);
    }

    @Test
    public void findCheapestPrice4() {
        int n = 5, src = 0, dst = 2, k = 2;
        int[][] flights = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        CheapestFlightsWithinKStops c = new CheapestFlightsWithinKStops();
        int res = c.findCheapestPrice(n, flights, src, dst, k);
        assertEquals(7, res);
    }

    @Test
    public void findCheapestPrice5() {
        int n = 3, src = 1, dst = 2, k = 1;
        int[][] flights = {{0,1,2},{1,2,1},{2,0,10}};
        CheapestFlightsWithinKStops c = new CheapestFlightsWithinKStops();
        int res = c.findCheapestPrice(n, flights, src, dst, k);
        assertEquals(1, res);
    }
}
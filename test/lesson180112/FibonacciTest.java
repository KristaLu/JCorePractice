package lesson180112;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FibonacciTest {

    private Fibonacci fb;

    @Before
    public void setup(){
        fb = new Fibonacci();
    }

    @Test
    public void testBaseCase(){
        int[] expected = {0,1,1,2,3,5,8,13,21,34,55};
        for (int i = 1; i < expected.length; i++) {
            int act = fb.getNumber(i);
            assertEquals(String.format("The %d element = %d", i, expected[i]),expected[i], act);
        }
    }

    @Test
    public void testLowerBound(){
        int[] badInd = {0,-1,-100,Integer.MIN_VALUE};
        for (int ind:badInd) {
            try {
                fb.getNumber(ind);

                fail("Element must throw an exception");
            } catch (IllegalArgumentException e) {
                // ok
            }
        }
    }

}
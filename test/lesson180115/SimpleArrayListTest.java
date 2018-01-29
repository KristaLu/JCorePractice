package lesson180115;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleArrayListTest {
    SimpleArrayList<String> list;

    @Before
    public void setUp() throws Exception {
        list = new SimpleArrayList<>();
    }

    @Test
    public void testAdd(){
        String[] expected = {"0","1","2","3","4"};

        for (String s:expected){
            list.add(s);
        }
        assertEquals(5,list.size());
        assertArrayEquals(expected, list.array);
    }

    @Test
    public void testAddOverflow(){
        String[] expected = {"0","1","2","3","4","5"};

        for (String s:expected){
            list.add(s);
        }
        assertEquals(6,list.size());
        compareArrays(expected, list.array);
    }

    private void compareArrays(String[] expected, Object[] actual) {
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i],actual[i]);

        }
    }

    @Test
    public void testRemoveLast(){
        final String[] expected = {"0","1","2","3"};
        final String[] data = {"0","1","2","3","4"};

        for (String s:data){
            list.add(s);
        }

        list.remove(4);

        assertEquals(4,list.size());
        compareArrays(expected,list.array);
    }

    @Test
    public void testRemoveFirst(){
        final String[] expected = {"1","2","3","4"};
        final String[] data = {"0","1","2","3","4"};

        for (String s:data){
            list.add(s);
        }

        list.remove(0);

        assertEquals(4,list.size());
        compareArrays(expected,list.array);
    }

    @Test
    public void testRemoveMiddle(){
        final String[] expected = {"0","1","3","4"};
        final String[] data = {"0","1","2","3","4"};

        for (String s:data){
            list.add(s);
        }

        list.remove(2);

        assertEquals(4,list.size());
        compareArrays(expected,list.array);
    }

}
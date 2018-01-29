package lesson180115;

import org.junit.Test;
import static org.junit.Assert.*;

public class SimpleArrayQueueTest {

    @Test
    public void testAdd() throws Exception{
        SimpleArrayQueue<String> queue = new SimpleArrayQueue<>();

        queue.enqueue("0");
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");

        assertEquals(5,queue.size);
        assertArrayEquals(new String[]{"0","1","2","3","4"}, queue.array);
    }

    @Test
    public void testAdd7Remove2() throws Exception{
        SimpleArrayQueue<String> queue = new SimpleArrayQueue<>();

        queue.enqueue("0");
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");

        assertEquals("0",queue.dequeue());
        assertEquals("1",queue.dequeue());

        queue.enqueue("5");
        queue.enqueue("6");

        assertEquals(5,queue.size);
        assertArrayEquals(new String[]{"5","6","2","3","4"}, queue.array);
    }

    @Test
    public void testIterator() throws Exception{
        SimpleArrayQueue<String> queue = new SimpleArrayQueue<>();

        queue.enqueue("0");
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");

        assertEquals("0",queue.dequeue());
        assertEquals("1",queue.dequeue());

        queue.enqueue("5");
        queue.enqueue("6");

        for (String s:queue){

        }
        assertEquals(5,queue.size);
        assertArrayEquals(new String[]{"5","6","2","3","4"}, queue.array);
    }

}
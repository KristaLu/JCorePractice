package lesson180115;

import org.junit.Test;
import static org.junit.Assert.*;

public class SimpleLinkedListTest {

    @Test
    public void testRemove() throws Exception{
        SimpleLinkedList<String> list = prepareList("0","1","2","3");

        list.remove(3);

        assertEquals(3,list.size());
        assertEquals("0", list.get(0));
        assertEquals("1", list.get(1));
        assertEquals("2", list.get(2));
    }

    private SimpleLinkedList<String> prepareList(String... data) {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        for (String s : data) {
            list.add(s);
        }
        return list;
    }
}
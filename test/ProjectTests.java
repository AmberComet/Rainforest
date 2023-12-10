import org.junit.Test;

import edu.washburn.Item;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectTests {
    @Test
    public void testBasePrice() {
        Item i = new Item("www.google.com", true, false, 35.0);
        Double result = i.getBaseprice();
        assertEquals(45.0, result);
    }
    @Test
    public void testBasePrice1() {
        Item i = new Item("www.google7.com", true, false, 35.0);
        Double result = i.getBaseprice();
        assertEquals(45.0, result);
    }
    @Test
    public void testgetUrl() {
        Item i = new Item("www.google7.com", true, false, 35.0);
        String result = i.getUrl();
        assertEquals("www.google7.com", result);
    }
    @Test
    public void testgetUrl1() {
        Item i = new Item("www.amazon.com", true, false, 35.0);
        String result = i.getUrl();
        assertEquals("www.google7.com", result);
    }
}

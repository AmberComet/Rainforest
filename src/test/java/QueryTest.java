import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import edu.washburn.Item;
import edu.washburn.Query;

public class QueryTest {

    private Query query;

    @Before
    public void setUp() {
        query = new Query(); // Initialize with the default constructor
    }

    @Test
    public void testCaptureDataFromFile() {
        // Assuming "TestHTML.html" contains valid HTML data for testing
        query.captureDataFromFile();
        assertEquals("99.99", query.getPrice());
    }

    @Test
    public void testCaptureDataFromFileWithInvalidFile() {
        // Assuming an invalid file path to test the failure scenario
        query = new Query("InvalidFilePath.html");
        query.captureDataFromFile();
        assertNull(query.getPrice());
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
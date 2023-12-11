import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

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


}
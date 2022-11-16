package cps3230.assignment;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class AlertTest {

    final String POSTEDBY_ID = "31a7cb0e-e0e5-4a05-9351-c074815f7b8a";

    Alert alert; 

    @BeforeEach
    public void setup() { 
        // sample valid alert 
        alert = new Alert(6, "Test heading", "test Description", "Test url", "Test image url", 100);
    }

    @Test
    public void testGetID() {
        Assertions.assertEquals(POSTEDBY_ID, alert.getID());
    }
}

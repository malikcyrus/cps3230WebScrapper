package cps3230.assignment;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.withSettings;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class PostServiceTests {
    
    // class under test 
    PostService testPostService; 

    private Alert mockedAlert;

    private ArrayList<Alert> testAlerts = new ArrayList<Alert>();

    @BeforeEach
    public void setup() { 
        // setup
        String heading = "Apple Leather Case Magsafe Black iPhone 12 Pro Max";
        String description = "Designed by Apple to complement 12 Pro Max, the Leather Case with MagSafe is a delightful way to give your iPhone extra protection while adding style.";
        String url = "https://lava.mt/product/apple-leather-case-magsafe-black-iphone-12-pro-max/";
        String imageUrl = "https://lava.mt/wp-content/uploads/2021/03/Apple-Leather-Case-Magsafe-Black-iPhone-12-Pro-Max.jpg.webp";
        int price = 6500; 

        mockedAlert = mock(Alert.class, withSettings().useConstructor(6, heading, description, url, imageUrl, price));
        
        testAlerts.add(mockedAlert);
    }

    @Test
    public void testPostAlert() {
        testPostService = new PostService(); 
        
        try { 
            Assertions.assertFalse(testPostService.postAlerts(testAlerts));
        } catch (Exception e) { 
            e.printStackTrace();
        }
        
       // assertEquals(201, testPostService.response.getStatusLine().getStatusCode());
    }
}

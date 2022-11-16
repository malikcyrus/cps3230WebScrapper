package cps3230.assignment;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ScrapperServiceTests {

    ScrapperService scrapperTester = new ScrapperService(); 
    ScrapperService mockedService; 
    Alert mockedAlert; 

    @Test
    public void searchElementIsSuccessful() { 
        String itemToTest = "text";

        Assertions.assertTrue(scrapperTester.searchItem(itemToTest));
    }

    @Test 
    public void testInvalidScrappedElement() { 
        mockedService = mock(ScrapperService.class);
        when(mockedService.scrapeElement("item")).thenReturn(null);
        
        Assertions.assertNull(mockedService.scrapeElement("item"));
    }

    @Test 
    public void testValidScrappedElement() { 
        // setup
        String heading = "Apple Leather Case Magsafe Black iPhone 12 Pro Max";
        String description = "Apple Leather Case Magsafe Black iPhone 12 Pro Max";
        String url = "https://lava.mt/product/apple-leather-case-magsafe-black-iphone-12-pro-max/";
        String imageUrl = "https://lava.mt/wp-content/uploads/2021/03/Apple-Leather-Case-Magsafe-Black-iPhone-12-Pro-Max.jpg.webp";
        int price = 6500; 

        Alert expectedAlert = mock(Alert.class, withSettings().useConstructor(6, heading, description, url, imageUrl, price));
        Alert scrappedAlert = scrapperTester.scrapeElement("Apple leather case");
        Assertions.assertNotNull(scrappedAlert);

        Assertions.assertEquals(expectedAlert.heading, scrappedAlert.heading);
        Assertions.assertEquals(expectedAlert.description, scrappedAlert.heading);
        Assertions.assertEquals(expectedAlert.url, scrappedAlert.url);
        Assertions.assertEquals(expectedAlert.imageUrl, scrappedAlert.imageUrl);
        Assertions.assertEquals(expectedAlert.priceInCents, scrappedAlert.priceInCents);
    }
}

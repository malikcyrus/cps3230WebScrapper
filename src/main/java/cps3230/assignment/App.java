package cps3230.assignment;

import java.util.ArrayList;

public class App {

    public static void main(String [] args) { 
        // list of items to scrape 
        ArrayList<String> items = new ArrayList<String>();   
        
        // list of alerts to post 
        ArrayList <Alert> alerts = new ArrayList<Alert>();

        items.add("xbox");
        items.add("Apple leather case");
        items.add("Nintendo");    
        items.add("apple macbook pro");
        items.add("apple watch");

        ScrapperService webScrapper = new ScrapperService();

        for (String item : items) {
            if(webScrapper.scrapeElement(item) != null){
                alerts.add(webScrapper.scrapeElement(item));
            }         
        }
        
        PostService poster = new PostService();
        
        try {
            poster.postAlerts(alerts);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

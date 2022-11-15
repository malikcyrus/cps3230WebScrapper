package cps3230.assignment;

public class Alert {
    protected int alertType;  
    protected String heading; 
    protected String description; 
    protected String url; 
    protected String imageUrl;
    protected int priceInCents; 
    private final String postedBy = "31a7cb0e-e0e5-4a05-9351-c074815f7b8a";

    public Alert(int alertType, String heading, String description, String url, String imageUrl, int priceInCents) { 
        this.alertType = alertType;
        this.heading = heading; 
        this.description = description;
        this.url = url;
        this.imageUrl = imageUrl; 
        this.priceInCents = priceInCents; 
    }

    public String getID() { 
        return postedBy; 
    }

    public void getDetails() { 
        System.out.println("alertType: " + alertType);
        System.out.println("Heading: " + heading);
        System.out.println("Description: " + description);
        System.out.println("url: " + url);
        System.out.println("imageUrl: " + imageUrl);
        System.out.println("postedBy: " + postedBy);
        System.out.println("priceInCents: " + priceInCents);
    }
}

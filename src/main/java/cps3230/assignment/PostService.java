package cps3230.assignment;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import java.util.ArrayList;

public class PostService {
    protected HttpResponse response;
    protected HttpClient httpClient;
    protected HttpPost post;

    public boolean postAlerts(ArrayList<Alert> alertsToPost) throws Exception { 

        httpClient = HttpClientBuilder.create().build();
        post = new HttpPost("https://api.marketalertum.com/Alert/");

        post.addHeader("content-type", "application/json");
        post.setHeader("Accepts", "application/json");

        for(Alert alertToPost : alertsToPost) {
            post.setEntity(new StringEntity(new Gson().toJson(alertToPost)));
            response = httpClient.execute(post);

            if (response.getStatusLine().getStatusCode() != 201) { 
                return false; 
            }
            alertToPost.getDetails();
            post.reset();
        }

        return true; 
    }

    public int getResponse() { 
        return response.getStatusLine().getStatusCode(); 
    }
}

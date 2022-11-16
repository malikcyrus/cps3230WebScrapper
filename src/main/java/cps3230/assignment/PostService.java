package cps3230.assignment;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import java.util.ArrayList;

public class PostService {
    ArrayList<HttpResponse> responses = new ArrayList<HttpResponse>();   
    protected HttpResponse response;
    protected HttpResponse deleteResponse; 
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

        responses.add(response);

        return true; 
    }

    public int removeAllAlerts() throws Exception{ 
        httpClient = HttpClientBuilder.create().build();
        String deleteEndpoint = "https://api.marketalertum.com/Alert?userId=31a7cb0e-e0e5-4a05-9351-c074815f7b8a";
        HttpDelete httpDelete = new HttpDelete(deleteEndpoint);
        deleteResponse = httpClient.execute(httpDelete);

        return deleteResponse.getStatusLine().getStatusCode();
    }
}

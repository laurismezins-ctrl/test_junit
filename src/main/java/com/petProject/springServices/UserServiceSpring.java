package com.petProject.springServices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class UserServiceSpring {

    @Value("${rest.assured.uri}")
    String baseUrl;

    private final MyClient myClient;

    private final HttpClient client;

    public UserServiceSpring(MyClient myClient) {
        this.myClient = myClient;
        this.client = HttpClient.newHttpClient();
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public HttpResponse<String> getUser(int id) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(baseUrl + "/users/" + id))
                .GET()
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public String getMessageFromMyClient(String message) {
        return "message: " + myClient.getMessage(message);
    }
}
package com.petProject.config.services.exampleService;

import com.petProject.config.Config;
import io.restassured.response.Response;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static io.restassured.RestAssured.get;

public class ExampleServiceClient {

//    private static final String BASE_URL = "https://reqres.in/api";

    private HttpClient client = HttpClient.newHttpClient();

    public ExampleServiceClient() {
        Config.getInstance().setBaseURI();
        this.client = HttpClient.newHttpClient();
    }

    public Response getUser(String String) {

        Response response =
                get(String)
                .then()
                .extract().response();

        return response;
    }
}

package com.petProject.config.services.dummyJsonService;

import com.petProject.config.Config;
import io.restassured.response.Response;

import java.net.http.HttpClient;

import static io.restassured.RestAssured.get;

public class DummyJsonClient {


    private HttpClient client = HttpClient.newHttpClient();

    public DummyJsonClient() {
        Config.getInstance().setBaseURI();
        this.client = HttpClient.newHttpClient();
    }

    public Response getRequest(String String) {

        Response response =
                get(String)
                        .then()
                        .extract().response();

        return response;
    }
}

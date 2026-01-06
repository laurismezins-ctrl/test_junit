package com.petProject.services.reqResService;

import com.petProject.config.Config;
import io.restassured.response.Response;

import java.net.http.HttpClient;

import static io.restassured.RestAssured.get;

public class ReqResServiceClient {

//    private static final String BASE_URL = "https://reqres.in/api";

    private HttpClient client = HttpClient.newHttpClient();

    public ReqResServiceClient() {
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

package com.petProject.config;
import io.restassured.RestAssured;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final String FILE_NAME = "test_properties";
    private final Properties properties;
    private static Config CONFIG;

    private Config() throws IOException {

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILE_NAME);
        properties = new Properties();

        if (inputStream != null) {
            properties.load(inputStream);
        } else {
            throw new FileNotFoundException("property not found: " + FILE_NAME);
        }
    }

    public static Config getInstance() {
        if (CONFIG == null) {
            synchronized (Config.class) {
                try {
                    CONFIG = new Config();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return CONFIG;
    }
    public void setBaseURI() {
        RestAssured.baseURI = properties.getProperty("dummy.json.uri");
//        RestAssured.baseURI = properties.getProperty("rest.assured.uri");
    }

    public String getBaseURI() {
        return RestAssured.baseURI;
    }



}

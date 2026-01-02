package test_cases;

import com.petProject.config.Config;
import com.petProject.config.services.exampleService.ExampleServiceClient;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstTest {
    @Test
    public void testFirstTest() throws InterruptedException {
        ExampleServiceClient exampleServiceClient = new ExampleServiceClient();

//        not a real project without it someplace
        Thread.sleep(100);

        String msg = String.format("post GET request to %s endpoint %s", Config.getInstance().getBaseURI(), "/users/2");
        System.out.println(msg);
        Response response = exampleServiceClient.getUser("/users/2");

        System.out.println("expected : " + 403);
        System.out.println("real : " + response.getStatusCode());
        assertEquals(403, response.getStatusCode());

    }
}

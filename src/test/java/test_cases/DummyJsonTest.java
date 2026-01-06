package test_cases;

import com.petProject.config.Config;
import com.petProject.services.dummyJsonService.DummyJsonClient;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummyJsonTest {
    @Test
    public void testFirstTest() throws InterruptedException {
        DummyJsonClient dummyJsonClient = new DummyJsonClient();

//        not a real project without it someplace
        Thread.sleep(100);


        String msg = String.format("post GET request to %s endpoint %s", Config.getInstance().getBaseURI(), "/todos");
        System.out.println(msg);
        Response response = dummyJsonClient.getRequest("/todos");

        System.out.println("Verify successful response");
        System.out.println("expected : " + 200);
        System.out.println("real : " + response.getStatusCode());
        assertEquals(200, response.getStatusCode());


        System.out.println("Print json response");
        List<String> todoArray =  response.jsonPath().get("todos.todo");
        System.out.println(String.format("All todos : %s", todoArray));
    }
}

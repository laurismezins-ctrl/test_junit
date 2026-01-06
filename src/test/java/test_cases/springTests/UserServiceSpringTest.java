package test_cases.springTests;

import com.petProject.springServices.AppConfigSpring;
import com.petProject.springServices.UserServiceSpring;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.http.HttpClient;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfigSpring.class)
public class UserServiceSpringTest {

    @Autowired
    private UserServiceSpring userServiceSpring;

    @Autowired
    HttpClient httpClient;

    @Autowired
    String beanName1;

    @Value("${rest.assured.uri}")
    String baseUrl;

    @Test
    void getUserTest() throws Exception {
        System.out.println(beanName1);
        System.out.println(baseUrl);
        System.out.println(userServiceSpring.getMessageFromMyClient("test"));

        var response = userServiceSpring.getUser(2);
        assertEquals(403, response.statusCode());
    }
}
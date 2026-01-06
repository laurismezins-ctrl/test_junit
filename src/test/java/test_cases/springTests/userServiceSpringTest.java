package test_cases.springTests;

import com.petProject.config.services.springServices.AppConfigSpring;
import com.petProject.config.services.springServices.UserServiceSpring;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfigSpring.class)
public class userServiceSpringTest {

    @Autowired
    private UserServiceSpring userServiceSpring;

    @Test
    void getUserTest() throws Exception {

        var response = userServiceSpring.getUser(2);

        assertEquals(200, response.statusCode());
        assertTrue(response.body().contains("\"id\":2"));
    }
}
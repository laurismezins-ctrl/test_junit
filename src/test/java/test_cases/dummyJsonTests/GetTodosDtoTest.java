package test_cases.dummyJsonTests;

import com.petProject.services.dummyJsonService.TodosResponseDto;
import com.petProject.services.dummyJsonService.TodoDto;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetTodosDtoTest {

    @Test
    void shouldValidateTodosResponseUsingDto() {

        TodosResponseDto response =
                RestAssured
                        .given()
                        .baseUri("https://dummyjson.com")
                        .when()
                        .get("/todos")
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(TodosResponseDto.class);

        // High-level assertions
        assertNotNull(response);
        assertEquals(254, response.getTotal());
        assertEquals(0, response.getSkip());
        assertEquals(30, response.getLimit());
        assertEquals(30, response.getTodos().size());

        // Validate first to do exactly
        TodoDto firstTodo = response.getTodos().get(0);

        assertEquals(1, firstTodo.getId());
        assertEquals("Do something nice for someone you care about", firstTodo.getTodo());
        assertFalse(firstTodo.isCompleted());
        assertEquals(152, firstTodo.getUserId());

        // Spot-check another item (last)
        TodoDto lastTodo = response.getTodos().get(29);

        assertEquals(30, lastTodo.getId());
        assertEquals("Go to the gym", lastTodo.getTodo());
        assertTrue(lastTodo.isCompleted());
        assertEquals(142, lastTodo.getUserId());
    }
}
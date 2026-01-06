package com.petProject.services.dummyJsonService;

import java.util.List;

public class TodosResponseDto {

    private List<TodoDto> todos;
    private int total;
    private int skip;
    private int limit;

    public List<TodoDto> getTodos() {
        return todos;
    }

    public int getTotal() {
        return total;
    }

    public int getSkip() {
        return skip;
    }

    public int getLimit() {
        return limit;
    }
}
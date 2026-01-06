package com.petProject.services.dummyJsonService;

public class TodoDto {

    private int id;
    private String todo;
    private boolean completed;
    private int userId;

    public int getId() {
        return id;
    }

    public String getTodo() {
        return todo;
    }

    public boolean isCompleted() {
        return completed;
    }

    public int getUserId() {
        return userId;
    }

}

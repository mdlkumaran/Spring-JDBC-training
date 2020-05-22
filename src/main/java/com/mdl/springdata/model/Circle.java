package com.mdl.springdata.model;

public class Circle {
    private int id;
    private String circleName;
    private String circleType;

    public Circle() {

    }

    public String getType() {
        return circleType;
    }

    public void setType(String type) {
        this.circleType = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return circleName;
    }

    public void setName(String name) {
        this.circleName = name;
    }

    public Circle(int circleId, String name, String type) {
        setId(circleId);
        setName(name);
        setType(type);
    }

}

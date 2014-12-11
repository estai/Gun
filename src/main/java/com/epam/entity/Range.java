package com.epam.entity;



/**
 * Created by User on 29.11.14.
 */
public class Range {
    private Type type;
    private int value;

    public Range() {
    }

    public Range(int value) {
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

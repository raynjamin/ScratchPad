package com.theironyard.clt;

/**
 * Created by Ben on 4/21/16.
 */
public class Rectangle extends Shape {
    public int length;
    public int width;

    Rectangle() {

    }

    Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
        sides = 4;
    }
}

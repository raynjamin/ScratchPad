package com.theironyard.clt;

/**
 * Created by Ben on 5/16/16.
 */
public class Point {
    private Double x;
    private Double y;

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Point(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public static Point generateRandom() {
        return new Point(Math.random(), Math.random());
    }
}

package IronMan.entities;

import static IronMan.utilities.RadarConstants.*;

import java.util.Random;

public class Point3d {
    private double x;
    private double y;
    private double z;


    public Point3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return this.z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double distanceTo(Point3d point) {
        return Math.sqrt(Math.pow(this.x-point.getX(),2) + Math.pow(this.y-point.getY(),2) + Math.pow(this.z-point.getZ(),2));
    }

    public static Point3d randomPoint() {
        Random r = new Random();
        return new Point3d(r.nextInt(MAX_DISTANCE), r.nextInt(MAX_DISTANCE), r.nextInt(MAX_DISTANCE));
    }

    @Override
    public String toString() {
        return "(" +  getX() + ", " + getY() + ", " + getZ() + ")";
    }

}

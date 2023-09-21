package FinalExercise.entities;

import java.util.Random;

public class Objective {
    private Point3d coordinates;
    private boolean hostility;
    private int resistance;


    public Objective() {
        Random r = new Random();
        coordinates = Point3d.randomPoint();
        hostility = r.nextBoolean();
        resistance = r.nextInt(101) + 1;
    }

    public Objective(Point3d coordinates, boolean hostility, int resistance) {
        this.coordinates = coordinates;
        this.hostility = hostility;
        this.resistance = resistance;
    }

    public Point3d getCoordinates() {
        return this.coordinates;
    }

    public void setCoordinates(Point3d coordinates) {
        this.coordinates = coordinates;
    }


    public boolean getHostility() {
        return this.hostility;
    }

    public void setHostility(boolean hostility) {
        this.hostility = hostility;
    }

    public int getResistance() {
        return this.resistance;
    }

    public void setResistencia(int resistance) {
        this.resistance = resistance;
    }


    @Override
    public String toString() {
        return
            "\nCoords: " + getCoordinates() +
            "\nHostility: " + getHostility() +
            "\nResistance:" + getResistance();
    }


}

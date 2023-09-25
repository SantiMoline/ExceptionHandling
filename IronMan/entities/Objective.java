package IronMan.entities;

import java.util.Random;

public class Objective {
    private Point3d coordinates;
    private boolean hostility;
    private double resistance;


    public Objective() {
        Random r = new Random();
        coordinates = Point3d.randomPoint();
        hostility = r.nextBoolean();
        resistance = r.nextInt(101) + 1;
    }

    public Objective(Point3d coordinates, boolean hostility, double resistance) {
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

    public double getResistance() {
        return this.resistance;
    }

    public void setResistance(double resistance) {
        this.resistance = resistance;
    }

    public void sufferDamage(double dmg) {
        if (dmg < 0 ) 
            throw new IllegalArgumentException("Incoming damage cannot be less than zero.");
        updateResistance(dmg);
    }

    private void updateResistance(double dmg) {
        double remainingResistance =  getResistance() < dmg ? 0 : getResistance() - dmg;
        setResistance(remainingResistance);
    } 

    @Override
    public String toString() {
        return
            "\nCoords: " + getCoordinates() +
            "\nHostility: " + getHostility() +
            "\nResistance:" + getResistance();
    }


}

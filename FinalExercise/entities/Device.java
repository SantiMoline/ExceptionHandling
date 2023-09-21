package FinalExercise.entities;

import static FinalExercise.utilities.ArmorConstants.*;

public class Device {
    private boolean isBroken;
    private Double consumption;
    private boolean isDestroyed;


    public Device(Double consumption) {
        this.isBroken = false;
        this.consumption = consumption;
        this.isDestroyed = false;
    }

    public Device(boolean isBroken, Double consumption, boolean isDestroyed) {
        this.isBroken = isBroken;
        this.consumption = consumption;
        this.isDestroyed = isDestroyed;
    }

    //Copy constructor (to avoid reference trap)
    public Device(Device source) {
        setIsBroken(source.isBroken);
        setConsumption(source.consumption);
        setIsDestroyed(source.isDestroyed);
    }


    public boolean getIsBroken() {
        return this.isBroken;
    }

    public void setIsBroken(boolean isBroken) {
        this.isBroken = isBroken;
    }

    public Double getConsumption() {
        return this.consumption;
    }

    public void setConsumption(Double consumption) {
        this.consumption = consumption;
    }

    public boolean getIsDestroyed() {
        return this.isDestroyed;
    }

    public void setIsDestroyed(boolean isDestroyed) {
        this.isDestroyed = isDestroyed;
    }

    public double use(int intensity, int time) {
        setIsBroken(breakDown());
        return this.consumption * intensity * time;
    }

    private boolean breakDown() {
        return  ((Math.random() * 100) <= BREAKDOWN_PROB);
    }


}

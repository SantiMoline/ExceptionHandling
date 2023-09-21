package FinalExercise.entities;

import static FinalExercise.utilities.ArmorConstants.*;

public class Device {
    private boolean isBroken;
    private Double consumption;


    public Device(Double consumption) {
        this.isBroken = false;
        this.consumption = consumption;
    }

    public Device(boolean isBroken, Double consumption) {
        this.isBroken = isBroken;
        this.consumption = consumption;
    }

    //Copy constructor (to avoid reference trap)
    public Device(Device source) {
        setIsBroken(source.isBroken);
        setConsumption(source.consumption);
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

    public double use(int intensity, int time) {
        setIsBroken(breakDown());
        return this.consumption * intensity * time;
    }

    private boolean breakDown() {
        return  ((Math.random() * 100) <= BREAKDOWN_PROB);
    }


}

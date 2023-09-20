package FinalExercise.entities;

public class Device {
    protected boolean isBroken;
    protected Double consumption;


    public Device(Double consumption) {
        this.isBroken = false;
        this.consumption = consumption;
    }

    public Device(boolean isBroken, Double consumption) {
        this.isBroken = isBroken;
        this.consumption = consumption;
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

    public double use (int intensity, int time) {
        return this.consumption * intensity * time;
    }


}

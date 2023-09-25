package IronMan.entities;

import static IronMan.utilities.ArmorConstants.*;

import IronMan.enums.DeviceStatus;

public class Device {
    private DeviceStatus status;
    private Double consumption;


    public Device(Double consumption) {
        this.status = DeviceStatus.OK;
        this.consumption = consumption;
    }

    public Device(Double consumption, DeviceStatus status) {
        this.status = status;
        this.consumption = consumption;

    }

    //Copy constructor (to avoid reference trap)
    public Device(Device source) {
        setConsumption(source.consumption);
        setStatus(source.status);
    }


    public DeviceStatus getStatus() {
        return this.status;
    }

    public void setStatus(DeviceStatus status) {
        this.status = status;
    }

    public Double getConsumption() {
        return this.consumption;
    }

    public void setConsumption(Double consumption) {
        this.consumption = consumption;
    }

    public double use(int intensity, int time) throws IllegalStateException {
        isBrokenOrDestroyed();
        double consumption = this.consumption * intensity * time;
        if (breakDown())
            setStatus(DeviceStatus.BROKEN);
        return consumption;
    }

    private boolean breakDown() {
        return  ((Math.random() * 100) <= BREAKDOWN_PROB);
    }

    public void isBrokenOrDestroyed() throws IllegalStateException {
        if (isBroken() || isDestroyed()) {
            throw new IllegalStateException("Broken device. Cannot activate this device.");
        }
    }

    public boolean isBroken() {
        return this.status.equals(DeviceStatus.BROKEN);
    }

    public boolean isDestroyed() {
        return this.status.equals(DeviceStatus.DESTROYED);
    }

    public void repair() {
        setStatus(DeviceStatus.OK);
    }

    public void destroy() {
        setStatus(DeviceStatus.DESTROYED);
    }

    public String showStatus() {
        return getStatus().toString();
    }
}

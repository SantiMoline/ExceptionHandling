package FinalExercise.entities;

import static FinalExercise.utilities.ArmorConstants.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import FinalExercise.enums.Color;

public class Armor {
    private Color primaryColor;
    private Color secundaryColor;
    private HashMap<String,Device> devices;
    private int hardness;
    private int healthPoints;
    private double reactor;


    public Armor() {
        setPrimaryColor(Color.RED);
        setSecundaryColor(Color.YELLOW);
        devices = new HashMap<>();
        setConsole(new Device(CONSOLE_CONSUMPTION));
        setSynthesizer(new Device(SYNTHESIZER_CONSUMPTION));
        setRightGlove(new Device(GLOVE_CONSUMPTION));
        setLeftGlove(new Device(GLOVE_CONSUMPTION));
        setRightBoot(new Device(BOOT_CONSUMPTION));
        setLeftBoot(new Device(BOOT_CONSUMPTION));
        setRadar(new Radar(RADAR_CONSUMPTION));
        setHardness(STANDARD_HARDNESS);
        setHealthPoints(INITIAL_HP);
        setReactor(REACTOR_MAX_VALUE);
    }

    public Armor(Color primaryColor, Color secundaryColor, Device console, Device synthesizer, Device rightGlove, Device leftGlove, Device rightBoot, Device leftBoot, Radar radar, int hardness, int healthPoints, double reactor) {
        setPrimaryColor(primaryColor);
        setSecundaryColor(secundaryColor);
        setConsole(console);
        setSynthesizer(synthesizer);
        setRightGlove(rightGlove);
        setLeftGlove(leftGlove);
        setRightBoot(rightBoot);
        setLeftBoot(leftBoot);
        setRadar(radar);
        setHardness(hardness);
        setHealthPoints(healthPoints);
        setReactor(reactor);
    }

    public Color getPrimaryColor() {
        return this.primaryColor;
    }

    public void setPrimaryColor(Color primaryColor) {
        this.primaryColor = primaryColor;
    }

    public Color getSecundaryColor() {
        return this.secundaryColor;
    }

    public void setSecundaryColor(Color secundaryColor) {
        this.secundaryColor = secundaryColor;
    }

    public Device getConsole() {
        return new Device(devices.get(KEY_CONSOLE));
    }

    public void setConsole(Device console) {
        if (console == null) {
            throw new IllegalArgumentException("Console cannot be null.");
        }
        devices.put(KEY_CONSOLE, new Device(console));
    }

    public Device getSynthesizer() {
        return  new Device(devices.get(KEY_SYNTHESIZER));
    }

    public void setSynthesizer(Device synthesizer) {
        if (synthesizer == null) {
            throw new IllegalArgumentException("Synthesizer cannot be null.");
        }
        devices.put(KEY_SYNTHESIZER, new Device(synthesizer));
    }

    public Device getRightGlove() {
        return new Device(devices.get(KEY_RIGHTGLOVE));
    }

    public void setRightGlove(Device rightGlove) {
        if (rightGlove == null) {
            throw new IllegalArgumentException("Right glove cannot be null.");
        }
        devices.put(KEY_RIGHTGLOVE, new Device(rightGlove));
    }

    public Device getLeftGlove() {
        return new Device(devices.get(KEY_LEFTGLOVE));
    }

    public void setLeftGlove(Device leftGlove) {
        if (leftGlove == null) {
            throw new IllegalArgumentException("Left glove cannot be null.");
        }
        devices.put(KEY_LEFTGLOVE, new Device(leftGlove));
    }

    public Device getRightBoot() {
        return new Device(devices.get(KEY_RIGHTBOOT));
    }

    public void setRightBoot(Device rightBoot) {
        if (rightBoot == null) {
            throw new IllegalArgumentException("Right boot cannot be null.");
        }
        devices.put(KEY_RIGHTBOOT, new Device(rightBoot));
    }

    public Device getLeftBoot() {
        return new Device(devices.get(KEY_LEFTBOOT));
    }

    public void setLeftBoot(Device leftBoot) {
        if (leftBoot == null) {
            throw new IllegalArgumentException("Left boot cannot be null.");
        }
        devices.put(KEY_LEFTBOOT, new Device(leftBoot));
    }

    public Radar getRadar() {
        return new Radar((Radar) devices.get(KEY_RADAR));
    }

    public void setRadar (Radar radar) {
        if (radar == null) {
            throw new IllegalArgumentException("Radar cannot be null.");
        }
        devices.put(KEY_RADAR, new Radar(radar));
    }

    public int getHardness() {
        return this.hardness;
    }

    public void setHardness(int hardness) {
        if (hardness < MIN_HARDNESS || hardness > MAX_HARDNESS) {
            throw new IllegalArgumentException("Hardness cannot be less than zero or greater than 100.");
        }
        this.hardness = hardness;
    }

    public int getHealthPoints() {
        return this.healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        if (healthPoints < 0 ||  healthPoints > INITIAL_HP) {
            throw new IllegalArgumentException("Health points cannot be less than zero or greater than 100.");
        }
        this.healthPoints = healthPoints;
    }

    public double getReactor() {
        return this.reactor;
    }

    public void setReactor(double reactor) {
        if (reactor < 0 || reactor > REACTOR_MAX_VALUE) {
            throw new IllegalArgumentException("Reactor cannot be less than zero or greater than max float value.");
        }
        this.reactor = reactor;
    }

    private boolean hasEnoughEnergy(double consumption) {
        return this.reactor >= consumption;
    }

    private boolean updateReactor(double consumption) throws IllegalStateException {
        if (!hasEnoughEnergy(consumption)) {
            throw new IllegalStateException("There is not enough energy to execute the action.");
        }
        setReactor(getReactor() - consumption);
        return true;
    }

    public boolean checkDeviceState(String key) throws IllegalStateException {
        if (devices.get(key).getIsBroken() || devices.get(key).getIsDestroyed()) {
            throw new IllegalStateException("The " + key + " is broken. Cannot activate " + key + ".");
        }
        return false;
    }

    private boolean areBootsBroken() throws IllegalStateException {
        return checkDeviceState(KEY_LEFTBOOT) || checkDeviceState(KEY_RIGHTBOOT);
    }

    private boolean areGlovesBroken() throws IllegalStateException {
        return devices.get(KEY_RIGHTGLOVE).getIsBroken() || devices.get(KEY_LEFTGLOVE).getIsBroken();
    }

    public boolean walk(int duration) throws IllegalStateException {
        if (areBootsBroken()) {
            throw new IllegalStateException("At least one boot is broken. Cannot perform walk action.");
        }
        double energyConsumption = devices.get(KEY_RIGHTBOOT).use(BASIC_USE, duration);
        energyConsumption += devices.get(KEY_LEFTBOOT).use(BASIC_USE, duration);
        
        return updateReactor(energyConsumption);
    }

    public boolean run(int duration) throws IllegalStateException {
        if (areBootsBroken()) {
            throw new IllegalStateException("At least one boot is broken. Cannot perform run action.");
        }
        double energyConsumption = devices.get(KEY_RIGHTBOOT).use(NORMAL_USE, duration);
        energyConsumption += devices.get(KEY_LEFTBOOT).use(NORMAL_USE, duration);

        return updateReactor(energyConsumption);
    }

    public boolean propel(int duration) throws IllegalStateException {
        if (areBootsBroken()) {
            throw new IllegalStateException("At least one boot is broken. Cannot perform propel action.");
        }
        double energyConsumption = devices.get(KEY_RIGHTBOOT).use(INTENSIVE_USE, duration);
        energyConsumption += devices.get(KEY_LEFTBOOT).use(INTENSIVE_USE, duration);

        return updateReactor(energyConsumption);
    }

    public boolean fly(int duration) throws IllegalStateException {
        if (areBootsBroken() || areGlovesBroken()) {
            throw new IllegalStateException("At least one boot or glove is broken. Cannot perform fly action.");
        }
        double energyConsumption = devices.get(KEY_LEFTBOOT).use(INTENSIVE_USE, duration);
        energyConsumption += devices.get(KEY_RIGHTBOOT).use(INTENSIVE_USE, duration);
        energyConsumption += devices.get(KEY_RIGHTGLOVE).use(NORMAL_USE, duration);
        energyConsumption += devices.get(KEY_LEFTGLOVE).use(NORMAL_USE, duration);

        return updateReactor(energyConsumption);
    }

    public boolean shootFromGloves(int duration) throws IllegalStateException {
        if (areGlovesBroken()) {
            throw new IllegalStateException("At least one glove is broken. Cannot perform shoot action.");
        }
        double energyConsumption = devices.get(KEY_RIGHTGLOVE).use(INTENSIVE_USE, duration);
        energyConsumption += devices.get(KEY_LEFTGLOVE).use(INTENSIVE_USE, duration);

        return updateReactor(energyConsumption);
    }

    public boolean readConsole(int duration) throws IllegalStateException {
        if (devices.get("console").getIsBroken()) {
            throw new IllegalStateException("The console is broken. Cannot perform read action.");
        }
        double energyConsumption = devices.get(KEY_CONSOLE).use(BASIC_USE, duration);

        return updateReactor(energyConsumption);
    }

    public boolean speakThroughSynthesizer(int duration) throws IllegalStateException {
        if (devices.get(KEY_SYNTHESIZER).getIsBroken()) {
            throw new IllegalStateException("The synthesizer is broken. Cannot perform speak action.");
        }
        double energyConsumption = devices.get(KEY_SYNTHESIZER).use(BASIC_USE, duration);

        return updateReactor(energyConsumption);
    }

    public boolean activateRadar(int duration) throws IllegalStateException {
        if (devices.get(KEY_RADAR).getIsBroken()) {
            throw new IllegalStateException("The radar is broken. Cannot activate radar.");
        }
        double energyConsumption = devices.get(KEY_RADAR).use(BASIC_USE, duration);

        return updateReactor(energyConsumption);
    }

    public void showBatteryStatus() {
        System.out.printf("Battery status: + %.2f", this.reactor/REACTOR_MAX_VALUE * 100);
        System.out.println("%");
    }

    public void showReactorStatus() {
        System.out.println("--------------------------------------");
        System.out.printf("Energy remaining expressed in KiloWatts/Hour: %.2f kWh ", (this.reactor / ENERGY_TO_KWH));
        System.out.printf("\nExpressed in MegaJoules: %.2f MJ", (this.reactor  / ENERGY_TO_MJ));
        System.out.println("\n--------------------------------------");
    }

    private boolean repairSucces() {
        Random r = new Random();
        return r.nextDouble(100) <= REPAIR_PROB ;
    }

    private boolean destroyOcurrance() {
        Random r = new Random();
        return r.nextDouble(100) <= DESTROY_PROB ;
    }

    private boolean repair(Device device) throws IllegalStateException {
        if (device.getIsDestroyed())
            throw new IllegalStateException("The device is destroyed. There is no way to fix it.");
        do {
            if (repairSucces()) {
                device.setIsBroken(false);
        }
            if (destroyOcurrance()) {
                device.setIsDestroyed(true);
                System.out.println("The device has been destroyed while attempting to fix it.");
                return false;
            }
        } while (device.getIsBroken());
        
        return true;
    }

    public void scanArmor() {
        for (Map.Entry<String, Device> entry : devices.entrySet()) {
            if (entry.getValue().getIsDestroyed()) {
                System.out.println(entry.getKey() + " is destroyed. There is no way to fix it.");
                continue;
            }
            if (entry.getValue().getIsBroken()) {
                System.out.println(entry.getKey() + " is broken.");
                System.out.println("Trying to repair it...");
                if (repair(entry.getValue())) {
                    System.out.println("The device has been succesfully repaired");
                }
            }
        }
    }


}

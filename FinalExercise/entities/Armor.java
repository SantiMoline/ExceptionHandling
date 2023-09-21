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
        return new Device(devices.get("console"));
    }

    public void setConsole(Device console) {
        if (console == null) {
            throw new IllegalArgumentException("Console cannot be null.");
        }
        devices.put("console", new Device(console));
    }

    public Device getSynthesizer() {
        return  new Device(devices.get("synthesizer"));
    }

    public void setSynthesizer(Device synthesizer) {
        if (synthesizer == null) {
            throw new IllegalArgumentException("Synthesizer cannot be null.");
        }
        devices.put("synthesizer", new Device(synthesizer));
    }

    public Device getRightGlove() {
        return new Device(devices.get("rightGlove"));
    }

    public void setRightGlove(Device rightGlove) {
        if (rightGlove == null) {
            throw new IllegalArgumentException("Right glove cannot be null.");
        }
        devices.put("rightGlove", new Device(rightGlove));
    }

    public Device getLeftGlove() {
        return new Device(devices.get("leftGlove"));
    }

    public void setLeftGlove(Device leftGlove) {
        if (leftGlove == null) {
            throw new IllegalArgumentException("Left glove cannot be null.");
        }
        devices.put("leftGlove", new Device(leftGlove));
    }

    public Device getRightBoot() {
        return new Device(devices.get("rightBoot"));
    }

    public void setRightBoot(Device rightBoot) {
        if (rightBoot == null) {
            throw new IllegalArgumentException("Right boot cannot be null.");
        }
        devices.put("rightBoot", new Device(rightBoot));
    }

    public Device getLeftBoot() {
        return new Device(devices.get("leftBoot"));
    }

    public void setLeftBoot(Device leftBoot) {
        if (leftBoot == null) {
            throw new IllegalArgumentException("Left boot cannot be null.");
        }
        devices.put("leftBoot", new Device(leftBoot));
    }

    public Radar getRadar() {
        return new Radar((Radar) devices.get("radar"));
    }

    public void setRadar (Radar radar) {
        if (radar == null) {
            throw new IllegalArgumentException("Radar cannot be null.");
        }
        devices.put("radar", new Radar(radar));
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

    private boolean checkEnergy(double consumption) {
        return this.reactor >= consumption;
    }

    private boolean updateReactor(double consumption) {
        if (checkEnergy(consumption)) {
            setReactor(getReactor() - consumption);
            return true;
        }
        return false;
    }

    private boolean areBootsBroken() {
        return devices.get("leftBoot").getIsBroken() || devices.get("rightBoot").getIsBroken();
    }

    private boolean areGlovesBroken() {
        return devices.get("rightGlove").getIsBroken() || devices.get("leftGlove").getIsBroken();
    }

    public boolean walk(int duration) throws IllegalStateException {
        if (areBootsBroken()) {
            throw new IllegalStateException("At least one boot is broken. Cannot perform walk action.");
        }
        double energyConsumption = devices.get("rightBoot").use(BASIC_USE, duration);
        energyConsumption += devices.get("leftBoot").use(BASIC_USE, duration);
        
        return updateReactor(energyConsumption);
    }

    public boolean run(int duration) {
        if (areBootsBroken()) {
            throw new IllegalStateException("At least one boot is broken. Cannot perform run action.");
        }
        double energyConsumption = devices.get("rightBoot").use(NORMAL_USE, duration);
        energyConsumption += devices.get("leftBoot").use(NORMAL_USE, duration);

        return updateReactor(energyConsumption);
    }

    public boolean propel(int duration) {
        if (areBootsBroken()) {
            throw new IllegalStateException("At least one boot is broken. Cannot perform propel action.");
        }
        double energyConsumption = devices.get("rightBoot").use(INTENSIVE_USE, duration);
        energyConsumption += devices.get("leftBoot").use(INTENSIVE_USE, duration);

        return updateReactor(energyConsumption);
    }

    public boolean fly(int duration) {
        if (areBootsBroken() || areGlovesBroken()) {
            throw new IllegalStateException("At least one boot or glove is broken. Cannot perform fly action.");
        }
        double energyConsumption = devices.get("leftBoot").use(INTENSIVE_USE, duration);
        energyConsumption += devices.get("rightBoot").use(INTENSIVE_USE, duration);
        energyConsumption += devices.get("rightGlove").use(NORMAL_USE, duration);
        energyConsumption += devices.get("leftGlove").use(NORMAL_USE, duration);

        return updateReactor(energyConsumption);
    }

    public boolean shootFromGloves(int duration) {
        if (areGlovesBroken()) {
            throw new IllegalStateException("At least one glove is broken. Cannot perform shoot action.");
        }
        double energyConsumption = devices.get("rightGlove").use(INTENSIVE_USE, duration);
        energyConsumption += devices.get("leftGlove").use(INTENSIVE_USE, duration);

        return updateReactor(energyConsumption);
    }

    public boolean readConsole(int duration) {
        if (devices.get("console").getIsBroken()) {
            throw new IllegalStateException("The console is broken. Cannot perform read action.");
        }
        double energyConsumption = devices.get("console").use(BASIC_USE, duration);

        return updateReactor(energyConsumption);
    }

    public boolean speakThroughSynthesizer(int duration) {
        if (devices.get("synthesizer").getIsBroken()) {
            throw new IllegalStateException("The synthesizer is broken. Cannot perform speak action.");
        }
        double energyConsumption = devices.get("synthesizer").use(BASIC_USE, duration);

        return updateReactor(energyConsumption);
    }

    public boolean activateRadar(int duration) {
        if (devices.get("radar").getIsBroken()) {
            throw new IllegalStateException("The radar is broken. Cannot activate radar.");
        }
        double energyConsumption = devices.get("radar").use(BASIC_USE, duration);

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

    private boolean repair(Device device) {
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

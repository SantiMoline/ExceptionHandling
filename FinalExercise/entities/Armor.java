package FinalExercise.entities;

import static FinalExercise.utilities.ArmorConstants.*;

import FinalExercise.enums.Color;

public class Armor {
    private Color primaryColor;
    private Color secundaryColor;
    private Device console;
    private Device synthesizer;
    private Device rightGlove;
    private Device leftGlove;
    private Device rightBoot;
    private Device leftBoot;
    private int hardness;
    private int healthPoints;
    private double reactor;

    

    public Armor() {
        setPrimaryColor(Color.RED);
        setSecundaryColor(Color.YELLOW);
        setConsole(new Device(CONSOLE_CONSUMPTION));
        setSynthesizer(new Device(SYNTHESIZER_CONSUMPTION));
        setRightGlove(new Device(GLOVE_CONSUMPTION));
        setLeftGlove(new Device(GLOVE_CONSUMPTION));
        setRightBoot(new Device(BOOT_CONSUMPTION));
        setLeftBoot(new Device(BOOT_CONSUMPTION));
        setHardness(STANDARD_HARDNESS);
        setHealthPoints(INITIAL_HP);
        setReactor(REACTOR_MAX_VALUE);
    }


    public Armor(Color primaryColor, Color secundaryColor, Device console, Device synthesizer, Device rightGlove, Device leftGlove, Device rightBoot, Device leftBoot, int hardness, int healthPoints, double reactor) {
        setPrimaryColor(primaryColor);
        setSecundaryColor(secundaryColor);
        setConsole(console);
        setSynthesizer(synthesizer);
        setRightGlove(rightGlove);
        setLeftGlove(leftGlove);
        setRightBoot(rightBoot);
        setLeftBoot(leftBoot);
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
        return new Device(this.console);
    }

    public void setConsole(Device console) {
        if (console == null) {
            throw new IllegalArgumentException("Console cannot be null.");
        }
        this.console = new Device(console);
    }

    public Device getSynthesizer() {
        return  new Device(this.synthesizer);
    }

    public void setSynthesizer(Device synthesizer) {
        if (synthesizer == null) {
            throw new IllegalArgumentException("Synthesizer cannot be null.");
        }
        this.synthesizer = new Device(synthesizer);
    }

    public Device getRightGlove() {
        return new Device(this.rightGlove);
    }

    public void setRightGlove(Device rightGlove) {
        if (rightGlove == null) {
            throw new IllegalArgumentException("Right glove cannot be null.");
        }
        this.rightGlove = new Device(rightGlove);
    }

    public Device getLeftGlove() {
        return new Device(this.leftGlove);
    }

    public void setLeftGlove(Device leftGlove) {
        if (leftGlove == null) {
            throw new IllegalArgumentException("Left glove cannot be null.");
        }
        this.leftGlove = new Device(leftGlove);
    }

    public Device getRightBoot() {
        return new Device(this.rightBoot);
    }

    public void setRightBoot(Device rightBoot) {
        if (rightBoot == null) {
            throw new IllegalArgumentException("Right boot cannot be null.");
        }
        this.rightBoot = new Device(rightBoot);
    }

    public Device getLeftBoot() {
        return new Device(this.leftBoot);
    }

    public void setLeftBoot(Device leftBoot) {
        if (leftBoot == null) {
            throw new IllegalArgumentException("Left boot cannot be null.");
        }
        this.leftBoot = new Device(leftBoot);
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

    private double calculateConsumption(Device device, int intensity, int duration) {
        return device.use(intensity, duration);
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

    public boolean walk(int duration) {
        double energyConsumption = calculateConsumption(rightBoot, BASIC_USE, duration);
        energyConsumption += calculateConsumption(leftBoot, BASIC_USE, duration);
        
        return updateReactor(energyConsumption);
    }

    public boolean run(int duration) {
        double energyConsumption = calculateConsumption(rightBoot, NORMAL_USE, duration);
        energyConsumption += calculateConsumption(leftBoot, NORMAL_USE, duration);

        return updateReactor(energyConsumption);
    }

    public boolean propel(int duration) {
        double energyConsumption = calculateConsumption(rightBoot, INTENSIVE_USE, duration);
        energyConsumption += calculateConsumption(leftBoot, INTENSIVE_USE, duration);

        return updateReactor(energyConsumption);
    }

    public boolean fly(int duration) {
        double energyConsumption = calculateConsumption(leftBoot, INTENSIVE_USE, duration);
        energyConsumption += calculateConsumption(rightBoot, INTENSIVE_USE, duration);
        energyConsumption += calculateConsumption(rightGlove, NORMAL_USE, duration);
        energyConsumption += calculateConsumption(leftGlove, NORMAL_USE, duration);

        return updateReactor(energyConsumption);
    }

    public boolean shootFromGloves(int duration) {
        double energyConsumption = calculateConsumption(rightGlove, INTENSIVE_USE, duration);
        energyConsumption += calculateConsumption(leftGlove, INTENSIVE_USE, duration);

        return updateReactor(energyConsumption);
    }

    public boolean readConsole(int duration) {
        double energyConsumption = calculateConsumption(console, BASIC_USE, duration);

        return updateReactor(energyConsumption);
    }

    public boolean speakThroughSynthesizer(int duration) {
        double energyConsumption = calculateConsumption(synthesizer, BASIC_USE, duration);

        return updateReactor(energyConsumption);
    }





}

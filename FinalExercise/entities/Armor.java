package FinalExercise.entities;

import static FinalExercise.utilities.ArmorConstants.*;

public class Armor {
    private String primaryColor;
    private String secundaryColor;
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
        this.primaryColor = "Red";
        this.secundaryColor = "Yellow";
        this.console = new Device(CONSOLE_CONSUMPTION);
        this.synthesizer = new Device(SYNTHESIZER_CONSUMPTION);
        this.rightGlove = new Device(GLOVE_CONSUMPTION);
        this.leftGlove = new Device(GLOVE_CONSUMPTION);
        this.rightBoot = new Device(BOOT_CONSUMPTION);
        this.leftBoot = new Device(BOOT_CONSUMPTION);
        this.hardness = STANDARD_HARDNESS;
        this.healthPoints = INITIAL_HP;
        this.reactor = REACTOR_MAX_VALUE;
    }


    public Armor(String primaryColor, String secundaryColor, Device console, Device synthesizer, Device rightGlove, Device leftGlove, Device rightBoot, Device leftBoot, int hardness, int healthPoints, double reactor) {
        this.primaryColor = primaryColor;
        this.secundaryColor = secundaryColor;
        this.console = console;
        this.synthesizer = synthesizer;
        this.rightGlove = rightGlove;
        this.leftGlove = leftGlove;
        this.rightBoot = rightBoot;
        this.leftBoot = leftBoot;
        this.hardness = hardness;
        this.healthPoints = healthPoints;
        this.reactor = reactor;
    }

    public String getPrimaryColor() {
        return this.primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public String getSecundaryColor() {
        return this.secundaryColor;
    }

    public void setSecundaryColor(String secundaryColor) {
        this.secundaryColor = secundaryColor;
    }

    public Device getConsole() {
        return this.console;
    }

    public void setConsole(Device console) {
        this.console = console;
    }

    public Device getSynthesizer() {
        return this.synthesizer;
    }

    public void setSynthesizer(Device synthesizer) {
        this.synthesizer = synthesizer;
    }

    public Device getRightGlove() {
        return this.rightGlove;
    }

    public void setRightGlove(Device rightGlove) {
        this.rightGlove = rightGlove;
    }

    public Device getLeftGlove() {
        return this.leftGlove;
    }

    public void setLeftGlove(Device leftGlove) {
        this.leftGlove = leftGlove;
    }

    public Device getRightBoot() {
        return this.rightBoot;
    }

    public void setRightBoot(Device rightBoot) {
        this.rightBoot = rightBoot;
    }

    public Device getLeftBoot() {
        return this.leftBoot;
    }

    public void setLeftBoot(Device leftBoot) {
        this.leftBoot = leftBoot;
    }

    public int getHardness() {
        return this.hardness;
    }

    public void setHardness(int hardness) {
        this.hardness = hardness;
    }

    public int getHealthPoints() {
        return this.healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public double getReactor() {
        return this.reactor;
    }

    public void setReactor(double reactor) {
        this.reactor = reactor;
    }



}

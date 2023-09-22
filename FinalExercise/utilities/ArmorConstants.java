package FinalExercise.utilities;

public class ArmorConstants {
    private static final double CONSUMPTION_MULTIPLICATOR = Math.pow(10, 35);
    public static final double ENERGY_TO_KWH = Math.pow(10, 35);
    public static final double ENERGY_TO_MJ = Math.pow(10, 35) / 3.6;
    public static final double BOOT_CONSUMPTION = 1.5 * CONSUMPTION_MULTIPLICATOR;
    public static final double GLOVE_CONSUMPTION = 2.5 * CONSUMPTION_MULTIPLICATOR;
    public static final double SYNTHESIZER_CONSUMPTION = 0.25 * CONSUMPTION_MULTIPLICATOR;
    public static final double CONSOLE_CONSUMPTION = 0.35 * CONSUMPTION_MULTIPLICATOR;
    public static final double RADAR_CONSUMPTION = 0.10 * CONSUMPTION_MULTIPLICATOR;
    public static final double REACTOR_MAX_VALUE = Float.MAX_VALUE;
    public static final int INITIAL_HP = 100;
    public static final int STANDARD_HARDNESS = 80;
    public static final int MIN_HARDNESS = 20;
    public static final int MAX_HARDNESS = 100;
    public static final int BASIC_USE = 1;
    public static final int NORMAL_USE = 2;
    public static final int INTENSIVE_USE = 3;
    public static final double BREAKDOWN_PROB = 30;
    public static final double REPAIR_PROB = 40;
    public static final double DESTROY_PROB = 30;
    public static final String KEY_RADAR = "radar";
    public static final String KEY_RIGHTBOOT = "rightBoot";
    public static final String KEY_LEFTBOOT = "leftBoot";
    public static final String KEY_RIGHTGLOVE = "rightGlove";
    public static final String KEY_LEFTGLOVE = "leftGlove";
    public static final String KEY_CONSOLE = "console";
    public static final String KEY_SYNTHESIZER = "synthesizer";

}

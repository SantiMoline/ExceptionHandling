
import FinalExercise.entities.Armor;


public class IronMan {
    public static void main(String[] args) {
        Armor armor = new Armor();

        // armor.run(25);
        // armor.fly(10);
        // armor.shootFromGloves(30);

        armor.showBatteryStatus();
        System.out.println(armor.getReactor());
        armor.showReactorStatus();
        for (int i = 0; i < 1; i++) {
            try {
                System.out.println("Try: " + i);
                System.out.println("Walkin...");
                armor.walk(15);
                System.out.println("Shootin..");
                armor.shootFromGloves(10);
                System.out.println("Reading console..");
                armor.readConsole(5);
                System.out.println("speaking through synthesizer..");
                armor.speakThroughSynthesizer(2);
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                armor.scanArmor();
            }
        }

        armor.activateRadar(10);
        armor.getRadar().showObjectives();
 

    }
}

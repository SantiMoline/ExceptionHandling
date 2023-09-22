package IronMan.entities;

import static IronMan.utilities.RadarConstants.*;

import java.util.ArrayList;

public class Radar extends Device {
    ArrayList<Objective> objectives;


    public Radar(double consumption) {
        super(consumption);
        objectives = new ArrayList<>();
    }


    public Radar(Radar source) {
        super(source);
        this.objectives = source.objectives;
    }


    public ArrayList<Objective> getObjectives() {
        return this.objectives;
    }

    public void setObjectives(ArrayList<Objective> objectives) {
        this.objectives = objectives;
    }

    public boolean addObjective(Objective objective) throws IllegalStateException {
        if(objectives.size() >= MAX_OBJECTIVES) {
            throw new IllegalStateException("Cannot add any more objective. Currently tracking the maximum " + MAX_OBJECTIVES + " objectives.");
        }
        objectives.add(objective);
        return true;
    }

    @Override
    public double use(int intensity, int time) {
        while (objectives.size() < MAX_OBJECTIVES) {
            addObjective(new Objective());
        }
        return super.use(intensity, time);
    }

    public double calculateDistance(Objective objective) {
        return objective.getCoordinates().distanceTo(ORIGIN_COORD);
    }

    public void showObjectives() {
        System.out.println("Displaying current objectives information: ");

        for (Objective objective : objectives) {
            System.out.println(objective);
            System.out.println("Distance in meters: " + calculateDistance(objective));
        }
    }


}

package InterfacesAndAbstraction.MilitaryElite;

import java.util.ArrayList;
import java.util.List;

public class Commando extends SpecialisedSoldier implements ICommando {

    private List<Mission> missions;


    public Commando(String fistName, String lastName, int id, double salary, String corps) {
        super(fistName, lastName, id, salary, corps);

        this.missions = new ArrayList<>();

    }

    @Override
    public void addMission(Mission mission) {

        this.missions.add(mission);
    }

    @Override
    public List<Mission> getMissions() {

        return this.missions;
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();

        str.append(super.toString() + "\n");
        str.append("Corps: " + super.getCorps() + "\n");
        str.append("Missions: " + "\n");

        for (int i = 0; i < this.missions.size(); i++) {

            str.append(this.missions.get(i).toString() + "\n");

        }

        return str.toString();
    }
}

package InterfacesAndAbstraction.MilitaryElite;

import java.util.ArrayList;
import java.util.List;

public class Engineer extends SpecialisedSoldier implements IEngineer {

    private List<Repair> repairs;

    public Engineer(String fistName, String lastName, int id, double salary, String corps) {
        super(fistName, lastName, id, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {

        this.repairs.add(repair);
    }

    @Override
    public List<Repair> getRepairs() {

        return this.repairs;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append(super.toString() + "\n");
        builder.append("Corps: " + super.getCorps() + "\n");
        builder.append("Repairs:" + "\n");

        for (int i = 0; i < this.repairs.size(); i++) {

            builder.append(this.repairs.get(i).toString() + "\n");

        }

        return builder.toString();

    }
}

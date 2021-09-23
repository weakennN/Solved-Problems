package InterfacesAndAbstraction.MilitaryElite;

public class Repair {

    private String name;
    private int workedHours;

    public Repair(String name, int workedHours) {

        this.name = name;
        this.workedHours = workedHours;
    }

    @Override
    public String toString() {

        return String.format("  Part Name: %s Hours Worked: %d", this.name, this.workedHours);
    }
}

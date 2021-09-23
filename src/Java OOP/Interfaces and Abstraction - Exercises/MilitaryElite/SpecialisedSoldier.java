package InterfacesAndAbstraction.MilitaryElite;

public abstract class SpecialisedSoldier extends Private {

    private String corps;

    public SpecialisedSoldier(String fistName, String lastName, int id, double salary, String corps) {
        super(fistName, lastName, id, salary);

        setCorps(corps);
    }

    protected void setCorps(String corps) {

        this.corps = corps;
    }

    protected String getCorps() {

        return this.corps;
    }
}

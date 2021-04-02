package InterfacesAndAbstraction.MilitaryElite;

public abstract class Soldier implements ISoldier {

    private String fistName;
    private String lastName;
    private int id;

    protected Soldier(String fistName, String lastName, int id) {

        setFistName(fistName);
        setLastName(lastName);
        setId(id);
    }


    private void setFistName(String fistName) {

        this.fistName = fistName;
    }

    private void setLastName(String lastName) {

        this.lastName = lastName;
    }

    private void setId(int id) {

        this.id = id;
    }

    @Override
    public String getFirstName() {

        return this.fistName;
    }

    @Override
    public String getLastName() {

        return this.lastName;
    }

    @Override
    public int getId() {

        return this.id;
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();

        str.append(String.format("Name: %s %s Id: %d", this.fistName, this.lastName, this.id));

        return str.toString();
    }
}

package InterfacesAndAbstraction.MilitaryElite;

public class Spy extends Soldier {

    private String codeNumber;

    public Spy(String fistName, String lastName, int id, String codeNumber) {
        super(fistName, lastName, id);

        this.codeNumber = codeNumber;
    }

    public String getCodeNumber() {

        return this.codeNumber;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append(super.toString() + "\n");
        builder.append("Code Number: " + this.codeNumber);

        return builder.toString();
    }
}

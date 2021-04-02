package InterfacesAndAbstraction.MilitaryElite;

public class Private extends Soldier implements IPrivate {

    private double salary;

    public Private(String fistName, String lastName, int id, double salary) {
        super(fistName, lastName, id);

        setSalary(salary);
    }

    private void setSalary(double salary) {

        this.salary = salary;
    }

    @Override
    public double getSalary() {

        return this.salary;
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();

        str.append(super.toString() + " ");
        str.append(String.format("Salary: %.2f", this.salary));
        return str.toString();
    }
}

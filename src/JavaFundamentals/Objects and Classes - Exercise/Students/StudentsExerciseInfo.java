package ObjectsAndClasses;

public class StudentsExerciseInfo {

    private String firstName;
    private String lastName;
    private Double grade;

    public StudentsExerciseInfo(String firstName, String lastName, Double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s: %.2f", this.firstName, this.lastName, this.grade);

    }

    public double getGrade() {
        return this.grade;
    }
}

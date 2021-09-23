package MoreClasses.Google;

public class Company {

    private String company;
    private String department;
    private String salary;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Company(String company, String department, String salary) {

        this.company = company;
        this.department = department;
        this.salary = salary;
    }

    public Company(){
        this.company = "";
        this.department = "";
        this.salary = "";

    }
}

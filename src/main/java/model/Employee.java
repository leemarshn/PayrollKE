package model;

import java.util.Date;

public class Employee {
    private int nationalID;
    private String first_name;
    private String last_name;
    private String middle_name;

    public Employee(int nationalID, String first_name, String last_name, String middle_name) {
        this.nationalID = nationalID;
        this.first_name = first_name;
        this.last_name = last_name;
        this.middle_name = middle_name;
    }


    @Override
    public String toString() {
        return "ID: " + nationalID + ", " +
                last_name + " " +
                first_name + " " +
                (middle_name.isEmpty() ? "" : middle_name + ".");
    }
}

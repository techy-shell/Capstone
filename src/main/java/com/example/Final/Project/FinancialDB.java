package com.example.Final.Project;

public class FinancialDB {


    //Getter and setters needed once names confirmed
    // name could change depending on the database.
    private int userName;
    private int salary;

    private int mortgage;



    public int getUserName() {
        return userName;
    }

    public void setUserName(int userName) {
        this.userName = userName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getMortgage() {
        return mortgage;
    }

    public void setMortgage(int mortgage) {
        this.mortgage = mortgage;
    }

}

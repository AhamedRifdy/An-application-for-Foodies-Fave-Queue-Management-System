package com.example.task4;

public class Customer {
    private String firstName; // The first name of the customer
    private String lastName; // The last name of the customer
    private int noOfBurgerCount; //No. of burgers required by the customer

    public Customer() {
    }

    public Customer(String firstName, String lastName, int noOfBurgerCount) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setNoOfBurgerCount(noOfBurgerCount);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNoOfBurgerCount() {
        return noOfBurgerCount;
    }

    public void setNoOfBurgerCount(int noOfBurgerCount) {
        this.noOfBurgerCount = noOfBurgerCount;
    }

}

package org.example;


/**
 * This class represents the account with name and balance, provides methods for setting and getting account details
 */
public class Account {
    private String name; // the name of the account holder
    private double balance; // the balance of the account

    /**
     * Default constructor, initializes the account with an empty name and balance
     */
    public Account(){
        setName("");
        setBalance(0.0);
    }

    /**
     * Constructor to create an account with the right name and balance
     * @param name  The name of the account holder
     * @param balance The balance of that account
     */
    public Account(String name, double balance){
        this.setName(name);
        this.setBalance(balance);
    }

    /**
     * Copy constructor to create a deep copy of the another account
     * @param other The account to copy
     */
    public Account(Account other){
        this.setName(other.getName());
        this.setBalance(other.getBalance());
    }

    /**
     *  get the name of the account
     * @return The name of the account
     */
    public String getName() {
        return name;
    }

    /**
     *  set the name of the account
     * @param name  The name of the account
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *  get the balance of the account
     * @return The balance of the account
     */
    public double getBalance() {
        return balance;
    }
    /**
     *  set the balance of the account
     * @param balance  The balance of the account
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Create and return a deep copy of the current account
     * @return A deep copy of the current account
     */
    Account deepCopy(){
        return new Account(this);
    }

    /**
     * Compares this caccount with another object to check if they are equal or not
     * @param obj object to compare with
     * @return {@code true} if the objects are equal
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Account other = (Account) obj;
        return name.equals(other.name) && balance == other.balance;
    }
}


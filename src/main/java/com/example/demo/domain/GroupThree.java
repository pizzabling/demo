package com.example.demo.domain;

public class GroupThree {
    private int id;
    private int workerFirst;
    private int workerSecond;
    private int workerThird;
    private double rentFirst;
    private double rentSecond;
    private double rentThird;
    private double expenses;

    public GroupThree(int id, int workerFirst, int workerSecond, int workerThird, double rentFirst, double rentSecond, double rentThird, double expenses) {
        this.id = id;
        this.workerFirst = workerFirst;
        this.workerSecond = workerSecond;
        this.workerThird = workerThird;
        this.rentFirst = rentFirst;
        this.rentSecond = rentSecond;
        this.rentThird = rentThird;
        this.expenses = expenses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorkerFirst() {
        return workerFirst;
    }

    public void setWorkerFirst(int workerFirst) {
        this.workerFirst = workerFirst;
    }

    public int getWorkerSecond() {
        return workerSecond;
    }

    public void setWorkerSecond(int workerSecond) {
        this.workerSecond = workerSecond;
    }

    public int getWorkerThird() {
        return workerThird;
    }

    public void setWorkerThird(int workerThird) {
        this.workerThird = workerThird;
    }

    public double getRentFirst() {
        return rentFirst;
    }

    public void setRentFirst(double rentFirst) {
        this.rentFirst = rentFirst;
    }

    public double getRentSecond() {
        return rentSecond;
    }

    public void setRentSecond(double rentSecond) {
        this.rentSecond = rentSecond;
    }

    public double getRentThird() {
        return rentThird;
    }

    public void setRentThird(double rentThird) {
        this.rentThird = rentThird;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }
}

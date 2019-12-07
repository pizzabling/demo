package com.example.demo.domain;

import lombok.Data;

@Data
public class GroupTwo {
    private int id;
    private int workerFirst;
    private int workerSecond;
    private int salaryPercentFirst;
    private int salaryPercentSecond;
    private double rentFirst;
    private double rentSecond;
    private double expenses;

    public GroupTwo() {
    }

    public GroupTwo(int id, int workerFirst, int workerSecond, int salaryPercentFirst, int salaryPercentSecond, double rentFirst, double rentSecond, double expenses) {
        this.id = id;
        this.workerFirst = workerFirst;
        this.workerSecond = workerSecond;
        this.salaryPercentFirst = salaryPercentFirst;
        this.salaryPercentSecond = salaryPercentSecond;
        this.rentFirst = rentFirst;
        this.rentSecond = rentSecond;
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

    public int getSalaryPercentFirst() {
        return salaryPercentFirst;
    }

    public void setSalaryPercentFirst(int salaryPercentFirst) {
        this.salaryPercentFirst = salaryPercentFirst;
    }

    public int getSalaryPercentSecond() {
        return salaryPercentSecond;
    }

    public void setSalaryPercentSecond(int salaryPercentSecond) {
        this.salaryPercentSecond = salaryPercentSecond;
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

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }
}

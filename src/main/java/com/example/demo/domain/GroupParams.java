package com.example.demo.domain;

import lombok.Data;

@Data
public class GroupParams {
    private double groupParams1;
    private double groupParams2;
    private double groupParams3;
    private double groupParams4;
    private double groupParams5;
    private double groupParams6;
    private double groupParams7;

    public GroupParams(double groupParams1, double groupParams2, double groupParams3, double groupParams4, double groupParams5, double groupParams6, double groupParams7) {
        this.groupParams1 = groupParams1;
        this.groupParams2 = groupParams2;
        this.groupParams3 = groupParams3;
        this.groupParams4 = groupParams4;
        this.groupParams5 = groupParams5;
        this.groupParams6 = groupParams6;
        this.groupParams7 = groupParams7;
    }

    public double getGroupParams1() {
        return groupParams1;
    }

    public void setGroupParams1(double groupParams1) {
        this.groupParams1 = groupParams1;
    }

    public double getGroupParams2() {
        return groupParams2;
    }

    public void setGroupParams2(double groupParams2) {
        this.groupParams2 = groupParams2;
    }

    public double getGroupParams3() {
        return groupParams3;
    }

    public void setGroupParams3(double groupParams3) {
        this.groupParams3 = groupParams3;
    }

    public double getGroupParams4() {
        return groupParams4;
    }

    public void setGroupParams4(double groupParams4) {
        this.groupParams4 = groupParams4;
    }

    public double getGroupParams5() {
        return groupParams5;
    }

    public void setGroupParams5(double groupParams5) {
        this.groupParams5 = groupParams5;
    }

    public double getGroupParams6() {
        return groupParams6;
    }

    public void setGroupParams6(double groupParams6) {
        this.groupParams6 = groupParams6;
    }

    public double getGroupParams7() {
        return groupParams7;
    }

    public void setGroupParams7(double groupParams7) {
        this.groupParams7 = groupParams7;
    }
}

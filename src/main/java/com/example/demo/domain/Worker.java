package com.example.demo.domain;

import lombok.Data;

@Data
public class Worker{
    private int id;
    private int workerId;
    private double rent;
    private double janRent;
    private double febRent;
    private double marRent;
    private double aprRent;
    private double mayRent;
    private double juneRent;
    private double julyRent;
    private double augRent;
    private double sepRent;
    private double octRent;
    private double novRent;
    private double decRent;
    private String name;
    private double ratio;
    private String comment;

    public Worker() {
    }

    public Worker(int workerId, double rent) {
        this.workerId = workerId;
        this.rent = rent;
    }

    public Worker(int id, int workerId, double rent, String comment, String name) {
        this.id = id;
        this.workerId = workerId;
        this.rent = rent;
        this.comment = comment;
        this.name = name;
    }



    public Worker(int id, int workerId, double rent, double janRent, double febRent, double marRent, double aprRent, double mayRent, double juneRent, double julyRent, double augRent, double sepRent, double octRent, double novRent, double decRent, String name, double ratio, String comment) {

        this.id = id;
        this.workerId = workerId;
        this.rent = rent;
        this.janRent = janRent;
        this.febRent = febRent;
        this.marRent = marRent;
        this.aprRent = aprRent;
        this.mayRent = mayRent;
        this.juneRent = juneRent;
        this.julyRent = julyRent;
        this.augRent = augRent;
        this.sepRent = sepRent;
        this.octRent = octRent;
        this.novRent = novRent;
        this.decRent = decRent;
        this.name = name;
        this.ratio = ratio;
        this.comment = comment;

    }

    public Worker(int id, int workerId, double rent, double janRent, double febRent, double marRent, double aprRent, double mayRent, double juneRent, double julyRent, double augRent, double sepRent, double octRent, double novRent, double decRent, String name, double ratio, String comment, double bond, double kent, double parlament, double winston, double lm, double malboro, double rotmans, double ld, double fmorris, double aliance, double java, double optima, double petr, double maksim, double crests, double vog, double glamur, double kiss, double esse, double quin, double lady, double mor, double chester, double radopy, double stuardessa, double stolichniye, double donskoy, double troyka, double fast, double royal, double manchester, double prestigue, double premier, double cosmos, double next, double magnat, double minsk, double souz) {
        this.id = id;
        this.workerId = workerId;
        this.rent = rent;
        this.janRent = janRent;
        this.febRent = febRent;
        this.marRent = marRent;
        this.aprRent = aprRent;
        this.mayRent = mayRent;
        this.juneRent = juneRent;
        this.julyRent = julyRent;
        this.augRent = augRent;
        this.sepRent = sepRent;
        this.octRent = octRent;
        this.novRent = novRent;
        this.decRent = decRent;
        this.name = name;
        this.ratio = ratio;
        this.comment = comment;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public double getJanRent() {
        return janRent;
    }

    public void setJanRent(double janRent) {
        this.janRent = janRent;
    }

    public double getFebRent() {
        return febRent;
    }

    public void setFebRent(double febRent) {
        this.febRent = febRent;
    }

    public double getMarRent() {
        return marRent;
    }

    public void setMarRent(double marRent) {
        this.marRent = marRent;
    }

    public double getAprRent() {
        return aprRent;
    }

    public void setAprRent(double aprRent) {
        this.aprRent = aprRent;
    }

    public double getMayRent() {
        return mayRent;
    }

    public void setMayRent(double mayRent) {
        this.mayRent = mayRent;
    }

    public double getJuneRent() {
        return juneRent;
    }

    public void setJuneRent(double juneRent) {
        this.juneRent = juneRent;
    }

    public double getJulyRent() {
        return julyRent;
    }

    public void setJulyRent(double julyRent) {
        this.julyRent = julyRent;
    }

    public double getAugRent() {
        return augRent;
    }

    public void setAugRent(double augRent) {
        this.augRent = augRent;
    }

    public double getSepRent() {
        return sepRent;
    }

    public void setSepRent(double sepRent) {
        this.sepRent = sepRent;
    }

    public double getOctRent() {
        return octRent;
    }

    public void setOctRent(double octRent) {
        this.octRent = octRent;
    }

    public double getNovRent() {
        return novRent;
    }

    public void setNovRent(double novRent) {
        this.novRent = novRent;
    }

    public double getDecRent() {
        return decRent;
    }

    public void setDecRent(double decRent) {
        this.decRent = decRent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
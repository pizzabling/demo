package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@NoArgsConstructor

public class Worker {
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
    private double rentRatio;

    private double bond;
    private double kent;
    private double parlament;
    private double winston;
    private double lm;
    private double malboro;
    private double rotmans;
    private double ld;
    private double fmorris;
    private double aliance;
    private double java;
    private double optima;
    private double petr;
    private double maksim;
    private double crests;
    private double vog;
    private double glamur;
    private double kiss;
    private double esse;
    private double quin;
    private double lady;
    private double mor;
    private double chester;
    private double radopy;
    private double stuardessa;
    private double stolichniye;
    private double donskoy;
    private double troyka;
    private double fast;
    private double royal;
    private double manchester;
    private double prestigue;
    private double premier;
    private double cosmos;
    private double next;
    private double magnat;
    private double minsk;
    private double souz;

    public Worker(int id, int workerId, double rent, double janRent, double febRent, double marRent, double aprRent, double mayRent, double juneRent, double julyRent, double augRent, double sepRent, double octRent, double novRent, double decRent, String name, double ratio, double rentRatio) {
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
        this.rentRatio = rentRatio;
    }

    public Worker(int id, int workerId, double rent, double janRent, double febRent, double marRent, double aprRent, double mayRent, double juneRent, double julyRent, double augRent, double sepRent, double octRent, double novRent, double decRent, String name, double ratio, double rentRatio, double bond, double kent, double parlament, double winston, double lm, double malboro, double rotmans, double ld, double fmorris, double aliance, double java, double optima, double petr, double maksim, double crests, double vog, double glamur, double kiss, double esse, double quin, double lady, double mor, double chester, double radopy, double stuardessa, double stolichniye, double donskoy, double troyka, double fast, double royal, double manchester, double prestigue, double premier, double cosmos, double next, double magnat, double minsk, double souz) {
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
        this.rentRatio = rentRatio;
        this.bond = bond;
        this.kent = kent;
        this.parlament = parlament;
        this.winston = winston;
        this.lm = lm;
        this.malboro = malboro;
        this.rotmans = rotmans;
        this.ld = ld;
        this.fmorris = fmorris;
        this.aliance = aliance;
        this.java = java;
        this.optima = optima;
        this.petr = petr;
        this.maksim = maksim;
        this.crests = crests;
        this.vog = vog;
        this.glamur = glamur;
        this.kiss = kiss;
        this.esse = esse;
        this.quin = quin;
        this.lady = lady;
        this.mor = mor;
        this.chester = chester;
        this.radopy = radopy;
        this.stuardessa = stuardessa;
        this.stolichniye = stolichniye;
        this.donskoy = donskoy;
        this.troyka = troyka;
        this.fast = fast;
        this.royal = royal;
        this.manchester = manchester;
        this.prestigue = prestigue;
        this.premier = premier;
        this.cosmos = cosmos;
        this.next = next;
        this.magnat = magnat;
        this.minsk = minsk;
        this.souz = souz;
    }
//    public Worker(double bond, double kent, double parlament, double winston, double lm, double malboro, double rotmans, double ld, double fmorris, double aliance, double java, double optima, double petr, double maksim, double crests, double vog, double glamur, double kiss, double esse, double quin, double lady, double mor, double chester, double radopy, double stuardessa, double stolichniye, double donskoy, double troyka, double fast, double royal, double manchester, double prestigue, double premier, double cosmos, double next, double magnat, double minsk, double souz) {
//
//        this.bond = bond;
//        this.kent = kent;
//        this.parlament = parlament;
//        this.winston = winston;
//        this.lm = lm;
//        this.malboro = malboro;
//        this.rotmans = rotmans;
//        this.ld = ld;
//        this.fmorris = fmorris;
//        this.aliance = aliance;
//        this.java = java;
//        this.optima = optima;
//        this.petr = petr;
//        this.maksim = maksim;
//        this.crests = crests;
//        this.vog = vog;
//        this.glamur = glamur;
//        this.kiss = kiss;
//        this.esse = esse;
//        this.quin = quin;
//        this.lady = lady;
//        this.mor = mor;
//        this.chester = chester;
//        this.radopy = radopy;
//        this.stuardessa = stuardessa;
//        this.stolichniye = stolichniye;
//        this.donskoy = donskoy;
//        this.troyka = troyka;
//        this.fast = fast;
//        this.royal = royal;
//        this.manchester = manchester;
//        this.prestigue = prestigue;
//        this.premier = premier;
//        this.cosmos = cosmos;
//        this.next = next;
//        this.magnat = magnat;
//        this.minsk = minsk;
//        this.souz = souz;
//
//    }

    public Worker(int id, double rent) {
        super();
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

    public double getRentRatio(){
        return rentRatio;
    }
    public void setRentRatio(double rentRatio){
        this.rentRatio = rentRatio;
    }
    public double getBond() {
        return bond;
    }

    public void setBond(double bond) {
        this.bond = bond;
    }

    public double getKent() {
        return kent;
    }

    public void setKent(double kent) {
        this.kent = kent;
    }

    public double getParlament() {
        return parlament;
    }

    public void setParlament(double parlament) {
        this.parlament = parlament;
    }

    public double getWinston() {
        return winston;
    }

    public void setWinston(double winston) {
        this.winston = winston;
    }

    public double getLm() {
        return lm;
    }

    public void setLm(double lm) {
        this.lm = lm;
    }

    public double getMalboro() {
        return malboro;
    }

    public void setMalboro(double malboro) {
        this.malboro = malboro;
    }

    public double getRotmans() {
        return rotmans;
    }

    public void setRotmans(double rotmans) {
        this.rotmans = rotmans;
    }

    public double getLd() {
        return ld;
    }

    public void setLd(double ld) {
        this.ld = ld;
    }

    public double getFmorris() {
        return fmorris;
    }

    public void setFmorris(double fmorris) {
        this.fmorris = fmorris;
    }

    public double getAliance() {
        return aliance;
    }

    public void setAliance(double aliance) {
        this.aliance = aliance;
    }

    public double getJava() {
        return java;
    }

    public void setJava(double java) {
        this.java = java;
    }

    public double getOptima() {
        return optima;
    }

    public void setOptima(double optima) {
        this.optima = optima;
    }

    public double getPetr() {
        return petr;
    }

    public void setPetr(double petr) {
        this.petr = petr;
    }

    public double getMaksim() {
        return maksim;
    }

    public void setMaksim(double maksim) {
        this.maksim = maksim;
    }

    public double getCrests() {
        return crests;
    }

    public void setCrests(double crests) {
        this.crests = crests;
    }

    public double getVog() {
        return vog;
    }

    public void setVog(double vog) {
        this.vog = vog;
    }

    public double getGlamur() {
        return glamur;
    }

    public void setGlamur(double glamur) {
        this.glamur = glamur;
    }

    public double getKiss() {
        return kiss;
    }

    public void setKiss(double kiss) {
        this.kiss = kiss;
    }

    public double getEsse() {
        return esse;
    }

    public void setEsse(double esse) {
        this.esse = esse;
    }

    public double getQuin() {
        return quin;
    }

    public void setQuin(double quin) {
        this.quin = quin;
    }

    public double getLady() {
        return lady;
    }

    public void setLady(double lady) {
        this.lady = lady;
    }

    public double getMor() {
        return mor;
    }

    public void setMor(double mor) {
        this.mor = mor;
    }

    public double getChester() {
        return chester;
    }

    public void setChester(double chester) {
        this.chester = chester;
    }

    public double getRadopy() {
        return radopy;
    }

    public void setRadopy(double radopy) {
        this.radopy = radopy;
    }

    public double getStuardessa() {
        return stuardessa;
    }

    public void setStuardessa(double stuardessa) {
        this.stuardessa = stuardessa;
    }

    public double getStolichniye() {
        return stolichniye;
    }

    public void setStolichniye(double stolichniye) {
        this.stolichniye = stolichniye;
    }

    public double getDonskoy() {
        return donskoy;
    }

    public void setDonskoy(double donskoy) {
        this.donskoy = donskoy;
    }

    public double getTroyka() {
        return troyka;
    }

    public void setTroyka(double troyka) {
        this.troyka = troyka;
    }

    public double getFast() {
        return fast;
    }

    public void setFast(double fast) {
        this.fast = fast;
    }

    public double getRoyal() {
        return royal;
    }

    public void setRoyal(double royal) {
        this.royal = royal;
    }

    public double getManchester() {
        return manchester;
    }

    public void setManchester(double manchester) {
        this.manchester = manchester;
    }

    public double getPrestigue() {
        return prestigue;
    }

    public void setPrestigue(double prestigue) {
        this.prestigue = prestigue;
    }

    public double getPremier() {
        return premier;
    }

    public void setPremier(double premier) {
        this.premier = premier;
    }

    public double getCosmos() {
        return cosmos;
    }

    public void setCosmos(double cosmos) {
        this.cosmos = cosmos;
    }

    public double getNext() {
        return next;
    }

    public void setNext(double next) {
        this.next = next;
    }

    public double getMagnat() {
        return magnat;
    }

    public void setMagnat(double magnat) {
        this.magnat = magnat;
    }

    public double getMinsk() {
        return minsk;
    }

    public void setMinsk(double minsk) {
        this.minsk = minsk;
    }

    public double getSouz() {
        return souz;
    }

    public void setSouz(double souz) {
        this.souz = souz;
    }
//    public double getBond() {
//        return bond;
//    }
//
//    public void setBond(double bond) {
//        this.bond = bond;
//    }
//
//    public double getKent() {
//        return kent;
//    }
//
//    public void setKent(double kent) {
//        this.kent = kent;
//    }
//
//    public double getParlament() {
//        return parlament;
//    }
//
//    public void setParlament(double parlament) {
//        this.parlament = parlament;
//    }
//
//    public double getWinston() {
//        return winston;
//    }
//
//    public void setWinston(double winston) {
//        this.winston = winston;
//    }
//
//    public double getLm() {
//        return lm;
//    }
//
//    public void setLm(double lm) {
//        this.lm = lm;
//    }
//
//    public double getMalboro() {
//        return malboro;
//    }
//
//    public void setMalboro(double malboro) {
//        this.malboro = malboro;
//    }
//
//    public double getRotmans() {
//        return rotmans;
//    }
//
//    public void setRotmans(double rotmans) {
//        this.rotmans = rotmans;
//    }
//
//    public double getLd() {
//        return ld;
//    }
//
//    public void setLd(double ld) {
//        this.ld = ld;
//    }
//
//    public double getFmorris() {
//        return fmorris;
//    }
//
//    public void setFmorris(double fmorris) {
//        this.fmorris = fmorris;
//    }
//
//    public double getAliance() {
//        return aliance;
//    }
//
//    public void setAliance(double aliance) {
//        this.aliance = aliance;
//    }
//
//    public double getJava() {
//        return java;
//    }
//
//    public void setJava(double java) {
//        this.java = java;
//    }
//
//    public double getOptima() {
//        return optima;
//    }
//
//    public void setOptima(double optima) {
//        this.optima = optima;
//    }
//
//    public double getPetr() {
//        return petr;
//    }
//
//    public void setPetr(double petr) {
//        this.petr = petr;
//    }
//
//    public double getMaksim() {
//        return maksim;
//    }
//
//    public void setMaksim(double maksim) {
//        this.maksim = maksim;
//    }
//
//    public double getCrests() {
//        return crests;
//    }
//
//    public void setCrests(double crests) {
//        this.crests = crests;
//    }
//
//    public double getVog() {
//        return vog;
//    }
//
//    public void setVog(double vog) {
//        this.vog = vog;
//    }
//
//    public double getGlamur() {
//        return glamur;
//    }
//
//    public void setGlamur(double glamur) {
//        this.glamur = glamur;
//    }
//
//    public double getKiss() {
//        return kiss;
//    }
//
//    public void setKiss(double kiss) {
//        this.kiss = kiss;
//    }
//
//    public double getEsse() {
//        return esse;
//    }
//
//    public void setEsse(double esse) {
//        this.esse = esse;
//    }
//
//    public double getQuin() {
//        return quin;
//    }
//
//    public void setQuin(double quin) {
//        this.quin = quin;
//    }
//
//    public double getLady() {
//        return lady;
//    }
//
//    public void setLady(double lady) {
//        this.lady = lady;
//    }
//
//    public double getMor() {
//        return mor;
//    }
//
//    public void setMor(double mor) {
//        this.mor = mor;
//    }
//
//    public double getChester() {
//        return chester;
//    }
//
//    public void setChester(double chester) {
//        this.chester = chester;
//    }
//
//    public double getRadopy() {
//        return radopy;
//    }
//
//    public void setRadopy(double radopy) {
//        this.radopy = radopy;
//    }
//
//    public double getStuardessa() {
//        return stuardessa;
//    }
//
//    public void setStuardessa(double stuardessa) {
//        this.stuardessa = stuardessa;
//    }
//
//    public double getStolichniye() {
//        return stolichniye;
//    }
//
//    public void setStolichniye(double stolichniye) {
//        this.stolichniye = stolichniye;
//    }
//
//    public double getDonskoy() {
//        return donskoy;
//    }
//
//    public void setDonskoy(double donskoy) {
//        this.donskoy = donskoy;
//    }
//
//    public double getTroyka() {
//        return troyka;
//    }
//
//    public void setTroyka(double troyka) {
//        this.troyka = troyka;
//    }
//
//    public double getFast() {
//        return fast;
//    }
//
//    public void setFast(double fast) {
//        this.fast = fast;
//    }
//
//    public double getRoyal() {
//        return royal;
//    }
//
//    public void setRoyal(double royal) {
//        this.royal = royal;
//    }
//
//    public double getManchester() {
//        return manchester;
//    }
//
//    public void setManchester(double manchester) {
//        this.manchester = manchester;
//    }
//
//    public double getPrestigue() {
//        return prestigue;
//    }
//
//    public void setPrestigue(double prestigue) {
//        this.prestigue = prestigue;
//    }
//
//    public double getPremier() {
//        return premier;
//    }
//
//    public void setPremier(double premier) {
//        this.premier = premier;
//    }
//
//    public double getCosmos() {
//        return cosmos;
//    }
//
//    public void setCosmos(double cosmos) {
//        this.cosmos = cosmos;
//    }
//
//    public double getNext() {
//        return next;
//    }
//
//    public void setNext(double next) {
//        this.next = next;
//    }
//
//    public double getMagnat() {
//        return magnat;
//    }
//
//    public void setMagnat(double magnat) {
//        this.magnat = magnat;
//    }
//
//    public double getMinsk() {
//        return minsk;
//    }
//
//    public void setMinsk(double minsk) {
//        this.minsk = minsk;
//    }
//
//    public double getSouz() {
//        return souz;
//    }
//
//    public void setSouz(double souz) {
//        this.souz = souz;
//    }
}
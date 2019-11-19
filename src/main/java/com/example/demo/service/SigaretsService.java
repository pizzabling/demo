package com.example.demo.service;

import com.example.demo.domain.Parameters;
import com.example.demo.domain.ResultSigarets;
import com.example.demo.domain.Worker;
import com.example.demo.repo.SigaretsRepo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SigaretsService {
    private JdbcTemplate jdbcTemplate;
    private com.example.demo.service.Service service;
    private SigaretsRepo sigaretsRepo;

    public SigaretsService(JdbcTemplate jdbcTemplate, com.example.demo.service.Service service, SigaretsRepo sigaretsRepo) {
        this.jdbcTemplate = jdbcTemplate;

        this.service = service;
        this.sigaretsRepo = sigaretsRepo;
    }

    private static final String FIND_ALL_BEST_GROUP = "SELECT * from SIGARETSRESULT";
    private static final String SAVE_BEST_GROUP = "INSERT INTO SIGARETSRESULT (firstId, secondId,PROCENTZP, sumBond, sumKent, sumParlament, sumWinston, sumLm, sumMalboro, sumRotmans, sumLd, sumFmorris, sumAliance, sumJava, sumOptima, sumPetr, sumMaksim, sumCrests, sumVog, sumGlamur, sumKiss, sumEsse, sumQuin, sumLady, sumMor, sumChester, sumRadopy, sumStuardessa, sumStolichniye, sumDonskoy, sumTroyka, sumFast, sumRoyal, sumManchester, sumPrestigue, sumPremier, sumCosmos, sumNext, sumMagnat, sumMinsk, sumSouz,\n" +
            "resultBond, resultKent, resultParlament, resultWinston, resultLm, resultMalboro, resultRotmans, resultLd, resultFmorris, resultAliance, resultJava, resultOptima, resultPetr, resultMaksim, resultCrests, resultVog, resultGlamur, resultKiss, resultEsse, resultQuin, resultLady, resultMor, resultChester, resultRadopy, resultStuardessa, resultStolichniye, resultDonskoy, resultTroyka, resultFast, resultRoyal,  resultManchester,resultPrestigue, resultPremier, resultCosmos, resultNext, resultMagnat, " +
            "resultMinsk, resultSouz, coefBond, coefKent, coefParlament, coefWinston, coefLm, coefMalboro, coefRotmans, coefLd, coefFmorris, coefAliance, coefJava, coefOptima, coefPetr, coefMaksim, coefCrests, coefVog, coefGlamur, coefKiss, coefEsse, coefQuin, coefLady, coefMor, coefChester, coefRadopy, coefStuardessa, coefStolichniye, coefDonskoy, coefTroyka, coefFast, coefRoyal, coefManchester, coefPrestigue, coefPremier, coefCosmos, coefNext, coefMagnat, coefMinsk, coefSouz)" +
            "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";

    public void save(Parameters parameters) {
        sigaretsRepo.saveParams(parameters);
    }

    public List<Parameters> findAll() {
        return sigaretsRepo.getAllResults();
    }

    public Parameters findParamsById(int id) {
        return sigaretsRepo.findParamsById(id);
    }

    public void saveBestGroup() {

        var parameters = findParamsById(1);

//        double substitution1;
//        double substitution2;
//        double expenses;

        double bond1 = 0;
        double bond2 = 0;
        double kent1 = 0;
        double kent2 = 0;
        double winston1 = 0;
        double winston2 = 0;
        double parlament1 = 0;
        double parlament2 = 0;
        double lm1 = 0;
        double lm2 = 0;
        double malboro1 = 0;
        double malboro2 = 0;
        double rotmans1 = 0;
        double rotmans2 = 0;
        double ld1 = 0;
        double ld2 = 0;
        double fmorris1 = 0;
        double fmorris2 = 0;
        double aliance1 = 0;
        double aliance2 = 0;
        double java1 = 0;
        double java2 = 0;
        double optima1 = 0;
        double optima2 = 0;
        double petr1 = 0;
        double petr2 = 0;
        double maksim1 = 0;
        double maksim2 = 0;
        double crests1 = 0;
        double crests2 = 0;
        double vog1 = 0;
        double vog2 = 0;
        double glamur1 = 0;
        double glamur2 = 0;
        double esse1 = 0;
        double esse2 = 0;
        double kiss1 = 0;
        double kiss2 = 0;
        double quin1 = 0;
        double quin2 = 0;
        double lady1 = 0;
        double lady2 = 0;
        double mor1 = 0;
        double mor2 = 0;
        double chester1 = 0;
        double chester2 = 0;
        double radopy1 = 0;
        double radopy2 = 0;
        double stuardessa1 = 0;
        double stuardessa2 = 0;
        double stolichniye1 = 0;
        double stolichniye2 = 0;
        double donskoy1 = 0;
        double donskoy2 = 0;
        double troyka1 = 0;
        double troyka2 = 0;
        double fast1 = 0;
        double fast2 = 0;
        double royal1 = 0;
        double royal2 = 0;
        double manchester1 = 0;
        double manchester2 = 0;
        double prestigue1 = 0;
        double prestigue2 = 0;
        double premier1 = 0;
        double premier2 = 0;
        double cosmos1 = 0;
        double cosmos2 = 0;
        double next1 = 0;
        double next2 = 0;
        double magnat1 = 0;
        double magnat2 = 0;
        double minsk1 = 0;
        double minsk2 = 0;
        double souz1 = 0;
        double souz2 = 0;
        for (int count = 1; count < 11; count++) {

            var worker1 = service.findWorkerById(count);
            double ratio1 = worker1.getRatio();
            for (int j = 2; j < 11; j++) {
                var worker2 = service.findWorkerById(j);
                double ratio2 = worker2.getRatio();
                for (double i = 1; i < 201; i++) {
                    double coef = i/100;
                    double substitution1 = ratio1 * coef;
                    double substitution2 = ratio2 * coef;
//                    substitution1 = 100;
//                    substitution2 = 200;
                    double expenses = substitution1 + substitution2;
                    if (worker1.getBond() != 0.0) {
                        bond1 = worker1.getBond() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set bond = ? where id=? ",
                                worker1.getBond() * substitution1, count);
                    }
                    if (worker2.getBond() != 0.0) {
                        bond2 = worker2.getBond() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set bond = ? where id=?",
                                worker2.getBond() * substitution2, j);
                    }
                    if (worker1.getKent() != 0.0) {
                        kent1 = worker1.getKent() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set KENT = ? where ID = ?",
                                worker1.getKent() * substitution1, count);
                    }
                    if (worker2.getKent() != 0.0) {
                        kent2 = worker2.getKent() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set KENT=? where ID=?",
                                worker2.getKent() * substitution2, j);
                    }
                    if (worker1.getParlament() != 0.0) {
                        parlament1 = worker1.getParlament() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set PARLAMENT=? where ID=?",
                                worker1.getParlament() * substitution1, count);
                    }
                    if (worker2.getParlament() != 0.0) {
                        parlament2 = worker2.getParlament() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set PARLAMENT=? where id=?",
                                worker2.getParlament() * substitution2, j);
                    }
                    if (worker1.getWinston() != 0.0) {
                        winston1 = worker1.getWinston() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set WINSTON=? where ID=?",
                                worker1.getWinston() * substitution1, count);
                    }
                    if (worker2.getWinston() != 0.0) {
                        winston2 = worker2.getWinston() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set WINSTON=? where ID=?",
                                worker2.getWinston() * substitution2, j);
                    }
                    if (worker1.getLm() != 0.0) {
                        lm1 = worker1.getLm() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set LM=? where ID=?",
                                worker1.getLm() * substitution1, count);
                    }
                    if (worker2.getLm() != 0.0) {
                        lm2 = worker2.getLm() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set LM=? where ID=?",
                                worker2.getLm() * substitution2, j);
                    }
                    if (worker1.getMalboro() != 0.0) {
                        malboro1 = worker1.getMalboro() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set MALBORO=? where ID=?",
                                worker1.getMalboro() * substitution1, count);
                    }
                    if (worker2.getMalboro() != 0.0) {
                        malboro2 = worker2.getMalboro() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set MALBORO=? where ID=?",
                                worker2.getMalboro() * substitution2, j);
                    }
                    if (worker1.getRotmans() != 0.0) {
                        rotmans1 = worker1.getRotmans() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set ROTMANS=? where ID=?",
                                worker1.getRotmans() * substitution1, count);
                    }
                    if (worker2.getRotmans() != 0.0) {
                        rotmans2 = worker2.getRotmans() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set ROTMANS=? where ID=?",
                                worker2.getRotmans() * substitution2, j);
                    }
                    if (worker1.getLd() != 0.0) {
                        ld1 = worker1.getLd() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set LD=? where ID=?",
                                worker1.getLd() * substitution1, count);
                    }
                    if (worker2.getLd() != 0.0) {
                        ld2 = worker2.getLd() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set LD=? where ID=?",
                                worker2.getLd() * substitution2, j);
                    }
                    if (worker1.getFmorris() != 0.0) {
                        fmorris1 = worker1.getFmorris() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set FMORRIS=? where ID=?",
                                worker1.getFmorris() * substitution1, count);
                    }
                    if (worker2.getFmorris() != 0.0) {
                        fmorris2 = worker2.getFmorris() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set FMORRIS=? where ID=?",
                                worker2.getFmorris() * substitution2, j);
                    }
                    if (worker1.getAliance() != 0.0) {
                        aliance1 = worker1.getAliance() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set ALIANCE=? where ID=?",
                                worker1.getAliance() * substitution1, count);
                    }
                    if (worker2.getAliance() != 0.0) {
                        aliance2 = worker2.getAliance() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set ALIANCE=? where ID=?",
                                worker2.getAliance() * substitution2, j);
                    }
                    if (worker1.getJava() != 0.0) {
                        java1 = worker1.getJava() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set JAVA=? where ID=?",
                                worker1.getJava() * substitution1, count);
                    }
                    if (worker2.getJava() != 0.0) {
                        java2 = worker2.getJava() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set JAVA=? where ID=?",
                                worker2.getJava() * substitution2, j);
                    }
                    if (worker1.getOptima() != 0.0) {
                        optima1 = worker1.getOptima() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set OPTIMA=? where ID=?",
                                worker1.getOptima() * substitution1, count);
                    }
                    if (worker2.getOptima() != 0.0) {
                        optima2 = worker2.getOptima() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set OPTIMA=? where ID=?",
                                worker2.getOptima() * substitution2, j);
                    }
                    if (worker1.getPetr() != 0.0) {
                        petr1 = worker1.getPetr() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set PETR=? where ID=?",
                                worker1.getPetr() * substitution1, count);
                    }
                    if (worker2.getPetr() != 0.0) {
                        petr2 = worker2.getPetr() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set PETR=? where ID=?",
                                worker2.getPetr() * substitution2, j);
                    }
                    if (worker1.getMaksim() != 0.0) {
                        maksim1 = worker1.getMaksim() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set MAKSIM=? where ID=?",
                                worker1.getMaksim() * substitution1, count);
                    }
                    if (worker2.getMaksim() != 0.0) {
                        maksim2 = worker2.getMaksim() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set MAKSIM=? where ID=?",
                                worker2.getMaksim() * substitution2, j);
                    }
                    if (worker1.getCrests() != 0.0) {
                        crests1 = worker1.getCrests() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set CRESTS=? where ID=?",
                                worker1.getCrests() * substitution1, count);
                    }
                    if (worker2.getCrests() != 0.0) {
                        crests2 = worker2.getCrests() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set CRESTS=? where ID=?",
                                worker2.getCrests() * substitution2, j);
                    }
                    if (worker1.getVog() != 0.0) {
                        vog1 = worker1.getVog() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set VOG=? where ID=?",
                                worker1.getVog() * substitution1, count);
                    }
                    if (worker2.getVog() != 0.0) {
                        vog2 = worker2.getVog() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set VOG=? where ID=?",
                                worker2.getVog() * substitution2, j);
                    }
                    if (worker1.getGlamur() != 0.0) {
                        glamur1 = worker1.getGlamur() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set GLAMUR=? where ID=?",
                                worker1.getGlamur() * substitution1, count);
                    }
                    if (worker2.getGlamur() != 0.0) {
                        glamur2 = worker2.getGlamur() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set GLAMUR=? where ID=?",
                                worker2.getGlamur() * substitution2, j);
                    }
                    if (worker1.getKiss() != 0.0) {
                        kiss1 = worker1.getKiss() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set KISS=? where ID=?",
                                worker1.getKiss() * substitution1, count);
                    }
                    if (worker2.getKiss() != 0.0) {
                        kiss2 = worker2.getKiss() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set KISS=? where ID=?",
                                worker2.getKiss() * substitution2, j);
                    }
                    if (worker1.getEsse() != 0.0) {
                        esse1 = worker1.getEsse() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set ESSE=? where ID=?",
                                worker1.getEsse() * substitution1, count);
                    }
                    if (worker2.getEsse() != 0.0) {
                        esse2 = worker2.getEsse() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set ESSE=? where ID=?",
                                worker2.getEsse() * substitution2, j);
                    }
                    if (worker1.getQuin() != 0.0) {
                        quin1 = worker1.getQuin() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set QUIN=? where ID=?",
                                worker1.getQuin() * substitution1, count);
                    }
                    if (worker2.getQuin() != 0.0) {
                        quin2 = worker2.getQuin() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set QUIN=? where ID=?",
                                worker2.getQuin() * substitution2, j);
                    }
                    if (worker1.getLady() != 0.0) {
                        lady1 = worker1.getLady() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set LADY=? where ID=?",
                                worker1.getLady() * substitution1, count);
                    }
                    if (worker2.getLady() != 0.0) {
                        lady2 = worker2.getLady() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set LADY=? where ID=?",
                                worker2.getLady() * substitution2, j);
                    }
                    if (worker1.getMor() != 0.0) {
                        mor1 = worker1.getMor() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set MOR=? where ID=?",
                                worker1.getMor() * substitution1, count);
                    }
                    if (worker2.getMor() != 0.0) {
                        mor2 = worker2.getMor() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set MOR=? where ID=?",
                                worker2.getMor() * substitution2, j);
                    }
                    if (worker1.getChester() != 0.0) {
                        chester1 = worker1.getChester() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set CHESTER=? where ID=?",
                                worker1.getChester() * substitution1, count);
                    }
                    if (worker2.getChester() != 0.0) {
                        chester2 = worker2.getChester() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set CHESTER=? where ID=?",
                                worker2.getChester() * substitution2, j);
                    }
                    if (worker1.getRadopy() != 0.0) {
                        radopy1 = worker1.getRadopy() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set RADOPY=? where ID=?",
                                worker1.getRadopy() * substitution1, count);
                    }
                    if (worker2.getRadopy() != 0.0) {
                        radopy2 = worker2.getRadopy() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set RADOPY=? where ID=?",
                                worker2.getRadopy() * substitution2, j);
                    }
                    if (worker1.getStuardessa() != 0.0) {
                        stuardessa1 = worker1.getStuardessa() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set STUARDESSA=? where ID=?",
                                worker1.getStuardessa() * substitution1, count);
                    }
                    if (worker2.getStuardessa() != 0.0) {
                        stuardessa2 = worker2.getStuardessa() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set STUARDESSA=? where ID=?",
                                worker2.getStuardessa() * substitution2, j);
                    }
                    if (worker1.getStolichniye() != 0.0) {
                        stolichniye1 = worker1.getStolichniye() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set STOLICHNIYE=? where ID=?",
                                worker1.getStolichniye() * substitution1, count);
                    }
                    if (worker2.getStolichniye() != 0.0) {
                        stolichniye2 = worker2.getStolichniye() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set STOLICHNIYE=? where ID=?",
                                worker2.getStolichniye() * substitution2, j);
                    }
                    if (worker1.getDonskoy() != 0.0) {
                        donskoy1 = worker1.getDonskoy() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set DONSKOY=? where ID=?",
                                worker1.getDonskoy() * substitution1, count);
                    }
                    if (worker2.getDonskoy() != 0.0) {
                        donskoy2 = worker2.getDonskoy() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set DONSKOY=? where ID=?",
                                worker2.getDonskoy() * substitution2, j);
                    }
                    if (worker1.getTroyka() != 0.0) {
                        troyka1 = worker1.getTroyka() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set TROYKA=? where ID=?",
                                worker1.getTroyka() * substitution1, count);
                    }
                    if (worker2.getTroyka() != 0.0) {
                        troyka2 = worker2.getTroyka() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set TROYKA=? where ID=?",
                                worker2.getTroyka() * substitution2, j);
                    }
                    if (worker1.getFast() != 0.0) {
                        fast1 = worker1.getFast() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set FAST=? where ID=?",
                                worker1.getFast() * substitution1, count);
                    }
                    if (worker2.getFast() != 0.0) {
                        fast2 = worker2.getFast() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set FAST=? where ID=?",
                                worker2.getFast() * substitution2, j);
                    }
                    if (worker1.getRoyal() != 0.0) {
                        royal1 = worker1.getRoyal() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set ROYAL=? where ID=?",
                                worker1.getRoyal() * substitution1, count);
                    }
                    if (worker2.getRoyal() != 0.0) {
                        royal2 = worker2.getRoyal() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set ROYAL=? where ID=?",
                                worker2.getRoyal() * substitution2, j);
                    }
                    if (worker1.getManchester() != 0.0) {
                        manchester1 = worker1.getManchester() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set MANCHESTER=? where ID=?",
                                worker1.getManchester() * substitution1, count);
                    }
                    if (worker2.getManchester() != 0.0) {
                        manchester2 = worker2.getManchester() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set MANCHESTER=? where ID=?",
                                worker2.getManchester() * substitution2, j);
                    }
                    if (worker1.getPrestigue() != 0.0) {
                        prestigue1 = worker1.getPrestigue() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set PRESTIGUE=? where ID=?",
                                worker1.getPrestigue() * substitution1, count);
                    }
                    if (worker2.getPrestigue() != 0.0) {
                        prestigue2 = worker2.getPrestigue() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set PRESTIGUE=? where ID=?",
                                worker2.getPrestigue() * substitution2, j);
                    }
                    if (worker1.getPremier() != 0.0) {
                        premier1 = worker1.getPremier() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set PREMIER=? where ID=?",
                                worker1.getPremier() * substitution1, count);
                    }
                    if (worker2.getPremier() != 0.0) {
                        premier2 = worker2.getPremier() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set PREMIER=? where ID=?",
                                worker2.getPremier() * substitution2, j);
                    }
                    if (worker1.getCosmos() != 0.0) {
                        cosmos1 = worker1.getCosmos() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set COSMOS=? where ID=?",
                                worker1.getCosmos() * substitution1, count);
                    }
                    if (worker2.getCosmos() != 0.0) {
                        cosmos2 = worker2.getCosmos() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set COSMOS=? where ID=?",
                                worker2.getCosmos() * substitution2, j);
                    }
                    if (worker1.getNext() != 0.0) {
                        next1 = worker1.getNext() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set NEXT=? where ID=?",
                                worker1.getNext() * substitution1, count);
                    }
                    if (worker2.getNext() != 0.0) {
                        next2 = worker2.getNext() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set NEXT=? where ID=?",
                                worker2.getNext() * substitution2, j);
                    }
                    if (worker1.getMagnat() != 0.0) {
                        magnat1 = worker1.getMagnat() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set MAGNAT=? where ID=?",
                                worker1.getMagnat() * substitution1, count);
                    }
                    if (worker2.getMagnat() != 0.0) {
                        magnat2 = worker2.getMagnat() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set MAGNAT=? where ID=?",
                                worker2.getMagnat() * substitution2, j);
                    }
                    if (worker1.getMinsk() != 0.0) {
                        minsk1 = worker1.getMinsk() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set MINSK=? where ID=?",
                                worker1.getMinsk() * substitution1, count);
                    }
                    if (worker2.getMinsk() != 0.0) {
                        minsk2 = worker2.getMinsk() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set MINSK=? where ID=?",
                                worker2.getMinsk() * substitution2, j);
                    }
                    if (worker1.getSouz() != 0.0) {
                        souz1 = worker1.getSouz() * substitution1;
                        jdbcTemplate.update("UPDATE SIGARETS set SOUZ=? where ID=?",
                                worker1.getSouz() * substitution1, count);
                    }
                    if (worker2.getSouz() != 0.0) {
                        souz2 = worker2.getSouz() * substitution2;
                        jdbcTemplate.update("UPDATE SIGARETS set SOUZ=? where ID=?",
                                worker2.getSouz() * substitution2, j);
                    }
                    double sumBond = bond1 + bond2;
                    double sumKent = kent1 + kent2;
                    double sumParlament = parlament1 + parlament2;
                    double sumWinston = winston1 + winston2;
                    double sumLm = lm1 + lm2;
                    double sumMalboro = malboro1 + malboro2;
                    double sumRotmans = rotmans1 + rotmans2;
                    double sumLd = ld1 + ld2;
                    double sumFmorris = fmorris1 + fmorris2;
                    double sumAliance = aliance1 + aliance2;
                    double sumJava = java1 + java2;
                    double sumOptima = optima1 + optima2;
                    double sumPetr = petr1 + petr2;
                    double sumMaksim = maksim1 + maksim2;
                    double sumCrests = crests1 + crests2;
                    double sumVog = vog1 + vog2;
                    double sumGlamur = glamur1 + glamur2;
                    double sumKiss = kiss1 + kiss2;
                    double sumEsse = esse1 + esse2;
                    double sumQuin = quin1 + quin2;
                    double sumLady = lady1 + lady2;
                    double sumMor = mor1 + mor2;
                    double sumChester = chester1 + chester2;
                    double sumRadopy = radopy1 + radopy2;
                    double sumStuardessa = stuardessa1 + stuardessa2;
                    double sumStolichniye = stolichniye1 + stolichniye2;
                    double sumDonskoy = donskoy1 + donskoy2;
                    double sumTroyka = troyka1 + troyka2;
                    double sumFast = fast1 + fast2;
                    double sumRoyal = royal1 + royal2;
                    double sumManchester = manchester1 + manchester2;
                    double sumPrestigue = prestigue1 + prestigue2;
                    double sumPremier = premier1 + premier2;
                    double sumCosmos = cosmos1 + cosmos2;
                    double sumNext = next1 + next2;
                    double sumMagnat = magnat1 + magnat2;
                    double sumMinsk = minsk1 + minsk2;
                    double sumSouz = souz1 + souz2;

                    double resultBond = sumBond - expenses;
                    double resultKent = sumKent - expenses;
                    double resultParlament = sumParlament - expenses;
                    double resultWinston = sumWinston - expenses;
                    double resultLm = sumLm - expenses;
                    double resultMalboro = sumMalboro - expenses;
                    double resultRotmans = sumRotmans - expenses;
                    double resultLd = sumLd - expenses;
                    double resultFmorris = sumFmorris - expenses;
                    double resultAliance = sumAliance - expenses;
                    double resultJava = sumJava - expenses;
                    double resultOptima = sumOptima - expenses;
                    double resultPetr = sumPetr - expenses;
                    double resultMaksim = sumMaksim - expenses;
                    double resultCrests = sumCrests - expenses;
                    double resultVog = sumVog - expenses;
                    double resultGlamur = sumGlamur - expenses;
                    double resultKiss = sumKiss - expenses;
                    double resultEsse = sumEsse - expenses;
                    double resultQuin = sumQuin - expenses;
                    double resultLady = sumLady - expenses;
                    double resultMor = sumMor - expenses;
                    double resultChester = sumChester - expenses;
                    double resultRadopy = sumRadopy - expenses;
                    double resultStuardessa = sumStuardessa - expenses;
                    double resultStolichniye = sumStolichniye - expenses;
                    double resultDonskoy = sumDonskoy - expenses;
                    double resultTroyka = sumTroyka - expenses;
                    double resultFast = sumFast - expenses;
                    double resultRoyal = sumRoyal - expenses;
                    double resultManchester = sumManchester - expenses;
                    double resultPrestigue = sumPrestigue - expenses;
                    double resultPremier = sumPremier - expenses;
                    double resultCosmos = sumCosmos - expenses;
                    double resultNext = sumNext - expenses;
                    double resultMagnat = sumMagnat - expenses;
                    double resultMinsk = sumMinsk - expenses;
                    double resultSouz = sumSouz - expenses;

                    double coefBond = resultBond / expenses * 100;
                    double coefKent = resultKent / expenses * 100;
                    double coefParlament = resultParlament / expenses * 100;
                    double coefWinston = resultWinston / expenses * 100;
                    double coefLm = resultLm / expenses * 100;
                    double coefMalboro = resultMalboro / expenses * 100;
                    double coefRotmans = resultRotmans / expenses * 100;
                    double coefLd = resultLd / expenses * 100;
                    double coefFmorris = resultFmorris / expenses * 100;
                    double coefAliance = resultAliance / expenses * 100;
                    double coefJava = resultJava / expenses * 100;
                    double coefOptima = resultOptima / expenses * 100;
                    double coefPetr = resultPetr / expenses * 100;
                    double coefMaksim = resultMaksim / expenses * 100;
                    double coefCrests = resultCrests / expenses * 100;
                    double coefVog = resultVog / expenses * 100;
                    double coefGlamur = resultGlamur / expenses * 100;
                    double coefKiss = resultKiss / expenses * 100;
                    double coefEsse = resultEsse / expenses * 100;
                    double coefQuin = resultQuin / expenses * 100;
                    double coefLady = resultLady / expenses * 100;
                    double coefMor = resultMor / expenses * 100;
                    double coefChester = resultChester / expenses * 100;
                    double coefRadopy = resultRadopy / expenses * 100;
                    double coefStuardessa = resultStuardessa / expenses * 100;
                    double coefStolichniye = resultStolichniye / expenses * 100;
                    double coefDonskoy = resultDonskoy / expenses * 100;
                    double coefTroyka = resultTroyka / expenses * 100;
                    double coefFast = resultFast / expenses * 100;
                    double coefRoyal = resultRoyal / expenses * 100;
                    double coefManchester = resultManchester / expenses * 100;
                    double coefPrestigue = resultPrestigue / expenses * 100;
                    double coefPremier = resultPremier / expenses * 100;
                    double coefCosmos = resultCosmos / expenses * 100;
                    double coefNext = resultNext / expenses * 100;
                    double coefMagnat = resultMagnat / expenses * 100;
                    double coefMinsk = resultMinsk / expenses * 100;
                    double coefSouz = resultSouz / expenses * 100;

                    if (coefBond >= parameters.getParameter1()) {
                        if (coefKent >= parameters.getParameter2()) {
                            if (coefParlament >= parameters.getParameter3()) {
                                if (coefWinston >= parameters.getParameter4()) {
                                    if (coefLm >= parameters.getParameter5()) {
                                        if (coefMalboro >= parameters.getParameter6()) {
                                            if (coefRotmans >= parameters.getParameter7()) {
                                                if (coefLd >= parameters.getParameter8()) {
                                                    if (coefFmorris >= parameters.getParameter9()) {
                                                        if (coefAliance >= parameters.getParameter10()) {
                                                            if (coefJava >= parameters.getParameter11()) {
                                                                if (coefOptima >= parameters.getParameter12()) {
                                                                    if (coefPetr >= parameters.getParameter13()) {
                                                                        if (coefMaksim >= parameters.getParameter14()) {
                                                                            if (coefCrests >= parameters.getParameter15()) {
                                                                                if (coefVog >= parameters.getParameter16()) {
                                                                                    if (coefGlamur >= parameters.getParameter17()) {
                                                                                        if (coefKiss >= parameters.getParameter18()) {
                                                                                            if (coefEsse >= parameters.getParameter19()) {
                                                                                                if (coefQuin >= parameters.getParameter20()) {
                                                                                                    if (coefLady >= parameters.getParameter21()) {
                                                                                                        if (coefMor >= parameters.getParameter22()) {
                                                                                                            if (coefChester >= parameters.getParameter23()) {
                                                                                                                if (coefRadopy >= parameters.getParameter24()) {
                                                                                                                    if (coefStuardessa >= parameters.getParameter25()) {
                                                                                                                        if (coefStolichniye >= parameters.getParameter26()) {
                                                                                                                            if (coefDonskoy >= parameters.getParameter27()) {
                                                                                                                                if (coefTroyka >= parameters.getParameter28()) {
                                                                                                                                    if (coefFast >= parameters.getParameter29()) {
                                                                                                                                        if (coefRoyal >= parameters.getParameter30()) {
                                                                                                                                            if (coefManchester >= parameters.getParameter31()) {
                                                                                                                                                if (coefPrestigue >= parameters.getParameter32()) {
                                                                                                                                                    if (coefPremier >= parameters.getParameter33()) {
                                                                                                                                                        if (coefCosmos >= parameters.getParameter34()) {
                                                                                                                                                            if (coefNext >= parameters.getParameter35()) {
                                                                                                                                                                if (coefMagnat >= parameters.getParameter36()) {
                                                                                                                                                                    if (coefMinsk >= parameters.getParameter37()) {
                                                                                                                                                                        if (coefSouz >= parameters.getParameter38()) {
                                                                                                                                                                            jdbcTemplate.update(SAVE_BEST_GROUP,
                                                                                                                                                                                    worker1.getWorkerId(),
                                                                                                                                                                                    worker2.getWorkerId(),
                                                                                                                                                                                    i,
                                                                                                                                                                                    sumBond,
                                                                                                                                                                                    sumKent,
                                                                                                                                                                                    sumParlament,
                                                                                                                                                                                    sumWinston,
                                                                                                                                                                                    sumLm,
                                                                                                                                                                                    sumMalboro,
                                                                                                                                                                                    sumRotmans,
                                                                                                                                                                                    sumLd,
                                                                                                                                                                                    sumFmorris,
                                                                                                                                                                                    sumAliance,
                                                                                                                                                                                    sumJava,
                                                                                                                                                                                    sumOptima,
                                                                                                                                                                                    sumPetr,
                                                                                                                                                                                    sumMaksim,
                                                                                                                                                                                    sumCrests,
                                                                                                                                                                                    sumVog,
                                                                                                                                                                                    sumGlamur,
                                                                                                                                                                                    sumKiss,
                                                                                                                                                                                    sumEsse,
                                                                                                                                                                                    sumQuin,
                                                                                                                                                                                    sumLady,
                                                                                                                                                                                    sumMor,
                                                                                                                                                                                    sumChester,
                                                                                                                                                                                    sumRadopy,
                                                                                                                                                                                    sumStuardessa,
                                                                                                                                                                                    sumStolichniye,
                                                                                                                                                                                    sumDonskoy,
                                                                                                                                                                                    sumTroyka,
                                                                                                                                                                                    sumFast,
                                                                                                                                                                                    sumRoyal,
                                                                                                                                                                                    sumManchester,
                                                                                                                                                                                    sumPrestigue,
                                                                                                                                                                                    sumPremier,
                                                                                                                                                                                    sumCosmos,
                                                                                                                                                                                    sumNext,
                                                                                                                                                                                    sumMagnat,
                                                                                                                                                                                    sumMinsk,
                                                                                                                                                                                    sumSouz,

                                                                                                                                                                                    resultBond,
                                                                                                                                                                                    resultKent,
                                                                                                                                                                                    resultParlament,
                                                                                                                                                                                    resultWinston,
                                                                                                                                                                                    resultLm,
                                                                                                                                                                                    resultMalboro,
                                                                                                                                                                                    resultRotmans,
                                                                                                                                                                                    resultLd,
                                                                                                                                                                                    resultFmorris,
                                                                                                                                                                                    resultAliance,
                                                                                                                                                                                    resultJava,
                                                                                                                                                                                    resultOptima,
                                                                                                                                                                                    resultPetr,
                                                                                                                                                                                    resultMaksim,
                                                                                                                                                                                    resultCrests,
                                                                                                                                                                                    resultVog,
                                                                                                                                                                                    resultGlamur,
                                                                                                                                                                                    resultKiss,
                                                                                                                                                                                    resultEsse,
                                                                                                                                                                                    resultQuin,
                                                                                                                                                                                    resultLady,
                                                                                                                                                                                    resultMor,
                                                                                                                                                                                    resultChester,
                                                                                                                                                                                    resultRadopy,
                                                                                                                                                                                    resultStuardessa,
                                                                                                                                                                                    resultStolichniye,
                                                                                                                                                                                    resultDonskoy,
                                                                                                                                                                                    resultTroyka,
                                                                                                                                                                                    resultFast,
                                                                                                                                                                                    resultRoyal,
                                                                                                                                                                                    resultManchester,
                                                                                                                                                                                    resultPrestigue,
                                                                                                                                                                                    resultPremier,
                                                                                                                                                                                    resultCosmos,
                                                                                                                                                                                    resultNext,
                                                                                                                                                                                    resultMagnat,
                                                                                                                                                                                    resultMinsk,
                                                                                                                                                                                    resultSouz,

                                                                                                                                                                                    coefBond,
                                                                                                                                                                                    coefKent,
                                                                                                                                                                                    coefParlament,
                                                                                                                                                                                    coefWinston,
                                                                                                                                                                                    coefLm,
                                                                                                                                                                                    coefMalboro,
                                                                                                                                                                                    coefRotmans,
                                                                                                                                                                                    coefLd,
                                                                                                                                                                                    coefFmorris,
                                                                                                                                                                                    coefAliance,
                                                                                                                                                                                    coefJava,
                                                                                                                                                                                    coefOptima,
                                                                                                                                                                                    coefPetr,
                                                                                                                                                                                    coefMaksim,
                                                                                                                                                                                    coefCrests,
                                                                                                                                                                                    coefVog,
                                                                                                                                                                                    coefGlamur,
                                                                                                                                                                                    coefKiss,
                                                                                                                                                                                    coefEsse,
                                                                                                                                                                                    coefQuin,
                                                                                                                                                                                    coefLady,
                                                                                                                                                                                    coefMor,
                                                                                                                                                                                    coefChester,
                                                                                                                                                                                    coefRadopy,
                                                                                                                                                                                    coefStuardessa,
                                                                                                                                                                                    coefStolichniye,
                                                                                                                                                                                    coefDonskoy,
                                                                                                                                                                                    coefTroyka,
                                                                                                                                                                                    coefFast,
                                                                                                                                                                                    coefRoyal,
                                                                                                                                                                                    coefManchester,
                                                                                                                                                                                    coefPrestigue,
                                                                                                                                                                                    coefPremier,
                                                                                                                                                                                    coefCosmos,
                                                                                                                                                                                    coefNext,
                                                                                                                                                                                    coefMagnat,
                                                                                                                                                                                    coefMinsk,
                                                                                                                                                                                    coefSouz
                                                                                                                                                                            );
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }

                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
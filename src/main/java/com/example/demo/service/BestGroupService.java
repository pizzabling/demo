package com.example.demo.service;

import com.example.demo.domain.bestGroup.*;
import com.example.demo.repo.GroupRepo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BestGroupService {
    private final JdbcTemplate jdbcTemplate;
    private final SigaretsService sigaretsService;
    private final com.example.demo.service.Service service;
    private final ParamsService paramsService;
    private final GroupRepo repo;

    public BestGroupService(JdbcTemplate jdbcTemplate, SigaretsService sigaretsService, com.example.demo.service.Service service, ParamsService paramsService, GroupRepo repo) {
        this.jdbcTemplate = jdbcTemplate;
        this.sigaretsService = sigaretsService;
        this.service = service;
        this.paramsService = paramsService;
        this.repo = repo;
    }

    private static final String SAVE_BEST_GROUP2 = "INSERT INTO SIGARETSRESULT2(firstId, secondId,OKLADFIRST,OKLADSECOND, sumBond, sumKent, sumParlament, sumWinston, sumLm, sumMalboro, sumRotmans, sumLd, sumFmorris, sumAliance, sumJava, sumOptima, sumPetr, sumMaksim, sumCrests, sumVog, sumGlamur, sumKiss, sumEsse, sumQuin, sumLady, sumMor, sumChester, sumRadopy, sumStuardessa, sumStolichniye, sumDonskoy, sumTroyka, sumFast, sumRoyal, sumManchester, sumPrestigue, sumPremier, sumCosmos, sumNext, sumMagnat, sumMinsk, sumSouz,\n" +
            "resultBond, resultKent, resultParlament, resultWinston, resultLm, resultMalboro, resultRotmans, resultLd, resultFmorris, resultAliance, resultJava, resultOptima, resultPetr, resultMaksim, resultCrests, resultVog, resultGlamur, resultKiss, resultEsse, resultQuin, resultLady, resultMor, resultChester, resultRadopy, resultStuardessa, resultStolichniye, resultDonskoy, resultTroyka, resultFast, resultRoyal,  resultManchester,resultPrestigue, resultPremier, resultCosmos, resultNext, resultMagnat, " +
            "resultMinsk, resultSouz, coefBond, coefKent, coefParlament, coefWinston, coefLm, coefMalboro, coefRotmans, coefLd, coefFmorris, coefAliance, coefJava, coefOptima, coefPetr, coefMaksim, coefCrests, coefVog, coefGlamur, coefKiss, coefEsse, coefQuin, coefLady, coefMor, coefChester, coefRadopy, coefStuardessa, coefStolichniye, coefDonskoy, coefTroyka, coefFast, coefRoyal, coefManchester, coefPrestigue, coefPremier, coefCosmos, coefNext, coefMagnat, coefMinsk, coefSouz)" +
            "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";
    private static final String SAVE_BEST_GROUP3 = "INSERT INTO SIGARETSRESULT3 (firstId, secondId,thirdid,OKLADFIRST,OKLADSECOND,okladThird, sumBond, sumKent, sumParlament, sumWinston, sumLm, sumMalboro, sumRotmans, sumLd, sumFmorris, sumAliance, sumJava, sumOptima, sumPetr, sumMaksim, sumCrests, sumVog, sumGlamur, sumKiss, sumEsse, sumQuin, sumLady, sumMor, sumChester, sumRadopy, sumStuardessa, sumStolichniye, sumDonskoy, sumTroyka, sumFast, sumRoyal, sumManchester, sumPrestigue, sumPremier, sumCosmos, sumNext, sumMagnat, sumMinsk, sumSouz,\n" +
            "resultBond, resultKent, resultParlament, resultWinston, resultLm, resultMalboro, resultRotmans, resultLd, resultFmorris, resultAliance, resultJava, resultOptima, resultPetr, resultMaksim, resultCrests, resultVog, resultGlamur, resultKiss, resultEsse, resultQuin, resultLady, resultMor, resultChester, resultRadopy, resultStuardessa, resultStolichniye, resultDonskoy, resultTroyka, resultFast, resultRoyal,  resultManchester,resultPrestigue, resultPremier, resultCosmos, resultNext, resultMagnat, " +
            "resultMinsk, resultSouz, coefBond, coefKent, coefParlament, coefWinston, coefLm, coefMalboro, coefRotmans, coefLd, coefFmorris, coefAliance, coefJava, coefOptima, coefPetr, coefMaksim, coefCrests, coefVog, coefGlamur, coefKiss, coefEsse, coefQuin, coefLady, coefMor, coefChester, coefRadopy, coefStuardessa, coefStolichniye, coefDonskoy, coefTroyka, coefFast, coefRoyal, coefManchester, coefPrestigue, coefPremier, coefCosmos, coefNext, coefMagnat, coefMinsk, coefSouz)" +
            "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";
    private static final String SAVE_BEST_GROUP4 = "INSERT INTO SIGARETSRESULT4 (firstId, secondId,thirdid,fourthId,OKLADFIRST,OKLADSECOND,okladThird, okladFourth, sumBond, sumKent, sumParlament, sumWinston, sumLm, sumMalboro, sumRotmans, sumLd, sumFmorris, sumAliance, sumJava, sumOptima, sumPetr, sumMaksim, sumCrests, sumVog, sumGlamur, sumKiss, sumEsse, sumQuin, sumLady, sumMor, sumChester, sumRadopy, sumStuardessa, sumStolichniye, sumDonskoy, sumTroyka, sumFast, sumRoyal, sumManchester, sumPrestigue, sumPremier, sumCosmos, sumNext, sumMagnat, sumMinsk, sumSouz,\n" +
            "resultBond, resultKent, resultParlament, resultWinston, resultLm, resultMalboro, resultRotmans, resultLd, resultFmorris, resultAliance, resultJava, resultOptima, resultPetr, resultMaksim, resultCrests, resultVog, resultGlamur, resultKiss, resultEsse, resultQuin, resultLady, resultMor, resultChester, resultRadopy, resultStuardessa, resultStolichniye, resultDonskoy, resultTroyka, resultFast, resultRoyal,  resultManchester,resultPrestigue, resultPremier, resultCosmos, resultNext, resultMagnat, " +
            "resultMinsk, resultSouz, coefBond, coefKent, coefParlament, coefWinston, coefLm, coefMalboro, coefRotmans, coefLd, coefFmorris, coefAliance, coefJava, coefOptima, coefPetr, coefMaksim, coefCrests, coefVog, coefGlamur, coefKiss, coefEsse, coefQuin, coefLady, coefMor, coefChester, coefRadopy, coefStuardessa, coefStolichniye, coefDonskoy, coefTroyka, coefFast, coefRoyal, coefManchester, coefPrestigue, coefPremier, coefCosmos, coefNext, coefMagnat, coefMinsk, coefSouz)" +
            "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";
    private static final String SAVE_BEST_GROUP5 = "INSERT INTO SIGARETSRESULT5 (firstId, secondId,thirdid,fourthId,fifthId, OKLADFIRST,OKLADSECOND,okladThird, okladFourth, okladFifth, sumBond, sumKent, sumParlament, sumWinston, sumLm, sumMalboro, sumRotmans, sumLd, sumFmorris, sumAliance, sumJava, sumOptima, sumPetr, sumMaksim, sumCrests, sumVog, sumGlamur, sumKiss, sumEsse, sumQuin, sumLady, sumMor, sumChester, sumRadopy, sumStuardessa, sumStolichniye, sumDonskoy, sumTroyka, sumFast, sumRoyal, sumManchester, sumPrestigue, sumPremier, sumCosmos, sumNext, sumMagnat, sumMinsk, sumSouz,\n" +
            "resultBond, resultKent, resultParlament, resultWinston, resultLm, resultMalboro, resultRotmans, resultLd, resultFmorris, resultAliance, resultJava, resultOptima, resultPetr, resultMaksim, resultCrests, resultVog, resultGlamur, resultKiss, resultEsse, resultQuin, resultLady, resultMor, resultChester, resultRadopy, resultStuardessa, resultStolichniye, resultDonskoy, resultTroyka, resultFast, resultRoyal,  resultManchester,resultPrestigue, resultPremier, resultCosmos, resultNext, resultMagnat, " +
            "resultMinsk, resultSouz, coefBond, coefKent, coefParlament, coefWinston, coefLm, coefMalboro, coefRotmans, coefLd, coefFmorris, coefAliance, coefJava, coefOptima, coefPetr, coefMaksim, coefCrests, coefVog, coefGlamur, coefKiss, coefEsse, coefQuin, coefLady, coefMor, coefChester, coefRadopy, coefStuardessa, coefStolichniye, coefDonskoy, coefTroyka, coefFast, coefRoyal, coefManchester, coefPrestigue, coefPremier, coefCosmos, coefNext, coefMagnat, coefMinsk, coefSouz)" +
            "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";
    private static final String SAVE_BEST_GROUP6 = "INSERT INTO SIGARETSRESULT6 (firstId, secondId,thirdid,fourthId,fifthId, sixthId, OKLADFIRST,OKLADSECOND,okladThird, okladFourth, okladFifth, okladSixth, sumBond, sumKent, sumParlament, sumWinston, sumLm, sumMalboro, sumRotmans, sumLd, sumFmorris, sumAliance, sumJava, sumOptima, sumPetr, sumMaksim, sumCrests, sumVog, sumGlamur, sumKiss, sumEsse, sumQuin, sumLady, sumMor, sumChester, sumRadopy, sumStuardessa, sumStolichniye, sumDonskoy, sumTroyka, sumFast, sumRoyal, sumManchester, sumPrestigue, sumPremier, sumCosmos, sumNext, sumMagnat, sumMinsk, sumSouz,\n" +
            "resultBond, resultKent, resultParlament, resultWinston, resultLm, resultMalboro, resultRotmans, resultLd, resultFmorris, resultAliance, resultJava, resultOptima, resultPetr, resultMaksim, resultCrests, resultVog, resultGlamur, resultKiss, resultEsse, resultQuin, resultLady, resultMor, resultChester, resultRadopy, resultStuardessa, resultStolichniye, resultDonskoy, resultTroyka, resultFast, resultRoyal,  resultManchester,resultPrestigue, resultPremier, resultCosmos, resultNext, resultMagnat, " +
            "resultMinsk, resultSouz, coefBond, coefKent, coefParlament, coefWinston, coefLm, coefMalboro, coefRotmans, coefLd, coefFmorris, coefAliance, coefJava, coefOptima, coefPetr, coefMaksim, coefCrests, coefVog, coefGlamur, coefKiss, coefEsse, coefQuin, coefLady, coefMor, coefChester, coefRadopy, coefStuardessa, coefStolichniye, coefDonskoy, coefTroyka, coefFast, coefRoyal, coefManchester, coefPrestigue, coefPremier, coefCosmos, coefNext, coefMagnat, coefMinsk, coefSouz)" +
            "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";
    private static final String SAVE_BEST_GROUP7 = "INSERT INTO SIGARETSRESULT7 (firstId, secondId,thirdid,fourthId,fifthId, sixthId,seventhId, OKLADFIRST,OKLADSECOND,okladThird, okladFourth, okladFifth, okladSixth, okladSeventh, sumBond, sumKent, sumParlament, sumWinston, sumLm, sumMalboro, sumRotmans, sumLd, sumFmorris, sumAliance, sumJava, sumOptima, sumPetr, sumMaksim, sumCrests, sumVog, sumGlamur, sumKiss, sumEsse, sumQuin, sumLady, sumMor, sumChester, sumRadopy, sumStuardessa, sumStolichniye, sumDonskoy, sumTroyka, sumFast, sumRoyal, sumManchester, sumPrestigue, sumPremier, sumCosmos, sumNext, sumMagnat, sumMinsk, sumSouz,\n" +
            "resultBond, resultKent, resultParlament, resultWinston, resultLm, resultMalboro, resultRotmans, resultLd, resultFmorris, resultAliance, resultJava, resultOptima, resultPetr, resultMaksim, resultCrests, resultVog, resultGlamur, resultKiss, resultEsse, resultQuin, resultLady, resultMor, resultChester, resultRadopy, resultStuardessa, resultStolichniye, resultDonskoy, resultTroyka, resultFast, resultRoyal,  resultManchester,resultPrestigue, resultPremier, resultCosmos, resultNext, resultMagnat, " +
            "resultMinsk, resultSouz, coefBond, coefKent, coefParlament, coefWinston, coefLm, coefMalboro, coefRotmans, coefLd, coefFmorris, coefAliance, coefJava, coefOptima, coefPetr, coefMaksim, coefCrests, coefVog, coefGlamur, coefKiss, coefEsse, coefQuin, coefLady, coefMor, coefChester, coefRadopy, coefStuardessa, coefStolichniye, coefDonskoy, coefTroyka, coefFast, coefRoyal, coefManchester, coefPrestigue, coefPremier, coefCosmos, coefNext, coefMagnat, coefMinsk, coefSouz)" +
            "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";
    private static final String SAVE_BEST_GROUP8 = "INSERT INTO SIGARETSRESULT8 (firstId, secondId,thirdid,fourthId,fifthId, sixthId,seventhId, eigthtId, OKLADFIRST,OKLADSECOND,okladThird, okladFourth, okladFifth, okladSixth, okladSeventh, OKLADEIGTHT, sumBond, sumKent, sumParlament, sumWinston, sumLm, sumMalboro, sumRotmans, sumLd, sumFmorris, sumAliance, sumJava, sumOptima, sumPetr, sumMaksim, sumCrests, sumVog, sumGlamur, sumKiss, sumEsse, sumQuin, sumLady, sumMor, sumChester, sumRadopy, sumStuardessa, sumStolichniye, sumDonskoy, sumTroyka, sumFast, sumRoyal, sumManchester, sumPrestigue, sumPremier, sumCosmos, sumNext, sumMagnat, sumMinsk, sumSouz,\n" +
            "resultBond, resultKent, resultParlament, resultWinston, resultLm, resultMalboro, resultRotmans, resultLd, resultFmorris, resultAliance, resultJava, resultOptima, resultPetr, resultMaksim, resultCrests, resultVog, resultGlamur, resultKiss, resultEsse, resultQuin, resultLady, resultMor, resultChester, resultRadopy, resultStuardessa, resultStolichniye, resultDonskoy, resultTroyka, resultFast, resultRoyal,  resultManchester,resultPrestigue, resultPremier, resultCosmos, resultNext, resultMagnat, " +
            "resultMinsk, resultSouz, coefBond, coefKent, coefParlament, coefWinston, coefLm, coefMalboro, coefRotmans, coefLd, coefFmorris, coefAliance, coefJava, coefOptima, coefPetr, coefMaksim, coefCrests, coefVog, coefGlamur, coefKiss, coefEsse, coefQuin, coefLady, coefMor, coefChester, coefRadopy, coefStuardessa, coefStolichniye, coefDonskoy, coefTroyka, coefFast, coefRoyal, coefManchester, coefPrestigue, coefPremier, coefCosmos, coefNext, coefMagnat, coefMinsk, coefSouz)" +
            "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";
    private static final String UPDATE_TEMPSIGARETS = "UPDATE TemporaryResultForSigarets set bond=?,kent=?,parlament=?,winston=?,lm=?,malboro=?,rotmans=?,ld=?,fmorris=?,aliance=?,java=?,optima=?,petr=?,maksim=?,crests=?,vog=?,glamur=?,kiss=?,esse=?,quin=?,lady=?,mor=?,chester=?,radopy=?,stuardessa=?,stolichniye=?,donskoy=?,troyka=?,fast=?,royal=?,manchester=?,prestigue=?,premier=?,cosmos=?,next=?,magnat=?,minsk=?,souz=? where id=?";

    public void getTiming() {
        Date date = new Date();
        System.out.println("Рассчёт окончен в: "+date.toString());
    }

    public List<ResultSigarets2> getBestGroup2() {
        return repo.getBestGroups2();
    }
    public List<ResultSigarets3> getBestGroup3() {
        return repo.getBestGroup3();
    }
    public List<ResultSigarets4> getBestGroup4() {
        return repo.getBestGroup4();
    }
    public List<ResultSigarets5> getBestGroup5() {
        return repo.getBestGroup5();
    }
    public List<ResultSigarets6> getBestGroup6() {
        return repo.getBestGroup6();
    }
    public List<ResultSigarets7> getBestGroup7() {
        return repo.getBestGroup7();
    }
    public List<ResultSigarets8> getBestGroup8() {
        return repo.getBestGroup8();
    }


    public void saveBestGroup2() {
        Date date = new Date();
        System.out.println("Рассчёт группы из 2 начат в: " + date.toString());
        var parameters = paramsService.findParamsById(1);
        double bond1;
        double bond2;
        double kent1;
        double kent2;
        double winston1;
        double winston2;
        double parlament1;
        double parlament2;
        double lm1;
        double lm2;
        double malboro1;
        double malboro2;
        double rotmans1;
        double rotmans2;
        double ld1;
        double ld2;
        double fmorris1;
        double fmorris2;
        double aliance1;
        double aliance2;
        double java1;
        double java2;
        double optima1;
        double optima2;
        double petr1;
        double petr2;
        double maksim1;
        double maksim2;
        double crests1;
        double crests2;
        double vog1;
        double vog2;
        double glamur1;
        double glamur2;
        double esse1;
        double esse2;
        double kiss1;
        double kiss2;
        double quin1;
        double quin2;
        double lady1;
        double lady2;
        double mor1;
        double mor2;
        double chester1;
        double chester2;
        double radopy1;
        double radopy2;
        double stuardessa1;
        double stuardessa2;
        double stolichniye1;
        double stolichniye2;
        double donskoy1;
        double donskoy2;
        double troyka1;
        double troyka2;
        double fast1;
        double fast2;
        double royal1;
        double royal2;
        double manchester1;
        double manchester2;
        double prestigue1;
        double prestigue2;
        double premier1;
        double premier2;
        double cosmos1;
        double cosmos2;
        double next1;
        double next2;
        double magnat1;
        double magnat2;
        double minsk1;
        double minsk2;
        double souz1;
        double souz2;

        double firstCoef;
        double secondCoef;
        double rentRatio1;
        double rentRatio2;
        double substitution1;
        double substitution2;
        double expenses;
        int count1;
        int i = 1;
        int count2;
        int j = 2;
        //Первый сотрудник
        for (count1 = i; count1 < 100; count1++) {
            var worker1 = service.findWorkerById(count1);
            var sigarets1 = sigaretsService.getSigaretsById(count1);
            //Второй сотрудник
            for (count2 = j; count2 < 100; count2++) {
                var worker2 = service.findWorkerById(count2);
                var sigarets2 = sigaretsService.getSigaretsById(count2);
                //Процент оклада первого
                for (firstCoef = 1; firstCoef < 201; firstCoef++) {
                    rentRatio1 = worker1.getRatio() * worker1.getRent();
                    substitution1 = rentRatio1 * firstCoef / 100;

                    bond1 = sigarets1.getBond() * substitution1;
                    kent1 = sigarets1.getKent() * substitution1;
                    parlament1 = sigarets1.getParlament() * substitution1;
                    winston1 = sigarets1.getWinston() * substitution1;
                    lm1 = sigarets1.getLm() * substitution1;
                    malboro1 = sigarets1.getMalboro() * substitution1;
                    rotmans1 = sigarets1.getRotmans() * substitution1;
                    ld1 = sigarets1.getLd() * substitution1;
                    fmorris1 = sigarets1.getFmorris() * substitution1;
                    aliance1 = sigarets1.getAliance() * substitution1;
                    java1 = sigarets1.getJava() * substitution1;
                    optima1 = sigarets1.getOptima() * substitution1;
                    petr1 = sigarets1.getPetr() * substitution1;
                    maksim1 = sigarets1.getMaksim() * substitution1;
                    crests1 = sigarets1.getCrests() * substitution1;
                    vog1 = sigarets1.getVog() * substitution1;
                    glamur1 = sigarets1.getGlamur() * substitution1;
                    kiss1 = sigarets1.getKiss() * substitution1;
                    esse1 = sigarets1.getEsse() * substitution1;
                    quin1 = sigarets1.getQuin() * substitution1;
                    lady1 = sigarets1.getLady() * substitution1;
                    mor1 = sigarets1.getMor() * substitution1;
                    chester1 = sigarets1.getChester() * substitution1;
                    radopy1 = sigarets1.getRadopy() * substitution1;
                    stuardessa1 = sigarets1.getStuardessa() * substitution1;
                    stolichniye1 = sigarets1.getStolichniye() * substitution1;
                    donskoy1 = sigarets1.getDonskoy() * substitution1;
                    troyka1 = sigarets1.getTroyka() * substitution1;
                    fast1 = sigarets1.getFast() * substitution1;
                    royal1 = sigarets1.getRoyal() * substitution1;
                    manchester1 = sigarets1.getManchester() * substitution1;
                    prestigue1 = sigarets1.getPrestigue() * substitution1;
                    premier1 = sigarets1.getPremier() * substitution1;
                    cosmos1 = sigarets1.getCosmos() * substitution1;
                    next1 = sigarets1.getNext() * substitution1;
                    magnat1 = sigarets1.getMagnat() * substitution1;
                    minsk1 = sigarets1.getMinsk() * substitution1;
                    souz1 = sigarets1.getSouz() * substitution1;
                    jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                            bond1, kent1, parlament1, winston1, lm1, malboro1, rotmans1,
                            ld1, fmorris1, aliance1, java1, optima1, petr1, maksim1, crests1,
                            vog1, glamur1, kiss1, esse1, quin1, lady1, mor1, chester1, radopy1,
                            stuardessa1, stolichniye1, donskoy1, troyka1, fast1, royal1, manchester1,
                            prestigue1, premier1, cosmos1, next1, magnat1, minsk1, souz1, count1);
                    //Процент оклада второго
                    for (secondCoef = 1; secondCoef < 201; secondCoef++) {
                        rentRatio2 = worker2.getRatio() * worker2.getRent();
                        substitution2 = rentRatio2 * secondCoef / 100;
                        expenses = substitution1 + substitution2;

                        bond2 = sigarets2.getBond() * substitution2;
                        kent2 = sigarets2.getKent() * substitution2;
                        parlament2 = sigarets2.getParlament() * substitution2;
                        winston2 = sigarets2.getWinston() * substitution2;
                        lm2 = sigarets2.getLm() * substitution2;
                        malboro2 = sigarets2.getMalboro() * substitution2;
                        rotmans2 = sigarets2.getRotmans() * substitution2;
                        ld2 = sigarets2.getLd() * substitution2;
                        fmorris2 = sigarets2.getFmorris() * substitution2;
                        aliance2 = sigarets2.getAliance() * substitution2;
                        java2 = sigarets2.getJava() * substitution2;
                        optima2 = sigarets2.getOptima() * substitution2;
                        petr2 = sigarets2.getPetr() * substitution2;
                        maksim2 = sigarets2.getMaksim() * substitution2;
                        crests2 = sigarets2.getCrests() * substitution2;
                        vog2 = sigarets2.getVog() * substitution2;
                        glamur2 = sigarets2.getGlamur() * substitution2;
                        kiss2 = sigarets2.getKiss() * substitution2;
                        esse2 = sigarets2.getEsse() * substitution2;
                        quin2 = sigarets2.getQuin() * substitution2;
                        lady2 = sigarets2.getLady() * substitution2;
                        mor2 = sigarets2.getMor() * substitution2;
                        chester2 = sigarets2.getChester() * substitution2;
                        radopy2 = sigarets2.getRadopy() * substitution2;
                        stuardessa2 = sigarets2.getStuardessa() * substitution2;
                        stolichniye2 = sigarets2.getStolichniye() * substitution2;
                        donskoy2 = sigarets2.getDonskoy() * substitution2;
                        troyka2 = sigarets2.getTroyka() * substitution2;
                        fast2 = sigarets2.getFast() * substitution2;
                        royal2 = sigarets2.getRoyal() * substitution2;
                        manchester2 = sigarets2.getManchester() * substitution2;
                        prestigue2 = sigarets2.getPrestigue() * substitution2;
                        premier2 = sigarets2.getPremier() * substitution2;
                        cosmos2 = sigarets2.getCosmos() * substitution2;
                        next2 = sigarets2.getNext() * substitution2;
                        magnat2 = sigarets2.getMagnat() * substitution2;
                        minsk2 = sigarets2.getMinsk() * substitution2;
                        souz2 = sigarets2.getSouz() * substitution2;
                        jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                bond2, kent2, parlament2, winston2, lm2, malboro2, rotmans2,
                                ld2, fmorris2, aliance2, java2, optima2, petr2, maksim2, crests2,
                                vog2, glamur2, kiss2, esse2, quin2, lady2, mor2, chester2, radopy2,
                                stuardessa2, stolichniye2, donskoy2, troyka2, fast2, royal2, manchester2,
                                prestigue2, premier2, cosmos2, next2, magnat2, minsk2, souz2, count2);

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

                        double expenses100 = expenses * 100;

                        double coefBond = resultBond / expenses100;
                        double coefKent = resultKent / expenses100;
                        double coefParlament = resultParlament / expenses100;
                        double coefWinston = resultWinston / expenses100;
                        double coefLm = resultLm / expenses100;
                        double coefMalboro = resultMalboro / expenses100;
                        double coefRotmans = resultRotmans / expenses100;
                        double coefLd = resultLd / expenses100;
                        double coefFmorris = resultFmorris / expenses100;
                        double coefAliance = resultAliance / expenses100;
                        double coefJava = resultJava / expenses100;
                        double coefOptima = resultOptima / expenses100;
                        double coefPetr = resultPetr / expenses100;
                        double coefMaksim = resultMaksim / expenses100;
                        double coefCrests = resultCrests / expenses100;
                        double coefVog = resultVog / expenses100;
                        double coefGlamur = resultGlamur / expenses100;
                        double coefKiss = resultKiss / expenses100;
                        double coefEsse = resultEsse / expenses100;
                        double coefQuin = resultQuin / expenses100;
                        double coefLady = resultLady / expenses100;
                        double coefMor = resultMor / expenses100;
                        double coefChester = resultChester / expenses100;
                        double coefRadopy = resultRadopy / expenses100;
                        double coefStuardessa = resultStuardessa / expenses100;
                        double coefStolichniye = resultStolichniye / expenses100;
                        double coefDonskoy = resultDonskoy / expenses100;
                        double coefTroyka = resultTroyka / expenses100;
                        double coefFast = resultFast / expenses100;
                        double coefRoyal = resultRoyal / expenses100;
                        double coefManchester = resultManchester / expenses100;
                        double coefPrestigue = resultPrestigue / expenses100;
                        double coefPremier = resultPremier / expenses100;
                        double coefCosmos = resultCosmos / expenses100;
                        double coefNext = resultNext / expenses100;
                        double coefMagnat = resultMagnat / expenses100;
                        double coefMinsk = resultMinsk / expenses100;
                        double coefSouz = resultSouz / expenses100;

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
                                                                                                                                                                                jdbcTemplate.update(SAVE_BEST_GROUP2,
                                                                                                                                                                                        worker1.getWorkerId(),
                                                                                                                                                                                        worker2.getWorkerId(),
                                                                                                                                                                                        firstCoef,
                                                                                                                                                                                        secondCoef,
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
            i++;
            j++;
        }
        getTiming();
    }

    public void saveBestGroup3() {
        Date date = new Date();
        System.out.println("Рассчёт группы из 3" + date.toString());
        var parameters = paramsService.findParamsById(1);
        double bond1;
        double bond2;
        double bond3;
        double kent1;
        double kent2;
        double kent3;
        double winston1;
        double winston2;
        double winston3;
        double parlament1;
        double parlament2;
        double parlament3;
        double lm1;
        double lm2;
        double lm3;
        double malboro1;
        double malboro2;
        double malboro3;
        double rotmans1;
        double rotmans2;
        double rotmans3;
        double ld1;
        double ld2;
        double ld3;
        double fmorris1;
        double fmorris2;
        double fmorris3;
        double aliance1;
        double aliance2;
        double aliance3;
        double java1;
        double java2;
        double java3;
        double optima1;
        double optima2;
        double optima3;
        double petr1;
        double petr2;
        double petr3;
        double maksim1;
        double maksim2;
        double maksim3;
        double crests1;
        double crests2;
        double crests3;
        double vog1;
        double vog2;
        double vog3;
        double glamur1;
        double glamur2;
        double glamur3;
        double esse1;
        double esse2;
        double esse3;
        double kiss1;
        double kiss2;
        double kiss3;
        double quin1;
        double quin2;
        double quin3;
        double lady1;
        double lady2;
        double lady3;
        double mor1;
        double mor2;
        double mor3;
        double chester1;
        double chester2;
        double chester3;
        double radopy1;
        double radopy2;
        double radopy3;
        double stuardessa1;
        double stuardessa2;
        double stuardessa3;
        double stolichniye1;
        double stolichniye2;
        double stolichniye3;
        double donskoy1;
        double donskoy2;
        double donskoy3;
        double troyka1;
        double troyka2;
        double troyka3;
        double fast1;
        double fast2;
        double fast3;
        double royal1;
        double royal2;
        double royal3;
        double manchester1;
        double manchester2;
        double manchester3;
        double prestigue1;
        double prestigue2;
        double prestigue3;
        double premier1;
        double premier2;
        double premier3;
        double cosmos1;
        double cosmos2;
        double cosmos3;
        double next1;
        double next2;
        double next3;
        double magnat1;
        double magnat2;
        double magnat3;
        double minsk1;
        double minsk2;
        double minsk3;
        double souz1;
        double souz2;
        double souz3;

        double firstCoef;
        double secondCoef;
        double thirdCoef;
        double rentRatio1;
        double rentRatio2;
        double rentRatio3;
        double substitution1;
        double substitution2;
        double substitution3;
        double expenses;
        int count1;
        int i = 1;
        int count2;
        int j = 2;
        int count3;
        int k = 3;
        //Первый сотрудник
        for (count1 = i; count1 < 50; count1++) {
            var worker1 = service.findWorkerById(count1);
            var sigarets1 = sigaretsService.getSigaretsById(count1);
            //Второй сотрудник
            for (count2 = j; count2 < 50; count2++) {
                var worker2 = service.findWorkerById(count2);
                var sigarets2 = sigaretsService.getSigaretsById(count2);
                //Процент оклада первого
                for (count3 = k; count3 < 50; count3++) {
                    var worker3 = service.findWorkerById(count3);
                    var sigarets3 = sigaretsService.getSigaretsById(count3);

                    for (firstCoef = 1; firstCoef < 201; firstCoef++) {
                        rentRatio1 = worker1.getRatio() * worker1.getRent();
                        substitution1 = rentRatio1 * firstCoef / 100;

                        bond1 = sigarets1.getBond() * substitution1;
                        kent1 = sigarets1.getKent() * substitution1;
                        parlament1 = sigarets1.getParlament() * substitution1;
                        winston1 = sigarets1.getWinston() * substitution1;
                        lm1 = sigarets1.getLm() * substitution1;
                        malboro1 = sigarets1.getMalboro() * substitution1;
                        rotmans1 = sigarets1.getRotmans() * substitution1;
                        ld1 = sigarets1.getLd() * substitution1;
                        fmorris1 = sigarets1.getFmorris() * substitution1;
                        aliance1 = sigarets1.getAliance() * substitution1;
                        java1 = sigarets1.getJava() * substitution1;
                        optima1 = sigarets1.getOptima() * substitution1;
                        petr1 = sigarets1.getPetr() * substitution1;
                        maksim1 = sigarets1.getMaksim() * substitution1;
                        crests1 = sigarets1.getCrests() * substitution1;
                        vog1 = sigarets1.getVog() * substitution1;
                        glamur1 = sigarets1.getGlamur() * substitution1;
                        kiss1 = sigarets1.getKiss() * substitution1;
                        esse1 = sigarets1.getEsse() * substitution1;
                        quin1 = sigarets1.getQuin() * substitution1;
                        lady1 = sigarets1.getLady() * substitution1;
                        mor1 = sigarets1.getMor() * substitution1;
                        chester1 = sigarets1.getChester() * substitution1;
                        radopy1 = sigarets1.getRadopy() * substitution1;
                        stuardessa1 = sigarets1.getStuardessa() * substitution1;
                        stolichniye1 = sigarets1.getStolichniye() * substitution1;
                        donskoy1 = sigarets1.getDonskoy() * substitution1;
                        troyka1 = sigarets1.getTroyka() * substitution1;
                        fast1 = sigarets1.getFast() * substitution1;
                        royal1 = sigarets1.getRoyal() * substitution1;
                        manchester1 = sigarets1.getManchester() * substitution1;
                        prestigue1 = sigarets1.getPrestigue() * substitution1;
                        premier1 = sigarets1.getPremier() * substitution1;
                        cosmos1 = sigarets1.getCosmos() * substitution1;
                        next1 = sigarets1.getNext() * substitution1;
                        magnat1 = sigarets1.getMagnat() * substitution1;
                        minsk1 = sigarets1.getMinsk() * substitution1;
                        souz1 = sigarets1.getSouz() * substitution1;
                        jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                bond1, kent1, parlament1, winston1, lm1, malboro1, rotmans1,
                                ld1, fmorris1, aliance1, java1, optima1, petr1, maksim1, crests1,
                                vog1, glamur1, kiss1, esse1, quin1, lady1, mor1, chester1, radopy1,
                                stuardessa1, stolichniye1, donskoy1, troyka1, fast1, royal1, manchester1,
                                prestigue1, premier1, cosmos1, next1, magnat1, minsk1, souz1, count1);
                        //Процент оклада второго
                        for (secondCoef = 1; secondCoef < 201; secondCoef++) {
                            rentRatio2 = worker2.getRatio() * worker2.getRent();
                            substitution2 = rentRatio2 * secondCoef / 100;


                            bond2 = sigarets2.getBond() * substitution2;
                            kent2 = sigarets2.getKent() * substitution2;
                            parlament2 = sigarets2.getParlament() * substitution2;
                            winston2 = sigarets2.getWinston() * substitution2;
                            lm2 = sigarets2.getLm() * substitution2;
                            malboro2 = sigarets2.getMalboro() * substitution2;
                            rotmans2 = sigarets2.getRotmans() * substitution2;
                            ld2 = sigarets2.getLd() * substitution2;
                            fmorris2 = sigarets2.getFmorris() * substitution2;
                            aliance2 = sigarets2.getAliance() * substitution2;
                            java2 = sigarets2.getJava() * substitution2;
                            optima2 = sigarets2.getOptima() * substitution2;
                            petr2 = sigarets2.getPetr() * substitution2;
                            maksim2 = sigarets2.getMaksim() * substitution2;
                            crests2 = sigarets2.getCrests() * substitution2;
                            vog2 = sigarets2.getVog() * substitution2;
                            glamur2 = sigarets2.getGlamur() * substitution2;
                            kiss2 = sigarets2.getKiss() * substitution2;
                            esse2 = sigarets2.getEsse() * substitution2;
                            quin2 = sigarets2.getQuin() * substitution2;
                            lady2 = sigarets2.getLady() * substitution2;
                            mor2 = sigarets2.getMor() * substitution2;
                            chester2 = sigarets2.getChester() * substitution2;
                            radopy2 = sigarets2.getRadopy() * substitution2;
                            stuardessa2 = sigarets2.getStuardessa() * substitution2;
                            stolichniye2 = sigarets2.getStolichniye() * substitution2;
                            donskoy2 = sigarets2.getDonskoy() * substitution2;
                            troyka2 = sigarets2.getTroyka() * substitution2;
                            fast2 = sigarets2.getFast() * substitution2;
                            royal2 = sigarets2.getRoyal() * substitution2;
                            manchester2 = sigarets2.getManchester() * substitution2;
                            prestigue2 = sigarets2.getPrestigue() * substitution2;
                            premier2 = sigarets2.getPremier() * substitution2;
                            cosmos2 = sigarets2.getCosmos() * substitution2;
                            next2 = sigarets2.getNext() * substitution2;
                            magnat2 = sigarets2.getMagnat() * substitution2;
                            minsk2 = sigarets2.getMinsk() * substitution2;
                            souz2 = sigarets2.getSouz() * substitution2;
                            jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                    bond2, kent2, parlament2, winston2, lm2, malboro2, rotmans2,
                                    ld2, fmorris2, aliance2, java2, optima2, petr2, maksim2, crests2,
                                    vog2, glamur2, kiss2, esse2, quin2, lady2, mor2, chester2, radopy2,
                                    stuardessa2, stolichniye2, donskoy2, troyka2, fast2, royal2, manchester2,
                                    prestigue2, premier2, cosmos2, next2, magnat2, minsk2, souz2, count2);
                            for (thirdCoef = 1; thirdCoef < 201; thirdCoef++) {
                                rentRatio3 = worker3.getRatio() * worker3.getRent();
                                substitution3 = rentRatio3 * secondCoef / 100;
                                expenses = substitution1 + substitution2 + substitution3;


                                bond3 = sigarets3.getBond() * substitution3;
                                kent3 = sigarets3.getKent() * substitution3;
                                parlament3 = sigarets3.getParlament() * substitution3;
                                winston3 = sigarets3.getWinston() * substitution3;
                                lm3 = sigarets3.getLm() * substitution3;
                                malboro3 = sigarets3.getMalboro() * substitution3;
                                rotmans3 = sigarets3.getRotmans() * substitution3;
                                ld3 = sigarets3.getLd() * substitution3;
                                fmorris3 = sigarets3.getFmorris() * substitution3;
                                aliance3 = sigarets3.getAliance() * substitution3;
                                java3 = sigarets3.getJava() * substitution3;
                                optima3 = sigarets3.getOptima() * substitution3;
                                petr3 = sigarets3.getPetr() * substitution3;
                                maksim3 = sigarets3.getMaksim() * substitution3;
                                crests3 = sigarets3.getCrests() * substitution3;
                                vog3 = sigarets3.getVog() * substitution3;
                                glamur3 = sigarets3.getGlamur() * substitution3;
                                kiss3 = sigarets3.getKiss() * substitution3;
                                esse3 = sigarets3.getEsse() * substitution3;
                                quin3 = sigarets3.getQuin() * substitution3;
                                lady3 = sigarets3.getLady() * substitution3;
                                mor3 = sigarets3.getMor() * substitution3;
                                chester3 = sigarets3.getChester() * substitution3;
                                radopy3 = sigarets3.getRadopy() * substitution3;
                                stuardessa3 = sigarets3.getStuardessa() * substitution3;
                                stolichniye3 = sigarets3.getStolichniye() * substitution3;
                                donskoy3 = sigarets3.getDonskoy() * substitution3;
                                troyka3 = sigarets3.getTroyka() * substitution3;
                                fast3 = sigarets3.getFast() * substitution3;
                                royal3 = sigarets3.getRoyal() * substitution3;
                                manchester3 = sigarets3.getManchester() * substitution3;
                                prestigue3 = sigarets3.getPrestigue() * substitution3;
                                premier3 = sigarets3.getPremier() * substitution3;
                                cosmos3 = sigarets3.getCosmos() * substitution3;
                                next3 = sigarets3.getNext() * substitution3;
                                magnat3 = sigarets3.getMagnat() * substitution3;
                                minsk3 = sigarets3.getMinsk() * substitution3;
                                souz3 = sigarets3.getSouz() * substitution3;
                                jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                        bond1, kent1, parlament1, winston1, lm1, malboro1, rotmans1,
                                        ld1, fmorris1, aliance1, java1, optima1, petr1, maksim1, crests1,
                                        vog1, glamur1, kiss1, esse1, quin1, lady1, mor1, chester1, radopy1,
                                        stuardessa1, stolichniye1, donskoy1, troyka1, fast1, royal1, manchester1,
                                        prestigue1, premier1, cosmos1, next1, magnat1, minsk1, souz1, count1);

                                double sumBond = bond1 + bond2 + bond3;
                                double sumKent = kent1 + kent2 + kent3;
                                double sumParlament = parlament1 + parlament2 + parlament3;
                                double sumWinston = winston1 + winston2 + winston3;
                                double sumLm = lm1 + lm2 + lm3;
                                double sumMalboro = malboro1 + malboro2 + malboro3;
                                double sumRotmans = rotmans1 + rotmans2 + rotmans3;
                                double sumLd = ld1 + ld2 + ld3;
                                double sumFmorris = fmorris1 + fmorris2 + fmorris3;
                                double sumAliance = aliance1 + aliance2 + aliance3;
                                double sumJava = java1 + java2 + java3;
                                double sumOptima = optima1 + optima2 + optima3;
                                double sumPetr = petr1 + petr2 + petr3;
                                double sumMaksim = maksim1 + maksim2 + maksim3;
                                double sumCrests = crests1 + crests2 + crests3;
                                double sumVog = vog1 + vog2 + vog3;
                                double sumGlamur = glamur1 + glamur2 + glamur3;
                                double sumKiss = kiss1 + kiss2 + kiss3;
                                double sumEsse = esse1 + esse2 + esse3;
                                double sumQuin = quin1 + quin2 + quin3;
                                double sumLady = lady1 + lady2 + lady3;
                                double sumMor = mor1 + mor2 + mor3;
                                double sumChester = chester1 + chester2 + chester3;
                                double sumRadopy = radopy1 + radopy2 + radopy3;
                                double sumStuardessa = stuardessa1 + stuardessa2 + stuardessa3;
                                double sumStolichniye = stolichniye1 + stolichniye2 + stolichniye3;
                                double sumDonskoy = donskoy1 + donskoy2 + donskoy3;
                                double sumTroyka = troyka1 + troyka2 + troyka3;
                                double sumFast = fast1 + fast2 + fast3;
                                double sumRoyal = royal1 + royal2 + royal3;
                                double sumManchester = manchester1 + manchester2 + manchester3;
                                double sumPrestigue = prestigue1 + prestigue2 + prestigue3;
                                double sumPremier = premier1 + premier2 + premier3;
                                double sumCosmos = cosmos1 + cosmos2 + cosmos3;
                                double sumNext = next1 + next2 + next3;
                                double sumMagnat = magnat1 + magnat2 + magnat3;
                                double sumMinsk = minsk1 + minsk2 + minsk3;
                                double sumSouz = souz1 + souz2 + souz3;

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

                                double expenses100 = expenses * 100;

                                double coefBond = resultBond / expenses100;
                                double coefKent = resultKent / expenses100;
                                double coefParlament = resultParlament / expenses100;
                                double coefWinston = resultWinston / expenses100;
                                double coefLm = resultLm / expenses100;
                                double coefMalboro = resultMalboro / expenses100;
                                double coefRotmans = resultRotmans / expenses100;
                                double coefLd = resultLd / expenses100;
                                double coefFmorris = resultFmorris / expenses100;
                                double coefAliance = resultAliance / expenses100;
                                double coefJava = resultJava / expenses100;
                                double coefOptima = resultOptima / expenses100;
                                double coefPetr = resultPetr / expenses100;
                                double coefMaksim = resultMaksim / expenses100;
                                double coefCrests = resultCrests / expenses100;
                                double coefVog = resultVog / expenses100;
                                double coefGlamur = resultGlamur / expenses100;
                                double coefKiss = resultKiss / expenses100;
                                double coefEsse = resultEsse / expenses100;
                                double coefQuin = resultQuin / expenses100;
                                double coefLady = resultLady / expenses100;
                                double coefMor = resultMor / expenses100;
                                double coefChester = resultChester / expenses100;
                                double coefRadopy = resultRadopy / expenses100;
                                double coefStuardessa = resultStuardessa / expenses100;
                                double coefStolichniye = resultStolichniye / expenses100;
                                double coefDonskoy = resultDonskoy / expenses100;
                                double coefTroyka = resultTroyka / expenses100;
                                double coefFast = resultFast / expenses100;
                                double coefRoyal = resultRoyal / expenses100;
                                double coefManchester = resultManchester / expenses100;
                                double coefPrestigue = resultPrestigue / expenses100;
                                double coefPremier = resultPremier / expenses100;
                                double coefCosmos = resultCosmos / expenses100;
                                double coefNext = resultNext / expenses100;
                                double coefMagnat = resultMagnat / expenses100;
                                double coefMinsk = resultMinsk / expenses100;
                                double coefSouz = resultSouz / expenses100;

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
                                                                                                                                                                                        jdbcTemplate.update(SAVE_BEST_GROUP3,
                                                                                                                                                                                                worker1.getWorkerId(),
                                                                                                                                                                                                worker2.getWorkerId(),
                                                                                                                                                                                                worker3.getWorkerId(),
                                                                                                                                                                                                firstCoef,
                                                                                                                                                                                                secondCoef,
                                                                                                                                                                                                thirdCoef,
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
            i++;
            j++;
            k++;
        }
        getTiming();
    }

    public void saveBestGroup4() {
        Date date = new Date();
        System.out.println("Рассчёт группы из 4" + date.toString());
        var parameters = paramsService.findParamsById(1);
        double bond1;
        double bond2;
        double bond3;
        double bond4;

        double kent1;
        double kent2;
        double kent3;
        double kent4;

        double winston1;
        double winston2;
        double winston3;
        double winston4;

        double parlament1;
        double parlament2;
        double parlament3;
        double parlament4;

        double lm1;
        double lm2;
        double lm3;
        double lm4;

        double malboro1;
        double malboro2;
        double malboro3;
        double malboro4;

        double rotmans1;
        double rotmans2;
        double rotmans3;
        double rotmans4;

        double ld1;
        double ld2;
        double ld3;
        double ld4;

        double fmorris1;
        double fmorris2;
        double fmorris3;
        double fmorris4;

        double aliance1;
        double aliance2;
        double aliance3;
        double aliance4;

        double java1;
        double java2;
        double java3;
        double java4;

        double optima1;
        double optima2;
        double optima3;
        double optima4;

        double petr1;
        double petr2;
        double petr3;
        double petr4;

        double maksim1;
        double maksim2;
        double maksim3;
        double maksim4;

        double crests1;
        double crests2;
        double crests3;
        double crests4;

        double vog1;
        double vog2;
        double vog3;
        double vog4;

        double glamur1;
        double glamur2;
        double glamur3;
        double glamur4;

        double esse1;
        double esse2;
        double esse3;
        double esse4;

        double kiss1;
        double kiss2;
        double kiss3;
        double kiss4;

        double quin1;
        double quin2;
        double quin3;
        double quin4;

        double lady1;
        double lady2;
        double lady3;
        double lady4;

        double mor1;
        double mor2;
        double mor3;
        double mor4;

        double chester1;
        double chester2;
        double chester3;
        double chester4;

        double radopy1;
        double radopy2;
        double radopy3;
        double radopy4;

        double stuardessa1;
        double stuardessa2;
        double stuardessa3;
        double stuardessa4;

        double stolichniye1;
        double stolichniye2;
        double stolichniye3;
        double stolichniye4;

        double donskoy1;
        double donskoy2;
        double donskoy3;
        double donskoy4;

        double troyka1;
        double troyka2;
        double troyka3;
        double troyka4;

        double fast1;
        double fast2;
        double fast3;
        double fast4;

        double royal1;
        double royal2;
        double royal3;
        double royal4;

        double manchester1;
        double manchester2;
        double manchester3;
        double manchester4;

        double prestigue1;
        double prestigue2;
        double prestigue3;
        double prestigue4;

        double premier1;
        double premier2;
        double premier3;
        double premier4;

        double cosmos1;
        double cosmos2;
        double cosmos3;
        double cosmos4;

        double next1;
        double next2;
        double next3;
        double next4;

        double magnat1;
        double magnat2;
        double magnat3;
        double magnat4;

        double minsk1;
        double minsk2;
        double minsk3;
        double minsk4;

        double souz1;
        double souz2;
        double souz3;
        double souz4;

        double firstCoef;
        double secondCoef;
        double thirdCoef;
        double fourthCoef;

        double rentRatio1;
        double rentRatio2;
        double rentRatio3;
        double rentRatio4;

        double substitution1;
        double substitution2;
        double substitution3;
        double substitution4;

        double expenses;
        int count1;
        int i = 1;
        int count2;
        int j = 2;
        int count3;
        int k = 3;
        int count4;
        int l = 4;

        //Первый сотрудник
        for (count1 = i; count1 < 50; count1++) {
            var worker1 = service.findWorkerById(count1);
            var sigarets1 = sigaretsService.getSigaretsById(count1);
            //Второй сотрудник
            for (count2 = j; count2 < 50; count2++) {
                var worker2 = service.findWorkerById(count2);
                var sigarets2 = sigaretsService.getSigaretsById(count2);
                //Третий сотрудник
                for (count3 = k; count3 < 50; count3++) {
                    var worker3 = service.findWorkerById(count3);
                    var sigarets3 = sigaretsService.getSigaretsById(count3);
                    //Четвёртый сотрудник
                    for (count4 = l; count4 < 50; count4++) {
                        var worker4 = service.findWorkerById(count4);
                        var sigarets4 = sigaretsService.getSigaretsById(count4);
                        //}

                        //Процент оклада первого
                        for (firstCoef = 1; firstCoef < 201; firstCoef++) {
                            rentRatio1 = worker1.getRatio() * worker1.getRent();
                            substitution1 = rentRatio1 * firstCoef / 100;

                            bond1 = sigarets1.getBond() * substitution1;
                            kent1 = sigarets1.getKent() * substitution1;
                            parlament1 = sigarets1.getParlament() * substitution1;
                            winston1 = sigarets1.getWinston() * substitution1;
                            lm1 = sigarets1.getLm() * substitution1;
                            malboro1 = sigarets1.getMalboro() * substitution1;
                            rotmans1 = sigarets1.getRotmans() * substitution1;
                            ld1 = sigarets1.getLd() * substitution1;
                            fmorris1 = sigarets1.getFmorris() * substitution1;
                            aliance1 = sigarets1.getAliance() * substitution1;
                            java1 = sigarets1.getJava() * substitution1;
                            optima1 = sigarets1.getOptima() * substitution1;
                            petr1 = sigarets1.getPetr() * substitution1;
                            maksim1 = sigarets1.getMaksim() * substitution1;
                            crests1 = sigarets1.getCrests() * substitution1;
                            vog1 = sigarets1.getVog() * substitution1;
                            glamur1 = sigarets1.getGlamur() * substitution1;
                            kiss1 = sigarets1.getKiss() * substitution1;
                            esse1 = sigarets1.getEsse() * substitution1;
                            quin1 = sigarets1.getQuin() * substitution1;
                            lady1 = sigarets1.getLady() * substitution1;
                            mor1 = sigarets1.getMor() * substitution1;
                            chester1 = sigarets1.getChester() * substitution1;
                            radopy1 = sigarets1.getRadopy() * substitution1;
                            stuardessa1 = sigarets1.getStuardessa() * substitution1;
                            stolichniye1 = sigarets1.getStolichniye() * substitution1;
                            donskoy1 = sigarets1.getDonskoy() * substitution1;
                            troyka1 = sigarets1.getTroyka() * substitution1;
                            fast1 = sigarets1.getFast() * substitution1;
                            royal1 = sigarets1.getRoyal() * substitution1;
                            manchester1 = sigarets1.getManchester() * substitution1;
                            prestigue1 = sigarets1.getPrestigue() * substitution1;
                            premier1 = sigarets1.getPremier() * substitution1;
                            cosmos1 = sigarets1.getCosmos() * substitution1;
                            next1 = sigarets1.getNext() * substitution1;
                            magnat1 = sigarets1.getMagnat() * substitution1;
                            minsk1 = sigarets1.getMinsk() * substitution1;
                            souz1 = sigarets1.getSouz() * substitution1;
                            jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                    bond1, kent1, parlament1, winston1, lm1, malboro1, rotmans1,
                                    ld1, fmorris1, aliance1, java1, optima1, petr1, maksim1, crests1,
                                    vog1, glamur1, kiss1, esse1, quin1, lady1, mor1, chester1, radopy1,
                                    stuardessa1, stolichniye1, donskoy1, troyka1, fast1, royal1, manchester1,
                                    prestigue1, premier1, cosmos1, next1, magnat1, minsk1, souz1, count1);
                            //Процент оклада второго
                            for (secondCoef = 1; secondCoef < 201; secondCoef++) {
                                rentRatio2 = worker2.getRatio() * worker2.getRent();
                                substitution2 = rentRatio2 * secondCoef / 100;


                                bond2 = sigarets2.getBond() * substitution2;
                                kent2 = sigarets2.getKent() * substitution2;
                                parlament2 = sigarets2.getParlament() * substitution2;
                                winston2 = sigarets2.getWinston() * substitution2;
                                lm2 = sigarets2.getLm() * substitution2;
                                malboro2 = sigarets2.getMalboro() * substitution2;
                                rotmans2 = sigarets2.getRotmans() * substitution2;
                                ld2 = sigarets2.getLd() * substitution2;
                                fmorris2 = sigarets2.getFmorris() * substitution2;
                                aliance2 = sigarets2.getAliance() * substitution2;
                                java2 = sigarets2.getJava() * substitution2;
                                optima2 = sigarets2.getOptima() * substitution2;
                                petr2 = sigarets2.getPetr() * substitution2;
                                maksim2 = sigarets2.getMaksim() * substitution2;
                                crests2 = sigarets2.getCrests() * substitution2;
                                vog2 = sigarets2.getVog() * substitution2;
                                glamur2 = sigarets2.getGlamur() * substitution2;
                                kiss2 = sigarets2.getKiss() * substitution2;
                                esse2 = sigarets2.getEsse() * substitution2;
                                quin2 = sigarets2.getQuin() * substitution2;
                                lady2 = sigarets2.getLady() * substitution2;
                                mor2 = sigarets2.getMor() * substitution2;
                                chester2 = sigarets2.getChester() * substitution2;
                                radopy2 = sigarets2.getRadopy() * substitution2;
                                stuardessa2 = sigarets2.getStuardessa() * substitution2;
                                stolichniye2 = sigarets2.getStolichniye() * substitution2;
                                donskoy2 = sigarets2.getDonskoy() * substitution2;
                                troyka2 = sigarets2.getTroyka() * substitution2;
                                fast2 = sigarets2.getFast() * substitution2;
                                royal2 = sigarets2.getRoyal() * substitution2;
                                manchester2 = sigarets2.getManchester() * substitution2;
                                prestigue2 = sigarets2.getPrestigue() * substitution2;
                                premier2 = sigarets2.getPremier() * substitution2;
                                cosmos2 = sigarets2.getCosmos() * substitution2;
                                next2 = sigarets2.getNext() * substitution2;
                                magnat2 = sigarets2.getMagnat() * substitution2;
                                minsk2 = sigarets2.getMinsk() * substitution2;
                                souz2 = sigarets2.getSouz() * substitution2;
                                jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                        bond2, kent2, parlament2, winston2, lm2, malboro2, rotmans2,
                                        ld2, fmorris2, aliance2, java2, optima2, petr2, maksim2, crests2,
                                        vog2, glamur2, kiss2, esse2, quin2, lady2, mor2, chester2, radopy2,
                                        stuardessa2, stolichniye2, donskoy2, troyka2, fast2, royal2, manchester2,
                                        prestigue2, premier2, cosmos2, next2, magnat2, minsk2, souz2, count2);
                                //Процент оклада третьего
                                for (thirdCoef = 1; thirdCoef < 201; thirdCoef++) {
                                    rentRatio3 = worker3.getRatio() * worker3.getRent();
                                    substitution3 = rentRatio3 * thirdCoef / 100;
                                    expenses = substitution1 + substitution2 + substitution3;


                                    bond3 = sigarets3.getBond() * substitution3;
                                    kent3 = sigarets3.getKent() * substitution3;
                                    parlament3 = sigarets3.getParlament() * substitution3;
                                    winston3 = sigarets3.getWinston() * substitution3;
                                    lm3 = sigarets3.getLm() * substitution3;
                                    malboro3 = sigarets3.getMalboro() * substitution3;
                                    rotmans3 = sigarets3.getRotmans() * substitution3;
                                    ld3 = sigarets3.getLd() * substitution3;
                                    fmorris3 = sigarets3.getFmorris() * substitution3;
                                    aliance3 = sigarets3.getAliance() * substitution3;
                                    java3 = sigarets3.getJava() * substitution3;
                                    optima3 = sigarets3.getOptima() * substitution3;
                                    petr3 = sigarets3.getPetr() * substitution3;
                                    maksim3 = sigarets3.getMaksim() * substitution3;
                                    crests3 = sigarets3.getCrests() * substitution3;
                                    vog3 = sigarets3.getVog() * substitution3;
                                    glamur3 = sigarets3.getGlamur() * substitution3;
                                    kiss3 = sigarets3.getKiss() * substitution3;
                                    esse3 = sigarets3.getEsse() * substitution3;
                                    quin3 = sigarets3.getQuin() * substitution3;
                                    lady3 = sigarets3.getLady() * substitution3;
                                    mor3 = sigarets3.getMor() * substitution3;
                                    chester3 = sigarets3.getChester() * substitution3;
                                    radopy3 = sigarets3.getRadopy() * substitution3;
                                    stuardessa3 = sigarets3.getStuardessa() * substitution3;
                                    stolichniye3 = sigarets3.getStolichniye() * substitution3;
                                    donskoy3 = sigarets3.getDonskoy() * substitution3;
                                    troyka3 = sigarets3.getTroyka() * substitution3;
                                    fast3 = sigarets3.getFast() * substitution3;
                                    royal3 = sigarets3.getRoyal() * substitution3;
                                    manchester3 = sigarets3.getManchester() * substitution3;
                                    prestigue3 = sigarets3.getPrestigue() * substitution3;
                                    premier3 = sigarets3.getPremier() * substitution3;
                                    cosmos3 = sigarets3.getCosmos() * substitution3;
                                    next3 = sigarets3.getNext() * substitution3;
                                    magnat3 = sigarets3.getMagnat() * substitution3;
                                    minsk3 = sigarets3.getMinsk() * substitution3;
                                    souz3 = sigarets3.getSouz() * substitution3;
                                    jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                            bond3, kent3, parlament3, winston3, lm3, malboro3, rotmans3,
                                            ld3, fmorris3, aliance3, java3, optima3, petr3, maksim3, crests3,
                                            vog3, glamur3, kiss3, esse3, quin3, lady3, mor3, chester3, radopy3,
                                            stuardessa3, stolichniye3, donskoy3, troyka3, fast3, royal3, manchester3,
                                            prestigue3, premier3, cosmos3, next3, magnat3, minsk3, souz3, count3);
                                    //Процент оклада четвёртого
                                    for (fourthCoef = 1; fourthCoef < 201; fourthCoef++) {
                                        rentRatio4 = worker4.getRatio() * worker4.getRent();
                                        substitution4 = rentRatio4 * fourthCoef / 100;

                                        bond4 = sigarets4.getBond() * substitution4;
                                        kent4 = sigarets4.getKent() * substitution4;
                                        parlament4 = sigarets4.getParlament() * substitution4;
                                        winston4 = sigarets4.getWinston() * substitution4;
                                        lm4 = sigarets4.getLm() * substitution4;
                                        malboro4 = sigarets4.getMalboro() * substitution4;
                                        rotmans4 = sigarets4.getRotmans() * substitution4;
                                        ld4 = sigarets4.getLd() * substitution4;
                                        fmorris4 = sigarets4.getFmorris() * substitution4;
                                        aliance4 = sigarets4.getAliance() * substitution4;
                                        java4 = sigarets4.getJava() * substitution4;
                                        optima4 = sigarets4.getOptima() * substitution4;
                                        petr4 = sigarets4.getPetr() * substitution4;
                                        maksim4 = sigarets4.getMaksim() * substitution4;
                                        crests4 = sigarets4.getCrests() * substitution4;
                                        vog4 = sigarets4.getVog() * substitution4;
                                        glamur4 = sigarets4.getGlamur() * substitution4;
                                        kiss4 = sigarets4.getKiss() * substitution4;
                                        esse4 = sigarets4.getEsse() * substitution4;
                                        quin4 = sigarets4.getQuin() * substitution4;
                                        lady4 = sigarets4.getLady() * substitution4;
                                        mor4 = sigarets4.getMor() * substitution4;
                                        chester4 = sigarets4.getChester() * substitution4;
                                        radopy4 = sigarets4.getRadopy() * substitution4;
                                        stuardessa4 = sigarets4.getStuardessa() * substitution4;
                                        stolichniye4 = sigarets4.getStolichniye() * substitution4;
                                        donskoy4 = sigarets4.getDonskoy() * substitution4;
                                        troyka4 = sigarets4.getTroyka() * substitution4;
                                        fast4 = sigarets4.getFast() * substitution4;
                                        royal4 = sigarets4.getRoyal() * substitution4;
                                        manchester4 = sigarets4.getManchester() * substitution4;
                                        prestigue4 = sigarets4.getPrestigue() * substitution4;
                                        premier4 = sigarets4.getPremier() * substitution4;
                                        cosmos4 = sigarets4.getCosmos() * substitution4;
                                        next4 = sigarets4.getNext() * substitution4;
                                        magnat4 = sigarets4.getMagnat() * substitution4;
                                        minsk4 = sigarets4.getMinsk() * substitution4;
                                        souz4 = sigarets4.getSouz() * substitution4;
                                        jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                                bond4, kent4, parlament4, winston4, lm4, malboro4, rotmans4,
                                                ld4, fmorris4, aliance4, java4, optima4, petr4, maksim4, crests4,
                                                vog4, glamur4, kiss4, esse4, quin4, lady4, mor4, chester4, radopy4,
                                                stuardessa4, stolichniye4, donskoy4, troyka4, fast4, royal4, manchester4,
                                                prestigue4, premier4, cosmos4, next4, magnat4, minsk4, souz4, count4);

                                        double sumBond = bond1 + bond2 + bond3 + bond4;
                                        double sumKent = kent1 + kent2 + kent3 + kent4;
                                        double sumParlament = parlament1 + parlament2 + parlament3 + parlament4;
                                        double sumWinston = winston1 + winston2 + winston3 + winston4;
                                        double sumLm = lm1 + lm2 + lm3 + lm4;
                                        double sumMalboro = malboro1 + malboro2 + malboro3 + malboro4;
                                        double sumRotmans = rotmans1 + rotmans2 + rotmans3 + rotmans4;
                                        double sumLd = ld1 + ld2 + ld3 + ld4;
                                        double sumFmorris = fmorris1 + fmorris2 + fmorris3 + fmorris4;
                                        double sumAliance = aliance1 + aliance2 + aliance3 + aliance4;
                                        double sumJava = java1 + java2 + java3 + java4;
                                        double sumOptima = optima1 + optima2 + optima3 + optima4;
                                        double sumPetr = petr1 + petr2 + petr3 + petr4;
                                        double sumMaksim = maksim1 + maksim2 + maksim3 + maksim4;
                                        double sumCrests = crests1 + crests2 + crests3 + crests4;
                                        double sumVog = vog1 + vog2 + vog3 + vog4;
                                        double sumGlamur = glamur1 + glamur2 + glamur3 + glamur4;
                                        double sumKiss = kiss1 + kiss2 + kiss3 + kiss4;
                                        double sumEsse = esse1 + esse2 + esse3 + esse4;
                                        double sumQuin = quin1 + quin2 + quin3 + quin4;
                                        double sumLady = lady1 + lady2 + lady3 + lady4;
                                        double sumMor = mor1 + mor2 + mor3 + mor4;
                                        double sumChester = chester1 + chester2 + chester3 + chester4;
                                        double sumRadopy = radopy1 + radopy2 + radopy3 + radopy4;
                                        double sumStuardessa = stuardessa1 + stuardessa2 + stuardessa3 + stuardessa4;
                                        double sumStolichniye = stolichniye1 + stolichniye2 + stolichniye3 + stolichniye4;
                                        double sumDonskoy = donskoy1 + donskoy2 + donskoy3 + donskoy4;
                                        double sumTroyka = troyka1 + troyka2 + troyka3 + troyka4;
                                        double sumFast = fast1 + fast2 + fast3 + fast4;
                                        double sumRoyal = royal1 + royal2 + royal3 + royal4;
                                        double sumManchester = manchester1 + manchester2 + manchester3 + manchester4;
                                        double sumPrestigue = prestigue1 + prestigue2 + prestigue3 + prestigue4;
                                        double sumPremier = premier1 + premier2 + premier3 + premier4;
                                        double sumCosmos = cosmos1 + cosmos2 + cosmos3 + cosmos4;
                                        double sumNext = next1 + next2 + next3 + next4;
                                        double sumMagnat = magnat1 + magnat2 + magnat3 + magnat4;
                                        double sumMinsk = minsk1 + minsk2 + minsk3 + minsk4;
                                        double sumSouz = souz1 + souz2 + souz3 + souz4;

                                        expenses = substitution1 + substitution2 + substitution3
                                                + substitution4;


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

                                        double expenses100 = expenses * 100;

                                        double coefBond = resultBond / expenses100;
                                        double coefKent = resultKent / expenses100;
                                        double coefParlament = resultParlament / expenses100;
                                        double coefWinston = resultWinston / expenses100;
                                        double coefLm = resultLm / expenses100;
                                        double coefMalboro = resultMalboro / expenses100;
                                        double coefRotmans = resultRotmans / expenses100;
                                        double coefLd = resultLd / expenses100;
                                        double coefFmorris = resultFmorris / expenses100;
                                        double coefAliance = resultAliance / expenses100;
                                        double coefJava = resultJava / expenses100;
                                        double coefOptima = resultOptima / expenses100;
                                        double coefPetr = resultPetr / expenses100;
                                        double coefMaksim = resultMaksim / expenses100;
                                        double coefCrests = resultCrests / expenses100;
                                        double coefVog = resultVog / expenses100;
                                        double coefGlamur = resultGlamur / expenses100;
                                        double coefKiss = resultKiss / expenses100;
                                        double coefEsse = resultEsse / expenses100;
                                        double coefQuin = resultQuin / expenses100;
                                        double coefLady = resultLady / expenses100;
                                        double coefMor = resultMor / expenses100;
                                        double coefChester = resultChester / expenses100;
                                        double coefRadopy = resultRadopy / expenses100;
                                        double coefStuardessa = resultStuardessa / expenses100;
                                        double coefStolichniye = resultStolichniye / expenses100;
                                        double coefDonskoy = resultDonskoy / expenses100;
                                        double coefTroyka = resultTroyka / expenses100;
                                        double coefFast = resultFast / expenses100;
                                        double coefRoyal = resultRoyal / expenses100;
                                        double coefManchester = resultManchester / expenses100;
                                        double coefPrestigue = resultPrestigue / expenses100;
                                        double coefPremier = resultPremier / expenses100;
                                        double coefCosmos = resultCosmos / expenses100;
                                        double coefNext = resultNext / expenses100;
                                        double coefMagnat = resultMagnat / expenses100;
                                        double coefMinsk = resultMinsk / expenses100;
                                        double coefSouz = resultSouz / expenses100;

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
                                                                                                                                                                                                jdbcTemplate.update(SAVE_BEST_GROUP4,
                                                                                                                                                                                                        worker1.getWorkerId(),
                                                                                                                                                                                                        worker2.getWorkerId(),
                                                                                                                                                                                                        worker3.getWorkerId(),
                                                                                                                                                                                                        worker4.getWorkerId(),

                                                                                                                                                                                                        firstCoef,
                                                                                                                                                                                                        secondCoef,
                                                                                                                                                                                                        thirdCoef,
                                                                                                                                                                                                        fourthCoef,

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
                }
            }
            i++;
            j++;
            k++;
            l++;
        }
        getTiming();
    }

    public void saveBestGroup5() {
        Date date = new Date();
        System.out.println("Рассчёт группы из 5" + date.toString());
        var parameters = paramsService.findParamsById(1);
        double bond1;
        double bond2;
        double bond3;
        double bond4;
        double bond5;

        double kent1;
        double kent2;
        double kent3;
        double kent4;
        double kent5;

        double winston1;
        double winston2;
        double winston3;
        double winston4;
        double winston5;

        double parlament1;
        double parlament2;
        double parlament3;
        double parlament4;
        double parlament5;

        double lm1;
        double lm2;
        double lm3;
        double lm4;
        double lm5;

        double malboro1;
        double malboro2;
        double malboro3;
        double malboro4;
        double malboro5;

        double rotmans1;
        double rotmans2;
        double rotmans3;
        double rotmans4;
        double rotmans5;

        double ld1;
        double ld2;
        double ld3;
        double ld4;
        double ld5;

        double fmorris1;
        double fmorris2;
        double fmorris3;
        double fmorris4;
        double fmorris5;

        double aliance1;
        double aliance2;
        double aliance3;
        double aliance4;
        double aliance5;

        double java1;
        double java2;
        double java3;
        double java4;
        double java5;

        double optima1;
        double optima2;
        double optima3;
        double optima4;
        double optima5;

        double petr1;
        double petr2;
        double petr3;
        double petr4;
        double petr5;

        double maksim1;
        double maksim2;
        double maksim3;
        double maksim4;
        double maksim5;

        double crests1;
        double crests2;
        double crests3;
        double crests4;
        double crests5;

        double vog1;
        double vog2;
        double vog3;
        double vog4;
        double vog5;

        double glamur1;
        double glamur2;
        double glamur3;
        double glamur4;
        double glamur5;

        double esse1;
        double esse2;
        double esse3;
        double esse4;
        double esse5;

        double kiss1;
        double kiss2;
        double kiss3;
        double kiss4;
        double kiss5;

        double quin1;
        double quin2;
        double quin3;
        double quin4;
        double quin5;

        double lady1;
        double lady2;
        double lady3;
        double lady4;
        double lady5;

        double mor1;
        double mor2;
        double mor3;
        double mor4;
        double mor5;

        double chester1;
        double chester2;
        double chester3;
        double chester4;
        double chester5;

        double radopy1;
        double radopy2;
        double radopy3;
        double radopy4;
        double radopy5;

        double stuardessa1;
        double stuardessa2;
        double stuardessa3;
        double stuardessa4;
        double stuardessa5;

        double stolichniye1;
        double stolichniye2;
        double stolichniye3;
        double stolichniye4;
        double stolichniye5;

        double donskoy1;
        double donskoy2;
        double donskoy3;
        double donskoy4;
        double donskoy5;

        double troyka1;
        double troyka2;
        double troyka3;
        double troyka4;
        double troyka5;

        double fast1;
        double fast2;
        double fast3;
        double fast4;
        double fast5;

        double royal1;
        double royal2;
        double royal3;
        double royal4;
        double royal5;

        double manchester1;
        double manchester2;
        double manchester3;
        double manchester4;
        double manchester5;

        double prestigue1;
        double prestigue2;
        double prestigue3;
        double prestigue4;
        double prestigue5;

        double premier1;
        double premier2;
        double premier3;
        double premier4;
        double premier5;

        double cosmos1;
        double cosmos2;
        double cosmos3;
        double cosmos4;
        double cosmos5;

        double next1;
        double next2;
        double next3;
        double next4;
        double next5;

        double magnat1;
        double magnat2;
        double magnat3;
        double magnat4;
        double magnat5;

        double minsk1;
        double minsk2;
        double minsk3;
        double minsk4;
        double minsk5;

        double souz1;
        double souz2;
        double souz3;
        double souz4;
        double souz5;


        double firstCoef;
        double secondCoef;
        double thirdCoef;
        double fourthCoef;
        double fifthCoef;

        double rentRatio1;
        double rentRatio2;
        double rentRatio3;
        double rentRatio4;
        double rentRatio5;

        double substitution1;
        double substitution2;
        double substitution3;
        double substitution4;
        double substitution5;

        double expenses;
        int count1;
        int i = 1;
        int count2;
        int j = 2;
        int count3;
        int k = 3;
        int count4;
        int l = 4;
        int count5;
        int a = 5;

        //Первый сотрудник
        for (count1 = i; count1 < 50; count1++) {
            var worker1 = service.findWorkerById(count1);
            var sigarets1 = sigaretsService.getSigaretsById(count1);
            //Второй сотрудник
            for (count2 = j; count2 < 50; count2++) {
                var worker2 = service.findWorkerById(count2);
                var sigarets2 = sigaretsService.getSigaretsById(count2);
                //Третий сотрудник
                for (count3 = k; count3 < 50; count3++) {
                    var worker3 = service.findWorkerById(count3);
                    var sigarets3 = sigaretsService.getSigaretsById(count3);
                    //Четвёртый сотрудник
                    for (count4 = l; count4 < 50; count4++) {
                        var worker4 = service.findWorkerById(count4);
                        var sigarets4 = sigaretsService.getSigaretsById(count4);
                        //}
                        //Пятый сотрудник
                        for (count5 = a; count5 < 50; count5++) {
                            var worker5 = service.findWorkerById(count5);
                            var sigarets5 = sigaretsService.getSigaretsById(count5);
                            //}
                            //Процент оклада первого
                            for (firstCoef = 1; firstCoef < 201; firstCoef++) {
                                rentRatio1 = worker1.getRatio() * worker1.getRent();
                                substitution1 = rentRatio1 * firstCoef / 100;

                                bond1 = sigarets1.getBond() * substitution1;
                                kent1 = sigarets1.getKent() * substitution1;
                                parlament1 = sigarets1.getParlament() * substitution1;
                                winston1 = sigarets1.getWinston() * substitution1;
                                lm1 = sigarets1.getLm() * substitution1;
                                malboro1 = sigarets1.getMalboro() * substitution1;
                                rotmans1 = sigarets1.getRotmans() * substitution1;
                                ld1 = sigarets1.getLd() * substitution1;
                                fmorris1 = sigarets1.getFmorris() * substitution1;
                                aliance1 = sigarets1.getAliance() * substitution1;
                                java1 = sigarets1.getJava() * substitution1;
                                optima1 = sigarets1.getOptima() * substitution1;
                                petr1 = sigarets1.getPetr() * substitution1;
                                maksim1 = sigarets1.getMaksim() * substitution1;
                                crests1 = sigarets1.getCrests() * substitution1;
                                vog1 = sigarets1.getVog() * substitution1;
                                glamur1 = sigarets1.getGlamur() * substitution1;
                                kiss1 = sigarets1.getKiss() * substitution1;
                                esse1 = sigarets1.getEsse() * substitution1;
                                quin1 = sigarets1.getQuin() * substitution1;
                                lady1 = sigarets1.getLady() * substitution1;
                                mor1 = sigarets1.getMor() * substitution1;
                                chester1 = sigarets1.getChester() * substitution1;
                                radopy1 = sigarets1.getRadopy() * substitution1;
                                stuardessa1 = sigarets1.getStuardessa() * substitution1;
                                stolichniye1 = sigarets1.getStolichniye() * substitution1;
                                donskoy1 = sigarets1.getDonskoy() * substitution1;
                                troyka1 = sigarets1.getTroyka() * substitution1;
                                fast1 = sigarets1.getFast() * substitution1;
                                royal1 = sigarets1.getRoyal() * substitution1;
                                manchester1 = sigarets1.getManchester() * substitution1;
                                prestigue1 = sigarets1.getPrestigue() * substitution1;
                                premier1 = sigarets1.getPremier() * substitution1;
                                cosmos1 = sigarets1.getCosmos() * substitution1;
                                next1 = sigarets1.getNext() * substitution1;
                                magnat1 = sigarets1.getMagnat() * substitution1;
                                minsk1 = sigarets1.getMinsk() * substitution1;
                                souz1 = sigarets1.getSouz() * substitution1;
                                jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                        bond1, kent1, parlament1, winston1, lm1, malboro1, rotmans1,
                                        ld1, fmorris1, aliance1, java1, optima1, petr1, maksim1, crests1,
                                        vog1, glamur1, kiss1, esse1, quin1, lady1, mor1, chester1, radopy1,
                                        stuardessa1, stolichniye1, donskoy1, troyka1, fast1, royal1, manchester1,
                                        prestigue1, premier1, cosmos1, next1, magnat1, minsk1, souz1, count1);
                                //Процент оклада второго
                                for (secondCoef = 1; secondCoef < 201; secondCoef++) {
                                    rentRatio2 = worker2.getRatio() * worker2.getRent();
                                    substitution2 = rentRatio2 * secondCoef / 100;


                                    bond2 = sigarets2.getBond() * substitution2;
                                    kent2 = sigarets2.getKent() * substitution2;
                                    parlament2 = sigarets2.getParlament() * substitution2;
                                    winston2 = sigarets2.getWinston() * substitution2;
                                    lm2 = sigarets2.getLm() * substitution2;
                                    malboro2 = sigarets2.getMalboro() * substitution2;
                                    rotmans2 = sigarets2.getRotmans() * substitution2;
                                    ld2 = sigarets2.getLd() * substitution2;
                                    fmorris2 = sigarets2.getFmorris() * substitution2;
                                    aliance2 = sigarets2.getAliance() * substitution2;
                                    java2 = sigarets2.getJava() * substitution2;
                                    optima2 = sigarets2.getOptima() * substitution2;
                                    petr2 = sigarets2.getPetr() * substitution2;
                                    maksim2 = sigarets2.getMaksim() * substitution2;
                                    crests2 = sigarets2.getCrests() * substitution2;
                                    vog2 = sigarets2.getVog() * substitution2;
                                    glamur2 = sigarets2.getGlamur() * substitution2;
                                    kiss2 = sigarets2.getKiss() * substitution2;
                                    esse2 = sigarets2.getEsse() * substitution2;
                                    quin2 = sigarets2.getQuin() * substitution2;
                                    lady2 = sigarets2.getLady() * substitution2;
                                    mor2 = sigarets2.getMor() * substitution2;
                                    chester2 = sigarets2.getChester() * substitution2;
                                    radopy2 = sigarets2.getRadopy() * substitution2;
                                    stuardessa2 = sigarets2.getStuardessa() * substitution2;
                                    stolichniye2 = sigarets2.getStolichniye() * substitution2;
                                    donskoy2 = sigarets2.getDonskoy() * substitution2;
                                    troyka2 = sigarets2.getTroyka() * substitution2;
                                    fast2 = sigarets2.getFast() * substitution2;
                                    royal2 = sigarets2.getRoyal() * substitution2;
                                    manchester2 = sigarets2.getManchester() * substitution2;
                                    prestigue2 = sigarets2.getPrestigue() * substitution2;
                                    premier2 = sigarets2.getPremier() * substitution2;
                                    cosmos2 = sigarets2.getCosmos() * substitution2;
                                    next2 = sigarets2.getNext() * substitution2;
                                    magnat2 = sigarets2.getMagnat() * substitution2;
                                    minsk2 = sigarets2.getMinsk() * substitution2;
                                    souz2 = sigarets2.getSouz() * substitution2;
                                    jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                            bond2, kent2, parlament2, winston2, lm2, malboro2, rotmans2,
                                            ld2, fmorris2, aliance2, java2, optima2, petr2, maksim2, crests2,
                                            vog2, glamur2, kiss2, esse2, quin2, lady2, mor2, chester2, radopy2,
                                            stuardessa2, stolichniye2, donskoy2, troyka2, fast2, royal2, manchester2,
                                            prestigue2, premier2, cosmos2, next2, magnat2, minsk2, souz2, count2);
                                    //Процент оклада третьего
                                    for (thirdCoef = 1; thirdCoef < 201; thirdCoef++) {
                                        rentRatio3 = worker3.getRatio() * worker3.getRent();
                                        substitution3 = rentRatio3 * thirdCoef / 100;
                                        expenses = substitution1 + substitution2 + substitution3;


                                        bond3 = sigarets3.getBond() * substitution3;
                                        kent3 = sigarets3.getKent() * substitution3;
                                        parlament3 = sigarets3.getParlament() * substitution3;
                                        winston3 = sigarets3.getWinston() * substitution3;
                                        lm3 = sigarets3.getLm() * substitution3;
                                        malboro3 = sigarets3.getMalboro() * substitution3;
                                        rotmans3 = sigarets3.getRotmans() * substitution3;
                                        ld3 = sigarets3.getLd() * substitution3;
                                        fmorris3 = sigarets3.getFmorris() * substitution3;
                                        aliance3 = sigarets3.getAliance() * substitution3;
                                        java3 = sigarets3.getJava() * substitution3;
                                        optima3 = sigarets3.getOptima() * substitution3;
                                        petr3 = sigarets3.getPetr() * substitution3;
                                        maksim3 = sigarets3.getMaksim() * substitution3;
                                        crests3 = sigarets3.getCrests() * substitution3;
                                        vog3 = sigarets3.getVog() * substitution3;
                                        glamur3 = sigarets3.getGlamur() * substitution3;
                                        kiss3 = sigarets3.getKiss() * substitution3;
                                        esse3 = sigarets3.getEsse() * substitution3;
                                        quin3 = sigarets3.getQuin() * substitution3;
                                        lady3 = sigarets3.getLady() * substitution3;
                                        mor3 = sigarets3.getMor() * substitution3;
                                        chester3 = sigarets3.getChester() * substitution3;
                                        radopy3 = sigarets3.getRadopy() * substitution3;
                                        stuardessa3 = sigarets3.getStuardessa() * substitution3;
                                        stolichniye3 = sigarets3.getStolichniye() * substitution3;
                                        donskoy3 = sigarets3.getDonskoy() * substitution3;
                                        troyka3 = sigarets3.getTroyka() * substitution3;
                                        fast3 = sigarets3.getFast() * substitution3;
                                        royal3 = sigarets3.getRoyal() * substitution3;
                                        manchester3 = sigarets3.getManchester() * substitution3;
                                        prestigue3 = sigarets3.getPrestigue() * substitution3;
                                        premier3 = sigarets3.getPremier() * substitution3;
                                        cosmos3 = sigarets3.getCosmos() * substitution3;
                                        next3 = sigarets3.getNext() * substitution3;
                                        magnat3 = sigarets3.getMagnat() * substitution3;
                                        minsk3 = sigarets3.getMinsk() * substitution3;
                                        souz3 = sigarets3.getSouz() * substitution3;
                                        jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                                bond3, kent3, parlament3, winston3, lm3, malboro3, rotmans3,
                                                ld3, fmorris3, aliance3, java3, optima3, petr3, maksim3, crests3,
                                                vog3, glamur3, kiss3, esse3, quin3, lady3, mor3, chester3, radopy3,
                                                stuardessa3, stolichniye3, donskoy3, troyka3, fast3, royal3, manchester3,
                                                prestigue3, premier3, cosmos3, next3, magnat3, minsk3, souz3, count3);
                                        //Процент оклада четвёртого
                                        for (fourthCoef = 1; fourthCoef < 201; fourthCoef++) {
                                            rentRatio4 = worker4.getRatio() * worker4.getRent();
                                            substitution4 = rentRatio4 * fourthCoef / 100;

                                            bond4 = sigarets4.getBond() * substitution4;
                                            kent4 = sigarets4.getKent() * substitution4;
                                            parlament4 = sigarets4.getParlament() * substitution4;
                                            winston4 = sigarets4.getWinston() * substitution4;
                                            lm4 = sigarets4.getLm() * substitution4;
                                            malboro4 = sigarets4.getMalboro() * substitution4;
                                            rotmans4 = sigarets4.getRotmans() * substitution4;
                                            ld4 = sigarets4.getLd() * substitution4;
                                            fmorris4 = sigarets4.getFmorris() * substitution4;
                                            aliance4 = sigarets4.getAliance() * substitution4;
                                            java4 = sigarets4.getJava() * substitution4;
                                            optima4 = sigarets4.getOptima() * substitution4;
                                            petr4 = sigarets4.getPetr() * substitution4;
                                            maksim4 = sigarets4.getMaksim() * substitution4;
                                            crests4 = sigarets4.getCrests() * substitution4;
                                            vog4 = sigarets4.getVog() * substitution4;
                                            glamur4 = sigarets4.getGlamur() * substitution4;
                                            kiss4 = sigarets4.getKiss() * substitution4;
                                            esse4 = sigarets4.getEsse() * substitution4;
                                            quin4 = sigarets4.getQuin() * substitution4;
                                            lady4 = sigarets4.getLady() * substitution4;
                                            mor4 = sigarets4.getMor() * substitution4;
                                            chester4 = sigarets4.getChester() * substitution4;
                                            radopy4 = sigarets4.getRadopy() * substitution4;
                                            stuardessa4 = sigarets4.getStuardessa() * substitution4;
                                            stolichniye4 = sigarets4.getStolichniye() * substitution4;
                                            donskoy4 = sigarets4.getDonskoy() * substitution4;
                                            troyka4 = sigarets4.getTroyka() * substitution4;
                                            fast4 = sigarets4.getFast() * substitution4;
                                            royal4 = sigarets4.getRoyal() * substitution4;
                                            manchester4 = sigarets4.getManchester() * substitution4;
                                            prestigue4 = sigarets4.getPrestigue() * substitution4;
                                            premier4 = sigarets4.getPremier() * substitution4;
                                            cosmos4 = sigarets4.getCosmos() * substitution4;
                                            next4 = sigarets4.getNext() * substitution4;
                                            magnat4 = sigarets4.getMagnat() * substitution4;
                                            minsk4 = sigarets4.getMinsk() * substitution4;
                                            souz4 = sigarets4.getSouz() * substitution4;
                                            jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                                    bond4, kent4, parlament4, winston4, lm4, malboro4, rotmans4,
                                                    ld4, fmorris4, aliance4, java4, optima4, petr4, maksim4, crests4,
                                                    vog4, glamur4, kiss4, esse4, quin4, lady4, mor4, chester4, radopy4,
                                                    stuardessa4, stolichniye4, donskoy4, troyka4, fast4, royal4, manchester4,
                                                    prestigue4, premier4, cosmos4, next4, magnat4, minsk4, souz4, count4);
                                            //Процент оклада пятого
                                            for (fifthCoef = 1; fifthCoef < 201; fifthCoef++) {
                                                rentRatio5 = worker5.getRatio() * worker5.getRent();
                                                substitution5 = rentRatio5 * fifthCoef / 100;

                                                bond5 = sigarets5.getBond() * substitution5;
                                                kent5 = sigarets5.getKent() * substitution5;
                                                parlament5 = sigarets5.getParlament() * substitution5;
                                                winston5 = sigarets5.getWinston() * substitution5;
                                                lm5 = sigarets5.getLm() * substitution5;
                                                malboro5 = sigarets5.getMalboro() * substitution5;
                                                rotmans5 = sigarets5.getRotmans() * substitution5;
                                                ld5 = sigarets5.getLd() * substitution5;
                                                fmorris5 = sigarets5.getFmorris() * substitution5;
                                                aliance5 = sigarets5.getAliance() * substitution5;
                                                java5 = sigarets5.getJava() * substitution5;
                                                optima5 = sigarets5.getOptima() * substitution5;
                                                petr5 = sigarets5.getPetr() * substitution5;
                                                maksim5 = sigarets5.getMaksim() * substitution5;
                                                crests5 = sigarets5.getCrests() * substitution5;
                                                vog5 = sigarets5.getVog() * substitution5;
                                                glamur5 = sigarets5.getGlamur() * substitution5;
                                                kiss5 = sigarets5.getKiss() * substitution5;
                                                esse5 = sigarets5.getEsse() * substitution5;
                                                quin5 = sigarets5.getQuin() * substitution5;
                                                lady5 = sigarets5.getLady() * substitution5;
                                                mor5 = sigarets5.getMor() * substitution5;
                                                chester5 = sigarets5.getChester() * substitution5;
                                                radopy5 = sigarets5.getRadopy() * substitution5;
                                                stuardessa5 = sigarets5.getStuardessa() * substitution5;
                                                stolichniye5 = sigarets5.getStolichniye() * substitution5;
                                                donskoy5 = sigarets5.getDonskoy() * substitution5;
                                                troyka5 = sigarets5.getTroyka() * substitution5;
                                                fast5 = sigarets5.getFast() * substitution5;
                                                royal5 = sigarets5.getRoyal() * substitution5;
                                                manchester5 = sigarets5.getManchester() * substitution5;
                                                prestigue5 = sigarets5.getPrestigue() * substitution5;
                                                premier5 = sigarets5.getPremier() * substitution5;
                                                cosmos5 = sigarets5.getCosmos() * substitution5;
                                                next5 = sigarets5.getNext() * substitution5;
                                                magnat5 = sigarets5.getMagnat() * substitution5;
                                                minsk5 = sigarets5.getMinsk() * substitution5;
                                                souz5 = sigarets5.getSouz() * substitution5;
                                                jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                                        bond5, kent5, parlament5, winston5, lm5, malboro5, rotmans5,
                                                        ld5, fmorris5, aliance5, java5, optima5, petr5, maksim5, crests5,
                                                        vog5, glamur5, kiss5, esse5, quin5, lady5, mor5, chester5, radopy5,
                                                        stuardessa5, stolichniye5, donskoy5, troyka5, fast5, royal5, manchester5,
                                                        prestigue5, premier5, cosmos5, next5, magnat5, minsk5, souz5, count5);


                                                double sumBond = bond1 + bond2 + bond3 + bond4 + bond5;
                                                double sumKent = kent1 + kent2 + kent3 + kent4 + kent5;
                                                double sumParlament = parlament1 + parlament2 + parlament3 + parlament4 + parlament5;
                                                double sumWinston = winston1 + winston2 + winston3 + winston4 + winston5;
                                                double sumLm = lm1 + lm2 + lm3 + lm4 + lm5;
                                                double sumMalboro = malboro1 + malboro2 + malboro3 + malboro4 + malboro5;
                                                double sumRotmans = rotmans1 + rotmans2 + rotmans3 + rotmans4 + rotmans5;
                                                double sumLd = ld1 + ld2 + ld3 + ld4 + ld5;
                                                double sumFmorris = fmorris1 + fmorris2 + fmorris3 + fmorris4 + fmorris5;
                                                double sumAliance = aliance1 + aliance2 + aliance3 + aliance4 + aliance5;
                                                double sumJava = java1 + java2 + java3 + java4 + java5;
                                                double sumOptima = optima1 + optima2 + optima3 + optima4 + optima5;
                                                double sumPetr = petr1 + petr2 + petr3 + petr4 + petr5;
                                                double sumMaksim = maksim1 + maksim2 + maksim3 + maksim4 + maksim5;
                                                double sumCrests = crests1 + crests2 + crests3 + crests4 + crests5;
                                                double sumVog = vog1 + vog2 + vog3 + vog4 + vog5;
                                                double sumGlamur = glamur1 + glamur2 + glamur3 + glamur4 + glamur5;
                                                double sumKiss = kiss1 + kiss2 + kiss3 + kiss4 + kiss5;
                                                double sumEsse = esse1 + esse2 + esse3 + esse4 + esse5;
                                                double sumQuin = quin1 + quin2 + quin3 + quin4 + quin5;
                                                double sumLady = lady1 + lady2 + lady3 + lady4 + lady5;
                                                double sumMor = mor1 + mor2 + mor3 + mor4 + mor5;
                                                double sumChester = chester1 + chester2 + chester3 + chester4 + chester5;
                                                double sumRadopy = radopy1 + radopy2 + radopy3 + radopy4 + radopy5;
                                                double sumStuardessa = stuardessa1 + stuardessa2 + stuardessa3 + stuardessa4 + stuardessa5;
                                                double sumStolichniye = stolichniye1 + stolichniye2 + stolichniye3 + stolichniye4 + stolichniye5;
                                                double sumDonskoy = donskoy1 + donskoy2 + donskoy3 + donskoy4 + donskoy5;
                                                double sumTroyka = troyka1 + troyka2 + troyka3 + troyka4 + troyka5;
                                                double sumFast = fast1 + fast2 + fast3 + fast4 + fast5;
                                                double sumRoyal = royal1 + royal2 + royal3 + royal4 + royal5;
                                                double sumManchester = manchester1 + manchester2 + manchester3 + manchester4 + manchester5;
                                                double sumPrestigue = prestigue1 + prestigue2 + prestigue3 + prestigue4 + prestigue5;
                                                double sumPremier = premier1 + premier2 + premier3 + premier4 + premier5;
                                                double sumCosmos = cosmos1 + cosmos2 + cosmos3 + cosmos4 + cosmos5;
                                                double sumNext = next1 + next2 + next3 + next4 + next5;
                                                double sumMagnat = magnat1 + magnat2 + magnat3 + magnat4 + magnat5;
                                                double sumMinsk = minsk1 + minsk2 + minsk3 + minsk4 + minsk5;
                                                double sumSouz = souz1 + souz2 + souz3 + souz4 + souz5;

                                                expenses = substitution1 + substitution2 + substitution3
                                                        + substitution4 + substitution5;


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

                                                double expenses100 = expenses * 100;

                                                double coefBond = resultBond / expenses100;
                                                double coefKent = resultKent / expenses100;
                                                double coefParlament = resultParlament / expenses100;
                                                double coefWinston = resultWinston / expenses100;
                                                double coefLm = resultLm / expenses100;
                                                double coefMalboro = resultMalboro / expenses100;
                                                double coefRotmans = resultRotmans / expenses100;
                                                double coefLd = resultLd / expenses100;
                                                double coefFmorris = resultFmorris / expenses100;
                                                double coefAliance = resultAliance / expenses100;
                                                double coefJava = resultJava / expenses100;
                                                double coefOptima = resultOptima / expenses100;
                                                double coefPetr = resultPetr / expenses100;
                                                double coefMaksim = resultMaksim / expenses100;
                                                double coefCrests = resultCrests / expenses100;
                                                double coefVog = resultVog / expenses100;
                                                double coefGlamur = resultGlamur / expenses100;
                                                double coefKiss = resultKiss / expenses100;
                                                double coefEsse = resultEsse / expenses100;
                                                double coefQuin = resultQuin / expenses100;
                                                double coefLady = resultLady / expenses100;
                                                double coefMor = resultMor / expenses100;
                                                double coefChester = resultChester / expenses100;
                                                double coefRadopy = resultRadopy / expenses100;
                                                double coefStuardessa = resultStuardessa / expenses100;
                                                double coefStolichniye = resultStolichniye / expenses100;
                                                double coefDonskoy = resultDonskoy / expenses100;
                                                double coefTroyka = resultTroyka / expenses100;
                                                double coefFast = resultFast / expenses100;
                                                double coefRoyal = resultRoyal / expenses100;
                                                double coefManchester = resultManchester / expenses100;
                                                double coefPrestigue = resultPrestigue / expenses100;
                                                double coefPremier = resultPremier / expenses100;
                                                double coefCosmos = resultCosmos / expenses100;
                                                double coefNext = resultNext / expenses100;
                                                double coefMagnat = resultMagnat / expenses100;
                                                double coefMinsk = resultMinsk / expenses100;
                                                double coefSouz = resultSouz / expenses100;

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
                                                                                                                                                                                                        jdbcTemplate.update(SAVE_BEST_GROUP5,
                                                                                                                                                                                                                worker1.getWorkerId(),
                                                                                                                                                                                                                worker2.getWorkerId(),
                                                                                                                                                                                                                worker3.getWorkerId(),
                                                                                                                                                                                                                worker4.getWorkerId(),
                                                                                                                                                                                                                worker5.getWorkerId(),

                                                                                                                                                                                                                firstCoef,
                                                                                                                                                                                                                secondCoef,
                                                                                                                                                                                                                thirdCoef,
                                                                                                                                                                                                                fourthCoef,
                                                                                                                                                                                                                fifthCoef,

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
                        }
                    }
                }
            }
            i++;
            j++;
            k++;
            l++;
            a++;

        }

        getTiming();

    }

    public void saveBestGroup6() {
        Date date = new Date();
        System.out.println("Рассчёт группы из 6" + date.toString());
        var parameters = paramsService.findParamsById(1);
        double bond1;
        double bond2;
        double bond3;
        double bond4;
        double bond5;
        double bond6;

        double kent1;
        double kent2;
        double kent3;
        double kent4;
        double kent5;
        double kent6;

        double winston1;
        double winston2;
        double winston3;
        double winston4;
        double winston5;
        double winston6;

        double parlament1;
        double parlament2;
        double parlament3;
        double parlament4;
        double parlament5;
        double parlament6;

        double lm1;
        double lm2;
        double lm3;
        double lm4;
        double lm5;
        double lm6;

        double malboro1;
        double malboro2;
        double malboro3;
        double malboro4;
        double malboro5;
        double malboro6;

        double rotmans1;
        double rotmans2;
        double rotmans3;
        double rotmans4;
        double rotmans5;
        double rotmans6;

        double ld1;
        double ld2;
        double ld3;
        double ld4;
        double ld5;
        double ld6;

        double fmorris1;
        double fmorris2;
        double fmorris3;
        double fmorris4;
        double fmorris5;
        double fmorris6;

        double aliance1;
        double aliance2;
        double aliance3;
        double aliance4;
        double aliance5;
        double aliance6;

        double java1;
        double java2;
        double java3;
        double java4;
        double java5;
        double java6;


        double optima1;
        double optima2;
        double optima3;
        double optima4;
        double optima5;
        double optima6;

        double petr1;
        double petr2;
        double petr3;
        double petr4;
        double petr5;
        double petr6;

        double maksim1;
        double maksim2;
        double maksim3;
        double maksim4;
        double maksim5;
        double maksim6;

        double crests1;
        double crests2;
        double crests3;
        double crests4;
        double crests5;
        double crests6;

        double vog1;
        double vog2;
        double vog3;
        double vog4;
        double vog5;
        double vog6;

        double glamur1;
        double glamur2;
        double glamur3;
        double glamur4;
        double glamur5;
        double glamur6;

        double esse1;
        double esse2;
        double esse3;
        double esse4;
        double esse5;
        double esse6;

        double kiss1;
        double kiss2;
        double kiss3;
        double kiss4;
        double kiss5;
        double kiss6;

        double quin1;
        double quin2;
        double quin3;
        double quin4;
        double quin5;
        double quin6;

        double lady1;
        double lady2;
        double lady3;
        double lady4;
        double lady5;
        double lady6;

        double mor1;
        double mor2;
        double mor3;
        double mor4;
        double mor5;
        double mor6;

        double chester1;
        double chester2;
        double chester3;
        double chester4;
        double chester5;
        double chester6;


        double radopy1;
        double radopy2;
        double radopy3;
        double radopy4;
        double radopy5;
        double radopy6;


        double stuardessa1;
        double stuardessa2;
        double stuardessa3;
        double stuardessa4;
        double stuardessa5;
        double stuardessa6;


        double stolichniye1;
        double stolichniye2;
        double stolichniye3;
        double stolichniye4;
        double stolichniye5;
        double stolichniye6;


        double donskoy1;
        double donskoy2;
        double donskoy3;
        double donskoy4;
        double donskoy5;
        double donskoy6;

        double troyka1;
        double troyka2;
        double troyka3;
        double troyka4;
        double troyka5;
        double troyka6;

        double fast1;
        double fast2;
        double fast3;
        double fast4;
        double fast5;
        double fast6;

        double royal1;
        double royal2;
        double royal3;
        double royal4;
        double royal5;
        double royal6;

        double manchester1;
        double manchester2;
        double manchester3;
        double manchester4;
        double manchester5;
        double manchester6;

        double prestigue1;
        double prestigue2;
        double prestigue3;
        double prestigue4;
        double prestigue5;
        double prestigue6;

        double premier1;
        double premier2;
        double premier3;
        double premier4;
        double premier5;
        double premier6;

        double cosmos1;
        double cosmos2;
        double cosmos3;
        double cosmos4;
        double cosmos5;
        double cosmos6;

        double next1;
        double next2;
        double next3;
        double next4;
        double next5;
        double next6;

        double magnat1;
        double magnat2;
        double magnat3;
        double magnat4;
        double magnat5;
        double magnat6;

        double minsk1;
        double minsk2;
        double minsk3;
        double minsk4;
        double minsk5;
        double minsk6;

        double souz1;
        double souz2;
        double souz3;
        double souz4;
        double souz5;
        double souz6;


        double firstCoef;
        double secondCoef;
        double thirdCoef;
        double fourthCoef;
        double fifthCoef;
        double sixthCoef;

        double rentRatio1;
        double rentRatio2;
        double rentRatio3;
        double rentRatio4;
        double rentRatio5;
        double rentRatio6;

        double substitution1;
        double substitution2;
        double substitution3;
        double substitution4;
        double substitution5;
        double substitution6;

        double expenses;
        int count1;
        int i = 1;
        int count2;
        int j = 2;
        int count3;
        int k = 3;
        int count4;
        int l = 4;
        int count5;
        int a = 5;
        int count6;
        int s = 6;

        //Первый сотрудник
        for (count1 = i; count1 < 50; count1++) {
            var worker1 = service.findWorkerById(count1);
            var sigarets1 = sigaretsService.getSigaretsById(count1);
            //Второй сотрудник
            for (count2 = j; count2 < 50; count2++) {
                var worker2 = service.findWorkerById(count2);
                var sigarets2 = sigaretsService.getSigaretsById(count2);
                //Третий сотрудник
                for (count3 = k; count3 < 50; count3++) {
                    var worker3 = service.findWorkerById(count3);
                    var sigarets3 = sigaretsService.getSigaretsById(count3);
                    //Четвёртый сотрудник
                    for (count4 = l; count4 < 50; count4++) {
                        var worker4 = service.findWorkerById(count4);
                        var sigarets4 = sigaretsService.getSigaretsById(count4);
                        //}
                        //Пятый сотрудник
                        for (count5 = a; count5 < 50; count5++) {
                            var worker5 = service.findWorkerById(count5);
                            var sigarets5 = sigaretsService.getSigaretsById(count5);
                            //}
                            //Шестой сотрудник
                            for (count6 = s; count6 < 50; count6++) {
                                var worker6 = service.findWorkerById(count6);
                                var sigarets6 = sigaretsService.getSigaretsById(count6);
                                //}
                                //Процент оклада первого
                                for (firstCoef = 1; firstCoef < 201; firstCoef++) {
                                    rentRatio1 = worker1.getRatio() * worker1.getRent();
                                    substitution1 = rentRatio1 * firstCoef / 100;

                                    bond1 = sigarets1.getBond() * substitution1;
                                    kent1 = sigarets1.getKent() * substitution1;
                                    parlament1 = sigarets1.getParlament() * substitution1;
                                    winston1 = sigarets1.getWinston() * substitution1;
                                    lm1 = sigarets1.getLm() * substitution1;
                                    malboro1 = sigarets1.getMalboro() * substitution1;
                                    rotmans1 = sigarets1.getRotmans() * substitution1;
                                    ld1 = sigarets1.getLd() * substitution1;
                                    fmorris1 = sigarets1.getFmorris() * substitution1;
                                    aliance1 = sigarets1.getAliance() * substitution1;
                                    java1 = sigarets1.getJava() * substitution1;
                                    optima1 = sigarets1.getOptima() * substitution1;
                                    petr1 = sigarets1.getPetr() * substitution1;
                                    maksim1 = sigarets1.getMaksim() * substitution1;
                                    crests1 = sigarets1.getCrests() * substitution1;
                                    vog1 = sigarets1.getVog() * substitution1;
                                    glamur1 = sigarets1.getGlamur() * substitution1;
                                    kiss1 = sigarets1.getKiss() * substitution1;
                                    esse1 = sigarets1.getEsse() * substitution1;
                                    quin1 = sigarets1.getQuin() * substitution1;
                                    lady1 = sigarets1.getLady() * substitution1;
                                    mor1 = sigarets1.getMor() * substitution1;
                                    chester1 = sigarets1.getChester() * substitution1;
                                    radopy1 = sigarets1.getRadopy() * substitution1;
                                    stuardessa1 = sigarets1.getStuardessa() * substitution1;
                                    stolichniye1 = sigarets1.getStolichniye() * substitution1;
                                    donskoy1 = sigarets1.getDonskoy() * substitution1;
                                    troyka1 = sigarets1.getTroyka() * substitution1;
                                    fast1 = sigarets1.getFast() * substitution1;
                                    royal1 = sigarets1.getRoyal() * substitution1;
                                    manchester1 = sigarets1.getManchester() * substitution1;
                                    prestigue1 = sigarets1.getPrestigue() * substitution1;
                                    premier1 = sigarets1.getPremier() * substitution1;
                                    cosmos1 = sigarets1.getCosmos() * substitution1;
                                    next1 = sigarets1.getNext() * substitution1;
                                    magnat1 = sigarets1.getMagnat() * substitution1;
                                    minsk1 = sigarets1.getMinsk() * substitution1;
                                    souz1 = sigarets1.getSouz() * substitution1;
                                    jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                            bond1, kent1, parlament1, winston1, lm1, malboro1, rotmans1,
                                            ld1, fmorris1, aliance1, java1, optima1, petr1, maksim1, crests1,
                                            vog1, glamur1, kiss1, esse1, quin1, lady1, mor1, chester1, radopy1,
                                            stuardessa1, stolichniye1, donskoy1, troyka1, fast1, royal1, manchester1,
                                            prestigue1, premier1, cosmos1, next1, magnat1, minsk1, souz1, count1);
                                    //Процент оклада второго
                                    for (secondCoef = 1; secondCoef < 201; secondCoef++) {
                                        rentRatio2 = worker2.getRatio() * worker2.getRent();
                                        substitution2 = rentRatio2 * secondCoef / 100;


                                        bond2 = sigarets2.getBond() * substitution2;
                                        kent2 = sigarets2.getKent() * substitution2;
                                        parlament2 = sigarets2.getParlament() * substitution2;
                                        winston2 = sigarets2.getWinston() * substitution2;
                                        lm2 = sigarets2.getLm() * substitution2;
                                        malboro2 = sigarets2.getMalboro() * substitution2;
                                        rotmans2 = sigarets2.getRotmans() * substitution2;
                                        ld2 = sigarets2.getLd() * substitution2;
                                        fmorris2 = sigarets2.getFmorris() * substitution2;
                                        aliance2 = sigarets2.getAliance() * substitution2;
                                        java2 = sigarets2.getJava() * substitution2;
                                        optima2 = sigarets2.getOptima() * substitution2;
                                        petr2 = sigarets2.getPetr() * substitution2;
                                        maksim2 = sigarets2.getMaksim() * substitution2;
                                        crests2 = sigarets2.getCrests() * substitution2;
                                        vog2 = sigarets2.getVog() * substitution2;
                                        glamur2 = sigarets2.getGlamur() * substitution2;
                                        kiss2 = sigarets2.getKiss() * substitution2;
                                        esse2 = sigarets2.getEsse() * substitution2;
                                        quin2 = sigarets2.getQuin() * substitution2;
                                        lady2 = sigarets2.getLady() * substitution2;
                                        mor2 = sigarets2.getMor() * substitution2;
                                        chester2 = sigarets2.getChester() * substitution2;
                                        radopy2 = sigarets2.getRadopy() * substitution2;
                                        stuardessa2 = sigarets2.getStuardessa() * substitution2;
                                        stolichniye2 = sigarets2.getStolichniye() * substitution2;
                                        donskoy2 = sigarets2.getDonskoy() * substitution2;
                                        troyka2 = sigarets2.getTroyka() * substitution2;
                                        fast2 = sigarets2.getFast() * substitution2;
                                        royal2 = sigarets2.getRoyal() * substitution2;
                                        manchester2 = sigarets2.getManchester() * substitution2;
                                        prestigue2 = sigarets2.getPrestigue() * substitution2;
                                        premier2 = sigarets2.getPremier() * substitution2;
                                        cosmos2 = sigarets2.getCosmos() * substitution2;
                                        next2 = sigarets2.getNext() * substitution2;
                                        magnat2 = sigarets2.getMagnat() * substitution2;
                                        minsk2 = sigarets2.getMinsk() * substitution2;
                                        souz2 = sigarets2.getSouz() * substitution2;
                                        jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                                bond2, kent2, parlament2, winston2, lm2, malboro2, rotmans2,
                                                ld2, fmorris2, aliance2, java2, optima2, petr2, maksim2, crests2,
                                                vog2, glamur2, kiss2, esse2, quin2, lady2, mor2, chester2, radopy2,
                                                stuardessa2, stolichniye2, donskoy2, troyka2, fast2, royal2, manchester2,
                                                prestigue2, premier2, cosmos2, next2, magnat2, minsk2, souz2, count2);
                                        //Процент оклада третьего
                                        for (thirdCoef = 1; thirdCoef < 201; thirdCoef++) {
                                            rentRatio3 = worker3.getRatio() * worker3.getRent();
                                            substitution3 = rentRatio3 * thirdCoef / 100;
                                            expenses = substitution1 + substitution2 + substitution3;


                                            bond3 = sigarets3.getBond() * substitution3;
                                            kent3 = sigarets3.getKent() * substitution3;
                                            parlament3 = sigarets3.getParlament() * substitution3;
                                            winston3 = sigarets3.getWinston() * substitution3;
                                            lm3 = sigarets3.getLm() * substitution3;
                                            malboro3 = sigarets3.getMalboro() * substitution3;
                                            rotmans3 = sigarets3.getRotmans() * substitution3;
                                            ld3 = sigarets3.getLd() * substitution3;
                                            fmorris3 = sigarets3.getFmorris() * substitution3;
                                            aliance3 = sigarets3.getAliance() * substitution3;
                                            java3 = sigarets3.getJava() * substitution3;
                                            optima3 = sigarets3.getOptima() * substitution3;
                                            petr3 = sigarets3.getPetr() * substitution3;
                                            maksim3 = sigarets3.getMaksim() * substitution3;
                                            crests3 = sigarets3.getCrests() * substitution3;
                                            vog3 = sigarets3.getVog() * substitution3;
                                            glamur3 = sigarets3.getGlamur() * substitution3;
                                            kiss3 = sigarets3.getKiss() * substitution3;
                                            esse3 = sigarets3.getEsse() * substitution3;
                                            quin3 = sigarets3.getQuin() * substitution3;
                                            lady3 = sigarets3.getLady() * substitution3;
                                            mor3 = sigarets3.getMor() * substitution3;
                                            chester3 = sigarets3.getChester() * substitution3;
                                            radopy3 = sigarets3.getRadopy() * substitution3;
                                            stuardessa3 = sigarets3.getStuardessa() * substitution3;
                                            stolichniye3 = sigarets3.getStolichniye() * substitution3;
                                            donskoy3 = sigarets3.getDonskoy() * substitution3;
                                            troyka3 = sigarets3.getTroyka() * substitution3;
                                            fast3 = sigarets3.getFast() * substitution3;
                                            royal3 = sigarets3.getRoyal() * substitution3;
                                            manchester3 = sigarets3.getManchester() * substitution3;
                                            prestigue3 = sigarets3.getPrestigue() * substitution3;
                                            premier3 = sigarets3.getPremier() * substitution3;
                                            cosmos3 = sigarets3.getCosmos() * substitution3;
                                            next3 = sigarets3.getNext() * substitution3;
                                            magnat3 = sigarets3.getMagnat() * substitution3;
                                            minsk3 = sigarets3.getMinsk() * substitution3;
                                            souz3 = sigarets3.getSouz() * substitution3;
                                            jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                                    bond3, kent3, parlament3, winston3, lm3, malboro3, rotmans3,
                                                    ld3, fmorris3, aliance3, java3, optima3, petr3, maksim3, crests3,
                                                    vog3, glamur3, kiss3, esse3, quin3, lady3, mor3, chester3, radopy3,
                                                    stuardessa3, stolichniye3, donskoy3, troyka3, fast3, royal3, manchester3,
                                                    prestigue3, premier3, cosmos3, next3, magnat3, minsk3, souz3, count3);
                                            //Процент оклада четвёртого
                                            for (fourthCoef = 1; fourthCoef < 201; fourthCoef++) {
                                                rentRatio4 = worker4.getRatio() * worker4.getRent();
                                                substitution4 = rentRatio4 * fourthCoef / 100;

                                                bond4 = sigarets4.getBond() * substitution4;
                                                kent4 = sigarets4.getKent() * substitution4;
                                                parlament4 = sigarets4.getParlament() * substitution4;
                                                winston4 = sigarets4.getWinston() * substitution4;
                                                lm4 = sigarets4.getLm() * substitution4;
                                                malboro4 = sigarets4.getMalboro() * substitution4;
                                                rotmans4 = sigarets4.getRotmans() * substitution4;
                                                ld4 = sigarets4.getLd() * substitution4;
                                                fmorris4 = sigarets4.getFmorris() * substitution4;
                                                aliance4 = sigarets4.getAliance() * substitution4;
                                                java4 = sigarets4.getJava() * substitution4;
                                                optima4 = sigarets4.getOptima() * substitution4;
                                                petr4 = sigarets4.getPetr() * substitution4;
                                                maksim4 = sigarets4.getMaksim() * substitution4;
                                                crests4 = sigarets4.getCrests() * substitution4;
                                                vog4 = sigarets4.getVog() * substitution4;
                                                glamur4 = sigarets4.getGlamur() * substitution4;
                                                kiss4 = sigarets4.getKiss() * substitution4;
                                                esse4 = sigarets4.getEsse() * substitution4;
                                                quin4 = sigarets4.getQuin() * substitution4;
                                                lady4 = sigarets4.getLady() * substitution4;
                                                mor4 = sigarets4.getMor() * substitution4;
                                                chester4 = sigarets4.getChester() * substitution4;
                                                radopy4 = sigarets4.getRadopy() * substitution4;
                                                stuardessa4 = sigarets4.getStuardessa() * substitution4;
                                                stolichniye4 = sigarets4.getStolichniye() * substitution4;
                                                donskoy4 = sigarets4.getDonskoy() * substitution4;
                                                troyka4 = sigarets4.getTroyka() * substitution4;
                                                fast4 = sigarets4.getFast() * substitution4;
                                                royal4 = sigarets4.getRoyal() * substitution4;
                                                manchester4 = sigarets4.getManchester() * substitution4;
                                                prestigue4 = sigarets4.getPrestigue() * substitution4;
                                                premier4 = sigarets4.getPremier() * substitution4;
                                                cosmos4 = sigarets4.getCosmos() * substitution4;
                                                next4 = sigarets4.getNext() * substitution4;
                                                magnat4 = sigarets4.getMagnat() * substitution4;
                                                minsk4 = sigarets4.getMinsk() * substitution4;
                                                souz4 = sigarets4.getSouz() * substitution4;
                                                jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                                        bond4, kent4, parlament4, winston4, lm4, malboro4, rotmans4,
                                                        ld4, fmorris4, aliance4, java4, optima4, petr4, maksim4, crests4,
                                                        vog4, glamur4, kiss4, esse4, quin4, lady4, mor4, chester4, radopy4,
                                                        stuardessa4, stolichniye4, donskoy4, troyka4, fast4, royal4, manchester4,
                                                        prestigue4, premier4, cosmos4, next4, magnat4, minsk4, souz4, count4);
                                                //Процент оклада пятого
                                                for (fifthCoef = 1; fifthCoef < 201; fifthCoef++) {
                                                    rentRatio5 = worker5.getRatio() * worker5.getRent();
                                                    substitution5 = rentRatio5 * fifthCoef / 100;

                                                    bond5 = sigarets5.getBond() * substitution5;
                                                    kent5 = sigarets5.getKent() * substitution5;
                                                    parlament5 = sigarets5.getParlament() * substitution5;
                                                    winston5 = sigarets5.getWinston() * substitution5;
                                                    lm5 = sigarets5.getLm() * substitution5;
                                                    malboro5 = sigarets5.getMalboro() * substitution5;
                                                    rotmans5 = sigarets5.getRotmans() * substitution5;
                                                    ld5 = sigarets5.getLd() * substitution5;
                                                    fmorris5 = sigarets5.getFmorris() * substitution5;
                                                    aliance5 = sigarets5.getAliance() * substitution5;
                                                    java5 = sigarets5.getJava() * substitution5;
                                                    optima5 = sigarets5.getOptima() * substitution5;
                                                    petr5 = sigarets5.getPetr() * substitution5;
                                                    maksim5 = sigarets5.getMaksim() * substitution5;
                                                    crests5 = sigarets5.getCrests() * substitution5;
                                                    vog5 = sigarets5.getVog() * substitution5;
                                                    glamur5 = sigarets5.getGlamur() * substitution5;
                                                    kiss5 = sigarets5.getKiss() * substitution5;
                                                    esse5 = sigarets5.getEsse() * substitution5;
                                                    quin5 = sigarets5.getQuin() * substitution5;
                                                    lady5 = sigarets5.getLady() * substitution5;
                                                    mor5 = sigarets5.getMor() * substitution5;
                                                    chester5 = sigarets5.getChester() * substitution5;
                                                    radopy5 = sigarets5.getRadopy() * substitution5;
                                                    stuardessa5 = sigarets5.getStuardessa() * substitution5;
                                                    stolichniye5 = sigarets5.getStolichniye() * substitution5;
                                                    donskoy5 = sigarets5.getDonskoy() * substitution5;
                                                    troyka5 = sigarets5.getTroyka() * substitution5;
                                                    fast5 = sigarets5.getFast() * substitution5;
                                                    royal5 = sigarets5.getRoyal() * substitution5;
                                                    manchester5 = sigarets5.getManchester() * substitution5;
                                                    prestigue5 = sigarets5.getPrestigue() * substitution5;
                                                    premier5 = sigarets5.getPremier() * substitution5;
                                                    cosmos5 = sigarets5.getCosmos() * substitution5;
                                                    next5 = sigarets5.getNext() * substitution5;
                                                    magnat5 = sigarets5.getMagnat() * substitution5;
                                                    minsk5 = sigarets5.getMinsk() * substitution5;
                                                    souz5 = sigarets5.getSouz() * substitution5;
                                                    jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                                            bond5, kent5, parlament5, winston5, lm5, malboro5, rotmans5,
                                                            ld5, fmorris5, aliance5, java5, optima5, petr5, maksim5, crests5,
                                                            vog5, glamur5, kiss5, esse5, quin5, lady5, mor5, chester5, radopy5,
                                                            stuardessa5, stolichniye5, donskoy5, troyka5, fast5, royal5, manchester5,
                                                            prestigue5, premier5, cosmos5, next5, magnat5, minsk5, souz5, count5);
                                                    //Процент оклада шестого
                                                    for (sixthCoef = 1; sixthCoef < 201; sixthCoef++) {
                                                        rentRatio6 = worker6.getRatio() * worker6.getRent();
                                                        substitution6 = rentRatio6 * sixthCoef / 100;

                                                        bond6 = sigarets6.getBond() * substitution6;
                                                        kent6 = sigarets6.getKent() * substitution6;
                                                        parlament6 = sigarets6.getParlament() * substitution6;
                                                        winston6 = sigarets6.getWinston() * substitution6;
                                                        lm6 = sigarets6.getLm() * substitution6;
                                                        malboro6 = sigarets6.getMalboro() * substitution6;
                                                        rotmans6 = sigarets6.getRotmans() * substitution6;
                                                        ld6 = sigarets6.getLd() * substitution6;
                                                        fmorris6 = sigarets6.getFmorris() * substitution6;
                                                        aliance6 = sigarets6.getAliance() * substitution6;
                                                        java6 = sigarets6.getJava() * substitution6;
                                                        optima6 = sigarets6.getOptima() * substitution6;
                                                        petr6 = sigarets6.getPetr() * substitution6;
                                                        maksim6 = sigarets6.getMaksim() * substitution6;
                                                        crests6 = sigarets6.getCrests() * substitution6;
                                                        vog6 = sigarets6.getVog() * substitution6;
                                                        glamur6 = sigarets6.getGlamur() * substitution6;
                                                        kiss6 = sigarets6.getKiss() * substitution6;
                                                        esse6 = sigarets6.getEsse() * substitution6;
                                                        quin6 = sigarets6.getQuin() * substitution6;
                                                        lady6 = sigarets6.getLady() * substitution6;
                                                        mor6 = sigarets6.getMor() * substitution6;
                                                        chester6 = sigarets6.getChester() * substitution6;
                                                        radopy6 = sigarets6.getRadopy() * substitution6;
                                                        stuardessa6 = sigarets6.getStuardessa() * substitution6;
                                                        stolichniye6 = sigarets6.getStolichniye() * substitution6;
                                                        donskoy6 = sigarets6.getDonskoy() * substitution6;
                                                        troyka6 = sigarets6.getTroyka() * substitution6;
                                                        fast6 = sigarets6.getFast() * substitution6;
                                                        royal6 = sigarets6.getRoyal() * substitution6;
                                                        manchester6 = sigarets6.getManchester() * substitution6;
                                                        prestigue6 = sigarets6.getPrestigue() * substitution6;
                                                        premier6 = sigarets6.getPremier() * substitution6;
                                                        cosmos6 = sigarets6.getCosmos() * substitution6;
                                                        next6 = sigarets6.getNext() * substitution6;
                                                        magnat6 = sigarets6.getMagnat() * substitution6;
                                                        minsk6 = sigarets6.getMinsk() * substitution6;
                                                        souz6 = sigarets6.getSouz() * substitution6;
                                                        jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                                                bond6, kent6, parlament6, winston6, lm6, malboro6, rotmans6,
                                                                ld6, fmorris6, aliance6, java6, optima6, petr6, maksim6, crests6,
                                                                vog6, glamur6, kiss6, esse6, quin6, lady6, mor6, chester6, radopy6,
                                                                stuardessa6, stolichniye6, donskoy6, troyka6, fast6, royal6, manchester6,
                                                                prestigue6, premier6, cosmos6, next6, magnat6, minsk6, souz6, count6);
                                                        //Процент оклада седьмого


                                                        double sumBond = bond1 + bond2 + bond3 + bond4 + bond5 + bond6;
                                                        double sumKent = kent1 + kent2 + kent3 + kent4 + kent5 + kent6;
                                                        double sumParlament = parlament1 + parlament2 + parlament3 + parlament4 + parlament5 + parlament6;
                                                        double sumWinston = winston1 + winston2 + winston3 + winston4 + winston5 + winston6;
                                                        double sumLm = lm1 + lm2 + lm3 + lm4 + lm5 + lm6;
                                                        double sumMalboro = malboro1 + malboro2 + malboro3 + malboro4 + malboro5 + malboro6;
                                                        double sumRotmans = rotmans1 + rotmans2 + rotmans3 + rotmans4 + rotmans5 + rotmans6;
                                                        double sumLd = ld1 + ld2 + ld3 + ld4 + ld5 + ld6;
                                                        double sumFmorris = fmorris1 + fmorris2 + fmorris3 + fmorris4 + fmorris5 + fmorris6;
                                                        double sumAliance = aliance1 + aliance2 + aliance3 + aliance4 + aliance5 + aliance6;
                                                        double sumJava = java1 + java2 + java3 + java4 + java5 + java6;
                                                        double sumOptima = optima1 + optima2 + optima3 + optima4 + optima5 + optima6;
                                                        double sumPetr = petr1 + petr2 + petr3 + petr4 + petr5 + petr6;
                                                        double sumMaksim = maksim1 + maksim2 + maksim3 + maksim4 + maksim5 + maksim6;
                                                        double sumCrests = crests1 + crests2 + crests3 + crests4 + crests5 + crests6;
                                                        double sumVog = vog1 + vog2 + vog3 + vog4 + vog5 + vog6;
                                                        double sumGlamur = glamur1 + glamur2 + glamur3 + glamur4 + glamur5 + glamur6;
                                                        double sumKiss = kiss1 + kiss2 + kiss3 + kiss4 + kiss5 + kiss6;
                                                        double sumEsse = esse1 + esse2 + esse3 + esse4 + esse5 + esse6;
                                                        double sumQuin = quin1 + quin2 + quin3 + quin4 + quin5 + quin6;
                                                        double sumLady = lady1 + lady2 + lady3 + lady4 + lady5 + lady6;
                                                        double sumMor = mor1 + mor2 + mor3 + mor4 + mor5 + mor6;
                                                        double sumChester = chester1 + chester2 + chester3 + chester4 + chester5 + chester6;
                                                        double sumRadopy = radopy1 + radopy2 + radopy3 + radopy4 + radopy5 + radopy6;
                                                        double sumStuardessa = stuardessa1 + stuardessa2 + stuardessa3 + stuardessa4 + stuardessa5 + stuardessa6;
                                                        double sumStolichniye = stolichniye1 + stolichniye2 + stolichniye3 + stolichniye4 + stolichniye5 + stolichniye6;
                                                        double sumDonskoy = donskoy1 + donskoy2 + donskoy3 + donskoy4 + donskoy5 + donskoy6;
                                                        double sumTroyka = troyka1 + troyka2 + troyka3 + troyka4 + troyka5 + troyka6;
                                                        double sumFast = fast1 + fast2 + fast3 + fast4 + fast5 + fast6;
                                                        double sumRoyal = royal1 + royal2 + royal3 + royal4 + royal5 + royal6;
                                                        double sumManchester = manchester1 + manchester2 + manchester3 + manchester4 + manchester5 + manchester6;
                                                        double sumPrestigue = prestigue1 + prestigue2 + prestigue3 + prestigue4 + prestigue5 + prestigue6;
                                                        double sumPremier = premier1 + premier2 + premier3 + premier4 + premier5 + premier6;
                                                        double sumCosmos = cosmos1 + cosmos2 + cosmos3 + cosmos4 + cosmos5 + cosmos6;
                                                        double sumNext = next1 + next2 + next3 + next4 + next5 + next6;
                                                        double sumMagnat = magnat1 + magnat2 + magnat3 + magnat4 + magnat5 + magnat6;
                                                        double sumMinsk = minsk1 + minsk2 + minsk3 + minsk4 + minsk5 + minsk6;
                                                        double sumSouz = souz1 + souz2 + souz3 + souz4 + souz5 + souz6;

                                                        expenses = substitution1 + substitution2 + substitution3
                                                                + substitution4 + substitution5 + substitution6;


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

                                                        double expenses100 = expenses * 100;

                                                        double coefBond = resultBond / expenses100;
                                                        double coefKent = resultKent / expenses100;
                                                        double coefParlament = resultParlament / expenses100;
                                                        double coefWinston = resultWinston / expenses100;
                                                        double coefLm = resultLm / expenses100;
                                                        double coefMalboro = resultMalboro / expenses100;
                                                        double coefRotmans = resultRotmans / expenses100;
                                                        double coefLd = resultLd / expenses100;
                                                        double coefFmorris = resultFmorris / expenses100;
                                                        double coefAliance = resultAliance / expenses100;
                                                        double coefJava = resultJava / expenses100;
                                                        double coefOptima = resultOptima / expenses100;
                                                        double coefPetr = resultPetr / expenses100;
                                                        double coefMaksim = resultMaksim / expenses100;
                                                        double coefCrests = resultCrests / expenses100;
                                                        double coefVog = resultVog / expenses100;
                                                        double coefGlamur = resultGlamur / expenses100;
                                                        double coefKiss = resultKiss / expenses100;
                                                        double coefEsse = resultEsse / expenses100;
                                                        double coefQuin = resultQuin / expenses100;
                                                        double coefLady = resultLady / expenses100;
                                                        double coefMor = resultMor / expenses100;
                                                        double coefChester = resultChester / expenses100;
                                                        double coefRadopy = resultRadopy / expenses100;
                                                        double coefStuardessa = resultStuardessa / expenses100;
                                                        double coefStolichniye = resultStolichniye / expenses100;
                                                        double coefDonskoy = resultDonskoy / expenses100;
                                                        double coefTroyka = resultTroyka / expenses100;
                                                        double coefFast = resultFast / expenses100;
                                                        double coefRoyal = resultRoyal / expenses100;
                                                        double coefManchester = resultManchester / expenses100;
                                                        double coefPrestigue = resultPrestigue / expenses100;
                                                        double coefPremier = resultPremier / expenses100;
                                                        double coefCosmos = resultCosmos / expenses100;
                                                        double coefNext = resultNext / expenses100;
                                                        double coefMagnat = resultMagnat / expenses100;
                                                        double coefMinsk = resultMinsk / expenses100;
                                                        double coefSouz = resultSouz / expenses100;

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
                                                                                                                                                                                                                jdbcTemplate.update(SAVE_BEST_GROUP6,
                                                                                                                                                                                                                        worker1.getWorkerId(),
                                                                                                                                                                                                                        worker2.getWorkerId(),
                                                                                                                                                                                                                        worker3.getWorkerId(),
                                                                                                                                                                                                                        worker4.getWorkerId(),
                                                                                                                                                                                                                        worker5.getWorkerId(),
                                                                                                                                                                                                                        worker6.getWorkerId(),

                                                                                                                                                                                                                        firstCoef,
                                                                                                                                                                                                                        secondCoef,
                                                                                                                                                                                                                        thirdCoef,
                                                                                                                                                                                                                        fourthCoef,
                                                                                                                                                                                                                        fifthCoef,
                                                                                                                                                                                                                        sixthCoef,

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
                                }
                            }
                        }
                    }
                }
            }
            i++;
            j++;
            k++;
            l++;
            a++;
            s++;
        }
        getTiming();
    }

    public void saveBestGroup7() {
        Date date = new Date();
        System.out.println("Рассчёт группы из 7" + date.toString());
        var parameters = paramsService.findParamsById(1);
        double bond1;
        double bond2;
        double bond3;
        double bond4;
        double bond5;
        double bond6;
        double bond7;

        double kent1;
        double kent2;
        double kent3;
        double kent4;
        double kent5;
        double kent6;
        double kent7;

        double winston1;
        double winston2;
        double winston3;
        double winston4;
        double winston5;
        double winston6;
        double winston7;

        double parlament1;
        double parlament2;
        double parlament3;
        double parlament4;
        double parlament5;
        double parlament6;
        double parlament7;

        double lm1;
        double lm2;
        double lm3;
        double lm4;
        double lm5;
        double lm6;
        double lm7;

        double malboro1;
        double malboro2;
        double malboro3;
        double malboro4;
        double malboro5;
        double malboro6;
        double malboro7;

        double rotmans1;
        double rotmans2;
        double rotmans3;
        double rotmans4;
        double rotmans5;
        double rotmans6;
        double rotmans7;

        double ld1;
        double ld2;
        double ld3;
        double ld4;
        double ld5;
        double ld6;
        double ld7;

        double fmorris1;
        double fmorris2;
        double fmorris3;
        double fmorris4;
        double fmorris5;
        double fmorris6;
        double fmorris7;

        double aliance1;
        double aliance2;
        double aliance3;
        double aliance4;
        double aliance5;
        double aliance6;
        double aliance7;

        double java1;
        double java2;
        double java3;
        double java4;
        double java5;
        double java6;
        double java7;

        double optima1;
        double optima2;
        double optima3;
        double optima4;
        double optima5;
        double optima6;
        double optima7;

        double petr1;
        double petr2;
        double petr3;
        double petr4;
        double petr5;
        double petr6;
        double petr7;

        double maksim1;
        double maksim2;
        double maksim3;
        double maksim4;
        double maksim5;
        double maksim6;
        double maksim7;

        double crests1;
        double crests2;
        double crests3;
        double crests4;
        double crests5;
        double crests6;
        double crests7;

        double vog1;
        double vog2;
        double vog3;
        double vog4;
        double vog5;
        double vog6;
        double vog7;

        double glamur1;
        double glamur2;
        double glamur3;
        double glamur4;
        double glamur5;
        double glamur6;
        double glamur7;

        double esse1;
        double esse2;
        double esse3;
        double esse4;
        double esse5;
        double esse6;
        double esse7;

        double kiss1;
        double kiss2;
        double kiss3;
        double kiss4;
        double kiss5;
        double kiss6;
        double kiss7;

        double quin1;
        double quin2;
        double quin3;
        double quin4;
        double quin5;
        double quin6;
        double quin7;

        double lady1;
        double lady2;
        double lady3;
        double lady4;
        double lady5;
        double lady6;
        double lady7;

        double mor1;
        double mor2;
        double mor3;
        double mor4;
        double mor5;
        double mor6;
        double mor7;

        double chester1;
        double chester2;
        double chester3;
        double chester4;
        double chester5;
        double chester6;
        double chester7;

        double radopy1;
        double radopy2;
        double radopy3;
        double radopy4;
        double radopy5;
        double radopy6;
        double radopy7;

        double stuardessa1;
        double stuardessa2;
        double stuardessa3;
        double stuardessa4;
        double stuardessa5;
        double stuardessa6;
        double stuardessa7;

        double stolichniye1;
        double stolichniye2;
        double stolichniye3;
        double stolichniye4;
        double stolichniye5;
        double stolichniye6;
        double stolichniye7;

        double donskoy1;
        double donskoy2;
        double donskoy3;
        double donskoy4;
        double donskoy5;
        double donskoy6;
        double donskoy7;

        double troyka1;
        double troyka2;
        double troyka3;
        double troyka4;
        double troyka5;
        double troyka6;
        double troyka7;

        double fast1;
        double fast2;
        double fast3;
        double fast4;
        double fast5;
        double fast6;
        double fast7;

        double royal1;
        double royal2;
        double royal3;
        double royal4;
        double royal5;
        double royal6;
        double royal7;

        double manchester1;
        double manchester2;
        double manchester3;
        double manchester4;
        double manchester5;
        double manchester6;
        double manchester7;

        double prestigue1;
        double prestigue2;
        double prestigue3;
        double prestigue4;
        double prestigue5;
        double prestigue6;
        double prestigue7;

        double premier1;
        double premier2;
        double premier3;
        double premier4;
        double premier5;
        double premier6;
        double premier7;

        double cosmos1;
        double cosmos2;
        double cosmos3;
        double cosmos4;
        double cosmos5;
        double cosmos6;
        double cosmos7;

        double next1;
        double next2;
        double next3;
        double next4;
        double next5;
        double next6;
        double next7;

        double magnat1;
        double magnat2;
        double magnat3;
        double magnat4;
        double magnat5;
        double magnat6;
        double magnat7;

        double minsk1;
        double minsk2;
        double minsk3;
        double minsk4;
        double minsk5;
        double minsk6;
        double minsk7;

        double souz1;
        double souz2;
        double souz3;
        double souz4;
        double souz5;
        double souz6;
        double souz7;


        double firstCoef;
        double secondCoef;
        double thirdCoef;
        double fourthCoef;
        double fifthCoef;
        double sixthCoef;
        double seventhCoef;

        double rentRatio1;
        double rentRatio2;
        double rentRatio3;
        double rentRatio4;
        double rentRatio5;
        double rentRatio6;
        double rentRatio7;

        double substitution1;
        double substitution2;
        double substitution3;
        double substitution4;
        double substitution5;
        double substitution6;
        double substitution7;

        double expenses;
        int count1;
        int i = 1;
        int count2;
        int j = 2;
        int count3;
        int k = 3;
        int count4;
        int l = 4;
        int count5;
        int a = 5;
        int count6;
        int s = 6;
        int count7;
        int f = 7;

        //Первый сотрудник
        for (count1 = i; count1 < 50; count1++) {
            var worker1 = service.findWorkerById(count1);
            var sigarets1 = sigaretsService.getSigaretsById(count1);
            //Второй сотрудник
            for (count2 = j; count2 < 50; count2++) {
                var worker2 = service.findWorkerById(count2);
                var sigarets2 = sigaretsService.getSigaretsById(count2);
                //Третий сотрудник
                for (count3 = k; count3 < 50; count3++) {
                    var worker3 = service.findWorkerById(count3);
                    var sigarets3 = sigaretsService.getSigaretsById(count3);
                    //Четвёртый сотрудник
                    for (count4 = l; count4 < 50; count4++) {
                        var worker4 = service.findWorkerById(count4);
                        var sigarets4 = sigaretsService.getSigaretsById(count4);
                        //}
                        //Пятый сотрудник
                        for (count5 = a; count5 < 50; count5++) {
                            var worker5 = service.findWorkerById(count5);
                            var sigarets5 = sigaretsService.getSigaretsById(count5);
                            //}
                            //Шестой сотрудник
                            for (count6 = s; count6 < 50; count6++) {
                                var worker6 = service.findWorkerById(count6);
                                var sigarets6 = sigaretsService.getSigaretsById(count6);
                                //}
                                //Седьмой сотрудник
                                for (count7 = f; count7 < 50; count7++) {
                                    var worker7 = service.findWorkerById(count7);
                                    var sigarets7 = sigaretsService.getSigaretsById(count7);
                                    //}


                                    //Процент оклада первого
                                    for (firstCoef = 1; firstCoef < 201; firstCoef++) {
                                        rentRatio1 = worker1.getRatio() * worker1.getRent();
                                        substitution1 = rentRatio1 * firstCoef / 100;

                                        bond1 = sigarets1.getBond() * substitution1;
                                        kent1 = sigarets1.getKent() * substitution1;
                                        parlament1 = sigarets1.getParlament() * substitution1;
                                        winston1 = sigarets1.getWinston() * substitution1;
                                        lm1 = sigarets1.getLm() * substitution1;
                                        malboro1 = sigarets1.getMalboro() * substitution1;
                                        rotmans1 = sigarets1.getRotmans() * substitution1;
                                        ld1 = sigarets1.getLd() * substitution1;
                                        fmorris1 = sigarets1.getFmorris() * substitution1;
                                        aliance1 = sigarets1.getAliance() * substitution1;
                                        java1 = sigarets1.getJava() * substitution1;
                                        optima1 = sigarets1.getOptima() * substitution1;
                                        petr1 = sigarets1.getPetr() * substitution1;
                                        maksim1 = sigarets1.getMaksim() * substitution1;
                                        crests1 = sigarets1.getCrests() * substitution1;
                                        vog1 = sigarets1.getVog() * substitution1;
                                        glamur1 = sigarets1.getGlamur() * substitution1;
                                        kiss1 = sigarets1.getKiss() * substitution1;
                                        esse1 = sigarets1.getEsse() * substitution1;
                                        quin1 = sigarets1.getQuin() * substitution1;
                                        lady1 = sigarets1.getLady() * substitution1;
                                        mor1 = sigarets1.getMor() * substitution1;
                                        chester1 = sigarets1.getChester() * substitution1;
                                        radopy1 = sigarets1.getRadopy() * substitution1;
                                        stuardessa1 = sigarets1.getStuardessa() * substitution1;
                                        stolichniye1 = sigarets1.getStolichniye() * substitution1;
                                        donskoy1 = sigarets1.getDonskoy() * substitution1;
                                        troyka1 = sigarets1.getTroyka() * substitution1;
                                        fast1 = sigarets1.getFast() * substitution1;
                                        royal1 = sigarets1.getRoyal() * substitution1;
                                        manchester1 = sigarets1.getManchester() * substitution1;
                                        prestigue1 = sigarets1.getPrestigue() * substitution1;
                                        premier1 = sigarets1.getPremier() * substitution1;
                                        cosmos1 = sigarets1.getCosmos() * substitution1;
                                        next1 = sigarets1.getNext() * substitution1;
                                        magnat1 = sigarets1.getMagnat() * substitution1;
                                        minsk1 = sigarets1.getMinsk() * substitution1;
                                        souz1 = sigarets1.getSouz() * substitution1;
                                        jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                                bond1, kent1, parlament1, winston1, lm1, malboro1, rotmans1,
                                                ld1, fmorris1, aliance1, java1, optima1, petr1, maksim1, crests1,
                                                vog1, glamur1, kiss1, esse1, quin1, lady1, mor1, chester1, radopy1,
                                                stuardessa1, stolichniye1, donskoy1, troyka1, fast1, royal1, manchester1,
                                                prestigue1, premier1, cosmos1, next1, magnat1, minsk1, souz1, count1);
                                        //Процент оклада второго
                                        for (secondCoef = 1; secondCoef < 201; secondCoef++) {
                                            rentRatio2 = worker2.getRatio() * worker2.getRent();
                                            substitution2 = rentRatio2 * secondCoef / 100;


                                            bond2 = sigarets2.getBond() * substitution2;
                                            kent2 = sigarets2.getKent() * substitution2;
                                            parlament2 = sigarets2.getParlament() * substitution2;
                                            winston2 = sigarets2.getWinston() * substitution2;
                                            lm2 = sigarets2.getLm() * substitution2;
                                            malboro2 = sigarets2.getMalboro() * substitution2;
                                            rotmans2 = sigarets2.getRotmans() * substitution2;
                                            ld2 = sigarets2.getLd() * substitution2;
                                            fmorris2 = sigarets2.getFmorris() * substitution2;
                                            aliance2 = sigarets2.getAliance() * substitution2;
                                            java2 = sigarets2.getJava() * substitution2;
                                            optima2 = sigarets2.getOptima() * substitution2;
                                            petr2 = sigarets2.getPetr() * substitution2;
                                            maksim2 = sigarets2.getMaksim() * substitution2;
                                            crests2 = sigarets2.getCrests() * substitution2;
                                            vog2 = sigarets2.getVog() * substitution2;
                                            glamur2 = sigarets2.getGlamur() * substitution2;
                                            kiss2 = sigarets2.getKiss() * substitution2;
                                            esse2 = sigarets2.getEsse() * substitution2;
                                            quin2 = sigarets2.getQuin() * substitution2;
                                            lady2 = sigarets2.getLady() * substitution2;
                                            mor2 = sigarets2.getMor() * substitution2;
                                            chester2 = sigarets2.getChester() * substitution2;
                                            radopy2 = sigarets2.getRadopy() * substitution2;
                                            stuardessa2 = sigarets2.getStuardessa() * substitution2;
                                            stolichniye2 = sigarets2.getStolichniye() * substitution2;
                                            donskoy2 = sigarets2.getDonskoy() * substitution2;
                                            troyka2 = sigarets2.getTroyka() * substitution2;
                                            fast2 = sigarets2.getFast() * substitution2;
                                            royal2 = sigarets2.getRoyal() * substitution2;
                                            manchester2 = sigarets2.getManchester() * substitution2;
                                            prestigue2 = sigarets2.getPrestigue() * substitution2;
                                            premier2 = sigarets2.getPremier() * substitution2;
                                            cosmos2 = sigarets2.getCosmos() * substitution2;
                                            next2 = sigarets2.getNext() * substitution2;
                                            magnat2 = sigarets2.getMagnat() * substitution2;
                                            minsk2 = sigarets2.getMinsk() * substitution2;
                                            souz2 = sigarets2.getSouz() * substitution2;
                                            jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                                    bond2, kent2, parlament2, winston2, lm2, malboro2, rotmans2,
                                                    ld2, fmorris2, aliance2, java2, optima2, petr2, maksim2, crests2,
                                                    vog2, glamur2, kiss2, esse2, quin2, lady2, mor2, chester2, radopy2,
                                                    stuardessa2, stolichniye2, donskoy2, troyka2, fast2, royal2, manchester2,
                                                    prestigue2, premier2, cosmos2, next2, magnat2, minsk2, souz2, count2);
                                            //Процент оклада третьего
                                            for (thirdCoef = 1; thirdCoef < 201; thirdCoef++) {
                                                rentRatio3 = worker3.getRatio() * worker3.getRent();
                                                substitution3 = rentRatio3 * thirdCoef / 100;
                                                expenses = substitution1 + substitution2 + substitution3;


                                                bond3 = sigarets3.getBond() * substitution3;
                                                kent3 = sigarets3.getKent() * substitution3;
                                                parlament3 = sigarets3.getParlament() * substitution3;
                                                winston3 = sigarets3.getWinston() * substitution3;
                                                lm3 = sigarets3.getLm() * substitution3;
                                                malboro3 = sigarets3.getMalboro() * substitution3;
                                                rotmans3 = sigarets3.getRotmans() * substitution3;
                                                ld3 = sigarets3.getLd() * substitution3;
                                                fmorris3 = sigarets3.getFmorris() * substitution3;
                                                aliance3 = sigarets3.getAliance() * substitution3;
                                                java3 = sigarets3.getJava() * substitution3;
                                                optima3 = sigarets3.getOptima() * substitution3;
                                                petr3 = sigarets3.getPetr() * substitution3;
                                                maksim3 = sigarets3.getMaksim() * substitution3;
                                                crests3 = sigarets3.getCrests() * substitution3;
                                                vog3 = sigarets3.getVog() * substitution3;
                                                glamur3 = sigarets3.getGlamur() * substitution3;
                                                kiss3 = sigarets3.getKiss() * substitution3;
                                                esse3 = sigarets3.getEsse() * substitution3;
                                                quin3 = sigarets3.getQuin() * substitution3;
                                                lady3 = sigarets3.getLady() * substitution3;
                                                mor3 = sigarets3.getMor() * substitution3;
                                                chester3 = sigarets3.getChester() * substitution3;
                                                radopy3 = sigarets3.getRadopy() * substitution3;
                                                stuardessa3 = sigarets3.getStuardessa() * substitution3;
                                                stolichniye3 = sigarets3.getStolichniye() * substitution3;
                                                donskoy3 = sigarets3.getDonskoy() * substitution3;
                                                troyka3 = sigarets3.getTroyka() * substitution3;
                                                fast3 = sigarets3.getFast() * substitution3;
                                                royal3 = sigarets3.getRoyal() * substitution3;
                                                manchester3 = sigarets3.getManchester() * substitution3;
                                                prestigue3 = sigarets3.getPrestigue() * substitution3;
                                                premier3 = sigarets3.getPremier() * substitution3;
                                                cosmos3 = sigarets3.getCosmos() * substitution3;
                                                next3 = sigarets3.getNext() * substitution3;
                                                magnat3 = sigarets3.getMagnat() * substitution3;
                                                minsk3 = sigarets3.getMinsk() * substitution3;
                                                souz3 = sigarets3.getSouz() * substitution3;
                                                jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                                        bond3, kent3, parlament3, winston3, lm3, malboro3, rotmans3,
                                                        ld3, fmorris3, aliance3, java3, optima3, petr3, maksim3, crests3,
                                                        vog3, glamur3, kiss3, esse3, quin3, lady3, mor3, chester3, radopy3,
                                                        stuardessa3, stolichniye3, donskoy3, troyka3, fast3, royal3, manchester3,
                                                        prestigue3, premier3, cosmos3, next3, magnat3, minsk3, souz3, count3);
                                                //Процент оклада четвёртого
                                                for (fourthCoef = 1; fourthCoef < 201; fourthCoef++) {
                                                    rentRatio4 = worker4.getRatio() * worker4.getRent();
                                                    substitution4 = rentRatio4 * fourthCoef / 100;

                                                    bond4 = sigarets4.getBond() * substitution4;
                                                    kent4 = sigarets4.getKent() * substitution4;
                                                    parlament4 = sigarets4.getParlament() * substitution4;
                                                    winston4 = sigarets4.getWinston() * substitution4;
                                                    lm4 = sigarets4.getLm() * substitution4;
                                                    malboro4 = sigarets4.getMalboro() * substitution4;
                                                    rotmans4 = sigarets4.getRotmans() * substitution4;
                                                    ld4 = sigarets4.getLd() * substitution4;
                                                    fmorris4 = sigarets4.getFmorris() * substitution4;
                                                    aliance4 = sigarets4.getAliance() * substitution4;
                                                    java4 = sigarets4.getJava() * substitution4;
                                                    optima4 = sigarets4.getOptima() * substitution4;
                                                    petr4 = sigarets4.getPetr() * substitution4;
                                                    maksim4 = sigarets4.getMaksim() * substitution4;
                                                    crests4 = sigarets4.getCrests() * substitution4;
                                                    vog4 = sigarets4.getVog() * substitution4;
                                                    glamur4 = sigarets4.getGlamur() * substitution4;
                                                    kiss4 = sigarets4.getKiss() * substitution4;
                                                    esse4 = sigarets4.getEsse() * substitution4;
                                                    quin4 = sigarets4.getQuin() * substitution4;
                                                    lady4 = sigarets4.getLady() * substitution4;
                                                    mor4 = sigarets4.getMor() * substitution4;
                                                    chester4 = sigarets4.getChester() * substitution4;
                                                    radopy4 = sigarets4.getRadopy() * substitution4;
                                                    stuardessa4 = sigarets4.getStuardessa() * substitution4;
                                                    stolichniye4 = sigarets4.getStolichniye() * substitution4;
                                                    donskoy4 = sigarets4.getDonskoy() * substitution4;
                                                    troyka4 = sigarets4.getTroyka() * substitution4;
                                                    fast4 = sigarets4.getFast() * substitution4;
                                                    royal4 = sigarets4.getRoyal() * substitution4;
                                                    manchester4 = sigarets4.getManchester() * substitution4;
                                                    prestigue4 = sigarets4.getPrestigue() * substitution4;
                                                    premier4 = sigarets4.getPremier() * substitution4;
                                                    cosmos4 = sigarets4.getCosmos() * substitution4;
                                                    next4 = sigarets4.getNext() * substitution4;
                                                    magnat4 = sigarets4.getMagnat() * substitution4;
                                                    minsk4 = sigarets4.getMinsk() * substitution4;
                                                    souz4 = sigarets4.getSouz() * substitution4;
                                                    jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                                            bond4, kent4, parlament4, winston4, lm4, malboro4, rotmans4,
                                                            ld4, fmorris4, aliance4, java4, optima4, petr4, maksim4, crests4,
                                                            vog4, glamur4, kiss4, esse4, quin4, lady4, mor4, chester4, radopy4,
                                                            stuardessa4, stolichniye4, donskoy4, troyka4, fast4, royal4, manchester4,
                                                            prestigue4, premier4, cosmos4, next4, magnat4, minsk4, souz4, count4);
                                                    //Процент оклада пятого
                                                    for (fifthCoef = 1; fifthCoef < 201; fifthCoef++) {
                                                        rentRatio5 = worker5.getRatio() * worker5.getRent();
                                                        substitution5 = rentRatio5 * fifthCoef / 100;

                                                        bond5 = sigarets5.getBond() * substitution5;
                                                        kent5 = sigarets5.getKent() * substitution5;
                                                        parlament5 = sigarets5.getParlament() * substitution5;
                                                        winston5 = sigarets5.getWinston() * substitution5;
                                                        lm5 = sigarets5.getLm() * substitution5;
                                                        malboro5 = sigarets5.getMalboro() * substitution5;
                                                        rotmans5 = sigarets5.getRotmans() * substitution5;
                                                        ld5 = sigarets5.getLd() * substitution5;
                                                        fmorris5 = sigarets5.getFmorris() * substitution5;
                                                        aliance5 = sigarets5.getAliance() * substitution5;
                                                        java5 = sigarets5.getJava() * substitution5;
                                                        optima5 = sigarets5.getOptima() * substitution5;
                                                        petr5 = sigarets5.getPetr() * substitution5;
                                                        maksim5 = sigarets5.getMaksim() * substitution5;
                                                        crests5 = sigarets5.getCrests() * substitution5;
                                                        vog5 = sigarets5.getVog() * substitution5;
                                                        glamur5 = sigarets5.getGlamur() * substitution5;
                                                        kiss5 = sigarets5.getKiss() * substitution5;
                                                        esse5 = sigarets5.getEsse() * substitution5;
                                                        quin5 = sigarets5.getQuin() * substitution5;
                                                        lady5 = sigarets5.getLady() * substitution5;
                                                        mor5 = sigarets5.getMor() * substitution5;
                                                        chester5 = sigarets5.getChester() * substitution5;
                                                        radopy5 = sigarets5.getRadopy() * substitution5;
                                                        stuardessa5 = sigarets5.getStuardessa() * substitution5;
                                                        stolichniye5 = sigarets5.getStolichniye() * substitution5;
                                                        donskoy5 = sigarets5.getDonskoy() * substitution5;
                                                        troyka5 = sigarets5.getTroyka() * substitution5;
                                                        fast5 = sigarets5.getFast() * substitution5;
                                                        royal5 = sigarets5.getRoyal() * substitution5;
                                                        manchester5 = sigarets5.getManchester() * substitution5;
                                                        prestigue5 = sigarets5.getPrestigue() * substitution5;
                                                        premier5 = sigarets5.getPremier() * substitution5;
                                                        cosmos5 = sigarets5.getCosmos() * substitution5;
                                                        next5 = sigarets5.getNext() * substitution5;
                                                        magnat5 = sigarets5.getMagnat() * substitution5;
                                                        minsk5 = sigarets5.getMinsk() * substitution5;
                                                        souz5 = sigarets5.getSouz() * substitution5;
                                                        jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                                                bond5, kent5, parlament5, winston5, lm5, malboro5, rotmans5,
                                                                ld5, fmorris5, aliance5, java5, optima5, petr5, maksim5, crests5,
                                                                vog5, glamur5, kiss5, esse5, quin5, lady5, mor5, chester5, radopy5,
                                                                stuardessa5, stolichniye5, donskoy5, troyka5, fast5, royal5, manchester5,
                                                                prestigue5, premier5, cosmos5, next5, magnat5, minsk5, souz5, count5);
                                                        //Процент оклада шестого
                                                        for (sixthCoef = 1; sixthCoef < 201; sixthCoef++) {
                                                            rentRatio6 = worker6.getRatio() * worker6.getRent();
                                                            substitution6 = rentRatio6 * sixthCoef / 100;

                                                            bond6 = sigarets6.getBond() * substitution6;
                                                            kent6 = sigarets6.getKent() * substitution6;
                                                            parlament6 = sigarets6.getParlament() * substitution6;
                                                            winston6 = sigarets6.getWinston() * substitution6;
                                                            lm6 = sigarets6.getLm() * substitution6;
                                                            malboro6 = sigarets6.getMalboro() * substitution6;
                                                            rotmans6 = sigarets6.getRotmans() * substitution6;
                                                            ld6 = sigarets6.getLd() * substitution6;
                                                            fmorris6 = sigarets6.getFmorris() * substitution6;
                                                            aliance6 = sigarets6.getAliance() * substitution6;
                                                            java6 = sigarets6.getJava() * substitution6;
                                                            optima6 = sigarets6.getOptima() * substitution6;
                                                            petr6 = sigarets6.getPetr() * substitution6;
                                                            maksim6 = sigarets6.getMaksim() * substitution6;
                                                            crests6 = sigarets6.getCrests() * substitution6;
                                                            vog6 = sigarets6.getVog() * substitution6;
                                                            glamur6 = sigarets6.getGlamur() * substitution6;
                                                            kiss6 = sigarets6.getKiss() * substitution6;
                                                            esse6 = sigarets6.getEsse() * substitution6;
                                                            quin6 = sigarets6.getQuin() * substitution6;
                                                            lady6 = sigarets6.getLady() * substitution6;
                                                            mor6 = sigarets6.getMor() * substitution6;
                                                            chester6 = sigarets6.getChester() * substitution6;
                                                            radopy6 = sigarets6.getRadopy() * substitution6;
                                                            stuardessa6 = sigarets6.getStuardessa() * substitution6;
                                                            stolichniye6 = sigarets6.getStolichniye() * substitution6;
                                                            donskoy6 = sigarets6.getDonskoy() * substitution6;
                                                            troyka6 = sigarets6.getTroyka() * substitution6;
                                                            fast6 = sigarets6.getFast() * substitution6;
                                                            royal6 = sigarets6.getRoyal() * substitution6;
                                                            manchester6 = sigarets6.getManchester() * substitution6;
                                                            prestigue6 = sigarets6.getPrestigue() * substitution6;
                                                            premier6 = sigarets6.getPremier() * substitution6;
                                                            cosmos6 = sigarets6.getCosmos() * substitution6;
                                                            next6 = sigarets6.getNext() * substitution6;
                                                            magnat6 = sigarets6.getMagnat() * substitution6;
                                                            minsk6 = sigarets6.getMinsk() * substitution6;
                                                            souz6 = sigarets6.getSouz() * substitution6;
                                                            jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                                                    bond6, kent6, parlament6, winston6, lm6, malboro6, rotmans6,
                                                                    ld6, fmorris6, aliance6, java6, optima6, petr6, maksim6, crests6,
                                                                    vog6, glamur6, kiss6, esse6, quin6, lady6, mor6, chester6, radopy6,
                                                                    stuardessa6, stolichniye6, donskoy6, troyka6, fast6, royal6, manchester6,
                                                                    prestigue6, premier6, cosmos6, next6, magnat6, minsk6, souz6, count6);
                                                            //Процент оклада седьмого
                                                            for (seventhCoef = 1; seventhCoef < 201; seventhCoef++) {
                                                                rentRatio7 = worker7.getRatio() * worker7.getRent();
                                                                substitution7 = rentRatio7 * seventhCoef / 100;

                                                                bond7 = sigarets7.getBond() * substitution7;
                                                                kent7 = sigarets7.getKent() * substitution7;
                                                                parlament7 = sigarets7.getParlament() * substitution7;
                                                                winston7 = sigarets7.getWinston() * substitution7;
                                                                lm7 = sigarets7.getLm() * substitution7;
                                                                malboro7 = sigarets7.getMalboro() * substitution7;
                                                                rotmans7 = sigarets7.getRotmans() * substitution7;
                                                                ld7 = sigarets7.getLd() * substitution7;
                                                                fmorris7 = sigarets7.getFmorris() * substitution7;
                                                                aliance7 = sigarets7.getAliance() * substitution7;
                                                                java7 = sigarets7.getJava() * substitution7;
                                                                optima7 = sigarets7.getOptima() * substitution7;
                                                                petr7 = sigarets7.getPetr() * substitution7;
                                                                maksim7 = sigarets7.getMaksim() * substitution7;
                                                                crests7 = sigarets7.getCrests() * substitution7;
                                                                vog7 = sigarets7.getVog() * substitution7;
                                                                glamur7 = sigarets7.getGlamur() * substitution7;
                                                                kiss7 = sigarets7.getKiss() * substitution7;
                                                                esse7 = sigarets7.getEsse() * substitution7;
                                                                quin7 = sigarets7.getQuin() * substitution7;
                                                                lady7 = sigarets7.getLady() * substitution7;
                                                                mor7 = sigarets7.getMor() * substitution7;
                                                                chester7 = sigarets7.getChester() * substitution7;
                                                                radopy7 = sigarets7.getRadopy() * substitution7;
                                                                stuardessa7 = sigarets7.getStuardessa() * substitution7;
                                                                stolichniye7 = sigarets7.getStolichniye() * substitution7;
                                                                donskoy7 = sigarets7.getDonskoy() * substitution7;
                                                                troyka7 = sigarets7.getTroyka() * substitution7;
                                                                fast7 = sigarets7.getFast() * substitution7;
                                                                royal7 = sigarets7.getRoyal() * substitution7;
                                                                manchester7 = sigarets7.getManchester() * substitution7;
                                                                prestigue7 = sigarets7.getPrestigue() * substitution7;
                                                                premier7 = sigarets7.getPremier() * substitution7;
                                                                cosmos7 = sigarets7.getCosmos() * substitution7;
                                                                next7 = sigarets7.getNext() * substitution7;
                                                                magnat7 = sigarets7.getMagnat() * substitution7;
                                                                minsk7 = sigarets7.getMinsk() * substitution7;
                                                                souz7 = sigarets7.getSouz() * substitution7;
                                                                jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                                                        bond7, kent7, parlament7, winston7, lm7, malboro7, rotmans7,
                                                                        ld7, fmorris7, aliance7, java7, optima7, petr7, maksim7, crests7,
                                                                        vog7, glamur7, kiss7, esse7, quin7, lady7, mor7, chester7, radopy7,
                                                                        stuardessa7, stolichniye7, donskoy7, troyka7, fast7, royal7, manchester7,
                                                                        prestigue7, premier7, cosmos7, next7, magnat7, minsk7, souz7, count7);


                                                                double sumBond = bond1 + bond2 + bond3 + bond4 + bond5 + bond6 + bond7;
                                                                double sumKent = kent1 + kent2 + kent3 + kent4 + kent5 + kent6 + kent7;
                                                                double sumParlament = parlament1 + parlament2 + parlament3 + parlament4 + parlament5 + parlament6 + parlament7;
                                                                double sumWinston = winston1 + winston2 + winston3 + winston4 + winston5 + winston6 + winston7;
                                                                double sumLm = lm1 + lm2 + lm3 + lm4 + lm5 + lm6 + lm7;
                                                                double sumMalboro = malboro1 + malboro2 + malboro3 + malboro4 + malboro5 + malboro6 + malboro7;
                                                                double sumRotmans = rotmans1 + rotmans2 + rotmans3 + rotmans4 + rotmans5 + rotmans6 + rotmans7;
                                                                double sumLd = ld1 + ld2 + ld3 + ld4 + ld5 + ld6 + ld7;
                                                                double sumFmorris = fmorris1 + fmorris2 + fmorris3 + fmorris4 + fmorris5 + fmorris6 + fmorris7;
                                                                double sumAliance = aliance1 + aliance2 + aliance3 + aliance4 + aliance5 + aliance6 + aliance7;
                                                                double sumJava = java1 + java2 + java3 + java4 + java5 + java6 + java7;
                                                                double sumOptima = optima1 + optima2 + optima3 + optima4 + optima5 + optima6 + optima7;
                                                                double sumPetr = petr1 + petr2 + petr3 + petr4 + petr5 + petr6 + petr7;
                                                                double sumMaksim = maksim1 + maksim2 + maksim3 + maksim4 + maksim5 + maksim6 + maksim7;
                                                                double sumCrests = crests1 + crests2 + crests3 + crests4 + crests5 + crests6 + crests7;
                                                                double sumVog = vog1 + vog2 + vog3 + vog4 + vog5 + vog6 + vog7;
                                                                double sumGlamur = glamur1 + glamur2 + glamur3 + glamur4 + glamur5 + glamur6 + glamur7;
                                                                double sumKiss = kiss1 + kiss2 + kiss3 + kiss4 + kiss5 + kiss6 + kiss7;
                                                                double sumEsse = esse1 + esse2 + esse3 + esse4 + esse5 + esse6 + esse7;
                                                                double sumQuin = quin1 + quin2 + quin3 + quin4 + quin5 + quin6 + quin7;
                                                                double sumLady = lady1 + lady2 + lady3 + lady4 + lady5 + lady6 + lady7;
                                                                double sumMor = mor1 + mor2 + mor3 + mor4 + mor5 + mor6 + mor7;
                                                                double sumChester = chester1 + chester2 + chester3 + chester4 + chester5 + chester6 + chester7;
                                                                double sumRadopy = radopy1 + radopy2 + radopy3 + radopy4 + radopy5 + radopy6 + radopy7;
                                                                double sumStuardessa = stuardessa1 + stuardessa2 + stuardessa3 + stuardessa4 + stuardessa5 + stuardessa6 + stuardessa7;
                                                                double sumStolichniye = stolichniye1 + stolichniye2 + stolichniye3 + stolichniye4 + stolichniye5 + stolichniye6 + stolichniye7;
                                                                double sumDonskoy = donskoy1 + donskoy2 + donskoy3 + donskoy4 + donskoy5 + donskoy6 + donskoy7;
                                                                double sumTroyka = troyka1 + troyka2 + troyka3 + troyka4 + troyka5 + troyka6 + troyka7;
                                                                double sumFast = fast1 + fast2 + fast3 + fast4 + fast5 + fast6 + fast7;
                                                                double sumRoyal = royal1 + royal2 + royal3 + royal4 + royal5 + royal6 + royal7;
                                                                double sumManchester = manchester1 + manchester2 + manchester3 + manchester4 + manchester5 + manchester6 + manchester7;
                                                                double sumPrestigue = prestigue1 + prestigue2 + prestigue3 + prestigue4 + prestigue5 + prestigue6 + prestigue7;
                                                                double sumPremier = premier1 + premier2 + premier3 + premier4 + premier5 + premier6 + premier7;
                                                                double sumCosmos = cosmos1 + cosmos2 + cosmos3 + cosmos4 + cosmos5 + cosmos6 + cosmos7;
                                                                double sumNext = next1 + next2 + next3 + next4 + next5 + next6 + next7;
                                                                double sumMagnat = magnat1 + magnat2 + magnat3 + magnat4 + magnat5 + magnat6 + magnat7;
                                                                double sumMinsk = minsk1 + minsk2 + minsk3 + minsk4 + minsk5 + minsk6 + minsk7;
                                                                double sumSouz = souz1 + souz2 + souz3 + souz4 + souz5 + souz6 + souz7;

                                                                expenses = substitution1 + substitution2 + substitution3
                                                                        + substitution4 + substitution5 + substitution6 + substitution7;


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

                                                                double expenses100 = expenses * 100;

                                                                double coefBond = resultBond / expenses100;
                                                                double coefKent = resultKent / expenses100;
                                                                double coefParlament = resultParlament / expenses100;
                                                                double coefWinston = resultWinston / expenses100;
                                                                double coefLm = resultLm / expenses100;
                                                                double coefMalboro = resultMalboro / expenses100;
                                                                double coefRotmans = resultRotmans / expenses100;
                                                                double coefLd = resultLd / expenses100;
                                                                double coefFmorris = resultFmorris / expenses100;
                                                                double coefAliance = resultAliance / expenses100;
                                                                double coefJava = resultJava / expenses100;
                                                                double coefOptima = resultOptima / expenses100;
                                                                double coefPetr = resultPetr / expenses100;
                                                                double coefMaksim = resultMaksim / expenses100;
                                                                double coefCrests = resultCrests / expenses100;
                                                                double coefVog = resultVog / expenses100;
                                                                double coefGlamur = resultGlamur / expenses100;
                                                                double coefKiss = resultKiss / expenses100;
                                                                double coefEsse = resultEsse / expenses100;
                                                                double coefQuin = resultQuin / expenses100;
                                                                double coefLady = resultLady / expenses100;
                                                                double coefMor = resultMor / expenses100;
                                                                double coefChester = resultChester / expenses100;
                                                                double coefRadopy = resultRadopy / expenses100;
                                                                double coefStuardessa = resultStuardessa / expenses100;
                                                                double coefStolichniye = resultStolichniye / expenses100;
                                                                double coefDonskoy = resultDonskoy / expenses100;
                                                                double coefTroyka = resultTroyka / expenses100;
                                                                double coefFast = resultFast / expenses100;
                                                                double coefRoyal = resultRoyal / expenses100;
                                                                double coefManchester = resultManchester / expenses100;
                                                                double coefPrestigue = resultPrestigue / expenses100;
                                                                double coefPremier = resultPremier / expenses100;
                                                                double coefCosmos = resultCosmos / expenses100;
                                                                double coefNext = resultNext / expenses100;
                                                                double coefMagnat = resultMagnat / expenses100;
                                                                double coefMinsk = resultMinsk / expenses100;
                                                                double coefSouz = resultSouz / expenses100;

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
                                                                                                                                                                                                                        jdbcTemplate.update(SAVE_BEST_GROUP7,
                                                                                                                                                                                                                                worker1.getWorkerId(),
                                                                                                                                                                                                                                worker2.getWorkerId(),
                                                                                                                                                                                                                                worker3.getWorkerId(),
                                                                                                                                                                                                                                worker4.getWorkerId(),
                                                                                                                                                                                                                                worker5.getWorkerId(),
                                                                                                                                                                                                                                worker6.getWorkerId(),
                                                                                                                                                                                                                                worker7.getWorkerId(),

                                                                                                                                                                                                                                firstCoef,
                                                                                                                                                                                                                                secondCoef,
                                                                                                                                                                                                                                thirdCoef,
                                                                                                                                                                                                                                fourthCoef,
                                                                                                                                                                                                                                fifthCoef,
                                                                                                                                                                                                                                sixthCoef,
                                                                                                                                                                                                                                seventhCoef,

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
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            i++;
            j++;
            k++;
            l++;
            a++;
            s++;
            f++;
        }
        getTiming();
    }

    public void saveBestGroup8() {
        Date date = new Date();
        System.out.println("Рассчёт группы из 8" + date.toString());
        var parameters = paramsService.findParamsById(1);
        double bond1;
        double bond2;
        double bond3;
        double bond4;
        double bond5;
        double bond6;
        double bond7;
        double bond8;
        double kent1;
        double kent2;
        double kent3;
        double kent4;
        double kent5;
        double kent6;
        double kent7;
        double kent8;
        double winston1;
        double winston2;
        double winston3;
        double winston4;
        double winston5;
        double winston6;
        double winston7;
        double winston8;
        double parlament1;
        double parlament2;
        double parlament3;
        double parlament4;
        double parlament5;
        double parlament6;
        double parlament7;
        double parlament8;
        double lm1;
        double lm2;
        double lm3;
        double lm4;
        double lm5;
        double lm6;
        double lm7;
        double lm8;
        double malboro1;
        double malboro2;
        double malboro3;
        double malboro4;
        double malboro5;
        double malboro6;
        double malboro7;
        double malboro8;
        double rotmans1;
        double rotmans2;
        double rotmans3;
        double rotmans4;
        double rotmans5;
        double rotmans6;
        double rotmans7;
        double rotmans8;
        double ld1;
        double ld2;
        double ld3;
        double ld4;
        double ld5;
        double ld6;
        double ld7;
        double ld8;
        double fmorris1;
        double fmorris2;
        double fmorris3;
        double fmorris4;
        double fmorris5;
        double fmorris6;
        double fmorris7;
        double fmorris8;
        double aliance1;
        double aliance2;
        double aliance3;
        double aliance4;
        double aliance5;
        double aliance6;
        double aliance7;
        double aliance8;
        double java1;
        double java2;
        double java3;
        double java4;
        double java5;
        double java6;
        double java7;
        double java8;
        double optima1;
        double optima2;
        double optima3;
        double optima4;
        double optima5;
        double optima6;
        double optima7;
        double optima8;
        double petr1;
        double petr2;
        double petr3;
        double petr4;
        double petr5;
        double petr6;
        double petr7;
        double petr8;
        double maksim1;
        double maksim2;
        double maksim3;
        double maksim4;
        double maksim5;
        double maksim6;
        double maksim7;
        double maksim8;
        double crests1;
        double crests2;
        double crests3;
        double crests4;
        double crests5;
        double crests6;
        double crests7;
        double crests8;
        double vog1;
        double vog2;
        double vog3;
        double vog4;
        double vog5;
        double vog6;
        double vog7;
        double vog8;
        double glamur1;
        double glamur2;
        double glamur3;
        double glamur4;
        double glamur5;
        double glamur6;
        double glamur7;
        double glamur8;
        double esse1;
        double esse2;
        double esse3;
        double esse4;
        double esse5;
        double esse6;
        double esse7;
        double esse8;
        double kiss1;
        double kiss2;
        double kiss3;
        double kiss4;
        double kiss5;
        double kiss6;
        double kiss7;
        double kiss8;
        double quin1;
        double quin2;
        double quin3;
        double quin4;
        double quin5;
        double quin6;
        double quin7;
        double quin8;
        double lady1;
        double lady2;
        double lady3;
        double lady4;
        double lady5;
        double lady6;
        double lady7;
        double lady8;
        double mor1;
        double mor2;
        double mor3;
        double mor4;
        double mor5;
        double mor6;
        double mor7;
        double mor8;
        double chester1;
        double chester2;
        double chester3;
        double chester4;
        double chester5;
        double chester6;
        double chester7;
        double chester8;
        double radopy1;
        double radopy2;
        double radopy3;
        double radopy4;
        double radopy5;
        double radopy6;
        double radopy7;
        double radopy8;
        double stuardessa1;
        double stuardessa2;
        double stuardessa3;
        double stuardessa4;
        double stuardessa5;
        double stuardessa6;
        double stuardessa7;
        double stuardessa8;
        double stolichniye1;
        double stolichniye2;
        double stolichniye3;
        double stolichniye4;
        double stolichniye5;
        double stolichniye6;
        double stolichniye7;
        double stolichniye8;
        double donskoy1;
        double donskoy2;
        double donskoy3;
        double donskoy4;
        double donskoy5;
        double donskoy6;
        double donskoy7;
        double donskoy8;
        double troyka1;
        double troyka2;
        double troyka3;
        double troyka4;
        double troyka5;
        double troyka6;
        double troyka7;
        double troyka8;
        double fast1;
        double fast2;
        double fast3;
        double fast4;
        double fast5;
        double fast6;
        double fast7;
        double fast8;
        double royal1;
        double royal2;
        double royal3;
        double royal4;
        double royal5;
        double royal6;
        double royal7;
        double royal8;
        double manchester1;
        double manchester2;
        double manchester3;
        double manchester4;
        double manchester5;
        double manchester6;
        double manchester7;
        double manchester8;
        double prestigue1;
        double prestigue2;
        double prestigue3;
        double prestigue4;
        double prestigue5;
        double prestigue6;
        double prestigue7;
        double prestigue8;
        double premier1;
        double premier2;
        double premier3;
        double premier4;
        double premier5;
        double premier6;
        double premier7;
        double premier8;
        double cosmos1;
        double cosmos2;
        double cosmos3;
        double cosmos4;
        double cosmos5;
        double cosmos6;
        double cosmos7;
        double cosmos8;
        double next1;
        double next2;
        double next3;
        double next4;
        double next5;
        double next6;
        double next7;
        double next8;
        double magnat1;
        double magnat2;
        double magnat3;
        double magnat4;
        double magnat5;
        double magnat6;
        double magnat7;
        double magnat8;
        double minsk1;
        double minsk2;
        double minsk3;
        double minsk4;
        double minsk5;
        double minsk6;
        double minsk7;
        double minsk8;
        double souz1;
        double souz2;
        double souz3;
        double souz4;
        double souz5;
        double souz6;
        double souz7;
        double souz8;

        double firstCoef;
        double secondCoef;
        double thirdCoef;
        double fourthCoef;
        double fifthCoef;
        double sixthCoef;
        double seventhCoef;
        double eighthCoef;
        double rentRatio1;
        double rentRatio2;
        double rentRatio3;
        double rentRatio4;
        double rentRatio5;
        double rentRatio6;
        double rentRatio7;
        double rentRatio8;
        double substitution1;
        double substitution2;
        double substitution3;
        double substitution4;
        double substitution5;
        double substitution6;
        double substitution7;
        double substitution8;
        double expenses;
        int count1;
        int i = 1;
        int count2;
        int j = 2;
        int count3;
        int k = 3;
        int count4;
        int l = 4;
        int count5;
        int a = 5;
        int count6;
        int s = 6;
        int count7;
        int f = 7;
        int count8;
        int g = 8;
        //Первый сотрудник
        for (count1 = i; count1 < 50; count1++) {
            var worker1 = service.findWorkerById(count1);
            var sigarets1 = sigaretsService.getSigaretsById(count1);
            //Второй сотрудник
            for (count2 = j; count2 < 50; count2++) {
                var worker2 = service.findWorkerById(count2);
                var sigarets2 = sigaretsService.getSigaretsById(count2);
                //Третий сотрудник
                for (count3 = k; count3 < 50; count3++) {
                    var worker3 = service.findWorkerById(count3);
                    var sigarets3 = sigaretsService.getSigaretsById(count3);
                    //Четвёртый сотрудник
                    for (count4 = l; count4 < 50; count4++) {
                        var worker4 = service.findWorkerById(count4);
                        var sigarets4 = sigaretsService.getSigaretsById(count4);
                        //}
                        //Пятый сотрудник
                        for (count5 = a; count5 < 50; count5++) {
                            var worker5 = service.findWorkerById(count5);
                            var sigarets5 = sigaretsService.getSigaretsById(count5);
                            //}
                            //Шестой сотрудник
                            for (count6 = s; count6 < 50; count6++) {
                                var worker6 = service.findWorkerById(count6);
                                var sigarets6 = sigaretsService.getSigaretsById(count6);
                                //}
                                //Седьмой сотрудник
                                for (count7 = f; count7 < 50; count7++) {
                                    var worker7 = service.findWorkerById(count7);
                                    var sigarets7 = sigaretsService.getSigaretsById(count7);
                                    //}
                                    //Восьмой сотрудник
                                    for (count8 = g; count8 < 50; count8++) {
                                        var worker8 = service.findWorkerById(count8);
                                        var sigarets8 = sigaretsService.getSigaretsById(count8);
                                        //}
                                        //Процент оклада первого
                                        for (firstCoef = 1; firstCoef < 201; firstCoef++) {
                                            rentRatio1 = worker1.getRatio() * worker1.getRent();
                                            substitution1 = rentRatio1 * firstCoef / 100;

                                            bond1 = sigarets1.getBond() * substitution1;
                                            kent1 = sigarets1.getKent() * substitution1;
                                            parlament1 = sigarets1.getParlament() * substitution1;
                                            winston1 = sigarets1.getWinston() * substitution1;
                                            lm1 = sigarets1.getLm() * substitution1;
                                            malboro1 = sigarets1.getMalboro() * substitution1;
                                            rotmans1 = sigarets1.getRotmans() * substitution1;
                                            ld1 = sigarets1.getLd() * substitution1;
                                            fmorris1 = sigarets1.getFmorris() * substitution1;
                                            aliance1 = sigarets1.getAliance() * substitution1;
                                            java1 = sigarets1.getJava() * substitution1;
                                            optima1 = sigarets1.getOptima() * substitution1;
                                            petr1 = sigarets1.getPetr() * substitution1;
                                            maksim1 = sigarets1.getMaksim() * substitution1;
                                            crests1 = sigarets1.getCrests() * substitution1;
                                            vog1 = sigarets1.getVog() * substitution1;
                                            glamur1 = sigarets1.getGlamur() * substitution1;
                                            kiss1 = sigarets1.getKiss() * substitution1;
                                            esse1 = sigarets1.getEsse() * substitution1;
                                            quin1 = sigarets1.getQuin() * substitution1;
                                            lady1 = sigarets1.getLady() * substitution1;
                                            mor1 = sigarets1.getMor() * substitution1;
                                            chester1 = sigarets1.getChester() * substitution1;
                                            radopy1 = sigarets1.getRadopy() * substitution1;
                                            stuardessa1 = sigarets1.getStuardessa() * substitution1;
                                            stolichniye1 = sigarets1.getStolichniye() * substitution1;
                                            donskoy1 = sigarets1.getDonskoy() * substitution1;
                                            troyka1 = sigarets1.getTroyka() * substitution1;
                                            fast1 = sigarets1.getFast() * substitution1;
                                            royal1 = sigarets1.getRoyal() * substitution1;
                                            manchester1 = sigarets1.getManchester() * substitution1;
                                            prestigue1 = sigarets1.getPrestigue() * substitution1;
                                            premier1 = sigarets1.getPremier() * substitution1;
                                            cosmos1 = sigarets1.getCosmos() * substitution1;
                                            next1 = sigarets1.getNext() * substitution1;
                                            magnat1 = sigarets1.getMagnat() * substitution1;
                                            minsk1 = sigarets1.getMinsk() * substitution1;
                                            souz1 = sigarets1.getSouz() * substitution1;
                                            jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                                    bond1, kent1, parlament1, winston1, lm1, malboro1, rotmans1,
                                                    ld1, fmorris1, aliance1, java1, optima1, petr1, maksim1, crests1,
                                                    vog1, glamur1, kiss1, esse1, quin1, lady1, mor1, chester1, radopy1,
                                                    stuardessa1, stolichniye1, donskoy1, troyka1, fast1, royal1, manchester1,
                                                    prestigue1, premier1, cosmos1, next1, magnat1, minsk1, souz1, count1);
                                            //Процент оклада второго
                                            for (secondCoef = 1; secondCoef < 201; secondCoef++) {
                                                rentRatio2 = worker2.getRatio() * worker2.getRent();
                                                substitution2 = rentRatio2 * secondCoef / 100;


                                                bond2 = sigarets2.getBond() * substitution2;
                                                kent2 = sigarets2.getKent() * substitution2;
                                                parlament2 = sigarets2.getParlament() * substitution2;
                                                winston2 = sigarets2.getWinston() * substitution2;
                                                lm2 = sigarets2.getLm() * substitution2;
                                                malboro2 = sigarets2.getMalboro() * substitution2;
                                                rotmans2 = sigarets2.getRotmans() * substitution2;
                                                ld2 = sigarets2.getLd() * substitution2;
                                                fmorris2 = sigarets2.getFmorris() * substitution2;
                                                aliance2 = sigarets2.getAliance() * substitution2;
                                                java2 = sigarets2.getJava() * substitution2;
                                                optima2 = sigarets2.getOptima() * substitution2;
                                                petr2 = sigarets2.getPetr() * substitution2;
                                                maksim2 = sigarets2.getMaksim() * substitution2;
                                                crests2 = sigarets2.getCrests() * substitution2;
                                                vog2 = sigarets2.getVog() * substitution2;
                                                glamur2 = sigarets2.getGlamur() * substitution2;
                                                kiss2 = sigarets2.getKiss() * substitution2;
                                                esse2 = sigarets2.getEsse() * substitution2;
                                                quin2 = sigarets2.getQuin() * substitution2;
                                                lady2 = sigarets2.getLady() * substitution2;
                                                mor2 = sigarets2.getMor() * substitution2;
                                                chester2 = sigarets2.getChester() * substitution2;
                                                radopy2 = sigarets2.getRadopy() * substitution2;
                                                stuardessa2 = sigarets2.getStuardessa() * substitution2;
                                                stolichniye2 = sigarets2.getStolichniye() * substitution2;
                                                donskoy2 = sigarets2.getDonskoy() * substitution2;
                                                troyka2 = sigarets2.getTroyka() * substitution2;
                                                fast2 = sigarets2.getFast() * substitution2;
                                                royal2 = sigarets2.getRoyal() * substitution2;
                                                manchester2 = sigarets2.getManchester() * substitution2;
                                                prestigue2 = sigarets2.getPrestigue() * substitution2;
                                                premier2 = sigarets2.getPremier() * substitution2;
                                                cosmos2 = sigarets2.getCosmos() * substitution2;
                                                next2 = sigarets2.getNext() * substitution2;
                                                magnat2 = sigarets2.getMagnat() * substitution2;
                                                minsk2 = sigarets2.getMinsk() * substitution2;
                                                souz2 = sigarets2.getSouz() * substitution2;
                                                jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                                        bond2, kent2, parlament2, winston2, lm2, malboro2, rotmans2,
                                                        ld2, fmorris2, aliance2, java2, optima2, petr2, maksim2, crests2,
                                                        vog2, glamur2, kiss2, esse2, quin2, lady2, mor2, chester2, radopy2,
                                                        stuardessa2, stolichniye2, donskoy2, troyka2, fast2, royal2, manchester2,
                                                        prestigue2, premier2, cosmos2, next2, magnat2, minsk2, souz2, count2);
                                                //Процент оклада третьего
                                                for (thirdCoef = 1; thirdCoef < 201; thirdCoef++) {
                                                    rentRatio3 = worker3.getRatio() * worker3.getRent();
                                                    substitution3 = rentRatio3 * thirdCoef / 100;
                                                    expenses = substitution1 + substitution2 + substitution3;


                                                    bond3 = sigarets3.getBond() * substitution3;
                                                    kent3 = sigarets3.getKent() * substitution3;
                                                    parlament3 = sigarets3.getParlament() * substitution3;
                                                    winston3 = sigarets3.getWinston() * substitution3;
                                                    lm3 = sigarets3.getLm() * substitution3;
                                                    malboro3 = sigarets3.getMalboro() * substitution3;
                                                    rotmans3 = sigarets3.getRotmans() * substitution3;
                                                    ld3 = sigarets3.getLd() * substitution3;
                                                    fmorris3 = sigarets3.getFmorris() * substitution3;
                                                    aliance3 = sigarets3.getAliance() * substitution3;
                                                    java3 = sigarets3.getJava() * substitution3;
                                                    optima3 = sigarets3.getOptima() * substitution3;
                                                    petr3 = sigarets3.getPetr() * substitution3;
                                                    maksim3 = sigarets3.getMaksim() * substitution3;
                                                    crests3 = sigarets3.getCrests() * substitution3;
                                                    vog3 = sigarets3.getVog() * substitution3;
                                                    glamur3 = sigarets3.getGlamur() * substitution3;
                                                    kiss3 = sigarets3.getKiss() * substitution3;
                                                    esse3 = sigarets3.getEsse() * substitution3;
                                                    quin3 = sigarets3.getQuin() * substitution3;
                                                    lady3 = sigarets3.getLady() * substitution3;
                                                    mor3 = sigarets3.getMor() * substitution3;
                                                    chester3 = sigarets3.getChester() * substitution3;
                                                    radopy3 = sigarets3.getRadopy() * substitution3;
                                                    stuardessa3 = sigarets3.getStuardessa() * substitution3;
                                                    stolichniye3 = sigarets3.getStolichniye() * substitution3;
                                                    donskoy3 = sigarets3.getDonskoy() * substitution3;
                                                    troyka3 = sigarets3.getTroyka() * substitution3;
                                                    fast3 = sigarets3.getFast() * substitution3;
                                                    royal3 = sigarets3.getRoyal() * substitution3;
                                                    manchester3 = sigarets3.getManchester() * substitution3;
                                                    prestigue3 = sigarets3.getPrestigue() * substitution3;
                                                    premier3 = sigarets3.getPremier() * substitution3;
                                                    cosmos3 = sigarets3.getCosmos() * substitution3;
                                                    next3 = sigarets3.getNext() * substitution3;
                                                    magnat3 = sigarets3.getMagnat() * substitution3;
                                                    minsk3 = sigarets3.getMinsk() * substitution3;
                                                    souz3 = sigarets3.getSouz() * substitution3;
                                                    jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                                            bond3, kent3, parlament3, winston3, lm3, malboro3, rotmans3,
                                                            ld3, fmorris3, aliance3, java3, optima3, petr3, maksim3, crests3,
                                                            vog3, glamur3, kiss3, esse3, quin3, lady3, mor3, chester3, radopy3,
                                                            stuardessa3, stolichniye3, donskoy3, troyka3, fast3, royal3, manchester3,
                                                            prestigue3, premier3, cosmos3, next3, magnat3, minsk3, souz3, count3);
                                                    //Процент оклада четвёртого
                                                    for (fourthCoef = 1; fourthCoef < 201; fourthCoef++) {
                                                        rentRatio4 = worker4.getRatio() * worker4.getRent();
                                                        substitution4 = rentRatio4 * fourthCoef / 100;

                                                        bond4 = sigarets4.getBond() * substitution4;
                                                        kent4 = sigarets4.getKent() * substitution4;
                                                        parlament4 = sigarets4.getParlament() * substitution4;
                                                        winston4 = sigarets4.getWinston() * substitution4;
                                                        lm4 = sigarets4.getLm() * substitution4;
                                                        malboro4 = sigarets4.getMalboro() * substitution4;
                                                        rotmans4 = sigarets4.getRotmans() * substitution4;
                                                        ld4 = sigarets4.getLd() * substitution4;
                                                        fmorris4 = sigarets4.getFmorris() * substitution4;
                                                        aliance4 = sigarets4.getAliance() * substitution4;
                                                        java4 = sigarets4.getJava() * substitution4;
                                                        optima4 = sigarets4.getOptima() * substitution4;
                                                        petr4 = sigarets4.getPetr() * substitution4;
                                                        maksim4 = sigarets4.getMaksim() * substitution4;
                                                        crests4 = sigarets4.getCrests() * substitution4;
                                                        vog4 = sigarets4.getVog() * substitution4;
                                                        glamur4 = sigarets4.getGlamur() * substitution4;
                                                        kiss4 = sigarets4.getKiss() * substitution4;
                                                        esse4 = sigarets4.getEsse() * substitution4;
                                                        quin4 = sigarets4.getQuin() * substitution4;
                                                        lady4 = sigarets4.getLady() * substitution4;
                                                        mor4 = sigarets4.getMor() * substitution4;
                                                        chester4 = sigarets4.getChester() * substitution4;
                                                        radopy4 = sigarets4.getRadopy() * substitution4;
                                                        stuardessa4 = sigarets4.getStuardessa() * substitution4;
                                                        stolichniye4 = sigarets4.getStolichniye() * substitution4;
                                                        donskoy4 = sigarets4.getDonskoy() * substitution4;
                                                        troyka4 = sigarets4.getTroyka() * substitution4;
                                                        fast4 = sigarets4.getFast() * substitution4;
                                                        royal4 = sigarets4.getRoyal() * substitution4;
                                                        manchester4 = sigarets4.getManchester() * substitution4;
                                                        prestigue4 = sigarets4.getPrestigue() * substitution4;
                                                        premier4 = sigarets4.getPremier() * substitution4;
                                                        cosmos4 = sigarets4.getCosmos() * substitution4;
                                                        next4 = sigarets4.getNext() * substitution4;
                                                        magnat4 = sigarets4.getMagnat() * substitution4;
                                                        minsk4 = sigarets4.getMinsk() * substitution4;
                                                        souz4 = sigarets4.getSouz() * substitution4;
                                                        jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                                                bond4, kent4, parlament4, winston4, lm4, malboro4, rotmans4,
                                                                ld4, fmorris4, aliance4, java4, optima4, petr4, maksim4, crests4,
                                                                vog4, glamur4, kiss4, esse4, quin4, lady4, mor4, chester4, radopy4,
                                                                stuardessa4, stolichniye4, donskoy4, troyka4, fast4, royal4, manchester4,
                                                                prestigue4, premier4, cosmos4, next4, magnat4, minsk4, souz4, count4);
                                                        //Процент оклада пятого
                                                        for (fifthCoef = 1; fifthCoef < 201; fifthCoef++) {
                                                            rentRatio5 = worker5.getRatio() * worker5.getRent();
                                                            substitution5 = rentRatio5 * fifthCoef / 100;

                                                            bond5 = sigarets5.getBond() * substitution5;
                                                            kent5 = sigarets5.getKent() * substitution5;
                                                            parlament5 = sigarets5.getParlament() * substitution5;
                                                            winston5 = sigarets5.getWinston() * substitution5;
                                                            lm5 = sigarets5.getLm() * substitution5;
                                                            malboro5 = sigarets5.getMalboro() * substitution5;
                                                            rotmans5 = sigarets5.getRotmans() * substitution5;
                                                            ld5 = sigarets5.getLd() * substitution5;
                                                            fmorris5 = sigarets5.getFmorris() * substitution5;
                                                            aliance5 = sigarets5.getAliance() * substitution5;
                                                            java5 = sigarets5.getJava() * substitution5;
                                                            optima5 = sigarets5.getOptima() * substitution5;
                                                            petr5 = sigarets5.getPetr() * substitution5;
                                                            maksim5 = sigarets5.getMaksim() * substitution5;
                                                            crests5 = sigarets5.getCrests() * substitution5;
                                                            vog5 = sigarets5.getVog() * substitution5;
                                                            glamur5 = sigarets5.getGlamur() * substitution5;
                                                            kiss5 = sigarets5.getKiss() * substitution5;
                                                            esse5 = sigarets5.getEsse() * substitution5;
                                                            quin5 = sigarets5.getQuin() * substitution5;
                                                            lady5 = sigarets5.getLady() * substitution5;
                                                            mor5 = sigarets5.getMor() * substitution5;
                                                            chester5 = sigarets5.getChester() * substitution5;
                                                            radopy5 = sigarets5.getRadopy() * substitution5;
                                                            stuardessa5 = sigarets5.getStuardessa() * substitution5;
                                                            stolichniye5 = sigarets5.getStolichniye() * substitution5;
                                                            donskoy5 = sigarets5.getDonskoy() * substitution5;
                                                            troyka5 = sigarets5.getTroyka() * substitution5;
                                                            fast5 = sigarets5.getFast() * substitution5;
                                                            royal5 = sigarets5.getRoyal() * substitution5;
                                                            manchester5 = sigarets5.getManchester() * substitution5;
                                                            prestigue5 = sigarets5.getPrestigue() * substitution5;
                                                            premier5 = sigarets5.getPremier() * substitution5;
                                                            cosmos5 = sigarets5.getCosmos() * substitution5;
                                                            next5 = sigarets5.getNext() * substitution5;
                                                            magnat5 = sigarets5.getMagnat() * substitution5;
                                                            minsk5 = sigarets5.getMinsk() * substitution5;
                                                            souz5 = sigarets5.getSouz() * substitution5;
                                                            jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                                                    bond5, kent5, parlament5, winston5, lm5, malboro5, rotmans5,
                                                                    ld5, fmorris5, aliance5, java5, optima5, petr5, maksim5, crests5,
                                                                    vog5, glamur5, kiss5, esse5, quin5, lady5, mor5, chester5, radopy5,
                                                                    stuardessa5, stolichniye5, donskoy5, troyka5, fast5, royal5, manchester5,
                                                                    prestigue5, premier5, cosmos5, next5, magnat5, minsk5, souz5, count5);
                                                            //Процент оклада шестого
                                                            for (sixthCoef = 1; sixthCoef < 201; sixthCoef++) {
                                                                rentRatio6 = worker6.getRatio() * worker6.getRent();
                                                                substitution6 = rentRatio6 * sixthCoef / 100;

                                                                bond6 = sigarets6.getBond() * substitution6;
                                                                kent6 = sigarets6.getKent() * substitution6;
                                                                parlament6 = sigarets6.getParlament() * substitution6;
                                                                winston6 = sigarets6.getWinston() * substitution6;
                                                                lm6 = sigarets6.getLm() * substitution6;
                                                                malboro6 = sigarets6.getMalboro() * substitution6;
                                                                rotmans6 = sigarets6.getRotmans() * substitution6;
                                                                ld6 = sigarets6.getLd() * substitution6;
                                                                fmorris6 = sigarets6.getFmorris() * substitution6;
                                                                aliance6 = sigarets6.getAliance() * substitution6;
                                                                java6 = sigarets6.getJava() * substitution6;
                                                                optima6 = sigarets6.getOptima() * substitution6;
                                                                petr6 = sigarets6.getPetr() * substitution6;
                                                                maksim6 = sigarets6.getMaksim() * substitution6;
                                                                crests6 = sigarets6.getCrests() * substitution6;
                                                                vog6 = sigarets6.getVog() * substitution6;
                                                                glamur6 = sigarets6.getGlamur() * substitution6;
                                                                kiss6 = sigarets6.getKiss() * substitution6;
                                                                esse6 = sigarets6.getEsse() * substitution6;
                                                                quin6 = sigarets6.getQuin() * substitution6;
                                                                lady6 = sigarets6.getLady() * substitution6;
                                                                mor6 = sigarets6.getMor() * substitution6;
                                                                chester6 = sigarets6.getChester() * substitution6;
                                                                radopy6 = sigarets6.getRadopy() * substitution6;
                                                                stuardessa6 = sigarets6.getStuardessa() * substitution6;
                                                                stolichniye6 = sigarets6.getStolichniye() * substitution6;
                                                                donskoy6 = sigarets6.getDonskoy() * substitution6;
                                                                troyka6 = sigarets6.getTroyka() * substitution6;
                                                                fast6 = sigarets6.getFast() * substitution6;
                                                                royal6 = sigarets6.getRoyal() * substitution6;
                                                                manchester6 = sigarets6.getManchester() * substitution6;
                                                                prestigue6 = sigarets6.getPrestigue() * substitution6;
                                                                premier6 = sigarets6.getPremier() * substitution6;
                                                                cosmos6 = sigarets6.getCosmos() * substitution6;
                                                                next6 = sigarets6.getNext() * substitution6;
                                                                magnat6 = sigarets6.getMagnat() * substitution6;
                                                                minsk6 = sigarets6.getMinsk() * substitution6;
                                                                souz6 = sigarets6.getSouz() * substitution6;
                                                                jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                                                        bond6, kent6, parlament6, winston6, lm6, malboro6, rotmans6,
                                                                        ld6, fmorris6, aliance6, java6, optima6, petr6, maksim6, crests6,
                                                                        vog6, glamur6, kiss6, esse6, quin6, lady6, mor6, chester6, radopy6,
                                                                        stuardessa6, stolichniye6, donskoy6, troyka6, fast6, royal6, manchester6,
                                                                        prestigue6, premier6, cosmos6, next6, magnat6, minsk6, souz6, count6);
                                                                //Процент оклада седьмого
                                                                for (seventhCoef = 1; seventhCoef < 201; seventhCoef++) {
                                                                    rentRatio7 = worker7.getRatio() * worker7.getRent();
                                                                    substitution7 = rentRatio7 * seventhCoef / 100;

                                                                    bond7 = sigarets7.getBond() * substitution7;
                                                                    kent7 = sigarets7.getKent() * substitution7;
                                                                    parlament7 = sigarets7.getParlament() * substitution7;
                                                                    winston7 = sigarets7.getWinston() * substitution7;
                                                                    lm7 = sigarets7.getLm() * substitution7;
                                                                    malboro7 = sigarets7.getMalboro() * substitution7;
                                                                    rotmans7 = sigarets7.getRotmans() * substitution7;
                                                                    ld7 = sigarets7.getLd() * substitution7;
                                                                    fmorris7 = sigarets7.getFmorris() * substitution7;
                                                                    aliance7 = sigarets7.getAliance() * substitution7;
                                                                    java7 = sigarets7.getJava() * substitution7;
                                                                    optima7 = sigarets7.getOptima() * substitution7;
                                                                    petr7 = sigarets7.getPetr() * substitution7;
                                                                    maksim7 = sigarets7.getMaksim() * substitution7;
                                                                    crests7 = sigarets7.getCrests() * substitution7;
                                                                    vog7 = sigarets7.getVog() * substitution7;
                                                                    glamur7 = sigarets7.getGlamur() * substitution7;
                                                                    kiss7 = sigarets7.getKiss() * substitution7;
                                                                    esse7 = sigarets7.getEsse() * substitution7;
                                                                    quin7 = sigarets7.getQuin() * substitution7;
                                                                    lady7 = sigarets7.getLady() * substitution7;
                                                                    mor7 = sigarets7.getMor() * substitution7;
                                                                    chester7 = sigarets7.getChester() * substitution7;
                                                                    radopy7 = sigarets7.getRadopy() * substitution7;
                                                                    stuardessa7 = sigarets7.getStuardessa() * substitution7;
                                                                    stolichniye7 = sigarets7.getStolichniye() * substitution7;
                                                                    donskoy7 = sigarets7.getDonskoy() * substitution7;
                                                                    troyka7 = sigarets7.getTroyka() * substitution7;
                                                                    fast7 = sigarets7.getFast() * substitution7;
                                                                    royal7 = sigarets7.getRoyal() * substitution7;
                                                                    manchester7 = sigarets7.getManchester() * substitution7;
                                                                    prestigue7 = sigarets7.getPrestigue() * substitution7;
                                                                    premier7 = sigarets7.getPremier() * substitution7;
                                                                    cosmos7 = sigarets7.getCosmos() * substitution7;
                                                                    next7 = sigarets7.getNext() * substitution7;
                                                                    magnat7 = sigarets7.getMagnat() * substitution7;
                                                                    minsk7 = sigarets7.getMinsk() * substitution7;
                                                                    souz7 = sigarets7.getSouz() * substitution7;
                                                                    jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                                                            bond7, kent7, parlament7, winston7, lm7, malboro7, rotmans7,
                                                                            ld7, fmorris7, aliance7, java7, optima7, petr7, maksim7, crests7,
                                                                            vog7, glamur7, kiss7, esse7, quin7, lady7, mor7, chester7, radopy7,
                                                                            stuardessa7, stolichniye7, donskoy7, troyka7, fast7, royal7, manchester7,
                                                                            prestigue7, premier7, cosmos7, next7, magnat7, minsk7, souz7, count7);

                                                                    //Процент оклада восьмого
                                                                    for (eighthCoef = 1; eighthCoef < 201; eighthCoef++) {
                                                                        rentRatio8 = worker8.getRatio() * worker8.getRent();
                                                                        substitution8 = rentRatio7 * eighthCoef / 100;

                                                                        bond8 = sigarets8.getBond() * substitution8;
                                                                        kent8 = sigarets8.getKent() * substitution8;
                                                                        parlament8 = sigarets8.getParlament() * substitution8;
                                                                        winston8 = sigarets8.getWinston() * substitution8;
                                                                        lm8 = sigarets8.getLm() * substitution8;
                                                                        malboro8 = sigarets8.getMalboro() * substitution8;
                                                                        rotmans8 = sigarets8.getRotmans() * substitution8;
                                                                        ld8 = sigarets8.getLd() * substitution8;
                                                                        fmorris8 = sigarets8.getFmorris() * substitution8;
                                                                        aliance8 = sigarets8.getAliance() * substitution8;
                                                                        java8 = sigarets8.getJava() * substitution8;
                                                                        optima8 = sigarets8.getOptima() * substitution8;
                                                                        petr8 = sigarets8.getPetr() * substitution8;
                                                                        maksim8 = sigarets8.getMaksim() * substitution8;
                                                                        crests8 = sigarets8.getCrests() * substitution8;
                                                                        vog8 = sigarets8.getVog() * substitution8;
                                                                        glamur8 = sigarets8.getGlamur() * substitution8;
                                                                        kiss8 = sigarets8.getKiss() * substitution8;
                                                                        esse8 = sigarets8.getEsse() * substitution8;
                                                                        quin8 = sigarets8.getQuin() * substitution8;
                                                                        lady8 = sigarets8.getLady() * substitution8;
                                                                        mor8 = sigarets8.getMor() * substitution8;
                                                                        chester8 = sigarets8.getChester() * substitution8;
                                                                        radopy8 = sigarets8.getRadopy() * substitution8;
                                                                        stuardessa8 = sigarets8.getStuardessa() * substitution8;
                                                                        stolichniye8 = sigarets8.getStolichniye() * substitution8;
                                                                        donskoy8 = sigarets8.getDonskoy() * substitution8;
                                                                        troyka8 = sigarets8.getTroyka() * substitution8;
                                                                        fast8 = sigarets8.getFast() * substitution8;
                                                                        royal8 = sigarets8.getRoyal() * substitution8;
                                                                        manchester8 = sigarets8.getManchester() * substitution8;
                                                                        prestigue8 = sigarets8.getPrestigue() * substitution8;
                                                                        premier8 = sigarets8.getPremier() * substitution8;
                                                                        cosmos8 = sigarets8.getCosmos() * substitution8;
                                                                        next8 = sigarets8.getNext() * substitution8;
                                                                        magnat8 = sigarets8.getMagnat() * substitution8;
                                                                        minsk8 = sigarets8.getMinsk() * substitution8;
                                                                        souz8 = sigarets8.getSouz() * substitution8;
                                                                        jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                                                                bond8, kent8, parlament8, winston8, lm8, malboro8, rotmans8,
                                                                                ld8, fmorris8, aliance8, java8, optima8, petr8, maksim8, crests8,
                                                                                vog8, glamur8, kiss8, esse8, quin8, lady8, mor8, chester8, radopy8,
                                                                                stuardessa8, stolichniye8, donskoy8, troyka8, fast8, royal8, manchester8,
                                                                                prestigue8, premier8, cosmos8, next8, magnat8, minsk8, souz8, count8);


                                                                        double sumBond = bond1 + bond2 + bond3 + bond4 + bond5 + bond6 + bond7 + bond8;
                                                                        double sumKent = kent1 + kent2 + kent3 + kent4 + kent5 + kent6 + kent7 + kent8;
                                                                        double sumParlament = parlament1 + parlament2 + parlament3 + parlament4 + parlament5 + parlament6 + parlament7 + parlament8;
                                                                        double sumWinston = winston1 + winston2 + winston3 + winston4 + winston5 + winston6 + winston7 + winston8;
                                                                        double sumLm = lm1 + lm2 + lm3 + lm4 + lm5 + lm6 + lm7 + lm8;
                                                                        double sumMalboro = malboro1 + malboro2 + malboro3 + malboro4 + malboro5 + malboro6 + malboro7 + malboro8;
                                                                        double sumRotmans = rotmans1 + rotmans2 + rotmans3 + rotmans4 + rotmans5 + rotmans6 + rotmans7 + rotmans8;
                                                                        double sumLd = ld1 + ld2 + ld3 + ld4 + ld5 + ld6 + ld7 + ld8;
                                                                        double sumFmorris = fmorris1 + fmorris2 + fmorris3 + fmorris4 + fmorris5 + fmorris6 + fmorris7 + fmorris8;
                                                                        double sumAliance = aliance1 + aliance2 + aliance3 + aliance4 + aliance5 + aliance6 + aliance7 + aliance8;
                                                                        double sumJava = java1 + java2 + java3 + java4 + java5 + java6 + java7 + java8;
                                                                        double sumOptima = optima1 + optima2 + optima3 + optima4 + optima5 + optima6 + optima7 + optima8;
                                                                        double sumPetr = petr1 + petr2 + petr3 + petr4 + petr5 + petr6 + petr7 + petr8;
                                                                        double sumMaksim = maksim1 + maksim2 + maksim3 + maksim4 + maksim5 + maksim6 + maksim7 + maksim8;
                                                                        double sumCrests = crests1 + crests2 + crests3 + crests4 + crests5 + crests6 + crests7 + crests8;
                                                                        double sumVog = vog1 + vog2 + vog3 + vog4 + vog5 + vog6 + vog7 + vog8;
                                                                        double sumGlamur = glamur1 + glamur2 + glamur3 + glamur4 + glamur5 + glamur6 + glamur7 + glamur8;
                                                                        double sumKiss = kiss1 + kiss2 + kiss3 + kiss4 + kiss5 + kiss6 + kiss7 + kiss8;
                                                                        double sumEsse = esse1 + esse2 + esse3 + esse4 + esse5 + esse6 + esse7 + esse8;
                                                                        double sumQuin = quin1 + quin2 + quin3 + quin4 + quin5 + quin6 + quin7 + quin8;
                                                                        double sumLady = lady1 + lady2 + lady3 + lady4 + lady5 + lady6 + lady7 + lady8;
                                                                        double sumMor = mor1 + mor2 + mor3 + mor4 + mor5 + mor6 + mor7 + mor8;
                                                                        double sumChester = chester1 + chester2 + chester3 + chester4 + chester5 + chester6 + chester7 + chester8;
                                                                        double sumRadopy = radopy1 + radopy2 + radopy3 + radopy4 + radopy5 + radopy6 + radopy7 + radopy8;
                                                                        double sumStuardessa = stuardessa1 + stuardessa2 + stuardessa3 + stuardessa4 + stuardessa5 + stuardessa6 + stuardessa7 + stuardessa8;
                                                                        double sumStolichniye = stolichniye1 + stolichniye2 + stolichniye3 + stolichniye4 + stolichniye5 + stolichniye6 + stolichniye7 + stolichniye8;
                                                                        double sumDonskoy = donskoy1 + donskoy2 + donskoy3 + donskoy4 + donskoy5 + donskoy6 + donskoy7 + donskoy8;
                                                                        double sumTroyka = troyka1 + troyka2 + troyka3 + troyka4 + troyka5 + troyka6 + troyka7 + troyka8;
                                                                        double sumFast = fast1 + fast2 + fast3 + fast4 + fast5 + fast6 + fast7 + fast8;
                                                                        double sumRoyal = royal1 + royal2 + royal3 + royal4 + royal5 + royal6 + royal7 + royal8;
                                                                        double sumManchester = manchester1 + manchester2 + manchester3 + manchester4 + manchester5 + manchester6 + manchester7 + manchester8;
                                                                        double sumPrestigue = prestigue1 + prestigue2 + prestigue3 + prestigue4 + prestigue5 + prestigue6 + prestigue7 + prestigue8;
                                                                        double sumPremier = premier1 + premier2 + premier3 + premier4 + premier5 + premier6 + premier7 + premier8;
                                                                        double sumCosmos = cosmos1 + cosmos2 + cosmos3 + cosmos4 + cosmos5 + cosmos6 + cosmos7 + cosmos8;
                                                                        double sumNext = next1 + next2 + next3 + next4 + next5 + next6 + next7 + next8;
                                                                        double sumMagnat = magnat1 + magnat2 + magnat3 + magnat4 + magnat5 + magnat6 + magnat7 + magnat8;
                                                                        double sumMinsk = minsk1 + minsk2 + minsk3 + minsk4 + minsk5 + minsk6 + minsk7 + minsk8;
                                                                        double sumSouz = souz1 + souz2 + souz3 + souz4 + souz5 + souz6 + souz7 + souz8;

                                                                        expenses = substitution1 + substitution2 + substitution3
                                                                                + substitution4 + substitution5 + substitution6 + substitution7
                                                                                + substitution8;

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

                                                                        double expenses100 = expenses * 100;

                                                                        double coefBond = resultBond / expenses100;
                                                                        double coefKent = resultKent / expenses100;
                                                                        double coefParlament = resultParlament / expenses100;
                                                                        double coefWinston = resultWinston / expenses100;
                                                                        double coefLm = resultLm / expenses100;
                                                                        double coefMalboro = resultMalboro / expenses100;
                                                                        double coefRotmans = resultRotmans / expenses100;
                                                                        double coefLd = resultLd / expenses100;
                                                                        double coefFmorris = resultFmorris / expenses100;
                                                                        double coefAliance = resultAliance / expenses100;
                                                                        double coefJava = resultJava / expenses100;
                                                                        double coefOptima = resultOptima / expenses100;
                                                                        double coefPetr = resultPetr / expenses100;
                                                                        double coefMaksim = resultMaksim / expenses100;
                                                                        double coefCrests = resultCrests / expenses100;
                                                                        double coefVog = resultVog / expenses100;
                                                                        double coefGlamur = resultGlamur / expenses100;
                                                                        double coefKiss = resultKiss / expenses100;
                                                                        double coefEsse = resultEsse / expenses100;
                                                                        double coefQuin = resultQuin / expenses100;
                                                                        double coefLady = resultLady / expenses100;
                                                                        double coefMor = resultMor / expenses100;
                                                                        double coefChester = resultChester / expenses100;
                                                                        double coefRadopy = resultRadopy / expenses100;
                                                                        double coefStuardessa = resultStuardessa / expenses100;
                                                                        double coefStolichniye = resultStolichniye / expenses100;
                                                                        double coefDonskoy = resultDonskoy / expenses100;
                                                                        double coefTroyka = resultTroyka / expenses100;
                                                                        double coefFast = resultFast / expenses100;
                                                                        double coefRoyal = resultRoyal / expenses100;
                                                                        double coefManchester = resultManchester / expenses100;
                                                                        double coefPrestigue = resultPrestigue / expenses100;
                                                                        double coefPremier = resultPremier / expenses100;
                                                                        double coefCosmos = resultCosmos / expenses100;
                                                                        double coefNext = resultNext / expenses100;
                                                                        double coefMagnat = resultMagnat / expenses100;
                                                                        double coefMinsk = resultMinsk / expenses100;
                                                                        double coefSouz = resultSouz / expenses100;

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
                                                                                                                                                                                                                                jdbcTemplate.update(SAVE_BEST_GROUP8,
                                                                                                                                                                                                                                        worker1.getWorkerId(),
                                                                                                                                                                                                                                        worker2.getWorkerId(),
                                                                                                                                                                                                                                        worker3.getWorkerId(),
                                                                                                                                                                                                                                        worker4.getWorkerId(),
                                                                                                                                                                                                                                        worker5.getWorkerId(),
                                                                                                                                                                                                                                        worker6.getWorkerId(),
                                                                                                                                                                                                                                        worker7.getWorkerId(),
                                                                                                                                                                                                                                        worker8.getWorkerId(),
                                                                                                                                                                                                                                        firstCoef,
                                                                                                                                                                                                                                        secondCoef,
                                                                                                                                                                                                                                        thirdCoef,
                                                                                                                                                                                                                                        fourthCoef,
                                                                                                                                                                                                                                        fifthCoef,
                                                                                                                                                                                                                                        sixthCoef,
                                                                                                                                                                                                                                        seventhCoef,
                                                                                                                                                                                                                                        eighthCoef,
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
            i++;
            j++;
            k++;
            l++;
            a++;
            s++;
            f++;
            g++;
        }
        getTiming();
    }


    public void setNum(int num) {
        if (num == 2) {
            saveBestGroup2();
        } else if (num == 3) {
            saveBestGroup3();
        } else if (num == 4) {
            saveBestGroup4();
        } else if (num == 5) {
            saveBestGroup5();
        } else if (num == 6) {
            saveBestGroup6();
        } else if (num == 7) {
            saveBestGroup7();
        } else if (num == 8) {
            saveBestGroup8();
        }
    }
}

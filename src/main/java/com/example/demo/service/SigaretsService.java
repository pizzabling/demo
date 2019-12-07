package com.example.demo.service;

import com.example.demo.domain.Parameters;
import com.example.demo.domain.ResultSigarets;
import com.example.demo.domain.Sigarets;
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
    private static final String SAVE_BEST_GROUP = "INSERT INTO SIGARETSRESULT (firstId, secondId,OKLADFIRST,OKLADSECOND, sumBond, sumKent, sumParlament, sumWinston, sumLm, sumMalboro, sumRotmans, sumLd, sumFmorris, sumAliance, sumJava, sumOptima, sumPetr, sumMaksim, sumCrests, sumVog, sumGlamur, sumKiss, sumEsse, sumQuin, sumLady, sumMor, sumChester, sumRadopy, sumStuardessa, sumStolichniye, sumDonskoy, sumTroyka, sumFast, sumRoyal, sumManchester, sumPrestigue, sumPremier, sumCosmos, sumNext, sumMagnat, sumMinsk, sumSouz,\n" +
            "resultBond, resultKent, resultParlament, resultWinston, resultLm, resultMalboro, resultRotmans, resultLd, resultFmorris, resultAliance, resultJava, resultOptima, resultPetr, resultMaksim, resultCrests, resultVog, resultGlamur, resultKiss, resultEsse, resultQuin, resultLady, resultMor, resultChester, resultRadopy, resultStuardessa, resultStolichniye, resultDonskoy, resultTroyka, resultFast, resultRoyal,  resultManchester,resultPrestigue, resultPremier, resultCosmos, resultNext, resultMagnat, " +
            "resultMinsk, resultSouz, coefBond, coefKent, coefParlament, coefWinston, coefLm, coefMalboro, coefRotmans, coefLd, coefFmorris, coefAliance, coefJava, coefOptima, coefPetr, coefMaksim, coefCrests, coefVog, coefGlamur, coefKiss, coefEsse, coefQuin, coefLady, coefMor, coefChester, coefRadopy, coefStuardessa, coefStolichniye, coefDonskoy, coefTroyka, coefFast, coefRoyal, coefManchester, coefPrestigue, coefPremier, coefCosmos, coefNext, coefMagnat, coefMinsk, coefSouz)" +
            "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";
    private static final String UPDATE_TEMPSIGARETS = "UPDATE TemporaryResultForSigarets set bond=?,kent=?,parlament=?,winston=?,lm=?,malboro=?,rotmans=?,ld=?,fmorris=?,aliance=?,java=?,optima=?,petr=?,maksim=?,crests=?,vog=?,glamur=?,kiss=?,esse=?,quin=?,lady=?,mor=?,chester=?,radopy=?,stuardessa=?,stolichniye=?,donskoy=?,troyka=?,fast=?,royal=?,manchester=?,prestigue=?,premier=?,cosmos=?,next=?,magnat=?,minsk=?,souz=? where id=?";

    public void saveSigarets(Sigarets sigarets) {
        sigaretsRepo.saveSigarets(sigarets);
    }

    public void saveParseSigarets(double bond, double kent, double parlament,
                                  double winston, double lm, double malboro, double rotmans,
                                  double ld, double fmorris, double aliance, double java,
                                  double optima, double petr, double maksim, double crests,
                                  double vog, double glamur, double kiss, double esse,
                                  double quin, double lady, double mor, double chester,
                                  double radopy, double stuardessa, double stolichniye,
                                  double donskoy, double troyka, double fast, double royal,
                                  double manchester, double prestigue, double premier,
                                  double cosmos, double next, double magnat, double minsk,
                                  double souz) {
        Sigarets sigarets = new Sigarets(bond, kent, parlament, winston, lm,
                malboro, rotmans, ld, fmorris, aliance, java, optima, petr,
                maksim, crests, vog, glamur, kiss, esse, quin, lady, mor, chester, radopy,
                stuardessa, stolichniye, donskoy, troyka, fast, royal, manchester, prestigue,
                premier, cosmos, next, magnat, minsk, souz);
        sigaretsRepo.saveSigarets(sigarets);
    }

    public void updateSigarets(int id, double bond, double kent, double parlament,
                               double winston, double lm, double malboro, double rotmans,
                               double ld, double fmorris, double aliance, double java,
                               double optima, double petr, double maksim, double crests,
                               double vog, double glamur, double kiss, double esse,
                               double quin, double lady, double mor, double chester,
                               double radopy, double stuardessa, double stolichniye,
                               double donskoy, double troyka, double fast, double royal,
                               double manchester, double prestigue, double premier,
                               double cosmos, double next, double magnat, double minsk,
                               double souz) {
        Sigarets sigarets = new Sigarets(id, bond, kent, parlament, winston, lm,
                malboro, rotmans, ld, fmorris, aliance, java, optima, petr,
                maksim, crests, vog, glamur, kiss, esse, quin, lady, mor, chester, radopy,
                stuardessa, stolichniye, donskoy, troyka, fast, royal, manchester, prestigue,
                premier, cosmos, next, magnat, minsk, souz);
        sigaretsRepo.updateSigarets(sigarets);
    }

    public void save(int parameter1, int parameter2, int parameter3, int parameter4, int parameter5,
                     int parameter6, int parameter7, int parameter8, int parameter9, int parameter10, int parameter11,
                     int parameter12, int parameter13, int parameter14, int parameter15, int parameter16, int parameter17,
                     int parameter18, int parameter19, int parameter20, int parameter21, int parameter22, int parameter23,
                     int parameter24, int parameter25, int parameter26, int parameter27, int parameter28, int parameter29,
                     int parameter30, int parameter31, int parameter32, int parameter33, int parameter34, int parameter35,
                     int parameter36, int parameter37, int parameter38) {
        Parameters params = new Parameters(parameter1, parameter2, parameter3, parameter4, parameter5,
                parameter6, parameter7, parameter8, parameter9, parameter10, parameter11,
                parameter12, parameter13, parameter14, parameter15, parameter16, parameter17,
                parameter18, parameter19, parameter20, parameter21, parameter22, parameter23,
                parameter24, parameter25, parameter26, parameter27, parameter28, parameter29,
                parameter30, parameter31, parameter32, parameter33, parameter34, parameter35,
                parameter36, parameter37, parameter38);
        sigaretsRepo.saveParams(params);
    }

    public List<Parameters> findAll() {
        return sigaretsRepo.getAllResults();
    }

    public Sigarets getSigaretsById(int id) {
        return sigaretsRepo.getSigaretsById(id);
    }

    public List<ResultSigarets> getAllBestGroup() {
        return sigaretsRepo.getAllBestsGroup();
    }


    public Parameters findParamsById(int id) {
        return sigaretsRepo.findParamsById(id);
    }

    public void saveBestGroup2() {

        var parameters = findParamsById(1);

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
        //Первый сотрудник
        for (int count = 1; count < 50; count++) {

            var worker1 = service.findWorkerById(count);
            var sigarets1 = getSigaretsById(count);
//            double ratio1 = sigarets1.getRatio();
            //Второй сотрудник
            for (int j = 2; j < 50; j++) {
                var worker2 = service.findWorkerById(j);
                var sigarets2 = getSigaretsById(j);
                //Процент оклада первого
                for (double firstCoef = 1; firstCoef < 201; firstCoef++) {
//                double coef1 = firstCoef / 100;
                    double substitution1 = worker1.getRatio() * firstCoef / 100;
                    //Процент оклада второго
                    for (double secondCoef = 1; secondCoef < 201; secondCoef++) {
//                        double coef2 = secondCoef / 100;
                        double substitution2 = worker2.getRatio() * secondCoef / 100;
                        double expenses = substitution1 + substitution2;
                        if (sigarets1.getBond() != 0.0) {
                            bond1 = sigarets1.getBond() * substitution1;
                        }
                        if (sigarets1.getKent() != 0.0) {
                            kent1 = sigarets1.getKent() * substitution1;
                        }
                        if (sigarets1.getParlament() != 0.0) {
                            parlament1 = sigarets1.getParlament() * substitution1;
                        }
                        if (sigarets1.getWinston() != 0.0) {
                            winston1 = sigarets1.getWinston() * substitution1;
                        }
                        if (sigarets1.getLm() != 0.0) {
                            lm1 = sigarets1.getLm() * substitution1;
                        }
                        if (sigarets1.getMalboro() != 0.0) {
                            malboro1 = sigarets1.getMalboro() * substitution1;
                        }
                        if (sigarets1.getRotmans() != 0.0) {
                            rotmans1 = sigarets1.getRotmans() * substitution1;
                        }
                        if (sigarets1.getLd() != 0.0) {
                            ld1 = sigarets1.getLd() * substitution1;
                        }
                        if (sigarets1.getFmorris() != 0.0) {
                            fmorris1 = sigarets1.getFmorris() * substitution1;
                        }
                        if (sigarets1.getAliance() != 0.0) {
                            aliance1 = sigarets1.getAliance() * substitution1;
                        }
                        if (sigarets1.getJava() != 0.0) {
                            java1 = sigarets1.getJava() * substitution1;
                        }
                        if (sigarets1.getOptima() != 0.0) {
                            optima1 = sigarets1.getOptima() * substitution1;
                        }
                        if (sigarets1.getPetr() != 0.0) {
                            petr1 = sigarets1.getPetr() * substitution1;
                        }
                        if (sigarets1.getMaksim() != 0.0) {
                            maksim1 = sigarets1.getMaksim() * substitution1;
                        }
                        if (sigarets1.getCrests() != 0.0) {
                            crests1 = sigarets1.getCrests() * substitution1;
                        }
                        if (sigarets1.getVog() != 0.0) {
                            vog1 = sigarets1.getVog() * substitution1;
                        }
                        if (sigarets1.getGlamur() != 0.0) {
                            glamur1 = sigarets1.getGlamur() * substitution1;
                        }
                        if (sigarets1.getKiss() != 0.0) {
                            kiss1 = sigarets1.getKiss() * substitution1;
                        }
                        if (sigarets1.getEsse() != 0.0) {
                            esse1 = sigarets1.getEsse() * substitution1;
                        }
                        if (sigarets1.getQuin() != 0.0) {
                            quin1 = sigarets1.getQuin() * substitution1;
                        }
                        if (sigarets1.getLady() != 0.0) {
                            lady1 = sigarets1.getLady() * substitution1;
                        }
                        if (sigarets1.getMor() != 0.0) {
                            mor1 = sigarets1.getMor() * substitution1;
                        }
                        if (sigarets1.getChester() != 0.0) {
                            chester1 = sigarets1.getChester() * substitution1;
                        }
                        if (sigarets1.getRadopy() != 0.0) {
                            radopy1 = sigarets1.getRadopy() * substitution1;
                        }
                        if (sigarets1.getStuardessa() != 0.0) {
                            stuardessa1 = sigarets1.getStuardessa() * substitution1;
                        }
                        if (sigarets1.getStolichniye() != 0.0) {
                            stolichniye1 = sigarets1.getStolichniye() * substitution1;
                        }
                        if (sigarets1.getDonskoy() != 0.0) {
                            donskoy1 = sigarets1.getDonskoy() * substitution1;
                        }
                        if (sigarets1.getTroyka() != 0.0) {
                            troyka1 = sigarets1.getTroyka() * substitution1;
                        }
                        if (sigarets1.getFast() != 0.0) {
                            fast1 = sigarets1.getFast() * substitution1;
                        }
                        if (sigarets1.getRoyal() != 0.0) {
                            royal1 = sigarets1.getRoyal() * substitution1;
                        }
                        if (sigarets1.getManchester() != 0.0) {
                            manchester1 = sigarets1.getManchester() * substitution1;
                        }
                        if (sigarets1.getPrestigue() != 0.0) {
                            prestigue1 = sigarets1.getPrestigue() * substitution1;
                        }
                        if (sigarets1.getPremier() != 0.0) {
                            premier1 = sigarets1.getPremier() * substitution1;
                        }
                        if (sigarets1.getCosmos() != 0.0) {
                            cosmos1 = sigarets1.getCosmos() * substitution1;
                        }
                        if (sigarets1.getNext() != 0.0) {
                            next1 = sigarets1.getNext() * substitution1;
                        }
                        if (sigarets1.getMagnat() != 0.0) {
                            magnat1 = sigarets1.getMagnat() * substitution1;
                        }
                        if (sigarets1.getMinsk() != 0.0) {
                            minsk1 = sigarets1.getMinsk() * substitution1;
                        }
                        if (sigarets1.getSouz() != 0.0) {
                            souz1 = sigarets1.getSouz() * substitution1;
                        }
                        jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                bond1, kent1, parlament1, winston1, lm1, malboro1, rotmans1,
                                ld1, fmorris1, aliance1, java1, optima1, petr1, maksim1, crests1,
                                vog1, glamur1, kiss1, esse1, quin1, lady1, mor1, chester1, radopy1,
                                stuardessa1, stolichniye1, donskoy1, troyka1, fast1, royal1, manchester1,
                                prestigue1, premier1, cosmos1, next1, magnat1, minsk1, souz1, count);

                        if (sigarets2.getBond() != 0.0) {
                            bond2 = sigarets2.getBond() * substitution2;
                        }

                        if (sigarets2.getKent() != 0.0) {
                            kent2 = sigarets2.getKent() * substitution2;
                        }

                        if (sigarets2.getParlament() != 0.0) {
                            parlament2 = sigarets2.getParlament() * substitution2;
                        }


                        if (sigarets2.getWinston() != 0.0) {
                            winston2 = sigarets2.getWinston() * substitution2;
                        }

                        if (sigarets2.getLm() != 0.0) {
                            lm2 = sigarets2.getLm() * substitution2;
                        }

                        if (sigarets2.getMalboro() != 0.0) {
                            malboro2 = sigarets2.getMalboro() * substitution2;
                        }

                        if (sigarets2.getRotmans() != 0.0) {
                            rotmans2 = sigarets2.getRotmans() * substitution2;
                        }

                        if (sigarets2.getLd() != 0.0) {
                            ld2 = sigarets2.getLd() * substitution2;
                        }

                        if (sigarets2.getFmorris() != 0.0) {
                            fmorris2 = sigarets2.getFmorris() * substitution2;
                        }

                        if (sigarets2.getAliance() != 0.0) {
                            aliance2 = sigarets2.getAliance() * substitution2;
                        }

                        if (sigarets2.getJava() != 0.0) {
                            java2 = sigarets2.getJava() * substitution2;
                        }

                        if (sigarets2.getOptima() != 0.0) {
                            optima2 = sigarets2.getOptima() * substitution2;
                        }

                        if (sigarets2.getPetr() != 0.0) {
                            petr2 = sigarets2.getPetr() * substitution2;
                        }

                        if (sigarets2.getMaksim() != 0.0) {
                            maksim2 = sigarets2.getMaksim() * substitution2;
                        }

                        if (sigarets2.getCrests() != 0.0) {
                            crests2 = sigarets2.getCrests() * substitution2;
                        }

                        if (sigarets2.getVog() != 0.0) {
                            vog2 = sigarets2.getVog() * substitution2;
                        }

                        if (sigarets2.getGlamur() != 0.0) {
                            glamur2 = sigarets2.getGlamur() * substitution2;
                        }

                        if (sigarets2.getKiss() != 0.0) {
                            kiss2 = sigarets2.getKiss() * substitution2;
                        }

                        if (sigarets2.getEsse() != 0.0) {
                            esse2 = sigarets2.getEsse() * substitution2;
                        }

                        if (sigarets2.getQuin() != 0.0) {
                            quin2 = sigarets2.getQuin() * substitution2;
                        }

                        if (sigarets2.getLady() != 0.0) {
                            lady2 = sigarets2.getLady() * substitution2;
                        }

                        if (sigarets2.getMor() != 0.0) {
                            mor2 = sigarets2.getMor() * substitution2;
                        }

                        if (sigarets2.getChester() != 0.0) {
                            chester2 = sigarets2.getChester() * substitution2;
                        }

                        if (sigarets2.getStuardessa() != 0.0) {
                            stuardessa2 = sigarets2.getStuardessa() * substitution2;
                        }

                        if (sigarets2.getStolichniye() != 0.0) {
                            stolichniye2 = sigarets2.getStolichniye() * substitution2;
                        }

                        if (sigarets2.getDonskoy() != 0.0) {
                            donskoy2 = sigarets2.getDonskoy() * substitution2;
                        }

                        if (sigarets2.getTroyka() != 0.0) {
                            troyka2 = sigarets2.getTroyka() * substitution2;
                        }

                        if (sigarets2.getFast() != 0.0) {
                            fast2 = sigarets2.getFast() * substitution2;
                        }

                        if (sigarets2.getRoyal() != 0.0) {
                            royal2 = sigarets2.getRoyal() * substitution2;
                        }

                        if (sigarets2.getManchester() != 0.0) {
                            manchester2 = sigarets2.getManchester() * substitution2;
                        }

                        if (sigarets2.getPrestigue() != 0.0) {
                            prestigue2 = sigarets2.getPrestigue() * substitution2;
                        }

                        if (sigarets2.getPremier() != 0.0) {
                            premier2 = sigarets2.getPremier() * substitution2;
                        }

                        if (sigarets2.getCosmos() != 0.0) {
                            cosmos2 = sigarets2.getCosmos() * substitution2;
                        }

                        if (sigarets2.getNext() != 0.0) {
                            next2 = sigarets2.getNext() * substitution2;
                        }

                        if (sigarets2.getMagnat() != 0.0) {
                            magnat2 = sigarets2.getMagnat() * substitution2;
                        }

                        if (sigarets2.getMinsk() != 0.0) {
                            minsk2 = sigarets2.getMinsk() * substitution2;
                        }

                        if (sigarets2.getSouz() != 0.0) {
                            souz2 = sigarets2.getSouz() * substitution2;
                        }

                        jdbcTemplate.update(UPDATE_TEMPSIGARETS,
                                bond2, kent2, parlament2, winston2, lm2, malboro2, rotmans2,
                                ld2, fmorris2, aliance2, java2, optima2, petr2, maksim2, crests2,
                                vog2, glamur2, kiss2, esse2, quin2, lady2, mor2, chester2, radopy2,
                                stuardessa2, stolichniye2, donskoy2, troyka2, fast2, royal2, manchester2,
                                prestigue2, premier2, cosmos2, next2, magnat2, minsk2, souz2, j);

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
        }
    }

//    public void fastSaveBestGroup2() {
//
//        var parameters = findParamsById(1);
//
//        double bond1 = 0;
//        double bond2 = 0;
//        double kent1 = 0;
//        double kent2 = 0;
//        double winston1 = 0;
//        double winston2 = 0;
//        double parlament1 = 0;
//        double parlament2 = 0;
//        double lm1 = 0;
//        double lm2 = 0;
//        double malboro1 = 0;
//        double malboro2 = 0;
//        double rotmans1 = 0;
//        double rotmans2 = 0;
//        double ld1 = 0;
//        double ld2 = 0;
//        double fmorris1 = 0;
//        double fmorris2 = 0;
//        double aliance1 = 0;
//        double aliance2 = 0;
//        double java1 = 0;
//        double java2 = 0;
//        double optima1 = 0;
//        double optima2 = 0;
//        double petr1 = 0;
//        double petr2 = 0;
//        double maksim1 = 0;
//        double maksim2 = 0;
//        double crests1 = 0;
//        double crests2 = 0;
//        double vog1 = 0;
//        double vog2 = 0;
//        double glamur1 = 0;
//        double glamur2 = 0;
//        double esse1 = 0;
//        double esse2 = 0;
//        double kiss1 = 0;
//        double kiss2 = 0;
//        double quin1 = 0;
//        double quin2 = 0;
//        double lady1 = 0;
//        double lady2 = 0;
//        double mor1 = 0;
//        double mor2 = 0;
//        double chester1 = 0;
//        double chester2 = 0;
//        double radopy1 = 0;
//        double radopy2 = 0;
//        double stuardessa1 = 0;
//        double stuardessa2 = 0;
//        double stolichniye1 = 0;
//        double stolichniye2 = 0;
//        double donskoy1 = 0;
//        double donskoy2 = 0;
//        double troyka1 = 0;
//        double troyka2 = 0;
//        double fast1 = 0;
//        double fast2 = 0;
//        double royal1 = 0;
//        double royal2 = 0;
//        double manchester1 = 0;
//        double manchester2 = 0;
//        double prestigue1 = 0;
//        double prestigue2 = 0;
//        double premier1 = 0;
//        double premier2 = 0;
//        double cosmos1 = 0;
//        double cosmos2 = 0;
//        double next1 = 0;
//        double next2 = 0;
//        double magnat1 = 0;
//        double magnat2 = 0;
//        double minsk1 = 0;
//        double minsk2 = 0;
//        double souz1 = 0;
//        double souz2 = 0;
//        //Первый сотрудник
//        for (int count = 1; count < 50; count++) {
//
//            var worker1 = service.findWorkerById(count);
//            var sigarets1 = getSigaretsById(count);
////            double ratio1 = sigarets1.getRatio();
//            //Процент оклада первого
//            for (double firstCoef = 1; firstCoef < 201; firstCoef++) {
////                double coef1 = firstCoef / 100;
//                double substitution1 = worker1.getRatio() * firstCoef / 100;
//                //Второй сотрудник
//                for (int j = 2; j < 50; j++) {
//                    var worker2 = service.findWorkerById(j);
//                    var sigarets2 = getSigaretsById(j);
////                    double ratio2 = sigarets2.getRatio();
//                    //Процент оклада второго
//                    for (double secondCoef = 1; secondCoef < 201; secondCoef++) {
////                        double coef2 = secondCoef / 100;
//                        double substitution2 = worker2.getRatio() * secondCoef / 100;
//                        double expenses = substitution1 + substitution2;
//                        if (sigarets1.getBond() != 0.0) {
//                            bond1 = sigarets1.getBond() * substitution1;
//                        }
//                        if (sigarets1.getKent() != 0.0) {
//                            kent1 = sigarets1.getKent() * substitution1;
//                        }
//                        if (sigarets1.getParlament() != 0.0) {
//                            parlament1 = sigarets1.getParlament() * substitution1;
//                        }
//                        if (sigarets1.getWinston() != 0.0) {
//                            winston1 = sigarets1.getWinston() * substitution1;
//                        }
//                        if (sigarets1.getLm() != 0.0) {
//                            lm1 = sigarets1.getLm() * substitution1;
//                        }
//                        if (sigarets1.getMalboro() != 0.0) {
//                            malboro1 = sigarets1.getMalboro() * substitution1;
//                        }
//                        if (sigarets1.getRotmans() != 0.0) {
//                            rotmans1 = sigarets1.getRotmans() * substitution1;
//                        }
//                        if (sigarets1.getLd() != 0.0) {
//                            ld1 = sigarets1.getLd() * substitution1;
//                        }
//                        if (sigarets1.getFmorris() != 0.0) {
//                            fmorris1 = sigarets1.getFmorris() * substitution1;
//                        }
//                        if (sigarets1.getAliance() != 0.0) {
//                            aliance1 = sigarets1.getAliance() * substitution1;
//                        }
//                        if (sigarets1.getJava() != 0.0) {
//                            java1 = sigarets1.getJava() * substitution1;
//                        }
//                        if (sigarets1.getOptima() != 0.0) {
//                            optima1 = sigarets1.getOptima() * substitution1;
//                        }
//                        if (sigarets1.getPetr() != 0.0) {
//                            petr1 = sigarets1.getPetr() * substitution1;
//                        }
//                        if (sigarets1.getMaksim() != 0.0) {
//                            maksim1 = sigarets1.getMaksim() * substitution1;
//                        }
//                        if (sigarets1.getCrests() != 0.0) {
//                            crests1 = sigarets1.getCrests() * substitution1;
//                        }
//                        if (sigarets1.getVog() != 0.0) {
//                            vog1 = sigarets1.getVog() * substitution1;
//                        }
//                        if (sigarets1.getGlamur() != 0.0) {
//                            glamur1 = sigarets1.getGlamur() * substitution1;
//                        }
//                        if (sigarets1.getKiss() != 0.0) {
//                            kiss1 = sigarets1.getKiss() * substitution1;
//                        }
//                        if (sigarets1.getEsse() != 0.0) {
//                            esse1 = sigarets1.getEsse() * substitution1;
//                        }
//                        if (sigarets1.getQuin() != 0.0) {
//                            quin1 = sigarets1.getQuin() * substitution1;
//                        }
//                        if (sigarets1.getLady() != 0.0) {
//                            lady1 = sigarets1.getLady() * substitution1;
//                        }
//                        if (sigarets1.getMor() != 0.0) {
//                            mor1 = sigarets1.getMor() * substitution1;
//                        }
//                        if (sigarets1.getChester() != 0.0) {
//                            chester1 = sigarets1.getChester() * substitution1;
//                        }
//                        if (sigarets1.getRadopy() != 0.0) {
//                            radopy1 = sigarets1.getRadopy() * substitution1;
//                        }
//                        if (sigarets1.getStuardessa() != 0.0) {
//                            stuardessa1 = sigarets1.getStuardessa() * substitution1;
//                        }
//                        if (sigarets1.getStolichniye() != 0.0) {
//                            stolichniye1 = sigarets1.getStolichniye() * substitution1;
//                        }
//                        if (sigarets1.getDonskoy() != 0.0) {
//                            donskoy1 = sigarets1.getDonskoy() * substitution1;
//                        }
//                        if (sigarets1.getTroyka() != 0.0) {
//                            troyka1 = sigarets1.getTroyka() * substitution1;
//                        }
//                        if (sigarets1.getFast() != 0.0) {
//                            fast1 = sigarets1.getFast() * substitution1;
//                        }
//                        if (sigarets1.getRoyal() != 0.0) {
//                            royal1 = sigarets1.getRoyal() * substitution1;
//                        }
//                        if (sigarets1.getManchester() != 0.0) {
//                            manchester1 = sigarets1.getManchester() * substitution1;
//                        }
//                        if (sigarets1.getPrestigue() != 0.0) {
//                            prestigue1 = sigarets1.getPrestigue() * substitution1;
//                        }
//                        if (sigarets1.getPremier() != 0.0) {
//                            premier1 = sigarets1.getPremier() * substitution1;
//                        }
//                        if (sigarets1.getCosmos() != 0.0) {
//                            cosmos1 = sigarets1.getCosmos() * substitution1;
//                        }
//                        if (sigarets1.getNext() != 0.0) {
//                            next1 = sigarets1.getNext() * substitution1;
//                        }
//                        if (sigarets1.getMagnat() != 0.0) {
//                            magnat1 = sigarets1.getMagnat() * substitution1;
//                        }
//                        if (sigarets1.getMinsk() != 0.0) {
//                            minsk1 = sigarets1.getMinsk() * substitution1;
//                        }
//                        if (sigarets1.getSouz() != 0.0) {
//                            souz1 = sigarets1.getSouz() * substitution1;
//                        }
//                        jdbcTemplate.update(UPDATE_TEMPSIGARETS,
//                                bond1, kent1, parlament1, winston1, lm1, malboro1, rotmans1,
//                                ld1, fmorris1, aliance1, java1, optima1, petr1, maksim1, crests1,
//                                vog1, glamur1, kiss1, esse1, quin1, lady1, mor1, chester1, radopy1,
//                                stuardessa1, stolichniye1, donskoy1, troyka1, fast1, royal1, manchester1,
//                                prestigue1, premier1, cosmos1, next1, magnat1, minsk1, souz1, count);
//
//                        if (sigarets2.getBond() != 0.0) {
//                            bond2 = sigarets2.getBond() * substitution2;
//                        }
//
//                        if (sigarets2.getKent() != 0.0) {
//                            kent2 = sigarets2.getKent() * substitution2;
//                        }
//
//                        if (sigarets2.getParlament() != 0.0) {
//                            parlament2 = sigarets2.getParlament() * substitution2;
//                        }
//
//
//                        if (sigarets2.getWinston() != 0.0) {
//                            winston2 = sigarets2.getWinston() * substitution2;
//                        }
//
//                        if (sigarets2.getLm() != 0.0) {
//                            lm2 = sigarets2.getLm() * substitution2;
//                        }
//
//                        if (sigarets2.getMalboro() != 0.0) {
//                            malboro2 = sigarets2.getMalboro() * substitution2;
//                        }
//
//                        if (sigarets2.getRotmans() != 0.0) {
//                            rotmans2 = sigarets2.getRotmans() * substitution2;
//                        }
//
//                        if (sigarets2.getLd() != 0.0) {
//                            ld2 = sigarets2.getLd() * substitution2;
//                        }
//
//                        if (sigarets2.getFmorris() != 0.0) {
//                            fmorris2 = sigarets2.getFmorris() * substitution2;
//                        }
//
//                        if (sigarets2.getAliance() != 0.0) {
//                            aliance2 = sigarets2.getAliance() * substitution2;
//                        }
//
//                        if (sigarets2.getJava() != 0.0) {
//                            java2 = sigarets2.getJava() * substitution2;
//                        }
//
//                        if (sigarets2.getOptima() != 0.0) {
//                            optima2 = sigarets2.getOptima() * substitution2;
//                        }
//
//                        if (sigarets2.getPetr() != 0.0) {
//                            petr2 = sigarets2.getPetr() * substitution2;
//                        }
//
//                        if (sigarets2.getMaksim() != 0.0) {
//                            maksim2 = sigarets2.getMaksim() * substitution2;
//                        }
//
//                        if (sigarets2.getCrests() != 0.0) {
//                            crests2 = sigarets2.getCrests() * substitution2;
//                        }
//
//                        if (sigarets2.getVog() != 0.0) {
//                            vog2 = sigarets2.getVog() * substitution2;
//                        }
//
//                        if (sigarets2.getGlamur() != 0.0) {
//                            glamur2 = sigarets2.getGlamur() * substitution2;
//                        }
//
//                        if (sigarets2.getKiss() != 0.0) {
//                            kiss2 = sigarets2.getKiss() * substitution2;
//                        }
//
//                        if (sigarets2.getEsse() != 0.0) {
//                            esse2 = sigarets2.getEsse() * substitution2;
//                        }
//
//                        if (sigarets2.getQuin() != 0.0) {
//                            quin2 = sigarets2.getQuin() * substitution2;
//                        }
//
//                        if (sigarets2.getLady() != 0.0) {
//                            lady2 = sigarets2.getLady() * substitution2;
//                        }
//
//                        if (sigarets2.getMor() != 0.0) {
//                            mor2 = sigarets2.getMor() * substitution2;
//                        }
//
//                        if (sigarets2.getChester() != 0.0) {
//                            chester2 = sigarets2.getChester() * substitution2;
//                        }
//
//                        if (sigarets2.getStuardessa() != 0.0) {
//                            stuardessa2 = sigarets2.getStuardessa() * substitution2;
//                        }
//
//                        if (sigarets2.getStolichniye() != 0.0) {
//                            stolichniye2 = sigarets2.getStolichniye() * substitution2;
//                        }
//
//                        if (sigarets2.getDonskoy() != 0.0) {
//                            donskoy2 = sigarets2.getDonskoy() * substitution2;
//                        }
//
//                        if (sigarets2.getTroyka() != 0.0) {
//                            troyka2 = sigarets2.getTroyka() * substitution2;
//                        }
//
//                        if (sigarets2.getFast() != 0.0) {
//                            fast2 = sigarets2.getFast() * substitution2;
//                        }
//
//                        if (sigarets2.getRoyal() != 0.0) {
//                            royal2 = sigarets2.getRoyal() * substitution2;
//                        }
//
//                        if (sigarets2.getManchester() != 0.0) {
//                            manchester2 = sigarets2.getManchester() * substitution2;
//                        }
//
//                        if (sigarets2.getPrestigue() != 0.0) {
//                            prestigue2 = sigarets2.getPrestigue() * substitution2;
//                        }
//
//                        if (sigarets2.getPremier() != 0.0) {
//                            premier2 = sigarets2.getPremier() * substitution2;
//                        }
//
//                        if (sigarets2.getCosmos() != 0.0) {
//                            cosmos2 = sigarets2.getCosmos() * substitution2;
//                        }
//
//                        if (sigarets2.getNext() != 0.0) {
//                            next2 = sigarets2.getNext() * substitution2;
//                        }
//
//                        if (sigarets2.getMagnat() != 0.0) {
//                            magnat2 = sigarets2.getMagnat() * substitution2;
//                        }
//
//                        if (sigarets2.getMinsk() != 0.0) {
//                            minsk2 = sigarets2.getMinsk() * substitution2;
//                        }
//
//                        if (sigarets2.getSouz() != 0.0) {
//                            souz2 = sigarets2.getSouz() * substitution2;
//                        }
//
//                        jdbcTemplate.update(UPDATE_TEMPSIGARETS,
//                                bond2, kent2, parlament2, winston2, lm2, malboro2, rotmans2,
//                                ld2, fmorris2, aliance2, java2, optima2, petr2, maksim2, crests2,
//                                vog2, glamur2, kiss2, esse2, quin2, lady2, mor2, chester2, radopy2,
//                                stuardessa2, stolichniye2, donskoy2, troyka2, fast2, royal2, manchester2,
//                                prestigue2, premier2, cosmos2, next2, magnat2, minsk2, souz2, j);
//
//                        double resultBond = ;
//                        double resultKent = ;
//                        double resultParlament = ;
//                        double resultWinston = ;
//                        double resultLm =
//                        double resultMalboro = ;
//                        double resultRotmans = ;
//                        double resultLd = ;
//                        double resultFmorris = ;
//                        double resultAliance = ;
//                        double resultJava = ;
//                        double resultOptima = ;
//                        double resultPetr = ;
//                        double resultMaksim = ;
//                        double resultCrests = ;
//                        double resultVog = ;
//                        double resultGlamur = ;
//                        double resultKiss = ;
//                        double resultEsse = ;
//                        double resultQuin = ;
//                        double resultLady = ;
//                        double resultMor = ;
//                        double resultChester = ;
//                        double resultRadopy = ;
//                        double resultStuardessa = ;
//                        double resultStolichniye = ;
//                        double resultDonskoy = donskoy1 + donskoy2 - expenses;
//                        double resultTroyka = troyka1 + troyka2 - expenses;
//                        double resultFast = fast1 + fast2 - expenses;
//                        double resultRoyal = royal1 + royal2 - expenses;
//                        double resultManchester = manchester1 + manchester2 - expenses;
//                        double resultPrestigue = prestigue1 + prestigue2 - expenses;
//                        double resultPremier = premier1 + premier2 - expenses;
//                        double resultCosmos = cosmos1 + cosmos2 - expenses;
//                        double resultNext = next1 + next2 - expenses;
//                        double resultMagnat = magnat1 + magnat2 - expenses;
//                        double resultMinsk = minsk1 + minsk2 - expenses;
//                        double resultSouz = souz1 + souz2 - expenses;
//
//                        double coefBond = (bond1 + bond2 - expenses) / expenses * 100;
//                        double coefKent = (kent1 + kent2 - expenses) / expenses * 100;
//                        double coefParlament = (parlament1 + parlament2 - expenses) / expenses * 100;
//                        double coefWinston = (winston1 + winston2 - expenses) / expenses * 100;
//                        double coefLm = (lm1 + lm2 - expenses) / expenses * 100;
//                        double coefMalboro = (malboro1 + malboro2 - expenses) / expenses * 100;
//                        double coefRotmans = (rotmans1 + rotmans2 - expenses) / expenses * 100;
//                        double coefLd = (ld1 + ld2 - expenses) / expenses * 100;
//                        double coefFmorris = (fmorris1 + fmorris2 - expenses) / expenses * 100;
//                        double coefAliance = (aliance1 + aliance2 - expenses) / expenses * 100;
//                        double coefJava = (java1 + java2 - expenses) / expenses * 100;
//                        double coefOptima = (optima1 + optima2 - expenses) / expenses * 100;
//                        double coefPetr = (petr1 + petr2 - expenses) / expenses * 100;
//                        double coefMaksim = (maksim1 + maksim2 - expenses) / expenses * 100;
//                        double coefCrests = (crests1 + crests2 - expenses) / expenses * 100;
//                        double coefVog = (vog1 + vog2 - expenses) / expenses * 100;
//                        double coefGlamur = (glamur1 + glamur2 - expenses) / expenses * 100;
//                        double coefKiss = (kiss1 + kiss2 - expenses) / expenses * 100;
//                        double coefEsse = (esse1 + esse2 - expenses) / expenses * 100;
//                        double coefQuin = (quin1 + quin2 - expenses) / expenses * 100;
//                        double coefLady = (lady1 + lady2 - expenses) / expenses * 100;
//                        double coefMor = (mor1 + mor2 - expenses) / expenses * 100;
//                        double coefChester = (chester1 + chester2 - expenses) / expenses * 100;
//                        double coefRadopy = (radopy1 + radopy2 - expenses) / expenses * 100;
//                        double coefStuardessa = (stuardessa1 + stuardessa2 - expenses) / expenses * 100;
//                        double coefStolichniye = stolichniye1 + stolichniye2 - expenses / expenses * 100;
//                        double coefDonskoy = resultDonskoy / expenses * 100;
//                        double coefTroyka = resultTroyka / expenses * 100;
//                        double coefFast = resultFast / expenses * 100;
//                        double coefRoyal = resultRoyal / expenses * 100;
//                        double coefManchester = resultManchester / expenses * 100;
//                        double coefPrestigue = resultPrestigue / expenses * 100;
//                        double coefPremier = resultPremier / expenses * 100;
//                        double coefCosmos = resultCosmos / expenses * 100;
//                        double coefNext = resultNext / expenses * 100;
//                        double coefMagnat = resultMagnat / expenses * 100;
//                        double coefMinsk = resultMinsk / expenses * 100;
//                        double coefSouz = resultSouz / expenses * 100;
//
//                        if (coefBond >= parameters.getParameter1()) {
//                            if (coefKent >= parameters.getParameter2()) {
//                                if (coefParlament >= parameters.getParameter3()) {
//                                    if (coefWinston >= parameters.getParameter4()) {
//                                        if (coefLm >= parameters.getParameter5()) {
//                                            if (coefMalboro >= parameters.getParameter6()) {
//                                                if (coefRotmans >= parameters.getParameter7()) {
//                                                    if (coefLd >= parameters.getParameter8()) {
//                                                        if (coefFmorris >= parameters.getParameter9()) {
//                                                            if (coefAliance >= parameters.getParameter10()) {
//                                                                if (coefJava >= parameters.getParameter11()) {
//                                                                    if (coefOptima >= parameters.getParameter12()) {
//                                                                        if (coefPetr >= parameters.getParameter13()) {
//                                                                            if (coefMaksim >= parameters.getParameter14()) {
//                                                                                if (coefCrests >= parameters.getParameter15()) {
//                                                                                    if (coefVog >= parameters.getParameter16()) {
//                                                                                        if (coefGlamur >= parameters.getParameter17()) {
//                                                                                            if (coefKiss >= parameters.getParameter18()) {
//                                                                                                if (coefEsse >= parameters.getParameter19()) {
//                                                                                                    if (coefQuin >= parameters.getParameter20()) {
//                                                                                                        if (coefLady >= parameters.getParameter21()) {
//                                                                                                            if (coefMor >= parameters.getParameter22()) {
//                                                                                                                if (coefChester >= parameters.getParameter23()) {
//                                                                                                                    if (coefRadopy >= parameters.getParameter24()) {
//                                                                                                                        if (coefStuardessa >= parameters.getParameter25()) {
//                                                                                                                            if (coefStolichniye >= parameters.getParameter26()) {
//                                                                                                                                if (coefDonskoy >= parameters.getParameter27()) {
//                                                                                                                                    if (coefTroyka >= parameters.getParameter28()) {
//                                                                                                                                        if (coefFast >= parameters.getParameter29()) {
//                                                                                                                                            if (coefRoyal >= parameters.getParameter30()) {
//                                                                                                                                                if (coefManchester >= parameters.getParameter31()) {
//                                                                                                                                                    if (coefPrestigue >= parameters.getParameter32()) {
//                                                                                                                                                        if (coefPremier >= parameters.getParameter33()) {
//                                                                                                                                                            if (coefCosmos >= parameters.getParameter34()) {
//                                                                                                                                                                if (coefNext >= parameters.getParameter35()) {
//                                                                                                                                                                    if (coefMagnat >= parameters.getParameter36()) {
//                                                                                                                                                                        if (coefMinsk >= parameters.getParameter37()) {
//                                                                                                                                                                            if (coefSouz >= parameters.getParameter38()) {
//                                                                                                                                                                                jdbcTemplate.update(SAVE_BEST_GROUP,
//                                                                                                                                                                                        worker1.getWorkerId(),
//                                                                                                                                                                                        worker2.getWorkerId(),
//                                                                                                                                                                                        firstCoef,
//                                                                                                                                                                                        secondCoef,
//                                                                                                                                                                                        sumBond,
//                                                                                                                                                                                        sumKent,
//                                                                                                                                                                                        sumParlament,
//                                                                                                                                                                                        sumWinston,
//                                                                                                                                                                                        sumLm,
//                                                                                                                                                                                        sumMalboro,
//                                                                                                                                                                                        sumRotmans,
//                                                                                                                                                                                        sumLd,
//                                                                                                                                                                                        sumFmorris,
//                                                                                                                                                                                        sumAliance,
//                                                                                                                                                                                        sumJava,
//                                                                                                                                                                                        sumOptima,
//                                                                                                                                                                                        sumPetr,
//                                                                                                                                                                                        sumMaksim,
//                                                                                                                                                                                        sumCrests,
//                                                                                                                                                                                        sumVog,
//                                                                                                                                                                                        sumGlamur,
//                                                                                                                                                                                        sumKiss,
//                                                                                                                                                                                        sumEsse,
//                                                                                                                                                                                        sumQuin,
//                                                                                                                                                                                        sumLady,
//                                                                                                                                                                                        sumMor,
//                                                                                                                                                                                        sumChester,
//                                                                                                                                                                                        sumRadopy,
//                                                                                                                                                                                        sumStuardessa,
//                                                                                                                                                                                        sumStolichniye,
//                                                                                                                                                                                        sumDonskoy,
//                                                                                                                                                                                        sumTroyka,
//                                                                                                                                                                                        sumFast,
//                                                                                                                                                                                        sumRoyal,
//                                                                                                                                                                                        sumManchester,
//                                                                                                                                                                                        sumPrestigue,
//                                                                                                                                                                                        sumPremier,
//                                                                                                                                                                                        sumCosmos,
//                                                                                                                                                                                        sumNext,
//                                                                                                                                                                                        sumMagnat,
//                                                                                                                                                                                        sumMinsk,
//                                                                                                                                                                                        sumSouz,
//
//                                                                                                                                                                                        resultBond,
//                                                                                                                                                                                        resultKent,
//                                                                                                                                                                                        resultParlament,
//                                                                                                                                                                                        resultWinston,
//                                                                                                                                                                                        resultLm,
//                                                                                                                                                                                        resultMalboro,
//                                                                                                                                                                                        resultRotmans,
//                                                                                                                                                                                        resultLd,
//                                                                                                                                                                                        resultFmorris,
//                                                                                                                                                                                        resultAliance,
//                                                                                                                                                                                        resultJava,
//                                                                                                                                                                                        resultOptima,
//                                                                                                                                                                                        resultPetr,
//                                                                                                                                                                                        resultMaksim,
//                                                                                                                                                                                        resultCrests,
//                                                                                                                                                                                        resultVog,
//                                                                                                                                                                                        resultGlamur,
//                                                                                                                                                                                        resultKiss,
//                                                                                                                                                                                        resultEsse,
//                                                                                                                                                                                        resultQuin,
//                                                                                                                                                                                        resultLady,
//                                                                                                                                                                                        resultMor,
//                                                                                                                                                                                        resultChester,
//                                                                                                                                                                                        resultRadopy,
//                                                                                                                                                                                        resultStuardessa,
//                                                                                                                                                                                        resultStolichniye,
//                                                                                                                                                                                        resultDonskoy,
//                                                                                                                                                                                        resultTroyka,
//                                                                                                                                                                                        resultFast,
//                                                                                                                                                                                        resultRoyal,
//                                                                                                                                                                                        resultManchester,
//                                                                                                                                                                                        resultPrestigue,
//                                                                                                                                                                                        resultPremier,
//                                                                                                                                                                                        resultCosmos,
//                                                                                                                                                                                        resultNext,
//                                                                                                                                                                                        resultMagnat,
//                                                                                                                                                                                        resultMinsk,
//                                                                                                                                                                                        resultSouz,
//
//                                                                                                                                                                                        coefBond,
//                                                                                                                                                                                        coefKent,
//                                                                                                                                                                                        coefParlament,
//                                                                                                                                                                                        coefWinston,
//                                                                                                                                                                                        coefLm,
//                                                                                                                                                                                        coefMalboro,
//                                                                                                                                                                                        coefRotmans,
//                                                                                                                                                                                        coefLd,
//                                                                                                                                                                                        coefFmorris,
//                                                                                                                                                                                        coefAliance,
//                                                                                                                                                                                        coefJava,
//                                                                                                                                                                                        coefOptima,
//                                                                                                                                                                                        coefPetr,
//                                                                                                                                                                                        coefMaksim,
//                                                                                                                                                                                        coefCrests,
//                                                                                                                                                                                        coefVog,
//                                                                                                                                                                                        coefGlamur,
//                                                                                                                                                                                        coefKiss,
//                                                                                                                                                                                        coefEsse,
//                                                                                                                                                                                        coefQuin,
//                                                                                                                                                                                        coefLady,
//                                                                                                                                                                                        coefMor,
//                                                                                                                                                                                        coefChester,
//                                                                                                                                                                                        coefRadopy,
//                                                                                                                                                                                        coefStuardessa,
//                                                                                                                                                                                        coefStolichniye,
//                                                                                                                                                                                        coefDonskoy,
//                                                                                                                                                                                        coefTroyka,
//                                                                                                                                                                                        coefFast,
//                                                                                                                                                                                        coefRoyal,
//                                                                                                                                                                                        coefManchester,
//                                                                                                                                                                                        coefPrestigue,
//                                                                                                                                                                                        coefPremier,
//                                                                                                                                                                                        coefCosmos,
//                                                                                                                                                                                        coefNext,
//                                                                                                                                                                                        coefMagnat,
//                                                                                                                                                                                        coefMinsk,
//                                                                                                                                                                                        coefSouz
//                                                                                                                                                                                );
//                                                                                                                                                                            }
//                                                                                                                                                                        }
//                                                                                                                                                                    }
//                                                                                                                                                                }
//                                                                                                                                                            }
//                                                                                                                                                        }
//                                                                                                                                                    }
//                                                                                                                                                }
//
//                                                                                                                                            }
//                                                                                                                                        }
//                                                                                                                                    }
//                                                                                                                                }
//                                                                                                                            }
//                                                                                                                        }
//                                                                                                                    }
//                                                                                                                }
//                                                                                                            }
//                                                                                                        }
//                                                                                                    }
//                                                                                                }
//                                                                                            }
//                                                                                        }
//                                                                                    }
//                                                                                }
//                                                                            }
//                                                                        }
//                                                                    }
//                                                                }
//                                                            }
//                                                        }
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//    public void saveBestGroup3() {
//
//        var parameters = findParamsById(1);
//
//        double bond1 = 0;
//        double bond2 = 0;
//        double bond3 = 0;
//        double kent1 = 0;
//        double kent2 = 0;
//        double kent3 = 0;
//        double winston1 = 0;
//        double winston2 = 0;
//        double winston3 = 0;
//        double parlament1 = 0;
//        double parlament2 = 0;
//        double parlament3 = 0;
//        double lm1 = 0;
//        double lm2 = 0;
//        double lm3 = 0;
//        double malboro1 = 0;
//        double malboro2 = 0;
//        double malboro3 = 0;
//        double rotmans1 = 0;
//        double rotmans2 = 0;
//        double rotmans3 = 0;
//        double ld1 = 0;
//        double ld2 = 0;
//        double ld3 = 0;
//        double fmorris1 = 0;
//        double fmorris2 = 0;
//        double fmorris3 = 0;
//        double aliance1 = 0;
//        double aliance2 = 0;
//        double aliance3 = 0;
//        double java1 = 0;
//        double java2 = 0;
//        double java3 = 0;
//        double optima1 = 0;
//        double optima2 = 0;
//        double optima3 = 0;
//        double petr1 = 0;
//        double petr2 = 0;
//        double petr3 = 0;
//        double maksim1 = 0;
//        double maksim2 = 0;
//        double maksim3 = 0;
//        double crests1 = 0;
//        double crests2 = 0;
//        double crests3 = 0;
//        double vog1 = 0;
//        double vog2 = 0;
//        double vog3 = 0;
//        double glamur1 = 0;
//        double glamur2 = 0;
//        double glamur3 = 0;
//        double esse1 = 0;
//        double esse2 = 0;
//        double esse3 = 0;
//        double kiss1 = 0;
//        double kiss2 = 0;
//        double kiss3 = 0;
//        double quin1 = 0;
//        double quin2 = 0;
//        double quin3 = 0;
//        double lady1 = 0;
//        double lady2 = 0;
//        double lady3 = 0;
//        double mor1 = 0;
//        double mor2 = 0;
//        double mor3 = 0;
//        double chester1 = 0;
//        double chester2 = 0;
//        double chester3 = 0;
//        double radopy1 = 0;
//        double radopy2 = 0;
//        double radopy3 = 0;
//        double stuardessa1 = 0;
//        double stuardessa2 = 0;
//        double stuardessa3 = 0;
//        double stolichniye1 = 0;
//        double stolichniye2 = 0;
//        double stolichniye3 = 0;
//        double donskoy1 = 0;
//        double donskoy2 = 0;
//        double donskoy3 = 0;
//        double troyka1 = 0;
//        double troyka2 = 0;
//        double troyka3 = 0;
//        double fast1 = 0;
//        double fast2 = 0;
//        double fast3 = 0;
//        double royal1 = 0;
//        double royal2 = 0;
//        double royal3 = 0;
//        double manchester1 = 0;
//        double manchester2 = 0;
//        double manchester3 = 0;
//        double prestigue1 = 0;
//        double prestigue2 = 0;
//        double prestigue3 = 0;
//        double premier1 = 0;
//        double premier2 = 0;
//        double premier3 = 0;
//        double cosmos1 = 0;
//        double cosmos2 = 0;
//        double cosmos3 = 0;
//        double next1 = 0;
//        double next2 = 0;
//        double next3 = 0;
//        double magnat1 = 0;
//        double magnat2 = 0;
//        double magnat3 = 0;
//        double minsk1 = 0;
//        double minsk2 = 0;
//        double minsk3 = 0;
//        double souz1 = 0;
//        double souz2 = 0;
//        double souz3 = 0;
//        //Первый сотрудник
//        for (int count = 1; count < 11; count++) {
//            var worker1 = service.findWorkerById(count);
//            double ratio1 = worker1.getRatio();
//            //Процент оклада первого
//            for (double firstCoef = 1; firstCoef < 201; firstCoef++) {
//                double coef1 = firstCoef / 100;
//                double substitution1 = ratio1 * coef1;
//                //Второй сотрудник
//                for (int j = 2; j < 11; j++) {
//                    var worker2 = service.findWorkerById(j);
//                    double ratio2 = worker2.getRatio();
//                    //Процент оклада второго
//                    for (double secondCoef = 1; secondCoef < 201; secondCoef++) {
//                        double coef2 = secondCoef / 100;
//                        double substitution2 = ratio2 * coef2;
//                        //Третий сотрудик
//                        for (int k = 3; k < 11; k++) {
//                            var worker3 = service.findWorkerById(k);
//                            double ratio3 = worker3.getRatio();
//                            //Процент оклада третьего сотрудника
//                            for (double thirdCoef = 1; thirdCoef < 201; thirdCoef++) {
//                                double coef3 = thirdCoef / 100;
//                                double substitution3 = ratio3 * coef3;
//
//                                double expenses = substitution1 + substitution2 + substitution3;
//                                if (worker1.getBond() != 0.0) {
//                                    bond1 = worker1.getBond() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set bond = ? where id=? ",
//                                            worker1.getBond() * substitution1, count);
//                                }
//                                if (worker2.getBond() != 0.0) {
//                                    bond2 = worker2.getBond() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set bond = ? where id=?",
//                                            worker2.getBond() * substitution2, j);
//                                }
//                                if (worker3.getBond() != 0.0) {
//                                    bond3 = worker3.getBond() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set bond = ? where id=?",
//                                            worker3.getBond() * substitution3, k);
//                                }
//                                if (worker1.getKent() != 0.0) {
//                                    kent1 = worker1.getKent() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set KENT = ? where ID = ?",
//                                            worker1.getKent() * substitution1, count);
//                                }
//                                if (worker2.getKent() != 0.0) {
//                                    kent2 = worker2.getKent() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set KENT=? where ID=?",
//                                            worker2.getKent() * substitution2, j);
//                                }
//                                if (worker3.getKent() != 0.0) {
//                                    kent3 = worker3.getKent() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set KENT=? where ID=?",
//                                            worker3.getKent() * substitution3, k);
//                                }
//                                if (worker1.getParlament() != 0.0) {
//                                    parlament1 = worker1.getParlament() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set PARLAMENT=? where ID=?",
//                                            worker1.getParlament() * substitution1, count);
//                                }
//                                if (worker2.getParlament() != 0.0) {
//                                    parlament2 = worker2.getParlament() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set PARLAMENT=? where id=?",
//                                            worker2.getParlament() * substitution2, j);
//                                }
//                                if (worker3.getParlament() != 0.0) {
//                                    parlament3 = worker3.getParlament() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set PARLAMENT=? where id=?",
//                                            worker3.getParlament() * substitution3, k);
//                                }
//                                if (worker1.getWinston() != 0.0) {
//                                    winston1 = worker1.getWinston() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set WINSTON=? where ID=?",
//                                            worker1.getWinston() * substitution1, count);
//                                }
//                                if (worker2.getWinston() != 0.0) {
//                                    winston2 = worker2.getWinston() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set WINSTON=? where ID=?",
//                                            worker2.getWinston() * substitution2, j);
//                                }
//                                if (worker1.getLm() != 0.0) {
//                                    lm1 = worker1.getLm() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set LM=? where ID=?",
//                                            worker1.getLm() * substitution1, count);
//                                }
//                                if (worker2.getLm() != 0.0) {
//                                    lm2 = worker2.getLm() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set LM=? where ID=?",
//                                            worker2.getLm() * substitution2, j);
//                                }
//                                if (worker1.getMalboro() != 0.0) {
//                                    malboro1 = worker1.getMalboro() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set MALBORO=? where ID=?",
//                                            worker1.getMalboro() * substitution1, count);
//                                }
//                                if (worker2.getMalboro() != 0.0) {
//                                    malboro2 = worker2.getMalboro() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set MALBORO=? where ID=?",
//                                            worker2.getMalboro() * substitution2, j);
//                                }
//                                if (worker1.getRotmans() != 0.0) {
//                                    rotmans1 = worker1.getRotmans() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set ROTMANS=? where ID=?",
//                                            worker1.getRotmans() * substitution1, count);
//                                }
//                                if (worker2.getRotmans() != 0.0) {
//                                    rotmans2 = worker2.getRotmans() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set ROTMANS=? where ID=?",
//                                            worker2.getRotmans() * substitution2, j);
//                                }
//                                if (worker1.getLd() != 0.0) {
//                                    ld1 = worker1.getLd() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set LD=? where ID=?",
//                                            worker1.getLd() * substitution1, count);
//                                }
//                                if (worker2.getLd() != 0.0) {
//                                    ld2 = worker2.getLd() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set LD=? where ID=?",
//                                            worker2.getLd() * substitution2, j);
//                                }
//                                if (worker1.getFmorris() != 0.0) {
//                                    fmorris1 = worker1.getFmorris() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set FMORRIS=? where ID=?",
//                                            worker1.getFmorris() * substitution1, count);
//                                }
//                                if (worker2.getFmorris() != 0.0) {
//                                    fmorris2 = worker2.getFmorris() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set FMORRIS=? where ID=?",
//                                            worker2.getFmorris() * substitution2, j);
//                                }
//                                if (worker1.getAliance() != 0.0) {
//                                    aliance1 = worker1.getAliance() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set ALIANCE=? where ID=?",
//                                            worker1.getAliance() * substitution1, count);
//                                }
//                                if (worker2.getAliance() != 0.0) {
//                                    aliance2 = worker2.getAliance() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set ALIANCE=? where ID=?",
//                                            worker2.getAliance() * substitution2, j);
//                                }
//                                if (worker1.getJava() != 0.0) {
//                                    java1 = worker1.getJava() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set JAVA=? where ID=?",
//                                            worker1.getJava() * substitution1, count);
//                                }
//                                if (worker2.getJava() != 0.0) {
//                                    java2 = worker2.getJava() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set JAVA=? where ID=?",
//                                            worker2.getJava() * substitution2, j);
//                                }
//                                if (worker1.getOptima() != 0.0) {
//                                    optima1 = worker1.getOptima() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set OPTIMA=? where ID=?",
//                                            worker1.getOptima() * substitution1, count);
//                                }
//                                if (worker2.getOptima() != 0.0) {
//                                    optima2 = worker2.getOptima() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set OPTIMA=? where ID=?",
//                                            worker2.getOptima() * substitution2, j);
//                                }
//                                if (worker1.getPetr() != 0.0) {
//                                    petr1 = worker1.getPetr() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set PETR=? where ID=?",
//                                            worker1.getPetr() * substitution1, count);
//                                }
//                                if (worker2.getPetr() != 0.0) {
//                                    petr2 = worker2.getPetr() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set PETR=? where ID=?",
//                                            worker2.getPetr() * substitution2, j);
//                                }
//                                if (worker1.getMaksim() != 0.0) {
//                                    maksim1 = worker1.getMaksim() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set MAKSIM=? where ID=?",
//                                            worker1.getMaksim() * substitution1, count);
//                                }
//                                if (worker2.getMaksim() != 0.0) {
//                                    maksim2 = worker2.getMaksim() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set MAKSIM=? where ID=?",
//                                            worker2.getMaksim() * substitution2, j);
//                                }
//                                if (worker1.getCrests() != 0.0) {
//                                    crests1 = worker1.getCrests() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set CRESTS=? where ID=?",
//                                            worker1.getCrests() * substitution1, count);
//                                }
//                                if (worker2.getCrests() != 0.0) {
//                                    crests2 = worker2.getCrests() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set CRESTS=? where ID=?",
//                                            worker2.getCrests() * substitution2, j);
//                                }
//                                if (worker1.getVog() != 0.0) {
//                                    vog1 = worker1.getVog() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set VOG=? where ID=?",
//                                            worker1.getVog() * substitution1, count);
//                                }
//                                if (worker2.getVog() != 0.0) {
//                                    vog2 = worker2.getVog() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set VOG=? where ID=?",
//                                            worker2.getVog() * substitution2, j);
//                                }
//                                if (worker1.getGlamur() != 0.0) {
//                                    glamur1 = worker1.getGlamur() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set GLAMUR=? where ID=?",
//                                            worker1.getGlamur() * substitution1, count);
//                                }
//                                if (worker2.getGlamur() != 0.0) {
//                                    glamur2 = worker2.getGlamur() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set GLAMUR=? where ID=?",
//                                            worker2.getGlamur() * substitution2, j);
//                                }
//                                if (worker1.getKiss() != 0.0) {
//                                    kiss1 = worker1.getKiss() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set KISS=? where ID=?",
//                                            worker1.getKiss() * substitution1, count);
//                                }
//                                if (worker2.getKiss() != 0.0) {
//                                    kiss2 = worker2.getKiss() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set KISS=? where ID=?",
//                                            worker2.getKiss() * substitution2, j);
//                                }
//                                if (worker1.getEsse() != 0.0) {
//                                    esse1 = worker1.getEsse() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set ESSE=? where ID=?",
//                                            worker1.getEsse() * substitution1, count);
//                                }
//                                if (worker2.getEsse() != 0.0) {
//                                    esse2 = worker2.getEsse() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set ESSE=? where ID=?",
//                                            worker2.getEsse() * substitution2, j);
//                                }
//                                if (worker1.getQuin() != 0.0) {
//                                    quin1 = worker1.getQuin() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set QUIN=? where ID=?",
//                                            worker1.getQuin() * substitution1, count);
//                                }
//                                if (worker2.getQuin() != 0.0) {
//                                    quin2 = worker2.getQuin() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set QUIN=? where ID=?",
//                                            worker2.getQuin() * substitution2, j);
//                                }
//                                if (worker1.getLady() != 0.0) {
//                                    lady1 = worker1.getLady() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set LADY=? where ID=?",
//                                            worker1.getLady() * substitution1, count);
//                                }
//                                if (worker2.getLady() != 0.0) {
//                                    lady2 = worker2.getLady() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set LADY=? where ID=?",
//                                            worker2.getLady() * substitution2, j);
//                                }
//                                if (worker1.getMor() != 0.0) {
//                                    mor1 = worker1.getMor() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set MOR=? where ID=?",
//                                            worker1.getMor() * substitution1, count);
//                                }
//                                if (worker2.getMor() != 0.0) {
//                                    mor2 = worker2.getMor() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set MOR=? where ID=?",
//                                            worker2.getMor() * substitution2, j);
//                                }
//                                if (worker1.getChester() != 0.0) {
//                                    chester1 = worker1.getChester() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set CHESTER=? where ID=?",
//                                            worker1.getChester() * substitution1, count);
//                                }
//                                if (worker2.getChester() != 0.0) {
//                                    chester2 = worker2.getChester() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set CHESTER=? where ID=?",
//                                            worker2.getChester() * substitution2, j);
//                                }
//                                if (worker1.getRadopy() != 0.0) {
//                                    radopy1 = worker1.getRadopy() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set RADOPY=? where ID=?",
//                                            worker1.getRadopy() * substitution1, count);
//                                }
//                                if (worker2.getRadopy() != 0.0) {
//                                    radopy2 = worker2.getRadopy() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set RADOPY=? where ID=?",
//                                            worker2.getRadopy() * substitution2, j);
//                                }
//                                if (worker1.getStuardessa() != 0.0) {
//                                    stuardessa1 = worker1.getStuardessa() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set STUARDESSA=? where ID=?",
//                                            worker1.getStuardessa() * substitution1, count);
//                                }
//                                if (worker2.getStuardessa() != 0.0) {
//                                    stuardessa2 = worker2.getStuardessa() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set STUARDESSA=? where ID=?",
//                                            worker2.getStuardessa() * substitution2, j);
//                                }
//                                if (worker1.getStolichniye() != 0.0) {
//                                    stolichniye1 = worker1.getStolichniye() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set STOLICHNIYE=? where ID=?",
//                                            worker1.getStolichniye() * substitution1, count);
//                                }
//                                if (worker2.getStolichniye() != 0.0) {
//                                    stolichniye2 = worker2.getStolichniye() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set STOLICHNIYE=? where ID=?",
//                                            worker2.getStolichniye() * substitution2, j);
//                                }
//                                if (worker1.getDonskoy() != 0.0) {
//                                    donskoy1 = worker1.getDonskoy() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set DONSKOY=? where ID=?",
//                                            worker1.getDonskoy() * substitution1, count);
//                                }
//                                if (worker2.getDonskoy() != 0.0) {
//                                    donskoy2 = worker2.getDonskoy() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set DONSKOY=? where ID=?",
//                                            worker2.getDonskoy() * substitution2, j);
//                                }
//                                if (worker1.getTroyka() != 0.0) {
//                                    troyka1 = worker1.getTroyka() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set TROYKA=? where ID=?",
//                                            worker1.getTroyka() * substitution1, count);
//                                }
//                                if (worker2.getTroyka() != 0.0) {
//                                    troyka2 = worker2.getTroyka() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set TROYKA=? where ID=?",
//                                            worker2.getTroyka() * substitution2, j);
//                                }
//                                if (worker1.getFast() != 0.0) {
//                                    fast1 = worker1.getFast() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set FAST=? where ID=?",
//                                            worker1.getFast() * substitution1, count);
//                                }
//                                if (worker2.getFast() != 0.0) {
//                                    fast2 = worker2.getFast() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set FAST=? where ID=?",
//                                            worker2.getFast() * substitution2, j);
//                                }
//                                if (worker1.getRoyal() != 0.0) {
//                                    royal1 = worker1.getRoyal() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set ROYAL=? where ID=?",
//                                            worker1.getRoyal() * substitution1, count);
//                                }
//                                if (worker2.getRoyal() != 0.0) {
//                                    royal2 = worker2.getRoyal() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set ROYAL=? where ID=?",
//                                            worker2.getRoyal() * substitution2, j);
//                                }
//                                if (worker1.getManchester() != 0.0) {
//                                    manchester1 = worker1.getManchester() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set MANCHESTER=? where ID=?",
//                                            worker1.getManchester() * substitution1, count);
//                                }
//                                if (worker2.getManchester() != 0.0) {
//                                    manchester2 = worker2.getManchester() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set MANCHESTER=? where ID=?",
//                                            worker2.getManchester() * substitution2, j);
//                                }
//                                if (worker1.getPrestigue() != 0.0) {
//                                    prestigue1 = worker1.getPrestigue() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set PRESTIGUE=? where ID=?",
//                                            worker1.getPrestigue() * substitution1, count);
//                                }
//                                if (worker2.getPrestigue() != 0.0) {
//                                    prestigue2 = worker2.getPrestigue() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set PRESTIGUE=? where ID=?",
//                                            worker2.getPrestigue() * substitution2, j);
//                                }
//                                if (worker1.getPremier() != 0.0) {
//                                    premier1 = worker1.getPremier() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set PREMIER=? where ID=?",
//                                            worker1.getPremier() * substitution1, count);
//                                }
//                                if (worker2.getPremier() != 0.0) {
//                                    premier2 = worker2.getPremier() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set PREMIER=? where ID=?",
//                                            worker2.getPremier() * substitution2, j);
//                                }
//                                if (worker1.getCosmos() != 0.0) {
//                                    cosmos1 = worker1.getCosmos() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set COSMOS=? where ID=?",
//                                            worker1.getCosmos() * substitution1, count);
//                                }
//                                if (worker2.getCosmos() != 0.0) {
//                                    cosmos2 = worker2.getCosmos() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set COSMOS=? where ID=?",
//                                            worker2.getCosmos() * substitution2, j);
//                                }
//                                if (worker1.getNext() != 0.0) {
//                                    next1 = worker1.getNext() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set NEXT=? where ID=?",
//                                            worker1.getNext() * substitution1, count);
//                                }
//                                if (worker2.getNext() != 0.0) {
//                                    next2 = worker2.getNext() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set NEXT=? where ID=?",
//                                            worker2.getNext() * substitution2, j);
//                                }
//                                if (worker1.getMagnat() != 0.0) {
//                                    magnat1 = worker1.getMagnat() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set MAGNAT=? where ID=?",
//                                            worker1.getMagnat() * substitution1, count);
//                                }
//                                if (worker2.getMagnat() != 0.0) {
//                                    magnat2 = worker2.getMagnat() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set MAGNAT=? where ID=?",
//                                            worker2.getMagnat() * substitution2, j);
//                                }
//                                if (worker1.getMinsk() != 0.0) {
//                                    minsk1 = worker1.getMinsk() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set MINSK=? where ID=?",
//                                            worker1.getMinsk() * substitution1, count);
//                                }
//                                if (worker2.getMinsk() != 0.0) {
//                                    minsk2 = worker2.getMinsk() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set MINSK=? where ID=?",
//                                            worker2.getMinsk() * substitution2, j);
//                                }
//                                if (worker1.getSouz() != 0.0) {
//                                    souz1 = worker1.getSouz() * substitution1;
//                                    jdbcTemplate.update("UPDATE SIGARETS set SOUZ=? where ID=?",
//                                            worker1.getSouz() * substitution1, count);
//                                }
//                                if (worker2.getSouz() != 0.0) {
//                                    souz2 = worker2.getSouz() * substitution2;
//                                    jdbcTemplate.update("UPDATE SIGARETS set SOUZ=? where ID=?",
//                                            worker2.getSouz() * substitution2, j);
//                                }
//                                double sumBond = bond1 + bond2;
//                                double sumKent = kent1 + kent2;
//                                double sumParlament = parlament1 + parlament2;
//                                double sumWinston = winston1 + winston2;
//                                double sumLm = lm1 + lm2;
//                                double sumMalboro = malboro1 + malboro2;
//                                double sumRotmans = rotmans1 + rotmans2;
//                                double sumLd = ld1 + ld2;
//                                double sumFmorris = fmorris1 + fmorris2;
//                                double sumAliance = aliance1 + aliance2;
//                                double sumJava = java1 + java2;
//                                double sumOptima = optima1 + optima2;
//                                double sumPetr = petr1 + petr2;
//                                double sumMaksim = maksim1 + maksim2;
//                                double sumCrests = crests1 + crests2;
//                                double sumVog = vog1 + vog2;
//                                double sumGlamur = glamur1 + glamur2;
//                                double sumKiss = kiss1 + kiss2;
//                                double sumEsse = esse1 + esse2;
//                                double sumQuin = quin1 + quin2;
//                                double sumLady = lady1 + lady2;
//                                double sumMor = mor1 + mor2;
//                                double sumChester = chester1 + chester2;
//                                double sumRadopy = radopy1 + radopy2;
//                                double sumStuardessa = stuardessa1 + stuardessa2;
//                                double sumStolichniye = stolichniye1 + stolichniye2;
//                                double sumDonskoy = donskoy1 + donskoy2;
//                                double sumTroyka = troyka1 + troyka2;
//                                double sumFast = fast1 + fast2;
//                                double sumRoyal = royal1 + royal2;
//                                double sumManchester = manchester1 + manchester2;
//                                double sumPrestigue = prestigue1 + prestigue2;
//                                double sumPremier = premier1 + premier2;
//                                double sumCosmos = cosmos1 + cosmos2;
//                                double sumNext = next1 + next2;
//                                double sumMagnat = magnat1 + magnat2;
//                                double sumMinsk = minsk1 + minsk2;
//                                double sumSouz = souz1 + souz2;
//
//                                double resultBond = sumBond - expenses;
//                                double resultKent = sumKent - expenses;
//                                double resultParlament = sumParlament - expenses;
//                                double resultWinston = sumWinston - expenses;
//                                double resultLm = sumLm - expenses;
//                                double resultMalboro = sumMalboro - expenses;
//                                double resultRotmans = sumRotmans - expenses;
//                                double resultLd = sumLd - expenses;
//                                double resultFmorris = sumFmorris - expenses;
//                                double resultAliance = sumAliance - expenses;
//                                double resultJava = sumJava - expenses;
//                                double resultOptima = sumOptima - expenses;
//                                double resultPetr = sumPetr - expenses;
//                                double resultMaksim = sumMaksim - expenses;
//                                double resultCrests = sumCrests - expenses;
//                                double resultVog = sumVog - expenses;
//                                double resultGlamur = sumGlamur - expenses;
//                                double resultKiss = sumKiss - expenses;
//                                double resultEsse = sumEsse - expenses;
//                                double resultQuin = sumQuin - expenses;
//                                double resultLady = sumLady - expenses;
//                                double resultMor = sumMor - expenses;
//                                double resultChester = sumChester - expenses;
//                                double resultRadopy = sumRadopy - expenses;
//                                double resultStuardessa = sumStuardessa - expenses;
//                                double resultStolichniye = sumStolichniye - expenses;
//                                double resultDonskoy = sumDonskoy - expenses;
//                                double resultTroyka = sumTroyka - expenses;
//                                double resultFast = sumFast - expenses;
//                                double resultRoyal = sumRoyal - expenses;
//                                double resultManchester = sumManchester - expenses;
//                                double resultPrestigue = sumPrestigue - expenses;
//                                double resultPremier = sumPremier - expenses;
//                                double resultCosmos = sumCosmos - expenses;
//                                double resultNext = sumNext - expenses;
//                                double resultMagnat = sumMagnat - expenses;
//                                double resultMinsk = sumMinsk - expenses;
//                                double resultSouz = sumSouz - expenses;
//
//                                double coefBond = resultBond / expenses * 100;
//                                double coefKent = resultKent / expenses * 100;
//                                double coefParlament = resultParlament / expenses * 100;
//                                double coefWinston = resultWinston / expenses * 100;
//                                double coefLm = resultLm / expenses * 100;
//                                double coefMalboro = resultMalboro / expenses * 100;
//                                double coefRotmans = resultRotmans / expenses * 100;
//                                double coefLd = resultLd / expenses * 100;
//                                double coefFmorris = resultFmorris / expenses * 100;
//                                double coefAliance = resultAliance / expenses * 100;
//                                double coefJava = resultJava / expenses * 100;
//                                double coefOptima = resultOptima / expenses * 100;
//                                double coefPetr = resultPetr / expenses * 100;
//                                double coefMaksim = resultMaksim / expenses * 100;
//                                double coefCrests = resultCrests / expenses * 100;
//                                double coefVog = resultVog / expenses * 100;
//                                double coefGlamur = resultGlamur / expenses * 100;
//                                double coefKiss = resultKiss / expenses * 100;
//                                double coefEsse = resultEsse / expenses * 100;
//                                double coefQuin = resultQuin / expenses * 100;
//                                double coefLady = resultLady / expenses * 100;
//                                double coefMor = resultMor / expenses * 100;
//                                double coefChester = resultChester / expenses * 100;
//                                double coefRadopy = resultRadopy / expenses * 100;
//                                double coefStuardessa = resultStuardessa / expenses * 100;
//                                double coefStolichniye = resultStolichniye / expenses * 100;
//                                double coefDonskoy = resultDonskoy / expenses * 100;
//                                double coefTroyka = resultTroyka / expenses * 100;
//                                double coefFast = resultFast / expenses * 100;
//                                double coefRoyal = resultRoyal / expenses * 100;
//                                double coefManchester = resultManchester / expenses * 100;
//                                double coefPrestigue = resultPrestigue / expenses * 100;
//                                double coefPremier = resultPremier / expenses * 100;
//                                double coefCosmos = resultCosmos / expenses * 100;
//                                double coefNext = resultNext / expenses * 100;
//                                double coefMagnat = resultMagnat / expenses * 100;
//                                double coefMinsk = resultMinsk / expenses * 100;
//                                double coefSouz = resultSouz / expenses * 100;
//
//                                if (coefBond >= parameters.getParameter1()) {
//                                    if (coefKent >= parameters.getParameter2()) {
//                                        if (coefParlament >= parameters.getParameter3()) {
//                                            if (coefWinston >= parameters.getParameter4()) {
//                                                if (coefLm >= parameters.getParameter5()) {
//                                                    if (coefMalboro >= parameters.getParameter6()) {
//                                                        if (coefRotmans >= parameters.getParameter7()) {
//                                                            if (coefLd >= parameters.getParameter8()) {
//                                                                if (coefFmorris >= parameters.getParameter9()) {
//                                                                    if (coefAliance >= parameters.getParameter10()) {
//                                                                        if (coefJava >= parameters.getParameter11()) {
//                                                                            if (coefOptima >= parameters.getParameter12()) {
//                                                                                if (coefPetr >= parameters.getParameter13()) {
//                                                                                    if (coefMaksim >= parameters.getParameter14()) {
//                                                                                        if (coefCrests >= parameters.getParameter15()) {
//                                                                                            if (coefVog >= parameters.getParameter16()) {
//                                                                                                if (coefGlamur >= parameters.getParameter17()) {
//                                                                                                    if (coefKiss >= parameters.getParameter18()) {
//                                                                                                        if (coefEsse >= parameters.getParameter19()) {
//                                                                                                            if (coefQuin >= parameters.getParameter20()) {
//                                                                                                                if (coefLady >= parameters.getParameter21()) {
//                                                                                                                    if (coefMor >= parameters.getParameter22()) {
//                                                                                                                        if (coefChester >= parameters.getParameter23()) {
//                                                                                                                            if (coefRadopy >= parameters.getParameter24()) {
//                                                                                                                                if (coefStuardessa >= parameters.getParameter25()) {
//                                                                                                                                    if (coefStolichniye >= parameters.getParameter26()) {
//                                                                                                                                        if (coefDonskoy >= parameters.getParameter27()) {
//                                                                                                                                            if (coefTroyka >= parameters.getParameter28()) {
//                                                                                                                                                if (coefFast >= parameters.getParameter29()) {
//                                                                                                                                                    if (coefRoyal >= parameters.getParameter30()) {
//                                                                                                                                                        if (coefManchester >= parameters.getParameter31()) {
//                                                                                                                                                            if (coefPrestigue >= parameters.getParameter32()) {
//                                                                                                                                                                if (coefPremier >= parameters.getParameter33()) {
//                                                                                                                                                                    if (coefCosmos >= parameters.getParameter34()) {
//                                                                                                                                                                        if (coefNext >= parameters.getParameter35()) {
//                                                                                                                                                                            if (coefMagnat >= parameters.getParameter36()) {
//                                                                                                                                                                                if (coefMinsk >= parameters.getParameter37()) {
//                                                                                                                                                                                    if (coefSouz >= parameters.getParameter38()) {
//                                                                                                                                                                                        jdbcTemplate.update(SAVE_BEST_GROUP,
//                                                                                                                                                                                                worker1.getWorkerId(),
//                                                                                                                                                                                                worker2.getWorkerId(),
//                                                                                                                                                                                                firstCoef,
//                                                                                                                                                                                                secondCoef,
//                                                                                                                                                                                                sumBond,
//                                                                                                                                                                                                sumKent,
//                                                                                                                                                                                                sumParlament,
//                                                                                                                                                                                                sumWinston,
//                                                                                                                                                                                                sumLm,
//                                                                                                                                                                                                sumMalboro,
//                                                                                                                                                                                                sumRotmans,
//                                                                                                                                                                                                sumLd,
//                                                                                                                                                                                                sumFmorris,
//                                                                                                                                                                                                sumAliance,
//                                                                                                                                                                                                sumJava,
//                                                                                                                                                                                                sumOptima,
//                                                                                                                                                                                                sumPetr,
//                                                                                                                                                                                                sumMaksim,
//                                                                                                                                                                                                sumCrests,
//                                                                                                                                                                                                sumVog,
//                                                                                                                                                                                                sumGlamur,
//                                                                                                                                                                                                sumKiss,
//                                                                                                                                                                                                sumEsse,
//                                                                                                                                                                                                sumQuin,
//                                                                                                                                                                                                sumLady,
//                                                                                                                                                                                                sumMor,
//                                                                                                                                                                                                sumChester,
//                                                                                                                                                                                                sumRadopy,
//                                                                                                                                                                                                sumStuardessa,
//                                                                                                                                                                                                sumStolichniye,
//                                                                                                                                                                                                sumDonskoy,
//                                                                                                                                                                                                sumTroyka,
//                                                                                                                                                                                                sumFast,
//                                                                                                                                                                                                sumRoyal,
//                                                                                                                                                                                                sumManchester,
//                                                                                                                                                                                                sumPrestigue,
//                                                                                                                                                                                                sumPremier,
//                                                                                                                                                                                                sumCosmos,
//                                                                                                                                                                                                sumNext,
//                                                                                                                                                                                                sumMagnat,
//                                                                                                                                                                                                sumMinsk,
//                                                                                                                                                                                                sumSouz,
//
//                                                                                                                                                                                                resultBond,
//                                                                                                                                                                                                resultKent,
//                                                                                                                                                                                                resultParlament,
//                                                                                                                                                                                                resultWinston,
//                                                                                                                                                                                                resultLm,
//                                                                                                                                                                                                resultMalboro,
//                                                                                                                                                                                                resultRotmans,
//                                                                                                                                                                                                resultLd,
//                                                                                                                                                                                                resultFmorris,
//                                                                                                                                                                                                resultAliance,
//                                                                                                                                                                                                resultJava,
//                                                                                                                                                                                                resultOptima,
//                                                                                                                                                                                                resultPetr,
//                                                                                                                                                                                                resultMaksim,
//                                                                                                                                                                                                resultCrests,
//                                                                                                                                                                                                resultVog,
//                                                                                                                                                                                                resultGlamur,
//                                                                                                                                                                                                resultKiss,
//                                                                                                                                                                                                resultEsse,
//                                                                                                                                                                                                resultQuin,
//                                                                                                                                                                                                resultLady,
//                                                                                                                                                                                                resultMor,
//                                                                                                                                                                                                resultChester,
//                                                                                                                                                                                                resultRadopy,
//                                                                                                                                                                                                resultStuardessa,
//                                                                                                                                                                                                resultStolichniye,
//                                                                                                                                                                                                resultDonskoy,
//                                                                                                                                                                                                resultTroyka,
//                                                                                                                                                                                                resultFast,
//                                                                                                                                                                                                resultRoyal,
//                                                                                                                                                                                                resultManchester,
//                                                                                                                                                                                                resultPrestigue,
//                                                                                                                                                                                                resultPremier,
//                                                                                                                                                                                                resultCosmos,
//                                                                                                                                                                                                resultNext,
//                                                                                                                                                                                                resultMagnat,
//                                                                                                                                                                                                resultMinsk,
//                                                                                                                                                                                                resultSouz,
//
//                                                                                                                                                                                                coefBond,
//                                                                                                                                                                                                coefKent,
//                                                                                                                                                                                                coefParlament,
//                                                                                                                                                                                                coefWinston,
//                                                                                                                                                                                                coefLm,
//                                                                                                                                                                                                coefMalboro,
//                                                                                                                                                                                                coefRotmans,
//                                                                                                                                                                                                coefLd,
//                                                                                                                                                                                                coefFmorris,
//                                                                                                                                                                                                coefAliance,
//                                                                                                                                                                                                coefJava,
//                                                                                                                                                                                                coefOptima,
//                                                                                                                                                                                                coefPetr,
//                                                                                                                                                                                                coefMaksim,
//                                                                                                                                                                                                coefCrests,
//                                                                                                                                                                                                coefVog,
//                                                                                                                                                                                                coefGlamur,
//                                                                                                                                                                                                coefKiss,
//                                                                                                                                                                                                coefEsse,
//                                                                                                                                                                                                coefQuin,
//                                                                                                                                                                                                coefLady,
//                                                                                                                                                                                                coefMor,
//                                                                                                                                                                                                coefChester,
//                                                                                                                                                                                                coefRadopy,
//                                                                                                                                                                                                coefStuardessa,
//                                                                                                                                                                                                coefStolichniye,
//                                                                                                                                                                                                coefDonskoy,
//                                                                                                                                                                                                coefTroyka,
//                                                                                                                                                                                                coefFast,
//                                                                                                                                                                                                coefRoyal,
//                                                                                                                                                                                                coefManchester,
//                                                                                                                                                                                                coefPrestigue,
//                                                                                                                                                                                                coefPremier,
//                                                                                                                                                                                                coefCosmos,
//                                                                                                                                                                                                coefNext,
//                                                                                                                                                                                                coefMagnat,
//                                                                                                                                                                                                coefMinsk,
//                                                                                                                                                                                                coefSouz
//                                                                                                                                                                                        );
//                                                                                                                                                                                    }
//                                                                                                                                                                                }
//                                                                                                                                                                            }
//                                                                                                                                                                        }
//                                                                                                                                                                    }
//                                                                                                                                                                }
//                                                                                                                                                            }
//                                                                                                                                                        }
//
//                                                                                                                                                    }
//                                                                                                                                                }
//                                                                                                                                            }
//                                                                                                                                        }
//                                                                                                                                    }
//                                                                                                                                }
//                                                                                                                            }
//                                                                                                                        }
//                                                                                                                    }
//                                                                                                                }
//                                                                                                            }
//                                                                                                        }
//                                                                                                    }
//                                                                                                }
//                                                                                            }
//                                                                                        }
//                                                                                    }
//                                                                                }
//                                                                            }
//                                                                        }
//                                                                    }
//                                                                }
//                                                            }
//                                                        }
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
}
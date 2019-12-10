package com.example.demo.repo;

import com.example.demo.domain.Parameters;
import com.example.demo.domain.Sigarets;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SigaretsRepo {

    private JdbcTemplate jdbcTemplate;

    public SigaretsRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    private static final String GET_SIGARETS_RESULT_BY_GROUPID = "select * from sigaretsResult where groupId = ?";
    private static final String FIND_RESULTSIGARETS_BY_ID = "SELECT * from SIGARETSRESULT where id = ?";
    private static final String SAVE_RESULTSIGARETS = "INSERT INTO SIGARETSRESULT (firstId, secondId, sumBond, sumKent, sumParlament, sumWinston, sumLm,  sumMalboro, sumRotmans, sumLd, sumFmorris, sumAliance, sumJava, sumOptima, sumPetr, sumMaksim, sumCrests, sumVog, sumGlamur, sumKiss, sumEsse, sumQuin, sumLady, sumMor, sumChester, sumRadopy, sumStuardessa, sumStolichniye, sumDonskoy, sumTroyka, sumFast, sumRoyal,sumManchester, sumPrestigue, sumPremier, sumCosmos, sumNext, sumMagnat, sumMinsk, sumSouz,\n" +
            "                          resultBond, resultKent, resultParlament, resultWinston, resultLm, resultMalboro, resultRotmans, resultLd, resultFmorris, resultAliance, resultJava, resultOptima, resultPetr, resultMaksim, resultCrests, resultVog, resultGlamur, resultKiss, resultEsse, resultQuin, resultLady, resultMor, resultChester, resultRadopy, resultStuardessa, resultStolichniye, resultDonskoy, resultTroyka, resultFast, resultRoyal, resultManchester, resultPrestigue, resultPremier, resultCosmos, resultNext, resultMagnat, resultMinsk, resultSouz, coefBond, coefKent, coefParlament, coefWinston, coefLm, coefMalboro, coefRotmans, coefLd, coefFmorris, coefAliance, coefJava, coefOptima, coefPetr, coefMaksim, coefCrests, coefVog, coefGlamur, coefKiss, coefEsse, coefQuin, coefLady,coefMor, coefChester, coefRadopy, coefStuardessa, coefStolichniye, coefDonskoy, coefTroyka, coefFast, coefRoyal, coefManchester, coefPrestigue, coefPremier, coefCosmos, coefNext, coefMagnat, coefMinsk, coefSouz,\n" +
            "                          parameter1, parameter2, parameter3, parameter4, parameter5, parameter6, parameter7, parameter8, parameter9, parameter10, parameter11, parameter12, parameter13, parameter14, parameter15, parameter16, parameter17, parameter18, parameter19, parameter20, parameter21, parameter22, parameter23, parameter24,  parameter25, parameter26, parameter27, parameter28, parameter29, parameter30, parameter31, parameter32, parameter33, parameter34, parameter35, parameter36,parameter37, parameter38)" +
            "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String GET_PARAMS = "SELECT * from PARAMETERS";

    private static final String SAVE_SIGARETS = "INSERT INTO SIGARETS (bond,kent,parlament,winston,lm,malboro,rotmans,ld,fmorris,aliance,java,optima,petr,maksim,crests,vog,glamur,kiss,esse,quin,lady,mor,chester,radopy,stuardessa,stolichniye,donskoy,troyka,fast,royal,manchester,prestigue,premier,cosmos,next,magnat,minsk,souz) " +
            "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SAVE_TEMPSIGARETS = "INSERT INTO SIGARETS (bond,kent,parlament,winston,lm,malboro,rotmans,ld,fmorris,aliance,java,optima,petr,maksim,crests,vog,glamur,kiss,esse,quin,lady,mor,chester,radopy,stuardessa,stolichniye,donskoy,troyka,fast,royal,manchester,prestigue,premier,cosmos,next,magnat,minsk,souz) " +
            "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_SIGARETS = "UPDATE SIGARETS set bond=?,kent=?,parlament=?,winston=?,lm=?,malboro=?,rotmans=?,ld=?,fmorris=?,aliance=?,java=?,optima=?,petr=?,maksim=?,crests=?,vog=?,glamur=?,kiss=?,esse=?,quin=?,lady=?,mor=?,chester=?,radopy=?,stuardessa=?,stolichniye=?,donskoy=?,troyka=?,fast=?,royal=?,manchester=?,prestigue=?,premier=?,cosmos=?,next=?,magnat=?,minsk=?,souz=? where id=?";
    private static final String GET_SIGARETS_BY_ID = "SELECT * FROM SIGARETS WHERE ID=?";

    public List<Parameters> getAllResults() {
        return jdbcTemplate.query(GET_PARAMS,
                (rs, i) -> new Parameters(
                        rs.getInt("id"),
                        rs.getDouble("parameter1"),
                        rs.getDouble("parameter2"),
                        rs.getDouble("parameter3"),
                        rs.getDouble("parameter4"),
                        rs.getDouble("parameter5"),
                        rs.getDouble("parameter6"),
                        rs.getDouble("parameter7"),
                        rs.getDouble("parameter8"),
                        rs.getDouble("parameter9"),
                        rs.getDouble("parameter10"),
                        rs.getDouble("parameter11"),
                        rs.getDouble("parameter12"),
                        rs.getDouble("parameter13"),
                        rs.getDouble("parameter14"),
                        rs.getDouble("parameter15"),
                        rs.getDouble("parameter16"),
                        rs.getDouble("parameter17"),
                        rs.getDouble("parameter18"),
                        rs.getDouble("parameter19"),
                        rs.getDouble("parameter20"),
                        rs.getDouble("parameter21"),
                        rs.getDouble("parameter22"),
                        rs.getDouble("parameter23"),
                        rs.getDouble("parameter24"),
                        rs.getDouble("parameter25"),
                        rs.getDouble("parameter26"),
                        rs.getDouble("parameter27"),
                        rs.getDouble("parameter28"),
                        rs.getDouble("parameter29"),
                        rs.getDouble("parameter30"),
                        rs.getDouble("parameter31"),
                        rs.getDouble("parameter32"),
                        rs.getDouble("parameter33"),
                        rs.getDouble("parameter34"),
                        rs.getDouble("parameter35"),
                        rs.getDouble("parameter36"),
                        rs.getDouble("parameter37"),
                        rs.getDouble("parameter38")
                )
        );
    }



    public Sigarets getSigaretsById(int id) {
        return jdbcTemplate.queryForObject(GET_SIGARETS_BY_ID,
                new Object[]{id},
                (rs, i) -> new Sigarets(
                        rs.getInt("id"),
                        rs.getDouble("bond"),
                        rs.getDouble("kent"),
                        rs.getDouble("parlament"),
                        rs.getDouble("winston"),
                        rs.getDouble("lm"),
                        rs.getDouble("malboro"),
                        rs.getDouble("rotmans"),
                        rs.getDouble("ld"),
                        rs.getDouble("fmorris"),
                        rs.getDouble("aliance"),
                        rs.getDouble("java"),
                        rs.getDouble("optima"),
                        rs.getDouble("petr"),
                        rs.getDouble("maksim"),
                        rs.getDouble("crests"),
                        rs.getDouble("vog"),
                        rs.getDouble("glamur"),
                        rs.getDouble("kiss"),
                        rs.getDouble("esse"),
                        rs.getDouble("quin"),
                        rs.getDouble("lady"),
                        rs.getDouble("mor"),
                        rs.getDouble("chester"),
                        rs.getDouble("radopy"),
                        rs.getDouble("stuardessa"),
                        rs.getDouble("stolichniye"),
                        rs.getDouble("donskoy"),
                        rs.getDouble("troyka"),
                        rs.getDouble("fast"),
                        rs.getDouble("royal"),
                        rs.getDouble("manchester"),
                        rs.getDouble("prestigue"),
                        rs.getDouble("premier"),
                        rs.getDouble("cosmos"),
                        rs.getDouble("next"),
                        rs.getDouble("magnat"),
                        rs.getDouble("minsk"),
                        rs.getDouble("souz")
                )
        );
    }

    public void updateSigarets(Sigarets sigarets) {
        jdbcTemplate.update(UPDATE_SIGARETS,
                sigarets.getBond(),
                sigarets.getKent(),
                sigarets.getParlament(),
                sigarets.getWinston(),
                sigarets.getLm(),
                sigarets.getMalboro(),
                sigarets.getRotmans(),
                sigarets.getLd(),
                sigarets.getFmorris(),
                sigarets.getAliance(),
                sigarets.getJava(),
                sigarets.getOptima(),
                sigarets.getPetr(),
                sigarets.getMaksim(),
                sigarets.getCrests(),
                sigarets.getVog(),
                sigarets.getGlamur(),
                sigarets.getKiss(),
                sigarets.getEsse(),
                sigarets.getQuin(),
                sigarets.getLady(),
                sigarets.getMor(),
                sigarets.getChester(),
                sigarets.getRadopy(),
                sigarets.getStuardessa(),
                sigarets.getStolichniye(),
                sigarets.getDonskoy(),
                sigarets.getTroyka(),
                sigarets.getFast(),
                sigarets.getRoyal(),
                sigarets.getManchester(),
                sigarets.getPrestigue(),
                sigarets.getPremier(),
                sigarets.getCosmos(),
                sigarets.getNext(),
                sigarets.getMagnat(),
                sigarets.getMinsk(),
                sigarets.getSouz(),
                sigarets.getId()
        );
    }

    public void saveSigarets(Sigarets worker) {
        jdbcTemplate.update(SAVE_SIGARETS,
                worker.getBond(),
                worker.getKent(),
                worker.getParlament(),
                worker.getWinston(),
                worker.getLm(),
                worker.getMalboro(),
                worker.getRotmans(),
                worker.getLd(),
                worker.getFmorris(),
                worker.getAliance(),
                worker.getJava(),
                worker.getOptima(),
                worker.getPetr(),
                worker.getMaksim(),
                worker.getCrests(),
                worker.getVog(),
                worker.getGlamur(),
                worker.getKiss(),
                worker.getEsse(),
                worker.getQuin(),
                worker.getLady(),
                worker.getMor(),
                worker.getChester(),
                worker.getRadopy(),
                worker.getStuardessa(),
                worker.getStolichniye(),
                worker.getDonskoy(),
                worker.getTroyka(),
                worker.getFast(),
                worker.getRoyal(),
                worker.getManchester(),
                worker.getPrestigue(),
                worker.getPremier(),
                worker.getCosmos(),
                worker.getNext(),
                worker.getMagnat(),
                worker.getMinsk(),
                worker.getSouz());
//        jdbcTemplate.update(SAVE_TEMPSIGARETS,
//                worker.getBond(),
//                worker.getKent(),
//                worker.getParlament(),
//                worker.getWinston(),
//                worker.getLm(),
//                worker.getMalboro(),
//                worker.getRotmans(),
//                worker.getLd(),
//                worker.getFmorris(),
//                worker.getAliance(),
//                worker.getJava(),
//                worker.getOptima(),
//                worker.getPetr(),
//                worker.getMaksim(),
//                worker.getCrests(),
//                worker.getVog(),
//                worker.getGlamur(),
//                worker.getKiss(),
//                worker.getEsse(),
//                worker.getQuin(),
//                worker.getLady(),
//                worker.getMor(),
//                worker.getChester(),
//                worker.getRadopy(),
//                worker.getStuardessa(),
//                worker.getStolichniye(),
//                worker.getDonskoy(),
//                worker.getTroyka(),
//                worker.getFast(),
//                worker.getRoyal(),
//                worker.getManchester(),
//                worker.getPrestigue(),
//                worker.getPremier(),
//                worker.getCosmos(),
//                worker.getNext(),
//                worker.getMagnat(),
//                worker.getMinsk(),
//                worker.getSouz());
    }

}

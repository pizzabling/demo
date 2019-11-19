package com.example.demo.repo;

import com.example.demo.domain.Parameters;
import com.example.demo.domain.ResultSigarets;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.tags.Param;

import java.util.List;

@Repository
public class SigaretsRepo {
    private JdbcTemplate jdbcTemplate;

    public SigaretsRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String GET_SIGARETS_RESULT = "select * from sigaretsResult";
    private static final String GET_SIGARETS_RESULT_BY_ID = "select * from sigaretsResult where groupId = ?";
    private static final String FIND_RESULTSIGARETS_BY_ID = "SELECT * from SIGARETSRESULT where id = ?";
    private static final String SAVE_RESULTSIGARETS = "INSERT INTO SIGARETSRESULT (firstId, secondId, sumBond, sumKent, sumParlament, sumWinston, sumLm,  sumMalboro, sumRotmans, sumLd, sumFmorris, sumAliance, sumJava, sumOptima, sumPetr, sumMaksim, sumCrests, sumVog, sumGlamur, sumKiss, sumEsse, sumQuin, sumLady, sumMor, sumChester, sumRadopy, sumStuardessa, sumStolichniye, sumDonskoy, sumTroyka, sumFast, sumRoyal,sumManchester, sumPrestigue, sumPremier, sumCosmos, sumNext, sumMagnat, sumMinsk, sumSouz,\n" +
            "                          resultBond, resultKent, resultParlament, resultWinston, resultLm, resultMalboro, resultRotmans, resultLd, resultFmorris, resultAliance, resultJava, resultOptima, resultPetr, resultMaksim, resultCrests, resultVog, resultGlamur, resultKiss, resultEsse, resultQuin, resultLady, resultMor, resultChester, resultRadopy, resultStuardessa, resultStolichniye, resultDonskoy, resultTroyka, resultFast, resultRoyal, resultManchester, resultPrestigue, resultPremier, resultCosmos, resultNext, resultMagnat, resultMinsk, resultSouz, coefBond, coefKent, coefParlament, coefWinston, coefLm, coefMalboro, coefRotmans, coefLd, coefFmorris, coefAliance, coefJava, coefOptima, coefPetr, coefMaksim, coefCrests, coefVog, coefGlamur, coefKiss, coefEsse, coefQuin, coefLady,coefMor, coefChester, coefRadopy, coefStuardessa, coefStolichniye, coefDonskoy, coefTroyka, coefFast, coefRoyal, coefManchester, coefPrestigue, coefPremier, coefCosmos, coefNext, coefMagnat, coefMinsk, coefSouz,\n" +
            "                          parameter1, parameter2, parameter3, parameter4, parameter5, parameter6, parameter7, parameter8, parameter9, parameter10, parameter11, parameter12, parameter13, parameter14, parameter15, parameter16, parameter17, parameter18, parameter19, parameter20, parameter21, parameter22, parameter23, parameter24,  parameter25, parameter26, parameter27, parameter28, parameter29, parameter30, parameter31, parameter32, parameter33, parameter34, parameter35, parameter36,parameter37, parameter38)" +
            "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String GET_PARAMS = "SELECT * from PARAMETERS";
    private static final String FIND_PARAMS_BY_ID = "SELECT * FROM PARAMETERS WHERE id = ?";
    private static final String SAVE_PARAMS = "UPDATE PARAMETERS set parameter1 = ?,parameter2 = ?,parameter3 = ?,parameter4 = ?,parameter5 = ?," +
            "parameter6 = ?,parameter7 = ?,parameter8 = ?,parameter9 = ?,parameter10 = ?," +
            "parameter11 = ?,parameter12 = ?,parameter13 = ?,parameter14 = ?,parameter15 = ?," +
            "parameter16 = ?,parameter17 = ?,parameter18 = ?,parameter19 = ?,parameter20 = ?," +
            "parameter21 = ?,parameter22 = ?,parameter23 = ?,parameter24 = ?,parameter25 = ?," +
            "parameter26 = ?,parameter27 = ?,parameter28 = ?,parameter29 = ?,parameter30 = ?," +
            "parameter31 = ?,parameter32 = ?,parameter33 = ?,parameter34 = ?,parameter35 = ?," +
            "parameter36 = ?,parameter37 = ?,parameter38 = ? where id = 1";


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

    public Parameters findParamsById(int id) {
        return jdbcTemplate.queryForObject(FIND_PARAMS_BY_ID,
                new Object[]{id},
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

    public void saveParams(Parameters parameters){
        jdbcTemplate.update(SAVE_PARAMS,
                parameters.getParameter1(),
                parameters.getParameter2(),
                parameters.getParameter3(),
                parameters.getParameter4(),
                parameters.getParameter5(),
                parameters.getParameter6(),
                parameters.getParameter7(),
                parameters.getParameter8(),
                parameters.getParameter9(),
                parameters.getParameter10(),
                parameters.getParameter11(),
                parameters.getParameter12(),
                parameters.getParameter13(),
                parameters.getParameter14(),
                parameters.getParameter15(),
                parameters.getParameter16(),
                parameters.getParameter17(),
                parameters.getParameter18(),
                parameters.getParameter19(),
                parameters.getParameter20(),
                parameters.getParameter21(),
                parameters.getParameter22(),
                parameters.getParameter23(),
                parameters.getParameter24(),
                parameters.getParameter25(),
                parameters.getParameter26(),
                parameters.getParameter27(),
                parameters.getParameter28(),
                parameters.getParameter29(),
                parameters.getParameter30(),
                parameters.getParameter31(),
                parameters.getParameter32(),
                parameters.getParameter33(),
                parameters.getParameter34(),
                parameters.getParameter35(),
                parameters.getParameter36(),
                parameters.getParameter37(),
                parameters.getParameter38()
        );
    }

    public ResultSigarets findResultSigaretsById(int id) {
        return jdbcTemplate.queryForObject(FIND_RESULTSIGARETS_BY_ID,
                new Object[]{id},
                (rs, i) -> new ResultSigarets(
                        rs.getInt("id"),
                        rs.getInt("firstId"),
                        rs.getInt("secondId"),
                        rs.getInt("procentZp"),
                        rs.getDouble("sumBond"),
                        rs.getDouble("sumKent"),
                        rs.getDouble("sumParlament"),
                        rs.getDouble("sumWinston"),
                        rs.getDouble("sumLm"),
                        rs.getDouble("sumMalboro"),
                        rs.getDouble("sumRotmans"),
                        rs.getDouble("sumLd"),
                        rs.getDouble("sumFmorris"),
                        rs.getDouble("sumAliance"),
                        rs.getDouble("sumJava"),
                        rs.getDouble("sumOptima"),
                        rs.getDouble("sumPetr"),
                        rs.getDouble("sumMaksim"),
                        rs.getDouble("sumCrests"),
                        rs.getDouble("sumVog"),
                        rs.getDouble("sumGlamur"),
                        rs.getDouble("sumKiss"),
                        rs.getDouble("sumEsse"),
                        rs.getDouble("sumQuin"),
                        rs.getDouble("sumLady"),
                        rs.getDouble("sumMor"),
                        rs.getDouble("sumChester"),
                        rs.getDouble("sumRadopy"),
                        rs.getDouble("sumStuardessa"),
                        rs.getDouble("sumStolichniye"),
                        rs.getDouble("sumDonskoy"),
                        rs.getDouble("sumTroyka"),
                        rs.getDouble("sumFast"),
                        rs.getDouble("sumRoyal"),
                        rs.getDouble("sumManchester"),
                        rs.getDouble("sumPrestigue"),
                        rs.getDouble("sumPremier"),
                        rs.getDouble("sumCosmos"),
                        rs.getDouble("sumNext"),
                        rs.getDouble("sumMagnat"),
                        rs.getDouble("sumMinsk"),
                        rs.getDouble("sumSouz"),

                        rs.getDouble("resultBond"),
                        rs.getDouble("resultKent"),
                        rs.getDouble("resultParlament"),
                        rs.getDouble("resultWinston"),
                        rs.getDouble("resultLm"),
                        rs.getDouble("resultMalboro"),
                        rs.getDouble("resultRotmans"),
                        rs.getDouble("resultLd"),
                        rs.getDouble("resultFmorrin"),
                        rs.getDouble("resultAliance"),
                        rs.getDouble("resultJava"),
                        rs.getDouble("resultOptima"),
                        rs.getDouble("resultPetr"),
                        rs.getDouble("resultMaksim"),
                        rs.getDouble("resultCrests"),
                        rs.getDouble("resultVog"),
                        rs.getDouble("resultGlamur"),
                        rs.getDouble("resultKiss"),
                        rs.getDouble("resultEsse"),
                        rs.getDouble("resultQuin"),
                        rs.getDouble("resultLady"),
                        rs.getDouble("resultMor"),
                        rs.getDouble("resultChester"),
                        rs.getDouble("resultRadopy"),
                        rs.getDouble("resultStuardessa"),
                        rs.getDouble("resultStolichniye"),
                        rs.getDouble("resultDonskoy"),
                        rs.getDouble("resultTroyka"),
                        rs.getDouble("resultFast"),
                        rs.getDouble("resultRoyal"),
                        rs.getDouble("resultManchester"),
                        rs.getDouble("resultPrestigue"),
                        rs.getDouble("resultPremier"),
                        rs.getDouble("resultCosmos"),
                        rs.getDouble("resultNext"),
                        rs.getDouble("resultMagnat"),
                        rs.getDouble("resultMinsk"),
                        rs.getDouble("resultSouz"),

                        rs.getDouble("coefBond"),
                        rs.getDouble("coefKent"),
                        rs.getDouble("coefParlament"),
                        rs.getDouble("coefWinston"),
                        rs.getDouble("coefLm"),
                        rs.getDouble("coefMalboro"),
                        rs.getDouble("coefRotmans"),
                        rs.getDouble("coefLd"),
                        rs.getDouble("coefFmorris"),
                        rs.getDouble("coefAliance"),
                        rs.getDouble("coefJava"),
                        rs.getDouble("coefOptima"),
                        rs.getDouble("coefPetr"),
                        rs.getDouble("coefMaksim"),
                        rs.getDouble("coefCrests"),
                        rs.getDouble("coefVog"),
                        rs.getDouble("coefGlamur"),
                        rs.getDouble("coefKiss"),
                        rs.getDouble("coefEsse"),
                        rs.getDouble("coefQuin"),
                        rs.getDouble("coefLady"),
                        rs.getDouble("coefMor"),
                        rs.getDouble("coefChester"),
                        rs.getDouble("coefRadopy"),
                        rs.getDouble("coefStuardessa"),
                        rs.getDouble("coefStolichniye"),
                        rs.getDouble("coefDonskoy"),
                        rs.getDouble("coefTroyka"),
                        rs.getDouble("coefFast"),
                        rs.getDouble("coefRoyal"),
                        rs.getDouble("coefManchester"),
                        rs.getDouble("coefPrestigue"),
                        rs.getDouble("coefPremier"),
                        rs.getDouble("coefCosmos"),
                        rs.getDouble("coefNext"),
                        rs.getDouble("coefMagnat"),
                        rs.getDouble("coefMinsk"),
                        rs.getDouble("coefSouz")
                ));
    }

    public void save(ResultSigarets resultSigarets) {
        if (resultSigarets.getId() == 0) {
            jdbcTemplate.update(SAVE_RESULTSIGARETS,
                    resultSigarets.getFirstId()
            );
        }
    }

}
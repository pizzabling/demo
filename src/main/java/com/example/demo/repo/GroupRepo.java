package com.example.demo.repo;

import com.example.demo.domain.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupRepo {
    private JdbcTemplate jdbcTemplate;

    public GroupRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String GET_GROUP_8 ="SELECT * FROM GROUP8" ;
    private static final String GET_GROUP_6 ="SELECT * FROM GROUP6" ;
    private static final String GET_GROUP_4 = "SELECT * FROM GROUP4";
    private static final String GET_GROUP_3 = "SELECT * FROM GROUP3";
    private static final String GET_GROUP_2 = "SELECT id, workerfirst, workersecond, salarypercentfirst, salarypercentsecond, rentfirst, rentsecond, expenses FROM GROUP2";
    private static final String GET_GROUP_2_BY_ID = "SELECT workerFirst, workerSecond,salarypercentfirst, salarypercentsecond, rentfirst, rentsecond expenses from group2 where id=?";
    private static final String ADD_GROUP_TWO ="INSERT INTO GROUP2 (workerFirst,workerSecond,SALARYPERCENTFIRST,SALARYPERCENTSECOND,rentFirst,rentSecond,expenses) values (?,?,?,?,?,?,?)" ;
    private static final String ADD_GROUP_THREE ="INSERT INTO GROUP3 (workerFirst,workerSecond,workerThird,rentFirst,rentSecond,rentThird,expenses) values(?,?,?,?,?,?,?)" ;
    private static final String ADD_GROUP_FOUR ="INSERT INTO GROUP4 (workerFirst,workerSecond,workerThird,workerFourth,rentFirst,rentSecond,rentThird,rentFourth,expenses) values(?,?,?,?,?,?,?,?,?)" ;
    private static final String ADD_GROUP_SIX ="INSERT INTO GROUP6 (workerFirst,workerSecond,workerThird,workeeFourth,workerFifth,workerSixth,rentFirst,rentSecond,rentThird,rentFourth,rentFifth,rentSixth,expenses) values(?,?,?,?,?,?,?,?,?,?,?)" ;
    private static final String ADD_GROUP_EIGHT ="INSERT INTO GROUP8 (workerFirst,workerSecond,workerThird,workerFourth,workerFifth,workerSixth,workerSeventh,workerEighth,rentFirst,rentSecond,rentThird,rentFourth,rentFifth,rentSixth,rentSeventh,rentEighth,expenses) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)" ;
    private static final String GET_SIGARETS_RESULT = "select * from sigaretsResult";

    public List<ResultSigarets> getAllBestsGroup() {
        return jdbcTemplate.query(GET_SIGARETS_RESULT,
                (rs, i) -> new ResultSigarets(
                        rs.getInt("id"),
                        rs.getInt("firstId"),
                        rs.getInt("secondId"),
                        rs.getDouble("okladFirst"),
                        rs.getDouble("okladSecond"),
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
                        rs.getDouble("resultRotmans"),
                        rs.getDouble("resultLd"),
                        rs.getDouble("resultMalboro"),
                        rs.getDouble("resultFmorris"),
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
                )
        );
    }

    public List<GroupTwo> getGroup2() {
        return jdbcTemplate.query(GET_GROUP_2,
                (rs, i) -> new GroupTwo(
                        rs.getInt("id"),
                        rs.getInt("workerFirst"),
                        rs.getInt("workerSecond"),
                        rs.getInt("salaryPercentFirst"),
                        rs.getInt("salaryPercentSecond"),
                        rs.getDouble("rentFirst"),
                        rs.getDouble("rentSecond"),
                        rs.getDouble("expenses")
                )
        );
    }

    public List<GroupThree> getGroup3() {
        return jdbcTemplate.query(GET_GROUP_3,
                (rs, i) -> new GroupThree(
                        rs.getInt("id"),
                        rs.getInt("workerFirst"),
                        rs.getInt("workerSecond"),
                        rs.getInt("workerThird"),
                        rs.getDouble("rentFirst"),
                        rs.getDouble("rentSecond"),
                        rs.getDouble("rentThird"),
                        rs.getDouble("expenses")
                )
        );
    }

    public List<GroupFour> getGroup4() {
        return jdbcTemplate.query(GET_GROUP_4,
                (rs, i) -> new GroupFour(
                        rs.getInt("id"),
                        rs.getInt("workerFirst"),
                        rs.getInt("workerSecond"),
                        rs.getInt("workerThird"),
                        rs.getInt("workerFourth"),
                        rs.getDouble("rentFirst"),
                        rs.getDouble("rentSecond"),
                        rs.getDouble("rentThird"),
                        rs.getDouble("rentFourth"),
                        rs.getDouble("expenses")
                )
        );
    }

    public List<GroupSix> getGroup6() {
        return jdbcTemplate.query(GET_GROUP_6,
                (rs,i)->new GroupSix(
                        rs.getInt("id"),
                        rs.getInt("workerFirst"),
                        rs.getInt("workerSecond"),
                        rs.getInt("workerThird"),
                        rs.getInt("workerFourth"),
                        rs.getInt("workerFifth"),
                        rs.getInt("workerSixth"),
                        rs.getDouble("rentFirst"),
                        rs.getDouble("rentSecond"),
                        rs.getDouble("rentThird"),
                        rs.getDouble("rentFourth"),
                        rs.getDouble("rentFifth"),
                        rs.getDouble("rentSixth"),
                        rs.getDouble("expenses")
                ));
    }

    public List<GroupEight> getGroup8(){
        return jdbcTemplate.query(GET_GROUP_8,
                (rs,i)->new GroupEight(
                        rs.getInt("id"),
                        rs.getInt("workerFirst"),
                        rs.getInt("workerSecond"),
                        rs.getInt("workerThird"),
                        rs.getInt("workerFourth"),
                        rs.getInt("workerFifth"),
                        rs.getInt("workerSixth"),
                        rs.getInt("workerSeventh"),
                        rs.getInt("workerEighth"),
                        rs.getDouble("rentFirst"),
                        rs.getDouble("rentSecond"),
                        rs.getDouble("rentThird"),
                        rs.getDouble("rentFourth"),
                        rs.getDouble("rentFifth"),
                        rs.getDouble("rentSixth"),
                        rs.getDouble("rentSeventh"),
                        rs.getDouble("rentEighth"),
                        rs.getDouble("expenses")
                )
        );
    }

    public void addGroup2(GroupTwo groupTwo) {
        jdbcTemplate.update(ADD_GROUP_TWO,
                groupTwo.getWorkerFirst(),
                groupTwo.getWorkerSecond(),
                groupTwo.getSalaryPercentFirst(),
                groupTwo.getSalaryPercentSecond(),
                groupTwo.getRentFirst(),
                groupTwo.getRentSecond(),
                groupTwo.getExpenses()

        );
    }
    public void addGroup3(GroupThree groupThree){
        jdbcTemplate.update(ADD_GROUP_THREE,
                groupThree.getWorkerFirst(),
                groupThree.getWorkerSecond(),
                groupThree.getWorkerThird(),
                groupThree.getRentFirst(),
                groupThree.getRentSecond(),
                groupThree.getRentThird(),
                groupThree.getExpenses()
        );
    }

    public void addGroup4(GroupFour groupFour){
        jdbcTemplate.update(ADD_GROUP_FOUR,
                groupFour.getWorkerFirst(),
                groupFour.getRentSecond(),
                groupFour.getWorkerThird(),
                groupFour.getRentFourth(),
                groupFour.getRentFirst(),
                groupFour.getRentSecond(),
                groupFour.getRentThird(),
                groupFour.getRentFourth(),
                groupFour.getExpenses()
        );
    }
    public void addGroup6(GroupSix groupSix){
        jdbcTemplate.update(ADD_GROUP_FOUR,
                groupSix.getWorkerFirst(),
                groupSix.getRentSecond(),
                groupSix.getWorkerThird(),
                groupSix.getRentFourth(),
                groupSix.getWorkerFifth(),
                groupSix.getWorkerSixth(),
                groupSix.getRentFirst(),
                groupSix.getRentSecond(),
                groupSix.getRentThird(),
                groupSix.getRentFourth(),
                groupSix.getRentFifth(),
                groupSix.getRentSixth(),
                groupSix.getExpenses()
        );
    }
    public void addGroup8(GroupEight groupEight){
        jdbcTemplate.update(ADD_GROUP_FOUR,
                groupEight.getWorkerFirst(),
                groupEight.getRentSecond(),
                groupEight.getWorkerThird(),
                groupEight.getWorkerFifth(),
                groupEight.getWorkerSixth(),
                groupEight.getWorkerSeventh(),
                groupEight.getWorkerEighth(),
                groupEight.getRentFirst(),
                groupEight.getRentSecond(),
                groupEight.getRentThird(),
                groupEight.getRentFourth(),
                groupEight.getRentFifth(),
                groupEight.getRentSixth(),
                groupEight.getRentSeventh(),
                groupEight.getRentEighth(),
                groupEight.getExpenses()
        );
    }

    public GroupTwo getGroup2ById(int id) {
        return jdbcTemplate.queryForObject(GET_GROUP_2_BY_ID,
                new Object[]{id},
                (rs,i)-> new GroupTwo(
                        rs.getInt("id"),
                        rs.getInt("workerFirst"),
                        rs.getInt("workerSecond"),
                        rs.getInt("salaryPercentFirst"),
                        rs.getInt("salaryPercentSecond"),
                        rs.getDouble("rentFirst"),
                        rs.getDouble("rentSecond"),
                        rs.getDouble("expenses")
                ));
    }
}

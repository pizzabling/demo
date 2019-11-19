package com.example.demo.repo;

import com.example.demo.domain.BestWorker;
import com.example.demo.domain.ResultSigarets;
import com.example.demo.domain.Worker;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class Repo {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public Repo(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;


        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private static final String GET_WORKER_PARAMETERS = "SELECT ID,WORKERID, RENT, JANRENT, FEBRENT, MARRENT, APRRENT, MAYRENT, JUNERENT, JULYRENT, AUGRENT, SEPRENT, OCTRENT, NOVRENT, DECRENT,NAME, RATIO,RENTRATIO from workers";
    private static final String FIND_WORKER_BY_ID = "select ID, WORKERID, RENT, JANRENT, FEBRENT, MARRENT, APRRENT, MAYRENT, JUNERENT, JULYRENT, AUGRENT, SEPRENT, OCTRENT, NOVRENT, DECRENT, NAME, RATIO, RENTRATIO, BOND, KENT, PARLAMENT, WINSTON, LM, MALBORO, ROTMANS, LD, FMORRIS, ALIANCE, JAVA, OPTIMA, PETR, MAKSIM, CRESTS, VOG, GLAMUR, KISS, ESSE, QUIN, LADY, MOR, CHESTER, RADOPY, STUARDESSA, STOLICHNIYE, DONSKOY, TROYKA, FAST, ROYAL, MANCHESTER, PRESTIGUE, PREMIER, COSMOS, NEXT, MAGNAT, MINSK, SOUZ from WORKERS where id=?";
    private static final String FIND_WORKER_BY_ID_ONLY_RATIO = "select  ID,RATIO from WORKERS where id=?";
    private static final String FIND_WORKER_BY_NAME = "select * from WORKERS where name=?";
    private static final String SAVE_WORKER = "insert into WORKERS (workerId,rent,name,janRent,febRent,marRent,aprRent,mayRent,juneRent,julyRent,augRent,sepRent,octRent,novRent,decRent,RATIO) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String GET_SIGARETS_PARAMETERS = "SELECT id,bond,kent,parlament,winston,lm,malboro,rotmans,ld,fmorris,aliance,java,optima,petr,maksim,crests,vog,glamur,kiss,esse,quin,lady,mor,chester,radopy,stuardessa,stolichniye,donskoy,troyka,fast,royal,manchester,prestigue,premier,cosmos,next,magnat,minsk,souz from sigarets";
    private static final String FIND_SIGARETS_BY_ID = "SELECT id,bond,kent,parlament,winston,lm,malboro,rotmans,ld,fmorris,aliance,java,optima,petr,maksim,crests,vog,glamur,kiss,esse,quin,lady,mor,chester,radopy,stuardessa,stolichniye,donskoy,troyka,fast,royal,manchester,prestigue,premier,cosmos,next,magnat,minsk,souz from sigarets where id = ?";
    private static final String SAVE_SIGARETS = "INSERT INTO SIGARETS (bond,kent,parlament,winston,lm,malboro,rotmans,ld,fmorris,aliance,java,optima,petr,maksim,crests,vog,glamur,kiss,esse,quin,lady,mor,chester,radopy,stuardessa,stolichniye,donskoy,troyka,fast,royal,manchester,prestigue,premier,cosmos,next,magnat,minsk,souz) " +
            "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


    public List<Worker> getWorkers() {
        return jdbcTemplate.query(
                GET_WORKER_PARAMETERS,
                (rs, i) -> new Worker(
                        rs.getInt("id"),
                        rs.getInt("workerId"),
                        rs.getDouble("rent"),
                        rs.getDouble("janRent"),
                        rs.getDouble("febRent"),
                        rs.getDouble("marRent"),
                        rs.getDouble("aprRent"),
                        rs.getDouble("mayRent"),
                        rs.getDouble("juneRent"),
                        rs.getDouble("julyRent"),
                        rs.getDouble("augRent"),
                        rs.getDouble("sepRent"),
                        rs.getDouble("octRent"),
                        rs.getDouble("novRent"),
                        rs.getDouble("decRent"),
                        rs.getString("name"),
                        rs.getDouble("ratio"),
                        rs.getDouble("rentRatio")

//                        rs.getDouble("bond"),
//                        rs.getDouble("kent"),
//                        rs.getDouble("parlament"),
//                        rs.getDouble("winston"),
//                        rs.getDouble("lm"),
//                        rs.getDouble("malboro"),
//                        rs.getDouble("rotmans"),
//                        rs.getDouble("ld"),
//                        rs.getDouble("fmorris"),
//                        rs.getDouble("aliance"),
//                        rs.getDouble("java"),
//                        rs.getDouble("optima"),
//                        rs.getDouble("petr"),
//                        rs.getDouble("maksim"),
//                        rs.getDouble("crests"),
//                        rs.getDouble("vog"),
//                        rs.getDouble("glamur"),
//                        rs.getDouble("kiss"),
//                        rs.getDouble("esse"),
//                        rs.getDouble("quin"),
//                        rs.getDouble("lady"),
//                        rs.getDouble("mor"),
//                        rs.getDouble("chester"),
//                        rs.getDouble("radopy"),
//                        rs.getDouble("stuardessa"),
//                        rs.getDouble("stolichniye"),
//                        rs.getDouble("donskoy"),
//                        rs.getDouble("troyka"),
//                        rs.getDouble("fast"),
//                        rs.getDouble("royal"),
//                        rs.getDouble("manchester"),
//                        rs.getDouble("prestigue"),
//                        rs.getDouble("premier"),
//                        rs.getDouble("cosmos"),
//                        rs.getDouble("next"),
//                        rs.getDouble("magnat"),
//                        rs.getDouble("minsk"),
//                        rs.getDouble("souz")


                )
        );

    }

//    public List<ResultSigarets> getSigarets() {
//        Worker worker = new Worker();
//        return jdbcTemplate.query(GET_SIGARETS_PARAMETERS,
//                (rs, i) -> new ResultSigarets(
//                        rs.getInt("id"),
//                        rs.getDouble("bond"),
//                        rs.getDouble("kent"),
//                        rs.getDouble("parlament"),
//                        rs.getDouble("winston"),
//                        rs.getDouble("lm"),
//                        rs.getDouble("malboro"),
//                        rs.getDouble("rotmans"),
//                        rs.getDouble("ld"),
//                        rs.getDouble("fmorris"),
//                        rs.getDouble("aliance"),
//                        rs.getDouble("java"),
//                        rs.getDouble("optima"),
//                        rs.getDouble("petr"),
//                        rs.getDouble("maksim"),
//                        rs.getDouble("crests"),
//                        rs.getDouble("vog"),
//                        rs.getDouble("glamur"),
//                        rs.getDouble("kiss"),
//                        rs.getDouble("esse"),
//                        rs.getDouble("quin"),
//                        rs.getDouble("lady"),
//                        rs.getDouble("mor"),
//                        rs.getDouble("chester"),
//                        rs.getDouble("radopy"),
//                        rs.getDouble("stuardessa"),
//                        rs.getDouble("stolichniye"),
//                        rs.getDouble("donskoy"),
//                        rs.getDouble("troyka"),
//                        rs.getDouble("fast"),
//                        rs.getDouble("royal"),
//                        rs.getDouble("manchester"),
//                        rs.getDouble("prestigue"),
//                        rs.getDouble("premier"),
//                        rs.getDouble("cosmos"),
//                        rs.getDouble("next"),
//                        rs.getDouble("magnat"),
//                        rs.getDouble("minsk"),
//                        rs.getDouble("souz")
//                )
//        );
//    }

//    public ResultSigarets findSigaretsById(int id) {
////            ResultSet rs = statement.exe
//
//        return jdbcTemplate.queryForObject(FIND_SIGARETS_BY_ID,
//                new Object[]{id},
//                (rs, i) -> new ResultSigarets(rs.getInt("id"),
//                        rs.getDouble("bond"),
//                        rs.getDouble("kent"),
//                        rs.getDouble("parlament"),
//                        rs.getDouble("winston"),
//                        rs.getDouble("lm"),
//                        rs.getDouble("malboro"),
//                        rs.getDouble("rotmans"),
//                        rs.getDouble("ld"),
//                        rs.getDouble("fmorris"),
//                        rs.getDouble("aliance"),
//                        rs.getDouble("java"),
//                        rs.getDouble("optima"),
//                        rs.getDouble("petr"),
//                        rs.getDouble("maksim"),
//                        rs.getDouble("crests"),
//                        rs.getDouble("vog"),
//                        rs.getDouble("glamur"),
//                        rs.getDouble("kiss"),
//                        rs.getDouble("esse"),
//                        rs.getDouble("quin"),
//                        rs.getDouble("lady"),
//                        rs.getDouble("mor"),
//                        rs.getDouble("chester"),
//                        rs.getDouble("radopy"),
//                        rs.getDouble("stuardessa"),
//                        rs.getDouble("stolichniye"),
//                        rs.getDouble("donskoy"),
//                        rs.getDouble("troyka"),
//                        rs.getDouble("fast"),
//                        rs.getDouble("royal"),
//                        rs.getDouble("manchester"),
//                        rs.getDouble("prestigue"),
//                        rs.getDouble("premier"),
//                        rs.getDouble("cosmos"),
//                        rs.getDouble("next"),
//                        rs.getDouble("magnat"),
//                        rs.getDouble("minsk"),
//                        rs.getDouble("souz")
//                ));
//    }

    public Worker findWorkerByName(String name) {
        return jdbcTemplate.queryForObject(FIND_WORKER_BY_NAME,
                new Object[]{name},
                (rs, i) -> new Worker(
                        rs.getInt("id"),
                        rs.getInt("workerId"),
                        rs.getDouble("rent"),
                        rs.getDouble("janRent"),
                        rs.getDouble("febRent"),
                        rs.getDouble("marRent"),
                        rs.getDouble("aprRent"),
                        rs.getDouble("mayRent"),
                        rs.getDouble("juneRent"),
                        rs.getDouble("julyRent"),
                        rs.getDouble("augRent"),
                        rs.getDouble("sepRent"),
                        rs.getDouble("octRent"),
                        rs.getDouble("novRent"),
                        rs.getDouble("decRent"),
                        rs.getString("name"),
                        rs.getDouble("ratio"),
                        rs.getDouble("rentRatio"),

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

    public Worker findWorkerById(int id) {
        return jdbcTemplate.queryForObject(FIND_WORKER_BY_ID,
                new Object[]{id},
                (rs, i) -> new Worker(
                        rs.getInt("id"),
                        rs.getInt("workerId"),
                        rs.getDouble("rent"),
                        rs.getDouble("janRent"),
                        rs.getDouble("febRent"),
                        rs.getDouble("marRent"),
                        rs.getDouble("aprRent"),
                        rs.getDouble("mayRent"),
                        rs.getDouble("juneRent"),
                        rs.getDouble("julyRent"),
                        rs.getDouble("augRent"),
                        rs.getDouble("sepRent"),
                        rs.getDouble("octRent"),
                        rs.getDouble("novRent"),
                        rs.getDouble("decRent"),
                        rs.getString("name"),
                        rs.getDouble("ratio"),
                        rs.getDouble("rentRatio"),

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
//public Worker findWorkerById(int id) {
//    return jdbcTemplate.queryForObject(FIND_WORKER_BY_ID_ONLY_RATIO,
//            new Object[]{id},
//            (rs, i) -> new Worker(
//                    rs.getInt("id"),
//                    rs.getInt("workerId"),
//                    rs.getDouble("rent"),
//                    rs.getDouble("janRent"),
//                    rs.getDouble("febRent"),
//                    rs.getDouble("marRent"),
//                    rs.getDouble("aprRent"),
//                    rs.getDouble("mayRent"),
//                    rs.getDouble("juneRent"),
//                    rs.getDouble("julyRent"),
//                    rs.getDouble("augRent"),
//                    rs.getDouble("sepRent"),
//                    rs.getDouble("octRent"),
//                    rs.getDouble("novRent"),
//                    rs.getDouble("decRent"),
//                    rs.getString("name"),
//                    rs.getDouble("ratio"),
//                    rs.getDouble("rentRatio"),
//
//                    rs.getDouble("bond"),
//                    rs.getDouble("kent"),
//                    rs.getDouble("parlament"),
//                    rs.getDouble("winston"),
//                    rs.getDouble("lm"),
//                    rs.getDouble("malboro"),
//                    rs.getDouble("rotmans"),
//                    rs.getDouble("ld"),
//                    rs.getDouble("fmorris"),
//                    rs.getDouble("aliance"),
//                    rs.getDouble("java"),
//                    rs.getDouble("optima"),
//                    rs.getDouble("petr"),
//                    rs.getDouble("maksim"),
//                    rs.getDouble("crests"),
//                    rs.getDouble("vog"),
//                    rs.getDouble("glamur"),
//                    rs.getDouble("kiss"),
//                    rs.getDouble("esse"),
//                    rs.getDouble("quin"),
//                    rs.getDouble("lady"),
//                    rs.getDouble("mor"),
//                    rs.getDouble("chester"),
//                    rs.getDouble("radopy"),
//                    rs.getDouble("stuardessa"),
//                    rs.getDouble("stolichniye"),
//                    rs.getDouble("donskoy"),
//                    rs.getDouble("troyka"),
//                    rs.getDouble("fast"),
//                    rs.getDouble("royal"),
//                    rs.getDouble("manchester"),
//                    rs.getDouble("prestigue"),
//                    rs.getDouble("premier"),
//                    rs.getDouble("cosmos"),
//                    rs.getDouble("next"),
//                    rs.getDouble("magnat"),
//                    rs.getDouble("minsk"),
//                    rs.getDouble("souz")
//
//            )
//    );
//}


    public void saveWorker(Worker worker) {

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("workerId", worker.getWorkerId())
                .addValue("rent", worker.getRent())
                .addValue("name", worker.getName())
                .addValue("janRent", worker.getJanRent())
                .addValue("febRent", worker.getFebRent())
                .addValue("marRent", worker.getMarRent())
                .addValue("aprRent", worker.getAprRent())
                .addValue("mayRent", worker.getMayRent())
                .addValue("juneRent", worker.getJuneRent())
                .addValue("julyRent", worker.getJulyRent())
                .addValue("augRent", worker.getAugRent())
                .addValue("sepRent", worker.getSepRent())
                .addValue("octRent", worker.getOctRent())
                .addValue("novRent", worker.getNovRent())
                .addValue("decRent", worker.getDecRent())
                .addValue("ratio", 10_000 / worker.getRent());


        if (worker.getId() == 0) {

            jdbcTemplate.update(SAVE_WORKER,
                    worker.getWorkerId(),
                    worker.getRent(),
                    worker.getName(),
                    worker.getJanRent(),
                    worker.getFebRent(),
                    worker.getMarRent(),
                    worker.getAprRent(),
                    worker.getMayRent(),
                    worker.getJuneRent(),
                    worker.getJulyRent(),
                    worker.getAugRent(),
                    worker.getSepRent(),
                    worker.getOctRent(),
                    worker.getNovRent(),
                    worker.getDecRent(),
                    10_000 / worker.getRent()
//                    worker.getRent()*10_000/worker.getRent()
            );
            jdbcTemplate.update(SAVE_SIGARETS,
                    worker.getAliance(),
                    worker.getBond(),
                    worker.getChester(),
                    worker.getCosmos(),
                    worker.getCrests(),
                    worker.getDonskoy(),
                    worker.getEsse(),
                    worker.getFast(),
                    worker.getFmorris(),
                    worker.getGlamur(),
                    worker.getJava(),
                    worker.getKent(),
                    worker.getKiss(),
                    worker.getLady(),
                    worker.getLd(),
                    worker.getLm(),
                    worker.getMagnat(),
                    worker.getMinsk(),
                    worker.getMaksim(),
                    worker.getMalboro(),
                    worker.getManchester(),
                    worker.getMor(),
                    worker.getNext(),
                    worker.getOptima(),
                    worker.getParlament(),
                    worker.getPetr(),
                    worker.getPremier(),
                    worker.getPrestigue(),
                    worker.getQuin(),
                    worker.getRadopy(),
                    worker.getRotmans(),
                    worker.getRoyal(),
                    worker.getSouz(),
                    worker.getStolichniye(),
                    worker.getStuardessa(),
                    worker.getTroyka(),
                    worker.getVog(),
                    worker.getWinston());
        }
        jdbcTemplate.update("insert into rent (ID, RENT) VALUES ( ?,? )",
                worker.getId(), worker.getRent()
        );
    }
}
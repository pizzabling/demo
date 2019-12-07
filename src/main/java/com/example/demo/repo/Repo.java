package com.example.demo.repo;

import com.example.demo.domain.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

@Repository
public class Repo {


    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public Repo(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    private static final String GET_WORKER_PARAMETERS = "SELECT ID,WORKERID, RENT, JANRENT, FEBRENT, MARRENT, APRRENT, MAYRENT, JUNERENT, JULYRENT, AUGRENT, SEPRENT, OCTRENT, NOVRENT, DECRENT,NAME, RATIO,COMMENT from workers";
    private static final String FIND_WORKER_BY_ID = "select ID, WORKERID, RENT, JANRENT, FEBRENT, MARRENT, APRRENT, MAYRENT, JUNERENT, JULYRENT, AUGRENT, SEPRENT, OCTRENT, NOVRENT, DECRENT, NAME, RATIO, comment from WORKERS where id=?";
    private static final String FIND_WORKER_BY_NAME = "select * from WORKERS where name=?";
    private static final String SAVE_WORKER = "insert into WORKERS (workerId,rent,janRent,febRent,marRent,aprRent,mayRent,juneRent,julyRent,augRent,sepRent,octRent,novRent,decRent,NAME,RATIO,COMMENT) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SAVE_PARSE_WORKER = "insert into WORKERS(workerId,rent,RATIO) values (?,?,?)";
    private static final String UPDATE_WORKER = "UPDATE WORKERS set NAME=?, WORKERID=?,RENT=?,RATIO=?, COMMENT=? where id=?";
    private static final String GET_SIGARETS_PARAMETERS = "SELECT id,bond,kent,parlament,winston,lm,malboro,rotmans,ld,fmorris,aliance,java,optima,petr,maksim,crests,vog,glamur,kiss,esse,quin,lady,mor,chester,radopy,stuardessa,stolichniye,donskoy,troyka,fast,royal,manchester,prestigue,premier,cosmos,next,magnat,minsk,souz from sigarets";
    private static final String FIND_SIGARETS_BY_ID = "SELECT id,bond,kent,parlament,winston,lm,malboro,rotmans,ld,fmorris,aliance,java,optima,petr,maksim,crests,vog,glamur,kiss,esse,quin,lady,mor,chester,radopy,stuardessa,stolichniye,donskoy,troyka,fast,royal,manchester,prestigue,premier,cosmos,next,magnat,minsk,souz from sigarets where id = ?";
    private static final String UPDATE_SIGARETS = "UPDATE SIGARETS set bond=?,kent=?,parlament=?,winston=?,lm=?,malboro=?,rotmans=?,ld=?,fmorris=?,aliance=?,java=?,optima=?,petr=?,maksim=?,crests=?,vog=?,glamur=?,kiss=?,esse=?,quin=?,lady=?,mor=?,chester=?,radopy=?,stuardessa=?,stolichniye=?,donskoy=?,troyka=?,fast=?,royal=?,manchester=?,prestigue=?,premier=?,cosmos=?,next=?,magnat=?,minsk=?,souz=? where id=?";


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
                        rs.getString("comment")
                )
        );
    }


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
                        rs.getString("comment"),

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
                        rs.getString("comment")
                )
        );
    }


    public void removeWorkerByid(int id) {
        jdbcTemplate.update("DELETE from WORKERS where ID=?",
                id);
        jdbcTemplate.update("DELETE from SIGARETS where ID=?",
                id);
    }

    public void updateWorkerById(Worker worker) {
        jdbcTemplate.update(UPDATE_WORKER,
                worker.getName(),
                worker.getWorkerId(),
                worker.getRent(),
                10_000 / worker.getRent(),
                worker.getComment(),
                worker.getId()
        );

    }

    public void saveParseWorker(Worker worker){
        jdbcTemplate.update(SAVE_PARSE_WORKER,
                worker.getWorkerId(),
                worker.getRent(),
                10_000/worker.getRent());
    }

    public void deleteAllWorkers(){
        jdbcTemplate.update("DELETE FROM WORKERS");
        jdbcTemplate.update("DELETE FROM SIGARETS");
        jdbcTemplate.update("DELETE FROM TEMPORARYRESULTFORSIGARETS");
    }
    public void saveWorker(Worker worker) {
        jdbcTemplate.update(SAVE_WORKER,
                worker.getWorkerId(),
                worker.getRent(),
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
                worker.getName(),
                10_000 / worker.getRent(),
                worker.getComment());
//        }else{
//            jdbcTemplate.update(UPDATE_WORKER,
//                    worker.getWorkerId(),
//                    worker.getRent(),
//                    worker.getJanRent(),
//                    worker.getFebRent(),
//                    worker.getMarRent(),
//                    worker.getAprRent(),
//                    worker.getMayRent(),
//                    worker.getJuneRent(),
//                    worker.getJulyRent(),
//                    worker.getAugRent(),
//                    worker.getSepRent(),
//                    worker.getOctRent(),
//                    worker.getNovRent(),
//                    worker.getDecRent(),
//                    worker.getName(),
//                    worker.getRatio(),
//
//                    worker.getBond(),
//                    worker.getKent(),
//                    worker.getParlament(),
//                    worker.getWinston(),
//                    worker.getLm(),
//                    worker.getMalboro(),
//                    worker.getRotmans(),
//                    worker.getLd(),
//                    worker.getFmorris(),
//                    worker.getAliance(),
//                    worker.getJava(),
//                    worker.getOptima(),
//                    worker.getPetr(),
//                    worker.getMaksim(),
//                    worker.getCrests(),
//                    worker.getVog(),
//                    worker.getGlamur(),
//                    worker.getKiss(),
//                    worker.getEsse(),
//                    worker.getQuin(),
//                    worker.getLady(),
//                    worker.getMor(),
//                    worker.getChester(),
//                    worker.getRadopy(),
//                    worker.getStuardessa(),
//                    worker.getStolichniye(),
//                    worker.getDonskoy(),
//                    worker.getTroyka(),
//                    worker.getFast(),
//                    worker.getRoyal(),
//                    worker.getManchester(),
//                    worker.getPrestigue(),
//                    worker.getPremier(),
//                    worker.getCosmos(),
//                    worker.getNext(),
//                    worker.getMagnat(),
//                    worker.getMinsk(),
//                    worker.getSouz());
//
    }
}


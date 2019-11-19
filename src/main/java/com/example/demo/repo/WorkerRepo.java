//package com.example.demo.repo;
//
//import com.example.demo.domain.Worker;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//
//public class WorkerRepo {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    public WorkerRepo(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//
//    public List<Worker> findAll() {
//        return jdbcTemplate.query(
//                "SELECT WORKERID, RENT, JANRENT, FEBRENT, MARRENT, APRRENT, MAYRENT, JUNERENT, JULYRENT, AUGRENT, SEPRENT, OCTRENT, NOVRENT, DECRENT from workers",
//                (rs, i) -> new Worker(
//
//    }
//
//    public Worker findById(int workerId) {
//        return jdbcTemplate.queryForObject(
//                "SELECT workerId, rent,janRent,febRent,marRent,aprRent,mayRent,juneRent,julyRent,augRent,sepRent,octRent,novRent,decRent from workers where workerId=?",
//                new Object[]{workerId},
//                (rs, i) -> new Worker(
//                        rs.getInt("workerId"),
//                        rs.getInt("rent"),
//                        rs.getInt("janRent"),
//                        rs.getInt("febRent"),
//                        rs.getInt("marRent"),
//                        rs.getInt("aprRent"),
//                        rs.getInt("mayRent"),
//                        rs.getInt("juneRent"),
//                        rs.getInt("julyRent"),
//                        rs.getInt("augRent"),
//                        rs.getInt("sepRent"),
//                        rs.getInt("octRent"),
//                        rs.getInt("novRent"),
//                        rs.getInt("decRent")
//                )
//        );
//    }
//
//    public void save(Worker worker) {
//        MapSqlParameterSource params = new MapSqlParameterSource();
//        params.addValue("workerId", worker.getWorkerId());
//        params.addValue("rent", worker.getRent());
//        params.addValue("janRent", worker.getJanRent());
//        params.addValue("febRent", worker.getFebRent());
//        params.addValue("marRent", worker.getMarRent());
//        params.addValue("aprRent", worker.getAprRent());
//        params.addValue("mayRent", worker.getMayRent());
//        params.addValue("juneRent", worker.getJuneRent());
//        params.addValue("julyRent", worker.getJulyRent());
//        params.addValue("augRent", worker.getAugRent());
//        params.addValue("sepRent", worker.getSepRent());
//        params.addValue("octRent", worker.getOctRent());
//        params.addValue("novRent", worker.getNovRent());
//        params.addValue("decRent", worker.getDecRent());
//
//        jdbcTemplate.update(
//                "INSERT INTO WORKERS(WORKERID,RENT,JANRENT,FEBRENT,MARRENT,APRRENT,MAYRENT,JUNERENT,JULYRENT,AUGRENT,SEPRENT,OCTRENT,NOVRENT,DECRENT) values (:WORKERID,:RENT,:JANRENT,:FEBRENT,:MARRENT,:APRRENT,:MAYRENT,:JUNERENT,:JULYRENT,:AUGRENT,:SEPRENT,:OCTRENT,:NOVRENT,:DECRENT)",
//                params
//        );
//  }
//
//
//}
//

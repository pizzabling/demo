package com.example.demo.service;

import com.example.demo.domain.Sigarets;
import com.example.demo.repo.SigaretsRepo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SigaretsService {
    private JdbcTemplate jdbcTemplate;
    private com.example.demo.service.Service service;
    private SigaretsRepo sigaretsRepo;
    private ParamsService paramsService;

    public SigaretsService(JdbcTemplate jdbcTemplate, com.example.demo.service.Service service, SigaretsRepo sigaretsRepo) {
        this.jdbcTemplate = jdbcTemplate;

        this.service = service;
        this.sigaretsRepo = sigaretsRepo;
    }

    private static final String FIND_ALL_BEST_GROUP = "SELECT * from SIGARETSRESULT";

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

    public Sigarets getSigaretsById(int id) {
        return sigaretsRepo.getSigaretsById(id);
    }







}
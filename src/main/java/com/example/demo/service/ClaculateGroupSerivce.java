package com.example.demo.service;

import com.example.demo.repo.GroupRepo;
import com.example.demo.repo.Repo;
import com.example.demo.repo.SigaretsRepo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ClaculateGroupSerivce {
    private final JdbcTemplate jdbcTemplate;
    private final Repo repo;
    private final SigaretsRepo sigaretsRepo;
    private final GroupRepo groupRepo;


    public ClaculateGroupSerivce(JdbcTemplate jdbcTemplate, Repo repo, SigaretsRepo sigaretsRepo, GroupRepo groupRepo) {
        this.jdbcTemplate = jdbcTemplate;
        this.repo = repo;
        this.sigaretsRepo = sigaretsRepo;
        this.groupRepo = groupRepo;
    }

    public void calculateGroup2(int id){
        var group2 = groupRepo.getGroup2ById(id);
        int workerIdFirst = group2.getWorkerFirst();
        int workerIdSecond = group2.getWorkerSecond();
        double rent1 = group2.getRentFirst();
        double rent2 = group2.getRentSecond();



    }
}

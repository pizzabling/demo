package com.example.demo.service;

import com.example.demo.domain.ResultSigarets;
import com.example.demo.domain.Worker;
import com.example.demo.repo.Repo;


import java.util.List;

@org.springframework.stereotype.Service

public class Service {
    private Repo repo;

    public Service(Repo repo) {
        this.repo = repo;
    }

    public List<Worker> getWorkers() {
        return repo.getWorkers();
    }
//    public List<ResultSigarets> getSigarets(){
//        return repo.getSigarets();
//    }
//    public ResultSigarets findSigaretsById(int id){
//        return repo.findSigaretsById(id);
//    }

    public Worker findWorkerById(int id){
        return repo.findWorkerById(id);
    }
    public Worker findWorkerByName(String name){
        return repo.findWorkerByName(name);
    }


    public void save(Worker worker){
        repo.saveWorker(worker);
    }

//    public ResultSigarets findResultSigaretsById(int id) {
//        return repo.findResultSigaretsById(id);
//    }
}

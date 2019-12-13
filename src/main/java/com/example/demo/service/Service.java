package com.example.demo.service;

import com.example.demo.domain.Worker;
import com.example.demo.repo.Repo;

import java.sql.SQLException;
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

    public Worker findWorkerById(int id) {
        return repo.findWorkerById(id);
    }

    public Worker findWorkerByWorkerId(int workerId){
        return repo.findWorkerByWorkerId(workerId);
    }

    public Worker findWorkerByName(String name) {
        return repo.findWorkerByName(name);
    }

    public void removeWorkerById(int id) {
        repo.removeWorkerByid(id);
    }

    public void saveWorker(Worker worker) throws SQLException {
        repo.saveWorker(worker);
    }

    public void saveParceWorker(int workerId, double rent){
        Worker worker = new Worker(workerId,rent);
        repo.saveParseWorker(worker);
    }

    public void deleteAllWorkers(){
        repo.deleteAllWorkers();
    }

    public void updateWorker(int id, int workerId, double rent, String comment, String name) {
        Worker worker = new Worker(id, workerId, rent, comment, name);
        repo.updateWorkerById(worker);
    }

    
}

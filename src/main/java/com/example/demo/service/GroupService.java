package com.example.demo.service;

import com.example.demo.domain.*;
import com.example.demo.domain.bestGroup.*;
import com.example.demo.repo.GroupRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private final GroupRepo groupRepo;

    public GroupService(GroupRepo groupRepo) {
        this.groupRepo = groupRepo;
    }

    public List<GroupTwo> getGroup2() {
        return groupRepo.getGroup2();
    }

    public List<GroupThree> getGroup3() {
        return groupRepo.getGroup3();
    }

    public List<GroupFour> getGroup4() {
        return groupRepo.getGroup4();
    }

    public List<GroupSix> getGroup6() {
        return groupRepo.getGroup6();
    }

    public List<GroupEight> getGroup8() {
        return groupRepo.getGroup8();
    }

    public void addGroup2(GroupTwo groupTwo) {
        groupRepo.addGroup2(groupTwo);
    }

    public ResultSigarets2 getBestGroup2ById(int id){
        return groupRepo.getBestGroup2ById(id);
    }
    public ResultSigarets3 getBestGroup3ById(int id){
        return groupRepo.getBestGroup3ById(id);
    }
    public ResultSigarets4 getBestGroup4ById(int id){
        return groupRepo.getBestGroup4ById(id);
    }
    public ResultSigarets5 getBestGroup5ById(int id){
        return groupRepo.getBestGroup5ById(id);
    }
    public ResultSigarets6 getBestGroup6ById(int id){
        return groupRepo.getBestGroup6ById(id);
    }
    public ResultSigarets7 getBestGroup7ById(int id){
        return groupRepo.getBestGroup7ById(id);
    }
    public ResultSigarets8 getBestGroup8ById(int id){
        return groupRepo.getBestGroup8ById(id);
    }


    public void addGroup3(GroupThree groupThree) {
        groupRepo.addGroup3(groupThree);
    }

    public void addGroup4(GroupFour groupFour) {
        groupRepo.addGroup4(groupFour);
    }

    public void addGroup6(GroupSix groupSix) {
        groupRepo.addGroup6(groupSix);
    }

    public void addGroup8(GroupEight groupEight) {
        groupRepo.addGroup8(groupEight);
    }
}

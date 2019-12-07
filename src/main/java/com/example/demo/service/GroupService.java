package com.example.demo.service;

import com.example.demo.domain.*;
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

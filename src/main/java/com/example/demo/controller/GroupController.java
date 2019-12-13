package com.example.demo.controller;

import com.example.demo.domain.*;
import com.example.demo.service.BestGroupService;
import com.example.demo.service.GroupService;
import com.example.demo.service.Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller("/group")
public class GroupController {

    private final GroupService groupService;
    private final BestGroupService bestGroupService;
    private final Service service;

    public GroupController(GroupService groupService, BestGroupService bestGroupService, Service service) {

        this.groupService = groupService;
        this.bestGroupService = bestGroupService;
        this.service = service;
    }

    @GetMapping("/bestsGroup")
    public String bestsGroup(Model model) {
        model.addAttribute("bgroup2", bestGroupService.getBestGroup2());
        model.addAttribute("bgroup3", bestGroupService.getBestGroup3());
        model.addAttribute("bgroup4", bestGroupService.getBestGroup4());
        model.addAttribute("bgroup5", bestGroupService.getBestGroup5());
        model.addAttribute("bgroup6", bestGroupService.getBestGroup6());
        model.addAttribute("bgroup7", bestGroupService.getBestGroup7());
        model.addAttribute("bgroup8", bestGroupService.getBestGroup8());
        return "bestsGroup";
    }


    @GetMapping("/bestGroup2")
    public String calcBestGroup2(Model model) {
        bestGroupService.saveBestGroup2();
        return "bestsGroup";
    }

    @GetMapping("/bestGroup3")
    public String calcBestGroup3(Model model) {
        bestGroupService.saveBestGroup3();
        return "bestsGroup";
    }

    @GetMapping("/bestGroup4")
    public String calcBestGroup4(Model model) {
        bestGroupService.saveBestGroup4();
        return "bestsGroup";
    }

    @GetMapping("/bestGroup5")
    public String calcBestGroup5(Model model) {
        bestGroupService.saveBestGroup5();
        return "bestsGroup";
    }

    @GetMapping("/bestGroup6")
    public String calcBestGroup6(Model model) {
        bestGroupService.saveBestGroup6();
        return "bestsGroup";
    }

    @GetMapping("/bestGroup7")
    public String calcBestGroup7(Model model) {
        bestGroupService.saveBestGroup7();
        return "bestsGroup";
    }

    @GetMapping("/bestGroup8")
    public String calcBestGroup8(Model model) {
        bestGroupService.saveBestGroup8();
        return "bestsGroup";
    }


    @GetMapping("/groups")
    public String groups(Model model) {
        model.addAttribute("workers2", groupService.getGroup2());
//        model.addAttribute("workers3", groupService.getGroup3());
//        model.addAttribute("workers4", groupService.getGroup4());
//        model.addAttribute("workers6", groupService.getGroup6());
//        model.addAttribute("workers8", groupService.getGroup8());
        return "groups";
    }

    @GetMapping("/group2")
    public String group2(Model model) {
        var group2 = groupService.getGroup2();
        model.addAttribute("workers", group2);
        return "group2";
    }

    @GetMapping("/createGroup2")
    public String setParamsGroup2(Model model) {

        return "createGroup2";
    }

    @PostMapping("/createGroup2")
    public String addGroup2(@ModelAttribute("groupTwo") @Valid GroupTwo groupTwo) {
        groupService.addGroup2(groupTwo);
        return "redirect:/";
    }

    @GetMapping("/group3")
    public String group3(Model model) {
        var group3 = groupService.getGroup3();
        model.addAttribute("workers", group3);
        return "group3";
    }

    @GetMapping("/createGroup3")
    public String setParamsGroup3() {
        return "createGroup3";
    }

    @PostMapping("/createGroup3")
    public String addGroup3(@ModelAttribute GroupThree groupThree) {
        groupService.addGroup3(groupThree);
        return "redirect:/";
    }

    @GetMapping("/group4")
    public String group4(Model model) {
        var group4 = groupService.getGroup4();
        model.addAttribute("workers", group4);
        return "group4";
    }

    @GetMapping("/createGroup4")
    public String setParamsGroup4() {
        return "createGroup4";
    }

    @PostMapping("/createGroup4")
    public String addGroup4(@ModelAttribute GroupFour groupFour) {
        groupService.addGroup4(groupFour);
        return "redirect:/";
    }

    @GetMapping("/group6")
    public String group6(Model model) {
        var group6 = groupService.getGroup6();
        model.addAttribute("workers", group6);
        return "group6";
    }

    @GetMapping("/createGroup6")
    public String setParamsGroup6(Model model) {
        return "createGroup6";
    }

    @PostMapping("/createGroup6")
    public String addGroup6(@ModelAttribute GroupSix groupSix) {
        groupService.addGroup6(groupSix);
        return "redirect:/";
    }

    @GetMapping("/group8")
    public String group8(Model model) {
        var group8 = groupService.getGroup8();
        model.addAttribute("workers", group8);
        return "group8";
    }

    @GetMapping("/createGroup8")
    public String setParamsGroup8() {
        return "createGroup8";
    }

    @PostMapping("/createGroup8")
    public String addGroup8(@ModelAttribute GroupEight groupEight) {
        groupService.addGroup8(groupEight);
        return "redirect:/";
    }

    @GetMapping("/bGroups2/{id}")
    public String getBestGroup2ById(@PathVariable int id, Model model) {
        var group = groupService.getBestGroup2ById(id);
        model.addAttribute("group", group);
        return "bGroups2";
    }

    @GetMapping("/bGroups3/{id}")
    public String getBestGroup3ById(@PathVariable int id, Model model) {
        var group = groupService.getBestGroup3ById(id);
        model.addAttribute("group", group);
        return "bGroups3";
    }

    @GetMapping("/bGroups4/{id}")
    public String getBestGroup4ById(@PathVariable int id, Model model){
        var group = groupService.getBestGroup4ById(id);
        model.addAttribute("group",group);
        return"bGroups4";
    }

    @GetMapping("/bGroups5/{id}")
    public String getBestGroup5ById(@PathVariable int id, Model model) {
        var group = groupService.getBestGroup5ById(id);
        model.addAttribute("group", group);
        return "bGroups5";
    }

    @GetMapping("/bGroups6/{id}")
    public String getBestGroup6ById(@PathVariable int id, Model model){
        var group = groupService.getBestGroup6ById(id);
        model.addAttribute("group",group);
        return"bGroups6";
    }

    @GetMapping("/bGroups7/{id}")
    public String getBestGroup7ById(@PathVariable int id, Model model) {
        var group = groupService.getBestGroup7ById(id);
        model.addAttribute("group", group);
        return "bGroups7";
    }

    @GetMapping("/bGroups8/{id}")
    public String getBestGroup8ById(@PathVariable int id, Model model){
        var group = groupService.getBestGroup8ById(id);
        model.addAttribute("group",group);
        return"bGroups8";
    }
}

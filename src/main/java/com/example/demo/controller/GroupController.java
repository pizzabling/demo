package com.example.demo.controller;

import com.example.demo.domain.*;
import com.example.demo.service.GroupService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller("/group")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {

        this.groupService = groupService;
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
}

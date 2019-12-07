package com.example.demo.controller;

import com.example.demo.domain.*;


import com.example.demo.service.GroupService;
import com.example.demo.service.ParseWorkersService;
import com.example.demo.service.Service;
import com.example.demo.service.SigaretsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@Controller
@RequestMapping("/")

public class WorkerController {

    private final Service service;
    private final SigaretsService sigaretsService;
    private final GroupService groupService;
    private final ParseWorkersService parseWorkersService;


    public WorkerController(Service service, SigaretsService sigaretsService, GroupService groupService, ParseWorkersService parseWorkersService) {
        this.service = service;
        this.sigaretsService = sigaretsService;
        this.groupService = groupService;
        this.parseWorkersService = parseWorkersService;
    }


    @GetMapping("/")
    public String getAll(Model model) throws IOException {
        model.addAttribute("workers", service.getWorkers());
        return "main";
    }

    @GetMapping("/rentCalc")
    public String rentCalc(Model model, @ModelAttribute BestWorker bestWorker) {
//        bestWorkerService.findBestWorker();
        model.addAttribute("workers", service.getWorkers());
        model.addAttribute("bestRent", bestWorker.getBestRent());
        return "rentCalc";
    }

    @GetMapping("/stocks")
    public String getAllStoks(Model model) {
        return "stocks";
    }


    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @PostMapping("/add")
    public String addWorker(@ModelAttribute Worker worker,@ModelAttribute Sigarets sigarets) throws SQLException {
        service.saveWorker(worker);
        sigaretsService.saveSigarets(sigarets);
        return "redirect:/";
    }

    @GetMapping("/worker/{id}")
    public String workerPage(@PathVariable int id,
                             Model model) {
        var worker = service.findWorkerById(id);
        var sigarets = sigaretsService.getSigaretsById(id);
        model.addAttribute("title", worker.getName());
        model.addAttribute("worker", worker);
        model.addAttribute("sigarets",sigarets);
        return "worker";
    }


    @GetMapping("/params")
    public String params() {
        return "params";
    }


    @PostMapping("/params")
    public String saveParams(@RequestParam int parameter1, @RequestParam int parameter2,
                             @RequestParam int parameter3, @RequestParam int parameter4, @RequestParam int parameter5,
                             @RequestParam int parameter6, @RequestParam int parameter7, @RequestParam int parameter8,
                             @RequestParam int parameter9, @RequestParam int parameter10, @RequestParam int parameter11,
                             @RequestParam int parameter12, @RequestParam int parameter13, @RequestParam int parameter14,
                             @RequestParam int parameter15, @RequestParam int parameter16, @RequestParam int parameter17,
                             @RequestParam int parameter18, @RequestParam int parameter19, @RequestParam int parameter20,
                             @RequestParam int parameter21, @RequestParam int parameter22, @RequestParam int parameter23,
                             @RequestParam int parameter24, @RequestParam int parameter25, @RequestParam int parameter26,
                             @RequestParam int parameter27, @RequestParam int parameter28, @RequestParam int parameter29,
                             @RequestParam int parameter30, @RequestParam int parameter31, @RequestParam int parameter32,
                             @RequestParam int parameter33, @RequestParam int parameter34, @RequestParam int parameter35,
                             @RequestParam int parameter36, @RequestParam int parameter37, @RequestParam int parameter38) {
        sigaretsService.save(parameter1, parameter2, parameter3, parameter4, parameter5,
                parameter6, parameter7, parameter8, parameter9, parameter10, parameter11,
                parameter12, parameter13, parameter14, parameter15, parameter16, parameter17,
                parameter18, parameter19, parameter20, parameter21, parameter22, parameter23,
                parameter24, parameter25, parameter26, parameter27, parameter28, parameter29,
                parameter30, parameter31, parameter32, parameter33, parameter34, parameter35,
                parameter36, parameter37, parameter38);

        return "params";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable int id, Model model) {
        var worker = service.findWorkerById(id);
        var sigarets = sigaretsService.getSigaretsById(id);
        model.addAttribute("worker", worker);
        model.addAttribute("sigarets", sigarets);
        return "edit";
    }
    @GetMapping("/parseWorkers")
    public String parseWorkers() throws IOException {
        parseWorkersService.parseWorkersFromExcel();
        return "redirect:/";
    }
    @PostMapping("/edit/{id}")
    public String editWorker(@PathVariable int id, @RequestParam int workerId, @RequestParam double rent,
                             @RequestParam String comment,
                             @RequestParam String name, @RequestParam double bond, @RequestParam double kent,
                             @RequestParam double parlament, @RequestParam double winston, @RequestParam double lm,
                             @RequestParam double malboro, @RequestParam double rotmans,
                             @RequestParam double ld, @RequestParam double fmorris, @RequestParam double aliance,
                             @RequestParam double java,
                             @RequestParam double optima, @RequestParam double petr, @RequestParam double maksim,
                             @RequestParam double crests,
                             @RequestParam double vog, @RequestParam double glamur, @RequestParam double kiss,
                             @RequestParam double esse,
                             @RequestParam double quin, @RequestParam double lady, @RequestParam double mor,
                             @RequestParam double chester,
                             @RequestParam double radopy, @RequestParam double stuardessa, @RequestParam double stolichniye,
                             @RequestParam double donskoy, @RequestParam double troyka, @RequestParam double fast,
                             @RequestParam double royal, @RequestParam double manchester, @RequestParam double prestigue, @RequestParam double premier,
                             @RequestParam double cosmos, @RequestParam double next, @RequestParam double magnat,
                             @RequestParam double minsk, @RequestParam double souz, Model model) {

        service.updateWorker(id, workerId, rent, comment, name);
        sigaretsService.updateSigarets(id, bond, kent, parlament, winston, lm,
                malboro, rotmans, ld, fmorris, aliance, java, optima, petr,
                maksim, crests, vog, glamur, kiss, esse, quin, lady, mor, chester, radopy,
                stuardessa, stolichniye, donskoy, troyka, fast, royal, manchester, prestigue,
                premier, cosmos, next, magnat, minsk, souz);

        return "redirect:/";
    }

    @PostMapping("/edit/{id}/remove")
    public String removeWorker(@PathVariable int id) {
        service.removeWorkerById(id);
        return "redirect:/";
    }
    @GetMapping("/deleteAllWorkers")
    public String deleteAll(){
        service.deleteAllWorkers();
        return "redirect:/";
    }

    @GetMapping("/bestsGroup")
    public String bestsGroup(Model model) {
        sigaretsService.saveBestGroup2();
        model.addAttribute("bests", sigaretsService.getAllBestGroup());

        return "bestsGroup";
    }
}

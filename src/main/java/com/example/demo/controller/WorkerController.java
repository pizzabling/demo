package com.example.demo.controller;

import com.example.demo.domain.BestWorker;
import com.example.demo.domain.Parameters;
import com.example.demo.domain.Worker;


import com.example.demo.service.Service;
import com.example.demo.service.SigaretsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/")

public class WorkerController {

    private final Service service;
    private final SigaretsService sigaretsService;


    public WorkerController(Service service, SigaretsService sigaretsService) {
        this.service = service;
        this.sigaretsService = sigaretsService;
    }


    @GetMapping("/")
    public String getAll(Model model) throws IOException {
        model.addAttribute("workers", service.getWorkers());
        return "main";
    }

    @GetMapping("/rentCalc")
    public String rentCalc(Model model, BestWorker bestWorker) {
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
    public String addWorker() {
        return "add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Worker worker) {
        service.save(worker);

        return "redirect:/";
    }

    @GetMapping("/worker/{id}")
    public String workerPage(@PathVariable int id,
                             Model model) {
        var worker = service.findWorkerById(id);
        model.addAttribute("title", worker.getName());
        model.addAttribute("worker", worker);
        return "worker";
    }

    @GetMapping("/params")
    public String params() {
        return "params";
    }

    @PostMapping("/params")
    public String saveParams(@ModelAttribute Parameters parameters) {
        sigaretsService.save(parameters);

        return "params";
    }

    @GetMapping("/bestsGroup")
    public String bestsGroup(Model model) {
        sigaretsService.saveBestGroup();
        model.addAttribute("best", sigaretsService.findAll());

        return "bestsGroup";
    }
//    @GetMapping("/search")
//    public String searchByName(Model model,@PathVariable String text){
//        model.addAttribute("search",service.findWorkerByName(text));
//        return "search";
//    }
}

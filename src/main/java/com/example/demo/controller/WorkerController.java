package com.example.demo.controller;

import com.example.demo.domain.BestWorker;
import com.example.demo.domain.Sigarets;
import com.example.demo.domain.Worker;
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
    @GetMapping("/worker/workerId{workerId}")
    public String workerPageByWorkerId(@PathVariable int workerId, Model model){
        var worker = service.findWorkerByWorkerId(workerId);
        int id = worker.getId();
        var sigarets = sigaretsService.getSigaretsById(id);
        model.addAttribute("title", worker.getName());
        model.addAttribute("worker", worker);
        model.addAttribute("sigarets",sigarets);
        return "worker";
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


}

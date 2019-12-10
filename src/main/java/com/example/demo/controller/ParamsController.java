package com.example.demo.controller;

import com.example.demo.service.ParamsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamsController {
    private final ParamsService service;

    public ParamsController(ParamsService service) {
        this.service = service;
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
        service.saveParams(parameter1, parameter2, parameter3, parameter4, parameter5,
                parameter6, parameter7, parameter8, parameter9, parameter10, parameter11,
                parameter12, parameter13, parameter14, parameter15, parameter16, parameter17,
                parameter18, parameter19, parameter20, parameter21, parameter22, parameter23,
                parameter24, parameter25, parameter26, parameter27, parameter28, parameter29,
                parameter30, parameter31, parameter32, parameter33, parameter34, parameter35,
                parameter36, parameter37, parameter38);

        return "params";
    }
    @GetMapping("/paramsGroup")
    public String setParamsG(Model model){
        return "paramsGroup";
    }
    @PostMapping("/paramsGroup")
    public String setParamsGroup(@RequestParam double paramsGroup1, @RequestParam double paramsGroup2,
                                 @RequestParam double paramsGroup3, @RequestParam double paramsGroup4,
                                 @RequestParam double paramsGroup5, @RequestParam double paramsGroup6,
                                 @RequestParam double paramsGroup7) {
        service.saveGroupParams(paramsGroup1, paramsGroup2, paramsGroup3, paramsGroup4, paramsGroup5,
                paramsGroup6, paramsGroup7);
        return "redirect:/";
    }
    @GetMapping("/paramsAll")
    public String setAllG(Model model){
        return "paramsAll";
    }
    @PostMapping("/paramsAll")
    public String setAllParams(@RequestParam double allParams) {
        service.saveAllParams(allParams);
        return "redirect:/";
    }
}

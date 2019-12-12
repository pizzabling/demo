package com.example.demo.domain;

import lombok.Data;

@Data
public class ResultFormula {
    private double acc;
    private String rest;

    public ResultFormula(double v, String r) {
        this.acc = v;
        this.rest = r;
    }
}

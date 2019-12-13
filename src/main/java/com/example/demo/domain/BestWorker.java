package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
@AllArgsConstructor
public class BestWorker {
    private int bestId;
    private double bestRent;

    public int getBestId() {
        return bestId;
    }

    public void setBestId(int bestId) {
        this.bestId = bestId;
    }

    public double getBestRent() {
        return bestRent;
    }

    public void setBestRent(double bestRent) {
        this.bestRent = bestRent;
    }
}

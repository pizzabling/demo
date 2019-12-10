package com.example.demo.service;

import com.example.demo.domain.GroupParams;
import com.example.demo.domain.Parameters;
import com.example.demo.repo.ParamsRepo;
import org.springframework.stereotype.Service;

@Service
public class ParamsService {
    private final ParamsRepo repo;

    public ParamsService(ParamsRepo repo) {
        this.repo = repo;
    }

    public void saveGroupParams(double groupParams1, double groupParams2, double groupParams3, double groupParams4,
                                double groupParams5, double groupParams6, double groupParams7) {
        GroupParams params = new GroupParams(groupParams1, groupParams2, groupParams3, groupParams4, groupParams5,
                groupParams6, groupParams7);
        repo.saveGroupParams(params);
    }

    public void saveAllParams(double allParams) {
        repo.saveAllParams(allParams);
    }

    public void saveParams(int parameter1, int parameter2, int parameter3, int parameter4, int parameter5,
                           int parameter6, int parameter7, int parameter8, int parameter9, int parameter10, int parameter11,
                           int parameter12, int parameter13, int parameter14, int parameter15, int parameter16, int parameter17,
                           int parameter18, int parameter19, int parameter20, int parameter21, int parameter22, int parameter23,
                           int parameter24, int parameter25, int parameter26, int parameter27, int parameter28, int parameter29,
                           int parameter30, int parameter31, int parameter32, int parameter33, int parameter34, int parameter35,
                           int parameter36, int parameter37, int parameter38) {
        Parameters params = new Parameters(parameter1, parameter2, parameter3, parameter4, parameter5,
                parameter6, parameter7, parameter8, parameter9, parameter10, parameter11,
                parameter12, parameter13, parameter14, parameter15, parameter16, parameter17,
                parameter18, parameter19, parameter20, parameter21, parameter22, parameter23,
                parameter24, parameter25, parameter26, parameter27, parameter28, parameter29,
                parameter30, parameter31, parameter32, parameter33, parameter34, parameter35,
                parameter36, parameter37, parameter38);
        repo.saveParams(params);
    }

    public Parameters findParamsById(int id) {
        return repo.findParamsById(id);
    }
}

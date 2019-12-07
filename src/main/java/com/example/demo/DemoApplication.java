package com.example.demo;

import com.example.demo.domain.Worker;
import com.example.demo.repo.Repo;
import com.example.demo.service.ParseWorkersService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) throws IOException {
        SpringApplication.run(DemoApplication.class, args);

       }
}
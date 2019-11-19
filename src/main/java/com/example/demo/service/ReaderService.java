//package com.example.demo.service;
//
//import com.example.demo.domain.Worker;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.springframework.stereotype.Service;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//
//@SuppressWarnings("ALL")
//@Service
//
//public class ReaderService {
//    private Worker worker;
//
//    public ReaderService(Worker worker) {
//        this.worker = worker;
//    }
//
//    public void ReaderService() throws IOException {
//  Worker worker = new Worker();
//
//        Workbook wr = new HSSFWorkbook(new FileInputStream("C:/Users/Monitoner/Desktop/read.xls"));
//        worker.setId(2);
//
//        for (int i = 11; i < 22; i++) {
//            worker.setJanRent(wr.getSheetAt(0).getRow(i).getCell(4).getNumericCellValue());
//            worker.setFebRent(wr.getSheetAt(0).getRow(i).getCell(5).getNumericCellValue());
//            worker.setMarRent(wr.getSheetAt(0).getRow(i).getCell(6).getNumericCellValue());
//            worker.setAprRent(wr.getSheetAt(0).getRow(i).getCell(7).getNumericCellValue());
//            worker.setMayRent(wr.getSheetAt(0).getRow(i).getCell(8).getNumericCellValue());
//            worker.setJuneRent(wr.getSheetAt(0).getRow(i).getCell(9).getNumericCellValue());
//            worker.setJulyRent(wr.getSheetAt(0).getRow(i).getCell(10).getNumericCellValue());
//            worker.setAugRent(wr.getSheetAt(0).getRow(i).getCell(11).getNumericCellValue());
//            worker.setSepRent(wr.getSheetAt(0).getRow(i).getCell(12).getNumericCellValue());
//            worker.setOctRent(wr.getSheetAt(0).getRow(i).getCell(13).getNumericCellValue());
//            worker.setNovRent(wr.getSheetAt(0).getRow(i).getCell(14).getNumericCellValue());
//            worker.setDecRent(wr.getSheetAt(0).getRow(i).getCell(15).getNumericCellValue());
//
//
//        }
//                 }
//
//
//    return ;}
//}
//

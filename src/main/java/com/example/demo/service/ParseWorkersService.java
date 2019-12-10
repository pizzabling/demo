package com.example.demo.service;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;

@Service
public class ParseWorkersService {

    private JdbcTemplate jdbcTemplate;
    private SigaretsService sigaretsService;
    private com.example.demo.service.Service service;

    public ParseWorkersService(JdbcTemplate jdbcTemplate, SigaretsService sigaretsService, com.example.demo.service.Service service) {
        this.sigaretsService = sigaretsService;
        this.jdbcTemplate = jdbcTemplate;
        this.service = service;
    }

    public void parseWorkersFromExcel() throws IOException {
        int workerId;
        double rent;
        double bond = 0;
        double kent = 0;
        double parlament = 0;
        double winston = 0;
        double lm = 0;
        double malboro = 0;
        double rotmans = 0;
        double ld = 0;
        double fmorris = 0;
        double aliance = 0;
        double java = 0;
        double optima = 0;
        double petr = 0;
        double maksim = 0;
        double crests = 0;
        double vog = 0;
        double glamur = 0;
        double kiss = 0;
        double esse = 0;
        double quin = 0;
        double lady = 0;
        double mor = 0;
        double chester = 0;
        double radopy = 0;
        double stuardessa = 0;
        double stolichniye = 0;
        double donskoy = 0;
        double troyka = 0;
        double fast = 0;
        double royal = 0;
        double manchester = 0;
        double prestigue = 0;
        double premier = 0;
        double cosmos = 0;
        double next = 0;
        double magnat = 0;
        double minsk = 0;
        double souz = 0;

        int i;
        String file = "C:/Users/Monitoner/Desktop/read1.xls";
        Workbook wb = new HSSFWorkbook(new FileInputStream(file));
        HSSFSheet sheet = (HSSFSheet) wb.getSheetAt(0);
        HSSFSheet sheet1 = (HSSFSheet) wb.getSheetAt(1);


        for (i = 0; i < 473; i++) {
            workerId = (int) sheet.getRow(i).getCell(1).getNumericCellValue();
            rent = sheet.getRow(i).getCell(5).getNumericCellValue();

            bond = wb.getSheetAt(1).getRow(i).getCell(0).getNumericCellValue();
            kent = wb.getSheetAt(1).getRow(i).getCell(1).getNumericCellValue();
            parlament = wb.getSheetAt(1).getRow(i).getCell(2).getNumericCellValue();
            winston = wb.getSheetAt(1).getRow(i).getCell(3).getNumericCellValue();
            lm = wb.getSheetAt(1).getRow(i).getCell(4).getNumericCellValue();
            malboro = wb.getSheetAt(1).getRow(i).getCell(5).getNumericCellValue();
            rotmans = wb.getSheetAt(1).getRow(i).getCell(6).getNumericCellValue();
            ld = wb.getSheetAt(1).getRow(i).getCell(7).getNumericCellValue();
            fmorris = wb.getSheetAt(1).getRow(i).getCell(8).getNumericCellValue();
            aliance = wb.getSheetAt(1).getRow(i).getCell(9).getNumericCellValue();
            java = wb.getSheetAt(1).getRow(i).getCell(10).getNumericCellValue();
            optima = wb.getSheetAt(1).getRow(i).getCell(11).getNumericCellValue();
            petr = wb.getSheetAt(1).getRow(i).getCell(12).getNumericCellValue();
            maksim = wb.getSheetAt(1).getRow(i).getCell(13).getNumericCellValue();
            crests = wb.getSheetAt(1).getRow(i).getCell(14).getNumericCellValue();
            vog = wb.getSheetAt(1).getRow(i).getCell(15).getNumericCellValue();
            glamur = wb.getSheetAt(1).getRow(i).getCell(16).getNumericCellValue();
            kiss = wb.getSheetAt(1).getRow(i).getCell(17).getNumericCellValue();
            esse = wb.getSheetAt(1).getRow(i).getCell(18).getNumericCellValue();
            quin = wb.getSheetAt(1).getRow(i).getCell(19).getNumericCellValue();
            lady = wb.getSheetAt(1).getRow(i).getCell(20).getNumericCellValue();
            mor = wb.getSheetAt(1).getRow(i).getCell(21).getNumericCellValue();
            chester = wb.getSheetAt(1).getRow(i).getCell(22).getNumericCellValue();
            radopy = wb.getSheetAt(1).getRow(i).getCell(23).getNumericCellValue();
            stuardessa = wb.getSheetAt(1).getRow(i).getCell(24).getNumericCellValue();
            stolichniye = wb.getSheetAt(1).getRow(i).getCell(25).getNumericCellValue();
            donskoy = wb.getSheetAt(1).getRow(i).getCell(26).getNumericCellValue();
            troyka = wb.getSheetAt(1).getRow(i).getCell(27).getNumericCellValue();
            fast = wb.getSheetAt(1).getRow(i).getCell(28).getNumericCellValue();
            royal = wb.getSheetAt(1).getRow(i).getCell(29).getNumericCellValue();
            manchester = wb.getSheetAt(1).getRow(i).getCell(30).getNumericCellValue();
            prestigue = wb.getSheetAt(1).getRow(i).getCell(31).getNumericCellValue();
            premier = wb.getSheetAt(1).getRow(i).getCell(32).getNumericCellValue();
            cosmos = wb.getSheetAt(1).getRow(i).getCell(33).getNumericCellValue();
            next = wb.getSheetAt(1).getRow(i).getCell(34).getNumericCellValue();
            magnat = wb.getSheetAt(1).getRow(i).getCell(35).getNumericCellValue();
            minsk = wb.getSheetAt(1).getRow(i).getCell(36).getNumericCellValue();
            souz = wb.getSheetAt(1).getRow(i).getCell(37).getNumericCellValue();


            sigaretsService.saveParseSigarets(bond, kent, parlament, winston, lm,
                    malboro, rotmans, ld, fmorris, aliance, java, optima, petr,
                    maksim, crests, vog, glamur, kiss, esse, quin, lady, mor, chester, radopy,
                    stuardessa, stolichniye, donskoy, troyka, fast, royal, manchester, prestigue,
                    premier, cosmos, next, magnat, minsk, souz);
            service.saveParceWorker(workerId, rent);
        }
    }
}

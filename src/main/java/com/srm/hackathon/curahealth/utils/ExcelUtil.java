package com.srm.hackathon.curahealth.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    public static Object[][] getTestData(String filePath, String sheetName) {

        Object[][] data = null;

        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

            data = new Object[rowCount - 1][colCount];

            for (int i = 1; i < rowCount; i++) { // skip header
                for (int j = 0; j < colCount; j++) {

                    Cell cell = sheet.getRow(i).getCell(j);

                    if (cell == null) {
                        data[i - 1][j] = "";
                    } else {
                        cell.setCellType(CellType.STRING);
                        data[i - 1][j] = cell.getStringCellValue();
                    }
                }
            }

            workbook.close();
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
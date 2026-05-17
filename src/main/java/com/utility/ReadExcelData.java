package com.utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;

public class ReadExcelData {
    public static String readParticularData(int rowVal,int clmVal){
        String data = null;
try{
    File file = new File("C:\\Users\\ADMIN\\Downloads\\DataDriven_IPT.xlsx");
    Workbook work = new XSSFWorkbook(file);
    Sheet sheet = work.getSheet("Sheet1");
    Row row = sheet.getRow(rowVal);
    Cell cell =  row.getCell(clmVal);
    DataFormatter dataFormat = new DataFormatter();
     data = dataFormat.formatCellValue(cell);

} catch (Exception e) {
    e.printStackTrace();
}
return data;
    }
}

package ru.mai;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelCreatingClass {

    public void creater() throws IOException {

        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("Тест");

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Корзина");

        Row row1 = sheet.createRow(1);
        Cell cell1 = row1.createCell(0);
        cell1.setCellValue("Яблоки");

        Row row2 = sheet.createRow(2);
        Cell cell2 = row2.createCell(0);
        cell2.setCellValue("Груши");

        Cell cell3 = row.createCell(1);
        cell3.setCellValue("Количество");

        Cell cell4 = row1.createCell(1);
        cell4.setCellValue(5);

        Cell cell5 = row2.createCell(1);
        cell5.setCellValue(4);

        sheet.setColumnWidth(1,3000);

        FileOutputStream fileOut = new FileOutputStream("WorkBook.xlsx");

        wb.write(fileOut);
        fileOut.close();

    }
}

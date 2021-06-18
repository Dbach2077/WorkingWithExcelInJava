package ru.mai;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReadingClass {
    public void reader() throws IOException {
        FileInputStream fis = new FileInputStream("WorkBook.xlsx");
        Workbook wb = new XSSFWorkbook(fis);
        String res = wb.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();
        System.out.println(res);
        String res1 = wb.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
        System.out.println(res1);
        String res2 = wb.getSheetAt(0).getRow(2).getCell(0).getStringCellValue();
        System.out.println(res2);
        System.out.println(getCellText( wb.getSheetAt(0).getRow(1).getCell(1)) + "\n" +
                getCellText( wb.getSheetAt(0).getRow(2).getCell(1)) );

        fis.close();
    }

    public static String getCellText(Cell cell){

        String resoult = "";

        switch (cell.getCellType()) {
            case STRING:
                resoult = cell.getRichStringCellValue().getString();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    resoult = cell.getDateCellValue().toString();
                } else {
                    resoult = Double.toString(cell.getNumericCellValue());
                }
                break;
            case BOOLEAN:
                resoult = Boolean.toString(cell.getBooleanCellValue());
                break;
            case FORMULA:
                resoult = cell.getCellFormula().toString();
                break;
            default:
                break;
        }
        return resoult;
    }
}

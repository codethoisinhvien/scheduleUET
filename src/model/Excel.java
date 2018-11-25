/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.collections.ObservableList;
import model.SubjectInformation;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFChartSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Phongthien
 */
public class Excel {

    public String link = "";
    public ArrayList<SubjectInformation> Subjects = new ArrayList<>();

    public void readExcel() throws FileNotFoundException, IOException {

        FileInputStream excelFile = new FileInputStream(new File("C:\\test.xlsx"));
        Workbook wb = new XSSFWorkbook(excelFile);

        System.out.println(wb.getNumberOfSheets());
        XSSFSheet sheet = (XSSFSheet) wb.getSheetAt(1);
        int i = 0;
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            i++;

            int j = 0;
            String result = "";
            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();
                // System.out.println(cell.getCellType());
                if (cell.getCellType() == CellType.NUMERIC) {
                    result = result + cell.getNumericCellValue() + "@";
                } else if (cell.getCellType() == CellType.STRING) {
                    j++;

                    result = result + cell.getStringCellValue() + "@";
                }
                if (j >= 8 && !result.contains("Mã học phần")) {
                    SubjectInformation a = new SubjectInformation(result);
                    Subjects.add(a);
                }

            }

        }

    }

    /**
     *
     * @param ScheduleList
     * @param ScheduleList
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void writeExcel(ObservableList<WorkGroupByLesson> ScheduleList,ObservableList<SubjectInformation> SubjectList) throws FileNotFoundException, IOException {
        XSSFWorkbook schedule = new XSSFWorkbook();
        XSSFSheet sheet = schedule.createSheet("Schedule");
        int rownum = 0;
        Cell cell;
        Row row;
        row = sheet.createRow(rownum);

        // EmpNo
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Tiết");

        // EmpName
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Thứ 2");

        // Salary
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Thứ 3");

        // Grade
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Thứ 4");

        // Bonus
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Thứ 5");
        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Thứ 6");
        cell = row.createCell(6, CellType.STRING);
        cell.setCellValue("Thứ 7");
        cell = row.createCell(8, CellType.STRING);
        cell.setCellValue("Chủ nhật");

        for (WorkGroupByLesson I : ScheduleList) {
            rownum++;
            if (rownum <= 13) {
                System.out.println(rownum);
                row = sheet.createRow(rownum);
                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(I.lesson);
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(I.getMonDay());
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(I.getTuseDay());
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(I.getWednesDay());
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(I.getThusrDay());
                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(I.getFriday());
                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(I.getSaturday());
                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(I.getSunday());

            }
        }
   
        this.writeSubject(sheet, SubjectList);
        File file = new File("D:\\scheldule.xlsx");

        FileOutputStream outFile = new FileOutputStream(file);
        schedule.write(outFile);
    }

  public  void writeSubject(XSSFSheet sheet, ObservableList<SubjectInformation> ScheduleList){
       int rownum = 15;
        Cell cell;
        Row row;
        row = sheet.createRow(rownum);

       
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Name");

     
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("ID Class");

      
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Teacher");

    
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Location");

        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Note");
      for(SubjectInformation I:ScheduleList){
           rownum++;
           row = sheet.createRow(rownum);
                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(I.Name);
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(I.IDClass);
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(I.Teacher);
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(I.Location);
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(I.Note);
      }
       
  }
}



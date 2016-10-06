/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.View;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author brian.marshall
 */
public class ClockIn {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InvalidFormatException {
        Calendar calendar = new GregorianCalendar();
        Calendar cal = new GregorianCalendar();
        //int year = calendar.get(calendar.YEAR);
        //System.out.println(year);
        //View view = new View();
        /*Workbook wb = WorkbookFactory.create(new File("C:/Users/brian.marshall/Documents/testworkbook.xlsx"));
        FileOutputStream outputStream = new FileOutputStream("C:/Users/brian.marshall/Documents/testworkbook.xlsx");
        Sheet sheet1 = wb.getSheetAt(0);
        sheet1.getRow(0).getCell(0).setCellValue("okokok");
        outputStream.
        wb.write(outputStream);
        wb.close();
        outputStream.close();
*/
        FileInputStream fsIP = new FileInputStream(new File("C:/Users/brian.marshall/Documents/SamplePayroll.xlsx"));
        XSSFWorkbook wb = new XSSFWorkbook(fsIP);
        XSSFSheet worksheet = wb.getSheetAt(0);
        Date date = worksheet.getRow(4).getCell(0).getDateCellValue();
        calendar.setTime(date);
        System.out.println(calendar.getTime());
        
        fsIP.close();
        //FileOutputStream output_file = new FileOutputStream(new File("C:/Users/brian.marshall/Documents/SamplePayroll.xlsx"));
        //wb.write(output_file);
        //output_file.close();
        
    }
    
}

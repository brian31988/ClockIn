/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Calendar;
import static java.util.Calendar.AM;
import static java.util.Calendar.DATE;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.HOUR;
import static java.util.Calendar.MONTH;
import java.util.GregorianCalendar;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Spreadsheet {

    private FileInputStream fsIP;
    private XSSFWorkbook wb;
    private XSSFSheet worksheet;
    private Calendar selectedCellDate;
    private Calendar currentDate;
    private SimpleDateFormat sdf;
    public Spreadsheet() throws FileNotFoundException, IOException {
        instantiateWorksheet();
        sdf = new SimpleDateFormat("HH:mm:ss a");
    }
    
    public void instantiateWorksheet() throws FileNotFoundException, IOException {
        this.fsIP = new FileInputStream(new File("C:/Users/brian.marshall/Documents/SamplePayroll.xlsx"));
        this.wb = new XSSFWorkbook(fsIP);
        this.worksheet = wb.getSheetAt(0);
    }
    
    public void clockIn() throws FileNotFoundException, IOException {
        int row = getRowOfCurrentDate();
        fsIP.close();
        FileOutputStream output_file = new FileOutputStream(new File("C:/Users/brian.marshall/Documents/SamplePayroll.xlsx"));
        this.worksheet.getRow(row).getCell(1).setCellValue(currentDate.getTime());
        XSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
        this.wb.write(output_file);
        output_file.close();
    }
    
    public void clockOut() throws IOException{
        int row = getRowOfCurrentDate();
        fsIP.close();
        FileOutputStream output_file = new FileOutputStream(new File("C:/Users/brian.marshall/Documents/SamplePayroll.xlsx"));
        this.worksheet.getRow(row).getCell(2).setCellValue(currentDate.getTime());
        XSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
        this.wb.write(output_file);
        output_file.close();
    }


    public int getRowOfCurrentDate() {
        Date cellDate = new Date();
        this.selectedCellDate = new GregorianCalendar();
        this.currentDate = new GregorianCalendar();
        for (Row row : worksheet){
            if ( row.getRowNum() > 3 && row.getRowNum() < 18){
            cellDate = row.getCell(0).getDateCellValue();
            selectedCellDate.setTime(cellDate);
                if((selectedCellDate.get(MONTH) == currentDate.get(MONTH)) && selectedCellDate.get(DATE) == currentDate.get(DATE) ){
                    return row.getRowNum();
                }
            }
        }
        return 0;
    }
}

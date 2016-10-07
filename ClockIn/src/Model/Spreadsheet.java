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
import java.util.GregorianCalendar;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Spreadsheet {

    FileInputStream fsIP;
    XSSFWorkbook wb;
    XSSFSheet worksheet;
    Calendar calendar1;
    Calendar calendar2;

    public Spreadsheet() throws FileNotFoundException, IOException {
        instantiateWorksheet();
        //calendar = new GregorianCalendar();
    }

    public void clockIn() throws FileNotFoundException, IOException {
        getRowOfCurrentDate();
        fsIP.close();
        outputCurrentTimeToWorksheet();
    }

    public void instantiateWorksheet() throws FileNotFoundException, IOException {
        fsIP = new FileInputStream(new File("C:/Users/brian/Documents/SamplePayroll.xlsx"));
        wb = new XSSFWorkbook(fsIP);
        worksheet = wb.getSheetAt(0);
    }

    public int getRowOfCurrentDate() {
        Date cellDate = new Date();
        cellDate.setTime(12/25/22);
        calendar2 = new GregorianCalendar();
        for (Row row : worksheet){
            if (CellType.values(row.getCell(0) getDateCellValue()) )
            cellDate = row.getCell(0) getDateCellValue();
            calendar1.setTime(cellDate);
            if((calendar1.MONTH == calendar2.MONTH) && calendar1.DAY_OF_YEAR == calendar2.DAY_OF_YEAR){
                return row.getRowNum();
            }
        }
        return 0;
    }

    public void outputCurrentTimeToWorksheet() throws FileNotFoundException, IOException {
        FileOutputStream output_file = new FileOutputStream(new File("C:/Users/brian/Documents/testworkbook.xlsx"));
        wb.write(output_file);
        output_file.close();
    }
}

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
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Spreadsheet {

    FileInputStream fsIP;
    XSSFWorkbook wb;
    XSSFSheet worksheet;
    Calendar calendar;

    public Spreadsheet() throws FileNotFoundException, IOException {
        instantiateWorksheet();
        //calendar = new GregorianCalendar();
    }

    private void clockIn() throws FileNotFoundException, IOException {
        Calendar currentDate = new GregorianCalendar();
        getRowOfCurrentDate();
        fsIP.close();
        outputCurrentTimeToWorksheet();
        
    }

    private void instantiateWorksheet() throws FileNotFoundException, IOException {
        fsIP = new FileInputStream(new File("C:/Users/brian.marshall/Documents/SamplePayroll.xlsx"));
        wb = new XSSFWorkbook(fsIP);
        worksheet = wb.getSheetAt(0);
    }

    private int getRowOfCurrentDate() {
        for (Row row : sheet)
            row.getCell(0).getDateCellValue();
        return 0;
    }

    private void outputCurrentTimeToWorksheet() throws FileNotFoundException, IOException {
        FileOutputStream output_file = new FileOutputStream(new File("C:/Users/brian.marshall/Documents/testworkbook.xlsx"));
        wb.write(output_file);
        output_file.close();
    }

    public int findRow(XSSFSheet sheet) {

        for (Row row : sheet) {
            for (Cell cell : row) {
                {
                    if (cell.getDateCellValue().compareTo(date) == 0) {
                        return row.getRowNum();
                    }
                }
            }
        }
        return 0;

    }
}

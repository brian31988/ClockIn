/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Spreadsheet;
import View.View;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import static java.time.temporal.ChronoField.MONTH_OF_YEAR;
import java.util.Calendar;
import static java.util.Calendar.DATE;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.DAY_OF_YEAR;
import static java.util.Calendar.FEBRUARY;
import static java.util.Calendar.HOUR;
import static java.util.Calendar.JANUARY;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.NOVEMBER;
import static java.util.Calendar.OCTOBER;
import java.util.Date;
import java.util.GregorianCalendar;
import jdk.nashorn.internal.codegen.types.Type;
import static jdk.nashorn.internal.parser.DateParser.DAY;
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
        
        View view = new View();
        
        /*Calendar cal = new GregorianCalendar();
        Calendar cal1 = new GregorianCalendar();
        cal.set(2016, 5, 12);
        
        System.out.println(cal1.getTime());
        System.out.println(cal.getTime());
        System.out.println(cal.get(DATE));
        System.out.println(cal.get(MONTH));
        */
        
    }
    
}

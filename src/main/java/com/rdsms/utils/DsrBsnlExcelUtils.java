package com.rdsms.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.rdsms.entity.DsrBsnl;
public class DsrBsnlExcelUtils {
	
public static List<DsrBsnl> readExcelData(File file){
		
		System.out.println("-- Started Reading Data from Excel File --");
		
		FileInputStream fs = null;
		List<DsrBsnl> dsrBsnlData = null;
		if (file != null) {
			try {
				fs = new FileInputStream(file);
				try {
					
					@SuppressWarnings("resource")
					Workbook workBook = new XSSFWorkbook(fs);
					Sheet sheet = workBook.getSheetAt(0);
					dsrBsnlData = new LinkedList<DsrBsnl>();
					Iterator<Row> rowIterator = sheet.iterator();
					int count = 0;
					while (rowIterator.hasNext()) {
						Row currentRow = rowIterator.next();
						if (currentRow.getRowNum() == 0) {
							System.out.println("Skipping headers while reading excel file data...");
							continue;
						}
						DsrBsnl d = assignValuestoDsrBsnl(currentRow,count);
						count++;
						dsrBsnlData.add(d);
					}
					return dsrBsnlData;
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("There is no File found to read ..!!");
		}
		
		return dsrBsnlData;
	}

   private static DsrBsnl assignValuestoDsrBsnl(Row row, int count) {
	   
	   DsrBsnl dsr = new DsrBsnl();
	   dsr.setCircle(row.getCell(0).getStringCellValue());
	   int no = (int)row.getCell(1).getNumericCellValue();
	   dsr.setCurrentDate(DateUtils.convertStringToDate(no+""));
	   dsr.setTime(Time.valueOf(row.getCell(2).getStringCellValue()));
	   dsr.setAgentNo((int)row.getCell(3).getNumericCellValue());
	   dsr.setChatId((int)row.getCell(4).getNumericCellValue());
	   dsr.setVendor(row.getCell(5).getStringCellValue());
	   dsr.setLocation(row.getCell(6).getStringCellValue());
	   dsr.setLastLoginLogoutTime(DateUtils.convertDate(row.getCell(7).getStringCellValue()));
//	   System.out.println("Last Login Logout Time :: "+DateUtils.convertDate(row.getCell(7).getStringCellValue()));
	   dsr.setLastLoginLogoutStatus(row.getCell(8).getStringCellValue());
	   dsr.setLoginLogoutTimeMins((int)row.getCell(9).getNumericCellValue());//DateUtils.convertStringToTime(row.getCell(9).getNumericCellValue()+"")
	   dsr.setStatus(row.getCell(10).getStringCellValue());
	   dsr.setHours((int)row.getCell(11).getNumericCellValue());
	   dsr.setTotalCalls((int)row.getCell(12).getNumericCellValue());
	   dsr.setSuccessCalls((int) row.getCell(13).getNumericCellValue());
	   dsr.setFailedCalls((int) row.getCell(14).getNumericCellValue());
	   dsr.setUnAnsweredCalls((int) row.getCell(15).getNumericCellValue());
	   dsr.setSwitchedOff((int) row.getCell(16).getNumericCellValue());
	   dsr.setUserBusy((int) row.getCell(17).getNumericCellValue());
	   dsr.setNetworkIssue((int) row.getCell(18).getNumericCellValue());
	   dsr.setMou((int) row.getCell(19).getNumericCellValue());
	   dsr.setActive(true);
	   return dsr;
	   
   }
   
   public static void main(String[] args) {
		File file = new File("C:\\Users\\Nitesh\\Documents\\dsr_bsnl_test.xlsx");
		List<DsrBsnl> df = readExcelData(file);
		System.out.println(df);
	}

}

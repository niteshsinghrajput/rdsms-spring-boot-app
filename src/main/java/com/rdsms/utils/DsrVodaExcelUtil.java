package com.rdsms.utils;

/**
 * @author Nitesh
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.rdsms.entity.DsrVodafone;

public class DsrVodaExcelUtil {
	
public static List<DsrVodafone> readExcelData(File file){
		
		System.out.println("-- Started Reading Data from Excel File --");
		
		FileInputStream fs = null;
		List<DsrVodafone> dsrVodafoneData = null;
		if (file != null) {
			try {
				fs = new FileInputStream(file);
				try {
					
					@SuppressWarnings("resource")
					Workbook workBook = new XSSFWorkbook(fs);
					Sheet sheet = workBook.getSheetAt(0);
					dsrVodafoneData = new LinkedList<DsrVodafone>();
					Iterator<Row> rowIterator = sheet.iterator();
					int count = 0;
					while (rowIterator.hasNext()) {
						Row currentRow = rowIterator.next();
						if (currentRow.getRowNum() == 0) {
							System.out.println("Skipping headers while reading excel file data...");
							continue;
						}
						DsrVodafone d = assignValuestoDsrVodafone(currentRow,count);
						count++;
						dsrVodafoneData.add(d);
					}
					return dsrVodafoneData;
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("There is no File found to read ..!!");
		}
		
		return dsrVodafoneData;
	}

	public static DsrVodafone assignValuestoDsrVodafone(Row row, int count) {
		
		DsrVodafone dsr = new DsrVodafone();
		dsr.setCircle(row.getCell(0).getStringCellValue());
		dsr.setAgentLocation(row.getCell(1).getStringCellValue());
		dsr.setReportDateTime(DateUtils.stringToSqlDate(row.getCell(2).getStringCellValue()));
		dsr.setDetailHours(Integer.parseInt(row.getCell(3).getStringCellValue()));
		dsr.setLoginLogoutTime(DateUtils.convertDate(row.getCell(4).getStringCellValue()));
		dsr.setChatId(Integer.parseInt(row.getCell(5).getStringCellValue()));
		dsr.setLoginLogoutStatus(row.getCell(6).getStringCellValue());
		dsr.setAni(Long.parseLong(row.getCell(7).getStringCellValue()));
		dsr.setVendor(row.getCell(8).getStringCellValue());
		dsr.setLocation(row.getCell(9).getStringCellValue());
		dsr.setLoginLogoutTimeMins((int)row.getCell(10).getNumericCellValue());
		dsr.setStatus(row.getCell(11).getStringCellValue());
		dsr.setCategory(row.getCell(12).getStringCellValue());
		dsr.setPriority(Integer.parseInt(row.getCell(13).getStringCellValue()));
		dsr.setTotalCalls((int)row.getCell(14).getNumericCellValue());
		dsr.setSuccessCalls((int)row.getCell(15).getNumericCellValue());
		dsr.setFailedCalls((int)row.getCell(16).getNumericCellValue());
		dsr.setPulses((int)row.getCell(17).getNumericCellValue());
		dsr.setMou((int)row.getCell(18).getNumericCellValue());
		dsr.setOthers((int)row.getCell(19).getNumericCellValue());
		dsr.setaPartyDisconnects((int)row.getCell(20).getNumericCellValue());
		dsr.setUnAnswered((int)row.getCell(21).getNumericCellValue());
		dsr.setSwitchedOff((int)row.getCell(22).getNumericCellValue());
		dsr.setActive(true);
		
		return dsr;
		
	}
	
	public static void main(String[] args) {
		File file = new File("C:\\Users\\Nitesh\\Documents\\dsr_vodafone_test.xlsx");
		List<DsrVodafone> df = readExcelData(file);
		System.out.println(df);
	}
}

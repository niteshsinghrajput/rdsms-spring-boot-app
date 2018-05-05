package com.rdsms.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.rdsms.entity.MIS;

public class ExcelUtil {
	
	public static List<MIS> readExcelData(File file){
		
		System.out.println("-- Started Reading Data from Excel File --");
		
		FileInputStream fs = null;
		List<MIS> misData = null;
		if (file != null) {
			try {
				fs = new FileInputStream(file);
				try {
					
					@SuppressWarnings("resource")
					Workbook workBook = new XSSFWorkbook(fs);
					Sheet sheet = workBook.getSheetAt(0);
					misData = new LinkedList<MIS>();
					Iterator<Row> rowIterator = sheet.iterator();
					int count = 0;
					while (rowIterator.hasNext()) {
						Row currentRow = rowIterator.next();
						if (currentRow.getRowNum() == 0) {
							System.out.println("Skipping headers while reading excel file data...");
							continue;
						}
						MIS m = assignValuestoMIS(currentRow,count);
						count++;
						misData.add(m);
					}
					return misData;
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("There is no File found to read ..!!");
		}
		
		return misData;
	}
	
	/*public static Map<String,Set<MIS>> readExcel(File file) {
		
		FileInputStream fs = null;
		Map<String, Set<MIS>> misMap = new HashMap<String, Set<MIS>>();
		Set<MIS> misData = new HashSet<MIS>();

		if (file != null) {

			try {
				
				fs = new FileInputStream(file);
				try {
					
					@SuppressWarnings("resource")
					Workbook workBook = new XSSFWorkbook(fs);
					int no = workBook.getNumberOfSheets();
					System.out.println("Total Sheets in excel file : "+no);
					
					for(int i=0;i<no;i++) {
						
						Sheet sheet = workBook.getSheetAt(i);
						
						Iterator<Row> rowIterator = sheet.iterator();
						int count = 0;
						while (rowIterator.hasNext()) {
							Row currentRow = rowIterator.next();
							if (currentRow.getRowNum() == 0) {
								System.out.println("Skipping headers while reading excel file data...");
								continue;
							}
							MIS m = assignValuestoMIS(currentRow , count);
							
							count++;
							misData.add(m);
							String sheetName = workBook.getSheetName(i);
							misMap.put(sheetName, misData);
						}
						System.out.println("Total Rows in Excel Sheet : " + misData.size());
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return misMap;
	}*/
	
	@SuppressWarnings("deprecation")
	public static MIS assignValuestoMIS(Row row, int count) {
		
		 MIS mis = new MIS();
		 //UUID id = randInt();
		 //mis.setId(id.toString());
		 mis.setDate(DateUtils.toSqlDate(row.getCell(0).getDateCellValue().toString()));
		 mis.setOperator(row.getCell(1).getStringCellValue());
		 mis.setPartner(row.getCell(2).getStringCellValue());
		 mis.setLocation(row.getCell(3).getStringCellValue());
		 if(row.getCell(4).getCellTypeEnum() == CellType.STRING) {
			 String bni = row.getCell(4).getStringCellValue().substring(0, 10);
			 long bniInt = Long.parseLong(bni.trim());
			 mis.setBni(bniInt);
		 }
		 else if(row.getCell(4).getCellTypeEnum() == CellType.NUMERIC)
			 mis.setBni((long)row.getCell(4).getNumericCellValue());
		 mis.setChatId((int)row.getCell(5).getNumericCellValue());
		 mis.setCircleId(row.getCell(6).getStringCellValue());
		 mis.setType(row.getCell(7).getStringCellValue());
		 mis.setTotalCalls((int)row.getCell(8).getNumericCellValue());
		 mis.setFailedCalls((int)row.getCell(9).getNumericCellValue());
		 mis.setUnAnsweredCalls((int)row.getCell(10).getNumericCellValue());
		 mis.setSwitchedOff((int)row.getCell(11).getNumericCellValue());
		 mis.setUserBusy((int)row.getCell(12).getNumericCellValue());
		 mis.setAnsweredCalls((int)row.getCell(13).getNumericCellValue());
		 mis.setDurations((int)row.getCell(14).getNumericCellValue());
		 mis.setPulse((int)row.getCell(15).getNumericCellValue());
		 mis.setMous((float)row.getCell(16).getNumericCellValue());
		 mis.setHrs((float)row.getCell(17).getNumericCellValue());
		 mis.setAtt((float)row.getCell(18).getNumericCellValue());
		 mis.setFailPercentage((int)row.getCell(19).getNumericCellValue());
		 mis.setCallLessThanOneMin((int)row.getCell(20).getNumericCellValue());
		 mis.setMousLessThanOneMin((float)row.getCell(21).getNumericCellValue());
		 if (row.getCell(22) == null) {
			 mis.setLoginHours(0.0f);
			}
		 else {
			 row.getCell(22).setCellType(CellType.NUMERIC);
			 if(row.getCell(22).getCellTypeEnum() == CellType.STRING) {
				 mis.setLoginHours(row.getCell(22).getStringCellValue()==null ? 0 : Integer.parseInt(row.getCell(20).getStringCellValue()));//Integer.parseInt(row.getCell(20).getStringCellValue())
			 }else if (row.getCell(22).getCellTypeEnum() == CellType.NUMERIC) {
				 mis.setLoginHours((float)row.getCell(22).getNumericCellValue());
			 }
		 }
		/* if(row.getCell(22).getCellTypeEnum() == CellType.STRING) {
			 mis.setLoginHours(row.getCell(22).getRichStringCellValue()==null ? 0 : Integer.parseInt(row.getCell(20).getStringCellValue()));//Integer.parseInt(row.getCell(20).getStringCellValue())
		 }*/
		 
		/* if(row.getCell(23).getCellTypeEnum() == CellType.STRING) {
			 mis.setLoginHours(Float.parseFloat(row.getCell(23).getStringCellValue()));
		 } else if (row.getCell(23).getCellTypeEnum() == CellType.NUMERIC) {
			 mis.setLoginHours((float)row.getCell(23).getNumericCellValue());
		 }*/
		 row.getCell(23).setCellType(CellType.NUMERIC);
		 mis.setFirstPartyDisconnects((int)row.getCell(23).getNumericCellValue());
		 row.getCell(24).setCellType(CellType.NUMERIC);
		 mis.setSecondPartyDisconnects((int)row.getCell(24).getNumericCellValue());
		 
		return mis;
	}
	
	public static void main(String[] args) {
		
		File file = new File("C:\\Users\\Nitesh\\Documents\\MIS_MANDLA_2017_1_Upload_test.xlsx");
		//Map<String, Set<MIS>> misMap = readExcel(file);
		List<MIS> misList = readExcelData(file);
		System.out.println("Total "+misList.size()+" Records Found in Excel Sheet " + file.getName());
	}
	
}

package com.rdsms.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.rdsms.entity.DsrBsnl;
import com.rdsms.entity.DsrVodafone;
import com.rdsms.service.IDSRService;
import com.rdsms.utils.DsrBsnlExcelUtils;
import com.rdsms.utils.DsrVodaExcelUtil;

/**
 * 
 * @author Nitesh
 *
 */

@Controller
@RequestMapping("dsrservice")
public class DSRController {
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(DSRController.class);
	
	@Autowired
	private IDSRService service;
	
	@GetMapping("dsrBsnl")
	public ResponseEntity<List<DsrBsnl>> getDsrBsnl(){
		
		List<DsrBsnl> dsr = service.getDsr();
		return new ResponseEntity<List<DsrBsnl>>(dsr,HttpStatus.OK);
	}
	
	@GetMapping("dsrBsnl/{location}")
	public ResponseEntity<List<DsrBsnl>> getDsrBsnlByLocation(@PathVariable("location") String location){
		System.out.println("Location :: "+location);
		List<DsrBsnl> dsr = service.getDsrBsnlByLocation(location);
		return new ResponseEntity<List<DsrBsnl>>(dsr,HttpStatus.OK);
		
	}
	
	@PostMapping("dsrBsnl")
	public ResponseEntity<String> uploadDsrBsnlFile(@RequestParam("fileName") MultipartFile file) {
		
		String UPLOADED_FOLDER = "./dsr_data/";
		if(file.isEmpty()) {
			return new ResponseEntity<String>("Please Select a File to Upload", HttpStatus.BAD_REQUEST);
		}
		try {
			
			logger.debug("File Name is {}", file.getName());
			InputStream in = file.getInputStream();
			Path path = Paths.get(UPLOADED_FOLDER);
			String fileLocation = path +"/"+ file.getOriginalFilename();
		    FileOutputStream f = new FileOutputStream(fileLocation);
		    int ch = 0;
		    while ((ch = in.read()) != -1) {
		        f.write(ch);
		    }
		    f.flush();
		    f.close();
		    
		    File excelFile = new File(fileLocation);
		    List<DsrBsnl> dsrBsnlDataList = DsrBsnlExcelUtils.readExcelData(excelFile);
		    boolean status = service.saveDsrBsnl(dsrBsnlDataList);
		    if(status) {
            	return new ResponseEntity<String>("File ["+ file.getOriginalFilename() +"] has been uploaded Successfully", HttpStatus.OK);
            }
			
		}catch(Exception e) {
			
		}
		return new ResponseEntity<String>("Problem occured while uploading file", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// DSR - Vodafone 
	@GetMapping("dsrVodafone")
	public ResponseEntity<List<DsrVodafone>> getDsrVodafone(){
		List<DsrVodafone> dsrVodafone = service.getDsrVodafone();
		return new ResponseEntity<List<DsrVodafone>>(dsrVodafone, HttpStatus.OK);
	}
	
	@GetMapping("dsrVodafone/{location}")
	public ResponseEntity<List<DsrVodafone>> getDsrVodafoneByLocation(@PathVariable("location") String location){
		List<DsrVodafone> dsrVodafone = service.getDsrVodafoneByLocation(location);
		return new ResponseEntity<List<DsrVodafone>>(dsrVodafone,HttpStatus.OK);
 	}
	
	@PostMapping("dsrVodafone")
	public ResponseEntity<String> uploadDsrVodafone(@RequestParam("file") MultipartFile file){
		
		String UPLOADED_FOLDER = "./dsr_data/";
		if(file.isEmpty()) {
			return new ResponseEntity<String>("Please Select a File to Upload", HttpStatus.BAD_REQUEST);
		}
		try {
			
			InputStream in = file.getInputStream();
			Path path = Paths.get(UPLOADED_FOLDER);
			String fileLocation = path +"/"+ file.getOriginalFilename();
		    FileOutputStream f = new FileOutputStream(fileLocation);
		    int ch = 0;
		    while ((ch = in.read()) != -1) {
		        f.write(ch);
		    }
		    f.flush();
		    f.close();
		    
		    File excelFile = new File(fileLocation);
		    List<DsrVodafone> dsrVodafoneDataList = DsrVodaExcelUtil.readExcelData(excelFile);
		    boolean status = service.saveDsrVodafone(dsrVodafoneDataList);
		    if(status) {
            	return new ResponseEntity<String>("File ["+ file.getOriginalFilename() +"] has been uploaded Successfully", HttpStatus.OK);
            }
			
		}catch(Exception e) {
			
		}
		return new ResponseEntity<String>("Problem occured while uploading file", HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}

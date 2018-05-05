package com.rdsms.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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

import com.rdsms.entity.MIS;
import com.rdsms.service.IMISService;
import com.rdsms.utils.ExcelUtil;

/**
 * 
 * @author Nitesh
 *
 */

@Controller
@RequestMapping("misservice")
public class MISController {
	
	@Autowired
	private IMISService service;
	
	@GetMapping("mis")
	public ResponseEntity<List<MIS>> getMisData(){
		List<MIS> misDataList = service.getMISData();
		return new ResponseEntity<List<MIS>>(misDataList,HttpStatus.OK);
	}
	
	@PostMapping("mis")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
		
		String UPLOADED_FOLDER = "./mis_data/";
		if(file.isEmpty()) {
			return new ResponseEntity<String>("Please Select a File to Upload", HttpStatus.BAD_REQUEST);
		}
		
		try {
			
			InputStream in = file.getInputStream();
			Path path = Paths.get(UPLOADED_FOLDER);
		    //File currDir = new File(".");
		   // String path = currDir.getAbsolutePath();
		    String fileLocation = path +"/"+ file.getOriginalFilename();
		    FileOutputStream f = new FileOutputStream(fileLocation);
		    int ch = 0;
		    while ((ch = in.read()) != -1) {
		        f.write(ch);
		    }
		    f.flush();
		    f.close();
		   // model.addAttribute("message", "File: " + file.getOriginalFilename() 
		  //    + " has been uploaded successfully!");
		   // return "excel";
			//TODO: 1. Need to call excel util method to read file 2.Then call saveMISData method to process data 
		    File excelFile = new File(fileLocation);
            List<MIS> misDataList = ExcelUtil.readExcelData(excelFile);
            boolean status = service.saveMISData(misDataList);
            if(status) {
            	return new ResponseEntity<String>("File ["+ file.getOriginalFilename() +"] has been uploaded Successfully", HttpStatus.OK);
            }
            
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<String>("Problem occured while uploading file", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("mis/{location}")
	public ResponseEntity<List<MIS>> getMISDataByLocation(@PathVariable("location") String location){
		List<MIS> misDataList = service.getMISDataByLocation(location);
		return new ResponseEntity<List<MIS>>(misDataList,HttpStatus.OK);
	}
	
	/*@GetMapping("mis/{page}")
	public ResponseEntity<List<MIS>> getMISDataByPage(@PathVariable("page") int page){
		List<MIS> misDataList = service.getMisByPageSize(page);
		return new ResponseEntity<List<MIS>>(misDataList,HttpStatus.OK);
	}*/
}

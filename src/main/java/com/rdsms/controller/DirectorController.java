package com.rdsms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rdsms.entity.Director;
import com.rdsms.service.IDirectorService;

/**
 * 
 * @author Nitesh
 *
 */

@Controller
@RequestMapping("directorservice")
public class DirectorController {
	
	@Autowired
	private IDirectorService service;
	
	@GetMapping("directors")
	public ResponseEntity<List<Director>> getDirectors(){
		List<Director> directors = service.getDirectorList();
		return new ResponseEntity<List<Director>>(directors, HttpStatus.OK);
	}

}

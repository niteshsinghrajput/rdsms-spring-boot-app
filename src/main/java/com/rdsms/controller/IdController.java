package com.rdsms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rdsms.entity.ID;
import com.rdsms.service.IdService;

/**
 * 
 * @author Nitesh
 *
 */

@Controller
@RequestMapping("idservice")
public class IdController {
	
	@Autowired
	private IdService service;
	
	@GetMapping("id")
	public ResponseEntity<List<ID>> getIds(){
		List<ID> ids = service.getIds();
		return new ResponseEntity<List<ID>>(ids, HttpStatus.OK);
	}

}

package com.rdsms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("directors")
	public ResponseEntity<Director> createDirector(@RequestBody Director director){
		Director addedDirector = service.addDirector(director);
		return new ResponseEntity<Director>(addedDirector, HttpStatus.OK);
	}
	
	@PutMapping("directors/{directorId}")
	public ResponseEntity<Director> updateDirector(@PathVariable("directorId") int directorId, @RequestBody Director director){
		Director updatedDirector = service.updateDirector(directorId, director);
		return new ResponseEntity<Director>(updatedDirector, HttpStatus.OK);
	}
	
	@DeleteMapping("directors/{directorId}")
	public ResponseEntity<String> deleteDirector(@PathVariable("directorId") int directorId) {
		String message;
		boolean isDeleted = service.deleteDirector(directorId);
		if(isDeleted) {
			message = "Director (id="+directorId+") has been deleted successfully";
		}else {
			message = "Error while deleting Director (id="+directorId+") from database";
		}
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}

}

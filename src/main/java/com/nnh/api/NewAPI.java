package com.nnh.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nnh.dto.NewDTO;
import com.nnh.service.INewService;

@CrossOrigin
@RestController
public class NewAPI {
	@Autowired
	private INewService newService;
	
	@PostMapping("/new")
	public NewDTO createNew(@RequestBody NewDTO model) {
		return newService.save(model);
	}
	
	@PutMapping("/new/{id}")
	public NewDTO updateNew(@RequestBody NewDTO model, @PathVariable("id") long id) {
		model.setId(id);
		newService.save(model);
		return model;
	}
	
	@DeleteMapping ("/new")
	public void deleteNew(@RequestBody long[] ids) {
		
	}
}

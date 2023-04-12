package com.nemat.sbmsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nemat.sbmsp.model.Uom;
import com.nemat.sbmsp.service.UomService;

@Controller
@RequestMapping("/uom")
public class UomController {

	@Autowired
	private UomService service;
	
//	1. Display Register Page
	@GetMapping("/register")
	public String showRegister() {
		return "UomRegister";
	}
	
	@PostMapping("/save")
	public String saveUom(@ModelAttribute Uom uom, Model model) {
		Integer id = service.saveUom(uom);
		String message = "Uom is saved with id : "+id ;
		model.addAttribute("message", message);
		return "UomRegister";
	}
	
	@PutMapping("/update")
	String updateUom(Uom uom) {
		return "";
	}
	
	@DeleteMapping("/delete")
	void deleteUom(Integer id) {
		
	}
	
	@GetMapping("/get")
	String getOneUom(Integer id) {
		return "";
	}
	
	@GetMapping("/all")
	String getAllUom(Model model) {
		List<Uom> listUom = service.getAllUom();
		model.addAttribute("listUom",listUom);
		return "UomData";
	}
}

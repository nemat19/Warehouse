package com.nemat.sbmsp.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nemat.sbmsp.model.ShipmentType;
import com.nemat.sbmsp.service.ShipmentTypeService;
import com.nemat.sbmsp.view.ShipmentTypeExcelView;

@Controller
@RequestMapping("/shipmentType")
public class ShipmentTypeController {
	
	@Autowired
	private ShipmentTypeService service;

//	1. Display Register Page
	@GetMapping("/register")
	public String showRegister(Model model) {
//		Form Backing object
		model.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";
	}
	
//	2. On Click Submit button, Read Form Data and Save.
	@PostMapping("/save")
	public String saveFormData(@ModelAttribute ShipmentType st,Model model) {
		Integer id = service.saveShipmetType(st);
		String msg = "Shipment Type : "+id+" saved.";
		model.addAttribute("message", msg);
		return "ShipmentTypeRegister";
	}

//	3. Display all records from UI
	@GetMapping("/all")
	public String showAllShipmentType(Model model) {
		List<ShipmentType> list = service.getAllShipmentType();
		model.addAttribute("list", list);
		return "ShipmentTypeData";
	}
	
//	4. Remove one Id
	@GetMapping("/delete/{id}")
	public String removeById(@PathVariable Integer id, Model model) {
//		service.deleteShipmentType(id);
//		
////		fetch other rows and display
//		List<ShipmentType> list = service.getAllShipmentType();
//		model.addAttribute("list", list);
//		
//		String msg = "Deleted Successfully";
//		model.addAttribute("msg", msg);
//		return "ShipmentTypeData";
//		
////		redirect
////		return "redirect:../all";
		
//		Another way
		String msg=null;
		if(service.isShipmentTypeExist(id)) {
			service.deleteShipmentType(id);
			msg = "Deleted Successfully";
		}else {
			msg = "Id : "+id+" Not avilable to delete";
			
		}
		model.addAttribute("msg", msg);
		List<ShipmentType> list = service.getAllShipmentType();
		model.addAttribute("list", list);
		return "ShipmentTypeData";
	}
	
//	5. Show Edit Page with data
	@GetMapping("/edit/{id}")
	public String showEdit(@PathVariable Integer id, Model model) {
		Optional<ShipmentType> ost = service.getOneShipmentType(id);
		String page = null;
		if(ost.isPresent()) {
			ShipmentType st = ost.get();
			model.addAttribute("shipmentType", st);
			page = "ShipmentTypeRegisterEdit";
		}else {
			page = "redirect:../all";
		}
		return page;
	}
	
//	6. Update : On click, Please update
	@PostMapping("/update")public String update(@ModelAttribute ShipmentType st, Model model) {
		service.updateShipmentType(st);
		String msg = "ShipmentType '"+st.getId()+"' updated";
		model.addAttribute("msg", msg);
		
//		New Data from DB
		List<ShipmentType> list = service.getAllShipmentType();
		model.addAttribute("list", list);
		return "ShipmentTypeData";
	}
	
//	7. Export Data to Excel
	@GetMapping("/excel")
	public ModelAndView exportToExcel() {
		ModelAndView m = new ModelAndView();
		m.setView(new ShipmentTypeExcelView());
		
//		Send data to view class
	List<ShipmentType> list = service.getAllShipmentType();
		m.addObject("obs", list);
		return m;
	}
	
//	7. Export Single record to Excel
	@GetMapping("/excel/{id}")
	public ModelAndView exportOneToExcel(@PathVariable Integer id) {
		ModelAndView m = new ModelAndView();
		m.setView(new ShipmentTypeExcelView());
		
//		Send data to view class
		Optional<ShipmentType> ost = service.getOneShipmentType(id);
			if(ost.isPresent()) {
				m.addObject("obs", Arrays.asList(ost.get()));
			}
		return m;
	}
}

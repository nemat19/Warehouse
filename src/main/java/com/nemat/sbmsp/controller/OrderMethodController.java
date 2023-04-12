package com.nemat.sbmsp.controller;

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

import com.nemat.sbmsp.model.OrderMethod;
import com.nemat.sbmsp.service.OrderMethodService;

@Controller
@RequestMapping("/orderMethod")
public class OrderMethodController {
	
	@Autowired
	private OrderMethodService service;
	
//	1. Show Register Page
	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodRegister";
	}
	
//	2. Save Data
	@PostMapping("/save")
	public String save(@ModelAttribute OrderMethod om, Model model) {
		Integer id = service.saveOrderMethod(om);
		String message = "Order Method '"+ id +"' saved";
		model.addAttribute("message", message);
		model.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodRegister";
	}
	
//	3. Show all
	@GetMapping("/all")
	public String getAll(Model model) {
		List<OrderMethod> list = service.getAllOrderMethod();
			model.addAttribute("list", list);
			return "OrderMethodData";
	}
	
//	4. Edit Page
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Optional<OrderMethod> oom = service.getOneOrderMethod(id);
		if(oom.isPresent()) {
			model.addAttribute("orderMethod", oom.get());
			return "OrderMethodEdit";
		}else {
			return "redirect:../all";
		}
		
	}
	
//	5. Do Update 
	@PostMapping("/update")
	public String update(@ModelAttribute OrderMethod om, Model model) {
		Optional<OrderMethod> oom = service.getOneOrderMethod(om.getId());
		if(oom.isPresent()) {
			service.updateOrderMethod(om);
			model.addAttribute("orderMethod", service.getOneOrderMethod(om.getId()).get());
			String message = "Order Method '"+ om.getId() +"' updated.";
			model.addAttribute("message", message);
		}
		return "OrderMethodEdit";
	}
	
//	6. do Delete
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		if(service.isOrderMethodExist(id)) {
			service.deleteOrderMethod(id);
			String msg = " ID : ' " + id + " ' deleted. ";
			model.addAttribute("msg", msg);
		}else{
			String msg = "ID not present to Deleted.";
			model.addAttribute("msg", msg);
		}
		List<OrderMethod> list = service.getAllOrderMethod();
		model.addAttribute("list", list);
		return "OrderMethodData";
	}

//	7. Show one
	@GetMapping("/get")
	public String get() {
		
		return "";
	}
	
}

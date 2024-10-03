package com.nt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;
import com.nt.validations.EmployeeValidator;

@Controller
public class EmployeeOpertionsController {
	@Autowired
	private IEmployeeMgmtService service;
	
	@Autowired
	private EmployeeValidator empValidator;

	@GetMapping("/")
	public String showHome() {
		System.out.println("EmployeeOpertionsController.showHome()");
		// return Logical View Name
		return "home";
	}

	@GetMapping("/report")
	public String showEmployeeReport(Map<String, Object> map) {
		System.out.println("EmployeeOpertionsController.showEmployeeReport()");
		// use service
		List<Employee> list = service.getAllEmployees();
		//put the results in model attributes
		map.put("empsData", list);
		//return LVN
		return "employee_report";
	}
	@GetMapping("/add")
	public String showAddEmployeeForm(@ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeOpertionsController.showAddEmployeeForm()");
		 emp.setJob("CLERK");
		 return "employee_register";
	}

	@PostMapping("/add")
	public String addEmployee(RedirectAttributes attrs,@ModelAttribute("emp") Employee emp,BindingResult errors) {
		System.out.println("EmployeeOpertionsController.addEmployee()");
		// check for type mismatch errors
		//enable server side form validations onlu when client side form validations are not done
		System.out.println(emp.getVflag());
		if(emp.getVflag().equalsIgnoreCase("no")) {
			System.out.println(emp.getVflag());
		if(errors.hasFieldErrors())
			return "employee_register";
		
		//checking form validations errors
		if(empValidator.supports(emp.getClass())) {
			empValidator.validate(emp, errors);
			if(errors.hasErrors())
				return "employee_register";
		}
		}
		//application logic errors
		if(emp.getJob().equalsIgnoreCase("hacker")) {
			errors.rejectValue("job", "job.reject");
			return "employee_register";
		}
		//use service
		String result = service.registerEmployee(emp);
		System.out.println(result);
		//List<Employee> list = service.getAllEmployees();
		//System.out.println(list);
		//keep results in model attributes
		 attrs.addFlashAttribute("resultMsg",result);
		 
		//return LVN
		return "redirect:report";
	}
	
	/*@PostMapping("/add")
	public String addEmployee(HttpSession ses,@ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeOpertionsController.addEmployee()");
		//use service
		String result = service.registerEmployee(emp);
		System.out.println(result);
		List<Employee> list = service.getAllEmployees();
		System.out.println(list);
		//keep results in model attributes
		 ses.setAttribute("resultMsg", result);
		 
		//return LVN
		return "redirect:report";
	}*/
	@GetMapping("/edit")
	public String showEditEmployeeForm(@RequestParam("no") int no,@ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeOpertionsController.showEditEmployeeForm()");
		System.out.println("Number::"+no);
	 //get Employee details dynamically based on the given emp no
		Employee emp1 = service.getEmployeeByNo(no);
		System.out.println("Emp1="+emp1);
		System.out.println("EMP="+emp);
		//emp=emp1
		BeanUtils.copyProperties(emp1, emp);
		//return LVN
		return "employee_edit";
	}
	@PostMapping("/edit")
	public String editEmployee(@ModelAttribute("emp") Employee emp,RedirectAttributes attrs,BindingResult errors) {
		System.out.println("EmployeeOpertionsController.editEmployee()");
		System.out.println("emp="+emp);
		//checking for type mismatch errors
	  // to enable server side form validations when client side form validations not done
		System.out.println(emp.getVflag());
		if(emp.getVflag().equalsIgnoreCase("no")) {
		   System.out.println(emp.getVflag());
		if(errors.hasFieldErrors())
              return  "employee_edit";
		//checking form validations errors
			if(empValidator.supports(emp.getClass())) {
			empValidator.validate(emp, errors);
			if(errors.hasErrors())
				return "employee_edit";
		}
		}
			//application logic errors
			if(emp.getJob().equalsIgnoreCase("hacker")) {
				errors.rejectValue("job", "job.reject");
				return "employee_edit";
			}
				
		//use service
		String msg=service.editEmployee(emp);
	//	List<Employee> list = service.getAllEmployees();
		//keep results in model attributes
		 attrs.addFlashAttribute("resultMsg",msg);
		//return LVN
		return "redirect:report";
	}
	
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("no") int no,RedirectAttributes attrs) {
		System.out.println("EmployeeOpertionsController.deleteEmployee()");
		//use service
		System.out.println("Number::"+no);
		String msg = service.deleteEmployee(no);
		//List<Employee> list = service.getAllEmployees();
		//keep results in model attributes
		 attrs.addFlashAttribute("resultMsg",msg);
		//return lVN
		return "redirect:report";
	}
	
}//class

package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repo.IEmployeeRepo;
@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepo empRepo;

	@Override
	public List<Employee> getAllEmployees() {
		System.out.println("EmployeeMgmtServiceImpl.getAllEmployees()");
		 return  empRepo.findAll();
	}

	@Override
	public String registerEmployee(Employee emp) {
		System.out.println("EmployeeMgmtServiceImpl.registerEmployee()");
		 int idVal = empRepo.save(emp).getEmpno();
		 return  "Employee is saved with the id value::"+idVal;
	}

	@Override
	public Employee getEmployeeByNo(int no) {
		System.out.println("EmployeeMgmtServiceImpl.getEmployeeByNo()");
		 Employee emp = empRepo.findById(no).get();
		 return emp;
	}

	@Override
	public String editEmployee(Employee emp) {
		System.out.println("EmployeeMgmtServiceImpl.editEmployee()");
		 int idVal = empRepo.save(emp).getEmpno();
		 return idVal+" Employee is updated";
	}

	@Override
	public String deleteEmployee(int no) {
		System.out.println("EmployeeMgmtServiceImpl.deleteEmployee()");
		 empRepo.deleteById(no);
		 return no+" Emp No  is deleted";
	}

}

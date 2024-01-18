package com.example.UnitTest;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class EmployeeController {

		@Autowired
	private static EmployeeService employeeService;
    
   @GetMapping("/getAll")
    public List<EmployeeModel> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/getid/{id}")
    public static EmployeeModel getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employee")
    public static EmployeeModel createEmployee(@RequestBody EmployeeModel employeeModel) {
        return employeeService.createEmployee(employeeModel);
    }

    @PutMapping("/{id}")
    public static EmployeeModel updateEmployee(@PathVariable Long id, @RequestBody EmployeeModel EmployeeDetails) {
        return employeeService.updateEmployee(id, EmployeeDetails);
    }

    @DeleteMapping("/delete/{id}")
    public static ResponseEntity<?> deleteEmployee(@PathVariable Long id, @RequestBody EmployeeModel EmployeeDetails) {
        employeeService.deleteEmployee(EmployeeDetails);
        return ResponseEntity.ok().build();
    }

//	public static void setEmployeeService(Object employeeService2) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public ResponseEntity<?> setAge() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public ResponseEntity<?> setEmp_Id() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public ResponseEntity<?> setEmailID() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public ResponseEntity<?> setPhoneNumber() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public ResponseEntity<?> setEmployeeFirstName() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	

			
	}



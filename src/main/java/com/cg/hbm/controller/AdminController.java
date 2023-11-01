package com.cg.hbm.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hbm.dto.AdminDTO;
import com.cg.hbm.entity.Admin;
import com.cg.hbm.service.IAdminService;
import com.cg.hbm.util.AdminDTOConvertor;



@RestController
@RequestMapping("/admin")
//@CrossOrigin(origins= {"http://localhost:4200","http://localhost:6001"},allowedHeaders="*")

public class AdminController {

	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	IAdminService adminService;

	@Autowired
	AdminDTOConvertor dtoConvertor;

	public AdminController() {
		logger.info("admin admin Called");
		System.err.println("admin admin Called");

	}
	@PostMapping("/add")

	public ResponseEntity<AdminDTO> saveCustomer(@RequestBody Admin admin) throws Exception {

		Admin savedAdmin = adminService.registerAdmin(admin);
		logger.info("----> Customer Saved <----" + savedAdmin);

		AdminDTO dto = dtoConvertor.convertTo(savedAdmin);

		return new ResponseEntity<AdminDTO>(dto, HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<List<AdminDTO>> getAllUsers() {

		List<Admin> allAdminsInDB = adminService.getAllAdmins();

		List<AdminDTO> dtoList = new ArrayList<>();
		for (Admin user : allAdminsInDB) {

			AdminDTO dto = dtoConvertor.convertTo(user);
			dtoList.add(dto);
		}

		return new ResponseEntity<List<AdminDTO>>(dtoList, HttpStatus.OK);
	}
	
//	@GetMapping("/login/{uId}/{password}")
//	public ResponseEntity<AdminDTO> doLogin( @PathVariable int uId,@PathVariable String password)
//	{
//		User userFromDB = userService.getUserById(uId);
//		System.err.println(userFromDB);
//		if (userFromDB != null) {
//			if(userFromDB.getPassword().equals(password)) {
//				System.err.println("inside if");
//				UserDTO dto = dtoConvertor.convertTo(userFromDB);
//				return new ResponseEntity<UserDTO>(dto, HttpStatus.OK);
//			}
//			return null;
//		} else
//			return null;
//	}
//	
//	
//
//	@GetMapping("/userbycity/{city}")
//
//	public ResponseEntity<List<CustomerDTO>> getUserByCity(@PathVariable String city) {
//
//		List<Customer> allUsers = userService.getUserByCity(city);
//		List<CustomerDTO> dto = new ArrayList<>();
//		for(Customer user: allUsers) {
//			CustomerDTO userDTO = dtoConvertor.convertTo(user);
//			dto.add(userDTO);
//		}
//
//		return new ResponseEntity<List<CustomerDTO>>(dto, HttpStatus.OK);
//
//	}
//
//	@GetMapping("/userbystate/{state}")
//
//	public ResponseEntity<List<CustomerDTO>> getUserByState(@PathVariable String state) {
//
//		List<Customer> allUsers = userService.getUserByState(state);
//		List<CustomerDTO> dtoObj= new ArrayList<>();
//		for(Customer user: allUsers) {
//			CustomerDTO userDTO = dtoConvertor.convertTo(user);
//			dtoObj.add(userDTO);
//		}
//
//		return new ResponseEntity<List<CustomerDTO>>(dtoObj, HttpStatus.OK);
//	
//		
//	}

	@GetMapping("/userbyid/{userId}")

	public ResponseEntity<AdminDTO> getadminById(@PathVariable int adminId) throws Exception {
		Admin adminFromDB = adminService.getadminById(adminId);
		if (adminFromDB != null) {
			AdminDTO dto = dtoConvertor.convertTo(adminFromDB);
			return new ResponseEntity<AdminDTO>(dto, HttpStatus.OK);
		} else
			return null;
	}

	@PutMapping("/updateuser/{userId}")

	public String updatedAdmin(@PathVariable int adminId) {

		Admin updatedAdmin = adminService.getadminById(adminId);
		return updatedAdmin.toString();
	}

}
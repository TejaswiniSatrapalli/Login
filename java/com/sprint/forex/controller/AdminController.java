package com.sprint.forex.controller;

import java.util.List;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.forex.dto.AdminDto;
import com.sprint.forex.dto.AdminLoginDto;
import com.sprint.forex.dto.CommonDTO;
import com.sprint.forex.dto.ExchangeRateDto;
import com.sprint.forex.dto.ForgotPassDTO;
import com.sprint.forex.dto.ResetPasswordDTO;
import com.sprint.forex.dto.SendOtpDTO;
import com.sprint.forex.entity.Admin;
import com.sprint.forex.entity.ExchangeRate;
import com.sprint.forex.entity.Users;
import com.sprint.forex.exception.InvalidInputException;
import com.sprint.forex.repository.AdminRepository;
import com.sprint.forex.service.AdminAuthenticationService;
import com.sprint.forex.service.AdminService;
import com.sprint.forex.service.ExchangeRateService;
import com.sprint.forex.service.UsersService;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private AdminAuthenticationService adminAuthenticationService;

	@Autowired
	private ExchangeRateService exchangeRateService;

	@Autowired
	private UsersService usersService;
	//admin save

	@GetMapping("/users/all")
	public List<Users> fetchAllUsers() {
		return usersService.getAllUsers();
	}
	@PostMapping("/login")
	public ResponseEntity<CommonDTO<Admin>> adminLogin(@RequestBody AdminLoginDto adminLoginDto) {
		Admin admin = adminAuthenticationService.doLogin(adminLoginDto.getAdminUsername(), adminLoginDto.getAdminPassword());
		return new ResponseEntity<>(new CommonDTO<>("Success", admin), HttpStatus.OK);
	}
	@PostMapping("/save")
	public ResponseEntity<CommonDTO<AdminDto>> addAdmin(@RequestBody AdminDto admin) {
		AdminDto newAdmin = adminService.saveAdmin(admin);
		return new ResponseEntity<>(new CommonDTO<>("Successfully admin created",newAdmin), HttpStatus.CREATED);
	}
	
	@PostMapping("/exchangeRate/save")
	public ResponseEntity<ExchangeRateDto> addExchangeRate(@RequestBody ExchangeRateDto exchangeRateDto) {
		ExchangeRateDto newExchangeRateDto = adminService.saveExchangeRate(exchangeRateDto);
		ResponseEntity<ExchangeRateDto> responseEntity = new ResponseEntity<>(newExchangeRateDto, HttpStatus.CREATED);
		return responseEntity;
	}
//  @PutMapping("/exchangeRate/update")


//		return new ResponseEntity<>(new CommonDTO<>("Exchange rate successfully updated",updatedexchangeRate), HttpStatus.OK);
//
//
//	}
  
	@PutMapping("/reset-password")
	public ResponseEntity<CommonDTO<String>> resetPassword(@RequestBody ResetPasswordDTO r) throws InvalidInputException {
		return ResponseEntity.ok(new CommonDTO<>(adminService.resetPassword(r.getEmail(),r.getOldPassword(),r.getNewPassword()), null));
  }
//	@PutMapping("/forgot-password")
//	public ResponseEntity<CommonDTO<String>> forgotPassword(@RequestBody ForgotPassDTO r) throws InvalidInputException {
//		@SuppressWarnings("unused")
//		Boolean isOtpVerify = adminAuthenticationService.verifyOtp(r.getEmail(), r.getOtp());
//		var res = adminService.resetForgotPassword(r.getEmail(),r.getPassword(),r.getPassword());
//		return ResponseEntity.ok(new CommonDTO<>(res,res));
//    }
//	@PostMapping("/sendEmail")
//	public ResponseEntity<CommonDTO<String>> sendEmail(@RequestBody SendOtpDTO r) {
//		var res = adminAuthenticationService.sendEmail(r.getEmail());
//		return ResponseEntity.ok(new CommonDTO<>(res,res));
//	}

	@GetMapping("/rate/all")
	public List<ExchangeRate> findAllRates() {
		List<ExchangeRate> list = exchangeRateService.findAllRates();
		return list;
	}
      
}

package com.sprint.forex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.forex.dto.CommonDTO;
import com.sprint.forex.dto.ForgotPassDTO;
import com.sprint.forex.dto.LoginDto;
import com.sprint.forex.dto.ResetPasswordDTO;
import com.sprint.forex.dto.SendOtpDTO;
import com.sprint.forex.dto.UsersDto;
import com.sprint.forex.entity.Users;
import com.sprint.forex.exception.InvalidInputException;
import com.sprint.forex.service.UsersAuthenticationService;
import com.sprint.forex.service.UsersService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UsersController {
	
	@Autowired
	private UsersService usersService;

	@Autowired
	private UsersAuthenticationService usersAuthenticationService;

	@PostMapping("/login")
	public ResponseEntity<CommonDTO<Users>> doLogin(@RequestBody LoginDto loginReq) {
		Users users = usersAuthenticationService.login(loginReq.getEmail(), loginReq.getPassword());
		return new ResponseEntity<>(new CommonDTO<>("Auth successfully", users), HttpStatus.OK);
	}

	@PutMapping("/forgot-password")
	public ResponseEntity<CommonDTO<String>> forgotPassword(@RequestBody ForgotPassDTO r) throws InvalidInputException {
		Boolean isOtpVerify = usersAuthenticationService.verifyOtp(r.getEmail(), r.getOtp());
		if(!isOtpVerify) throw new InvalidInputException("OTP not valid");
		var res = usersService.resetForgotPassword(r.getEmail(),r.getPassword(),r.getPassword());
		return ResponseEntity.ok(new CommonDTO<>(res,res));
    }
	
	
	@PutMapping("/reset-password")
	public ResponseEntity<CommonDTO<String>> resetPassword(@RequestBody ResetPasswordDTO r) throws InvalidInputException {

		return ResponseEntity.ok(new CommonDTO<>(usersService.resetPassword(r.getEmail(),r.getOldPassword(),r.getNewPassword()),usersService.resetPassword(r.getEmail(),r.getOldPassword(),r.getNewPassword())));
    }
	@PostMapping("/sendEmail")
	public ResponseEntity<CommonDTO<String>> sendEmail(@RequestBody SendOtpDTO r) {
		var res =  usersAuthenticationService.sendEmail(r.getEmail());
		return ResponseEntity.ok(new CommonDTO<>(res,res));
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<CommonDTO<UsersDto>> addUsers(@RequestBody UsersDto usersDto) {
		UsersDto newUsers = usersService.saveUsers(usersDto);
		return new ResponseEntity<>(new CommonDTO<>("User created successfully", newUsers), HttpStatus.CREATED);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CommonDTO<String>> removeUsers(@PathVariable("id") int usersId) {
		usersService.deleteUsers(usersId);
		return new ResponseEntity<>(new CommonDTO<>("User Deleted Successfully","Users Deleted Successfully"), HttpStatus.OK);

	}
	

	
	@GetMapping("/all")
	public List<Users> fetchAllUsers() {
		List<Users> list = usersService.getAllUsers();
		return list;
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Users> fetchUsersDetails(@PathVariable("id") int usersId) {
		Users users = usersService.getUsersById(usersId);
		ResponseEntity<Users> responseEntity = new ResponseEntity<>(users, HttpStatus.OK);
		return responseEntity;
	}
	

}
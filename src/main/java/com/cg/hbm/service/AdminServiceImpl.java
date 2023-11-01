package com.cg.hbm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbm.entity.Admin;
import com.cg.hbm.entity.User;
import com.cg.hbm.exceptions.InvalidUserException;
import com.cg.hbm.repository.AdminRepository;
import com.cg.hbm.service.IAdminService;


@Service
public class AdminServiceImpl implements IAdminService{
	
		@Autowired
	AdminRepository adminRepository;

	@Override
	public Admin registerAdmin(Admin admin)throws InvalidUserException {
	
		if(admin.getAdminName().equals("")) {
			throw new InvalidUserException("User name","User Name is null");
		}
		
		if(admin.getEmailId().equals("")) {
			throw new InvalidUserException("Email Id","Email Id cannot be null");
		}
		if(admin.getPassword().equals("")) {
			throw new InvalidUserException("Password","Password cannot be null");
		}
		return adminRepository.save(admin);
	}

	@Override
	public List<Admin> getAllAdmins() {

		return adminRepository.findAll();
	}
	
	@Override
	public Admin getadminById(int adminId) {
		
		Admin adminFromDB = adminRepository.getReferenceById(adminId);
		adminRepository.getReferenceById(adminId);
	
		return adminFromDB;
	}

	@Override
	public Admin updateAdmin(int adminId) {
	
		Admin updatedAdmin =adminRepository.getReferenceById(adminId);
		adminRepository.save(updatedAdmin);
		return updatedAdmin;
	}

	

	
//	@Override
//	public List<User> getUserByCity(String searchCity) {
//		//get all users 
//		List<Customer> allUsers = customerRepository.findAll();
//		//Filter user through for loop based on city
//		List<Customer> allUserByCity = new ArrayList<>();
//		for(Customer user : allUsers) {
//			String userCity =user.getAddress().getCity();
//		if(userCity.equals(searchCity)) {
//			allUserByCity.add(user);
//		}
//		}
//		
//		return allUserByCity;
//	}
//	
//	

//	@Override
//	public List<Customer> getUserByState(String searchstate) {
//		
//		List<Customer> allUsers = customerRepository.findAll();
//		List<Customer> allUserByState = new ArrayList<>();
//		for (Customer user: allUsers) {
//			String userState = user.getAddress().getState();
//			if(userState.equals(searchstate)) {
//				allUserByState.add(user);
//			}
//		}
//		return allUserByState;
//	}




}

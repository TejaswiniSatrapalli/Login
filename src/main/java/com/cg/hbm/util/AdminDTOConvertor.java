package com.cg.hbm.util;


import org.springframework.stereotype.Component;

import com.cg.hbm.dto.AdminDTO;

import com.cg.hbm.entity.Admin;



@Component

public class AdminDTOConvertor {
		
	public AdminDTO convertTo(Admin admin) {

		return new AdminDTO(admin.getAdminId(), admin.getAdminName(),admin.getPassword(),admin.getEmailId(),admin.getPhoneNumber());
	}


}

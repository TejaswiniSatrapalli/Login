package com.cg.hbm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor



public class UserDTO {
	
	private int userId;
	private String userName;
	private String password;
	private String emailId;
	private long phoneNumber;
	

}



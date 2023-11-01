package com.cg.hbm.util;

import org.springframework.stereotype.Component;

import com.cg.hbm.dto.UserDTO;
import com.cg.hbm.entity.User;


@Component

public class UserDTOConvertor {
	
	public UserDTO convertTo(User user) {

		return new UserDTO(user.getUserId(), user.getUserName(),user.getPassword(),user.getEmailId(),user.getPhoneNumber());
	}

}



package com.cg.hbm.dto;

import java.sql.Date;

import lombok.Data;
 
@Data
public class AppoinmentsResponseDTO {
 
		private Long id;
	    private String subject;
	    private Date startTime;
	    private Date endTime;
	    private String msge;
		
		
 
	}
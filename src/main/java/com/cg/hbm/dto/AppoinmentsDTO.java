package com.cg.hbm.dto;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
 
public class AppoinmentsDTO {
	
    private Long id;
    private String subject;
    private Date startTime;
    private Date endTime;
	
	
 
}

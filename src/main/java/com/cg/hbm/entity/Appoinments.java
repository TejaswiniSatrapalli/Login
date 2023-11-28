package com.cg.hbm.entity;

import java.sql.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Entity
@Data
@NoArgsConstructor
public class Appoinments {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String subject;
	    private Date startTime;
	    private Date endTime;
	    
	    
		public Appoinments(Long id, String subject, Date startTime, Date endTime) {
			super();
			this.id = id;
			this.subject = subject;
			this.startTime = startTime;
			this.endTime = endTime;
		}

 
}

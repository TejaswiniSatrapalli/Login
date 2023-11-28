package com.cg.hbm.service;

import java.util.List;

import com.cg.hbm.dto.AppoinmentsDTO;
import com.cg.hbm.entity.Appoinments;

public interface IAppoinmentsService {

	List<Appoinments> getAll();
	
	Appoinments addAppoinment(Appoinments appoinments)throws Exception;

}

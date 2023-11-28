package com.cg.hbm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbm.entity.Appoinments;
import com.cg.hbm.repository.AppoinmentsRepository;


@Service
public class AppoinmentsService implements IAppoinmentsService{
	
	@Autowired
	AppoinmentsRepository appoinmentsRepository;
	
	@Override
	public List<Appoinments> getAll() {
		
		return appoinmentsRepository.findAll();	
	}

	@Override
	public Appoinments addAppoinment(Appoinments appoinments) {
	
		return appoinmentsRepository.save(appoinments);
	}
	

}

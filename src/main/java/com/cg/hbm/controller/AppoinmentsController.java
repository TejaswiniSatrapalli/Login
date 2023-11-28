package com.cg.hbm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hbm.dto.AppoinmentsResponseDTO;
import com.cg.hbm.entity.Appoinments;
import com.cg.hbm.service.AppoinmentsService;
import com.cg.hbm.util.AppoinmentsDTOConvertor;

@RestController
@RequestMapping("/appoinments")

//	@CrossOrigin(origins = {"http://localhost:4200/","http://localhost:2004/"},allowedHeaders = "*")


public class AppoinmentsController {
		
		private final Logger logger = LoggerFactory.getLogger(this.getClass());
		
		@Autowired
		AppoinmentsService appoinmentsService;
		
		@Autowired
		AppoinmentsDTOConvertor appoinmentsDTOConvertor;

		public AppoinmentsController() {
			
		logger.info("---appoinments Controller Called --");
		logger.warn("---appoinments Controller Called --");
		
		System.err.println("appoinments Controller Called");
	    }
		
		@PostMapping("/addAppoinment")
		public ResponseEntity<AppoinmentsResponseDTO> addReview(@RequestBody Appoinments appoinments) throws Exception
		{
			Appoinments savedAppoinment = appoinmentsService.addAppoinment(appoinments);
			
			logger.info("---->> Appoinment saved"+savedAppoinment);
			
			
			if(savedAppoinment != null) {

				AppoinmentsResponseDTO dtoObj = appoinmentsDTOConvertor.getAppoinmentsResponseDTO(savedAppoinment);
			return new ResponseEntity<AppoinmentsResponseDTO>(dtoObj,HttpStatus.OK);
		}
			return null;
				
		}
		
		
//		@GetMapping("/reviews")
//		public ResponseEntity<List<ReviewResponseDTO>> getAllReviews()
//		{
//			List<Review> allReviews = reviewService.getAllReviews();
//			List<ReviewResponseDTO> allReviewDTO = new ArrayList<>();
//			
//			for (Review review : allReviews) {
//				
//				allReviewDTO.add(reviewDTOConvertor.getReviewResponseDTO(review));		
//			}
//			return new ResponseEntity<List<ReviewResponseDTO>>(allReviewDTO,HttpStatus.OK);
//		}
		
	

}

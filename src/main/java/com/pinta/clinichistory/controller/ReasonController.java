package com.pinta.clinichistory.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinta.clinichistory.dto.ReasonDTO;
import com.pinta.clinichistory.model.Reason;
import com.pinta.clinichistory.service.ReasonService;

@RequestMapping("/api/reasons")
@CrossOrigin(origins = "*")
@RestController
public class ReasonController {
	
	@Autowired
	private ReasonService resonService;
	
	@PostMapping("/")
	public ResponseEntity<ReasonDTO> createReson(@RequestBody ReasonDTO request){
		Reason newReason = new Reason(request);
		Reason dbReason = this.resonService.findByName(request.getName());
		if(dbReason != null) {
			throw new ServiceException("Ya se encuentra registrada un sintoma llamado: "+ request.getName());
		}
		this.resonService.createReason(newReason);
		
		return new ResponseEntity<ReasonDTO>(new ReasonDTO(newReason),HttpStatus.OK );
	}
	
	@GetMapping("/")
	public List<ReasonDTO> getReasons(){
		return 
			this.resonService.findAllReasons().stream()
			.map(ReasonDTO::new).collect(Collectors.toList());
	}
}

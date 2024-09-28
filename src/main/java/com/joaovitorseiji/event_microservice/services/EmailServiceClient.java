package com.joaovitorseiji.event_microservice.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.joaovitorseiji.event_microservice.dtos.EmailRequestDTO;

@FeignClient(name = "email-service", url = "http://localhost:8080/api/email")
public interface EmailServiceClient {
	
	@PostMapping("/send")
	void sendEmail(@RequestBody EmailRequestDTO emailRequest);

}
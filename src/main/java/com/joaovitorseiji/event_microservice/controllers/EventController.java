package com.joaovitorseiji.event_microservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaovitorseiji.event_microservice.domain.Event;
import com.joaovitorseiji.event_microservice.dtos.EventRequestDTO;
import com.joaovitorseiji.event_microservice.dtos.SubscriptionRequestDTO;
import com.joaovitorseiji.event_microservice.services.EventService;

@RestController
@RequestMapping("/events")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@GetMapping
	public List<Event> getAllEvents(){
		return eventService.getAllEvents();
	}
	
	@GetMapping("/upcoming")
	public List<Event> getUpcomingEvents(){
		return eventService.getUpcomingEvents();
	}
	
	@PostMapping
	public Event createEvent(@RequestBody EventRequestDTO event) {
		return eventService.createEvent(event);
	}
	
	@PostMapping("/{eventId}/register")
	public void registerPartipant(@PathVariable String eventId, @RequestBody SubscriptionRequestDTO request) {
		eventService.registerParticipant(eventId, request.participantEmail());
		
	}
}

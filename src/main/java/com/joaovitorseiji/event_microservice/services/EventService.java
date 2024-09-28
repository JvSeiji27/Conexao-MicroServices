package com.joaovitorseiji.event_microservice.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaovitorseiji.event_microservice.domain.Event;
import com.joaovitorseiji.event_microservice.domain.Subscription;
import com.joaovitorseiji.event_microservice.dtos.EmailRequestDTO;
import com.joaovitorseiji.event_microservice.dtos.EventRequestDTO;
import com.joaovitorseiji.event_microservice.exception.EventFullException;
import com.joaovitorseiji.event_microservice.exception.EventNotFoundException;
import com.joaovitorseiji.event_microservice.repositories.EventRepository;
import com.joaovitorseiji.event_microservice.repositories.SubscriptionRepository;

@Service
public class EventService {

	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	SubscriptionRepository subscriptionRepository;
	
	@Autowired
	EmailServiceClient emailServiceClient;
	
	public List<Event> getAllEvents(){
		return eventRepository.findAll();
	}
	
	public List<Event> getUpcomingEvents(){
		return eventRepository.findUpcomingEvents(LocalDateTime.now());
	}
	
	public Event createEvent(EventRequestDTO eventRequest) {
		Event newEvent = new Event(eventRequest);
		return eventRepository.save(newEvent);		
	}
	
	public void registerParticipant(String eventId, String participantEmail) {
		Event event = eventRepository.findById(eventId).orElseThrow(EventNotFoundException::new);
		
		if(event.getNumberParticipants() < event.getMaxParticipants()) {
			Subscription subscription = new Subscription();
			subscriptionRepository.save(subscription);
			
			event.setNumberParticipants(event.getNumberParticipants()+1);
			
			EmailRequestDTO emailRequest = new EmailRequestDTO(participantEmail, "Confirmação de Inscrição", "Você foi inscrito para o evento com sucesso!");
			
			emailServiceClient.sendEmail(emailRequest);
		}else {
			throw new EventFullException();
		}
	
	
		
	}
	
	
}

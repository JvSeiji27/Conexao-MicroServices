package com.joaovitorseiji.event_microservice.exception;

import com.joaovitorseiji.event_microservice.domain.Event;

public class EventNotFoundException extends RuntimeException{
	public EventNotFoundException() {
		super("Evento não encontrado");
	}
	
	public EventNotFoundException(String msg) {
		super(msg);
	}
}
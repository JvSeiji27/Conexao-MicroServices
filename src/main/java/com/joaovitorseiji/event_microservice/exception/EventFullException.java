package com.joaovitorseiji.event_microservice.exception;

public class EventFullException extends RuntimeException{
	
	public EventFullException() {
		super("Evento Cheio!!");
	}
	
	public EventFullException(String msg) {
		super(msg);
	}

}

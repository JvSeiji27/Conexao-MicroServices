package com.joaovitorseiji.event_microservice.dtos;

public record EventRequestDTO(int maxParticipants, int numberParticipants, String date, String title, String description) {

}

package com.joaovitorseiji.event_microservice.domain;

import com.joaovitorseiji.event_microservice.dtos.EventRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*Estou declarando uma entidade que representa uma tabela no meu banco de dadosm na qual irei salvar os meus eventos*/

@Entity(name = "event")//Representa um objeto
@Table(name = "event")//Será uma tabela
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private int maxParticipants;
	private int numberParticipants;
	private String date;
	private String title;
	private String description;
	

	
    public Event(EventRequestDTO request) {
    	
    	this.maxParticipants = request.maxParticipants();
    	this.numberParticipants = request.numberParticipants();
    	this.date = request.date();
    	this.title = request.title();
    	this.description = request.description();
    }

}

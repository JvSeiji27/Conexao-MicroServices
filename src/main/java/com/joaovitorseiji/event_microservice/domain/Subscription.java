package com.joaovitorseiji.event_microservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="subscription")
@Table(name="subscription")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Subscription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//Temos uma relação entre entidades. O evento terá várias inscrições. A inscrição terá um evento 
	
	@ManyToOne
	private Event event;
	
	private String participantEmail;
	
	public Subscription(Event event, String participantEmail) {
		this.event = event;
		this.participantEmail = participantEmail;
	}
	
	
}

package com.joaovitorseiji.event_microservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaovitorseiji.event_microservice.domain.Subscription;

public interface SubscriptionRepository extends JpaRepository <Subscription, Long> {

}

package com.projecte.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projecte.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}

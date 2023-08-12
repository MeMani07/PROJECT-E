package com.projecte.repo;

import com.projecte.dtos.ClubDTO;
import com.projecte.dtos.EventDTO;
import com.projecte.entity.Branch;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projecte.entity.Event;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @EntityGraph(value = "Event.withClub")
    List<Event> findAll();
}

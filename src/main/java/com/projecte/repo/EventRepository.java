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

//    @Query("SELECT NEW com.projecte.dtos.EventDTO(e.eventId, e.eventName, " +
//            "NEW com.projecte.dtos.ClubDTO(c.clubId, c.clubName), " +
//            "NEW com.projecte.dtos.BranchDTO(b.branchId, b.year, b.branchName)) " +
//            "FROM Event e " +
//            "LEFT JOIN e.club c " +
//            "LEFT JOIN e.eligibleBranches b " +
//            "GROUP BY e.id, c.clubId, b.branchId")
//    List<EventDTO> findAllEventDetails();

    @Query("SELECT DISTINCT e FROM Event e " +
            "LEFT JOIN FETCH e.club c " +
            "LEFT JOIN FETCH e.eligibleBranches ee")
    List<Event> findAllEventsWithDetails();

    default List<EventDTO> findAllEventDetails() {
        List<Event> events = findAll();
        List<EventDTO> result = new ArrayList<>();

        for (Event event : events) {
            EventDTO eventDTO = new EventDTO(
                    event.getEventId(),
                    event.getEventName(),
                    event.getClub() != null ? new ClubDTO(event.getClub().getClubId(), event.getClub().getClubName()) : null ,
                    Branch.toDto(event.getEligibleBranches())
            );
            result.add(eventDTO);
        }

        return result;
    }


}

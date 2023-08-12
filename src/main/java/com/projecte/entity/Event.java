package com.projecte.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.projecte.dtos.ClubDTO;
import com.projecte.dtos.EventDTO;

import jakarta.persistence.*;

@Entity
@NamedEntityGraph(name = "Event.withClub",
        attributeNodes = {
                @NamedAttributeNode(value = "club"),
                @NamedAttributeNode(value = "eligibleBranches"),
				@NamedAttributeNode(value = "registeredStudents"),
				@NamedAttributeNode(value = "attendedStudents")
        })
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "event_name")
    private String eventName;

    @ManyToOne
    @JoinColumn(name = "club_id")
	@JsonIgnoreProperties("events")
    private Club club;

    @ManyToMany(mappedBy = "registeredEvents")
    @JsonIgnoreProperties("registeredEvents")
    private Set<Student> registeredStudents = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "event_attendance",
        joinColumns = @JoinColumn(name = "event_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
	@JsonIgnoreProperties("attendedEvents")
    private Set<Student> attendedStudents = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "event_eligibility",
        joinColumns = @JoinColumn(name = "event_id"),
        inverseJoinColumns = @JoinColumn(name = "branch_id")
    )
    @JsonIgnoreProperties("eligibleEvents")
    private Set<Branch> eligibleBranches;

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public Set<Student> getRegisteredStudents() {
		return registeredStudents;
	}

	public void setRegisteredStudents(Set<Student> registeredStudents) {
		this.registeredStudents = registeredStudents;
	}

	public Set<Student> getAttendedStudents() {
		return attendedStudents;
	}

	public void setAttendedStudents(Set<Student> attendedStudents) {
		this.attendedStudents = attendedStudents;
	}

	public Set<Branch> getEligibleBranches() {
		return eligibleBranches;
	}

	public void setEligibleBranches(Set<Branch> eligibleBranches) {
		this.eligibleBranches = eligibleBranches;
	}
	
	public static EventDTO toDto(Event event) {
		return new EventDTO(
                event.getEventId(),
                event.getEventName(),
                event.getClub() != null ? new ClubDTO(event.getClub().getClubId(), event.getClub().getClubName()) : null ,
                Branch.toDto(event.getEligibleBranches()));
	}
	
	public static List<EventDTO> toDto(List<Event> events){
		List<EventDTO> result = new ArrayList<>();
        for (Event event : events) {
            result.add(toDto(event));
        }
        return result;
	}

    // Getters and setters...
}

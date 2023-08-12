package com.projecte.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@NamedEntityGraph(name = "Event.withClub",
        attributeNodes = {
                @NamedAttributeNode(value = "club"),
                @NamedAttributeNode(value = "eligibleBranches")
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

    @ManyToMany
    @JoinTable(
        name = "event_registration",
        joinColumns = @JoinColumn(name = "event_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    @JsonIgnore
    private Set<Student> registeredStudents = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "event_attendance",
        joinColumns = @JoinColumn(name = "event_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    @JsonIgnore
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

    // Getters and setters...
}

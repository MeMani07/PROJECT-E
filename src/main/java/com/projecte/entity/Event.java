package com.projecte.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "event_name")
    private String eventName;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    @ManyToMany
    @JoinTable(
        name = "event_registration",
        joinColumns = @JoinColumn(name = "event_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    @JsonManagedReference
    private Set<Student> registeredStudents = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "event_attendance",
        joinColumns = @JoinColumn(name = "event_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    @JsonManagedReference
    private Set<Student> attendedStudents = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "event_eligibility",
        joinColumns = @JoinColumn(name = "event_id"),
        inverseJoinColumns = @JoinColumn(name = "branch_id")
    )
    @JsonManagedReference
    private Set<Branch> eligibleBranches = new HashSet<>();

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

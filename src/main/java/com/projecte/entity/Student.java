package com.projecte.entity;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToMany(mappedBy = "registeredStudents")
    @JsonIgnore
    private Set<Event> registeredEvents = new HashSet<>();

    @ManyToMany(mappedBy = "attendedStudents")
    @JsonIgnore
    private Set<Event> attendedEvents = new HashSet<>();

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Set<Event> getRegisteredEvents() {
		return registeredEvents;
	}

	public void setRegisteredEvents(Set<Event> registeredEvents) {
		this.registeredEvents = registeredEvents;
	}
	
	public Set<Event> getAttendedEvents() {
		return attendedEvents;
	}
	
	public void setAttendedEvents(Set<Event> attendedEvents) {
		this.attendedEvents = attendedEvents;
	}

    // Getters and setters...
}
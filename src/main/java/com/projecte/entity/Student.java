package com.projecte.entity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projecte.dtos.BranchDTO;
import com.projecte.dtos.StudentDTO;

import jakarta.persistence.*;

@Entity
@NamedEntityGraph(name = "Student.withBranch",
attributeNodes = {
        @NamedAttributeNode(value = "branch"),
        @NamedAttributeNode(value = "registeredEvents"),
        @NamedAttributeNode(value = "attendedEvents")
})
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
    @JsonIgnoreProperties("students")
    @JoinColumn(name = "branch_id")
    private Branch branch;
    
    @ManyToMany
    @JoinTable(
        name = "event_registration",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    @JsonIgnoreProperties("registeredStudents")
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
	
	public static StudentDTO toDto(Student student) {
		return new StudentDTO(
        		student.getStudentId(),
        		student.getStudentName(),
        		student.getEmail(),
        		student.getMobile(),
        		student.getBranch()!=null? new BranchDTO(student.getBranch().getBranchId(),student.getBranch().getYear(),student.getBranch().getBranchName()):null);
	}
	
	public static List<StudentDTO> toDto(List<Student> students){
		List<StudentDTO> result = new ArrayList<>();
		for (Student student : students) {
			result.add(toDto(student));
		}
		return result;
	}

	@Override
	public String toString() {
		return "Student{" +
				"studentId=" + studentId +
				", studentName='" + studentName + '\'' +
				", email='" + email + '\'' +
				", mobile='" + mobile + '\'' +
				", branch=" + branch +
				", registeredEvents=" + registeredEvents +
				", attendedEvents=" + attendedEvents +
				'}';
	}
// Getters and setters...
}
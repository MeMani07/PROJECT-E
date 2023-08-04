package com.projecte.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
public class Branch {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id")
    private Long branchId;

    @Column(name = "year")
    private int year;

    @Column(name = "branch_name")
    private String branchName;

    @ManyToMany(mappedBy = "eligibleBranches")
    @JsonBackReference
    private Set<Event> eligibleEvents = new HashSet<>();

    @OneToMany(mappedBy = "branch")
    private List<Student> students = new ArrayList<>();

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Set<Event> getEligibleEvents() {
		return eligibleEvents;
	}

	public void setEligibleEvents(Set<Event> eligibleEvents) {
		this.eligibleEvents = eligibleEvents;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

    // Getters and setters...
}

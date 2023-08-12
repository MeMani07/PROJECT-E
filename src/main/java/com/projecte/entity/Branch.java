package com.projecte.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projecte.dtos.BranchDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id")
    private Long branchId;

    @Column(name = "year")
    private int year;

    @Column(name = "branch_name")
    private String branchName;

    @ManyToMany(mappedBy = "eligibleBranches")
    @JsonIgnoreProperties("eligibleBranches")
    private Set<Event> eligibleEvents = new HashSet<>();

    @OneToMany(mappedBy = "branch")
	@JsonIgnoreProperties("branch")
    private List<Student> students = new ArrayList<>();
    
    public static BranchDTO toDto(Branch branch) {
    	return new BranchDTO(branch.getBranchId(),branch.getYear(),branch.getBranchName());
    }

	public static Set<BranchDTO> toDto(Set<Branch> branches) {
		Set<BranchDTO> branchDTOS = new HashSet<>();
		for(Branch branch: branches){
			branchDTOS.add(toDto(branch));
		}
		return branchDTOS;
	}

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

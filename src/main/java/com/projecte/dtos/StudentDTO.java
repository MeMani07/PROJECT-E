package com.projecte.dtos;

public class StudentDTO {
	private Long studentId;
	private String studentName;
	private String email;
	private String mobile;
	private BranchDTO branchDTO;

	public StudentDTO(Long studentId, String studentName, String email, String mobile, BranchDTO branchDTO) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.email = email;
		this.mobile = mobile;
		this.branchDTO = branchDTO;
	}
	public StudentDTO(Long studentId, String studentName, String email, String mobile) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.email = email;
		this.mobile = mobile;
	}
	public StudentDTO(Long studentId, String studentName) {
		this.studentId = studentId;
		this.studentName = studentName;
	}
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
	public BranchDTO getBranchDTO() {
		return branchDTO;
	}
	public void setBranchDTO(BranchDTO branchDTO) {
		this.branchDTO = branchDTO;
	}
}

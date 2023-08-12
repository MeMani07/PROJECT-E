package com.projecte.dtos;

public class BranchDTO {

    private Long branchId;
    private int year;
    private String branchName;

    public BranchDTO(Long branchId, int year, String branchName) {
        this.branchId = branchId;
        this.year = year;
        this.branchName = branchName;
    }

    public BranchDTO() {
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
}

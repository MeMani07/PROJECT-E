package com.projecte.dtos;

public class ClubDTO {

    private Long clubId;
    private String clubName;

    public ClubDTO(Long clubId, String clubName) {
        this.clubId = clubId;
        this.clubName = clubName;
    }

    public ClubDTO() {
    }

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
}

package com.projecte.dtos;

import java.util.Set;

public class EventDTO {

    private Long eventId;

    private String eventName;

    private ClubDTO clubDTO;

    private Set<BranchDTO> branchDTOS;

    public EventDTO() {
    }

    public EventDTO(Long eventId, String eventName) {
        this.eventId = eventId;
        this.eventName = eventName;
    }

    public EventDTO(Long eventId, String eventName, ClubDTO clubDTO, Set<BranchDTO> branchDTOS) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.clubDTO = clubDTO;
        this.branchDTOS = branchDTOS;
    }

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

    public ClubDTO getClubDTO() {
        return clubDTO;
    }

    public void setClubDTO(ClubDTO clubDTO) {
        this.clubDTO = clubDTO;
    }

    public Set<BranchDTO> getBranchDTOS() {
        return branchDTOS;
    }

    public void setBranchDTOS(Set<BranchDTO> branchDTOS) {
        this.branchDTOS = branchDTOS;
    }
}

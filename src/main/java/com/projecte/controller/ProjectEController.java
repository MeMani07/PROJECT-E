package com.projecte.controller;

import java.util.List;
import java.util.Set;

import com.projecte.dtos.BranchDTO;
import com.projecte.dtos.ClubDTO;
import com.projecte.dtos.EventDTO;
import com.projecte.dtos.StudentDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projecte.entity.Branch;
import com.projecte.entity.Club;
import com.projecte.entity.Event;
import com.projecte.entity.Student;
import com.projecte.service.ProjectEService;

@RestController
@RequestMapping("/api")
public class ProjectEController {

    @Autowired
    private ProjectEService projectEService;

    @GetMapping("/students")
    public List<StudentDTO> getAllStudents() { //done

        List<StudentDTO> students = projectEService.getAllStudents();
        return students;
    }

    @GetMapping("/students/{studentId}")
    public StudentDTO getStudentById(@PathVariable Long studentId) { //doing
        return projectEService.getStudentById(studentId);
    }

    @GetMapping("/students/{studentId}/registered")
    public Set<EventDTO> getRegisteredEventsByStudentId(@PathVariable Long studentId) {
        return projectEService.getRegisteredEventsByStudentId(studentId);
    }

    @GetMapping("/events/{eventId}/registered")
    public Set<StudentDTO> getRegisteredStudentsByEventId(@PathVariable Long eventId){
    	return projectEService.getRegisteredStudentsByEventId(eventId);
    }

    @GetMapping("/events/{eventId}/attended")
    public Set<StudentDTO> getAttendedStudentsByEventId(@PathVariable Long eventId){
    	return projectEService.getAttendedStudentsByEventId(eventId);
    }

    @GetMapping("/students/{studentId}/attended")
    public Set<EventDTO> getAttendedEventsByStudentId(@PathVariable Long studentId) {
        return projectEService.getAttendedEventsByStudentId(studentId);
    }


    @PostMapping(path = "/students", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void addStudent(@RequestBody Student student) {
        projectEService.addStudent(student);
    }

    @PutMapping("/students/{studentId}")
    public void updateStudent(@PathVariable Long studentId, @RequestBody Student student) {
        student.setStudentId(studentId);
        projectEService.updateStudent(student);
    }

    @PutMapping("/students/{studentId}/register/{eventId}")
    public void registerStudentForEvent(@PathVariable Long studentId, @PathVariable Long eventId) {
        projectEService.registerStudentForEvent(studentId, eventId);
    }

    @PutMapping("/students/{studentId}/attended/{eventId}")
    public void markAttendanceByStudentId(@PathVariable Long studentId, @PathVariable Long eventId) {
        projectEService.markAttendanceByStudentId(studentId, eventId);
    }

    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        projectEService.deleteStudent(studentId);
    }

    @GetMapping("/events")
    public List<EventDTO> getAllEvents() {
        return projectEService.getAllEvents();
    }

    @GetMapping("/events/{eventId}")
    public Event getEventById(@PathVariable Long eventId) {
        return projectEService.getEventById(eventId);
    }

    @PostMapping(path = "/events", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void addEvent(@RequestBody Event event) {
        projectEService.addEvent(event);
    }

    @PutMapping("/events/{eventId}")
    public void updateEvent(@PathVariable Long eventId, @RequestBody Event event) {
        event.setEventId(eventId);
        projectEService.updateEvent(event);
    }

    @DeleteMapping("/events/{eventId}")
    public void deleteEvent(@PathVariable Long eventId) {
        projectEService.deleteEvent(eventId);
    }

    @GetMapping("/branches")
    public List<BranchDTO> getAllBranches() {
        return projectEService.getAllBranches();
    }

    @GetMapping("/branches/{branchId}")
    public BranchDTO getBranchByBranchId(@PathVariable Long branchId) {
        return projectEService.getBranchByBranchId(branchId);
    }

    @GetMapping("/branches/{branchId}/events")
    public Set<EventDTO> getEventsOfBranchByBranchId(@PathVariable Long branchId) {
        return projectEService.getEventsOfBranchByBranchId(branchId);
    }

    @GetMapping("/branches/{branchId}/students")
    public List<StudentDTO> getStudentsOfBranchByBranchId(@PathVariable Long branchId) {
        return projectEService.getStudentsOfBranchByBranchId(branchId);
    }

    @PostMapping("/branches")
    public void addBranch(@RequestBody Branch branch) {
        projectEService.addBranch(branch);
    }

    @PutMapping("/branches/{branchId}")
    public void updateBranch(@PathVariable Long branchId, @RequestBody Branch branch) {
        branch.setBranchId(branchId);
        projectEService.updateBranch(branch);
    }

    @DeleteMapping("/branches/{branchId}")
    public void deleteBranch(@PathVariable Long branchId) {
        projectEService.deleteBranch(branchId);
    }


    @GetMapping("/clubs")
    public List<ClubDTO> getAllClubs() {
        return projectEService.getAllClubs();
    }

    @GetMapping("/clubs/{clubId}")
    public ClubDTO getClubByClubId(@PathVariable Long clubId) {
        return projectEService.getClubByClubId(clubId);
    }

    @GetMapping("/clubs/{clubId}/events")
    public List<EventDTO> getAllEventsOfAClubByClubId(@PathVariable Long clubId) {
        return projectEService.getAllEventsOfAClubByClubId(clubId);
    }

    @PostMapping("/clubs")
    public void addClub(@RequestBody Club club) {
        projectEService.addClub(club);
    }

    @PutMapping("/clubs/{clubId}")
    public void updateClub(@PathVariable Long clubId, @RequestBody Club club) {
        club.setClubId(clubId);
        projectEService.updateClub(club);
    }

    @DeleteMapping("/clubs/{clubId}")
    public void deleteClub(@PathVariable Long clubId) {
        projectEService.deleteClub(clubId);
    }

    @GetMapping("/branch/{branchId}/registered/{eventId}")
    public List<StudentDTO> getRegisteredStudentsForBranchIdEventId(@PathVariable Long branchId, @PathVariable Long eventId){
        return projectEService.getRegisteredStudentsForBranchIdEventId(branchId, eventId);
    }

    @GetMapping("/branch/{branchId}/attended/{eventId}")
    public List<StudentDTO> getAttendedStudentsForBranchIdEventId(@PathVariable Long branchId, @PathVariable Long eventId){
        return projectEService.getAttendedStudentsForBranchIdEventId(branchId, eventId);
    }

    @GetMapping("/students/{studentId}/events")
    public Set<EventDTO> getAllEligibleEventsByStudentId(@PathVariable Long studentId){
        return projectEService.getAllEligibleEventsByStudentId(studentId);
    }

}

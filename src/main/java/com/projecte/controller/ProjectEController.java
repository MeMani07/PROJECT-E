package com.projecte.controller;

import java.util.List;

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


    @PostMapping(path = "/students", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void addStudent(@RequestBody Student student) {
        projectEService.addStudent(student);
    }

    @PutMapping("/students/{studentId}")
    public void updateStudent(@PathVariable Long studentId, @RequestBody Student student) {
        student.setStudentId(studentId);
        projectEService.updateStudent(student);
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
    public List<Branch> getAllBranches() {
        return projectEService.getAllBranches();
    }

    @GetMapping("/branches/{branchId}")
    public Branch getBranchByBranchId(@PathVariable Long branchId) {
        return  projectEService.getBranchByBranchId(branchId);
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
    public List<Club> getAllClubs() {
        return projectEService.getAllClubs();
    }

    @GetMapping("/clubs{clubId}")
    public Club getClubByClubId(@PathVariable Long clubId) {
        return projectEService.getClubByClubId(clubId);
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
    
    @PostMapping("/students/{studentId}/register/{eventId}")
    public void registerStudentForEvent(@PathVariable Long studentId, @PathVariable Long eventId) {
        projectEService.registerStudentForEvent(studentId, eventId);
    }

}

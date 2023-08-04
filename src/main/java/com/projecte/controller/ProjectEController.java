package com.projecte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Student> getAllStudents() {
        return projectEService.getAllStudents();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable Long studentId) {
        return projectEService.getStudentById(studentId);
    }


    @PostMapping("/students")
    public void addStudent(@RequestBody Student student) {
        projectEService.addStudent(student);
    }

//    @PutMapping("/students/{studentId}")
//    public void updateStudent(@PathVariable Long studentId, @RequestBody Student student) {
//        student.setId(studentId);
//        projectEService.updateStudent(student);
//    }

    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        projectEService.deleteStudent(studentId);
    }

    @GetMapping("/events")
    public List<Event> getAllEvents() {
        return projectEService.getAllEvents();
    }
    @GetMapping("/events/{eventId}")
    public Event getEventById(@PathVariable Long eventId) {
        return projectEService.getEventById(eventId);
    }
    
    @PostMapping("/events")
    public void addEvent(@RequestBody Event event) {
        projectEService.addEvent(event);
    }

//    @PutMapping("/events/{eventId}")
//    public void updateEvent(@PathVariable Long eventId, @RequestBody Event event) {
//        event.setId(eventId);
//        projectEService.updateEvent(event);
//    }

    @DeleteMapping("/events/{eventId}")
    public void deleteEvent(@PathVariable Long eventId) {
        projectEService.deleteEvent(eventId);
    }

    @PostMapping("/branches")
    public void addBranch(@RequestBody Branch branch) {
        projectEService.addBranch(branch);
    }
//
//    @PutMapping("/branches/{branchId}")
//    public void updateBranch(@PathVariable Long branchId, @RequestBody Branch branch) {
//        branch.setId(branchId);
//        projectEService.updateBranch(branch);
//    }

    @DeleteMapping("/branches/{branchId}")
    public void deleteBranch(@PathVariable Long branchId) {
        projectEService.deleteBranch(branchId);
    }

    @PostMapping("/clubs")
    public void addClub(@RequestBody Club club) {
        projectEService.addClub(club);
    }

//    @PutMapping("/clubs/{clubId}")
//    public void updateClub(@PathVariable Long clubId, @RequestBody Club club) {
//        club.setId(clubId);
//        projectEService.updateClub(club);
//    }

    @DeleteMapping("/clubs/{clubId}")
    public void deleteClub(@PathVariable Long clubId) {
        projectEService.deleteClub(clubId);
    }

    // Rest of the methods from previous examples...
}

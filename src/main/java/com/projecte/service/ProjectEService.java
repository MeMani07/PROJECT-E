package com.projecte.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecte.entity.Branch;
import com.projecte.entity.Club;
import com.projecte.entity.Event;
import com.projecte.entity.Student;
import com.projecte.repo.BranchRepository;
import com.projecte.repo.ClubRepository;
import com.projecte.repo.EventRepository;
import com.projecte.repo.StudentRepository;

@Service
public class ProjectEService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private ClubRepository clubRepository;

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        return studentOptional.orElse(null);
    }


    public void addEvent(Event event) {
        eventRepository.save(event);
    }

    public void updateEvent(Event event) {
        eventRepository.save(event);
    }

    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long eventId) {
        Optional<Event> eventOptional = eventRepository.findById(eventId);
        return eventOptional.orElse(null);
    }

    public void addBranch(Branch branch) {
        branchRepository.save(branch);
    }

    public void updateBranch(Branch branch) {
        branchRepository.save(branch);
    }

    public void deleteBranch(Long branchId) {
        branchRepository.deleteById(branchId);
    }

    public void addClub(Club club) {
        clubRepository.save(club);
    }

    public void updateClub(Club club) {
        clubRepository.save(club);
    }

    public void deleteClub(Long clubId) {
        clubRepository.deleteById(clubId);
    }

    // Rest of the methods from previous examples...
}

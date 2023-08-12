package com.projecte.service;

import java.util.*;

import com.projecte.dtos.BranchDTO;
import com.projecte.dtos.ClubDTO;
import com.projecte.dtos.EventDTO;
import com.projecte.dtos.StudentDTO;

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
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
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

    public List<StudentDTO> getAllStudents() {
    	List<Student> students = studentRepository.findAll();
        return Student.toDto(students);
    }

    public StudentDTO getStudentById(Long studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        Student student = studentOptional.orElse(null);
        return Student.toDto(student);
    }


    public void addEvent(Event event) {
        Set<Branch> branches = new HashSet<>();
        for(Branch branchPassed: event.getEligibleBranches()){
            Branch branch = getBranchByBranchId(branchPassed.getBranchId());
            branches.add(branch);
        }
        event.setEligibleBranches(branches);
        eventRepository.save(event);
    }

    public void updateEvent(Event event) {
        eventRepository.save(event);
    }

    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }

    public List<EventDTO> getAllEvents() {
    	List<Event> events = eventRepository.findAll();
        return Event.toDto(events);
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

    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }

    public Branch getBranchByBranchId(Long branchId) {
        Optional<Branch> branchOptional = branchRepository.findById(branchId);
        return branchOptional.orElse(null);
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

    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    public Club getClubByClubId(Long clubId) {
        Optional<Club> clubOptional = clubRepository.findById(clubId);
        return clubOptional.orElse(null);
    }
    
    public void registerStudentForEvent(Long studentId, Long eventId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        Student student = studentOptional.orElse(null);
        Event event = getEventById(eventId);
        if (student != null && event != null) {
            student.getRegisteredEvents().add(event);
            studentRepository.save(student);
        } else {
            // Handle student or event not found
        }
    }
}

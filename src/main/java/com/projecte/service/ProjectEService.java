package com.projecte.service;

import java.util.*;

import com.projecte.dtos.EventDTO;
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

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        return studentOptional.orElse(null);
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
        return eventRepository.findAllEventDetails();
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
}

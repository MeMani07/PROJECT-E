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
    
    public Set<StudentDTO> getRegisteredStudentsByEventId(Long eventId){
    	Optional<Event> eventOptional = eventRepository.findById(eventId);
    	Event event = eventOptional.orElse(null);
    	Set<Student> students = event.getRegisteredStudents();
    	Set<StudentDTO> studentDTOs = new HashSet<>();
    	for(Student student:students) {
    		studentDTOs.add(new StudentDTO(student.getStudentId(),student.getStudentName()));
    	}
    	return studentDTOs;
    }
    
    public Set<StudentDTO> getAttendedStudentsByEventId(Long eventId){
    	Optional<Event> eventOptional = eventRepository.findById(eventId);
    	Event event = eventOptional.orElse(null);
    	Set<Student> students = event.getAttendedStudents();
    	Set<StudentDTO> studentDTOs = new HashSet<>();
    	for(Student student:students) {
    		studentDTOs.add(new StudentDTO(student.getStudentId(),student.getStudentName()));
    	}
    	return studentDTOs;
    }

    public Set<EventDTO> getRegisteredEventsByStudentId(Long studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        Student student = studentOptional.orElse(null);
        Set<Event> events = student.getRegisteredEvents();
        Set<EventDTO> eventDTOS = new HashSet<>();
        for (Event event : events) {
            eventDTOS.add(new EventDTO(event.getEventId(), event.getEventName()));
        }
        return eventDTOS;
    }

    public Set<EventDTO> getAttendedEventsByStudentId(Long studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        Student student = studentOptional.orElse(null);
        Set<Event> events = student.getAttendedEvents();
        Set<EventDTO> eventDTOS = new HashSet<>();
        for (Event event : events) {
            eventDTOS.add(new EventDTO(event.getEventId(), event.getEventName()));
        }
        return eventDTOS;
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

    public void markAttendanceByStudentId(Long studentId, Long eventId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        Student student = studentOptional.orElse(null);
        Event event = getEventById(eventId);
        if (student != null && event != null) {
            student.getAttendedEvents().add(event);
            studentRepository.save(student);
        } else {
            // Handle student or event not found
        }
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

    public List<BranchDTO> getAllBranches() {
    	List<Branch> branches = branchRepository.findAll();
    	List<BranchDTO> branchDTOs = new ArrayList<>();
    	for(Branch branch:branches) {
    		branchDTOs.add(new BranchDTO(branch.getBranchId(),branch.getYear(),branch.getBranchName()));
    	}
        return branchDTOs;
    }

    public BranchDTO getBranchByBranchId(Long branchId) {
        Optional<Branch> branchOptional = branchRepository.findById(branchId);
        Branch branch = branchOptional.orElse(null);
        return new BranchDTO(branch.getBranchId(), branch.getYear(), branch.getBranchName());
    }

    public Set<EventDTO> getEventsOfBranchByBranchId(Long branchId) {
    	Optional<Branch> branchOptional = branchRepository.findById(branchId);
    	Branch branch = branchOptional.orElse(null);
        Set<Event> events = branch.getEligibleEvents();
        Set<EventDTO> eventDTOS = new HashSet<>();
        for (Event event : events) {
            eventDTOS.add(new EventDTO(event.getEventId(), event.getEventName()));
        }
        return eventDTOS;
    }

    public List<StudentDTO> getStudentsOfBranchByBranchId(Long branchId) {
    	Optional<Branch> branchOptional = branchRepository.findById(branchId);
    	Branch branch = branchOptional.orElse(null);
        List<Student> students = branch.getStudents();
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student student : students) {
            studentDTOS.add(new StudentDTO(student.getStudentId(), student.getStudentName(), student.getEmail(), student.getMobile()));
        }
        return studentDTOS;
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

    public List<ClubDTO> getAllClubs() {
    	List<Club> clubs = clubRepository.findAll();
    	List<ClubDTO> clubDTOs = new ArrayList<>();
    	for(Club club:clubs) {
    		clubDTOs.add(new ClubDTO(club.getClubId(),club.getClubName()));
    	}
        return clubDTOs;
    }

    public ClubDTO getClubByClubId(Long clubId) {
        Optional<Club> clubOptional = clubRepository.findById(clubId);
        Club club = clubOptional.orElse(null);
        return new ClubDTO(club.getClubId(),club.getClubName());
    }

    public List<EventDTO> getAllEventsOfAClubByClubId(Long clubId) {
        Optional<Club> clubOptional = clubRepository.findById(clubId);
        Club club = clubOptional.orElse(null);
        List<Event> events = club.getEvents();
        List<EventDTO> eventDTOS = new ArrayList<>();
        for(Event event : events){
            eventDTOS.add(new EventDTO(event.getEventId(), event.getEventName()));
        }
        return eventDTOS;
    }

    public List<StudentDTO> getRegisteredStudentsForBranchIdEventId(Long branchId, Long eventId){
        return branchRepository.getRegisteredStudentsForBranchIdEventId(branchId, eventId);
    }

    public List<StudentDTO> getAttendedStudentsForBranchIdEventId(Long branchId, Long eventId){
        return branchRepository.getAttendedStudentsForBranchIdEventId(branchId, eventId);
    }
}

package com.projecte.repo;

import com.projecte.dtos.ClubDTO;
import com.projecte.dtos.EventDTO;
import com.projecte.dtos.StudentDTO;
import com.projecte.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projecte.entity.Branch;

import java.util.ArrayList;
import java.util.List;
import java.util.function.LongFunction;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

    @Query("SELECT NEW com.projecte.dtos.StudentDTO(e.studentId, e.studentName, e.email, e.mobile) "+
    "FROM Student e "+
    "LEFT JOIN e.branch b "+
    "LEFT JOIN e.registeredEvents ee "+
    "WHERE b.branchId = :branchId AND ee.eventId = :eventId")
    List<StudentDTO> getRegisteredStudentsForBranchIdEventId(@Param("branchId") Long branchId, @Param("eventId") Long eventId);

    @Query("SELECT NEW com.projecte.dtos.StudentDTO(e.studentId, e.studentName, e.email, e.mobile) "+
            "FROM Student e "+
            "LEFT JOIN e.branch b "+
            "LEFT JOIN e.attendedEvents ee "+
            "WHERE b.branchId = :branchId AND ee.eventId = :eventId")
    List<StudentDTO> getAttendedStudentsForBranchIdEventId(@Param("branchId") Long branchId, @Param("eventId") Long eventId);

}

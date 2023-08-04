package com.projecte.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projecte.entity.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
}

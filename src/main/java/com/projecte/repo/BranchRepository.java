package com.projecte.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projecte.entity.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {
}

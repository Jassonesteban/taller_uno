package com.cloud.lab1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloud.lab1.models.Backlog;

/**
 * The Interface BacklogRepository.
 */
@Repository
public interface BacklogRepository extends JpaRepository<Backlog, Long> {

}

package com.cloud.lab1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloud.lab1.models.Project;

/**
 * The Interface ProjectRepository.
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    /**
     * Find by project identifier or project name.
     *
     * @param projectIdentifier the project identifier
     * @param projectName       the project name
     * @return the project
     */
    Project findByProjectIdentifierOrProjectName(String projectIdentifier, String projectName);

    /**
     * Find by project identifier.
     *
     * @param projectIdentifier the project identifier
     * @return the project
     */
    Project findByProjectIdentifier(String projectIdentifier);

    /**
     * Find by project name.
     *
     * @param projectName the project name
     * @return the project
     */
    Project findByProjectName(String projectName);

}

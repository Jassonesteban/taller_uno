package com.cloud.lab1.services;

import java.util.List;

import com.cloud.lab1.models.Project;

/**
 * The Interface ProjectService.
 */
public interface ProjectService {

    /**
     * Save project.
     *
     * @param project the project
     * @return the project
     * @throws Exception the exception
     */
    Project saveProject(Project project) throws Exception;
    
    /**
     * Validate project.
     *
     * @param project the project
     * @throws Exception the exception
     */
    void validateProject(Project project) throws Exception;
    
    /**
     * Gets the project.
     *
     * @return the project
     */
    List<Project> getProject();
}

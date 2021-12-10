package com.cloud.lab1.services;

import java.util.List;

import javax.naming.directory.InvalidAttributeValueException;

import com.cloud.lab1.dtos.ProjectTaskDTO;
import com.cloud.lab1.models.ProjectTask;

/**
 * The Interface ProjectTaskService.
 */
public interface ProjectTaskService {

    /**
     * Save project task.
     *
     * @param projectTask the project task
     * @return the project task
     * @throws Exception the exception
     */
    ProjectTask saveProjectTask(ProjectTask projectTask) throws Exception;

    /**
     * Gets the project task per project.
     *
     * @param projectIdentifier the project identifier
     * @return the project task per project
     * @throws Exception the exception
     */
    List<ProjectTask> getProjectTaskPerProject(String projectIdentifier) throws Exception;

    /**
     * Gets the project task hours.
     *
     * @param projectIdentifier the project identifier
     * @return the project task hours
     * @throws Exception the exception
     */
    Double getProjectTaskHours(String projectIdentifier) throws Exception;

    /**
     * Gets the project task hours per status.
     *
     * @param projectIdentifier the project identifier
     * @param status            the status
     * @return the project task hours per status
     */
    Double getProjectTaskHoursPerStatus(String projectIdentifier, String status);

    /**
     * Delete project task.
     *
     * @param idTask             the project identifier
     * @param projectIdentifier2 the project identifier 2
     * @return the double
     */
    Integer deleteProjectTask(Long idTask, String projectIdentifier2);

    /**
     * Validate project task.
     *
     * @param projectTaskDTO the project task DTO
     * @throws InvalidAttributeValueException 
     */
    void validateProjectTask(ProjectTaskDTO projectTaskDTO) throws InvalidAttributeValueException;

}

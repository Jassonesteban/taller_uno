package com.cloud.lab1.services.impl;

import java.util.List;

import javax.naming.NameNotFoundException;
import javax.naming.directory.InvalidAttributeValueException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.cloud.lab1.dtos.ProjectTaskDTO;
import com.cloud.lab1.models.ProjectTask;
import com.cloud.lab1.repositories.ProjectTaskRepository;
import com.cloud.lab1.services.ProjectTaskService;

/**
 * The Class ProjectTaskServiceImpl.
 */
@Service
@Transactional
public class ProjectTaskServiceImpl implements ProjectTaskService {

    /** The project task repository. */
    private ProjectTaskRepository projectTaskRepository;

    /**
     * Instantiates a new project task service impl.
     *
     * @param projectTaskRepository the project task repository
     */
    @Autowired
    public ProjectTaskServiceImpl(ProjectTaskRepository projectTaskRepository) {
        this.projectTaskRepository = projectTaskRepository;
    }

    /**
     * Save project task.
     *
     * @param projectTask the project task
     * @return the project task
     * @throws Exception the exception
     */
    @Override
    public ProjectTask saveProjectTask(ProjectTask projectTask) throws Exception {
        return this.projectTaskRepository.save(projectTask);
    }

    /**
     * Gets the project task per project.
     *
     * @param projectIdentifier the project identifier
     * @return the project task per project
     * @throws Exception the exception
     */
    @Override
    public List<ProjectTask> getProjectTaskPerProject(String projectIdentifier) throws Exception {
        List<ProjectTask> tasks = this.projectTaskRepository
                .findByProjectIdentifier(projectIdentifier);
        if (CollectionUtils.isEmpty(tasks)) {
            throw new NameNotFoundException("Not found");
        }

        return tasks;
    }

    /**
     * Gets the project task hours.
     *
     * @param projectIdentifier the project identifier
     * @return the project task hours
     * @throws Exception the exception
     */
    @Override
    public Double getProjectTaskHours(String projectIdentifier) throws Exception {
        return this.projectTaskRepository.countHours(projectIdentifier);
    }

    /**
     * Gets the project task hours per status.
     *
     * @param projectIdentifier the project identifier
     * @param status            the status
     * @return the project task hours per status
     */
    @Override
    public Double getProjectTaskHoursPerStatus(String projectIdentifier, String status) {
        return this.projectTaskRepository.countHoursByStatus(projectIdentifier, status);
    }

    /**
     * Delete project task.
     *
     * @param idTask            the id task
     * @param projectIdentifier the project identifier
     * @return the integer
     */
    @Override
    public Integer deleteProjectTask(Long idTask, String projectIdentifier) {
        return this.projectTaskRepository.logicDeleteTask(idTask, projectIdentifier);
    }

    /**
     * Validate project task.
     *
     * @param projectTaskDTO the project task DTO
     * @throws InvalidAttributeValueException the invalid attribute value exception
     */
    @Override
    public void validateProjectTask(ProjectTaskDTO projectTaskDTO)
            throws InvalidAttributeValueException {
        if (projectTaskDTO.getId() != null) {
            ProjectTask pt = this.projectTaskRepository
                    .findById(Long.parseLong(projectTaskDTO.getId())).orElse(null);
            if (!pt.getProjectIdentifier().equals(projectTaskDTO.getProjectIdentifier()))
                throw new InvalidAttributeValueException("projectIdentifier is not updatable");
        } else {
            if (this.projectTaskRepository.findByNameAndProjectIdentifier(projectTaskDTO.getName(),
                    projectTaskDTO.getProjectIdentifier()) != null) {
                throw new InvalidAttributeValueException(
                        "name and projectIdentifier already exist");
            }
        }

    }

}

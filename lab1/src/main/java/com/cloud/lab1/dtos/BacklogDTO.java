package com.cloud.lab1.dtos;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;

/**
 * The Class BacklogDTO.
 */
public class BacklogDTO implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8773808797633158260L;

    /** The id. */
    private String id;

    /** The project identifier. */
    @NotBlank(message = "Project Identifier its mandatory")
    private String projectIdentifier;

    /** The project. */
    private ProjectDTO project;

    /** The project task. */
    private List<ProjectTaskDTO> projectTask;

    /**
     * Instantiates a new backlog DTO.
     */
    public BacklogDTO() {
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the project identifier.
     *
     * @return the project identifier
     */
    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    /**
     * Sets the project identifier.
     *
     * @param projectIdentifier the new project identifier
     */
    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    /**
     * Gets the project.
     *
     * @return the project
     */
    public ProjectDTO getProject() {
        return project;
    }

    /**
     * Sets the project.
     *
     * @param project the new project
     */
    public void setProject(ProjectDTO project) {
        this.project = project;
    }

    /**
     * Gets the project task.
     *
     * @return the project task
     */
    public List<ProjectTaskDTO> getProjectTask() {
        return projectTask;
    }

    /**
     * Sets the project task.
     *
     * @param projectTask the new project task
     */
    public void setProjectTask(List<ProjectTaskDTO> projectTask) {
        this.projectTask = projectTask;
    }

}

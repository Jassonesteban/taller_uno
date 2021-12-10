package com.cloud.lab1.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Class ProjectDTO.
 */
public class ProjectDTO implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -882640690782468853L;

    /** The id. */
    private String id;

    /** The project name. */
    @NotBlank
    private String projectName;

    /** The project identifier. */
    @NotBlank
    @Size(min = 5, max = 7)
    private String projectIdentifier;

    /** The description. */
    @NotBlank
    private String description;

    /** The start date. */
    private String startDate;

    /** The endt date. */
    private String endDate;

    /** The backlog. */
    private BacklogDTO backlog;

    /**
     * Instantiates a new project DTO.
     */
    public ProjectDTO() {
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
     * Gets the project name.
     *
     * @return the project name
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Sets the project name.
     *
     * @param projectName the new project name
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
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
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the start date.
     *
     * @return the start date
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date.
     *
     * @param startDate the new start date
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the endt date.
     *
     * @return the endt date
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the endt date.
     *
     * @param endtDate the new endt date
     */
    public void setEndDate(String endtDate) {
        this.endDate = endtDate;
    }

    /**
     * Gets the backlog.
     *
     * @return the backlog
     */
    @JsonIgnore
    public BacklogDTO getBacklog() {
        return backlog;
    }

    /**
     * Sets the backlog.
     *
     * @param backlog the new backlog
     */
    public void setBacklog(BacklogDTO backlog) {
        this.backlog = backlog;
    }

}

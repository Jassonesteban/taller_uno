package com.cloud.lab1.dtos;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * The Class ProjectTaskDTO.
 */
public class ProjectTaskDTO implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 8923491283468217490L;

    /** The id. */
    private String id;

    /** The name. */
    @NotBlank(message = "Name its requeried")
    private String name;

    /** The summary. */
    @NotBlank(message = "Summary its requeried")
    private String summary;

    /** The acceptance criteria. */
    private String acceptanceCriteria;

    /** The status. */
    @Pattern(regexp = "^(Not Stared|in progress|completed|deleted*)$", message = "Status its worse")
    private String status;

    /** The priority. */
    @Min(1)
    @Max(5)
    private Integer priority;

    /** The hours. */
    @Min(1)
    @Max(8)
    private Double hours;

    /** The start date. */
    private String startDate;

    /** The endt date. */
    private String endDate;

    /** The proyect identifier. */
    private String projectIdentifier;

    /** The backlog. */
    @JsonProperty(access = Access.WRITE_ONLY)
    private BacklogDTO backlog;

    /**
     * Instantiates a new project task DTO.
     */
    public ProjectTaskDTO() {
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
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the summary.
     *
     * @return the summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Sets the summary.
     *
     * @param summary the new summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Gets the acceptance criteria.
     *
     * @return the acceptance criteria
     */
    public String getAcceptanceCriteria() {
        return acceptanceCriteria;
    }

    /**
     * Sets the acceptance criteria.
     *
     * @param acceptanceCriteria the new acceptance criteria
     */
    public void setAcceptanceCriteria(String acceptanceCriteria) {
        this.acceptanceCriteria = acceptanceCriteria;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the priority.
     *
     * @return the priority
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * Sets the priority.
     *
     * @param priority the new priority
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * Gets the hours.
     *
     * @return the hours
     */
    public Double getHours() {
        return hours;
    }

    /**
     * Sets the hours.
     *
     * @param hours the new hours
     */
    public void setHours(Double hours) {
        this.hours = hours;
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
     * @param endDate the new end date
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets the proyect identifier.
     *
     * @return the proyect identifier
     */
    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    /**
     * Sets the proyect identifier.
     *
     * @param proyectIdentifier the new proyect identifier
     */
    public void setProjectIdentifier(String proyectIdentifier) {
        this.projectIdentifier = proyectIdentifier;
    }

    /**
     * Gets the backlog.
     *
     * @return the backlog
     */
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

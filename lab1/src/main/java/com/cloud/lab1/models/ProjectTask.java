package com.cloud.lab1.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class ProjectTask.
 */
@Entity
@Table(name = "PROJECT_TASK")
public class ProjectTask {

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The name. */
    @Column(name = "name", nullable = false)
    private String name;

    /** The summary. */
    @Column(name = "summary", nullable = false)
    private String summary;

    /** The acceptance criteria. */
    @Column(name = "acceptance_criteria")
    private String acceptanceCriteria;

    /** The status. */
    @Column(name = "status")
    private String status;

    /** The priority. */
    @Column(name = "priority")
    private Integer priority;

    /** The hours. */
    @Column(name = "hours")
    private Double hours;

    /** The start date. */
    @Column(name = "start_date")
    private Date startDate;

    /** The endt date. */
    @Column(name = "end_date")
    private Date endDate;

    /** The proyect identifier. */
    @Column(name = "project_identifier")
    private String projectIdentifier;

    /** The backlog. */
    @ManyToOne
    @JoinColumn(name = "backlog_id")
    private Backlog backlog;

    /**
     * Instantiates a new project task.
     */
    public ProjectTask() {
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Long id) {
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
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date.
     *
     * @param startDate the new start date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the endt date.
     *
     * @return the endt date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets the endt date.
     *
     * @param endtDate the new endt date
     */
    public void setEndDate(Date endtDate) {
        this.endDate = endtDate;
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
    public Backlog getBacklog() {
        return backlog;
    }

    /**
     * Sets the backlog.
     *
     * @param backlog the new backlog
     */
    public void setBacklog(Backlog backlog) {
        this.backlog = backlog;
    }

}

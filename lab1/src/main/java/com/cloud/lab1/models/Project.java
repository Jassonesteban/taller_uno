package com.cloud.lab1.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The Class Project.
 */
@Entity
@Table(name = "PROJECT")
public class Project {

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /** The project name. */
    @Column(name = "project_name", nullable = false, unique = true)
    private String projectName;
    
    /** The project identifier. */
    @Column(name = "project_identifier", nullable = false, unique = true, updatable = false)
    private String projectIdentifier;
    
    /** The description. */
    @Column(name = "description", nullable = false)
    private String description;
    
    /** The start date. */
    @Column(name = "start_date")
    private Date startDate;
    
    /** The endt date. */
    @Column(name = "end_date")
    private Date endDate;
    
    /** The backlog. */
    @OneToOne(mappedBy = "project")
    private Backlog backlog;

    /**
     * Instantiates a new project.
     */
    public Project() {

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

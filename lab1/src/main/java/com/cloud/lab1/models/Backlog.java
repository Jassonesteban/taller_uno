package com.cloud.lab1.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The Class Backlog.
 */
@Entity
@Table(name = "BACKLOG")
public class Backlog {

    /** The id. */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The project identifier. */

    @Column(name = "project_identifier", nullable = false)
    private String projectIdentifier;

    /** The project. */
    @OneToOne
    @JoinTable(name = "backlog_project", joinColumns = {
            @JoinColumn(name = "backlog_id", referencedColumnName = "id") }, inverseJoinColumns = {
                    @JoinColumn(name = "project_id", referencedColumnName = "id") })
    private Project project;

    /** The project task. */
    @OneToMany(mappedBy = "backlog", cascade = CascadeType.DETACH)
    private List<ProjectTask> projectTask;

    /**
     * Instantiates a new backlog.
     */
    public Backlog() {
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
    public Project getProject() {
        return project;
    }

    /**
     * Sets the project.
     *
     * @param project the new project
     */
    public void setProject(Project project) {
        this.project = project;
    }

    /**
     * Gets the project task.
     *
     * @return the project task
     */
    public List<ProjectTask> getProjectTask() {
        return projectTask;
    }

    /**
     * Sets the project task.
     *
     * @param projectTask the new project task
     */
    public void setProjectTask(List<ProjectTask> projectTask) {
        this.projectTask = projectTask;
    }

}

package com.cloud.lab1.services.impl;

import java.util.List;

import javax.naming.directory.InvalidAttributeValueException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.lab1.models.Project;
import com.cloud.lab1.repositories.ProjectRepository;
import com.cloud.lab1.services.ProjectService;

/**
 * The Class ProjectServiceImpl.
 */
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    /** The project repository. */
    private ProjectRepository projectRepository;

    /**
     * Instantiates a new project service impl.
     *
     * @param projectRepository the project repository
     */
    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    /**
     * Save project.
     *
     * @param project the project
     * @return the project
     * @throws Exception the exception
     */
    @Override
    public Project saveProject(Project project) throws Exception {
        this.validateProject(project);
        return this.projectRepository.save(project);
    }

    /**
     * Validate project.
     *
     * @param project the project
     * @throws Exception the exception
     */
    @Override
    public void validateProject(Project project) throws Exception {
        if (project.getId() == null) {
            if (this.projectRepository
                    .findByProjectIdentifier(project.getProjectIdentifier()) != null) {
                throw new InvalidAttributeValueException("projectIdentifier already exists");
            } else if (this.projectRepository.findByProjectName(project.getProjectName()) != null) {
                throw new InvalidAttributeValueException("projectName already exists");
            } 
        }else {
            Project p = this.projectRepository.findById(project.getId()).orElse(null);
            if(p != null) {
                if(!p.getProjectIdentifier().equals(project.getProjectIdentifier())) {
                    throw new InvalidAttributeValueException("projectIdentifier its not updatable");
                }
            }
        }
    }

    /**
     * Gets the project.
     *
     * @return the project
     */
    @Override
    public List<Project> getProject() {
        return this.projectRepository.findAll();
    }

}

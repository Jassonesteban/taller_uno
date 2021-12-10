package com.cloud.lab1.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.lab1.dtos.ProjectDTO;
import com.cloud.lab1.models.Project;
import com.cloud.lab1.services.ProjectService;
import com.commons.utils.CustomMapper;

/**
 * The Class ProjectController.
 */
@RestController
@RequestMapping("/project")
public class ProjectController extends BaseController {

    /** The project service. */
    private ProjectService projectService;

    /**
     * Instantiates a new project controller.
     *
     * @param projectService the project service
     */
    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * Save project.
     *
     * @param projectDTO the project DTO
     * @return the project DTO
     * @throws Exception the exception
     */
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProjectDTO saveProject(@Valid @RequestBody ProjectDTO projectDTO) throws Exception {
        Project response = this.projectService
                .saveProject((Project) CustomMapper.mapper(projectDTO, Project.class));

        ProjectDTO responseDTO = (ProjectDTO) CustomMapper.mapper(response, ProjectDTO.class);

        return responseDTO;
    }

    /**
     * Gets the project.
     *
     * @return the project
     * @throws Exception the exception
     */
    @GetMapping
    public List<ProjectDTO> getProject() throws Exception {
        List<ProjectDTO> response = new ArrayList<>();
        List<Project> projects = this.projectService.getProject();

        if (projects != null) {
            response = projects.stream()
                    .map(p -> (ProjectDTO) CustomMapper.mapper(p, ProjectDTO.class))
                    .collect(Collectors.toList());
        }

        return response;
    }
}

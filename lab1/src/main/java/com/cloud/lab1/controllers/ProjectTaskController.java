package com.cloud.lab1.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.lab1.dtos.ProjectTaskDTO;
import com.cloud.lab1.dtos.StatusDTO;
import com.cloud.lab1.models.ProjectTask;
import com.cloud.lab1.services.ProjectTaskService;

/**
 * The Class ProjectTaskController.
 */
@RestController
@RequestMapping("/task")
public class ProjectTaskController extends BaseController {

    /** The project task service. */
    private ProjectTaskService projectTaskService;

    /**
     * Instantiates a new project task controller.
     *
     * @param projectTaskService the project task service
     */
    @Autowired
    public ProjectTaskController(ProjectTaskService projectTaskService) {
        this.projectTaskService = projectTaskService;
    }

    /**
     * Save project task.
     *
     * @param projectTaskDTO the project task DTO
     * @return the project task DTO
     * @throws Exception the exception
     */
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProjectTaskDTO saveProjectTask(@Valid @RequestBody ProjectTaskDTO projectTaskDTO)
            throws Exception {

        this.projectTaskService.validateProjectTask(projectTaskDTO);

        ProjectTask projectTask = (ProjectTask) new ModelMapper().map(projectTaskDTO,
                ProjectTask.class);

        ProjectTaskDTO projectTaskResponseDTO = (ProjectTaskDTO) new ModelMapper().map(this.projectTaskService.saveProjectTask(projectTask), ProjectTaskDTO.class);

        return projectTaskResponseDTO;
    }

    /**
     * Gets the project task per project.
     *
     * @param projectIdentifier the project identifier
     * @return the project task per project
     * @throws Exception the exception
     */
    @GetMapping("/project/{projectIdentifier}")
    public List<ProjectTaskDTO> getProjectTaskPerProject(@PathVariable String projectIdentifier)
            throws Exception {

        List<ProjectTask> tasks = this.projectTaskService
                .getProjectTaskPerProject(projectIdentifier);

        List<ProjectTaskDTO> projectTasksResponseDTO = tasks.stream()
                .map(pt -> (ProjectTaskDTO) new ModelMapper().map(pt, ProjectTaskDTO.class))
                .collect(Collectors.toList());

        return projectTasksResponseDTO;
    }

    /**
     * Gets the project task hours per project.
     *
     * @param projectIdentifier the project identifier
     * @return the project task hours per project
     * @throws Exception the exception
     */
    @GetMapping("hours/project/{projectIdentifier}")
    public StatusDTO getProjectTaskHoursPerProject(@PathVariable String projectIdentifier)
            throws Exception {
        Double hours = this.projectTaskService.getProjectTaskHours(projectIdentifier);

        return new StatusDTO(hours, "HOURS");
    }

    /**
     * Gets the project task hours per project.
     *
     * @param projectIdentifier the project identifier
     * @param status            the status
     * @return the project task hours per project
     * @throws Exception the exception
     */
    @GetMapping("hours/project/{projectIdentifier}/{status}")
    public StatusDTO getProjectTaskHoursPerProject(@PathVariable String projectIdentifier,
            @PathVariable String status) throws Exception {
        Double hours = this.projectTaskService.getProjectTaskHoursPerStatus(projectIdentifier,
                status);

        return new StatusDTO(hours, "HOURS");
    }

    /**
     * Delete project task.
     *
     * @param idTask            the id task
     * @param projectIdentifier the project identifier
     * @return the status DTO
     * @throws Exception the exception
     */
    @DeleteMapping("{idTask}/{projectIdentifier}")
    public StatusDTO deleteProjectTask(@PathVariable Long idTask,
            @PathVariable String projectIdentifier) throws Exception {

        Integer response = this.projectTaskService.deleteProjectTask(idTask, projectIdentifier);

        return new StatusDTO(response > 0 ? "Task Deleted" : "Task could not deleted", "TASK");
    }

}

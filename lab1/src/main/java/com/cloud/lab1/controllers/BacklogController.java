package com.cloud.lab1.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.lab1.dtos.BacklogDTO;
import com.cloud.lab1.models.Backlog;
import com.cloud.lab1.services.BacklogService;

/**
 * The Class BacklogController.
 */
@RestController
@RequestMapping("/backlog")
public class BacklogController extends BaseController {

    /** The backlog service. */
    private BacklogService backlogService;

    /**
     * Instantiates a new backlog controller.
     *
     * @param backlogService the backlog service
     */
    @Autowired
    public BacklogController(BacklogService backlogService) {
        this.backlogService = backlogService;
    }

    /**
     * Save backlog.
     *
     * @param backlog the backlog
     * @return the backlog DTO
     */
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public BacklogDTO saveBacklog(@Valid @RequestBody BacklogDTO backlog) {

        Backlog response = this.backlogService.saveBacklog((Backlog) new ModelMapper().map(backlog, Backlog.class));
        BacklogDTO responseDTO = (BacklogDTO) new ModelMapper().map(response, BacklogDTO.class);
        return responseDTO;
    }
    
    @GetMapping
    public String hello() {
        return "Hello World";
    }
}

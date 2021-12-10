package com.cloud.lab1.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.cloud.lab1.dtos.BacklogDTO;
import com.cloud.lab1.models.Backlog;
import com.cloud.lab1.services.BacklogService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class BacklogControllerTest.
 */
@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class BacklogControllerTest {

    /** The mock mvc. */
    @Autowired
    protected MockMvc mockMvc;

    /** The backlog service. */
    @MockBean
    private BacklogService backlogService;

    /**
     * Test save backlog.
     *
     * @throws Exception the exception
     */
    @Test
    public void testSaveBacklog() throws Exception {
        Mockito.when(backlogService.saveBacklog(Mockito.any(Backlog.class)))
                .thenReturn(new Backlog());

        BacklogDTO bt = new BacklogDTO();
        bt.setProjectIdentifier("12345");
        mockMvc.perform(post("/backlog").contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(bt)))
                .andExpect(status().isCreated());
    }

}

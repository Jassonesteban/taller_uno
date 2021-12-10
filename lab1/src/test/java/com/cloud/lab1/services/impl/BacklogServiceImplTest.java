package com.cloud.lab1.services.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cloud.lab1.models.Backlog;
import com.cloud.lab1.repositories.BacklogRepository;
import com.cloud.lab1.services.BacklogService;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(addFilters = false)
public class BacklogServiceImplTest {

    private BacklogService backlogService;

    @MockBean
    private BacklogRepository backlogRepository;

    @Before
    public void init() {
        backlogService = new BacklogServiceImpl(backlogRepository);
    }

    @Test
    public void testSaveBacklog() {
        Mockito.when(backlogRepository.save(Mockito.any(Backlog.class))).thenReturn(new Backlog());

        Assert.assertNotNull(this.backlogService.saveBacklog(new Backlog()));
    }

}

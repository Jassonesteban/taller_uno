package com.cloud.lab1.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.lab1.models.Backlog;
import com.cloud.lab1.repositories.BacklogRepository;
import com.cloud.lab1.services.BacklogService;

/**
 * The Class BacklogServiceImpl.
 */
@Service
@Transactional
public class BacklogServiceImpl implements BacklogService {

    /** The backlog repository. */
    private BacklogRepository backlogRepository;

    /**
     * Instantiates a new backlog service impl.
     *
     * @param backlogRepository the backlog repository
     */
    @Autowired
    public BacklogServiceImpl(BacklogRepository backlogRepository) {
        this.backlogRepository = backlogRepository;
    }

    /**
     * Save backlog.
     *
     * @param backlog the backlog
     * @return the backlog
     */
    @Override
    public Backlog saveBacklog(Backlog backlog) {
        return this.backlogRepository.save(backlog);
    }

}

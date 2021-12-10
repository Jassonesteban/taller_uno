package com.cloud.lab1.services;

import com.cloud.lab1.models.Backlog;

/**
 * The Interface BacklogService.
 */
public interface BacklogService {

    /**
     * Save backlog.
     *
     * @param backlog the backlog
     * @return the backlog
     */
    Backlog saveBacklog(Backlog backlog);
}

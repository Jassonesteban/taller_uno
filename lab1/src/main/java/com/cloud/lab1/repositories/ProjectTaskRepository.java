package com.cloud.lab1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cloud.lab1.models.ProjectTask;

/**
 * The Interface ProjectTaskRepository.
 */
@Repository
public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Long> {

    /**
     * Find by project identifier.
     *
     * @param projectIdentifier the project identifier
     * @return the project task
     */
   List<ProjectTask> findByProjectIdentifier(String projectIdentifier);

    @Query("select sum(p.hours) from ProjectTask p where p.projectIdentifier=:projectIdentifier and p.status != 'deleted'")
    Double countHours(String projectIdentifier);

    @Query("select sum(p.hours) from ProjectTask p where p.projectIdentifier=:projectIdentifier and p.status =:status")
    Double countHoursByStatus(String projectIdentifier, String status);

    @Modifying
    @Query("update ProjectTask p set p.status='deleted' where p.projectIdentifier=:projectIdentifier and p.id=:idTask")
    Integer logicDeleteTask(Long idTask, String projectIdentifier);

    ProjectTask findByNameAndProjectIdentifier(String name, String projectIdentifier);

}

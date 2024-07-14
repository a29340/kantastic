package com.a29340.kantastic.repository;

import com.a29340.kantastic.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findByStageId(Long stageId);
}

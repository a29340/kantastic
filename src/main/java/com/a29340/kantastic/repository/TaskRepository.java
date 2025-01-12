package com.a29340.kantastic.repository;

import com.a29340.kantastic.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStageId(Long stageId);

    List<Task> findByBoardId(Long boardId);
}

package com.a29340.kantastic.repository;

import com.a29340.kantastic.model.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StageRepository extends JpaRepository<Stage, Long> {
    //@Query("select Stage from Stage where boardId = :boardId")
    List<Stage> findByBoardId(Long boardId);
}

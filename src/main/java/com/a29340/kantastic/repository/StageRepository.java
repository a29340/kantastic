package com.a29340.kantastic.repository;

import com.a29340.kantastic.model.Stage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StageRepository extends CrudRepository<Stage, Long> {
    //@Query("select Stage from Stage where boardId = :boardId")
    List<Stage> findByBoardId(Long boardId);
}

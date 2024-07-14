package com.a29340.kantastic.repository;

import com.a29340.kantastic.model.Stage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageRepository extends CrudRepository<Stage, Long> {
}

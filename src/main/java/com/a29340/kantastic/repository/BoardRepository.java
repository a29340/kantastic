package com.a29340.kantastic.repository;

import com.a29340.kantastic.model.Board;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends CrudRepository<Board, Long> {
}

package com.a29340.kantastic.dto.mapper;

import com.a29340.kantastic.dto.BoardDTO;
import com.a29340.kantastic.model.Board;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BoardMapper {

    BoardDTO boardToBoardDTO(Board board);
    Board boardDTOToBoard(BoardDTO boardDTO);

}

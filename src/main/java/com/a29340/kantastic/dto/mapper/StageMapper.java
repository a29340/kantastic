package com.a29340.kantastic.dto.mapper;

import com.a29340.kantastic.dto.StageDTO;
import com.a29340.kantastic.model.Stage;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StageMapper {

    StageDTO stageToStageDTO(Stage Stage);
    Stage stageDTOToStage(StageDTO StageDTO);

}

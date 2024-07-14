package com.a29340.kantastic.dto.mapper;

import com.a29340.kantastic.dto.TaskDTO;
import com.a29340.kantastic.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskMapper {

    TaskDTO taskToTaskDTO(Task Task);
    Task taskDTOToTask(TaskDTO TaskDTO);

}

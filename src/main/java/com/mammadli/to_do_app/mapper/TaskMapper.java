package com.mammadli.to_do_app.mapper;

import com.mammadli.to_do_app.model.dto.TaskRequest;
import com.mammadli.to_do_app.model.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TaskMapper {

   TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

   Task mapToTask(TaskRequest request);
}

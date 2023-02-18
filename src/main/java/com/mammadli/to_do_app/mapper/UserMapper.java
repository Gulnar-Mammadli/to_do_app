package com.mammadli.to_do_app.mapper;

import com.mammadli.to_do_app.model.dto.RegistrationRequest;
import com.mammadli.to_do_app.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapToUser(RegistrationRequest registrationRequest);

}

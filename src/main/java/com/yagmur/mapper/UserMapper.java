package com.yagmur.mapper;

import com.yagmur.dto.request.RegisterRequestDto;
import com.yagmur.dto.response.LoginResponseDto;
import com.yagmur.dto.response.RegisterResponseDto;
import com.yagmur.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    LoginResponseDto fromUserToLoginResponseDto(final User user);
    User fromRegisterRequestDtoToUser(final RegisterRequestDto dto);
    RegisterResponseDto fromUserToRegisterResponseDto(final User user);
}

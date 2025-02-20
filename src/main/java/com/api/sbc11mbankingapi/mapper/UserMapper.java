package com.api.sbc11mbankingapi.mapper;

import com.api.sbc11mbankingapi.domain.User;
import com.api.sbc11mbankingapi.feature.user.dto.RegisterRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User fromRegisterRequest(RegisterRequest registerRequest);
}

package com.api.sbc11mbankingapi.feature.user;

import com.api.sbc11mbankingapi.feature.user.dto.RegisterRequest;

public interface UserService {
    void register(RegisterRequest registerRequest);
}

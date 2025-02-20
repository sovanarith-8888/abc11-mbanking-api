package com.api.sbc11mbankingapi.feature.user;

import com.api.sbc11mbankingapi.feature.user.dto.RegisterRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void register(@Valid @RequestBody RegisterRequest registerRequest){
        userService.register(registerRequest);
    }
}

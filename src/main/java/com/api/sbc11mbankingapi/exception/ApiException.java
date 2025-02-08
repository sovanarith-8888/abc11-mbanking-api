package com.api.sbc11mbankingapi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class ApiException {
    @ExceptionHandler(ResponseStatusException.class)
    ResponseEntity<?> handleResponseStatusException(ResponseStatusException e) {
        ErrorDetailResponse<?> errorDetailResponse = ErrorDetailResponse.builder()
                .code(e.getStatusCode().toString())
                .description(e.getReason())
        .build();
        return new ResponseEntity<>(ErrorResponse.builder()
                        .error(errorDetailResponse).
                build(),e.getStatusCode());
    }
}

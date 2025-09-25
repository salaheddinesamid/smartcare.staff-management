package com.healthcare.staff_management.exception;

import com.healthcare.staff_management.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DoctorExceptionController {

    @ExceptionHandler(DoctorAlreadyExistsException.class)
    public ResponseEntity<ApiResponse<?>> doctorAlreadyExists(){
        ApiResponse<?> response = new ApiResponse<>(
                false,
                "The doctor already exists",
                null
        );
        return ResponseEntity.status(500)
                .body(response);
    }

    @ExceptionHandler(UserCannotBeCreatedException.class)
    public ResponseEntity<ApiResponse<?>> handleErrorWhenCreatingUser(UserCannotBeCreatedException exception){
        ApiResponse<?> ex = new ApiResponse<>(
                false,
                exception.getMessage(),
                null
        );
        return ResponseEntity.status(500)
                .body(ex);
    }
}

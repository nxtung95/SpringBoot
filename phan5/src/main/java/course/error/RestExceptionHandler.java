package course.error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import course.exception.ServiceRuntimeException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler({ MethodArgumentNotValidException.class })
    public ResponseEntity<List<ApiError>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ApiError> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String[] messageCode = error.getDefaultMessage().split(":");
            String errorCode = messageCode[0];
            String message = messageCode[1];
            errors.add(new ApiError(errorCode, message));
        });
        log.error("Status Error: {}, Message: {}", HttpStatus.BAD_REQUEST, errors.toString());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ InvalidFormatException.class })
    public ResponseEntity<ApiError> handleInvalidFormatException(InvalidFormatException ex) {
        ApiError apiError = new ApiError(ErrorCode.USER_E007, ErrorMessage.USER_E007);
        log.error("Status Error: {}, Message: {}", HttpStatus.INTERNAL_SERVER_ERROR, ErrorMessage.USER_E007);
        return buildResponseEntity(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ ServiceRuntimeException.class })
    public ResponseEntity<ApiError> handleExistEmailException(ServiceRuntimeException ex) {
        ApiError apiError = new ApiError(ex.getErrorCode(), ex.getMessage());
        log.error("Status Error: {}, Message: {}", ex.getHttpStatus(), ex.getMessage());
        return buildResponseEntity(apiError, ex.getHttpStatus());
    }

    @ExceptionHandler({ DataIntegrityViolationException.class })
    public ResponseEntity<ApiError> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        ApiError apiError = new ApiError(ErrorCode.DB_COURSE, ErrorMessage.DB_COURSE);
        log.error("Status Error: {}, Message: {}", HttpStatus.BAD_REQUEST, ErrorMessage.DB_COURSE);
        return buildResponseEntity(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<ApiError> handleOtherException(Exception ex) {
        ApiError apiError = new ApiError(ErrorCode.OTHER_ERROR, ErrorMessage.OTHER_ERROR);
        log.error("Status Error: {}, Message: {}", HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return buildResponseEntity(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ApiError> buildResponseEntity(ApiError apiError, HttpStatus httpStatus) {
        return new ResponseEntity<>(apiError, httpStatus);
    }
}

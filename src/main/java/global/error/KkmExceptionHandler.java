package global.error;

import global.error.exception.ErrorCode;
import global.error.exception.KkmException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class KkmExceptionHandler {

    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(KkmException.class)
    public ErrorResponse handleStupetitionException(KkmException e, HttpServletRequest request){
        log.error("errorCode: {}, url: {}, message: {}",
                e.getErrorCode(), request.getRequestURI(), e.getMessage());

        return ErrorResponse.builder()
                .status(e.getErrorCode().getStatus())
                .message(e.getMessage())
                .build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleBadRequest(MethodArgumentNotValidException e, HttpServletRequest request) {
        log.error("url: {}, message: {}", request.getRequestURI(), e.getMessage());

        return ErrorResponse.builder()
                .status(ErrorCode.BAD_REQUEST.getStatus())
                .message(
                        e.getBindingResult().getFieldErrors().get(0).getField() + "의 " +
                                e.getBindingResult().getFieldErrors().get(0).getDefaultMessage())
                .build();
    }

    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(Exception e, HttpServletRequest request) {
        log.error("url: {}, message: {}", request.getRequestURI(), e.getMessage());

        return ErrorResponse.builder()
                .status(ErrorCode.INTERNAL_SERVER_ERROR.getStatus())
                .message(ErrorCode.INTERNAL_SERVER_ERROR.getMessage())
                .build();
    }
}


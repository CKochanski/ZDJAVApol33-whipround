package pl.sda.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(WhiproundNotFoundException.class)
    public ResponseEntity<?> handleWhiproundNotFoundException(WhiproundNotFoundException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

}

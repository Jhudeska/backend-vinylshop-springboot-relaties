package nl.novi.backendvinylshopspringbootrelaties.helpers;

import jakarta.servlet.http.HttpServletRequest;
import nl.novi.backendvinylshopspringbootrelaties.exceptions.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(RecordNotFoundException.class)
  public ResponseEntity<String> handleException(RecordNotFoundException ex){
    return ResponseEntity.notFound().build();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
    List<String> violations = ex
            .getBindingResult()
            .getFieldErrors()
            .stream()
            .map(FieldError::getDefaultMessage)
            .toList();
    return ResponseEntity.badRequest().body(violations);
  }

  @ExceptionHandler(IllegalStateException.class)
  public ResponseEntity<Map<String, Object>> handleIllegalStateException(
          IllegalStateException ex,
          HttpServletRequest request) {

    Map<String, Object> response = new LinkedHashMap<>();

    response.put("timestamp", LocalDateTime.now());
    response.put("status", HttpStatus.CONFLICT.value());
    response.put("error", ex.getMessage());
    response.put("path", request.getRequestURI());


    return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(response);
  }
}
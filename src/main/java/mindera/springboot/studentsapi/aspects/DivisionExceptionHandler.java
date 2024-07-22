package mindera.springboot.studentsapi.aspects;

import mindera.springboot.studentsapi.exceptions.BadDenominatorDivision;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Component
@ControllerAdvice
public class DivisionExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(DivisionExceptionHandler.class);

    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class, NumberFormatException.class, ArithmeticException.class, BadDenominatorDivision.class})
    public ResponseEntity<String> handleDivisionByZero(Exception ex) {
        logger.error("Known Exception: " + ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<String> handleGenericException(Exception ex) {
        logger.error("Unknown Exception: " + ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
    }
}

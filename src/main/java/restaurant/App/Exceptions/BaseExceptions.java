package restaurant.App.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import restaurant.App.Utils.ResponseUtils;

@ControllerAdvice
public class BaseExceptions extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ResponseUtils> invalidParams(NotFoundException e){
        return ResponseEntity.ok(new ResponseUtils(false, e.getMessage()));
    }
}

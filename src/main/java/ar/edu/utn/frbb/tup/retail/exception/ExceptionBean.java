package ar.edu.utn.frbb.tup.retail.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExceptionBean extends RuntimeException{
    public ExceptionBean(String message) {
        super(message,null,true,false);
        this.setStackTrace(new StackTraceElement[0]);
    }
}

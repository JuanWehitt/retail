package ar.edu.utn.frbb.tup.retail.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.CONFLICT)
public class ExceptionCategoriaRelacionada extends RuntimeException{


    public ExceptionCategoriaRelacionada(String message) {
        super(message,null,true,false);
        this.setStackTrace(new StackTraceElement[0]);
    }
}

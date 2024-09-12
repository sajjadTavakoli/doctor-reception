package ir.stdev.reception.controller.advice;

import ir.stdev.reception.api.exception.DoctorReceptionException;
import ir.stdev.reception.api.exception.DoctorReceptionRunTimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DoctorReceptionException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionParam handleDoctorReceptionException(DoctorReceptionException e) {
        return generateExceptionParam(e.getMessage());
    }

    @ExceptionHandler(DoctorReceptionRunTimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionParam handleDoctorReceptionRunTimeException(DoctorReceptionRunTimeException e) {
        return generateExceptionParam(e.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionParam handleThrowable(Throwable e) {
        return generateExceptionParam(e.getMessage());
    }

    private ExceptionParam generateExceptionParam(String message) {
        ExceptionParam exceptionParam = new ExceptionParam();
        exceptionParam.setMessage(message);
        return exceptionParam;
    }
}

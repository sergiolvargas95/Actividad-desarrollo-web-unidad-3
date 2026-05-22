package com.hexagonal.crudl.infrastructure.web.advice;

import com.hexagonal.crudl.domain.exception.CedulaInvalidaException;
import com.hexagonal.crudl.domain.exception.EmailInvalidoException;
import com.hexagonal.crudl.domain.exception.UsuarioDuplicadoException;
import com.hexagonal.crudl.domain.exception.UsuarioInvalidoException;
import com.hexagonal.crudl.domain.exception.UsuarioNoEncontradoException;
import com.hexagonal.crudl.infrastructure.web.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsuarioNoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleUsuarioNoEncontrado(UsuarioNoEncontradoException ex) {
        return new ErrorResponse(ex.getMessage(), null);
    }

    @ExceptionHandler(UsuarioDuplicadoException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleUsuarioDuplicado(UsuarioDuplicadoException ex) {
        return new ErrorResponse(ex.getMessage(), "cedula");
    }

    @ExceptionHandler(CedulaInvalidaException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleCedulaInvalida(CedulaInvalidaException ex) {
        return new ErrorResponse(ex.getMessage(), "cedula");
    }

    @ExceptionHandler(EmailInvalidoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleEmailInvalido(EmailInvalidoException ex) {
        return new ErrorResponse(ex.getMessage(), "email");
    }

    @ExceptionHandler(UsuarioInvalidoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleUsuarioInvalido(UsuarioInvalidoException ex) {
        return new ErrorResponse(ex.getMessage(), null);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ErrorResponse> handleValidacion(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(this::toErrorResponse)
                .toList();
    }

    private ErrorResponse toErrorResponse(FieldError fieldError) {
        return new ErrorResponse(fieldError.getDefaultMessage(), fieldError.getField());
    }
}

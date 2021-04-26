package com.api.spring.handle.app.estudo.handle;

import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.time.LocalDateTime;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.api.spring.handle.app.estudo.enums.protocoloInternalErrorCodesEnum;
import com.api.spring.handle.app.estudo.exceptions.ClienteApiException;
import com.api.spring.handle.app.estudo.exceptions.CodigoDeErroException;
import com.api.spring.handle.app.estudo.model.Erro;
import com.api.spring.handle.app.estudo.model.CustomErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {

    @Resource
    private MessageSource messageSource;

    @ExceptionHandler(Exception.class)
    private ResponseEntity<Object> handleGeneral(Exception e, WebRequest request) {
        String message = "";
        if (e.getClass().isAssignableFrom(UndeclaredThrowableException.class)) {

            UndeclaredThrowableException exception = (UndeclaredThrowableException) e;
            Class<? extends Throwable> exceptionClass = exception.getUndeclaredThrowable().getClass();

            if (exceptionClass.isAssignableFrom(ClienteApiException.class)) {
                return handleCliente((ClienteApiException) exception.getUndeclaredThrowable(), request);
            }
            if (CodigoDeErroException.class.isAssignableFrom(exceptionClass)) {
                return handleCodigoDeErro((CodigoDeErroException) exception.getUndeclaredThrowable(), request);
            }

            message = messageSource.getMessage("error.server", new Object[]{exception.getUndeclaredThrowable().getMessage()}, null);
        } else {
            message = messageSource.getMessage("error.server", new Object[]{e.getMessage()}, null);
        }

        CustomErrorResponse error = new CustomErrorResponse();
        error.setError(message);
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setTimestamp(LocalDateTime.now());
        error.setCodigo(protocoloInternalErrorCodesEnum.E500000.getErrorcode());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        log.error("Erro interno: {}", e.getMessage(), e);

        return handleExceptionInternal(e, error, headers, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler({CodigoDeErroException.class})
    private ResponseEntity<Object> handleCodigoDeErro(Exception e, WebRequest request) {
    	CustomErrorResponse error = new CustomErrorResponse();
        CodigoDeErroException codigoDeErroException = (CodigoDeErroException) e;

        error.setError(e.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimestamp(LocalDateTime.now());
        error.setCodigo(codigoDeErroException.getErrorcode().getErrorcode());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        log.debug("Erro genérico: {}", e.getMessage(), e);

        return handleExceptionInternal(e, error, headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({ClienteApiException.class})
    private ResponseEntity<Object> handleCliente(Exception e, WebRequest request) {
        String message = messageSource.getMessage("error.cliente", new Object[]{e.getMessage()}, null);

        Erro Erro = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Erro = objectMapper.readValue(message, Erro.class);
        } catch (IOException io) {
            log.debug("Erro com a transformação de Objeto x JSON. ", io);
        }

        CustomErrorResponse error = new CustomErrorResponse();
        error.setError(Erro == null ? message : Erro.getError().getCode() + " - " + Erro.getError().getDescription());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimestamp(LocalDateTime.now());
        error.setCodigo("460." + String.format("%03d", Erro.getError().getCode()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        log.debug("Erro no client da cliente. {}", e.getMessage(), e);

        return handleExceptionInternal(e, error, headers, HttpStatus.BAD_REQUEST, request);
    }
}
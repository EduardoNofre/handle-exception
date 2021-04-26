package com.api.spring.handle.app.estudo.handle;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;

import com.api.spring.handle.app.estudo.enums.ApiErrorCodesEnum;
import com.api.spring.handle.app.estudo.exceptions.ClienteApiException;
import com.api.spring.handle.app.estudo.model.Erro;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        if (expectedNegativeResponse(response)) {
            String responseBody;
            Erro Erro = null;
            try {
                responseBody = IOUtils.toString(response.body().asInputStream());
                Erro = new ObjectMapper().readValue(responseBody, Erro.class);
            } catch (IOException e) {
                log.error("read conflict response body exception. {}", e.toString());
                responseBody = "{}";
            }
            return resolveContaDigitalApiException(responseBody, Erro);
        }
        return new ClienteApiException(response.status() + " - " + response.reason());
    }

    private boolean expectedNegativeResponse(Response response) {
        return response.status() == HttpStatus.BAD_REQUEST.value()
                || response.status() == HttpStatus.UNAUTHORIZED.value()
                || response.status() == HttpStatus.INTERNAL_SERVER_ERROR.value();
    }

    private Exception resolveContaDigitalApiException(String conflictionDetails, Erro Erro) {
        if (Erro != null) {
            Integer errorCode = Erro.getError().getCode();
            return Arrays.stream(ApiErrorCodesEnum.values())
                    .filter(error -> error.getErrorId().equals(errorCode))
                    .map(ApiErrorCodesEnum::getMappedInternalException)
                    .filter(Objects::nonNull)
                    .findFirst().orElse(new ClienteApiException(conflictionDetails));
        } else
            return new ClienteApiException(conflictionDetails);
    }
}

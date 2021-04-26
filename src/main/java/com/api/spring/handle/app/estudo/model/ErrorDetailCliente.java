package com.api.spring.handle.app.estudo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDetailCliente {

    private Integer code;
    private String description;
    private String field;
}

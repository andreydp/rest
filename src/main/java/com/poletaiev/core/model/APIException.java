package com.poletaiev.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class APIException extends RuntimeException{
    int errorCode;
    String description;

    @Override
    public String toString() {
        return "Error{" +
                "errorCode=" + errorCode +
                ", description='" + description + '\'' +
                '}';
    }
}
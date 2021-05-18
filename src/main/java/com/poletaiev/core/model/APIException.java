package com.poletaiev.core.model;

import com.google.gson.GsonBuilder;
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

    public String toJson() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
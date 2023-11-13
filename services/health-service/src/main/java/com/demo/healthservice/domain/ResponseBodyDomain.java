package com.demo.healthservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseBodyDomain<T> {
    private String message;
    private Boolean isSuccess;
    private T body;
}

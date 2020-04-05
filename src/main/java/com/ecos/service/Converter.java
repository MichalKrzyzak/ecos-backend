package com.ecos.service;

public interface Converter<T, U> {
    U convertToEntity(T dto);

    T convertToDto(U entity);
}

package com.ecos.common;

public interface BaseConverter<F, T> {

    T convertToDto(F entity);

    F convertToEntity(T dto);
}

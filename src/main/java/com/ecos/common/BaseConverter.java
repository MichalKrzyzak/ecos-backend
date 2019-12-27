package com.ecos.common;

import java.util.List;
import java.util.stream.Collectors;

public interface BaseConverter<F, T> {

    T convertToDto(F entity);

    F convertToEntity(T dto);

    default List<T> convertAllToDto(List<F> fElements) {
        List<T> convertedElement = fElements.stream()
                        .map(this::convertToDto)
                        .collect(Collectors.toList());

        return convertedElement;
    }

    default List<F> convertAllToEntity(List<T> fElements) {
        List<F> convertedElement = fElements.stream()
                        .map(this::convertToEntity)
                        .collect(Collectors.toList());

        return convertedElement;
    }
}

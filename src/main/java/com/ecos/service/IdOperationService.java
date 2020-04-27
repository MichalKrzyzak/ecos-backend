package com.ecos.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public interface IdOperationService<T, U> extends CommonService<T, U> {
    Optional<T> getById(Long id);

    ResponseEntity<String> deleteById(@PathVariable("id") Long id);

    ResponseEntity<T> updateById(@PathVariable("id") Long id, @RequestBody T dto);

    ResponseEntity<T> getResponseEntity(@RequestBody U entity, Optional<U> data);
}

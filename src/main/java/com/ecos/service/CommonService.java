package com.ecos.service;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CommonService<T, U> extends Converter<T, U> {
    List<T> getAll();

    T create(@RequestBody T fieldOfStudyDto);


}

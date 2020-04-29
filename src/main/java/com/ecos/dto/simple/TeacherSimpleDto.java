package com.ecos.dto.simple;

import com.ecos.dto.PersonalDataDto;

public class TeacherSimpleDto {
    private Long id;
    private PersonalDataDto personalData;

    public TeacherSimpleDto() {
    }

    public TeacherSimpleDto(Long id, PersonalDataDto personalData) {
        this.id = id;
        this.personalData = personalData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PersonalDataDto getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalDataDto personalData) {
        this.personalData = personalData;
    }
}

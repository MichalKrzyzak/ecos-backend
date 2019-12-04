package com.ecos.model.enums;

public enum TeacherRoleEnum {
    LECTURER {
        @Override
        public String toString() {
            return "Wykładowca";
        }
    },
    RECTOR {
        @Override
        public String toString() {
            return "Rektor";
        }
    },
    EMPLOYEE {
        @Override
        public String toString() {
            return "Pracownik";
        }
    }
}

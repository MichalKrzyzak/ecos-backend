package com.ecos.model.enums;

public enum FieldOfStudyEnum {
    BIOLOGY {
        @Override
        public String toString() {
            return "Biology";
        }
    },
    PSYCHOLOGY {
        @Override
        public String toString() {
            return "Psychology";
        }
    },
    COMPUTER_SCIENCE {
        @Override
        public String toString() {
            return "Computer Science";
        }
    }
}

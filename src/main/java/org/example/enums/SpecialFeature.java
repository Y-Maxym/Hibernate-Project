package org.example.enums;

import lombok.Getter;

@Getter
public enum SpecialFeature {
    TRAILERS("Trailers"),
    COMMENTARIES("Commentaries"),
    DELETED_SCENES("Deleted Scenes"),
    BEHIND_THE_SCENES("Behind the Scenes");

    private final String value;

    SpecialFeature(String value) {
        this.value = value;
    }

    public static SpecialFeature fromValue(String value) {
        for (SpecialFeature feature : values()) {
            if (feature.getValue().equals(value)) {
                return feature;
            }
        }
        throw new IllegalArgumentException("Unknown enum type " + value);
    }
}
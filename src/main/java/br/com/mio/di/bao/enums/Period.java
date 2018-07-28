package br.com.mio.di.bao.enums;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Period {
    MORNING("morning"), NIGHT("night");

    private String description;

    Period(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}

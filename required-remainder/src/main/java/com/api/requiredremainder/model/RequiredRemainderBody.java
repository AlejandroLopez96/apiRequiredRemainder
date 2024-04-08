package com.api.requiredremainder.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class RequiredRemainderBody {

    @Getter
    @NotNull(message = "The x field is required and it should be a number")
    private Integer x;

    @Getter
    @NotNull(message = "The y field is required and it should be a number")
    private Integer y;

    @Getter
    @NotNull(message = "The n field is required and it should be a number")
    private Integer n;

}

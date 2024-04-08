package com.api.requiredremainder.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequiredRemainderRequest {

    @NotNull(message = "The x field is required and it should be a number")
    private Integer x;

    @NotNull(message = "The y field is required and it should be a number")
    private Integer y;

    @NotNull(message = "The n field is required and it should be a number")
    private Integer n;

}

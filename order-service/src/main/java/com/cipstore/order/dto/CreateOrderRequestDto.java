package com.cipstore.order.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateOrderRequestDto {

    @NotNull
    @NotEmpty
    private String description;

    @NotNull
    private Long userId;

}

package com.cipstore.order.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    private String statusCode;
    private String statusMessage;
    private Object data;
    private Object pagination;
}

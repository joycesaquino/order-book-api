package com.meli.orderbook.dto;

import com.meli.orderbook.enums.operation.Type;
import com.meli.orderbook.enums.operation.Status;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class OperationDto {

    @DecimalMin(value = "0.1")
    private BigDecimal value;

    @DecimalMin(value = "1")
    private int quantity;

    private String user;

    @NotNull
    private Status status;

    @NotNull
    private Type operationType;

}

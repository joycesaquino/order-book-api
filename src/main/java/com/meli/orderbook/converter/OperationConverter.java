package com.meli.orderbook.converter;

import com.meli.orderbook.dto.OperationDto;
import com.meli.orderbook.enums.operation.Status;
import com.meli.orderbook.enums.operation.Type;
import com.meli.orderbook.model.Id;
import com.meli.orderbook.model.Operation;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class OperationConverter implements Function<OperationDto, Operation> {

    private final AuditConverter auditConverter;

    public OperationConverter(AuditConverter auditConverter) {
        this.auditConverter = auditConverter;
    }

    @Override
    public Operation apply(OperationDto dto) {

        var operation = new Operation();
        var audit = auditConverter.apply(operation);
        var status = dto.getOperationType().equals(Type.SALE) ? Status.IN_OFFER : Status.AVAILABLE;
        operation.setId(new Id(status, dto.getUserId(), audit.getRequestId()));
        operation.setValue(dto.getValue());
        operation.setQuantity(dto.getQuantity());
        operation.setStatus(status);
        operation.setType(dto.getOperationType());
        operation.setAudit(audit);

        operation.setAudit(audit);

        return operation;
    }
}

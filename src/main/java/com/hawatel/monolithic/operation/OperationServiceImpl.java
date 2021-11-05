package com.hawatel.monolithic.operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class OperationServiceImpl implements OperationService {


    @Autowired
    private OperationRepository operationRepository;

    @Override
    public Operation createNewOperation(OperationType operationType, Date date) {
        Operation operation = new Operation();
        operation.setOperationType(operationType);
        operation.setDate(date);
        operationRepository.save(operation);
        return operation;
    }
}

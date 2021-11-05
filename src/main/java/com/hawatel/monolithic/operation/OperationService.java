package com.hawatel.monolithic.operation;

import java.util.Date;

public interface OperationService {

    Operation createNewOperation(OperationType operationType, Date date);



}

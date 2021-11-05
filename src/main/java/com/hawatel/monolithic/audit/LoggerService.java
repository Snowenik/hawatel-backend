package com.hawatel.monolithic.audit;

import com.hawatel.monolithic.operation.OperationType;
import com.hawatel.monolithic.user.User;

import java.util.Date;

public interface LoggerService {

    void logOperation(User user, Date date, OperationType operationType);


}

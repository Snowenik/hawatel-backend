package com.hawatel.monolithic.audit;

import com.hawatel.monolithic.operation.OperationType;
import com.hawatel.monolithic.user.User;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

@Component
public class LoggerServiceImpl implements LoggerService {


    @Override
    public void logOperation(User user, Date date, OperationType operationType) {
        String action = null;
        if (operationType == OperationType.ADD) {
            action = "dodal produkt do tablicy";
        }
        else if (operationType == OperationType.MODIFY) {
            action = "zmodyfikowal produkt w tablicy";
        }
        else {
            action = "usunal produkt z tablicy";
        }
        String s = String.format("%s %s, data operacji: %s", user.getFirstName(), action, date.toString());
        FileWriter fw = null;
        try {
            fw = new FileWriter("log.txt", true);
            fw.write(s + String.format("%n"));
            fw.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

package com.hawatel.monolithic.operation;


import com.hawatel.monolithic.user.User;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "operations")
public class Operation {


    @Id
    @GeneratedValue
    private Long id;

    private Date date;

    @Enumerated(EnumType.STRING)
    private OperationType operationType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Operation() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, operationType, user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operation operation = (Operation) o;
        return Objects.equals(id, operation.id) &&
                Objects.equals(date, operation.date) &&
                Objects.equals(operationType, operation.operationType) &&
                Objects.equals(user, operation.user);
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", operationType='" + operationType + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}















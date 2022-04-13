package com.kodilla.calculator.event;

import com.kodilla.calculator.domain.CalculateMethod;
import org.springframework.context.ApplicationEvent;

public class CalculationEventRegister extends ApplicationEvent {

    private int integer1;
    private int integer2;
    private CalculateMethod method;

    public CalculationEventRegister(Object source, int integer1, int integer2, CalculateMethod method) {
        super(source);
        this.integer1 = integer1;
        this.integer2 = integer2;
        this.method = method;
    }

    public int getInteger1() {
        return integer1;
    }

    public int getInteger2() {
        return integer2;
    }

    public CalculateMethod getMethod() {
        return method;
    }

    public void setMethod(CalculateMethod method) {
        this.method = method;
    }
}



package com.kodilla.calculator.service;

import com.kodilla.calculator.event.CalculationEventRegister;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CalculatorManager implements ApplicationListener<CalculationEventRegister> {

    @Override
    public void onApplicationEvent(CalculationEventRegister event) {
        System.out.println("First element is: " + event.getInteger1());
        System.out.println("Second element is: " + event.getInteger2());
        System.out.println("The calculation task was: " + event.getMethod());
    }

}


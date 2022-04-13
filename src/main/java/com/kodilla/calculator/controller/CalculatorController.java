package com.kodilla.calculator.controller;

import com.kodilla.calculator.domain.CalculateMethod;
import com.kodilla.calculator.domain.CalculatorDto;
import com.kodilla.calculator.event.CalculationEventRegister;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/calculate")
public class CalculatorController implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @PostMapping(path = "add")
    public void addition(@RequestBody CalculatorDto calculatorDto) {
        int result = calculatorDto.getInteger1() + calculatorDto.getInteger2();
        publisher.publishEvent(
                new CalculationEventRegister(this,
                        calculatorDto.getInteger1(),
                        calculatorDto.getInteger2(),
                        CalculateMethod.ADD));

        System.out.println("The result of addition is: " + result);
    }

    @PostMapping(path = "sub")
    public void substract(@RequestBody CalculatorDto calculatorDto) {
        int result = calculatorDto.getInteger2() - calculatorDto.getInteger1();
        publisher.publishEvent(
                new CalculationEventRegister(this,
                        calculatorDto.getInteger1(),
                        calculatorDto.getInteger2(),
                        CalculateMethod.SUBSTRACT));

        System.out.println("The result of substract is: " + result);
    }

    @PostMapping(path = "mul")
    public void multiply(@RequestBody CalculatorDto calculatorDto) {
        int result = calculatorDto.getInteger1() * calculatorDto.getInteger2();
        publisher.publishEvent(
                new CalculationEventRegister(this,
                        calculatorDto.getInteger1(),
                        calculatorDto.getInteger2(),
                        CalculateMethod.MULTIPLY));

        System.out.println("The result of multiply is: " + result);
    }

    @PostMapping(path = "div")
    public void divide(@RequestBody CalculatorDto calculatorDto) {
        int result = calculatorDto.getInteger1()/calculatorDto.getInteger2();
        publisher.publishEvent(
                new CalculationEventRegister(this,
                        calculatorDto.getInteger1(),
                        calculatorDto.getInteger2(),
                        CalculateMethod.DIVIDE));

        System.out.println("The result of divide is: " + result);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}

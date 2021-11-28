package com.code.test;

public class Calculator {
    public int add(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }

    public double divide(int firstNum, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return firstNum / divisor;
    }
}

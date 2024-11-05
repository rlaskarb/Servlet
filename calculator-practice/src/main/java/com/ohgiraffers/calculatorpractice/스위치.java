package com.ohgiraffers.calculatorpractice;

import java.util.HashMap;
import java.util.Map;

public class 스위치 {

    public HashMap<String,String> totalNumber(String operator, int number1 , int number2) {

        Map<String, String> resultMap = new HashMap<>();
        String msg = "";

        int result = 0;

        switch (operator) {
            case "+":
                result = number1 + number2;
                msg = "계산 성공";
                break;

            case "-":
                result = number1 - number2;
                msg = "계산 성공";
                break;

            case "*":
                result = number1 * number2;
                msg = "계산 성공";
                break;

            case "/":
                if (number2 != 0) {
                    result = number1 / number2;
                    msg = "계산 성공";
                } else {
                    msg = "Division by zero error";
                }
                break;
            default:
                msg = "잘못된 입력으로 인한 리턴이다 이자식아";
                break;
        }

        resultMap.put("message", msg);
        resultMap.put("result", String.valueOf(result));

        return (HashMap<String, String>) resultMap;
    }
}


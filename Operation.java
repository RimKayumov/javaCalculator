package com.javamentor.calculator2;

public class Operation {
    private int result;
    public Operation(int first, int second, char c){
        if (c == '+'){
            result = first + second;
        }
        else if (c == '-'){
            result = first - second;
        }
        else if (c == '/'){
            result = first / second;
        }
        else if (c == '*'){
            result = first * second;
        }
        else throw new RuntimeException(new Error("Unknown operation"));
    }
    public int getResult(){
        return result;
    }
}

package com.javamentor.calculator2;
import com.javamentor.calculator2.ValueType;
import com.javamentor.calculator2.Operation;
import com.javamentor.calculator2.RomaValues;

import java.util.Vector;

public class Calculation {
    private RomaValues romaValues = new RomaValues();
    private Operation operation;
    private int firstVal = 0, secondVal = 0;
    private String resultString = "no results";
    private int resultInt;

    public Calculation(String x, String y, char c, ValueType val_type) {
        switch (val_type){
            case Roma -> {

                if (romaValues.get().contains(x) && romaValues.get().contains(y)) {
                    for (int i = 0; i < 10; ++i) {
                        if (romaValues.get().elementAt(i).equals(x)) {
                            firstVal += (i+1);
                        }
                        if (romaValues.get().elementAt(i).equals(y)) {
                            secondVal += (i+1);
                        }
                    }
                }
                else throw new RuntimeException(new Error("Invalid value"));
                operation = new Operation(firstVal, secondVal, c);
                resultInt = operation.getResult();
                resultString = romaValues.get().elementAt(resultInt-1);
                break;
            }
            case Arabic -> {
                firstVal = Integer.parseInt(x);
                secondVal = Integer.parseInt(y);
                if (firstVal > 10) throw new RuntimeException(new Error("First value is more than 10"));
                else if (firstVal < 0) throw new RuntimeException(new Error("First value is less than 0"));
                if (secondVal > 10) throw new RuntimeException(new Error("Second value is more than 10"));
                else if (secondVal < 0) throw new RuntimeException(new Error("Second value is less than 0"));
                operation = new Operation(firstVal, secondVal, c);
                resultInt = operation.getResult();
                break;
            }
        }
    }
    public int getIntResult(){
        return  resultInt;
    }
    public String getStringResult(){
        return resultString;
    }

}

package com.javamentor.calculator2;
import java.util.Vector;

import javax.management.RuntimeErrorException;

public class Parser {
    private Vector<String> vec = new Vector(3);

    public Parser(String expression) {
        String str = new String();
        for (int i = 0; i < expression.length(); ++i){
            if (expression.charAt(i) != ' ') {
                str += expression.charAt(i);
            }
            else {
                vec.add(str);
                str = "";
            }
            if (i == expression.length()-1) {
                vec.add(str);
            }
        }
        if (vec.size() > 3) throw new RuntimeErrorException(new Error("More than 3 values"));
        if (vec.size() < 3) throw new RuntimeErrorException(new Error("Incorrect expression"));

    }
    public Vector<String> getResult(){
        return vec;
    }
}

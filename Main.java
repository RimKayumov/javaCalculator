package com.javamentor.calculator2;
import java.util.Scanner;
import com.javamentor.calculator2.Parser;
import com.javamentor.calculator2.ValueType;
import  com.javamentor.calculator2.Calculation;

public class Main {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        String expression = console.nextLine();

        Parser parser = new Parser(expression); // парсим строку
        char c = parser.getResult().elementAt(1).charAt(0); // получаем оператор вычисления

        Calculation calculation;

        String first = parser.getResult().elementAt(0); // получаем первое значение
        String second = parser.getResult().elementAt(2); // получаем второе значение


        try{
            int a = Integer.parseInt(first); // узнаем, является ли переменная числом
            int b = Integer.parseInt(second); //

            // в случае, если переменные - целые числа:
            calculation = new Calculation(first, second, c, ValueType.Arabic);
            System.out.println(calculation.getIntResult());
        }
        catch (Exception e){
            // если переменные не являются целыми числами:
            calculation = new Calculation(first, second, c, ValueType.Roma);
            System.out.println(calculation.getStringResult());
        }
    }
}

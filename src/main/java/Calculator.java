package com.tdd.study;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Calculator {

    public String[] startGame(){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("입력하세요");
        String input = scanner.nextLine();    
        String[] values = input.split("");
        return values;
    }

    public int calculate(String[] input){
        int result=0;
        for(int i=0;i<input.length/2;i++){
             if(i==0){
                result = Integer.parseInt(input[i]);
             }
             String sign = input[i*2+1];
             int nextNum = Integer.parseInt(input[i*2+2]);
            
             switch(sign){
                case "+" : 
                    result = Sign.PLUS.apply(result, nextNum );
                    break;
                case "-" : 
                    result = Sign.MINUS.apply(result,nextNum);
                    break;
                case "*" : 
                    result = Sign.MULTIPLY.apply(result,nextNum);
                    break;
                case "/" : 
                    result = Sign.DIVIDE.apply(result, nextNum);
                    break;
            }
        }
        return result;
    }
    
    enum Sign{
        PLUS("+"){
            public int apply(int x,int y){
                return x+y;
            }
        },
        MINUS("-"){
            public int apply(int x,int y){
                return x-y;
            }
        },
        MULTIPLY("*"){
            public int apply(int x,int y){
                return x*y;
            }
        },
        DIVIDE("/"){
            public int apply(int x,int y){
                return x/y;
            }
        };

        private String operator;
        Sign(String operator){
            this.operator = operator;
        }
        abstract int apply(int x,int y);
    }
}

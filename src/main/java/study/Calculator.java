package study;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Calculator {

    public String[] startGame(){
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("입력하세요");
        String input = scanner.nextLine();    
        String[] values = input.split("");
        scanner.close();
        return values;
    }

    public int calculate(String[] input){
        int result=0;
        for(int i=0;i<input.length/2;i++){
             if(i==0){
                result = Integer.parseInt(input[i]);
             }
             String operator = input[i*2+1];
             int nextNum = Integer.parseInt(input[i*2+2]);
            
             switch(operator){
                case "+" : 
                    result = Operation.PLUS.apply(result, nextNum );
                    break;
                case "-" : 
                    result = Operation.MINUS.apply(result,nextNum);
                    break;
                case "*" : 
                    result = Operation.MULTIPLY.apply(result,nextNum);
                    break;
                case "/" : 
                    result = Operation.DIVIDE.apply(result, nextNum);
                    break;
            }
        }
        return result;
    }
    
    enum Operation{
        PLUS {
            public int apply(int x,int y){
                return x+y;
            }
        },
        MINUS {
            public int apply(int x,int y){
                return x-y;
            }
        },
        MULTIPLY {
            public int apply(int x,int y){
                return x*y;
            }
        },
        DIVIDE {
            public int apply(int x,int y){
                return x/y;
            }
        };

        
        abstract int apply(int x,int y);
    }
}

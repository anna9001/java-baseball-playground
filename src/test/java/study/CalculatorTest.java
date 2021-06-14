package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    String[] operator = new String[]{"+","*","/","-"}; 
    int [] numbers = new int[5];
    Calculator cal = new Calculator();

    @BeforeEach
    public void makeInputs(){        
        for(int i=0;i<5;i++){
            numbers[i] = (int) (Math.random() * 10) + 1; //1~10까지 난수 
        }

        System.out.println("num.length => "+numbers.length);
        //( Math.random() * ( 최대값 - 최소값 )  ) + 최소값 -- 최소갑 설정 방법
        int length = ((int) (Math.random() * (10-3))+3 )  ; // 1+2 최소 길이 3 
        // 홀수만 나오게 - 짝수일 경우 operation 다음 숫자 못오기 때문.
        if(length%2==0){ length += 1; };

        String [] inputs = new String[length];

        System.out.println("inputs.length => "+length);

        for(int i=0;i<length;i+=2){
            inputs[i] = Integer.toString(numbers[(int) (Math.random() * 5) ]);
            if(i<length-1){
                inputs[i+1] = operator[(int) (Math.random() * 4) ];
            }
            
        }

        for(int i=0;i<length;i++){
            System.out.print(inputs[i]);
        }
        calculate(inputs);
    }

    @Test
    public void calculate(String[] inputs){
        int result = cal.calculate(inputs);  
       
        System.out.println();
        System.out.println("result = "+result);              
    }
}

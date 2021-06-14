package study;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseBallTest {
    static String [] com =new String[3] ;
    static String [] user = new String[3];
    int strike=0;
    int ball=0;

    /**
     * flags 의 역할
     * 만약 com=[1,0,9], usr=[1,1,1] 일 때 뒤에 usr[1],usr[2] 가  com[0]에 ball 로 카운트 되는 것을 방지한다.
     * 이미 1이라는 숫자는 com[0]과 usr[0] 에서 카운트 되었기 때문에.    
     * */
    boolean [] flags = new boolean[3];
    int flagEmptyIndex= 0;

    @DisplayName("컴퓨터의 숫자")
    @BeforeAll
    public static void getrandomNum(){
        int num = (int) (Math.random() * 100)+100;
        System.out.println("computer : "+num);
        com = Integer.toString(num).split("");
    }

    @DisplayName("유저의 숫자")
    @BeforeAll
    public static void getUserGuess(){
        int num = (int) (Math.random() * 10)+100;
        System.out.println("user : "+num);
        user = Integer.toString(num).split("");
    }

    @DisplayName("strike 와 ball 카운트")
    @Test
    public void addCount(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(i==j){
                   checkStrike(Integer.parseInt(com[i]),Integer.parseInt(user[j]));
                   break;
                } 
                if(!flags[j]){
                    checkBall(Integer.parseInt(com[i]),Integer.parseInt(user[j]));
                }
                 
            }
        }
        showResult();
    }

    public void showResult(){
        System.out.println("strike : " + strike + ", ball : " + ball);
    }
   
    public void checkStrike(int x,int y){
        if(compare(x,y))  {
            strike+=1;
            flags[flagEmptyIndex] = true;
            flagEmptyIndex+=1;
        }
    }
    
    public void checkBall(int x,int y){
        if(compare(x,y))  ball+=1;
     }

    public boolean compare(int x,int y){
        if(x==y) return true;        
        return false;
    }
}

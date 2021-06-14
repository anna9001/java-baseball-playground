package study;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest 
{

   @Test
   public void testSplit(){
       String[] values = "1".split(",");
       assertThat(values).contains("1");

       values = "1,2".split(",");
       assertThat(values).containsExactly("1","2");
   }

   @Test
   public void testSubStr(){
        String test = "(1,2)";
        String result = test.substring(1,test.length()-1);
        assertThat(result).isEqualTo("1,2");
   }

   @Test
   public void testCharAt(){
        
      /*  
        assertThrows(StringConcatException.class, ()->{
            String test= "abc";
            test.charAt(4);
        });*/
        assertThrows(IndexOutOfBoundsException.class, ()->{
            String test= "abc";
            test.charAt(4);
        });
   }

   Set<Integer> set ;
   @BeforeEach
   public void testSet(){     
       set = new HashSet<>();
       set.add(1);
       set.add(2);
       set.add(3);

       assertThat(set.size()).isEqualTo(3);
       assertThat(set.contains(1)).isTrue();
   }
   
   @ParameterizedTest
   @ValueSource(ints = {1, 2, 3})
    void valueSourceTest(int number) {
        assertThat(set.contains(number)).isTrue();
    }

   @ParameterizedTest
   @CsvSource(
    value={
        "1:true",
        "2:true",
        "3:true",
        "4:false",
        "5:false",
    }, delimiter = ':'
  )
  void testWithCsvSource(int num, boolean expected){
        if(expected){
            assertThat(set.contains(num)).isTrue();
        }else{
            assertThat(set.contains(num)).isFalse();
        }
        
      //  assertThat(set.contains(Integer.parseInt(nums))).isTrue();
   }
  
}

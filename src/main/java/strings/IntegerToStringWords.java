package strings;

public class IntegerToStringWords {

  private static final String [] onesPlace = {
      "","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"
  };
  private static final String [] tensPlace = {
      "","ten","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninty"
  };
 private static final String [] specialNames = {
     "","thousand","million","billion","trillion"
  };
 public static String covertLessThanHundred (int number) {
   String word= "";
   String space = " ";
   if(number%100 < 20) {
     word=onesPlace[number];
   } else {
     word = onesPlace[number%10];
     number=number/10;
     if(number>0) {
       word=tensPlace[number%10]+space+word;
       number=number/10;
     }
     if(number>0) {
       word=onesPlace[number%10]+space+"hundred"+space+word;
       number=number/10;
     }
   }
   return word;
 }
/**
 *
 * @param integer = 123
 * @return
 */
 public static String convertToWords(int number) {
   String prefix="";
   String word= "";
   String space = " ";
   if(number==0) {
     return "zero";
   }
   if(number <0) {
     number=-number;
     prefix="negative";
   }
   int count=0;
   do{
     int n = number%1000;
     if(n!=0) {
       String s =covertLessThanHundred(n);
       word= s+space+specialNames[count]+space+word;
       number=number/1000;
     }
     count++;
   } while(number>0);
   word=prefix+space+word;
   return word;
 }

 public static void main(String [] args) {
   System.out.println(IntegerToStringWords.convertToWords(11123884));
 }

}

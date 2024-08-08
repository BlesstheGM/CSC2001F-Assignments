import java.util.Scanner;

public class Convertor {
   public static void main (String [] args) {
      Scanner inKey = new Scanner(System.in);
      System.out.println("Enter a time or 'quit':");
      String time = inKey.nextLine();
           
      while (!time.equals("quit")) {
         String hours = time.split(":")[0];
         String minutes = time.split(":")[1]; 
         
         String[] times = {"5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};
         String[] descriptions = {"five past", "ten past", "quarter past", "twenty past", "twenty five past", "half past", "twenty five to", "twenty to", "quarter to", "ten to", "five to"}; 
         String[] texts = {"zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "one"};
         
         int hours_in_int = Integer.valueOf(hours);
         int minutes_in_int = Integer.valueOf(minutes);
         
         if (minutes_in_int!=00) {
            if (!(minutes_in_int  % 5 > 0)) {
                  int indexNo=0;
                  for (int i=0; i<times.length; i++) {
                     if (times[i].equals(minutes)) {
                        indexNo = i;
                     }      
                  }        
                   if(minutes_in_int>30) {
                     System.out.println(descriptions[indexNo] + " " + texts[hours_in_int+1] );
                   } else if(minutes_in_int<=30) {
                     System.out.println(descriptions[indexNo] + " " + texts[hours_in_int]);
                   } 
   
            }else {
               if (1 <= minutes_in_int && minutes_in_int <= 2) {
                  System.out.println("about " + texts[hours_in_int] + " o'clock");
               } else if (3<= minutes_in_int && minutes_in_int <=7) {
                  System.out.println("about five past " + texts[hours_in_int]);
               } else if (8<= minutes_in_int && minutes_in_int <=12) {
                  System.out.println("about ten past " + texts[hours_in_int]);
               } else if (13<= minutes_in_int && minutes_in_int <=17) {
                  System.out.println("about quarter past " + texts[hours_in_int]);
               } else if (18<= minutes_in_int && minutes_in_int <=22) {
                  System.out.println("about twenty past " + texts[hours_in_int]);
               } else if(23<= minutes_in_int && minutes_in_int <=27) {
                  System.out.println("about twenty five past " + texts[hours_in_int]);
               } else if (28<= minutes_in_int && minutes_in_int <=32) {
                  System.out.println("about half past " + texts[hours_in_int]);
               } else if (33<= minutes_in_int && minutes_in_int <=37) {
                  System.out.println("about twenty five to " + texts[hours_in_int+1]);
               } else if (38<= minutes_in_int && minutes_in_int <=42) {
                  System.out.println("about twenty to " + texts[hours_in_int+1]);
               } else if (43<= minutes_in_int && minutes_in_int <=47) {
                  System.out.println("about quarter to " + texts[hours_in_int+1]);
               } else if (48<= minutes_in_int && minutes_in_int <=52) {
                  System.out.println("about ten to " + texts[hours_in_int+1]);
               } else if (53<= minutes_in_int && minutes_in_int <=57) {
                  System.out.println("about five to " + texts[hours_in_int+1]);
               } else if (58<= minutes_in_int && minutes_in_int <=59) {
                  System.out.println("about " + texts[hours_in_int+1] + " o'clock");
               } else if (minutes_in_int==0) {
                  System.out.println(texts[hours_in_int] + " 0'clock");
               }
            }


         } else {        
            System.out.println(texts[hours_in_int] + " o'clock");
         }
                  
         
         System.out.println("Enter a time or 'quit':");
         time = inKey.nextLine();         
 
      }
      System.out.println("Done");
   }
    
}

 
        
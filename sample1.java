import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class sample1 {
   
   public static void main (String [] args){
      Scanner inKey = new Scanner(System.in);
      System.out.println("Enter the name of the cards file: ");
      String fileName = inKey.nextLine();
      
      
      try (Scanner myFileInput = new Scanner(new File(fileName))) {
         while (myFileInput.hasNext()) {
             String line = myFileInput.nextLine();
             System.out.println("Processing: "+line);
            String[] list = line.split(" ");
            String[] square= list[0].split(",");
            String[] circle = list[1].split(",");
            String[] triangle = list[2].split(",");
            
            String squareColour=square[1];
            String circleColour=circle[1];
            String triangleColour=triangle[1];
            String squareShape=square[2];
            String circleShape=circle[2];
            String triangleShape=triangle[2];

             if ( squareColour.equals(triangleColour) &&  squareColour.equals(circleColour)) {
               System.out.println("Valid ");
             
             } else if ( !squareColour.equals(triangleColour) || !squareColour.equals(circleColour) ) {
               System.out.println("Invalid ");
             }else {
               System.out.println("Not found ");
             }
             
         }
      
      
      } catch (FileNotFoundException e) {
         System.out.println("Cannot Access File " + e.getMessage());
      }
      System.out.println("Done ");

   }


}
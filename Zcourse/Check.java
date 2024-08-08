import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Check {
   
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
            
            String squarePattern=square[2];
            String circlePattern=circle[2];
            String trianglePattern=triangle[2];
            String squareColour=square[1];
            String circleColour=circle[1];
            String triangleColour=triangle[1];
            String squareShape=square[0];
            String circleShape=circle[0];
            String triangleShape=triangle[0];

             if ( squareColour.equals(triangleColour) &&  squareColour.equals(circleColour) && squareShape.equals(triangleShape) &&  squareShape.equals(circleShape) && squarePattern.equals(trianglePattern) &&  squarePattern.equals(circlePattern)) {
               System.out.println("Valid ");
             
             } else if ( !squareColour.equals(triangleColour) &&  !squareColour.equals(circleColour) && !triangleColour.equals(circleColour) && !squareShape.equals(triangleShape) &&  !squareShape.equals(circleShape) && !triangleShape.equals(circleShape) && !squarePattern.equals(trianglePattern) && !squarePattern.equals(circlePattern) && !trianglePattern.equals(circlePattern)) {
               System.out.println("Valid ");
             }else {
               System.out.println("Invalid ");
             }
             
         }
      
      
      } catch (FileNotFoundException e) {
         System.out.println("Cannot Access File " + e.getMessage());
      }
      System.out.println("Done ");

   }


}
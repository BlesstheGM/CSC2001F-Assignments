import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimulatorOne {
    
    public static void main(String[] args) {
    
        Graph graph = new Graph();
        Scanner scanner = new Scanner(System.in);          
        int numberOfNodes = scanner.nextInt();
        scanner.nextLine();
            

        for (int i = 0; i < numberOfNodes; i++) {   
            String line = scanner.nextLine();
            String[] nodes = line.split(" ");  
            String source = nodes[0];
            
            for (int n = 1; n < nodes.length; n += 2) {
                String destination = nodes[n];
                double weight = Double.parseDouble(nodes[n + 1]);

                graph.addEdge(source, destination, weight);
            }                   
       }  
            
        int numberOfShops = scanner.nextInt();
        scanner.nextLine();
        String[] shopNumbers = new String[numberOfShops];
        for (int i = 0; i < numberOfShops; i++) {
            shopNumbers[i] = Integer.toString(scanner.nextInt()); 
        }
            
        scanner.nextLine();
        int numberOfClients = scanner.nextInt();
        String[] clientNumbers = new String[numberOfClients];
        for (int i = 0; i < numberOfClients; i++) {
            clientNumbers[i] = Integer.toString(scanner.nextInt()); 
        }
            
        for (String clientNode : clientNumbers) {
            String shop="";
            double smallestDistanceToClient = 10000;
            ArrayList<String> taxis = new ArrayList<String>();
            ArrayList<String> shops = new ArrayList<String>();
            System.out.println("client " + clientNode);       
            for (String shopNumber : shopNumbers) {
                if(graph.dijkstra(shopNumber)){
                    if (smallestDistanceToClient > graph.getDistance(clientNode)){
                        smallestDistanceToClient = graph.getDistance(clientNode);
                        taxis.clear();
                        taxis.add(shopNumber);         
                    } else if (smallestDistanceToClient == graph.getDistance(clientNode)){
                        taxis.add(shopNumber);
                    }                
                }              
            }
                      
            if(graph.dijkstra(clientNode)){
                double smallestDistanceToShop = 10000;   
                for (String shopNumber : shopNumbers) {
                    if (graph.getDistance(shopNumber) < smallestDistanceToShop) {
                        smallestDistanceToShop = graph.getDistance(shopNumber);
                        shops.clear();
                        shops.add(shopNumber);
                    } else if (graph.getDistance(shopNumber) == smallestDistanceToShop){
                        shops.add(shopNumber);
                    }             
                }
            }

            if(!taxis.isEmpty() && !shops.isEmpty()){
                for (String taxi : taxis){
                   System.out.println("taxi "+ taxi);
                   if (graph.dijkstra(taxi)){
                      if (graph.getVertex(clientNode).isPossible == true ) {
                          System.out.println("multiple solutions cost "+ (int) (graph.getDistance(clientNode)));
                      }
                      else if (graph.getVertex(clientNode).isPossible == false) {  
                          graph.printPath(clientNode);
                          System.out.println();
                      }              
                   }
                }

                if(graph.dijkstra(clientNode)){
                      for (String myshop : shops){
                            if (graph.getVertex(myshop).isPossible == true ) {
                                System.out.println("shop "+myshop);
                                System.out.println("multiple solutions cost "+ (int) (graph.getDistance(myshop)));
                            }
                            else if (graph.getVertex(myshop).isPossible == false) {
                                System.out.println("shop "+myshop);     
                                graph.printPath(myshop);
                                System.out.println();
                            }
                      } 
                }         
            } else {
               System.out.println("cannot be helped");
            }
                
        }
        
    }

}

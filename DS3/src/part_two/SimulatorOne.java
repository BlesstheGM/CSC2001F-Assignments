import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimulatorOne {

    public static void main(String[] args) {

        Graph g = new Graph();
        Scanner scanner = new Scanner(System.in);

        // Reading graph edges and weights
        int numOfNodes = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numOfNodes; i++) {
            String line = scanner.nextLine();
            String[] nodes = line.split(" ");
            String source = nodes[0];

            for (int n = 1; n < nodes.length; n += 2) {
                String dest = nodes[n];
                double weight = Double.parseDouble(nodes[n + 1]);

                g.addEdge(source, dest, weight);
            }
        }

        // Reading company details
        Map<String, ArrayList<String>> companyTaxis = new HashMap<>();
        int numCompanies = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numCompanies; i++) {
            String company = scanner.next();
            int numTaxis = scanner.nextInt();
            ArrayList<String> taxis = new ArrayList<>();

            for (int j = 0; j < numTaxis; j++) {
                taxis.add(scanner.next());
            }

            companyTaxis.put(company, taxis);
        }

        // Reading client details
        int numClients = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numClients; i++) {
            String clientNode = scanner.next();
            String clientCompany = scanner.next();
            String destShop = scanner.next();

            // Finding available taxis for the client's company
            ArrayList<String> taxis = companyTaxis.get(clientCompany);

            if (taxis != null && !taxis.isEmpty()) {
                // Simulating taxi-client interaction
                simulateTaxiClientInteraction(g, clientNode, destShop, taxis);
            } else {
                System.out.println("No taxis available for company " + clientCompany);
            }
        }

    }

    private static void simulateTaxiClientInteraction(Graph g, String clientNode, String destShop, ArrayList<String> taxis) {
        double smallestDistanceToClient = Double.MAX_VALUE;
        String nearestTaxi = null;

        // Find nearest taxi to client
        for (String taxi : taxis) {
            if (g.dijkstra(taxi)) {
                if (smallestDistanceToClient > g.getDistance(clientNode)) {
                    smallestDistanceToClient = g.getDistance(clientNode);
                    nearestTaxi = taxi;
                }
            }
        }

        if (nearestTaxi != null) {
            System.out.println("Client at node " + clientNode + " has been picked up by taxi " + nearestTaxi);
            // Simulating taxi journey to shop
            g.dijkstra(destShop);
            g.printPath(destShop);
            System.out.println();
        } else {
            System.out.println("No available taxi found for client at node " + clientNode);
        }
    }
}

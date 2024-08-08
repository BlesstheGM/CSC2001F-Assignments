import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Optimize {

    public static void main(String[] args) {
        // Read the list of names from the mydata.txt file
        List<String> nameList = readNamesFromFile("mydata.txt");
        
        // Initialize variables to store the minimum number of probes and the number of combinations achieving it
        int minProbes = Integer.MAX_VALUE;
        int numMinProbeCombinations = 0;
        
        // Iterate through all possible combinations of weights
        for (int weight1 = 0; weight1 <= 4; weight1++) {
            for (int weight2 = 0; weight2 <= 4; weight2++) {
                for (int weight3 = 0; weight3 <= 4; weight3++) {
                    for (int weight4 = 0; weight4 <= 4; weight4++) {
                        for (int weight5 = 0; weight5 <= 4; weight5++) {
                            for (int weight6 = 0; weight6 <= 4; weight6++) {
                                for (int weight7 = 0; weight7 <= 4; weight7++) {
                                    for (int weight8 = 0; weight8 <= 4; weight8++) {
                                        for (int weight9 = 0; weight9 <= 4; weight9++) {
                                            // Create a new LPHashTable with size 37 and set the weights
                                            LPHashTable hashTable = new LPHashTable(37);
                                            int[] weights = {weight1, weight2, weight3, weight4, weight5, weight6, weight7, weight8, weight9};
                                            hashTable.setWeights(weights);
                                            
                                            // Insert all names into the hash table and count the probes
                                            int probes = insertNamesAndGetProbes(nameList, hashTable);
                                            
                                            // Update the minimum number of probes and the count of combinations achieving it
                                            if (probes < minProbes) {
                                                minProbes = probes;
                                                numMinProbeCombinations = 1;
                                            } else if (probes == minProbes) {
                                                numMinProbeCombinations++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        System.out.println("Minimum number of probes required: " + minProbes);
        System.out.println("Number of weight combinations achieving this: " + numMinProbeCombinations);
    }

    private static List<String> readNamesFromFile(String fileName) {
        List<String> nameList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                nameList.add(scanner.nextLine().trim());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File '" + fileName + "' not found.");
            System.exit(1);
        }
        return nameList;
    }

    private static int insertNamesAndGetProbes(List<String> nameList, LPHashTable hashTable) {
        int probes = 0;
        for (String name : nameList) {
            // Count the probes required for each insertion
            hashTable.insert(name);
            probes += hashTable.getProbeCount();
            hashTable.resetProbeCount(); // Reset probe count for the next insertion
        }
        return probes;
    }
}

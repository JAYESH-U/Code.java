import java.util.Scanner;

public class DistanceVectorRouting {

    void calculateRoutingTable(int n, int distanceMatrix[][]) {
        int i, j, k;
        int routingTable[][] = new int[n][n]; // initiate routing table

        // initialize routing table with direct connections
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                routingTable[i][j] = j;
            }
        }

        // Calculate routing table using distance vector algorithm (floyd warshall
        // algorithm)
        for (k = 0; k < n; k++) {
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if (distanceMatrix[i][j] > distanceMatrix[i][k] + distanceMatrix[k][j]) {
                        distanceMatrix[i][j] = distanceMatrix[i][k] + distanceMatrix[k][j];
                        routingTable[i][j] = k; // Update routing table
                    }
                }
            }
        }

        // Print the calculated routing table
        System.out.println("Routing Table:");
        for (i = 0; i < n; i++) {
            System.out.println("For node " + i);
            System.out.println("To cost next hop \n ");
            for (j = 0; j < n; j++) {
                if (i != j) {
                    System.out.println(j + " " + distanceMatrix[i][j] + " " + routingTable[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DistanceVectorRouting router = new DistanceVectorRouting();

        // // Example distance matrix (replace this with your actual data)
        // int n = 3;
        // int distanceMatrix[][] = {
        // // {0, 2, 5, Integer.MAX_VALUE},
        // // {2, 0, 3, 4},
        // // {5, 3, 0, 1},
        // // {Integer.MAX_VALUE, 4, 1, 0}
        // {0, 1, 3},
        // {1, 0, 1},
        // {3, 1, 0}
        // };

        // router.calculateRoutingTable(n, distanceMatrix);

        int i, j, n;
        System.out.print("Enter the number of nodes: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int distanceMatrix[][] = new int[n][n];

        System.out.println("Enter the distance matrix: ");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                distanceMatrix[i][j] = sc.nextInt();
            }
        }

        router.calculateRoutingTable(n, distanceMatrix);
    }
}

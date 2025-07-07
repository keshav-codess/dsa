import java.util.ArrayList;

class GraphUsingAJList {
    public static void main(String[] args) {
        final int V = 5; // number of vertices
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // initialize adjacency list
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // add edges
        graph.get(0).add(2);
        graph.get(0).add(1);
        graph.get(1).add(3);
        graph.get(2).add(4);
        graph.get(2).add(1);
        graph.get(3).add(0);
        graph.get(4).add(1);

        // print the adjacency list
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + ": ");
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(graph.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}



//----------USING ADJAENCY MATRIX-------------- 

class GraphUsingAJMatrix {
    public static void main(String[] args) {
        final int V = 5; // number of vertices
        int[][] matrix = new int[V][V]; // 5x5 adjacency matrix initialized to 0

        // Add edges
        matrix[0][2] = 1;
        matrix[0][1] = 1;
        matrix[1][3] = 1;
        matrix[2][4] = 1;
        matrix[2][1] = 1;
        matrix[3][0] = 1;
        matrix[4][1] = 1;

        // Print the matrix
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

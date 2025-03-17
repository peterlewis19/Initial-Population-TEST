import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Node destination;
        Node current;

        ArrayList<Integer> neighbourIDOfANode = new ArrayList<>();
        //ArrayList<Node> finalRoute = new ArrayList<>();
        ArrayList<Route> initialPopulation = new ArrayList<>();
        Route initialRoute;


        //initialises the map of coordinate data
        Map graph = new Map(FileHandler.readNodesFromFile("map.txt"));
        destination = graph.get(graph.size()-1);
        current = graph.get(0);

        System.out.println(current +" to "+ destination);

        //adds the neighbours to each node
        for (int i=0; i< graph.size(); i++){
            Node node = graph.get(i);
            ArrayList<Node> neighboursOfThisNode = FileHandler.readNeighboursFromNode(node, "map.txt");

            for (Node neighbour: neighboursOfThisNode){
                //gets the ID for the Node in the graph which shares the coords with the neighbour Node in neighoursOfThisNode
                node.addNeighbour(graph.getIDByCoords(neighbour.getCoords()));
            }
        }

        int nextNodeID;
        Random random = new Random();
        //from currentNode, checks neighbours and makes decision based off that
        //current basis is randomness for ease

        for (int i=0; i < 10; i++) {
            ArrayList<Node> finalRoute = new ArrayList<>();
            while (!current.equals(destination)) {
                /*TODO:
                 *  - implement the routes found as a linked list
                 * */


                neighbourIDOfANode = current.getNeighbours();

               /* We have list of neighbours:
               how do we choose from these for the next step
               choices:
               - shortest distance to final destination
               - randomly choosing one of the neighbours EASIER, started on 16.3.24

               all require backtracking
               how to implement it:
               - store the previous node visited in the linked list of the route
               - go to it, check for other unvisited points, if any are available, go to those
               - repeat until there is an available neighbour and go to it.
                */

                //current has become the next Node
                nextNodeID = neighbourIDOfANode.get(random.nextInt(neighbourIDOfANode.size()));
                current = graph.getNodeByID(nextNodeID);

                finalRoute.add(current);
            }


            for (Node node: finalRoute){
                System.out.print(node+",");
            }
            System.out.println();

            initialRoute = new Route(finalRoute);
            initialRoute.display();

            //go through initial Route, clear NExt of every node
            Node n = initialRoute.getHead();

            //for (int i=1; i<values.size(); i++) {
            while (n.next != null){
                n = n.next;
                n.next = null;
            }

            initialPopulation.add(initialRoute);
        }


        NewFrame frame = new NewFrame();
        frame.drawFrame(initialPopulation);

    }

    public static Node[] generatePoints(int numberOfPoints){
        Random random = new Random();
        int randomX = 0;
        int randomY = 0;
        //int[] coords = {randomX, randomY};
        Node[] allNodes = new Node[numberOfPoints];

        for (int i = 0; i < numberOfPoints; i++) {
            randomX = random.nextInt(0, 1200);
            randomY = random.nextInt(0,700);

            //adds the coordinates to instantiate the Node
            double[] coords = {randomX, randomY};
            allNodes[i] = new Node(coords); //Node is added to allNodes
        }

        return allNodes;
    }
}
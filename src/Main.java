import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int NUM_OF_POINTS = 5;
        int CLOSEST_N = 8;

        Node destination;
        Node current;
        int k=0;

        ArrayList<Node> neighboursOfANode = new ArrayList<>();
        ArrayList<Node> finalRoute = new ArrayList<>();

        //gets map data from file
        /*TODO:
        *  -Get the initial nodes from a file and store in arrayList
        *  -Get the neighbours for each Node, add them using add neighbour.
        * */
        //Node[] graph = generatePoints(NUM_OF_POINTS);

        ArrayList<Node> graph = FileHandler.readNodesFromFile("map.txt");
        System.out.println("will read nodes from file");
        destination = graph.getLast();
        current = graph.get(0);

        //adds the neighbours to each node
        for (Node node: graph){
            ArrayList<Node> neighboursOfThisNode = FileHandler.readNeighboursFromNode(node, "map.txt"); /// gets stuck on this MAKE MORE EFFICIENT
            //System.out.println("can read neighbours from Node");

            for (Node neighbour: neighboursOfThisNode){
                node.addNeighbour(neighbour);
            }
        }

        System.out.println("neighbours are added");


        //from the currentNode, it checks against the neighbours and moves to the
        // neighbour closest to the destination, until it reaches destination or it
        // reaches an arbitrary number of points
        while (!current.equals(destination) && k < 15 ){
            //CHANGED FROM GRAPH_GENERATION, from sorting by distance to current node to
            //sorting by distance to finalNode
            neighboursOfANode = current.getNeighbours();

            System.out.println("gets past getting the neighbours");
            //sorts neighbours of a node then picks first
            // to get the neighbour closest to destination
            neighboursOfANode.sort(Comparator.comparingDouble(destination::distanceTo));
            System.out.println("gets past sorting");
            current = neighboursOfANode.get(0);

            finalRoute.add(current);

            System.out.println(k);
            k++;
        }

        for (Node node: finalRoute){
            System.out.println(node);
        }

        //using allNeighbours, draw the graph
        //NewFrame frame = new NewFrame();
        //frame.drawFrame(finalRoute);

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
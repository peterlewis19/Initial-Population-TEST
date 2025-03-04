import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int NUM_OF_POINTS = 400;
        int CLOSEST_N = 8;

        Node destination;
        Node current;
        int k=0;

        ArrayList<Node>[] neighboursOfANode = new ArrayList[NUM_OF_POINTS];

        //generates 50 random nodes
        Node[] graph = generatePoints(NUM_OF_POINTS);
        destination = graph[NUM_OF_POINTS-1];
        current = graph[0];

        //for each node recognise the 5 closest neighbours
        //Node[] fiveClosest = new Node[CLOSEST_N];

            //finds the 5 closest nodes to the current node, and randomly chooses from those to make neighbours
        //for (int k = 0; k < graph.length; k++) {
        while (!current.equals(destination) && k < NUM_OF_POINTS ){
            current = graph[k];

            //CHANGED FROM GRAPH_GENERATION, from sorting by distance to current node to
            //sorting by distance to finalNode
            Node[] sortedForCurrentGraph = graph.clone();

            //Arrays.sort(sortedForCurrentGraph, Comparator.comparingDouble(destination::distanceTo));

            neighboursOfANode = current.getNeighbours();

                //arraylist containing Node, neighbour1, neighbour2... etc to add to allNeigbours at the end
            ArrayList<Node> nodeAndNeighbours = new ArrayList<>();
            nodeAndNeighbours.add(current);


            for (Node neighbour: current.getNeighbours()){
                System.out.println(neighbour);

                nodeAndNeighbours.add(neighbour);
            }

            allNeighbours[k] = nodeAndNeighbours;
                //System.out.println();

            k++;
        }

            //frane.drawFrame(allNeighbours);




        //using allNeighbours, draw the graph
        NewFrame frame = new NewFrame();
        frame.drawFrame(allNeighbours);

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
            int[] coords = {randomX, randomY};
            allNodes[i] = new Node(coords); //Node is added to allNodes
        }

        return allNodes;
    }
}
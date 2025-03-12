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

        ArrayList<Integer> neighbourIndexOfANode = new ArrayList<>();
        ArrayList<Node> finalRoute = new ArrayList<>();

        //gets map data from file
        /*TODO:
        *  -Get the initial nodes from a file and store in arrayList
        *  -Get the neighbours for each Node, add them using add neighbour.
        * */
        //Node[] graph = generatePoints(NUM_OF_POINTS);

        ArrayList<Node> graph = FileHandler.readNodesFromFile("map.txt");
        //TODO:
        // -implement get Node by ID, for graph
        //System.out.println("will read nodes from file");
        destination = graph.getLast();
        current = graph.get(0);

        //adds the neighbours to each node
        for (Node node: graph){
            ArrayList<Node> neighboursOfThisNode = FileHandler.readNeighboursFromNode(node, "map.txt");


            for (Node neighbour: neighboursOfThisNode){
                node.addNeighbour(neighbour);
                //System.out.println(node +"->"+neighbour);
            }
        }
        /*
        Node nodeToFind = graph.get(3);

        ArrayList<Node> neighboursOfThisNode = FileHandler.readNeighboursFromNode(nodeToFind, "map.txt");
        for (Node neighbour: neighboursOfThisNode){
            nodeToFind.addNeighbour(neighbour);
            System.out.println(neighbour);
        }*/

        System.out.println("neighbours are added");


        //from the currentNode, it checks against the neighbours and moves to the
        // neighbour closest to the destination, until it reaches destination or it
        // reaches an arbitrary number of points
        // this is a stinky algorithm. TODO: FIX IT!
        while (!current.equals(destination) && k < 15 ){
            System.out.println("CURRENT:"+current);
            //CHANGED FROM GRAPH_GENERATION, from sorting by distance to current node to
            //sorting by distance to finalNode
            neighbourIndexOfANode = current.getNeighbours();
            ArrayList<Node> neighboursOfANode = new ArrayList<>();

            for (int index: neighbourIndexOfANode){
                neighboursOfANode.add(graph.getByID(index));
            }

            ///REASON FOR NOT WORKING
            /// THEY ARE NOT THE SAME NODE IN MEMORY, ONLY A NODE WITH SAME COORDINATES
            /// USE INDEX OF GRAPH, assuming initial graph is unchanging

            for (Node neighbour: neighboursOfANode){
                System.out.println(neighbour);
            }

            //System.out.println("gets past getting the neighbours");
            //sorts neighbours of a node then picks first
            // to get the neighbour closest to destination
            neighboursOfANode.sort(Comparator.comparingDouble(destination::distanceTo));
            System.out.println("sorted:");

            for (Node neighbour: neighboursOfANode){
                System.out.println(neighbour);
            }

            System.out.println(neighboursOfANode.size());
            current = neighboursOfANode.get(0);
            finalRoute.add(current);

            //System.out.println(k);
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
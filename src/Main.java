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
        Map graph = new Map(FileHandler.readNodesFromFile("realMap.txt"));
        destination = graph.get(graph.size()-1);
        current = graph.get(0);

        System.out.println(current +" to "+ destination);

        //adds the neighbours to each node
        for (int i=0; i< graph.size(); i++){
            Node node = graph.get(i);
            ArrayList<Node> neighboursOfThisNode = FileHandler.readNeighboursFromNode(node, "realMap.txt");
            System.out.println(node + ": ");

            for (Node neighbour: neighboursOfThisNode){
                //gets the ID for the Node in the graph which shares the coords with the neighbour Node in neighoursOfThisNode
                node.addNeighbour(graph.getIDByCoords(neighbour.getCoords()));

                System.out.print(Arrays.toString(neighbour.getCoords()));
            }
            System.out.println();
        }



        int nextNodeID;
        Random random = new Random();
        //from currentNode, checks neighbours and makes decision based off that
        //current basis is randomness for ease

        ArrayList<Node> finalRoute = new ArrayList<>();
        NewFrame frame = new NewFrame();

        //creates 4 routes for the initial pop, testing phase
        for (int i=0; i < 10; i++) {
            finalRoute = new ArrayList<>();
            //resets the route being stored every time, starting from the start
            current = graph.get(0);
            finalRoute.add(current);
            //System.out.println("CURRENT: "+ current);

            while (!current.equals(destination)) {
                /*TODO:
                 *  - implement the routes found as a linked list DONE
                 *  - clear the finalRoute after the initial one.
                 * */

                neighbourIDOfANode = current.getNeighbours();

                for (int ID: neighbourIDOfANode){
                    System.out.print(ID+",");
                }

                ///FOR SOME REASON< IT IS CREATING IDS OF -1

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
                //chooses a random neighbour ID, then moves to it
                //System.out.println("SIZE: "+neighbourIDOfANode.size());
                nextNodeID = neighbourIDOfANode.get(random.nextInt(0,neighbourIDOfANode.size()));
                //the ID found for the chosen neighbour isn't currently found in the graph
                current = graph.getNodeByID(nextNodeID);


                //adds this stop to the route
                finalRoute.add(current);
            }


            for (Node node: finalRoute){
                System.out.print(node+",");
            }

            System.out.println();

            //REMOVE LINKED LISTS FOR NOW, AS EVERY LINKED LIST HAS THE SAME HEAD !!!!
            //Stores the route as a linked list
            //initialRoute = new Route(finalRoute);
            //initialRoute.display();

            //initialRoute.display() is not showing the same thing as lines 81 - 84, displaying the nodes from finalRoute

            //go through initial Route, clear NExt of every node
            //Node n = initialRoute.getHead();

            //clears the next value of each Node, for the next one.
            /*while (n.next != null){
                n = n.next;
                n.next = null;
            }*/

            //initialPopulation.add(initialRoute);

            //draws finalRoute not initialRoute bc linkedlists arent working currently
            frame.drawFrame(finalRoute);
        }

        //frame.drawFrame(initialPopulation.get(0));

        //at this moment, try drawing new frame for each route
        //frame.drawFrame(initialPopulation.get(1));
        /*for (int i=0; i< 4; i++) {
            frame.drawFrame(initialPopulation.get(i));
        }*/

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
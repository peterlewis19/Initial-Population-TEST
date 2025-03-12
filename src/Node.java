import java.util.ArrayList;

public class Node {
    private double[] coords;
    private ArrayList<Integer> neighbours;
    private static int iDcounter;
    private int thisID;
    Node next;


    public Node(double[] coords){
        thisID = iDcounter;
        this.coords = coords;
        this.neighbours = new ArrayList<>();

        iDcounter++;
    }

    public int getID(){
        return thisID;
    }

    public Node getNext(){
        return next;
    }

    public void addNeighbour(Node neighbour){
        int currentID = neighbour.getID();

        neighbours.add(currentID);
    }

    public ArrayList<Integer> getNeighbours(){
        return neighbours;
    }

    /*public boolean isNeighbour(Node neighbour){
        boolean isNeighbour = false;
        ArrayList<Node> neighboursOfNeighbour = neighbour.getNeighbours();

        //checks if the current node is a neighbour of neighbour
        for (Node neighbourino: neighboursOfNeighbour){
            if (neighbourino.getCoords().equals(getCoords())){
                isNeighbour = true;
            }
        }

        return isNeighbour;
    }*/

    public double[] getCoords(){
        return coords;
    }

    public String toString(){
        double[] coords = getCoords();
        double x = coords[0];
        double y = coords[1];

        String strx = Double.toString(x);
        String stry = Double.toString(y);

        return strx + "," + stry;
    }

    //returns the distance to another node
    public double distanceTo(Node matilda){
        double distance;

        double changeInX = Math.abs(coords[0] - matilda.getCoords()[0]);
        double changeInY = Math.abs(coords[1] - matilda.getCoords()[1]);

        //use pythagorean theorem to work out the distance diagonally
        distance = Math.sqrt(Math.pow(changeInX,2) + Math.pow(changeInY,2));

        return distance;
    }


}

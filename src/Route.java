import java.util.ArrayList;

public class Route {
    private Node head;
    private Node next;

    public Route(ArrayList<Node> values) {
        //Node n = new Node(values.get(0));
        Node n = values.get(0);
        head = n;

        for (int i=1; i<values.size(); i++) {
            n.next = values.get(i);
            n = n.next;
        }
    }
    public Node getHead() {
        return head;
    }

    public Node getNext(){
        Node current = next;
        next = current.getNext();

        return current;
    }

    public boolean isEmpty(){
        Node n = getHead();
        int count = 0;

        while (n.next != null){
            n = n.next;
            count++;
        }

        if (count > 0){
            return false;
        } else{
            return true;
        }
    }

    public void display(){
        Node n = getHead();

        while (n.next != null){
            System.out.print(n+" -> ");
            n = n.next;
        }

        System.out.println("null");
    }

    //goes to end of linkedlist, modifies nextNode to the one given
    public void addItem(Node nodeToAdd){
        //Node nodeToAdd = new Node(coords);

        Node head = getHead();
        Node n = head;

        while (n.next != null){
            n = n.next;
        }

        n.next = nodeToAdd;
    }

    public void resetNext(){

    }

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Map {
    ArrayList<Node> map;

    public Map(ArrayList<Node> map){
        this.map = map;
    }

    public Node getNodeByID(int ID){
        //if node isn't present, it returns -1, causing errors

        return map.get(lookFor(ID, map.size(), 0));
    }

    public int getIDByCoords(double[] coords){
        int finalID = -1;
        int count =0;
        boolean found = false;

        //ends loop once found or reaches end.
        while (count < map.size() && !found)  {
            if (Arrays.equals(map.get(count).getCoords(), coords)){
                finalID = map.get(count).getID();
                found = true;
            }

            count++;
        }

        return finalID;
    }

    public Node get(int n){
        return map.get(n);
    }

    public int size(){
        return map.size();
    }

    public int lookFor(int target, int max, int min){
        int midpoint = (int)((max+min)/2);

        //target has been found
        if (map.get(midpoint).getID() == target){
            System.out.println(target+ " is in the list at index "+midpoint);
            return midpoint;
        }

        //then the target is not present
        if (max==min+1){
            System.out.println(target+" is not in the array");
            return -1;
        }

        //splits the list in 2
        if (target > map.get(midpoint).getID()){
            min = midpoint;
        } else {
            max = midpoint;
        }

        //System.out.println(data[min] + ", "+ data[max]);
        lookFor(target, max, min);

        return -1;
    }


}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Map {
    ArrayList<Node> map;

    public Map(ArrayList<Node> map){
        this.map = map;
    }

    //TS NEEDS FIXING!! no longer use recursion
    public Node getNodeByID(int ID){
        //if node isn't present, it returns -1, causing errors
        int index = binarySearch(0, map.size(), ID);
        //System.out.println(index);

        return map.get(index);
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

    public int lookFor(int target, int max, int min, int finalIndex){
        int midpoint = (int)((max+min)/2);

        System.out.println("MAX: "+ map.get(max-1) +"("+(max-1)+")");
        System.out.println("MIN: "+ map.get(min) +"("+min+")");

        //target has been found
        if (map.get(midpoint).getID() == target){
            System.out.println(target+ " is in the list at index "+midpoint);
            finalIndex = midpoint;
            return finalIndex;
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
        lookFor(target, max, min, finalIndex);

        return finalIndex;
    }

    int binarySearch(int min, int max, int target)
    {
        while (min <= max) {
            int midpoint = (min + max) / 2;

            if (map.get(midpoint).getID() == target) {
                return midpoint;

              //halves the list into top or bottom half
            } else if (map.get(midpoint).getID() > target) {
                max = midpoint - 1;

            } else {
                min = midpoint + 1;
            }
        }

        // not there
        return -1;
    }


}

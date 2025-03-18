import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyCanvas extends JComponent {

    private ArrayList<Node> routeToDraw;
    private final int SCALING_MULTIPLIER= 200;

    public MyCanvas(ArrayList<Node> routeToDraw){
        this.routeToDraw = routeToDraw;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set rendering hints for smooth lines
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set line color and thickness
        g2d.setColor(Color.BLUE);
        g2d.setStroke(new BasicStroke(2)); // Line thickness = 2

    }

    public void paint(Graphics g) {
        setForeground(Color.BLUE);
        setBackground(Color.WHITE);
        int crossStartX=0;
        int crossEndX=0;
        int crossStartY =0;
        int crossEndY=0;

        //for (Route routeToDraw: allRoutesToDraw) {

        //VERY INEFFICIENT, GO TO THIS MAYBE 30 TIMES RATHER THAN 4

            //for (int i = 0; i < routeToDraw.size() - 1; i++) {
            //Node n = routeToDraw.getHead();

            //while (n.next != null){
            for (int i=0; i < routeToDraw.size()-1; i++){
                //System.out.print("THIS PASS:");
                //go to nodeAndNeighbour.get(0)
                //SEEMS TO BE SKIPPING COORDINATES
                int startX = (int) ((routeToDraw.get(i).getCoords()[0] - 51.45) * SCALING_MULTIPLIER) ;
                int startY = (int) (routeToDraw.get(i).getCoords()[1] - 0.1) * SCALING_MULTIPLIER;

                int endX = (int) ((routeToDraw.get(i+1).getCoords()[0] - 51.45) * SCALING_MULTIPLIER) ;
                int endY = (int) (routeToDraw.get(i+1).getCoords()[1] - 0.1) * SCALING_MULTIPLIER;

                g.drawLine(startX, startY, endX, endY);

                //n=n.next;
            }


            crossStartX = (int)((routeToDraw.get(0).getCoords()[0]  - 51.45)*SCALING_MULTIPLIER);
            crossStartY = (int)(routeToDraw.get(0).getCoords()[1] - 0.1)*SCALING_MULTIPLIER;

            crossEndX = (int)((routeToDraw.getLast().getCoords()[0] - 51.45)*SCALING_MULTIPLIER) ;
            crossEndY = (int)(routeToDraw.getLast().getCoords()[1] - 0.1)*SCALING_MULTIPLIER;
       // }


        //marks the start and end with crosses
        //int startX = (int)(allRoutesToDraw.getFirst().getHead().getCoords()[0]*15) + 100;
        //int startY = (int)allRoutesToDraw.getFirst().getHead().getCoords()[1]*15;

        //int endX = (int)(routeToDraw.getLast().getCoords()[0]*15) + 100;
        //int endY = (int)routeToDraw.getLast().getCoords()[1]*15;


        //highlight start and end with a cross
        g.drawLine(crossStartX - 5, crossStartY - 5, crossStartX + 5, crossStartY + 5);
        g.drawLine(crossStartX - 5, crossStartY + 5, crossStartX + 5, crossStartY - 5);

        g.drawLine(crossEndX - 5, crossEndY - 5, crossEndX + 5, crossEndY + 5);
        g.drawLine(crossEndX - 5, crossEndY + 5, crossEndX + 5, crossEndY - 5);
    }

}

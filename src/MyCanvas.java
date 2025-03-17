import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyCanvas extends JComponent {

    private ArrayList<Route> allRoutesToDraw;

    public MyCanvas(ArrayList<Route> routeToDraw){
        this.allRoutesToDraw = routeToDraw;
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

        for (Route routeToDraw: allRoutesToDraw) {

            //for (int i = 0; i < routeToDraw.size() - 1; i++) {
            Node n = routeToDraw.getHead();
            System.out.println("THIS ROUTE:");

            while (n.next != null){
                System.out.print("THIS PASS:");
                //go to nodeAndNeighbour.get(0)
                int startX = (int) (n.getCoords()[0] * 15) + 100;
                int startY = (int) n.getCoords()[1] * 15;

                int endX = (int) (n.next.getCoords()[0] * 15) + 100;
                int endY = (int) n.next.getCoords()[1] * 15;

                System.out.print("START:"+startX + ", "+ startY);
                System.out.print("END:"+endX + ", "+ endY);

                g.drawLine(startX, startY, endX, endY);

                n=n.next;

                System.out.println();
            }


            crossStartX = (int)(allRoutesToDraw.getFirst().getHead().getCoords()[0]*15) + 100;
            crossStartY = (int)allRoutesToDraw.getFirst().getHead().getCoords()[1]*15;

            crossEndX = (int)(n.getCoords()[0]*15) + 100;
            crossEndY = (int)n.getCoords()[1]*15;
        }


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

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static java.awt.SystemColor.window;

// Driver Class
public class NewFrame {
    // Main Function
    public void drawFrame(ArrayList<Node> routeToDraw) {
        // Creating instance of JFrame
        JFrame frame = new JFrame("Random nodes and neighbours");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyCanvas canvas = new MyCanvas(routeToDraw);

        //do a canvas of only the first pass, the firrst + second, first+second+third, etc...
        //LinePanel linePanel = new LinePanel();
        frame.add(canvas);

        // 400 width and 500 height
        frame.setSize(1200, 700);

        // making the frame visible
        frame.setVisible(true);
    }
}

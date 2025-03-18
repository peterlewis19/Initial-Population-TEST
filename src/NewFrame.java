import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static java.awt.SystemColor.window;

// Driver Class
public class NewFrame {
    // Main Function
    public void drawFrame(ArrayList<Node> currentRoute) {
        // Creating instance of JFrame
        JFrame frame = new JFrame("Hardcoded local map");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyCanvas canvas = new MyCanvas(currentRoute);

        //do a canvas of only the first pass, the first + second, first+second+third, etc...
        //LinePanel linePanel = new LinePanel();
        frame.add(canvas);

        // 400 width and 500 height
        frame.setSize(500, 500);

        // making the frame visible
        frame.setVisible(true);
    }
}

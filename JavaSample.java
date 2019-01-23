import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.nio.file.*;

public class JavaSample {
    public static void main(String[] args) {
        startAWT();

        SwingUtilities.invokeLater(JavaSample::startSwing);
    }

    private static void startAWT() {
        Frame frame = new Frame("Hello, AWT!");

        frame.setSize(300, 300);
        frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(java.awt.event.WindowEvent event) {
                    System.exit(0);
                }
            });

        final java.awt.Button button = new java.awt.Button("Hello, AWT!");

        button.addActionListener(event -> {
                button.setLabel("Button clicked!");
            });

        frame.add(button);

        frame.setVisible(true);
    }

    private static void startSwing() {
        JFrame frame = new JFrame("Hello, Swing!");

        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        final JButton button = new JButton("Hello, Swing!");

        button.addActionListener(event -> {
                button.setText("Button clicked!");
            });
        
        frame.getContentPane().add(button);
 
        frame.setVisible(true);
    }
}

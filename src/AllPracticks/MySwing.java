package AllPracticks;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class MySwing {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = getFrame();

        jFrame.add(new Mycomponent());

    }

    static class Mycomponent extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
            Font font = new Font("Bistream Charter", Font.BOLD, 20);
            Graphics2D g2 = (Graphics2D) g;
            g2.setFont(font);
            g2.drawString("Kriiiiiiisssstiiin", 20, 20);
        }
    }
        static JFrame getFrame() {
            JFrame jFrame = new JFrame();
            jFrame.setVisible(true);
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setSize(500, 300);
            jFrame.setLocation(500, 500);

            jFrame.setTitle("Kristin norm patsan");
            return jFrame;
        }
}
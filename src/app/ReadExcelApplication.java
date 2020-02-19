package app;
import panel.BodyPanel;
import panel.HeaderPanel;

import javax.swing.*;
import java.awt.*;

public class ReadExcelApplication extends JFrame {

    private JFrame mainFrame;
    private JPanel mainPanel;


    private void prepareGUI() {
        mainFrame = new JFrame("File Upload");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
       // mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        mainPanel.setLayout(new GridLayout(2, 3));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //mainPanel.setBounds(0, 0, 491, 355);

        // Add Panels
        mainPanel.add(new HeaderPanel());
        mainPanel.add(Box.createVerticalStrut(10));

        mainPanel.add(new BodyPanel());
        mainPanel.add(Box.createVerticalStrut(20));


        mainFrame.getContentPane().add(mainPanel);
        //controlPanel.setLayout(null);




        mainFrame.pack();
        mainFrame.setVisible(true);
    }



    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ReadExcelApplication excel = new ReadExcelApplication();
                excel.prepareGUI();

            }
        });
    }
}


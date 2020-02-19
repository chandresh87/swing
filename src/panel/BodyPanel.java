package panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class BodyPanel extends JPanel {

    private String filename;
    private String fname;
    private JButton startButton;
    private JTextField textField;
    private JLabel lblFilename;
    private JButton btnNewButton;
    private JButton btnCancel;

    public BodyPanel()
    {
        this.setLayout(new GridLayout(2, 3));
        createUIComponents();
    }
    
    private void createUIComponents() {
        // label
        lblFilename = new JLabel("FileName");
        lblFilename.setVisible(true);
       // lblFilename.setBounds(0, 0, 10, 31);
        lblFilename.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        this.add(lblFilename);

        // file location feild
        textField = new JTextField();
        //textField.setBounds(0, 0, 200, 31);
        this.add(textField);
        textField.setColumns(10);

        // Browse Button
        btnNewButton = new JButton("Browse");
       // btnNewButton.setBounds(258, 26, 105, 31);
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                JFileChooser filedilg = new JFileChooser();
                filedilg.showOpenDialog(filedilg);
                filename = filedilg.getSelectedFile().getAbsolutePath();
                textField.setText(filename);

                File file1 = new File(filename);
                fname = file1.getName();
                System.out.println("THE FILE NAME IS " + fname);
            }
        });
        this.add(btnNewButton);

        // Send button
        startButton = new JButton("Send");
        //startButton.setBounds(75, 82, 90, 31);
        startButton.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                //JOptionPane.showMessageDialog(rootPane, "File uploded for processing...!!!");
                System.out.println("file reading from POI" + filename);

            }
        });

        this.add(startButton);

        // Close button
        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(182, 82, 90, 31);
        btnCancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        this.add(btnCancel);
    }
}

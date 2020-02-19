package panel;

import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel{

    public HeaderPanel()
    {
        this.setLayout(new GridLayout(3, 3));
        createUIComponents();
    }

    private void createUIComponents() {
        JLabel header =new JLabel();
        header.setText("Excel processing Application");
        add(header);
    }
}

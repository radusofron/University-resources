import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainMiddlePanel extends JPanel {
    final MainFrame frame;
    JLabel leftTextBox = new JLabel("<html>* If you click on VERSION 1, you have to enter just the rooms as input. <br><br>* A schedule will be created according to those rooms and their capacities.</html>");
    JLabel rightTextBox = new JLabel("<html>* If you click on VERSION 2, you have to enter all the data as input. <br><br>* A schedule will be created after you insert the groups, the teachers, the rooms and so on...</html>");
    public MainMiddlePanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1,2));
        leftTextBox.setBorder(createRightBorder());
        add(leftTextBox);
        rightTextBox.setBorder(createLeftBorder());
        add(rightTextBox);
    }

    private Border createRightBorder() {
        Border border;
        border = BorderFactory.createMatteBorder( 0,0,0,1, Color.BLACK);
        return border;
    }

    private Border createLeftBorder() {
        Border border;
        border = BorderFactory.createMatteBorder( 0,1,0,0, Color.BLACK);
        return border;
    }
}
